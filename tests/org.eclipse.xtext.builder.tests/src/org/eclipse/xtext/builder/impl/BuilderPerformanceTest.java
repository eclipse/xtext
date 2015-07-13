/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
/*

2012-12-04 / Sebastian
==========================

Clean Java first - Took 968ms
Clean Java second - Took 1076ms
Toggle Nature - Took 3009ms
Clean Xtext first - Took 1391ms
Clean Xtext second - Took 1056ms
Clean Xtext third - Took 969ms

-------------------------------------------------------------------------------------------------------------------------
Task 'build' took 5444ms (4 measurements).
Task 'parsing' took 288ms (36 measurements).
Task 'primary JVM Model inference' took 385ms (72 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 186ms (72 measurements).
Task 'Crosslink resolution' took 6948ms (5264 measurements).
-------------------------------------------------------------------------------------------------------------------------

Clean Java first - Took 1106ms
Clean Java second - Took 964ms
Toggle Nature - Took 2921ms

-------------------------------------------------------------------------------------------------------------------------
Task 'build' took 2679ms (1 measurements).
Task 'parsing' took 23ms (9 measurements).
Task 'primary JVM Model inference' took 200ms (18 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 41ms (18 measurements).
Task 'Crosslink resolution' took 4287ms (809 measurements).
-------------------------------------------------------------------------------------------------------------------------

Clean Xtext first - Took 1495ms

-------------------------------------------------------------------------------------------------------------------------
Task 'build' took 1223ms (1 measurements).
Task 'parsing' took 33ms (9 measurements).
Task 'primary JVM Model inference' took 50ms (18 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 28ms (18 measurements).
Task 'Crosslink resolution' took 2017ms (809 measurements).
-------------------------------------------------------------------------------------------------------------------------

Clean Xtext second - Took 1239ms
Clean Xtext third - Took 1030ms
Clean Xtext fourth - Took 983ms
Clean Xtext fith - Took 937ms

-------------------------------------------------------------------------------------------------------------------------
Task 'build' took 3104ms (4 measurements).
Task 'parsing' took 88ms (36 measurements).
Task 'primary JVM Model inference' took 165ms (72 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 53ms (72 measurements).
Task 'Crosslink resolution' took 4716ms (3236 measurements).
-------------------------------------------------------------------------------------------------------------------------

Clean Java first - Took 970ms
Clean Java second - Took 1075ms
Toggle Nature - Took 968ms
Clean Xtext first - Took 974ms
Clean Xtext second - Took 976ms
Clean Xtext third - Took 1079ms
Clean Xtext fourth - Took 973ms
Clean Xtext fith - Took 980ms

-------------------------------------------------------------------------------------------------------------------------
Task 'build' took 7ms (6 measurements).
-------------------------------------------------------------------------------------------------------------------------

 */
public class BuilderPerformanceTest extends AbstractBuilderTest {
	
	@Override
	@Before
	public void setUp() throws Exception {
		Stopwatches.setEnabled(true);
		super.setUp();
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		printAndClearStopwatchData();
		Stopwatches.setEnabled(false);
	}
	
	@Test public void testSecondBuildRunIsMuchFaster() throws Exception {
		final String project1name = "project1";
		IJavaProject javaProject1 = createJavaProject(project1name);
		addJarToClasspath(javaProject1, copyAndGetXtendExampleJar(javaProject1));
		
		System.out.println("Clean Java first - "+cleanBuildTakes());
		System.out.println("Clean Java second - "+cleanBuildTakes());
		
		toggleNature(javaProject1);
		
		System.out.println("Clean Xtext first - "+cleanBuildTakes());
//		final Controller controller = new Controller();
//		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, null, "");
		System.out.println("Clean Xtext second - "+cleanBuildTakes());
		System.out.println("Clean Xtext third - "+cleanBuildTakes());
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.stopCPUProfiling();
	}

	@Test public void testBuildWithJarsContainingIndexedResources() throws Exception {
		final String project1name = "project1";
		// create a project with a bunch of jars
		IProject project1 = createPluginProject(project1name, 
				"org.eclipse.core.runtime", 
				"org.eclipse.core.jobs", 
				"org.eclipse.core.variables", 
				"org.eclipse.debug.core", 
				"org.eclipse.debug.ui", 
				"org.eclipse.emf.edit", 
				"org.eclipse.emf.ecore", 
				"org.eclipse.emf.common", 
				"org.eclipse.emf.ecore.xmi", 
				"org.antlr.generator", 
				"org.eclipse.jdt.ui", 
				"org.eclipse.emf.mwe.core", 
				"org.eclipse.jdt.core", 
				"org.eclipse.xtext.xbase.lib", 
				"org.eclipse.xtend.lib");
		IJavaProject javaProject1 = JavaCore.create(project1);
		
		IFile file = copyAndGetXtendExampleJar(javaProject1);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(file.getFullPath(), null, null);
		addToClasspath(javaProject1, libraryEntry);
		
		System.out.println("Clean Java first - "+cleanBuildTakes());
		System.out.println("Clean Java second - "+cleanBuildTakes());
		
//		final Controller controller = new Controller();
//		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, null, "");
		
		toggleNature(javaProject1);
		printAndClearStopwatchData();
		
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.clearCPUData();
//		
		System.out.println("Clean Xtext first - "+cleanBuildTakes());
		printAndClearStopwatchData();
		
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.clearCPUData();
		
		System.out.println("Clean Xtext second - "+cleanBuildTakes());
		
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.clearCPUData();
		System.out.println("Clean Xtext third - "+cleanBuildTakes());
		System.out.println("Clean Xtext fourth - "+cleanBuildTakes());
		System.out.println("Clean Xtext fith - "+cleanBuildTakes());
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.stopCPUProfiling();
	}
	
	@Test public void testBuildWithManyNonXtextRelatedJars() throws Exception {
		final String project1name = "project1";
		// create a project with a bunch of jars
		IProject project1 = createPluginProject(project1name, 
				"org.eclipse.core.runtime", 
				"org.eclipse.core.jobs", 
				"org.eclipse.core.variables", 
				"org.eclipse.debug.core", 
				"org.eclipse.debug.ui", 
//				"org.eclipse.emf.edit", 
//				"org.eclipse.emf.ecore", 
//				"org.eclipse.emf.common", 
//				"org.eclipse.emf.ecore.xmi", 
				"org.antlr.generator", 
				"org.eclipse.jdt.ui", 
//				"org.eclipse.emf.mwe.core", 
				"org.eclipse.jdt.core", 
				"org.eclipse.xtext.xbase.lib", 
				"org.eclipse.xtend.lib");
		IJavaProject javaProject1 = JavaCore.create(project1);
		
//		IFile file = javaProject1.getProject().getFile("XtendExample.jar");
//		
//		InputStream inputStream = CachedJarInfoTest.class.getResourceAsStream("XtendExample.jar");
//		file.create(inputStream, IResource.FORCE, null);
//		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(file.getFullPath(), null, null);
//		addToClasspath(javaProject1, libraryEntry);
		
		System.out.println("Clean Java first - "+cleanBuildTakes());
		System.out.println("Clean Java second - "+cleanBuildTakes());
		
		toggleNature(javaProject1);
		System.out.println("Clean Xtext first - "+cleanBuildTakes());
//		final Controller controller = new Controller();
//		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, null, "");
		System.out.println("Clean Xtext second - "+cleanBuildTakes());
		System.out.println("Clean Xtext third - "+cleanBuildTakes());
		System.out.println("Clean Xtext fourth - "+cleanBuildTakes());
		System.out.println("Clean Xtext fith - "+cleanBuildTakes());
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.stopCPUProfiling();
	}
	
	private void printAndClearStopwatchData() {
		System.out.println(Stopwatches.getPrintableStopwatchData());
		Stopwatches.resetAll();
	}
	
	private IFile copyAndGetXtendExampleJar(IJavaProject javaProject1) throws CoreException {
		IFile file = javaProject1.getProject().getFile("XtendExample.jar");
		InputStream inputStream = BuilderPerformanceTest.class.getResourceAsStream("XtendExample.jar");
		file.create(inputStream, IResource.FORCE, null);
		return file;
	}

	private void toggleNature(IJavaProject javaProject1) {
		long before = System.currentTimeMillis();
		new ToggleXtextNatureAction().toggleNature(javaProject1.getProject());
		waitForBuild();
		System.out.println("Toggle Nature - Took " + (System.currentTimeMillis() - before) +"ms");
	}
	
	private String cleanBuildTakes() throws Exception {
		waitForBuild();
		long before = System.currentTimeMillis();
		cleanBuild();
		fullBuild();
		waitForBuild();
		long after = System.currentTimeMillis();
		return "Took " + (after -before) + "ms";
	}
	
	private IProject createPluginProject(String name, String ... bundleDependencies) throws CoreException {
		PluginProjectFactory projectFactory = getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
		projectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
		projectFactory.addFolders(Collections.singletonList("src"));
		projectFactory.addBuilderIds(
			JavaCore.BUILDER_ID, 
			"org.eclipse.pde.ManifestBuilder",
			"org.eclipse.pde.SchemaBuilder");
		projectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature");
		projectFactory.addRequiredBundles(Arrays.asList(bundleDependencies));
		IProject result = projectFactory.createProject(new NullProgressMonitor(), null);
		return result;
	}
	
	protected void waitForBuild() {
		IResourcesSetupUtil.reallyWaitForAutoBuild();
	}
	
}
