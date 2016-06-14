/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.builder;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.generator.trace.TraceMarkers;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendBuilderParticipantTest extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper testHelper;
	
	@Inject
	private TraceMarkers traceMarkers;

	@Override
	public void tearDown() throws Exception {
		testHelper.tearDown();
		super.tearDown();
	}

	@Test
	public void testBuild() throws Exception {
		IFile sourceFile = testHelper.createFile("test/Test", "package test\nclass Test {}");
		assertTrue(sourceFile.exists());
		waitForBuild();

		IFile targetFile = testHelper.getProject().getFile("/xtend-gen/test/Test.java");
		assertTrue(targetFile.exists());
		assertFalse(fileIsEmpty(targetFile));

		IFile traceFile = testHelper.getProject().getFile("/xtend-gen/test/.Test.java._trace");
		assertTrue(traceFile.exists());
		assertFalse(fileIsEmpty(traceFile));

		IFile classFile = testHelper.getProject().getFile("/bin/test/Test.class");
		assertTrue(classFile.exists());
		assertFalse(fileIsEmpty(classFile));
		
		List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);
		assertTrue(traceFiles.contains(traceFile.getFullPath()));

		sourceFile.delete(true, null);
		waitForBuild();
		cleanBuild();
		assertTrue(targetFile.getParent().exists());
		assertFalse(targetFile.exists());
		assertFalse(traceFile.exists());
		assertFalse(classFile.exists());

	}

	/**
	 * https://bugs.eclipse.org/bugs/show_bug.cgi?id=400193
	 */
	@Test
	public void testSourceRelativeOutput() throws Exception {
		IProject project = testHelper.getProject();
		String srcFolder = "/foo/bar/bug";
		JavaProjectSetupUtil.addSourceFolder(JavaCore.create(project), srcFolder);

		String path = srcFolder + "/Foo.xtend";
		String fullFileName = project.getName() + path;
		IFile sourceFile = testHelper.createFileImpl(fullFileName, "class Foo {}");
		assertTrue(sourceFile.exists());
		waitForBuild();

		IFile generatedFile = project.getFile("foo/bar/xtend-gen/Foo.java");
		assertTrue(generatedFile.exists());
		IFile traceFile = testHelper.getProject().getFile("foo/bar/xtend-gen/.Foo.java._trace");
		assertTrue(traceFile.exists());
		IFile classFile = testHelper.getProject().getFile("/bin/Foo.class");
		assertTrue(classFile.exists());
		
		List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);
		assertTrue(traceFiles.contains(traceFile.getFullPath()));


		sourceFile.delete(false, new NullProgressMonitor());
		waitForBuild();
		assertFalse(generatedFile.exists());
		assertFalse(traceFile.exists());
	}
	
}
