package org.xpect.text;

import java.util.Arrays;
import java.util.List;

import org.xpect.text.ITextDifferencer.ILineDiff;
import org.xpect.text.ITextDifferencer.ISegment;
import org.xpect.text.ITextDifferencer.ISegmentDiff;
import org.xpect.text.ITextDifferencer.ITextDiff;
import org.xpect.util.IDifferencer.MatchKind;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public class TextDiffToString implements Function<ITextDiff, String> {
	protected static class Chunk {
		private final boolean equal;
		private final String text;

		public Chunk(String text, boolean equal) {
			super();
			this.text = text;
			this.equal = equal;
		}

		public String getText() {
			return text;
		}

		public boolean isEqual() {
			return equal;
		}

		@Override
		public String toString() {
			return text;
		}
	}

	private boolean allowSingleLineDiff = true;
	private boolean allowSingleSegmentDiff = true;
	private int linesAfterDiff = 4;
	private int linesBeforeDiff = 4;

	public String apply(ITextDiff input) {
		return apply(input.getLines());
	}

	public String apply(List<ILineDiff> lines) {
		if (allowSingleLineDiff || allowSingleSegmentDiff) {
			ILineDiff line = findSingleChangedLine(lines);
			if (line != null) {
				List<Chunk> chunks = toChunks(line);
				if (allowSingleSegmentDiff) {
					Chunk chunk = findSingleChangedChunk(chunks);
					if (chunk != null)
						return chunk.getText();
				}
				return Joiner.on("").join(chunks);
			}
		}
		return toMultiLineDiff(lines);
	}

	protected ILineDiff findSingleChangedLine(List<ILineDiff> lines) {
		ILineDiff changed = null;
		for (ILineDiff line : lines) {
			switch (line.getKind()) {
			case SIMILAR: {
				if (changed == null)
					changed = line;
				else
					return null;
				break;
			}
			case LEFT_ONLY:
			case RIGHT_ONLY:
				return null;
			default: {
			}
			}
		}
		return changed;
	}

	protected Chunk findSingleChangedChunk(List<Chunk> chunks) {
		Chunk changed = null;
		for (Chunk chunk : chunks) {
			if (!chunk.isEqual()) {
				if (changed == null)
					changed = chunk;
				else
					return null;
			}
		}
		return changed;
	}

	protected String getHiddenBetween(ISegment seg1, ISegment seg2) {
		StringBuilder result1 = new StringBuilder();
		ISegment next = seg1.getNext();
		while (next != null && next.isHidden() && !next.isWrap()) {
			result1.append(next);
			next = next.getNext();
		}
		if (next == seg2)
			return result1.toString();
		StringBuilder result2 = new StringBuilder();
		ISegment prev = seg2.getPrevious();
		while (prev != null && prev.isHidden() && !prev.isWrap()) {
			result2.insert(0, prev);
			prev = prev.getPrevious();
		}
		if (result1.length() > 0 && result2.length() > 0) {
			if (result1.length() < result2.length())
				return result1.toString();
			return result2.toString();
		} else if (result1.length() > 0) {
			return result1.toString();
		}
		return result2.toString();
	}

	protected List<ISegment> getLeftSegments(ILineDiff line) {
		List<ISegment> result = Lists.newArrayList();
		for (ISegmentDiff match : line.getSegmentDiffs()) {
			ISegment left = match.getLeft();
			if (left != null)
				result.add(left);
		}
		return result;
	}

	public int getLinesAfterDiff() {
		return linesAfterDiff;
	}

	public int getLinesBeforeDiff() {
		return linesBeforeDiff;
	}

	protected List<ISegment> getRightSegments(ILineDiff line) {
		List<ISegment> result = Lists.newArrayList();
		for (ISegmentDiff match : line.getSegmentDiffs()) {
			ISegment right = match.getRight();
			if (right != null)
				result.add(right);
		}
		return result;
	}

	public boolean isAllowSingleLineDiff() {
		return allowSingleLineDiff;
	}

	public boolean isAllowSingleSegmentDiff() {
		return allowSingleSegmentDiff;
	}

	public TextDiffToString setAllowSingleLineDiff(boolean allowSingleLineDiff) {
		this.allowSingleLineDiff = allowSingleLineDiff;
		return this;
	}

	public TextDiffToString setAllowSingleSegmentDiff(boolean allowSingleTokenDiff) {
		this.allowSingleSegmentDiff = allowSingleTokenDiff;
		return this;
	}

	public TextDiffToString setLinesAfterDiff(int linesAfterDiff) {
		this.linesAfterDiff = linesAfterDiff;
		return this;
	}

	public TextDiffToString setLinesBeforeDiff(int linesBeforeDiff) {
		this.linesBeforeDiff = linesBeforeDiff;
		return this;
	}

	private List<Chunk> toChunks(ILineDiff line) {
		List<ISegmentDiff> segmentDiffs = line.getSegmentDiffs();
		List<Chunk> result = Lists.newArrayList();
		List<ISegment> left = Lists.newArrayList();
		List<ISegment> right = Lists.newArrayList();
		List<ISegment> equal = Lists.newArrayList();
		for (int i = 0; i < segmentDiffs.size(); i++) {
			ISegmentDiff match = segmentDiffs.get(i);
			switch (match.getKind()) {
			case EQUAL:
				equal.add(match.getLeft());
				break;
			case LEFT_ONLY:
				left.add(match.getLeft());
				break;
			case RIGHT_ONLY:
				right.add(match.getRight());
				break;
			case SIMILAR:
				right.add(match.getRight());
				left.add(match.getLeft());
				break;
			}
			if (match.getKind() == MatchKind.EQUAL) {
				if (left.size() > 0 || right.size() > 0) {
					result.add(new Chunk("[" + toString(left, false, false) + "|" + toString(right, false, false) + "]", false));
					left.clear();
					right.clear();
				}
			}
			if (match.getKind() != MatchKind.EQUAL) {
				if (equal.size() > 0) {
					result.add(new Chunk(toString(equal, true, true), true));
					equal.clear();
				}
			}
			if (i == segmentDiffs.size() - 1) {
				if (left.size() > 0 || right.size() > 0)
					result.add(new Chunk("[" + toString(left, false, false) + "|" + toString(right, false, false) + "]", false));
				if (equal.size() > 0)
					result.add(new Chunk(toString(equal, true, true), true));
			}
		}
		return result;
	}

	public String toMultiLineDiff(List<ILineDiff> lines) {
		boolean enabled[] = new boolean[lines.size()];
		Arrays.fill(enabled, false);
		int lastDiffLine = -linesAfterDiff;
		for (int line = 0; line < enabled.length; line++) {
			if (lines.get(line).getKind() != MatchKind.EQUAL)
				lastDiffLine = line;
			if (line - lastDiffLine < linesAfterDiff)
				enabled[line] = true;
		}
		lastDiffLine = enabled.length + linesBeforeDiff;
		for (int lastLine = enabled.length - 1; lastLine >= 0; lastLine--) {
			if (lines.get(lastLine).getKind() != MatchKind.EQUAL)
				lastDiffLine = lastLine;
			if (lastDiffLine - lastLine < linesBeforeDiff)
				enabled[lastLine] = true;
		}
		List<String> filtered = Lists.newArrayList();
		boolean out = false;
		for (int i = 0; i < enabled.length; i++) {
			if (enabled[i]) {
				filtered.add(toPrefixedLine(lines.get(i)));
				out = false;
			} else {
				if (!out) {
					filtered.add("(...)");
					out = true;
				}
			}
		}
		return Joiner.on('\n').join(filtered);
	}

	public String toPrefixedLine(ILineDiff line) {
		switch (line.getKind()) {
		case EQUAL:
			return "  " + toString(getLeftSegments(line), true, true);
		case LEFT_ONLY:
			return "- " + toString(getLeftSegments(line), true, true);
		case RIGHT_ONLY:
			return "+ " + toString(getRightSegments(line), true, true);
		case SIMILAR:
			return "| " + Joiner.on("").join(toChunks(line));
		}
		throw new IllegalStateException("unknown MatchKind: " + line.getKind());
	}

	public String toSingleLineDiff(ILineDiff line) {
		return line.toString();
	}

	public String toSingleSegmentDiff(ISegmentDiff segment) {
		return segment.toString();
	}

	protected String toString(List<ISegment> segments, boolean prefix, boolean postfix) {
		if (segments.isEmpty())
			return "";
		StringBuilder builder = new StringBuilder();
		if (prefix) {
			ISegment prev = segments.get(0).getPrevious();
			while (prev != null && prev.isHidden() && !prev.isWrap()) {
				builder.insert(0, prev);
				prev = prev.getPrevious();
			}
		}
		ISegment last = null;
		for (ISegment seg : segments) {
			if (last != null)
				builder.append(getHiddenBetween(last, seg));
			builder.append(seg);
			last = seg;
		}
		if (postfix) {
			ISegment next = segments.get(segments.size() - 1).getNext();
			while (next != null && next.isHidden() && !next.isWrap()) {
				builder.append(next);
				next = next.getNext();
			}
		}
		return builder.toString();
	}
}
