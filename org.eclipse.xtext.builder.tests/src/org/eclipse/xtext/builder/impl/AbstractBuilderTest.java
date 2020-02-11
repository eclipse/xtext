/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.builder.tests.BuilderTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Event;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.ui.testing.util.TestedWorkspaceWithJDT;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runner.RunWith;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(BuilderTestLanguageInjectorProvider.class)
public abstract class AbstractBuilderTest implements IResourceDescription.Event.Listener {
	
	protected final String F_EXT = ".buildertestlanguage";
	
	/* Must be public because it's a Junit4 rule */
	@Inject
	@Rule
	@Extension
	public TestedWorkspaceWithJDT workspace;

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
	
	protected void addToClasspath(IJavaProject project, IClasspathEntry newClassPathEntry) {
		workspace.addToClasspath(project, newClassPathEntry);
	}

	protected void build() {
		workspace.build();
	}
	
	protected void assertEmptyIndex() {
		workspace.assertEmptyIndex();
	}

	protected IJavaProject createJavaProject(String name) {
		return workspace.createJavaProject(name);
	}
	
	protected IWorkspaceRoot root() {
		return workspace.root();
	}

	protected void cleanBuild() {
		workspace.cleanBuild();
	}

	public IClasspathEntry addJarToClasspath(IJavaProject project, IFile jarFile) {
		return workspace.addJarToClasspath(project, jarFile);
	}

	protected void fullBuild() {
		workspace.fullBuild();
	}

	public IFile createFile(IPath wsRelativePath, String content) {
		return workspace.createFile(wsRelativePath, content);
	}

	protected void addProjectReference(IJavaProject from, IJavaProject to) {
		workspace.addProjectReference(from, to);
	}

	protected IFile createFile(String wsRelativePath, String content) {
		return workspace.createFile(wsRelativePath, content);
	}

	protected void removeProjectReference(IJavaProject from, IJavaProject to) {
		workspace.removeProjectReference(from, to);
	}

	public String readFile(IFile file) {
		return workspace.readFile(file);
	}

	protected void addSourceFolder(IJavaProject project, String folder) {
		workspace.addSourceFolder(project, folder);
	}

	public IFolder createSubFolder(IProject project, String name) {
		return workspace.createSubFolder(project, name);
	}

	public IProject createProject() {
		return workspace.createProject();
	}

	protected void deleteClasspathEntry(IJavaProject project, IPath entry) {
		workspace.deleteClasspathEntry(project, entry);
	}

	public IProject createProject(String name) {
		return workspace.createProject(name);
	}

	protected void addNature(IProject project, String natureId) {
		workspace.addNature(project, natureId);
	}

	protected void addBuilder(IProject project, String builderId) {
		workspace.addBuilder(project, builderId);
	}

	protected void setReference(IProject from, IProject to) {
		workspace.setReference(from, to);
	}

	protected void removeReference(IProject from, IProject to) {
		workspace.removeReference(from, to);
	}

	protected void removeNature(IProject project, String natureId) {
		workspace.removeNature(project, natureId);
	}

	protected void removeBuilder(IProject project, String builderId) {
		workspace.removeBuilder(project, builderId);
	}

	public IProgressMonitor monitor() {
		return workspace.monitor();
	}

	protected void enableAutobuild(Runnable r) {
		workspace.enableAutobuild(r);
	}

	protected void disableAutobuild(Runnable r) {
		workspace.disableAutobuild(r);
	}
	
	
}
