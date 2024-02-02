/*******************************************************************************
 * Copyright (c) 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.util;

import static org.junit.Assert.*;

import org.eclipse.xtext.common.types.JvmParameterizedTypeReference;
import org.eclipse.xtext.common.types.TypesFactory;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class JvmTypeReferenceUtilTest {

	@Test
	public void testExpectedAsClass() {
		var typeReference1 = createTypeReference();
		var typeReference2 = createTypeReference();
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference1));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference2));
		JvmTypeReferenceUtil.setExpectedAsClass(typeReference1);
		JvmTypeReferenceUtil.setExpectedAsClass(typeReference2);
		assertTrue(JvmTypeReferenceUtil.isExpectedAsClass(typeReference1));
		assertTrue(JvmTypeReferenceUtil.isExpectedAsClass(typeReference2));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference1));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference2));
	}

	@Test
	public void testExpectedAsInterface() {
		var typeReference1 = createTypeReference();
		var typeReference2 = createTypeReference();
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference1));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference2));
		JvmTypeReferenceUtil.setExpectedAsInterface(typeReference1);
		JvmTypeReferenceUtil.setExpectedAsInterface(typeReference2);
		assertTrue(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference1));
		assertTrue(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference2));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference1));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference2));
	}

	private JvmParameterizedTypeReference createTypeReference() {
		return TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
	}
}
