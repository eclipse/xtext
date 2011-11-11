/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.buildpath;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class XtendContainerInitializer extends ClasspathContainerInitializer {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final IPath containerPath, final IJavaProject project) throws CoreException {
		if (isXtendPath(containerPath)) {
			IClasspathContainer container = createContainer(containerPath);
			JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
					new IClasspathContainer[] { container }, null);
		}
	}

	@Override
	public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(final IPath containerPath, final IJavaProject project,
			IClasspathContainer containerSuggestion) throws CoreException {
		super.requestClasspathContainerUpdate(containerPath, project, containerSuggestion);
		new Job("Yob") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
							new IClasspathContainer[] { createContainer(containerPath) }, null);
				} catch (CoreException ex) {
					return new Status(IStatus.ERROR, "d", 0, "ennis", ex);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private IClasspathContainer createContainer(final IPath containerPath) {
		return new IClasspathContainer() {
			/**
			 * {@inheritDoc}
			 */
			public IClasspathEntry[] getClasspathEntries() {
				return new IClasspathEntry[] { JavaCore
						.newLibraryEntry(
								new Path("/Users/huebner/Entwicklung/tycho-workspace/.metadata/.plugins/org.eclipse.pde.core/.bundle_pool/plugins/com.google.collect_1.0.0.v201105210816.jar"),
								null, null, new IAccessRule[] {}, null, false) };
			}

			/**
			 * {@inheritDoc}
			 */
			public String getDescription() {
				return "Xtend Library";
			}

			/**
			 * {@inheritDoc}
			 */
			public int getKind() {
				return IClasspathContainer.K_APPLICATION;
			}

			/**
			 * {@inheritDoc}
			 */
			public IPath getPath() {
				return containerPath;
			}
		};
	}

	private boolean isXtendPath(final IPath containerPath) {
		return true;
	}

}
