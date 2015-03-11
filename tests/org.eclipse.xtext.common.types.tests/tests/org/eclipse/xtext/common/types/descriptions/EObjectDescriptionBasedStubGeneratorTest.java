/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.descriptions;

import java.util.Collections;

import org.eclipse.xtext.common.types.TypesFactory;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class EObjectDescriptionBasedStubGeneratorTest {
	
	private EObjectDescriptionBasedStubGenerator gen = new EObjectDescriptionBasedStubGenerator();

	EObjectDescription _class = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.<String,String>emptyMap());
	EObjectDescription _class_with_typeParam = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.TYPE_PARAMETERS, "<A,B>"));
	EObjectDescription _nested_class = new EObjectDescription(QualifiedName.create("foo","Bar$Baz"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_NESTED_TYPE, Boolean.TRUE.toString()));
	EObjectDescription _interface = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmGenericType(), Collections.singletonMap(JvmTypesResourceDescriptionStrategy.IS_INTERFACE, Boolean.TRUE.toString()));
	EObjectDescription _enum = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmEnumerationType(), Collections.<String,String>emptyMap());
	EObjectDescription _annotation = new EObjectDescription(QualifiedName.create("foo","Bar"), TypesFactory.eINSTANCE.createJvmAnnotationType(), Collections.<String,String>emptyMap());
	
	@Test
	public void testStubGenerator() throws Exception {
		assertEquals("package foo;\npublic class Bar{}",gen.getJavaStubSource(_class));
		assertEquals("package foo;\npublic class Bar<A,B>{}",gen.getJavaStubSource(_class_with_typeParam));
		assertNull(gen.getJavaStubSource(_nested_class));
		assertEquals("package foo;\npublic interface Bar{}",gen.getJavaStubSource(_interface));
		assertEquals("package foo;\npublic enum Bar{}",gen.getJavaStubSource(_enum));
		assertEquals("package foo;\npublic @interface Bar{}",gen.getJavaStubSource(_annotation));
	}
}
