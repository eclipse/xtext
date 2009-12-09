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
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.nature.XtextNature;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.util.StringInputStream;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.inject.util.Stopwatch;

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

	public void testLotsOfFiles() throws Exception {
		IJavaProject project = createJavaProject("foo");
		addNature(project.getProject(), XtextNature.NATURE_ID);
		IFolder folder = addSourceFolder(project, "src");
		int NUM_FILES = 10;
		IFile[] files = new IFile[NUM_FILES];
		Stopwatch timer = new Stopwatch();
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

	private void logAndReset(String string, Stopwatch timer) {
		long took = timer.reset();
		System.out.println(string + " took : " + took);
	}

	private IResourceDescriptions getBuilderState() {
		return BuilderStateAccess.getBuilderState().get();
	}

	private int countResourcesInIndex() {
		return Collections2.forIterable(getBuilderState().getAllResourceDescriptions()).size();
	}

	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
}
