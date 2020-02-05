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
class ArrayExtensionsBooleanTest {

	var boolean[] data

	@Before
	def void init() {
		data = createData()
	}

	private def boolean[] createData() {
		val boolean[] array = newBooleanArrayOfSize(3)
		array.set(0, true)
		array.set(1, false)
		array.set(2, true)
		return array
	}

	@Test
	def void testSetGet__boolean() {
		assertTrue(data.get(0))
		assertFalse(data.get(1))
		assertTrue(data.get(2))
	}

	@Test
	def void testClone__boolean() {
		val clonedData = data.clone();

		assertTrue(clonedData.get(0))
		assertFalse(clonedData.get(1))
		assertTrue(clonedData.get(2))
	}

	@Test
	def void testLength__boolean() {
		assertEquals(3, data.length)
	}

	@Test
	def void testHashCode__boolean() {
		assertEquals(Objects.hashCode(data), data.hashCode)
	}

	@Test
	def void testEquals__boolean() {
		assertTrue(data.equals(data))

		assertFalse(data.equals(createData()))
		assertFalse(data.equals(newArrayOfSize(3)))
		assertFalse(data.equals(null))

		val newData = createData() => [it.set(1, true)]
		assertFalse(data.equals(newData))
	}

	@Test
	def void testContains__boolean() {
		assertTrue(data.contains(true))
		assertTrue(data.contains(false))
		
		val onlyFalse = newBooleanArrayOfSize(2) => [
			set(0, false)
			set(1, false)
		]

		assertFalse(onlyFalse.contains(true))
		assertTrue(onlyFalse.contains(false))
	}

}
