package org.xpect.util;

import java.util.List;

/**
 * @author Moritz Eysholdt
 */
public interface IDifferencer {

	public interface ISimilarityFunction<T> {
		final float EQUAL = 0.0f;
		final float UPPER_SIMILARITY_BOUND = 1.0f;

		float similarity(T object1, T object2);
	}

	public enum MatchKind {
		EQUAL, SIMILAR, LEFT_ONLY, RIGHT_ONLY
	}

	public interface Match {
		final int NO_INDEX = -1;
		final float EQUAL = ISimilarityFunction.EQUAL;
		final float UNEQUAL = ISimilarityFunction.UPPER_SIMILARITY_BOUND;

		int getLeft();

		int getRight();

		float getSimilarity();

		MatchKind getKind();
	}

	public <T> List<Match> diff(List<T> left, List<T> right, ISimilarityFunction<? super T> similarityfunction);

}
