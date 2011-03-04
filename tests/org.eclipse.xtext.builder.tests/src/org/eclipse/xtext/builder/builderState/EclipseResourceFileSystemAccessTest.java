/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
import org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class EclipseResourceFileSystemAccessTest extends TestCase {

	@Override
	protected void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	public void testDirsAreCreated() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("test");
		EclipseResourceFileSystemAccess fileSystemAccess = new EclipseResourceFileSystemAccess();
		fileSystemAccess.setRoot(ResourcesPlugin.getWorkspace().getRoot());
		fileSystemAccess.setOutputPath("test");
		fileSystemAccess.generateFile("tmp/X", "XX");
		IFolder dir = project.getFolder("tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("X");
		assertTrue(file.exists());
	}
}
