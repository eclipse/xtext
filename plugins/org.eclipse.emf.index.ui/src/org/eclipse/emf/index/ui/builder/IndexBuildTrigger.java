/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.builder;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.eclipse.ui.IStartup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class IndexBuildTrigger implements IStartup {

	public void earlyStartup() {
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				if (project.isAccessible()) {
					IProjectDescription description = project.getDescription();
					if (description.hasNature(EmfIndexNature.NATURE_ID)) {
						Job builderJob = new Job("EMF Index: indexing " + project.getName()) {
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								try {
									project.build(IncrementalProjectBuilder.CLEAN_BUILD, EmfIndexBuilder.BUILDER_ID,
											null, monitor);
								}
								catch (CoreException e) {
									Status status = new Status(IStatus.ERROR, EmfIndexUIPlugin.PLUGIN_ID,
											"Error indexing project " + project.getName(), e);
									EmfIndexUIPlugin.getDefault().getLog().log(status);
									return status;
								}
								return Status.OK_STATUS;
							}
						};
						builderJob.schedule();
					}
				}
			}
			catch (CoreException ce) {
				Status status = new Status(IStatus.ERROR, EmfIndexUIPlugin.PLUGIN_ID,
						"Error getting project description of " + project.getName(), ce);
				EmfIndexUIPlugin.getDefault().getLog().log(status);
			}
		}
	}

}
