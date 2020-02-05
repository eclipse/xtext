/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib

import org.junit.Before
import org.junit.Test

import static org.junit.Assert.*
import java.util.Objects

/**
 * @author Mathias Rieder - Initial contribution and API
 */
class ArrayExtensionsIntTest {

	var int[] data

	@Before
	def void init() {
		data = createData()
	}

	private def int[] createData() {
		val int[] array = newIntArrayOfSize(3)
		array.set(0, 10)
		array.set(1, 20)
		array.set(2, 30)
		return array
	}

	@Test
	def void testSetGet__int() {
		assertEquals(10, data.get(0))
		assertEquals(20, data.get(1))
		assertEquals(30, data.get(2))
	}

	@Test
	def void testClone__int() {
		val clonedData = data.clone();

		assertEquals(10, clonedData.get(0))
		assertEquals(20, clonedData.get(1))
		assertEquals(30, clonedData.get(2))
	}

	@Test
	def void testLength__int() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__int() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__int() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, 0)]
		assertFalse(data.equals(newData))
	}

	@Test 
	def void testContains__int() {
		assertTrue(data.contains(10))
		assertTrue(data.contains(20))
		assertTrue(data.contains(30))
		
		assertFalse(data.contains(40))
	}

}
