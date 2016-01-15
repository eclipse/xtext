package org.xpect.text;

import java.util.List;

import org.xpect.util.IDifferencer.ISimilarityFunction;
import org.xpect.util.IDifferencer.MatchKind;

public interface ITextDifferencer {

	public interface ILineDiff {
		MatchKind getKind();

		List<ISegmentDiff> getSegmentDiffs();
	}

	public interface ISegment {
		ISegment getNext();

		ISegment getPrevious();

		int getTokenIndex();

		boolean isHidden();

		boolean isWrap();

		String toString();
	}

	public interface ISegmentDiff {
		MatchKind getKind();

		ISegment getLeft();

		ISegment getRight();

		float getSimilarity();
	}

	public interface ITextDiff {
		List<ILineDiff> getLines();
	}

	public interface ITextDiffConfig<T> extends ISimilarityFunction<ISegment> {

		boolean isHidden(T token, String segment);

		Iterable<String> toSegments(T token);
	}

	<T> ITextDiff diff(List<T> leftTokens, List<T> rightTokens, ITextDiffConfig<T> config);

}
