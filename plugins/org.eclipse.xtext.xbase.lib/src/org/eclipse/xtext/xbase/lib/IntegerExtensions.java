/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.Iterator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IntegerExtensions {

	public static int _operator_minus(Integer a) {
		return -a;
	}
	
	public static int _operator_plus(Integer a, Number b) {
		return a+b.intValue();
	}
	
	public static int _operator_minus(Integer a, Number b) {
		return a-b.intValue();
	}
	
	public static int _operator_multiply(Integer a, Number b) {
		return a*b.intValue();
	}
	
	public static int _operator_divide(Integer a, Number b) {
		return a/b.intValue();
	}
	
	public static int _operator_modulo(Integer a, Number b) {
		return a%b.intValue();
	}
	
	public static int _operator_power(Integer a, Number b) {
		return (int) Math.pow(a, b.intValue());
	}

	/**
	 * implementation for the upTo operator on {@link Integer} 
	 */
	public static Iterable<Integer> _operator_upTo(final Integer a, Number b) {
		final int upTo = b.intValue();
		return new Iterable<Integer>() {
			public Iterator<Integer> iterator() {
				return new IntIterator(a, upTo);
			}
		};
	}
	
	protected static class IntIterator implements Iterator<Integer> {
		private int current;
		private int upTo;
		private boolean increases;

		public IntIterator(int start, int upTo) {
			super();
			this.current = start;
			this.upTo = upTo;
			this.increases = start < upTo;
		}

		public boolean hasNext() {
			if (increases)
				return current < upTo;
			else
				return current > upTo;
		}

		public Integer next() {
			if (increases)
				return current++;
			else
				return current--;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
}
