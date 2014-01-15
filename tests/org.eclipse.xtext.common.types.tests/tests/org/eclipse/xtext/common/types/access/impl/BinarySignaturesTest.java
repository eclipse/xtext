/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.eclipse.xtext.common.types.access.binary.signatures.BinarySignatures;
import org.eclipse.xtext.common.types.access.binary.signatures.BinaryTypeSignature;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BinarySignaturesTest {

	@Test
	public void testNestedTypeWithOuterGenerics() {
		char[] signature = "Lcom/google/common/collect/AbstractMultimap<TK;TV;>.WrappedCollection;".toCharArray();
		BinaryTypeSignature typeSignature = BinarySignatures.createTypeSignature(signature);
		BinaryTypeSignature typeErasure = typeSignature.getTypeErasure();
		String identifier = typeErasure.toIdentifier();
		Assert.assertEquals("com.google.common.collect.AbstractMultimap$WrappedCollection", identifier);
	}
	
}
