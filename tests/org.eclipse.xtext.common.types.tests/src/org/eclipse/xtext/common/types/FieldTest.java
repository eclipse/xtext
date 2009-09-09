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
public class FieldTest extends TestCase {

	private Field field;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		field = TypesFactory.eINSTANCE.createField();
	}
	
	public void testCanonicalName_01() {
		assertNull(field.getCanonicalName(), field.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		field.setName("name");
		assertEquals("name", field.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		field.setName("name");
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.lang.String");
		TypeReference typeReference = TypesFactory.eINSTANCE.createTypeReference();
		typeReference.setType(genericType);
		field.setType(typeReference);
		assertEquals("name", field.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		GenericType genericType = TypesFactory.eINSTANCE.createGenericType();
		genericType.setFullyQualifiedName("java.lang.String");
		field.setDeclaringType(genericType);
		field.setName("name");
		assertEquals("java.lang.String.name", field.getCanonicalName());
	}
}
