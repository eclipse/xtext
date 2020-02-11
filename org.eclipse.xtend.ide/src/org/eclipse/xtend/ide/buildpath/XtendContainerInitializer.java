/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.buildpath;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.ide.internal.XtendActivator;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendContainerInitializer extends ClasspathContainerInitializer {

	public static final Path XTEND_LIBRARY_PATH = new Path("org.eclipse.xtend.XTEND_CONTAINER"); //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final IPath containerPath, final IJavaProject project) throws CoreException {
		if (isXtendPath(containerPath)) {
			IClasspathContainer container = new XtendClasspathContainer(containerPath);
			JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
					new IClasspathContainer[] { container }, null);
		}
	}

	/**
	 * Allows users to manually add source bundles
	 */
	@Override
	public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(final IPath containerPath, final IJavaProject project,
			final IClasspathContainer containerSuggestion) throws CoreException {
		super.requestClasspathContainerUpdate(containerPath, project, containerSuggestion);
		new Job("Classpath container update") { //$NON-NLS-1$
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
							new IClasspathContainer[] { containerSuggestion }, monitor);
				} catch (CoreException ex) {
					return new Status(IStatus.ERROR, XtendActivator.getInstance().getBundle().getSymbolicName(), 0,
							"Classpath container update failed", ex); //$NON-NLS-1$
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private boolean isXtendPath(final IPath containerPath) {
		return XTEND_LIBRARY_PATH.equals(containerPath);
	}

}
