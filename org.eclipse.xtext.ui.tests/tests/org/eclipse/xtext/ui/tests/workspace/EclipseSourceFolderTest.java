/*******************************************************************************
 * Copyright (c) 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.testing.AbstractWorkbenchTest;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.workspace.EclipseSourceFolder;
import org.junit.Test;

/**
 * @author Lorenzo Bettini - Initial contribution and API
 */
public class EclipseSourceFolderTest extends AbstractWorkbenchTest {

	@Test
	public void testEclipseSourceFolderTrailingPathSeparator() throws CoreException {
		IProject project = JavaProjectSetupUtil.createJavaProject("aproject").getProject();
		EclipseSourceFolder sourceFolderWithoutTrailingSlash = new EclipseSourceFolder(
			project, "afolder");
		EclipseSourceFolder sourceFolderWithTrailingSlash = new EclipseSourceFolder(
			project, "afolder/");
		assertEquals("project P/aproject name afolder (platform:/resource/aproject/afolder/)",
			sourceFolderWithoutTrailingSlash.toString());
		// no double trailing path separator
		// see https://github.com/eclipse/xtext-eclipse/issues/1997
		assertEquals("project P/aproject name afolder/ (platform:/resource/aproject/afolder/)",
			sourceFolderWithTrailingSlash.toString());

		// equals must be based on path
		assertEquals(sourceFolderWithTrailingSlash, sourceFolderWithoutTrailingSlash);
		// hashCode must be based on path
		assertEquals(sourceFolderWithTrailingSlash.hashCode(), sourceFolderWithoutTrailingSlash.hashCode());
	}
}
