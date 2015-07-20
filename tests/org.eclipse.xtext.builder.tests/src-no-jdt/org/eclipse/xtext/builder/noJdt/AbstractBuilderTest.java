/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import static org.eclipse.xtext.builder.impl.BuilderUtil.*;
import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroManager;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Mainly copied from {@link org.eclipse.xtext.builder.impl.AbstractBuilderTest}
 */
public abstract class AbstractBuilderTest extends Assert implements IResourceDescription.Event.Listener {
	public final String F_EXT = ".nojdt";
	private volatile List<Event> events = Lists.newArrayList();

	@Before
	public void setUp() throws Exception {
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
		if (PlatformUI.isWorkbenchRunning()) {
			final IIntroManager introManager = PlatformUI.getWorkbench().getIntroManager();
			if (introManager.getIntro() != null) {
				Display.getDefault().asyncExec(new Runnable() {
					
					@Override
					public void run() {
						introManager.closeIntro(introManager.getIntro());
					}
				});
			}
		}
	}

	@After
	public void tearDown() throws Exception {
		cleanWorkspace();
		waitForBuild();
		events.clear();
		getBuilderState().removeListener(this);
		assertEquals(0, countResourcesInIndex());
		assertEquals(0, root().getProjects().length);
	}

	@Override
	public void descriptionsChanged(Event event) {
		this.events.add(event);
	}
	
	public List<Event> getEvents() {
		return events;
	}
	
	protected int countMarkers(IFile file) throws CoreException {
		return file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE).length;
	}
	
	protected String printMarkers(IFile file) throws CoreException {
		return printMarkers(file.findMarkers(EValidator.MARKER, true, IResource.DEPTH_INFINITE));
	}

	protected String printMarkers(IMarker[] findMarkers) throws CoreException {
		StringBuffer buff = new StringBuffer();
		for (IMarker iMarker : findMarkers) {
			buff.append("\n");
			buff.append(iMarker.getAttribute(IMarker.MESSAGE));
		}
		return buff.toString();
	}
	
	protected IProject createEmptyProject(String string) throws CoreException, InvocationTargetException, InterruptedException {
		IProject project = createProject(string);
		addNature(project, XtextProjectHelper.NATURE_ID);
		return project;
	}
}
