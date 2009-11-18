/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.util;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;
import junit.framework.TestCase;

import org.eclipse.jdt.core.IJavaProject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class JdtUtilTest extends TestCase {
	
	public void testIsInSrcFolder() throws Exception{
		IJavaProject project = createJavaProject("foo");
		addSourceFolder(project, "src");
		addSourceFolder(project, "src-gen");
		assertFalse(JdtUtil.isInSourceFolder(project, createFile("foo/bar.text", "")));
		assertFalse(JdtUtil.isInSourceFolder(project, createFile("foo/baz/bar.text", "")));
		assertTrue(JdtUtil.isInSourceFolder(project, createFile("foo/src/bar.text", "")));
		assertTrue(JdtUtil.isInSourceFolder(project, createFile("foo/src-gen/bar.text", "")));
	}
}
