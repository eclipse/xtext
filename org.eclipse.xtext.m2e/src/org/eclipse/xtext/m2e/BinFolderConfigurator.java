/*******************************************************************************
 * Copyright (c) 2019 Sebastian Zarnekow (szarnekow) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.m2e;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ProjectScope;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;

/**
 * Optionally compile everything to {@code bin} and {@code bin-test} instead of {@code target/classes} and {@code target/test-classes}.
 * 
 * @since 2.21
 */
public class BinFolderConfigurator extends AbstractProjectConfigurator {

	@Override
	public void configure(ProjectConfigurationRequest request, IProgressMonitor monitor) throws CoreException {
		IProject project = XtextProjectConfigurator.getProject(request);
		if (compileToBin(project)) {
			IPath projectRoot = project.getFullPath();
			IPath binPath = projectRoot.append("bin");
			IPath binTestPath = projectRoot.append("bin-test");
			IJavaProject javaProject = JavaCore.create(project);
			javaProject.setOutputLocation(binPath, monitor);

			IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
			for (int i = 0; i < rawClasspath.length; i++) {
				IClasspathEntry entry = rawClasspath[i];
				if (entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
					if (isTest(entry)) {
						rawClasspath[i] = copyWithOutput(entry, binTestPath);
					} else {
						rawClasspath[i] = copyWithOutput(entry, binPath);
					}
				}
			}
			javaProject.setRawClasspath(rawClasspath, monitor);
		}
	}

	/**
	 * IClasspathEntry.isTest is not avaiable on Oxygen.
	 */
	@Deprecated
	private boolean isTest(IClasspathEntry entry) {
		for (IClasspathAttribute attribute : entry.getExtraAttributes()) {
			if ("test".equals(attribute.getName()) && "true".equals(attribute.getValue())) //$NON-NLS-1$
				return true;
		}
		return false;
	}

	/**
	 * Copy a classpath entry and sets the given output path instead of the original path.
	 */
	private IClasspathEntry copyWithOutput(IClasspathEntry entry, IPath output) {
		return JavaCore.newSourceEntry(entry.getPath(), entry.getInclusionPatterns(), entry.getExclusionPatterns(), output, entry.getExtraAttributes());
	}

	/**
	 * Read a setting from the project scope (higher prio) or the instance scope (lower prio) to decide if Eclipse should use its own output
	 * dir or compile to the maven standard output directories.
	 * 
	 * Defaults to {@code false}.
	 */
	private boolean compileToBin(IProject project) {
		String pluginId = "org.eclipse.xtext.m2e";
		String key = "compileToBin";
		ProjectScope projectScope = new ProjectScope(project);
		IEclipsePreferences projectPreferences = projectScope.getNode(pluginId);
		String value = projectPreferences.get(key, null);
		if (value != null) {
			return "true".equals(value);
		}
		IEclipsePreferences instancePreferences = InstanceScope.INSTANCE.getNode(pluginId);
		return "true".equals(instancePreferences.get(key, "false"));
	}

}
