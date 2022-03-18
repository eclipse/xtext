/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.test;

import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.addNature;
import static org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil.fileIsEmpty;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.purexbase.ui.internal.PurexbaseActivator;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.generator.trace.TraceMarkers;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Injector;

public class BuilderWithTracesTest {

	private static Injector injector = PurexbaseActivator.getInstance()
			.getInjector(
					PurexbaseActivator.ORG_ECLIPSE_XTEXT_PUREXBASE_PUREXBASE);

	@Inject
	private TraceMarkers traceMarkers;

	private IProject project;

	private IJavaProject javaProject;

	@Before
	public void setUp() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
		javaProject = JavaProjectSetupUtil.createJavaProject("foo");
		project = javaProject.getProject();
		addNature(project, XtextProjectHelper.NATURE_ID);
		injector.injectMembers(this);
	}

	@After
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Test
	public void testJavaAndTraceGenerated() throws CoreException, IOException {
		IFile sourceFile = project.getFile("src/Foo.xbase");
		sourceFile.create(new StringInputStream("val foo = 5"), true, null);
		assertTrue(sourceFile.exists());
		sourceFile.getProject().build(IncrementalProjectBuilder.AUTO_BUILD, null);

		IFile targetFile = project.getFile("/src-gen/Foo.java");
		assertTrue(targetFile.exists());
		assertFalse(fileIsEmpty(targetFile));

		IFile traceFile = project.getFile("/src-gen/.Foo.java._trace");
		assertTrue(traceFile.exists());
		assertFalse(fileIsEmpty(traceFile));

		sourceFile.delete(true, null);
		sourceFile.getProject().build(IncrementalProjectBuilder.AUTO_BUILD, null);
		assertTrue(targetFile.getParent().exists());
		assertFalse(targetFile.exists());
		assertFalse(traceFile.exists());
	}

	/*
	 * TODO No trace markers are installed. This is because the
	 * JavaProjectAwareTraceContribution makes trace URIs relative to the source
	 * folder. But the EclipseResourceFileSystemAccess2 can only handle platform
	 * resources. This is fixed for Xtend and currently trace markers are only
	 * used by Xtend (in the generated source view). But this should work for
	 * all languages.
	 */
	@Test
	@Ignore
	public void testTraceMarkersInstalled() throws CoreException {
		IFile sourceFile = project.getFile("src/Foo.xbase");
		sourceFile.create(new StringInputStream("val foo = 5"), true, null);
		assertTrue(sourceFile.exists());
		sourceFile.getProject().build(IncrementalProjectBuilder.AUTO_BUILD, null);

		IFile traceFile = project.getFile("/src-gen/.Foo.java._trace");
		List<IPath> traceFiles = traceMarkers.findTraceFiles(sourceFile);

		assertTrue(traceFiles.contains(traceFile.getFullPath()));
	}

}
