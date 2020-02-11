/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ImportManagerTest extends AbstractXbaseTestCase {

	private ImportManager importManager;

	@Inject
	private TypeReferences typeReferences;

	private XExpression expression;

	private JvmDeclaredType fooClass;
	
	@Before
	public void setUp() throws Exception {
		expression = expression("null");
		fooClass = (JvmDeclaredType) typeReferences.findDeclaredType(foo.TestClass.class, expression);
		importManager = new ImportManager(true, fooClass);
	}
	
	@Test public void testJavaLangString() throws Exception {
		JvmType string = typeReferences.findDeclaredType("java.lang.String", expression);
		assertEquals("String", importManager.serialize(string).toString());
		assertTrue(importManager.getImports().isEmpty());
	}

	@Test public void testOtherString() {
		JvmType otherString = typeReferences.findDeclaredType(foo.String.class, expression);
		assertEquals("foo.String", importManager.serialize(otherString).toString());
		assertTrue(importManager.getImports().isEmpty());
	}
	
	@Test public void testJavaLangStringFromOtherString() {
		JvmType otherString = typeReferences.findDeclaredType(foo.String.class, expression);
		ImportManager importManager2 = new ImportManager(true, (JvmDeclaredType) otherString);
		JvmType javaLangString = typeReferences.findDeclaredType("java.lang.String", expression);
		assertEquals("java.lang.String", importManager2.serialize(javaLangString).toString());
		assertTrue(importManager2.getImports().isEmpty());
	}
	
	@Test public void testThisClass() throws Exception {
		assertEquals("TestClass", importManager.serialize(fooClass).toString());
		assertTrue(importManager.getImports().toString(), importManager.getImports().isEmpty());
	}
	
	@Test public void testThisClassNameClash() throws Exception {
		JvmType fooBarClass = typeReferences.findDeclaredType(foo.bar.TestClass.class, expression);
		assertEquals("foo.bar.TestClass", importManager.serialize(fooBarClass).toString());
		assertTrue(importManager.getImports().isEmpty());
	}

	@Test public void testOtherPackage() throws Exception {
		JvmType string = typeReferences.findDeclaredType(List.class, expression);
		assertEquals("List", importManager.serialize(string).toString());
		assertTrue(importManager.getImports().contains("java.util.List"));
	}
	
}
