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
public class GenericTypeTest extends TestCase {

	private GenericType genericType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		genericType = TypesFactory.eINSTANCE.createGenericType();
	}
	
	public void testCanonicalName_01() {
		assertNull(genericType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		genericType.setFullyQualifiedName("java.util.List");
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		GenericType outerType = TypesFactory.eINSTANCE.createGenericType();
		outerType.getMembers().add(genericType);
		genericType.setFullyQualifiedName("java.util.List.ListElement");
		assertEquals("java.util.List.ListElement", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_04() {
		TypeParameter typeParameter = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter.setName("T");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeParameters().add(typeParameter);
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_05() {
		TypeParameter typeParameter1 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter1.setName("T1");
		TypeParameter typeParameter2 = TypesFactory.eINSTANCE.createTypeParameter();
		typeParameter2.setName("T2");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeParameters().add(typeParameter1);
		genericType.getTypeParameters().add(typeParameter2);
		assertEquals("java.util.List", genericType.getCanonicalName());
	}
	
}
