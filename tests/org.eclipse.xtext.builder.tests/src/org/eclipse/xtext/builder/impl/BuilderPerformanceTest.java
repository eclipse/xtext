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
import java.util.Map.Entry;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.internal.StopWatches;
import org.eclipse.xtext.util.internal.StopWatches.NumbersForTask;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class BuilderPerformanceTest extends AbstractBuilderTest {
	
	@Override
	@Before
	public void setUp() throws Exception {
		StopWatches.setEnabled(true);
		super.setUp();
	}
	
	@Override
	@After
	public void tearDown() throws Exception {
		super.tearDown();
		printAndClearStopWatchData();
	}
	
	@Ignore @Test public void testSecondBuildRunIsMuchFaster() throws Exception {
		final String project1name = "project1";
		IJavaProject javaProject1 = createJavaProject(project1name);
		IFile file = javaProject1.getProject().getFile("XtendExample.jar");
		
		InputStream inputStream = BuilderPerformanceTest.class.getResourceAsStream("XtendExample.jar");
		file.create(inputStream, IResource.FORCE, null);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(file.getFullPath(), null, null);
		addToClasspath(javaProject1, libraryEntry);
		
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
	
	@Ignore @Test public void testBuildWithJarsContainingIndexedResources() throws Exception {
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
		
		IFile file = javaProject1.getProject().getFile("XtendExample.jar");
		
		InputStream inputStream = BuilderPerformanceTest.class.getResourceAsStream("XtendExample.jar");
		file.create(inputStream, IResource.FORCE, null);
		IClasspathEntry libraryEntry = JavaCore.newLibraryEntry(file.getFullPath(), null, null);
		addToClasspath(javaProject1, libraryEntry);
		
		System.out.println("Clean Java first - "+cleanBuildTakes());
		System.out.println("Clean Java second - "+cleanBuildTakes());
		
//		final Controller controller = new Controller();
//		controller.startCPUProfiling(ProfilingModes.CPU_TRACING, null, "");
		
		toggleNature(javaProject1);
		printAndClearStopWatchData();
		
//		controller.captureSnapshot(ProfilingModes.SNAPSHOT_WITHOUT_HEAP);
//		controller.clearCPUData();
//		
		System.out.println("Clean Xtext first - "+cleanBuildTakes());
		printAndClearStopWatchData();
		
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
	
	@Ignore @Test public void testBuildWithManyNonXtextRelatedJars() throws Exception {
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
	
	private void printAndClearStopWatchData() {
		for (Entry<String, NumbersForTask> task : StopWatches.allNumbers().entrySet()) {
			System.out.println("Task '"+task.getKey()+"' took "+task.getValue().getMilliseconds()+"ms ("+task.getValue().getNumberOfMeasurements()+" measurements).");
		}
		StopWatches.resetAll();
	}

	private void toggleNature(IJavaProject javaProject1) {
		long before = System.currentTimeMillis();
		new ToggleXtextNatureAction().toggleNature(javaProject1.getProject());
		waitForAutoBuild();
		System.out.println("Toggle Nature - Took " + (System.currentTimeMillis() - before) +"ms");
	}
	
	private String cleanBuildTakes() throws Exception {
		waitForAutoBuild();
		long before = System.currentTimeMillis();
		cleanBuild();
		fullBuild();
		waitForAutoBuild();
		long after = System.currentTimeMillis();
		return "Took " + (after -before) + "ms";
	}
	
	private IProject createPluginProject(String name, String ... bundleDependencies) throws CoreException {
		PluginProjectFactory projectFactory = getInstance(PluginProjectFactory.class);
		projectFactory.setProjectName(name);
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
	
}
