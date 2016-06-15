/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class ProfilerAbstractBuilderTest extends Assert implements IResourceDescription.Event.Listener {
	private static final String F_EXT = ".buildertestlanguage";
	private volatile List<Event> events = Lists.newArrayList();

	@Before
	public void setUp() throws Exception {
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
	}

	@After
	public void tearDown() throws Exception {
		cleanWorkspace();
		waitForBuild();
		events.clear();
		getBuilderState().removeListener(this);
	}
	
	@Test public void testIncrementalBuildWithBigLibraryFile() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		int NUM_OBJECTS = 40000;
		StopWatch timer = new StopWatch();
		IFile file = folder.getFile("Test_Library" + F_EXT);
		String contents = "namespace x { ";
		for (int i = 0; i < NUM_OBJECTS; i++) {
			contents += " object Foo" + i;
		}
		contents+="}";
		file.create(new StringInputStream(contents), true, monitor());
		logAndReset("Creating files", timer);
		waitForBuild();
		for (int i =0;i<5;i++) {
			IFile f = folder.getFile("Referencing_"+i+F_EXT);
			logAndReset("Creating library file", timer);
			f.create(new StringInputStream("object Bar"+i+" references x.Foo1"), true, null);
			logAndReset("Auto build", timer);
			waitForBuild();
		}
	}
	
	@Test public void testFullBuildBigProject() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		int NUM_FILES = 200;
		IFile[] files = new IFile[NUM_FILES];
		StopWatch timer = new StopWatch();
		for (int i = 0; i < NUM_FILES; i++) {
			IFile file = folder.getFile("Test_" + i + "_" + F_EXT);
			files[i] = file;
			String contents = "object Foo" + i + " references Foo" + (i + 1);
			if (i == NUM_FILES)
				contents = "object Foo" + i;
			file.create(new StringInputStream(contents), true, monitor());
		}
		logAndReset("Creating files", timer);
		waitForBuild();
		logAndReset("Auto build", timer);
	}
	
	@Test public void testFullBuildBigProjectWithRefeernceToJar() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		IFile jarFile = project.getProject().getFile("my.jar");
		jarFile.create(jarInputStream(new TextFile("my/element"+F_EXT,"object ReferenceMe")), true, monitor());
		addJarToClasspath(project, jarFile);
		
		int NUM_FILES = 2000;
		IFile[] files = new IFile[NUM_FILES];
		StopWatch timer = new StopWatch();
		for (int i = 0; i < NUM_FILES; i++) {
			IFile file = folder.getFile("Test_" + i + "_" + F_EXT);
			files[i] = file;
			String contents = "object Foo" + i + " references ReferenceMe";
			file.create(new StringInputStream(contents), true, monitor());
		}
		logAndReset("Creating files", timer);
		waitForBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		for (IMarker iMarker : iMarkers) {
			System.out.println(iMarker.getAttribute(IMarker.MESSAGE));
		}
		assertEquals(0,iMarkers.length);
	}
	
	@Test public void testFullBuildBigProjectWithLinkingErrors() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		int NUM_FILES = 200;
		IFile[] files = new IFile[NUM_FILES];
		StopWatch timer = new StopWatch();
		for (int i = 0; i < NUM_FILES; i++) {
			IFile file = folder.getFile("Test_" + i + "_" + F_EXT);
			files[i] = file;
			String contents = "object Foo" + i + " references Foo" + (i * 1000);
			if (i == NUM_FILES)
				contents = "object Foo" + i;
			file.create(new StringInputStream(contents), true, monitor());
		}
		logAndReset("Creating files", timer);
		waitForBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		assertEquals(NUM_FILES-1,iMarkers.length);
	}
	
	@Test public void testFullBuildBigProjectWithSyntaxErrors() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		int NUM_FILES = 500;
		IFile[] files = new IFile[NUM_FILES];
		StopWatch timer = new StopWatch();
		for (int i = 0; i < NUM_FILES; i++) {
			IFile file = folder.getFile("Test_" + i + "_" + F_EXT);
			files[i] = file;
			String contents = "object Foo" + i + " references Foo" + (i * 1000);
			if (i == NUM_FILES)
				contents = "object Foo" + i;
			file.create(new StringInputStream(contents), true, monitor());
		}
		logAndReset("Creating files", timer);
		waitForBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		assertEquals(NUM_FILES-1,iMarkers.length);
	}

	@Test public void testLotsOfFiles() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = project.getProject().getFolder("src");
		int NUM_FILES = 10;
		IFile[] files = new IFile[NUM_FILES];
		StopWatch timer = new StopWatch();
		for (int i = 0; i < NUM_FILES; i++) {
			IFile file = folder.getFile("Test_" + i + "_" + F_EXT);
			files[i] = file;
			String contents = "object Foo" + i + " references Foo" + (i + 1);
			if (i == NUM_FILES)
				contents = "object Foo" + i;
			file.create(new StringInputStream(contents), true, monitor());
		}
		logAndReset("Creating files", timer);
		waitForBuild();
		logAndReset("Auto build", timer);
		for (int x = 0; x < 20; x++) {
			for (int i = 0; i < NUM_FILES; i++) {
				IFile file = files[i];
				String contents = "object Foo" + i + " references Foo" + (i + 1);
				if (i == NUM_FILES)
					contents = "object Foo" + i;
				file.setContents(new StringInputStream(contents), true, true, monitor());
				waitForBuild();
			}
			logAndReset("updating all " + NUM_FILES + " files", timer);
		}
		assertEquals(NUM_FILES, countResourcesInIndex());
	}

	private void logAndReset(String string, StopWatch timer) {
		timer.resetAndLog(string);
	}

	private IBuilderState getBuilderState() {
		return Access.getIBuilderState().get();
	}

	private int countResourcesInIndex() {
		return Lists.newArrayList(getBuilderState().getAllResourceDescriptions()).size();
	}

	@Override
	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
}
