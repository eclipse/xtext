/*******************************************************************************
 * Copyright (c) 2016, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.junit.Assert.*;
import static org.junit.Assume.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Version;

import com.google.common.collect.ImmutableList;

/**
 * @author Christian Dietrich - Initial contribution and API
 */
public class Bug486584Test extends AbstractBuilderTest {

	private static final String PROJECT_NAME = "foo";
	private static final String XTEND_EXAMPLE_JAR = "XtendExample.jar";
	private static final String SRC_FOLDER = "src";
	private static final String SRC2_FOLDER = "src2";
	private static int projectCounter = 0;
	private final static IAccessRule[] NO_ACCESS_RULES = {};

	@Before
	public void addListener() throws Exception {
		getBuilderState().addListener(this);
	}

	@After
	public void removeListener() throws Exception {
		getBuilderState().removeListener(this);
	}

	@Test
	public void testFullBuildWhenClasspathChanged_1() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		assertEquals(1, getEvents().size());
		Event singleEvent = getEvents().get(0);
		ImmutableList<Delta> deltas = singleEvent.getDeltas();
		assertEquals(1, deltas.size());
	}

	@Test
	public void testNoFullBuildIfAttachmentChangeOnly() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertEquals(1, getEvents().size());
		Event singleEvent = getEvents().get(0);
		ImmutableList<Delta> deltas = singleEvent.getDeltas();
		assertEquals(1, deltas.size());
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
		build();
		assertEquals(0, getEvents().size());
	}
	
	@Test
	public void testNoFullBuildIfJavadocChangeOnly() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null, NO_ACCESS_RULES, new IClasspathAttribute[0], false);
		addToClasspath(project, libraryEntry);
		build();
		assertEquals(1, getEvents().size());
		Event singleEvent = getEvents().get(0);
		ImmutableList<Delta> deltas = singleEvent.getDeltas();
		assertEquals(1, deltas.size());
		getEvents().clear();
		IClasspathEntry[] classpath = project.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (libraryEntry.getPath().equals(entryPath)) {
				IClasspathAttribute[] attr = new IClasspathAttribute[1];
				attr[0] = JavaCore.newClasspathAttribute(IClasspathAttribute.JAVADOC_LOCATION_ATTRIBUTE_NAME, libaryFile.getFullPath().toString());
				classpath[i] = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null, NO_ACCESS_RULES, attr , false);
				project.setRawClasspath(classpath, null);
				
			}
		}
		build();
		assertEquals(0, getEvents().size());
	}
	
	@Test
	public void testFullBuildWhenTestAttributeChanges() throws Exception {
		assumeTrue(JavaCore.getPlugin().getBundle().getVersion().compareTo(new Version(3,33,0)) >= 0);
		IJavaProject project = setupProject();
		// create src2 folder and give it a separate output folder
		addSourceFolder(project, SRC2_FOLDER);
		IClasspathEntry[] classpath = project.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (entryPath != null && entryPath.toString().endsWith(SRC2_FOLDER)) {
				classpath[i] = JavaCore.newSourceEntry(entryPath, new IPath[] {}, new IPath[] {}, project.getPath().append("bin-test"));
			}
		}
		project.setRawClasspath(classpath, null);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		build();
		// toggle thee test flag for src2 folder
		classpath = project.getRawClasspath();
		for (int i = 0; i < classpath.length; ++i) {
			IPath entryPath = classpath[i].getPath();
			if (entryPath != null && entryPath.toString().endsWith(SRC2_FOLDER)) {
				IClasspathAttribute[] attr = new IClasspathAttribute[1];
				attr[0] = JavaCore.newClasspathAttribute(IClasspathAttribute.TEST, "true");
				classpath[i] = JavaCore.newSourceEntry(entryPath, new IPath[] {}, new IPath[] {}, project.getPath().append("bin-test"), attr);
			}
		}
		project.setRawClasspath(classpath, null);
		build();
		assertEquals(1, getEvents().size());
		Event singleEvent = getEvents().get(0);
		ImmutableList<Delta> deltas = singleEvent.getDeltas();
		assertEquals(1, deltas.size());
	}

	@Test
	public void testFullBuildWhenClasspathChanged_2() throws CoreException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(libaryFile.getFullPath(), null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();

		libaryFile.touch(null);
		libaryFile.refreshLocal(IResource.DEPTH_INFINITE, null);
		build();
		assertEquals(1, getEvents().size());
		Event singleEvent = getEvents().get(0);
		ImmutableList<Delta> deltas = singleEvent.getDeltas();
		assertEquals(1, deltas.size());
	}

	@Test
	public void testFullBuildWhenClasspathChanged_3() throws CoreException, IOException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IPath rawLocation = libaryFile.getRawLocation();
		File file = rawLocation.toFile();
		Assert.assertTrue(file.setLastModified(10));
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(rawLocation, null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		Assert.assertTrue(file.setLastModified(System.currentTimeMillis()));
		project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		build();
		assertEquals(1, getEvents().size());
	}
	
	
	@Test
	public void testFullBuildWhenClasspathChanged_4() throws CoreException, IOException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libraryFile = copyAndGetXtendExampleJar(project);
		IPath rawLocation = libraryFile.getRawLocation();
		libraryFile.setLocalTimeStamp(10L);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(rawLocation, null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		libraryFile.setLocalTimeStamp(System.currentTimeMillis());
		project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		// refresh -> full build
		build();
		assertEquals(1, getEvents().size());
	}
	
	@Test
	public void testNoFullBuildWhenClasspathNotReallyChanged_1() throws CoreException, IOException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libaryFile = copyAndGetXtendExampleJar(project);
		IPath rawLocation = libaryFile.getRawLocation();
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(rawLocation, null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		project.setRawClasspath(project.getRawClasspath(), null);
		project.getProject().getFile("src/dummy.txt").create(new StringInputStream(""), false, null);
		project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
		build();
		assertEquals(0, getEvents().size());
	}
	
	@Test
	public void testNoFullBuildWhenClasspathNotReallyChanged_2() throws CoreException, IOException, InterruptedException {
		IJavaProject project = setupProject();
		IFile libraryFile = copyAndGetXtendExampleJar(project);
		IPath rawLocation = libraryFile.getRawLocation();
		libraryFile.setLocalTimeStamp(10L);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(rawLocation, null, null);
		addToClasspath(project, libraryEntry);
		build();
		assertFalse(getEvents().isEmpty());
		getEvents().clear();
		libraryFile.setLocalTimeStamp(System.currentTimeMillis());
		// no refresh -> no full build
		build();
		assertEquals(0, getEvents().size());
	}
	
	private IFile copyAndGetXtendExampleJar(IJavaProject javaProject) throws CoreException {
		IFile file = javaProject.getProject().getFile(XTEND_EXAMPLE_JAR);
		try (InputStream inputStream = Bug486584Test.class.getResourceAsStream(XTEND_EXAMPLE_JAR)) {
			file.create(inputStream, IResource.FORCE, null);	
		} catch (IOException e) {
			Exceptions.throwUncheckedException(e);
		}
		return file;
	}

	private IJavaProject setupProject() throws CoreException {
		IJavaProject project = createJavaProject(PROJECT_NAME + projectCounter++);
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		addBuilder(project.getProject(), XtextProjectHelper.BUILDER_ID);
		IFolder folder = project.getProject().getFolder(SRC_FOLDER);
		addFile(folder, "source", "namespace bar { object B }");
		return project;
	}

	private void addFile(IFolder folder, String fileName, String content) throws CoreException {
		IFile file = folder.getFile(fileName + F_EXT);
		file.create(new StringInputStream(content), true, monitor());
		build();
	}

}
