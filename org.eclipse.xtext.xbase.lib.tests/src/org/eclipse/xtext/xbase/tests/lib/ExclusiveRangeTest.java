/*******************************************************************************
 * Copyright (c) 2016, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.eclipse.xtext.xbase.lib.IterableExtensions.join;

/**
 * @author Jan Koehnlein
 */
public class ExclusiveRangeTest {

	@Test
	public void testContent() {
		assertEquals("1,2,3,4", join(new ExclusiveRange(1, 5, true), ","));
		assertEquals("", join(new ExclusiveRange(0, 0, true), ","));
		assertEquals("", join(new ExclusiveRange(0, -1, true), ","));
		assertEquals("-1", join(new ExclusiveRange(-1, 0, true), ","));
		assertEquals("4,3,2,1", join(new ExclusiveRange(5, 1, false), ","));
		assertEquals("", join(new ExclusiveRange(0, 0, false), ","));
		assertEquals("", join(new ExclusiveRange(-1, 0, false), ","));
		assertEquals("-1", join(new ExclusiveRange(0, -1, false), ","));
	}

	@Test
	public void testSize() {
		assertEquals(4, new ExclusiveRange(1, 5, true).size());
		assertEquals(0, new ExclusiveRange(0, 0, true).size());
		assertEquals(0, new ExclusiveRange(0, -1, true).size());
		assertEquals(1, new ExclusiveRange(-1, 0, true).size());
		assertEquals(4, new ExclusiveRange(5, 1, false).size());
		assertEquals(0, new ExclusiveRange(0, 0, false).size());
		assertEquals(0, new ExclusiveRange(-1, 0, false).size());
		assertEquals(1, new ExclusiveRange(0, -1, false).size());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(new ExclusiveRange(1, 5, true).isEmpty());
		assertTrue(new ExclusiveRange(0, 0, true).isEmpty());
		assertTrue(new ExclusiveRange(0, -1, true).isEmpty());
		assertFalse(new ExclusiveRange(-1, 0, true).isEmpty());
		assertFalse(new ExclusiveRange(5, 1, false).isEmpty());
		assertTrue(new ExclusiveRange(0, 0, false).isEmpty());
		assertTrue(new ExclusiveRange(-1, 0, false).isEmpty());
		assertFalse(new ExclusiveRange(0, -1, false).isEmpty());
	}

	@Test
	public void testContains() {
		assertFalse(new ExclusiveRange(1, 5, true).contains(0));
		assertTrue(new ExclusiveRange(1, 5, true).contains(1));
		assertTrue(new ExclusiveRange(1, 5, true).contains(2));
		assertTrue(new ExclusiveRange(1, 5, true).contains(3));
		assertTrue(new ExclusiveRange(1, 5, true).contains(4));
		assertFalse(new ExclusiveRange(1, 5, true).contains(5));

		assertFalse(new ExclusiveRange(0, 0, true).contains(0));

		assertFalse(new ExclusiveRange(0, -1, true).contains(0));
		assertFalse(new ExclusiveRange(0, -1, true).contains(-1));

		assertFalse(new ExclusiveRange(-1, 0, true).contains(-2));
		assertTrue(new ExclusiveRange(-1, 0, true).contains(-1));
		assertFalse(new ExclusiveRange(-1, 0, true).contains(-0));

		assertFalse(new ExclusiveRange(5, 1, false).contains(0));
		assertTrue(new ExclusiveRange(5, 1, false).contains(1));
		assertTrue(new ExclusiveRange(5, 1, false).contains(2));
		assertTrue(new ExclusiveRange(5, 1, false).contains(3));
		assertTrue(new ExclusiveRange(5, 1, false).contains(4));
		assertFalse(new ExclusiveRange(5, 1, false).contains(5));

		assertFalse(new ExclusiveRange(0, 0, false).contains(0));

		assertFalse(new ExclusiveRange(-1, 0, false).contains(0));
		assertFalse(new ExclusiveRange(-1, 0, false).contains(-1));

		assertFalse(new ExclusiveRange(0, -1, false).contains(-2));
		assertTrue(new ExclusiveRange(0, -1, false).contains(-1));
		assertFalse(new ExclusiveRange(0, -1, false).contains(-0));
	}
	
}
