/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.access.binary.asm.BinarySignatures;
import org.eclipse.xtext.common.types.access.binary.asm.BinaryTypeSignature;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinarySignaturesTest {

	@Test
	public void testNestedTypeWithOuterGenerics() {
		String signature = "Lcom/google/common/collect/AbstractMultimap<TK;TV;>.WrappedCollection;";
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(signature);
		BinaryTypeSignature typeErasure = typeSignature.getTypeErasure();
		String identifier = typeErasure.toIdentifier();
		Assert.assertEquals("com.google.common.collect.AbstractMultimap$WrappedCollection", identifier);
	}
	
	@Test
	public void testClassesInDefaultPackage_01() {
		String signature = "LDummyService;";
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(signature);
		Assert.assertEquals("java:/Objects/DummyService#DummyService", typeSignature.getURI().toString());
	}
	
	@Test
	public void testClassesInDefaultPackage_02() {
		String signature = "DummyService";
		BinaryTypeSignature typeSignature = BinarySignatures.createObjectTypeSignature(signature);
		Assert.assertEquals("java:/Objects/DummyService#DummyService", typeSignature.getURI().toString());
	}
	
	@Test
	public void testDoubleSignature() {
		String signature = "D";
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(signature);
		Assert.assertEquals("java:/Primitives#double", typeSignature.getURI().toString());
	}
	
	@Test
	public void testSingleCharInDefaultPackage_01() {
		String signature = "LD;";
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(signature);
		Assert.assertEquals("java:/Objects/D#D",typeSignature.getURI().toString());
	}
	
	@Test
	public void testSingleCharInDefaultPackage_02() {
		String signature = "D";
		BinaryTypeSignature typeSignature = BinarySignatures.createObjectTypeSignature(signature);
		Assert.assertEquals("java:/Objects/D#D", typeSignature.getURI().toString());
	}
	
}
