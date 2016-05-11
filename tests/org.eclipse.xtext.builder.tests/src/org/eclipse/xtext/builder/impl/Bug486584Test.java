/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class Bug486584Test extends AbstractBuilderTest {
	
	private static final String PROJECT_NAME = "foo";
	private static final String XTEND_EXAMPLE_JAR = "XtendExample.jar";
	private static final String SRC_FOLDER = "src";
	
	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		getBuilderState().addListener(this);
	}
	
	@Test
	public void testFullBuildWhenClasspathChanged() throws CoreException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		waitForBuild();
		assertFalse(getEvents().isEmpty());
		
	}
	
	@Test
	public void testNoFullBuildIfAttachmentChangeOnly() throws CoreException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		waitForBuild();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		
		IClasspathEntry[] classpath = project.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (libraryEntry.getPath().equals(entryPath)) {
				IClasspathEntry[] newClasspath = new IClasspathEntry[classpath.length];
				System.arraycopy(classpath, 0, newClasspath, 0, classpath.length);
				
				classpath[i] = JavaCore.newLibraryEntry(libaryFile.getFullPath(), libaryFile.getFullPath(), null);
				project.setRawClasspath(classpath, null);

			}
		}
		waitForBuild();
		assertTrue(getEvents().isEmpty());
	}
	
	private IFile copyAndGetXtendExampleJar(IJavaProject javaProject) throws CoreException {
		IFile file = javaProject.getProject().getFile(XTEND_EXAMPLE_JAR);
		InputStream inputStream = Bug486584Test.class.getResourceAsStream(XTEND_EXAMPLE_JAR);
		file.create(inputStream, IResource.FORCE, null);
		return file;
	}
	
	private IJavaProject setupProject() throws CoreException {
		IJavaProject project = createJavaProject(PROJECT_NAME);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addBuilder(project.getProject(), XtextProjectHelper.BUILDER_ID);
		IFolder folder = project.getProject().getFolder(SRC_FOLDER);
		addFile(folder, "source", "namespace bar { object B }");
		ResourcesPlugin.getWorkspace().build(
				IncrementalProjectBuilder.AUTO_BUILD, monitor());
		return project;
	}

	private void addFile(IFolder folder, String fileName, String content) throws CoreException {
		IFile file = folder.getFile(fileName + F_EXT);
		file.create(new StringInputStream(content), true, monitor());
		waitForBuild();
	}
}
