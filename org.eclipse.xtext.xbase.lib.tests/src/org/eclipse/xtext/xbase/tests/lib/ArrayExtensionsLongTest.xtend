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
class ArrayExtensionsLongTest {

	var long[] data

	@Before
	def void init() {
		data = createData()
	}

	private def long[] createData() {
		val long[] array = newLongArrayOfSize(3)
		array.set(0, 10l)
		array.set(1, 20l)
		array.set(2, 30l)
		return array
	}

	@Test
	def void testSetGet__long() {
		assertEquals(10l, data.get(0))
		assertEquals(20l, data.get(1))
		assertEquals(30l, data.get(2))
	}

	@Test
	def void testClone__long() {
		val clonedData = data.clone();

		assertEquals(10l, clonedData.get(0))
		assertEquals(20l, clonedData.get(1))
		assertEquals(30l, clonedData.get(2))
	}

	@Test
	def void testLength__long() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__long() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__long() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, 0l)]
		assertFalse(data.equals(newData))
	}

	@Test 
	def void testContains__long() {
		assertTrue(data.contains(10l))
		assertTrue(data.contains(20l))
		assertTrue(data.contains(30l))
		
		assertFalse(data.contains(40l))
	}

}
