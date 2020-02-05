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
class ArrayExtensionsFloatTest {

	var float[] data

	@Before
	def void init() {
		data = createData()
	}

	private def float[] createData() {
		val float[] array = newFloatArrayOfSize(3)
		array.set(0, 10.0f)
		array.set(1, 20.0f)
		array.set(2, 30.0f)
		return array
	}

	@Test
	def void testSetGet__float() {
		assertEquals(10.0f, data.get(0), 0.001f)
		assertEquals(20.0f, data.get(1), 0.001f)
		assertEquals(30.0f, data.get(2), 0.001f)
	}

	@Test
	def void testClone__float() {
		val clonedData = data.clone();

		assertEquals(10.0f, clonedData.get(0), 0.001f)
		assertEquals(20.0f, clonedData.get(1), 0.001f)
		assertEquals(30.0f, clonedData.get(2), 0.001f)
	}

	@Test
	def void testLength__float() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__float() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__float() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, 0.0f)]
		assertFalse(data.equals(newData))
	}

	@Test 
	def void testContains__float() {
		assertTrue(data.contains(10.0f))
		assertTrue(data.contains(20.0f))
		assertTrue(data.contains(30.0f))
		
		assertFalse(data.contains(40.0f))
	}
	
	@Test
	def void testContains__float_NaN() {
		val float[] nanData = #[1.0f, Float.NaN]
		
		assertTrue(nanData.contains(Float.NaN))
		assertTrue(nanData.contains(0f / 0f))
		assertTrue(nanData.contains(Math.log(-1) as float))
		
		assertFalse(nanData.contains(Float.NEGATIVE_INFINITY))
		assertFalse(nanData.contains(Float.POSITIVE_INFINITY))
	}
	
	@Test
	def void testContains__float_posInfinity() {
		val float[] nanData = #[1.0f, Float.POSITIVE_INFINITY]
		
		assertTrue(nanData.contains(Float.POSITIVE_INFINITY))
		assertTrue(nanData.contains(Float.POSITIVE_INFINITY + 7.2f))
		
		assertFalse(nanData.contains(Float.NaN))
		assertFalse(nanData.contains(0f / 0f))
		assertFalse(nanData.contains(Math.log(-1) as float))
		assertFalse(nanData.contains(Float.NEGATIVE_INFINITY))
	}

	@Test
	def void testContains__float_negInfinity() {
		val float[] nanData = #[1.0f, Float.NEGATIVE_INFINITY]
		
		assertTrue(nanData.contains(Float.NEGATIVE_INFINITY))
		assertTrue(nanData.contains(Float.NEGATIVE_INFINITY + 7.2f))
		
		assertFalse(nanData.contains(Float.NaN))
		assertFalse(nanData.contains(0f / 0f))
		assertFalse(nanData.contains(Math.log(-1) as float))
		assertFalse(nanData.contains(Float.POSITIVE_INFINITY))
	}

}
