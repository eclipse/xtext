/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.typesystem;

import java.io.Serializable;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LightweightTypeReferenceTest extends AbstractLightweightTypeReferenceTest {
	@Test
	public void testIsAssignableFrom_01() {
		LightweightTypeReference serializableRef = typeRef(Serializable.class);
		JvmType objectArr = type(Object[].class);
		LightweightTypeReference objectArrRef = typeRef(Object[].class);
		Assert.assertTrue(serializableRef.isAssignableFrom(objectArrRef));
		Assert.assertTrue(serializableRef.isAssignableFrom(objectArr));
		Assert.assertTrue(serializableRef.isAssignableFrom(Object[].class));
	}

	@Test
	public void testIsAssignableFrom_02() {
		LightweightTypeReference serializableArrRef = typeRef(Serializable[].class);
		JvmType objectArr = type(Object[].class);
		LightweightTypeReference objectArrRef = typeRef(Object[].class);
		Assert.assertFalse(serializableArrRef.isAssignableFrom(objectArrRef));
		Assert.assertFalse(serializableArrRef.isAssignableFrom(objectArr));
		Assert.assertFalse(serializableArrRef.isAssignableFrom(Object[].class));
	}

	@Test
	public void testIsAssignableFrom_03() {
		LightweightTypeReference serializableArrRef = typeRef(Serializable[].class);
		JvmType stringArr = type(String[].class);
		LightweightTypeReference stringArrRef = typeRef(String[].class);
		Assert.assertTrue(serializableArrRef.isAssignableFrom(stringArrRef));
		Assert.assertTrue(serializableArrRef.isAssignableFrom(stringArr));
		Assert.assertTrue(serializableArrRef.isAssignableFrom(String[].class));
	}
}
