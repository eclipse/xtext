/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class URIsInEcoreFilesTest extends AbstractPortableURIsTest {

	@Test public void testXbase() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.ecore", "xbase");
	}
	
	@Test public void testXtype() {
		doTestResource("org.eclipse.xtext.xbase/model/Xtype.ecore", "xtype");
	}
	
	@Test public void testXbaseWithAnnotations() {
		doTestResource("org.eclipse.xtext.xbase/model/XAnnotations.ecore", "xAnnotations");
	}
	
	@Test public void testXbaseGenmodel() {
		doTestResource("org.eclipse.xtext.xbase/model/Xbase.genmodel", "xbase", "xtype", "xAnnotations");
	}
	
	@Test public void testCommonTypes() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.ecore", "types");
	}

	@Test public void testCommonTypesGenModel() {
		doTestResource("org.eclipse.xtext.common.types/model/JavaVMTypes.genmodel", "types");
	}
	
	@Override
	protected Object getClasspathURIContext() {
		try {
			return new URLClassLoader(new URL[] {new File("../org.eclipse.xtext.xbase").toURI().toURL(), new File("../org.eclipse.xtext.common.types").toURI().toURL()}, getClass().getClassLoader());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
