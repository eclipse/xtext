/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 * @author Stéphane Galland - fixing for supporting "deprecated feature use" warning.
 */
public class JavaClasspathTest extends AbstractXtendUITestCase {
	private static final String TEST_CLAZZ = "import org.eclipse.xtend.lib.Property class Foo { @Property int bar }";

	@Inject
	private MarkerAssertions markerAssert;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Test
	public void testNoJavaInClasspath() throws Exception {
		IProject project = testHelper.getProject();
		IJavaProject javaProject = JavaCore.create(project);

		IFile file = project.getFile("src/Foo.xtend");
		if (!file.exists())
			file.create(new StringInputStream(TEST_CLAZZ),
					true, null);

		IClasspathEntry jrePath = JavaProjectSetupUtil.getJreContainerClasspathEntry(javaProject);
		assertNotNull("JRE Lib classpath entry not found.", jrePath);

		JavaProjectSetupUtil.deleteClasspathEntry(javaProject, jrePath.getPath()); // remove JRE Lib
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.JDK_NOT_ON_CLASSPATH);

		JavaProjectSetupUtil.addToClasspath(javaProject, jrePath); // add JRE back
		IResourcesSetupUtil.waitForAutoBuild();
		MarkerAssertions markers = markerAssert.createCollection();
		markers.assertErrorMarker(file, org.eclipse.xtext.xbase.validation.IssueCodes.DEPRECATED_FEATURE);
		markers.assertNoErrorMarker(file);
	}

	@Test
	public void testJavaSourceLevelMismatch() throws Exception {
		IProject project = testHelper.getProject();

		// create a fake java.util.List without type param
		IFile list = project.getFile("src/java.util.List.xtend");
		list.create(new StringInputStream("package java.util; class List {}"), true, null);

		IFile file = project.getFile("src/Foo.xtend");
		if (!file.exists())
			file.create(new StringInputStream(TEST_CLAZZ),
					true, null);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.JDK_NOT_ON_CLASSPATH);

		list.delete(true, null);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForAutoBuild();
		MarkerAssertions markers = markerAssert.createCollection();
		markers.assertErrorMarker(file, org.eclipse.xtext.xbase.validation.IssueCodes.DEPRECATED_FEATURE);
		markers.assertNoErrorMarker(file);
	}
}
