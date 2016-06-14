/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath;

import org.apache.log4j.Level;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeMirror;
import org.eclipse.xtext.junit4.logging.LoggingTester;
import org.eclipse.xtext.junit4.logging.LoggingTester.LogCapture;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class JavaClasspathTest extends AbstractXtendUITestCase {
	private static final String TEST_CLAZZ = "import org.eclipse.xtend.lib.annotations.Accessors class Foo { @Accessors int bar }";

	@Inject
	private MarkerAssertions markerAssert;

	@Inject
	private WorkbenchTestHelper testHelper;

	@Test
	public void testNoJavaInClasspath() throws Exception {
		LogCapture capturedLogging = LoggingTester.captureLogging(Level.ERROR, AbstractClassMirror.class, new Runnable() {

			@Override
			public void run() {
				LogCapture capturedLogging = LoggingTester.captureLogging(Level.ERROR, JdtTypeMirror.class, new Runnable() {
					@Override
					public void run() {
						try {
							IProject project = testHelper.getProject();
							IJavaProject javaProject = JavaCore.create(project);
			
							IFile file = project.getFile("src/Foo.xtend");
							if (!file.exists())
								file.create(new StringInputStream(TEST_CLAZZ),
										true, null);
			
							IClasspathEntry jrePath = JavaProjectSetupUtil.getJreContainerClasspathEntry(javaProject);
							assertNotNull("JRE Lib classpath entry not found.", jrePath);
			
							JavaProjectSetupUtil.deleteClasspathEntry(javaProject, jrePath.getPath()); // remove JRE Lib
							IResourcesSetupUtil.waitForBuild();
							markerAssert.assertErrorMarker(file, IssueCodes.JDK_NOT_ON_CLASSPATH);
			
							JavaProjectSetupUtil.addToClasspath(javaProject, jrePath); // add JRE back
							IResourcesSetupUtil.waitForBuild();
							markerAssert.assertNoErrorMarker(file);
						} catch(Exception e) {
							throw new RuntimeException(e);
						}
					}
				});
				assertFalse(capturedLogging.getLogEntries().isEmpty());
			}
		});
		assertFalse(capturedLogging.getLogEntries().isEmpty());
	}

	@Test
	public void testJavaSourceLevelMismatch() throws Exception {
		IProject project = testHelper.getProject();

		// create a fake java.util.List without type param
		IFolder folder = project.getFolder(new Path("src/java/util"));
		IResourcesSetupUtil.createFolder(folder.getFullPath());
		IFile list = folder.getFile("List.xtend");
		list.create(new StringInputStream("package java.util; class List {}"), true, null);

		IFile file = project.getFile("src/Foo.xtend");
		if (!file.exists())
			file.create(new StringInputStream(TEST_CLAZZ),
					true, null);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.JDK_NOT_ON_CLASSPATH);

		list.delete(true, null);
		IResourcesSetupUtil.cleanBuild();
		IResourcesSetupUtil.waitForBuild();
		markerAssert.assertNoErrorMarker(file);
	}
}
