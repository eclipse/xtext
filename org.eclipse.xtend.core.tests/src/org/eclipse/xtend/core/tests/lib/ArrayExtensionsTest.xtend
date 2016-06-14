/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.lib

import java.util.Arrays
import org.junit.Test

import static org.junit.Assert.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class ArrayExtensionsTest {

	int[] intArray = #[1,2,3]
	boolean[] booleanArray = #[true, false]
	long[] longArray = #[1,2,3]
	double[] doubleArray = #[1,2,3]
	String[] stringArray = #["foo","bar","baz"]
	char[] charArray = #['a','b','c']

	@Test def void testClone() {
		assertNotSame(intArray, intArray.clone)
		assertArrayEquals(intArray, intArray.clone)
		
		assertNotSame(booleanArray, booleanArray.clone)
		assertTrue(Arrays.equals(booleanArray, booleanArray.clone))
		
		assertNotSame(longArray, longArray.clone)
		assertArrayEquals(longArray, longArray.clone)
		
		assertNotSame(doubleArray, doubleArray.clone)
		assertTrue(Arrays.equals(doubleArray, doubleArray.clone))
		
		assertNotSame(stringArray, stringArray.clone)
		assertArrayEquals(stringArray, stringArray.clone)
		
		assertNotSame(charArray, charArray.clone)
		assertArrayEquals(charArray, charArray.clone)
	}
	
	@Test def void testHashCode() {
		assertEquals(intArray.objectHashCode, intArray.hashCode)
		assertEquals(booleanArray.objectHashCode, booleanArray.hashCode)
		assertEquals(longArray.objectHashCode, longArray.hashCode)
		assertEquals(doubleArray.objectHashCode, doubleArray.hashCode)
		assertEquals(stringArray.objectHashCode, stringArray.hashCode)
		assertEquals(charArray.objectHashCode, charArray.hashCode)
	}
	
	@Test def void testEquals() {
		assertTrue(intArray.equals(intArray))
		assertTrue(booleanArray.equals(booleanArray))
		assertTrue(longArray.equals(longArray))
		assertTrue(doubleArray.equals(doubleArray))
		assertTrue(stringArray.equals(stringArray))
		assertTrue(charArray.equals(charArray))
		assertFalse(intArray.equals(intArray.clone))
		assertFalse(booleanArray.equals(booleanArray.clone))
		assertFalse(longArray.equals(longArray.clone))
		assertFalse(doubleArray.equals(doubleArray.clone))
		assertFalse(stringArray.equals(stringArray.clone))
		assertFalse(charArray.equals(charArray.clone))
	}
	
	def int objectHashCode(Object x) {
		assertTrue(x.class.array)
		return x.hashCode
	}
	
}