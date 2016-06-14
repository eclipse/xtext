/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import static org.junit.Assert.*;

import java.util.ListIterator;
import java.util.NoSuchElementException;

import org.eclipse.xtext.xbase.lib.IntegerRange;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class IntegerRangeTest {

	@Test
	public void testValidity() {
		new IntegerRange(0, 0, 1);
		new IntegerRange(0, 0, -1);
		new IntegerRange(0, 2, 1);
		new IntegerRange(-1, 2, 1);
		new IntegerRange(-2, -1, 1);
		new IntegerRange(2, 0, -1);
		new IntegerRange(2, -1, -1);
		new IntegerRange(-1, -2, -1);

		assertInvalid(0, 1, 0);
		assertInvalid(0, 2, -1);
		assertInvalid(-1, 2, -1);
		assertInvalid(-2, -1, -1);
		assertInvalid(2, 0, 1);
		assertInvalid(2, -1, 1);
		assertInvalid(-1, -2, 1);
	}

	protected void assertInvalid(int start, int end, int step) {
		try {
			new IntegerRange(start, end, step);
			fail("Invalid step not detected");
		} catch (IllegalArgumentException e) {
			// expected exception
		}
	}

	@Test
	public void testDefaultStep() {
		assertEquals(1, new IntegerRange(0, 10).getStep());
		assertEquals(-1, new IntegerRange(10, 0).getStep());
		assertEquals(1, new IntegerRange(10, 10).getStep());
	}

	@Test
	public void testContains_0() {
		IntegerRange range = new IntegerRange(-1, 1, 2);
		assertFalse(range.contains(-2));
		assertTrue(range.contains(-1));
		assertFalse(range.contains(0));
		assertTrue(range.contains(1));
		assertFalse(range.contains(2));
	}

	@Test
	public void testContains_1() {
		IntegerRange range = new IntegerRange(-1, 2, 2);
		assertFalse(range.contains(-2));
		assertTrue(range.contains(-1));
		assertFalse(range.contains(0));
		assertTrue(range.contains(1));
		assertFalse(range.contains(2));
	}

	@Test
	public void testSize() {
		final IntegerRange myRange = new IntegerRange(-1, 1);
		assertEquals(3, myRange.getSize());
		assertEquals(2, myRange.withStep(2).getSize());
		assertEquals(1, myRange.withStep(3).getSize());
		
		final IntegerRange myRange2 = new IntegerRange(1, -1);
		assertEquals(3, myRange2.getSize());
		assertEquals(2, myRange2.withStep(-2).getSize());
		assertEquals(1, myRange2.withStep(-3).getSize());
	}

	@Test
	public void testIterator() {
		ListIterator<Integer> iterator = new IntegerRange(-2, 2, 2).iterator();
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals(-1, iterator.previousIndex());
		try {
			iterator.previous();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// expected exception;
		}
		
		assertEquals(-2, iterator.next().intValue());
		assertTrue(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals(0, iterator.previousIndex());

		assertEquals(0, iterator.next().intValue());
		assertTrue(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals(1, iterator.previousIndex());

		assertEquals(2, iterator.next().intValue());
		assertTrue(iterator.hasPrevious());
		assertFalse(iterator.hasNext());
		assertEquals(3, iterator.nextIndex());
		assertEquals(2, iterator.previousIndex());
		try {
			iterator.next();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// expected exception;
		}

		assertEquals(2, iterator.previous().intValue());
		assertTrue(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(2, iterator.nextIndex());
		assertEquals(1, iterator.previousIndex());

		assertEquals(0, iterator.previous().intValue());
		assertTrue(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(1, iterator.nextIndex());
		assertEquals(0, iterator.previousIndex());

		assertEquals(-2, iterator.previous().intValue());
		assertFalse(iterator.hasPrevious());
		assertTrue(iterator.hasNext());
		assertEquals(0, iterator.nextIndex());
		assertEquals(-1, iterator.previousIndex());

		try {
			iterator.previous();
			fail("Expected NoSuchElementException");
		} catch(NoSuchElementException e) {
			// expected exception;
		}
	}
}
