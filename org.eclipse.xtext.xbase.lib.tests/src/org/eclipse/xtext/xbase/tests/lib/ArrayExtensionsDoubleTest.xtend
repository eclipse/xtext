/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib

import java.util.Objects
import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Mathias Rieder - Initial contribution and API
 */
class ArrayExtensionsDoubleTest {

	var double[] data

	@Before
	def void init() {
		data = createData()
	}

	private def double[] createData() {
		val double[] array = newDoubleArrayOfSize(3)
		array.set(0, 10.0)
		array.set(1, 20.0)
		array.set(2, 30.0)
		return array
	}

	@Test
	def void testSetGet__double() {
		assertEquals(10.0, data.get(0), 0.001)
		assertEquals(20.0, data.get(1), 0.001)
		assertEquals(30.0, data.get(2), 0.001)
	}

	@Test
	def void testClone__double() {
		val clonedData = data.clone();

		assertEquals(10.0, clonedData.get(0), 0.001)
		assertEquals(20.0, clonedData.get(1), 0.001)
		assertEquals(30.0, clonedData.get(2), 0.001)
	}

	@Test
	def void testLength__double() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__double() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__double() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, 0.0)]
		assertFalse(data.equals(newData))
	}

	@Test
	def void testContains__double() {
		assertTrue(data.contains(10.0))
		assertTrue(data.contains(20.0))
		assertTrue(data.contains(30.0))
		
		assertFalse(data.contains(40.0))
	}
	
	@Test
	def void testContains__float_NaN() {
		val double[] nanData = #[1.0, Double.NaN]
		
		assertTrue(nanData.contains(Double.NaN))
		assertTrue(nanData.contains(0f / 0f))
		assertTrue(nanData.contains(Math.log(-1)))
		
		assertFalse(nanData.contains(Double.NEGATIVE_INFINITY))
		assertFalse(nanData.contains(Double.POSITIVE_INFINITY))
	}
	
	@Test
	def void testContains__double_posInfinity() {
		val double[] nanData = #[1.0f, Double.POSITIVE_INFINITY]
		
		assertTrue(nanData.contains(Double.POSITIVE_INFINITY))
		assertTrue(nanData.contains(Double.POSITIVE_INFINITY + 7.2f))
		
		assertFalse(nanData.contains(Double.NaN))
		assertFalse(nanData.contains(0f / 0f))
		assertFalse(nanData.contains(Math.log(-1)))
		assertFalse(nanData.contains(Double.NEGATIVE_INFINITY))
	}

	@Test
	def void testContains__double_negInfinity() {
		val double[] nanData = #[1.0f, Double.NEGATIVE_INFINITY]
		
		assertTrue(nanData.contains(Double.NEGATIVE_INFINITY))
		assertTrue(nanData.contains(Double.NEGATIVE_INFINITY + 7.2f))
		
		assertFalse(nanData.contains(Double.NaN))
		assertFalse(nanData.contains(0f / 0f))
		assertFalse(nanData.contains(Math.log(-1)))
		assertFalse(nanData.contains(Double.POSITIVE_INFINITY))
	}

}
