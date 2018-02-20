/*******************************************************************************
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Files;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class Bug486584Test extends AbstractBuilderTest {

	private static final String PROJECT_NAME = "foo";
	private static final String XTEND_EXAMPLE_JAR = "XtendExample.jar";
	private static final String SRC_FOLDER = "src";
	private static int projectCounter = 0;
	private List<IResourceChangeListener> resourceChangeListeners = new ArrayList<>();

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
		getBuilderState().addListener(this);
	}

	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		for (IResourceChangeListener l : resourceChangeListeners) {
			ResourcesPlugin.getWorkspace().removeResourceChangeListener(l);
		}
		resourceChangeListeners.clear();
	}

	@Test
	public void testFullBuildWhenClasspathChanged() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		final CountDownLatch latch = createWaitForFullBuildLatch(project);
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		// wait for FORGET_BUILD_STATE_ONLY
		latch.await(300, TimeUnit.MILLISECONDS);
		assertEquals("no fullbuild sheduled", 0l, latch.getCount());
		waitForBuild();
		assertFalse(getEvents().isEmpty());

	}

	@Test
	public void testNoFullBuildIfAttachmentChangeOnly() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		waitForBuild();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		final CountDownLatch latch = createWaitForFullBuildLatch(project);
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
		// wait for FORGET_BUILD_STATE_ONLY
		latch.await(300, TimeUnit.MILLISECONDS);
		assertEquals("no fullbuild sheduled", 1l, latch.getCount());
		waitForBuild();
		assertTrue(getEvents().isEmpty());
	}

	@Test
	public void testFullBuildWhenClasspathChanged_2() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		waitForBuild();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();

		final CountDownLatch latch = createWaitForFullBuildLatch(project);
		libaryFile.touch(null);
		libaryFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		// wait for FORGET_BUILD_STATE_ONLY
		latch.await(300, TimeUnit.MILLISECONDS);
		assertEquals("no fullbuild sheduled", 0l, latch.getCount());
		waitForBuild();
		assertFalse(getEvents().isEmpty());

	}

	@Test
	public void testFullBuildWhenClasspathChanged_3() throws CoreException, IOException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IPath rawLocation = libaryFile.getRawLocation();
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(rawLocation, null, null);
		addToClasspath(project, libraryEntry);
		waitForBuild();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();

		final CountDownLatch latch = createWaitForFullBuildLatch(project);
		File file = rawLocation.toFile();
		Files.touch(file);
		project.setRawClasspath(project.getRawClasspath(), null);
		project.getProject().getFile("src/dummy.txt").create(new StringInputStream(""), false, null);
		project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		// wait for FORGET_BUILD_STATE_ONLY
		latch.await(300, TimeUnit.MILLISECONDS);
		assertEquals("no fullbuild sheduled", 0l, latch.getCount());
		waitForBuild();
		assertFalse(getEvents().isEmpty());

	}

	private IFile copyAndGetXtendExampleJar(IJavaProject javaProject) throws CoreException {
		IFile file = javaProject.getProject().getFile(XTEND_EXAMPLE_JAR);
		InputStream inputStream = Bug486584Test.class.getResourceAsStream(XTEND_EXAMPLE_JAR);
		file.create(inputStream, IResource.FORCE, null);
		return file;
	}

	private IJavaProject setupProject() throws CoreException {
		IJavaProject project = createJavaProject(PROJECT_NAME + projectCounter++);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addBuilder(project.getProject(), XtextProjectHelper.BUILDER_ID);
		IFolder folder = project.getProject().getFolder(SRC_FOLDER);
		addFile(folder, "source", "namespace bar { object B }");
		ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.AUTO_BUILD, monitor());
		return project;
	}

	private void addFile(IFolder folder, String fileName, String content) throws CoreException {
		IFile file = folder.getFile(fileName + F_EXT);
		file.create(new StringInputStream(content), true, monitor());
		waitForBuild();
	}

	private CountDownLatch createWaitForFullBuildLatch(IJavaProject project) {
		final CountDownLatch latch = new CountDownLatch(1);
		addResourceChangeListener(new IResourceChangeListener() {
			@Override
			public void resourceChanged(IResourceChangeEvent event) {
				if (event.getBuildKind() == IncrementalProjectBuilder.FULL_BUILD) {
					if (project.getProject() == event.getSource()) {
						latch.countDown();
					}
				}
			}
		}, IResourceChangeEvent.POST_BUILD);
		return latch;
	}

	private void addResourceChangeListener(IResourceChangeListener l, int eventMask) {
		resourceChangeListeners.add(l);
		ResourcesPlugin.getWorkspace().addResourceChangeListener(l, eventMask);
	}

}
