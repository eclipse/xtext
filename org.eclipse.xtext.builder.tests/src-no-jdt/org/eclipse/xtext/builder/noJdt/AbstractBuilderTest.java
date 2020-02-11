/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.noJdt;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.xtext.builder.tests.SharedInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.ui.testing.util.TestedWorkspaceWithoutJdt;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Mainly copied from {@link org.eclipse.xtext.builder.impl.AbstractBuilderTest}
 */
@RunWith(XtextRunner.class)
@InjectWith(SharedInjectorProvider.class)
public abstract class AbstractBuilderTest extends Assert implements IResourceDescription.Event.Listener {
	
	public final String F_EXT = ".nojdt";
	
	/* Must be public because it's a Junit4 rule */
	@Inject
	@Rule
	@Extension
	public TestedWorkspaceWithoutJdt workspace;

	@BeforeClass
	public static void setupTargetPlatform() throws Exception {
		TargetPlatformUtil.setTargetPlatform(AbstractBuilderTest.class);
	}
	
	private volatile List<Event> events = Lists.newArrayList();
	
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
	
	protected IProject createEmptyXtextProject(String string) {
		return workspace.createEmptyXtextProject(string);
	}
	
	protected void build() {
		workspace.build();
	}

	protected IFile createFile(String wsRelativePath, String content) {
		return workspace.createFile(wsRelativePath, content);
	}

	protected void removeNature(IProject project, String natureId) {
		workspace.removeNature(project, natureId);
	}
	
	protected void removeXtextNature(IProject project) {
		removeNature(project, XtextProjectHelper.NATURE_ID);
	}

	protected void addNature(IProject project, String natureId) {
		workspace.addNature(project, natureId);
	}
	
	protected void addXtextNature(IProject project) {
		addNature(project, XtextProjectHelper.NATURE_ID);
	}

	protected IProgressMonitor monitor() {
		return workspace.monitor();
	}
	
}
