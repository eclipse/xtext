/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath;

import java.util.Map;

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
 */
public class JavaClasspathTest extends AbstractXtendUITestCase {
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
			file.create(new StringInputStream("import org.eclipse.xtend.lib.Property class Foo { @Property int bar }"),
					true, null);
		
		IClasspathEntry jrePath = JavaProjectSetupUtil.getJreContainerClasspathEntry(javaProject);
		assertNotNull("JRE Lib classpath entry not found.", jrePath);
		
		JavaProjectSetupUtil.deleteClasspathEntry(javaProject, jrePath.getPath()); // remove JRE Lib
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.JAVA_IS_MISSING);

		JavaProjectSetupUtil.addToClasspath(javaProject, jrePath); // add JRE back
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertNoErrorMarker(file);
	}

	@Test
	public void testJavaSourceLevelMismatch() throws Exception {
		IProject project = testHelper.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		Map<?, ?> options = javaProject.getOptions(false);
		JavaCore.setComplianceOptions(JavaCore.VERSION_1_4, options);
		javaProject.setOptions(options);
		IFile file = project.getFile("src/Foo.xtend");
		if (!file.exists())
			file.create(new StringInputStream("import org.eclipse.xtend.lib.Property class Foo { @Property int bar }"),
					true, null);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.JAVA_SOURCE_LEVEL_MISMATCH);

		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertNoErrorMarker(file);
	}
}
