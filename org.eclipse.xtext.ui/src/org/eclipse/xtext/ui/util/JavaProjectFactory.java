/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import static org.eclipse.xtext.ui.util.JREContainerProvider.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.jdt.internal.ui.wizards.buildpaths.BuildPathSupport;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkingSet;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaProjectFactory extends ProjectFactory {

	private static final Logger logger = Logger.getLogger(JavaProjectFactory.class);
	
	private List<IClasspathEntry> extraClasspathEntries = Lists.newArrayList();
	private String defaultOutput = "bin";

	private IClasspathEntry jreContainerEntry;

	private Map<String, String> sourceFolderOutputs = new HashMap<>();
	private Set<String> testSourceFolders = new HashSet<>();

	@Override
	protected void enhanceProject(IProject project, SubMonitor monitor, Shell shell) throws CoreException {
		super.enhanceProject(project, monitor, shell);
		if (builderIds.contains(JavaCore.BUILDER_ID)) {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 10);
			try {
				subMonitor.subTask(Messages.JavaProjectFactory_ConfigureJavaProject + projectName);
				IJavaProject javaProject = JavaCore.create(project);
				List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
				for (final IProject referencedProject : project.getReferencedProjects()) {
					final IClasspathEntry referencedProjectClasspathEntry = JavaCore.newProjectEntry(referencedProject
							.getFullPath());
					classpathEntries.add(referencedProjectClasspathEntry);
				}
				for (final String folderName : getFolders()) {
					final IFolder sourceFolder = project.getFolder(folderName);
					String outputFolderName = sourceFolderOutputs.get(folderName);
					final IClasspathEntry srcClasspathEntry = JavaCore.newSourceEntry(sourceFolder.getFullPath(),
							ClasspathEntry.INCLUDE_ALL, ClasspathEntry.EXCLUDE_NONE,
							outputFolderName == null ? null : project.getFolder(outputFolderName).getFullPath(),
							testSourceFolders.contains(folderName)
									? new IClasspathAttribute[] { JavaCore.newClasspathAttribute("test", "true") }
									: new IClasspathAttribute[0]);
					classpathEntries.add(srcClasspathEntry);
				}
				classpathEntries.addAll(extraClasspathEntries);

				IClasspathEntry defaultJREContainerEntry = getJreContainerEntry();
				classpathEntries.add(defaultJREContainerEntry);
				addMoreClasspathEntriesTo(classpathEntries);
				
				javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[classpathEntries.size()]),
						subMonitor.newChild(1));
				javaProject.setOutputLocation(new Path("/" + project.getName() + "/" + defaultOutput), subMonitor.newChild(1));
				
				String executionEnvironmentId = JavaRuntime.getExecutionEnvironmentId(defaultJREContainerEntry.getPath());
				if (executionEnvironmentId != null) {
					BuildPathSupport.setEEComplianceOptions(javaProject, executionEnvironmentId, null);
				}
			} catch (JavaModelException e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	private IClasspathEntry getJreContainerEntry() {
		if(jreContainerEntry == null) {
			return getDefaultJREContainerEntry();
		}
		return jreContainerEntry;
	}
	
	/**
	 * @since 2.9
	 * 
	 * @param jreContainerEntry the JRE to use. If not set the default from <code>JREContainerProvider</code> will be used.
	 * @see org.eclipse.xtext.ui.util.JREContainerProvider#getDefaultJREContainerEntry
	 */
	public void setJreContainerEntry(IClasspathEntry jreContainerEntry) {
		this.jreContainerEntry = jreContainerEntry;
	}
	
	protected void addMoreClasspathEntriesTo(List<IClasspathEntry> classpathEntries) {
	}

	/**
	 * @since 2.9
	 */
	public JavaProjectFactory addClasspathEntries(IClasspathEntry...classpathEntries) {
		this.extraClasspathEntries.addAll(Arrays.asList(classpathEntries));
		return this;
	}

	/**
	 * @since 2.14
	 */
	public List<IClasspathEntry> getExtraClasspathEntries() {
		return extraClasspathEntries;
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
	
	/**
	 * The default output directory, relative to the project root
	 * @since 2.9
	 */
	public JavaProjectFactory setDefaultOutput(String defaultOutput) {
		this.defaultOutput= defaultOutput;
		return this;
	}

	/**
	 * @since 2.15
	 */
	public JavaProjectFactory addSourceFolder(String path, String output, boolean isTest) {
		addFolders(Collections.singletonList(path));
		this.sourceFolderOutputs.put(path, output);
		if (isTest) {
			this.testSourceFolders.add(path);
		}
		return this;
	}
}
