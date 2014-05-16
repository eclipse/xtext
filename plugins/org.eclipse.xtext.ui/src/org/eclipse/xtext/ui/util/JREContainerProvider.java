/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.launching.StandardVMType;
import org.eclipse.jdt.launching.IVMInstall;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.jdt.launching.environments.IExecutionEnvironmentsManager;

import static org.eclipse.jdt.launching.JavaRuntime.*;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.6
 */
public class JREContainerProvider {

	/**
	 * @since 2.6
	 */
	public static IClasspathEntry getDefaultJREContainerEntry() {
		IPath jreContainerPath = getDefaultJREContainerPath();
		return JavaCore.newContainerEntry(jreContainerPath);
	}

	/**
	 * @since 2.6
	 */
	public static IPath getDefaultJREContainerPath() {
		IVMInstall defaultVMInstall = getDefaultVMInstall();
		if (defaultVMInstall == null) {
			return newJRE15ContainerPath();
		}
		IExecutionEnvironmentsManager executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
		IExecutionEnvironment[] executionEnvironments = executionEnvironmentsManager.getExecutionEnvironments();
		for (IExecutionEnvironment executionEnvironment : executionEnvironments) {
			if (executionEnvironment.isStrictlyCompatible(defaultVMInstall)) {
				return newJREContainerPath(executionEnvironment);
			}
		}
		return newJRE15ContainerPath();
	}

	protected static IPath newJRE15ContainerPath() {
		return newJREContainerPath(StandardVMType.ID_STANDARD_VM_TYPE, "J2SE-1.5");
	}

	public static IClasspathEntry getJREContainerEntry(IJavaProject javaProject) throws JavaModelException {
		IClasspathEntry defaultJREContainerEntry = getDefaultJREContainerEntry();

		IClasspathEntry[] rawClasspath = javaProject.getRawClasspath();
		for (IClasspathEntry classpathEntry : rawClasspath) {
			int entryKind = classpathEntry.getEntryKind();
			if (entryKind == IClasspathEntry.CPE_CONTAINER
					&& defaultJREContainerEntry.getPath().isPrefixOf(classpathEntry.getPath())) {
				return classpathEntry;
			}
		}
		return null;
	}

}
