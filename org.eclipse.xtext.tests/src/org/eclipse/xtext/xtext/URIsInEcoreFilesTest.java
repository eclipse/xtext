/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.xtext.tests.AbstractPortableURIsTest;
import org.junit.Test;

/**
 * @author zarnekow - Initial contribution and API
 */
// UI Test
public class URIsInEcoreFilesTest extends AbstractPortableURIsTest {
	
	@Test public void testXtext() {
		doTestResource("org.eclipse.xtext/org/eclipse/xtext/Xtext.ecore", "xtext");
	}
	
	@Test public void testXtextGenmodel() {
		doTestResource("org.eclipse.xtext/org/eclipse/xtext/Xtext.genmodel", "xtext");
	}
	
	@Override
	protected Object getClasspathURIContext() {
		try {
			return new URLClassLoader(new URL[] {new File("../org.eclipse.xtext").toURI().toURL()}, getClass().getClassLoader());
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
