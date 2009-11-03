/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IStorage;
import org.eclipse.jdt.core.IJarEntryResource;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.junit.util.JavaProjectSetupUtil;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IStorageUtilTest extends TestCase {
	
	@Override
	protected void tearDown() throws Exception {
		cleanWorkspace();
		super.tearDown();
	}
	
	public void testForIFile() throws Exception {
		IFile file = createFile("foo/bar/Baz.txt", "Moin!");
		
		StorageUtil storageUtil = new StorageUtil();
		String string = storageUtil.toExternalString(file);
		assertEquals(file, storageUtil.getStorage(string));
	}
	
	public void testForIJarEntry() throws Exception {
		IJavaProject project = JavaProjectSetupUtil.createJavaProject("foo");
		String jarName = "JarWalkerTest.jar";
		IFile file = project.getProject().getFile(jarName);
		file.create(getClass().getResourceAsStream(jarName), true, new org.eclipse.core.runtime.NullProgressMonitor());
		JavaProjectSetupUtil.addJarToClasspath(project, file);
		
		final List<IJarEntryResource> resources = new ArrayList<IJarEntryResource>();
		new JarWalker() {
			@Override
			protected void handle(IJarEntryResource jarEntry) {
				resources.add(jarEntry);
			}
		}.traverseAllJars(project.getProject());

//		Assertion does not hold on build server due to other jars in the jdk
//		assertEquals(312,resources.size());
		StorageUtil storageUtil = new StorageUtil(); 
		for (IJarEntryResource entry : resources) {
			String externalString = storageUtil.toExternalString(entry);
			IStorage storage = storageUtil.getStorage(externalString);
			assertEquals(entry, storage);
		}
		
	}
}
