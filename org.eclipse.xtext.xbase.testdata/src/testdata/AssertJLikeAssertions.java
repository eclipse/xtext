/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/

package testdata;

import com.google.common.base.Objects;

public class AssertJLikeAssertions {

	public static <T extends Comparable<? super T>> T assertThat(T actual) {
		return actual;
	}

	public static NumberAssert<?, Integer> assertThat(int actual) {
		return new IntegerAssert(actual);
	}

	public static interface NumberAssert<S extends NumberAssert<S, A>, A extends Number> {
		public S isEqualTo(int expected);
		public int getValue();
	}
	
	public static abstract class AbstractIntegerAssert<S extends AbstractIntegerAssert<S>>implements NumberAssert<S, Integer> {
		
	}
	
	public static class IntegerAssert extends AbstractIntegerAssert<IntegerAssert> {
		
		private int value;

		public IntegerAssert(int value) {
			this.value = value;
		}

		@Override
		public IntegerAssert isEqualTo(int expected) {
			if (!Objects.equal(expected, value)) {
				throw new AssertJLikeException(expected + " != " + value);
			}
			return this;
		}

		@Override
		public int getValue() {
			return value;
		}
		
	}
	
	public static class AssertJLikeException extends RuntimeException {
		private static final long serialVersionUID = 5999372789728363443L;

		public AssertJLikeException(String message) {
			super(message);
		}
		
	}

}
