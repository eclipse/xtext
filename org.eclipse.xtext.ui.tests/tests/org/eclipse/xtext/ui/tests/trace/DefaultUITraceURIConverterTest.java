/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.tests.trace;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.generator.trace.AbsoluteURI;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.SourceRelativeURI;
import org.eclipse.xtext.ui.tests.Activator;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class DefaultUITraceURIConverterTest extends Assert {

	private static IJavaProject project;

	@BeforeClass
	public static void createProject() throws Exception {
		project = createJavaProject("Foo");
		addSourceFolder(project, "src");
		createFolder("/Foo/main");
		addSourceFolder(project, "main/src");
	}

	@AfterClass
	public static void deleteProject() throws Exception {
		deleteJavaProject(project);
	}

	@Inject
	private ITraceURIConverter converter;
	
	@Inject 
	private EclipseProjectConfigProvider projectConfigProvider;

	@Inject
	@Named(Constants.FILE_EXTENSIONS)
	private String ext;

	public DefaultUITraceURIConverterTest() {
		Activator.getInstance().getInjector(Activator.ORG_ECLIPSE_XTEXT_UI_TESTS_TESTLANGUAGE).injectMembers(this);
	}

	private void assertConversion(String expected, IFile source) {
		AbsoluteURI sourceURI = new AbsoluteURI(URI.createPlatformResourceURI(source.getFullPath().toString(), true));
		IProjectConfig projectConfig = projectConfigProvider.createProjectConfig(project.getProject());
		SourceRelativeURI traceUri = converter.getURIForTrace(projectConfig, sourceURI);
		assertEquals(expected, traceUri.toString());
	}

	@Test
	public void test0() throws Exception {
		assertConversion("foo0." + ext, createFile("/Foo/foo0." + ext, "foo"));
	}

	@Test
	public void test1() throws Exception {
		assertConversion("folder/foo1." + ext, createFile("/Foo/folder/foo1." + ext, "foo"));
	}

	@Test
	public void test2() throws Exception {
		assertConversion("foo2." + ext, createFile("/Foo/src/foo2." + ext, "foo"));
	}

	@Test
	public void test3() throws Exception {
		assertConversion("folder/foo3." + ext, createFile("/Foo/src/folder/foo3." + ext, "foo"));
	}

	@Test
	public void test4() throws Exception {
		assertConversion("foo4." + ext, createFile("/Foo/main/src/foo4." + ext, "foo"));
	}

	@Test
	public void test5() throws Exception {
		assertConversion("folder/foo5." + ext, createFile("/Foo/main/src/folder/foo5." + ext, "foo"));
	}
}
