/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.compiler;

import java.util.List;

import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.common.types.JvmType;
import org.eclipse.xtext.common.types.util.TypeReferences;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.compiler.ImportManager;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;

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
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		expression = expression("null");
		fooClass = (JvmDeclaredType) typeReferences.findDeclaredType(foo.TestClass.class, expression);
		importManager = new ImportManager(true, fooClass);
	}
	
	public void testJavaLangString() throws Exception {
		JvmType string = typeReferences.findDeclaredType("java.lang.String", expression);
		assertEquals("String", importManager.serialize(string).toString());
		assertTrue(importManager.getImports().isEmpty());
	}

	public void testOtherString() {
		JvmType otherString = typeReferences.findDeclaredType(foo.String.class, expression);
		assertEquals("foo.String", importManager.serialize(otherString).toString());
		assertTrue(importManager.getImports().isEmpty());
	}
	
	public void testThisClass() throws Exception {
		assertEquals("TestClass", importManager.serialize(fooClass).toString());
		assertTrue(importManager.getImports().toString(), importManager.getImports().isEmpty());
	}
	
	public void testThisClassNameClash() throws Exception {
		JvmType fooBarClass = typeReferences.findDeclaredType(foo.bar.TestClass.class, expression);
		assertEquals("foo.bar.TestClass", importManager.serialize(fooBarClass).toString());
		assertTrue(importManager.getImports().isEmpty());
	}

	public void testOtherPackage() throws Exception {
		JvmType string = typeReferences.findDeclaredType(List.class, expression);
		assertEquals("List", importManager.serialize(string).toString());
		assertTrue(importManager.getImports().contains("java.util.List"));
	}
	
}
