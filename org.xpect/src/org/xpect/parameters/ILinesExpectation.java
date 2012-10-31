package org.xpect.parameters;

public interface ILinesExpectation {
	void assertEquals(Iterable<?> string);

	void assertEquals(String message, Iterable<?> string);

	void fail(String message, Iterable<?> string);
}
