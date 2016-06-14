/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.performance;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.InputStream;
import java.util.Iterator;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.junit.Test;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class FilesInJarsAreNotIndexedTest extends AbstractXtendUITestCase {

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Inject
	private Provider<IResourceDescriptions> descriptionsProvider;
	
	@Test
	public void testXtendInSourceIsIndexed() throws Exception {
		IProject project = workbenchTestHelper.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		addSourceFolder(javaProject, "src");
		IFile file = workbenchTestHelper.createFile("src/my/XtendClass.xtend", "package my class XtendClass { } ");
		waitForBuild();
		IResourceDescriptions descriptions = descriptionsProvider.get();
		assertEquals(URI.createPlatformResourceURI(file.getFullPath().toString(), true), descriptions.getAllResourceDescriptions().iterator().next().getURI());
	}
	
	@Test
	public void testXtendInSourceIsIndexed_02() throws Exception {
		IProject project = workbenchTestHelper.getProject();
		IJavaProject javaProject = JavaCore.create(project);
		addSourceFolder(javaProject, "src");
		IFile file = workbenchTestHelper.createFile("my/XtendClass.xtend", "package my\n" +
				"import static extension example5.Distance.*\n" + 
				"import static extension example5.Time.*\n" + 
				"import static extension example5.Speed.*\n" +
				"class XtendClass {\n" +
				"  def foo() {\n" +
				"    println((13.km + 2_000.m) * 2)\n" +
				"    println(65.sec + 59.min - 5_000.msec)\n" +
				"    println(42.km/h == (40_000.m + 2.km) / 60.min)\n" +
				"  }\n" +
				" } ");
		addJarToClasspath(javaProject, copyAndGetXtendExampleJar(javaProject));
		waitForBuild();
		IMarker[] markers = file.findMarkers(IMarker.PROBLEM, true, -1);
		if (markers.length>0) {
			fail("No markers expected but got: "+markers[0].getAttribute(IMarker.MESSAGE));
		}
		IResourceDescriptions descriptions = descriptionsProvider.get();
		Iterator<IResourceDescription> iterator = descriptions.getAllResourceDescriptions().iterator();
		assertEquals(URI.createPlatformResourceURI(file.getFullPath().toString(), true), iterator.next().getURI());
		assertFalse(iterator.hasNext());
	}
	
	private IFile copyAndGetXtendExampleJar(IJavaProject javaProject1) throws CoreException {
		IFile file = javaProject1.getProject().getFile("XtendExample.jar");
		InputStream inputStream = FilesInJarsAreNotIndexedTest.class.getResourceAsStream("XtendExample.jar");
		file.create(inputStream, IResource.FORCE, null);
		return file;
	}
}
