/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import static org.eclipse.xtext.ui.util.JREContainerProvider.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathSupport;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaProjectFactory extends ProjectFactory {

	private static final Logger logger = Logger.getLogger(JavaProjectFactory.class);

	@Override
	protected void enhanceProject(IProject project, SubMonitor monitor, Shell shell) throws CoreException {
		super.enhanceProject(project, monitor, shell);
		if (builderIds.contains(JavaCore.BUILDER_ID)) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 10);
			try {
				subMonitor.subTask(Messages.JavaProjectFactory_ConfigureJavaProject + projectName);
				IJavaProject javaProject = JavaCore.create(project);
				List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
				for (final IProject referencedProject : project.getReferencingProjects()) {
					final IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(referencedProject
							.getFullPath());
					classpathEntries.add(referencedProjectClasspathEntry);
				}
				for (final String folderName : folders) {
					final IFolder sourceFolder = project.getFolder(folderName);
					final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(sourceFolder.getFullPath());
					classpathEntries.add(srcClasspathEntry);
				}

				IClasspathEntry defaultJREContainerEntry = getDefaultJREContainerEntry();
				classpathEntries.add(defaultJREContainerEntry);
				addMoreClasspathEntriesTo(classpathEntries);
				
				javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
						subMonitor.newChild(1));
				javaProject.setOutputLocation(new Path("/" + project.getName() + "/bin"), subMonitor.newChild(1)); //$NON-NLS-1$ //$NON-NLS-2$
				
				String executionEnvironmentId = JavaRuntime.getExecutionEnvironmentId(defaultJREContainerEntry.getPath());
				if (executionEnvironmentId != null) {
					BuildPathSupport.setEEComplianceOptions(javaProject, executionEnvironmentId, null);
				}
			} catch (JavaModelException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	protected void addMoreClasspathEntriesTo(List<IClasspathEntry> classpathEntries) {
	}

	@Override
	public JavaProjectFactory addBuilderIds(String... builderIds) {
		return (JavaProjectFactory) super.addBuilderIds(builderIds);
	}

	@Override
	public JavaProjectFactory addFolders(List<String> folders) {
		return (JavaProjectFactory) super.addFolders(folders);
	}

	@Override
	public JavaProjectFactory setProjectName(String projectName) {
		return (JavaProjectFactory) super.setProjectName(projectName);
	}

	@Override
	public JavaProjectFactory addProjectNatures(String... projectNatures) {
		return (JavaProjectFactory) super.addProjectNatures(projectNatures);
	}

	@Override
	public JavaProjectFactory addReferencedProjects(List<IProject> referencedProjects) {
		return (JavaProjectFactory) super.addReferencedProjects(referencedProjects);
	}

	@Override
	public JavaProjectFactory setLocation(IPath location) {
		return (JavaProjectFactory) super.setLocation(location);
	}

	@Override
	public JavaProjectFactory addWorkingSets(List<IWorkingSet> workingSets) {
		return (JavaProjectFactory) super.addWorkingSets(workingSets);
	}
}
