/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests;

import org.eclipse.xtext.xtend2.xtend2.XtendClass;
import org.eclipse.xtext.xtend2.xtend2.XtendFile;
import org.eclipse.xtext.xtend2.xtend2.XtendFunction;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ModelExtensionsTest extends AbstractXtend2TestCase {
	
	public void testXtendClass() throws Exception {
		XtendFile file = file("package foo class Bar extends Object implements java.io.Serializable {}");
		XtendClass xtendClass = file.getXtendClass();
		assertEquals("foo.Bar", xtendClass.getIdentifier());
		assertEquals("foo", xtendClass.getPackageName());
		assertEquals("Bar", xtendClass.getSimpleName());
		// TODO: enable supertypes
//		EList<JvmTypeReference> superTypes = xtendClass.getSuperTypes();
//		assertEquals(2, superTypes.size());
//		assertEquals("java.lang.Object", superTypes.get(0).getCanonicalName());
//		assertEquals("java.io.Serializable", superTypes.get(1).getCanonicalName());
	}
	
	
	public void testXtendFunction() throws Exception {
		XtendFile file = file("package foo class Bar { int foo() 1}");
		XtendFunction xtendFunction = (XtendFunction) file.getXtendClass().getMembers().get(0);
		assertEquals("foo", xtendFunction.getSimpleName());
		assertEquals("foo.Bar.foo", xtendFunction.getIdentifier());
	}
}
