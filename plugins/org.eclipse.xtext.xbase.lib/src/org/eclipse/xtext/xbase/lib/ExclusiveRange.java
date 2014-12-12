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
 * A sequence of integers starting from <code>start</code> to <code>end</code> counting up or down.
 * It excludes the <code>end</code> value when counting up and the <code>start</code> value when counting down.   
 * 
 * Examples:
 * <table>
 * <tr><td><code>new ExclusiveRange(1, 5, true)</code></td><td>(1,2,3,4)</td></tr>
 * <tr><td><code>new ExclusiveRange(0, 0, true)</code></td><td>()</td></tr>
 * <tr><td><code>new ExclusiveRange(0, -1, true)</code></td><td>()</td></tr>
 * <tr><td><code>new ExclusiveRange(-1, 0, true)</code></td><td>(-1)</td></tr>
 * <tr><td><code>new ExclusiveRange(5, 1, false)</code></td><td>(4,3,2,1)</td></tr>
 * <tr><td><code>new ExclusiveRange(0, 0, false)</code></td><td>()</td></tr>
 * <tr><td><code>new ExclusiveRange(-1, 0, false)</code></td><td>()</td></tr>
 * <tr><td><code>new ExclusiveRange(0, -1, false)</code></td><td>(-1)</td></tr>
 * </table>
 * 
 * As opposed to {@link IntegerRange} this class meets the requirements to iterate arrays or lists without 
 * the need for further guards, e.g.
 * 
 * <pre>
 * for(i: new ExclusiveRange(0, list.size, true)) 
 *   list.get(i)...
 * 
 * for(i: new ExclusiveRange(array.length, 0, false)) 
 *   array.get(i)...
 * 
 * for(i: new ExclusiveRange(0, string.indexOf('x'), true)
 *   string.charAt(i)...
 * </pre>
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.4
 */
@GwtCompatible 
public class ExclusiveRange implements Iterable<Integer> {

	private final int first;
	private final int last;
	private final int step;

	private static final ListIterator<Integer> EMPTY_LIST_ITERATOR = new ListIterator<Integer>() {

		@Override
		public boolean hasNext() {
			return false;
		}

		@Override
		public Integer next() {
			throw new NoSuchElementException();
		}

		@Override
		public boolean hasPrevious() {
			return false;
		}

		@Override
		public Integer previous() {
			throw new NoSuchElementException();
		}

		@Override
		public int nextIndex() {
			return -1;
		}

		@Override
		public int previousIndex() {
			return -1;
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
	};
	
	/**
	 * @return a read-only {@link ListIterator} for this.
	 */
	@Override
	@Pure
	public ListIterator<Integer> iterator() {
		return isEmpty() ? EMPTY_LIST_ITERATOR : new RangeIterator();
	}

	/**
	 * Constructs a new ExclusiveRange object.
	 * 
	 * @param start the start value
	 * @param end the end value
	 * @param increment
	 *            if true, the range goes from start up to end (exclusive)
	 *            if false, the range goes from end down to start (exclusive)
	 */
	@Pure
	public ExclusiveRange(int start, int end, boolean increment) {
		if (increment) {
			first = start;
			last = end - 1;
			step = 1;
		} else {
			first = start - 1;
			last = end;
			step = -1;
		} 
	}

	/**
	 * Returns the number of elements in this ExclusiveRange. 
	 * 
	 * @return the number of elements in this ExclusiveRange.
	 */
	@Pure
	public int size() {
		return (isEmpty()) ? 0 : Math.abs(last - first) + 1;
	}


	/** 
	 * Returns whether this is range is empty.
	 * 
	 * @return true if this range is empty.
	 */
	@Pure 
	public boolean isEmpty() {
		return (last - first) * step < 0;
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
		if (isEmpty())
			return false;
		if(step == -1)
			return number <= first && number >= last;
		else
			return number >= first && number <= last;
	}

	private class RangeIterator implements ListIterator<Integer> {

		private int next = first;
		private int nextIndex = 0;

		@Override
		public boolean hasNext() {
			if (step < 0)
				return next >= last;
			else
				return next <= last;
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
