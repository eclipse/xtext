/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.typesystem

import java.io.Serializable
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class LightweightTypeReferenceTest extends AbstractLightweightTypeReferenceTest {

	@Test
	def void testIsAssignableFrom_01() {
		val serializableRef = typeRef(Serializable)
		val objectArr = type(typeof(Object[]))
		val objectArrRef = typeRef(typeof(Object[]))
		assertTrue(serializableRef.isAssignableFrom(objectArrRef))
		assertTrue(serializableRef.isAssignableFrom(objectArr))
		assertTrue(serializableRef.isAssignableFrom(typeof(Object[])))
	}
	
	@Test
	def void testIsAssignableFrom_02() {
		val serializableArrRef = typeRef(typeof(Serializable[]))
		val objectArr = type(typeof(Object[]))
		val objectArrRef = typeRef(typeof(Object[]))
		assertFalse(serializableArrRef.isAssignableFrom(objectArrRef))
		assertFalse(serializableArrRef.isAssignableFrom(objectArr))
		assertFalse(serializableArrRef.isAssignableFrom(typeof(Object[])))
	}
	
	@Test
	def void testIsAssignableFrom_03() {
		val serializableArrRef = typeRef(typeof(Serializable[]))
		val stringArr = type(typeof(String[]))
		val stringArrRef = typeRef(typeof(String[]))
		assertTrue(serializableArrRef.isAssignableFrom(stringArrRef))
		assertTrue(serializableArrRef.isAssignableFrom(stringArr))
		assertTrue(serializableArrRef.isAssignableFrom(typeof(String[])))
	}
	
}