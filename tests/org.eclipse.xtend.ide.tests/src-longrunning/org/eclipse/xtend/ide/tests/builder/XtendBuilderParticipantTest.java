/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.util.Strings.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendBuilderParticipantTest extends AbstractXtendUITestCase {

	@Inject
	private IWorkspace workspace;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	@Test
	public void testBuild() throws Exception {
		IFile sourceFile = testHelper.createFile("test/Test", "package test\nclass Test {}");
		sourceFile.getProject().setDefaultCharset(getNonDefaultEncoding(), null);
		assertTrue(sourceFile.exists());
		waitForAutoBuild();

		IFile targetFile = testHelper.getProject().getFile("/xtend-gen/test/Test.java");
		assertTrue(targetFile.exists());
		assertFalse(isEmpty(targetFile));
		assertEquals(getNonDefaultEncoding(), targetFile.getCharset());

		IFile classFile = testHelper.getProject().getFile("/bin/test/Test.class");
		assertTrue(classFile.exists());
		assertFalse(isEmpty(classFile));

		sourceFile.delete(true, null);
		waitForAutoBuild();
		cleanBuild();
		assertFalse(targetFile.exists());
		// don't delete folders per default
		assertTrue(targetFile.getParent().exists());
		assertFalse(classFile.exists());
	}

	@Test
	public void testBug400193() throws Exception {
		IProject project = testHelper.getProject();
		waitForAutoBuild();
		String srcFolder = "/foo/bar/bug";
		IFolder folder = project.getFolder(srcFolder);
		prepareFolder(folder);
		final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(folder.getFullPath());
		IJavaProject javaProject = JavaCore.create(project);
		List<IClasspathEntry> classpathEntries = Lists.newArrayList(javaProject.getRawClasspath());
		classpathEntries.add(srcClasspathEntry);
		javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
				new NullProgressMonitor());
		String path = srcFolder + "/Foo.xtend";
		String fullFileName = project.getName() + path;
		IFile file = testHelper.createFileImpl(fullFileName, "class Foo {}");
		waitForAutoBuild();
		IFile generatedFile = project.getFile("foo/bar/xtend-gen/Foo.java");
		assertTrue(generatedFile.exists());
		file.delete(false, new NullProgressMonitor());
		waitForAutoBuild();
		assertTrue(!generatedFile.exists());
	}

	public void prepareFolder(IFolder folder) {
		IContainer parent = folder.getParent();
		if (parent instanceof IFolder) {
			prepareFolder((IFolder) parent);
		}
		if (!folder.exists()) {
			try {
				folder.create(false,false,new NullProgressMonitor());
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
	}

	protected boolean isEmpty(IFile file) throws CoreException, IOException {
		InputStream contents = null;
		try {
			contents = file.getContents();
			return contents.read() == -1;
		} finally {
			if (contents != null)
				contents.close();
		}
	}

	protected String getNonDefaultEncoding() throws CoreException {
		String defaultCharset = workspace.getRoot().getDefaultCharset();
		if (equal(defaultCharset, "UTF-8"))
			return "ISO-8859-1";
		else
			return "UTF-8";
	}
}
