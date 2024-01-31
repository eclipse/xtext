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
		var typeReference = createTypeReference();
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference));
		JvmTypeReferenceUtil.setExpectedAsClass(typeReference);
		assertTrue(JvmTypeReferenceUtil.isExpectedAsClass(typeReference));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference));
	}

	@Test
	public void testExpectedAsInterface() {
		var typeReference = createTypeReference();
		assertFalse(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference));
		JvmTypeReferenceUtil.setExpectedAsInterface(typeReference);
		assertTrue(JvmTypeReferenceUtil.isExpectedAsInterface(typeReference));
		assertFalse(JvmTypeReferenceUtil.isExpectedAsClass(typeReference));
	}

	private JvmParameterizedTypeReference createTypeReference() {
		return TypesFactory.eINSTANCE.createJvmParameterizedTypeReference();
	}
}
