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
		TypeVariable typeVariable = TypesFactory.eINSTANCE.createTypeVariable();
		typeVariable.setName("T");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeVariables().add(typeVariable);
		assertEquals("java.util.List<T>", genericType.getCanonicalName());
	}
	
	public void testCanonicalName_05() {
		TypeVariable typeVariable1 = TypesFactory.eINSTANCE.createTypeVariable();
		typeVariable1.setName("T1");
		TypeVariable typeVariable2 = TypesFactory.eINSTANCE.createTypeVariable();
		typeVariable2.setName("T2");
		genericType.setFullyQualifiedName("java.util.List");
		genericType.getTypeVariables().add(typeVariable1);
		genericType.getTypeVariables().add(typeVariable2);
		assertEquals("java.util.List<T1, T2>", genericType.getCanonicalName());
	}
	
}
