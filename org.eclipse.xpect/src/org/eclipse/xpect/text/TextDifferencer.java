package org.eclipse.xpect.text;

import java.util.List;

import org.eclipse.xpect.util.DifferencerImpl;
import org.eclipse.xpect.util.IDifferencer.Match;
import org.eclipse.xpect.util.IDifferencer.MatchKind;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class TextDifferencer implements ITextDifferencer {

	protected static class LineDiff implements ILineDiff {
		private final MatchKind kind;
		private final List<ISegmentDiff> segmentDiffs;

		public LineDiff(List<? extends ISegmentDiff> segmentDiffs) {
			super();
			this.segmentDiffs = ImmutableList.<ISegmentDiff> copyOf(segmentDiffs);
			this.kind = computeKind(this.segmentDiffs);
		}

		protected MatchKind computeKind(List<ISegmentDiff> lineMatches) {
			boolean hasLeft = false, hasRight = false;
			for (ISegmentDiff match : lineMatches) {
				switch (match.getKind()) {
				case SIMILAR:
					return MatchKind.SIMILAR;
				case EQUAL:
					if (hasLeft != hasRight)
						return MatchKind.SIMILAR;
					hasLeft = true;
					hasRight = true;
					break;
				case LEFT_ONLY:
					hasLeft = true;
					if (hasRight)
						return MatchKind.SIMILAR;
					break;
				case RIGHT_ONLY:
					hasRight = true;
					if (hasLeft)
						return MatchKind.SIMILAR;
					break;
				}
			}
			if (hasLeft && hasRight)
				return MatchKind.EQUAL;
			if (hasLeft)
				return MatchKind.LEFT_ONLY;
			if (hasRight)
				return MatchKind.RIGHT_ONLY;
			return MatchKind.EQUAL;
		}

		public MatchKind getKind() {
			return kind;
		}

		public List<ISegmentDiff> getSegmentDiffs() {
			return segmentDiffs;
		}

		@Override
		public String toString() {
			return new TextDiffToString().toPrefixedLine(this);
		}
	}

	protected static class Segment implements ISegment {

		private final boolean hidden;
		private Segment next = null;
		private Segment previous = null;
		private final String string;
		private final int tokenIndex;

		public Segment(int tokenIndex, String string, boolean hidden) {
			super();
			Preconditions.checkArgument(string.length() > 0);
			this.tokenIndex = tokenIndex;
			this.string = string;
			this.hidden = hidden;
		}

		public int getTokenIndex() {
			return tokenIndex;
		}

		public boolean isHidden() {
			return hidden;
		}

		public boolean needsWrap() {
			if (previous != null)
				return previous.needsWrapHidden();
			return false;
		}

		protected boolean needsWrapHidden() {
			if (!hidden)
				return false;
			if (isWrap())
				return true;
			if (previous != null)
				return previous.needsWrapHidden();
			return false;
		}

		@Override
		public String toString() {
			return string;
		}

		public ISegment getNext() {
			return next;
		}

		public ISegment getPrevious() {
			return previous;
		}

		public boolean isWrap() {
			return string.endsWith("\n");
		}
	}

	protected static class SegmentDiff implements ISegmentDiff {

		private final MatchKind kind;

		private final Segment left;
		private final Segment right;

		private final float similarity;

		public SegmentDiff(MatchKind kind, Segment left, Segment right, float similarity) {
			super();
			this.left = left;
			this.right = right;
			this.kind = kind;
			this.similarity = similarity;
		}

		public MatchKind getKind() {
			return kind;
		}

		public Segment getLeft() {
			return left;
		}

		public Segment getRight() {
			return right;
		}

		public float getSimilarity() {
			return similarity;
		}

		@Override
		public String toString() {
			switch (kind) {
			case EQUAL:
				return left.toString();
			case LEFT_ONLY:
				return "[" + left.toString() + "|]";
			case RIGHT_ONLY:
				return "[|" + right.toString() + "]";
			case SIMILAR:
				return "[" + left.toString() + "|" + right.toString() + "]";
			}
			return super.toString();
		}

	}

	protected static class TextDiff implements ITextDiff {

		private final List<ILineDiff> lines;

		public TextDiff(List<? extends ILineDiff> lines) {
			super();
			this.lines = ImmutableList.copyOf(lines);
		}

		public List<ILineDiff> getLines() {
			return lines;
		}

		@Override
		public String toString() {
			return new TextDiffToString().apply(this);
		}

	}

	protected DifferencerImpl createDifferencer() {
		return new DifferencerImpl();
	}

	protected <T> List<Segment> createSegments(List<T> tokens, ITextDiffConfig<T> config) {
		List<Segment> segments = Lists.newArrayList();
		for (int tokenIndex = 0; tokenIndex < tokens.size(); tokenIndex++) {
			T token = tokens.get(tokenIndex);
			for (String string : config.toSegments(token)) {
				boolean hidden = config.isHidden(token, string);
				int index, lastIndex = 0;
				while ((index = string.indexOf('\n', lastIndex)) >= 0) {
					int end = index > 0 && string.charAt(index - 1) == '\r' ? index - 1 : index;
					if (lastIndex < end)
						segments.add(new Segment(tokenIndex, string.substring(lastIndex, end), hidden));
					segments.add(new Segment(tokenIndex, string.substring(end, index + 1), true));
					lastIndex = index + 1;
				}
				int end = string.length();
				if (lastIndex < end)
					segments.add(new Segment(tokenIndex, string.substring(lastIndex, end), hidden));
			}
		}
		if (!segments.isEmpty()) {
			Segment previous = segments.get(0);
			for (int i = 1; i < segments.size(); i++) {
				Segment seg = segments.get(i);
				seg.previous = previous;
				previous.next = seg;
				previous = seg;
			}
		}
		List<Segment> result = Lists.newArrayList();
		for (Segment s : segments)
			if (!s.isHidden())
				result.add(s);
		return result;
	}

	public <T> ITextDiff diff(List<T> leftTokens, List<T> rightTokens, ITextDiffConfig<T> config) {
		List<Segment> leftSegments = createSegments(leftTokens, config);
		List<Segment> rightSegments = createSegments(rightTokens, config);
		List<Match> diff = createDifferencer().diff(leftSegments, rightSegments, config);
		List<SegmentDiff> currentLine = Lists.newArrayList();
		List<LineDiff> result = Lists.newArrayList();
		for (Match match : diff) {
			Segment left = match.getLeft() != Match.NO_INDEX ? leftSegments.get(match.getLeft()) : null;
			Segment right = match.getRight() != Match.NO_INDEX ? rightSegments.get(match.getRight()) : null;
			if ((left != null && left.needsWrap()) || (right != null && right.needsWrap())) {
				result.add(new LineDiff(currentLine));
				currentLine.clear();
				// System.out.println("<flush>");
			}
			// System.out.println(left + "<>" + right);
			currentLine.add(new SegmentDiff(match.getKind(), left, right, match.getSimilarity()));
		}
		if (!currentLine.isEmpty()) {
			result.add(new LineDiff(currentLine));
			currentLine.clear();
		}
		TextDiff textDiff = new TextDiff(result);
		return textDiff;
	}

}
