/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.tests.ui.builder;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.xtext.xtend2.tests.ui.AbstractXtend2WorkspaceTestCase;
import org.eclipse.xtext.xtend2.ui.builder.FolderUtil;

import com.google.inject.Inject;


/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class FolderUtilTest extends AbstractXtend2WorkspaceTestCase {

	@Inject
	protected FolderUtil folderUtil;
	
	public void testClearFolder() throws Exception {
		createProject("test");
		IFolder one = createFolder("/test/one");
		IFolder two = createFolder("/test/one/two");
		IFolder three = createFolder("/test/three");
		IFile file = createFile("/test/one/file.txt", "");
		folderUtil.clearFolder(one, null);
		assertTrue(one.exists());
		assertFalse(two.exists());
		assertTrue(three.exists());
		assertFalse(file.exists());
	}
	
	public void testRemoveEmptySubFolders() throws Exception {
		createProject("test");
		IFolder one = createFolder("/test/one");
		IFolder two = createFolder("/test/one/two");
		IFolder three = createFolder("/test/one/two/three");
		IFile file = createFile("/test/one/four/file.txt", "");
		folderUtil.removeEmptySubFolders(one, null);
		assertTrue(one.exists());
		assertFalse(three.exists());
		assertFalse(two.exists());
		assertTrue(file.exists());
	}
	
	public void testCreateParentFolders() throws Exception {
		IProject project = createProject("test");
		IFolder one = project.getFolder("/one");
		IFolder two = project.getFolder("/one/two");
		assertFalse(one.exists());
		assertFalse(two.exists());
		folderUtil.createParentFolders(two, null);
		assertTrue(one.exists());
		assertFalse(two.exists());
		
		IFolder three = two.getFolder("three");
		IFile file = two.getFile("three/file.txt");
		assertFalse(three.exists());
		assertFalse(file.exists());
		folderUtil.createParentFolders(file, null);
		assertTrue(three.exists());
		assertFalse(file.exists());
	}
}
