package org.xpect.expectation;

public interface IStringDiffExpectation {

	public interface ITokenAdapter<T> {
		boolean isHidden(T token, String segment);

		Iterable<String> splitIntoSegments(T token);

		float similarity(T token1, String segment1, T token2, String segment2);
	}

	<T> void assertDiffEquals(Iterable<T> leftTokens, Iterable<T> rightTokens, ITokenAdapter<T> adapter);

	void assertDiffEquals(String left, String right);
}
