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
class ArrayExtensionsObjectTest {

	var Object[] data

	@Before
	def void init() {
		data = createData()
	}

	private def Object[] createData() {
		val Object[] array = newArrayOfSize(3)
		array.set(0, Integer.valueOf(0))
		array.set(1, Integer.valueOf(1))
		array.set(2, null)
		return array
	}

	@Test
	def void testSetGet__Object() {
		assertSame(Integer.valueOf(0), data.get(0))
		assertSame(Integer.valueOf(1), data.get(1))
		assertNull(null, data.get(2))
	}

	@Test
	def void testClone__Object() {
		val clonedData = data.clone();

		assertSame(Integer.valueOf(0), clonedData.get(0))
		assertSame(Integer.valueOf(1), clonedData.get(1))
		assertNull(null, data.get(2))
	}

	@Test
	def void testLength__Object() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__Object() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__Object() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, "Hello World")]
		assertFalse(data.equals(newData))
	}

	@Test
	def void testContains__Object() {
		assertTrue(data.contains(Integer.valueOf(0)))
		assertTrue(data.contains(Integer.valueOf(1)))
		assertTrue(data.contains(null))

		assertFalse(data.contains(Integer.valueOf(3)))
		assertFalse(data.contains(Integer.valueOf(4)))
	}

}
