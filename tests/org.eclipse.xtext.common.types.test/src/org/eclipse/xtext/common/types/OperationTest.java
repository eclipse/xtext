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
public class OperationTest extends TestCase {

	private Operation operation;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		operation = TypesFactory.eINSTANCE.createOperation();
	}
	
	public void testCanonicalName_01() {
		assertNull(operation.getCanonicalName(), operation.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		operation.setName("getName");
		assertEquals("getName()", operation.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		operation.setName("getName");
		FormalParameter parameter = TypesFactory.eINSTANCE.createFormalParameter();
		parameter.setName("param");
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.lang.String");
		TypeReference typeReference = TypesFactory.eINSTANCE.createTypeReference();
		typeReference.setType(genericType);
		parameter.setParameterType(typeReference);
		operation.getParameters().add(parameter);
		assertEquals("getName(java.lang.String)", operation.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.lang.String");
		operation.setDeclaringType(genericType);
		operation.setName("getName");
		assertEquals("java.lang.String.getName()", operation.getCanonicalName());
	}
	
}
