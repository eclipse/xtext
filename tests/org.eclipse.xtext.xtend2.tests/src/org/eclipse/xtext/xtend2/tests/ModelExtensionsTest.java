/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests;

import java.util.List;

import org.eclipse.xtext.common.types.JvmTypeReference;
import org.eclipse.xtext.xtend2.xtend2.Xtend2Factory;
import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;
import org.eclipse.xtext.xtend2.xtend2.XtendImport;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ModelExtensionsTest extends AbstractXtend2TestCase {
	
	@Inject
	protected Xtend2Factory factory;
	
	public void testXtendClass() throws Exception {
		XtendFile file = file("package foo class Bar extends Object implements java.io.Serializable {}");
		XtendClass xtendClass = file.getXtendClass();
		assertEquals("foo.Bar", xtendClass.getIdentifier());
		assertEquals("foo", xtendClass.getPackageName());
		assertEquals("Bar", xtendClass.getSimpleName());
		List<JvmTypeReference> superTypes = xtendClass.getSuperTypes();
		assertEquals(2, superTypes.size());
		assertEquals("java.lang.Object", superTypes.get(0).getQualifiedName());
		assertEquals("java.io.Serializable", superTypes.get(1).getQualifiedName());
	}
	
	public void testXtendFunction() throws Exception {
		XtendFile file = file("package foo class Bar { int foo() 1}");
		XtendFunction xtendFunction = (XtendFunction) file.getXtendClass().getMembers().get(0);
		assertEquals("foo", xtendFunction.getSimpleName());
		assertEquals("foo.Bar.foo()", xtendFunction.getIdentifier());
	}
	
	public void testXtendImport() throws Exception {
		XtendImport xtendImport = factory.createXtendImport();
		assertFalse(xtendImport.isWildcard());
		assertNull(xtendImport.getImportedTypeName());
		xtendImport.setImportedNamespace("");
		assertFalse(xtendImport.isWildcard());
		assertEquals("", xtendImport.getImportedTypeName());
		xtendImport.setImportedNamespace("java.lang.Collections.*");
		assertTrue(xtendImport.isWildcard());
		assertEquals("java.lang.Collections", xtendImport.getImportedTypeName());
	}
}
