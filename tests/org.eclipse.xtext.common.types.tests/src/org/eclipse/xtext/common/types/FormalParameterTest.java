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
public class FormalParameterTest extends TestCase {

	private FormalParameter formalParameter;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		formalParameter = TypesFactory.eINSTANCE.createFormalParameter();
	}
	
	public void testCanonicalName_01() {
		assertNull(formalParameter.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		formalParameter.setName("param");
		assertNull(formalParameter.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		TypeParameter typeParameter = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter.setName("T");
		formalParameter.setName("param");
		SimpleTypeReference typeReference = TypesFactory.eINSTANCE.createSimpleTypeReference();
		typeReference.setType(typeParameter);
		formalParameter.setParameterType(typeReference);
		assertEquals("T", formalParameter.getCanonicalName());
	}
}
