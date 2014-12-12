/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.lib;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.google.common.annotations.GwtCompatible;

/**
 * A sequence of integers starting from <code>start</code> up to <code>end</code> with an increment of <code>step</code>. 
 * The value of <code>start</code> is always included. 
 * The value of <code>end</code> is included only if the difference between <code>end-start</code> is a multiple of <code>step</code>. 
 * The <code>step</code> can be positive or negative, but never 0. It must have the same signum as of <code>end-start</code>.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.3
 */
@GwtCompatible public class IntegerRange implements Iterable<Integer> {

	private final int start;
	private final int end;
	private final int step;

	/**
	 * @return a read-only {@link ListIterator} for this.
	 */
	@Override
	@Pure
	public ListIterator<Integer> iterator() {
		return new RangeIterator();
	}

	/**
	 * Constructs a new IntegerRange object.
	 * The step will be set to -1 if end<start or to 1 otherwise.
	 * 
	 * @param start
	 *            the start value (inclusive)
	 * @param end
	 *            the end value (inclusive)
	 */
	@Pure
	public IntegerRange(int start, int end) {
		this(start, end, end >= start ? 1 : -1);
	}

	/**
	 * Constructs a new IntegerRange object.
	 * 
	 * @param start
	 *            the start value (inclusive)
	 * @param end
	 *            the end value (inclusive if end-start%step == 0)
	 * @param step
	 *            the increment
	 */
	@Pure
	public IntegerRange(int start, int end, int step) {
		if ((end - start) * step < 0)
			throw new IllegalArgumentException("The step of an IntegerRange must have the correct sign.");
		if (step == 0)
			throw new IllegalArgumentException("The step of an IntegerRange must not be 0");
		this.start = start;
		this.end = end;
		this.step = step;
	}

	/**
	 * @return the start value
	 */
	@Pure
	public int getStart() {
		return start;
	}

	/**
	 * @return the step value
	 */
	@Pure
	public int getStep() {
		return step;
	}

	/**
	 * @return the end value
	 */
	@Pure
	public int getEnd() {
		return end;
	}

	/**
	 * Returns the number of elements in this IntegerRange. That is <em>not</em> the length of the interval,
	 * but <code>(end-start)/step + 1</code>.
	 * @return the number of elements in this IntegerRange.
	 */
	@Pure
	public int getSize() {
		return (end - start) / step + 1;
	}

	/**
	 * @param step
	 *            the step of the new range.
	 * @return a new IntegerRange with the given step.
	 */
	@Pure
	public IntegerRange withStep(int step) {
		return new IntegerRange(start, end, step);
	}

	/**
	 * Checks whether this contains the given number, i.e. whether the iterator will yield the number. This is different
	 * from interval containment: <code>0..2.by(2)</code> will <em>not</em> contain 1.
	 * 
	 * @param number
	 *            the number to be checked for containment.
	 * @return whether this sequence contains the given number or not.
	 */
	@Pure
	public boolean contains(int number) {
		if (step < 0)
			return number <= start && number >= end && (number - start) % step == 0;
		else
			return number >= start && number <= end && (number - start) % step == 0;
	}

	/**
	 * @author Jan Koehnlein - Initial contribution and API
	 */
	private class RangeIterator implements ListIterator<Integer> {

		private int next = start;
		private int nextIndex = 0;

		@Override
		public boolean hasNext() {
			if (step < 0)
				return next >= end;
			else
				return next <= end;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int value = next;
			next += step;
			++nextIndex;
			return value;
		}

		@Override
		public boolean hasPrevious() {
			return nextIndex > 0;
		}

		@Override
		public Integer previous() {
			if (nextIndex <= 0)
				throw new NoSuchElementException();
			--nextIndex;
			next -= step;
			return next;
		}

		@Override
		public int nextIndex() {
			return nextIndex;
		}

		@Override
		public int previousIndex() {
			return nextIndex - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException("Cannot remove elements from a Range");
		}

		@Override
		public void set(Integer e) {
			throw new UnsupportedOperationException("Cannot set elements in a Range");
		}

		@Override
		public void add(Integer e) {
			throw new UnsupportedOperationException("Cannot add elements to a Range");
		}
	}
}
