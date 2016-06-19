/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Dennis Huebner (dhubner) - Initial contribution and API
 */
public class BasicDependencyCheckTest {

	/**
	 * Check that org.eclipse.xtext.xbase doesn't depend on org.eclipse.jdt.core
	 * see Bug [364082] Optional dependency to JDT from xbase core bundle
	 */
	@Test
	@Ignore("https://github.com/eclipse/xtext-extras/issues/10")
	public void testJavaCoreNotOnClassPath() {
		try {
			ClassLoader classLoader = org.eclipse.xtext.xbase.XbaseRuntimeModule.class.getClassLoader();
			classLoader.loadClass("org.eclipse.jdt.core.JavaCore");
			fail("org.eclipse.jdt.core.JavaCore should not be accessable/loadable from the xbase core bundle");
		} catch (ClassNotFoundException e) {
			// Good - test passed
		}
	}

}
