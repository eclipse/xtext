/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
