/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ReferenceTypeArgumentTest extends TestCase {

	private ReferenceTypeArgument typeArgument;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeArgument = TypesFactory.eINSTANCE.createReferenceTypeArgument();
	}
	
	public void testCanonicalName_01() {
		assertNull(typeArgument.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		typeArgument.setTypeReference(TypesFactory.eINSTANCE.createSimpleTypeReference());
		assertNull(typeArgument.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		SimpleTypeReference typeReference = TypesFactory.eINSTANCE.createSimpleTypeReference();
		typeReference.setType(TypesFactory.eINSTANCE.createVoid());
		typeArgument.setTypeReference(typeReference);
		assertEquals("void", typeArgument.getCanonicalName());
	}
}
