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
class ArrayExtensionsShortTest {

	var short[] data

	val short _10 = 10 as short
	val short _20 = 20 as short
	val short _30 = 30 as short

	@Before
	def void init() {
		data = createData()
	}

	private def short[] createData() {
		val short[] array = newShortArrayOfSize(3)
		array.set(0, _10)
		array.set(1, _20)
		array.set(2, _30)
		return array
	}

	@Test
	def void testSetGet__short() {
		assertEquals(_10, data.get(0))
		assertEquals(_20, data.get(1))
		assertEquals(_30, data.get(2))
	}

	@Test
	def void testClone__short() {
		val clonedData = data.clone();

		assertEquals(_10, clonedData.get(0))
		assertEquals(_20, clonedData.get(1))
		assertEquals(_30, clonedData.get(2))
	}

	@Test
	def void testLength__short() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__short() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__short() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, 0 as short)]
		assertFalse(data.equals(newData))
	}

	@Test 
	def void testContains__short() {
		assertTrue(data.contains(10 as short))
		assertTrue(data.contains(20 as short))
		assertTrue(data.contains(30 as short))
		
		assertFalse(data.contains(40 as short))
	}

}
