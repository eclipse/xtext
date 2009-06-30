/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.ui.builder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.index.IPersistableIndexStore;
import org.eclipse.emf.index.IndexStore;
import org.eclipse.emf.index.ecore.EcoreIndexFeeder;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchListener;
import org.eclipse.ui.PlatformUI;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
@Singleton
public class IndexStartupInitializer implements IStartup {

	@Inject
	private IndexStore index;

	@Inject
	private EcoreIndexFeeder ecoreIndexFeeder;

	public void earlyStartup() {

		try {
			File indexFile = EmfIndexUIPlugin.getIndexFile();
			if (indexFile.exists()) {
				((IPersistableIndexStore) index).load(new FileInputStream(indexFile));
			}
		}
		catch (Exception e) {
			EmfIndexUIPlugin.logError("Error loading EMF index", e);
		}

		try {
			ecoreIndexFeeder.feedEPackagesFromRegistry();
		}
		catch (Exception exc) {
			EmfIndexUIPlugin.logError("Error indexing EPackage registry", exc);
		}

		buildAll();

		if (index instanceof IPersistableIndexStore) {
			IWorkbench workbench = PlatformUI.getWorkbench();
			if (workbench != null) {
				workbench.addWorkbenchListener(new IWorkbenchListener() {
					public boolean preShutdown(IWorkbench workbench, boolean forced) {
						try {
							((IPersistableIndexStore) index)
									.save(new FileOutputStream(EmfIndexUIPlugin.getIndexFile()));
						}
						catch (Exception e) {
							EmfIndexUIPlugin.logError("Error saving EMF index", e);
						}
						return true;
					}

					public void postShutdown(IWorkbench workbench) {
						// do nothing.
					}
				});
			}
		}
	}

	public static void buildAll() {
		for (final IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			try {
				if (project.isAccessible()) {
					IProjectDescription description = project.getDescription();
					if (description.hasNature(EmfIndexNature.NATURE_ID)) {
						Job builderJob = new Job("EMF Index: indexing " + project.getName()) {
							@Override
							protected IStatus run(IProgressMonitor monitor) {
								try {
									project.build(IncrementalProjectBuilder.CLEAN_BUILD,
											EmfIndexProjectBuilder.BUILDER_ID, null, monitor);
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
				EmfIndexUIPlugin.logError("Error getting project description of " + project.getName(), ce);
			}
		}
	}
}
