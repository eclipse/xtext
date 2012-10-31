package org.xpect.parameters;

import com.google.common.base.Predicate;

public interface ICommaSeparatedValuesExpectation {
	void assertEquals(Iterable<?> string);

	void assertEquals(Iterable<?> string, Predicate<String> predicate);

	void assertEquals(Predicate<String> predicate);
}
