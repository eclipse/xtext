/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import static org.eclipse.xtext.junit.util.IResourcesSetupUtil.*;
import static org.eclipse.xtext.junit.util.JavaProjectSetupUtil.*;

import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.junit.util.JavaProjectSetupUtil.TextFile;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.shared.Access;
import org.eclipse.xtext.util.StopWatch;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ProfilerAbstractBuilderTest extends TestCase implements IResourceDescription.Event.Listener {
	private static final String F_EXT = ".buildertestlanguage";
	private volatile List<Event> events = Lists.newArrayList();

	@Override
	protected void setUp() throws Exception {
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		cleanWorkspace();
		waitForAutoBuild();
		events.clear();
		getBuilderState().removeListener(this);
		super.tearDown();
	}
	
	public void testFullBuildBigProject() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		waitForAutoBuild();
		logAndReset("Auto build", timer);
	}
	
	public void testFullBuildBigProjectWithRefeernceToJar() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		waitForAutoBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		for (IMarker iMarker : iMarkers) {
			System.out.println(iMarker.getAttribute(IMarker.MESSAGE));
		}
		assertEquals(0,iMarkers.length);
	}
	
	public void testFullBuildBigProjectWithLinkingErrors() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		waitForAutoBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		assertEquals(NUM_FILES-1,iMarkers.length);
	}
	
	public void testFullBuildBigProjectWithSyntaxErrors() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		waitForAutoBuild();
		logAndReset("Auto build", timer);
		IMarker[] iMarkers = folder.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE);
		assertEquals(NUM_FILES-1,iMarkers.length);
	}

	public void testLotsOfFiles() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextProjectHelper.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
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
		waitForAutoBuild();
		logAndReset("Auto build", timer);
		for (int x = 0; x < 20; x++) {
			for (int i = 0; i < NUM_FILES; i++) {
				IFile file = files[i];
				String contents = "object Foo" + i + " references Foo" + (i + 1);
				if (i == NUM_FILES)
					contents = "object Foo" + i;
				file.setContents(new StringInputStream(contents), true, true, monitor());
				waitForAutoBuild();
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
		return Collections2.forIterable(getBuilderState().getAllResourceDescriptions()).size();
	}

	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
}
