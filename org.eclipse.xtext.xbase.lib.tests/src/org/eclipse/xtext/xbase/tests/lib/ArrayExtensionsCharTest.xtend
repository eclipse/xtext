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
class ArrayExtensionsCharTest {

	var char[] data
	
	val char a = 'a'
	val char b = 'b'
	val char c = 'c'
	
	val char x = 'x'

	@Before
	def void init() {
		data = createData()
	}

	private def char[] createData() {
		val char[] array = newCharArrayOfSize(3)
		array.set(0, a) 
		array.set(1, b)
		array.set(2, c)
		return array
	}

	@Test
	def void testSetGet__char() {
		assertEquals(a, data.get(0))
		assertEquals(b, data.get(1))
		assertEquals(c, data.get(2))
	}

	@Test
	def void testClone__char() {
		val clonedData = data.clone();

		assertEquals(a, clonedData.get(0))
		assertEquals(b, clonedData.get(1))
		assertEquals(c, clonedData.get(2))
	}

	@Test
	def void testLength__char() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__char() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__char() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, a)]
		assertFalse(data.equals(newData))
	}

	@Test 
	def void testContains__char() {
		assertTrue(data.contains(a))
		assertTrue(data.contains(b))
		assertTrue(data.contains(c))
		
		assertFalse(data.contains(x))
	}

}
