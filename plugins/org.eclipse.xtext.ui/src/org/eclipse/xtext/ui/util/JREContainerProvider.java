/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import static org.eclipse.jdt.launching.JavaRuntime.*;

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

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.6
 */
public class JREContainerProvider {

	/**
	 * @since 2.7
	 */
	public static final String PREFERRED_BREE = "JavaSE-1.6";
	private static IVMInstall defaultVMInstall = null;
	private static boolean defaultVMinitialized = false;

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
		if (defaultVMInstall() != null) {
			IExecutionEnvironmentsManager executionEnvironmentsManager = JavaRuntime.getExecutionEnvironmentsManager();
			IExecutionEnvironment[] executionEnvironments = executionEnvironmentsManager.getExecutionEnvironments();
			for (IExecutionEnvironment executionEnvironment : executionEnvironments) {
				if (executionEnvironment.isStrictlyCompatible(defaultVMInstall())) {
					return newJREContainerPath(executionEnvironment);
				}
			}
		}
		return newPreferredContainerPath();
	}

	private static IVMInstall defaultVMInstall() {
		if (!defaultVMinitialized) {
			// remember result - getDefaultVMInstall() is very expensive operation
			defaultVMInstall = getDefaultVMInstall();
			defaultVMinitialized = true;
		}
		return defaultVMInstall;
	}

	/**
	 * @return JRE container path {@link IPath} for standard VM "J2SE-1.5"
	 */
	protected static IPath newJRE15ContainerPath() {
		return newJREContainerPath(StandardVMType.ID_STANDARD_VM_TYPE, "J2SE-1.5");
	}

	/**
	 * @deprecated use {@link #newPreferredContainerPath()} instead
	 * @since 2.7
	 */
	@Deprecated
	protected static IPath newPrefferedContainerPath() {
		return newPreferredContainerPath();
	}

	/**
	 * @since 2.8
	 * @return JRE container path {@link IPath} for standard VM {@value #PREFERRED_BREE}
	 */
	protected static IPath newPreferredContainerPath() {
		return newJREContainerPath(StandardVMType.ID_STANDARD_VM_TYPE, PREFERRED_BREE);
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
	
	/**
	 * @since 2.9
	 */
	public static IClasspathEntry getJREContainerEntry(String bree)  {
		IClasspathEntry jreContainerEntry = getDefaultJREContainerEntry();
		IExecutionEnvironment ee = JavaRuntime.getExecutionEnvironmentsManager().getEnvironment(bree);
		if(ee != null) {
			return JavaCore.newContainerEntry(newJREContainerPath(ee));
		}
		return jreContainerEntry;
	}

	/**
	 * @since 2.7
	 */
	public static String getDefaultBREE() {
		return getDefaultJREContainerPath().lastSegment();
	}
}
