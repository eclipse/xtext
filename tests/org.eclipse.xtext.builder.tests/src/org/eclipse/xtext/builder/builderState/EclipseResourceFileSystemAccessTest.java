/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

import static com.google.common.collect.Lists.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.util.IAcceptor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class EclipseResourceFileSystemAccessTest extends Assert {

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test public void testDirsAreCreated() throws Exception {
		IProject project = IResourcesSetupUtil.createProject("test");
		EclipseResourceFileSystemAccess fileSystemAccess = new EclipseResourceFileSystemAccess();
		fileSystemAccess.setRoot(ResourcesPlugin.getWorkspace().getRoot());
		fileSystemAccess.setOutputPath("test");
		final List<String> newFiles = newArrayList();
		fileSystemAccess.setNewFileAcceptor(new IAcceptor<String>() {
			@Override
			public void accept(String t) {
				newFiles.add(t);
			}
		});
		fileSystemAccess.generateFile("tmp/X", "XX");
		IFolder dir = project.getFolder("tmp");
		assertTrue(dir.exists());
		IFile file = dir.getFile("X");
		assertTrue(file.exists());
		assertEquals(1, newFiles.size());
		assertTrue(newFiles.contains("/test/tmp/X"));
	}
}
