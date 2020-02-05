/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IntegerExtensionsTest {
	
	@Test
	public void testOperator_upTo_01() throws Exception {
		Iterator<Integer> iterator = org.eclipse.xtext.xbase.lib.IntegerExtensions.operator_upTo(0, 0).iterator();
		Assert.assertEquals(0, iterator.next().intValue());
		Assert.assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testOperator_upTo_02() throws Exception {
		Iterator<Integer> iterator = org.eclipse.xtext.xbase.lib.IntegerExtensions.operator_upTo(4, 6).iterator();
		Assert.assertEquals(4, iterator.next().intValue());
		Assert.assertEquals(5, iterator.next().intValue());
		Assert.assertEquals(6, iterator.next().intValue());
		Assert.assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testOperator_upTo_03() throws Exception {
		Iterator<Integer> iterator = org.eclipse.xtext.xbase.lib.IntegerExtensions.operator_upTo(12, 9).iterator();
		Assert.assertEquals(12, iterator.next().intValue());
		Assert.assertEquals(11, iterator.next().intValue());
		Assert.assertEquals(10, iterator.next().intValue());
		Assert.assertEquals(9, iterator.next().intValue());
		Assert.assertFalse(iterator.hasNext());
	}
	
	@Test
	public void testOperator_upTo_04() throws Exception {
		Iterator<Integer> iterator = org.eclipse.xtext.xbase.lib.IntegerExtensions.operator_upTo(-12, -9).iterator();
		Assert.assertEquals(-12, iterator.next().intValue());
		Assert.assertEquals(-11, iterator.next().intValue());
		Assert.assertEquals(-10, iterator.next().intValue());
		Assert.assertEquals(-9, iterator.next().intValue());
		Assert.assertFalse(iterator.hasNext());
	}
}
