/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests;

import java.util.List;

import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendFactory;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendImport;
import org.eclipse.xtext.common.types.JvmTypeReference;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ModelExtensionsTest extends AbstractXtendTestCase {
	
	@Inject
	protected XtendFactory factory;
	
	@Test public void testXtendClass() throws Exception {
		XtendFile file = file("package foo class Bar extends Object implements java.io.Serializable {}");
		XtendClass xtendClass = (XtendClass) file.getXtendTypes().get(0);
		assertEquals("foo", file.getPackage());
		assertEquals("Bar", xtendClass.getName());
		assertEquals("java.lang.Object", xtendClass.getExtends().getQualifiedName());
		assertEquals("java.io.Serializable", xtendClass.getImplements().get(0).getQualifiedName());
	}
	
	@Test public void testXtendFunction() throws Exception {
		XtendFile file = file("package foo class Bar { def int foo() {1}}");
		XtendFunction xtendFunction = (XtendFunction) ((XtendClass) file.getXtendTypes().get(0)).getMembers().get(0);
		assertEquals("foo", xtendFunction.getName());
	}
	
	@Test public void testXtendImport() throws Exception {
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
