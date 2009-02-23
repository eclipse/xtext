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
import org.eclipse.emf.index.IIndexStore;
import org.eclipse.emf.index.ecore.EPackageRegistryIndexFeeder;
import org.eclipse.emf.index.ui.internal.EmfIndexUIPlugin;
import org.eclipse.ui.IStartup;

public class IndexBuildTrigger implements IStartup {

	public void earlyStartup() {
		new Job("EMF index: Indexing EPackages in EPackage registry") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				EPackageRegistryIndexFeeder.feedEPackagesFromRegistry(IIndexStore.eINSTANCE);
				return Status.OK_STATUS;
			}
		}.schedule();
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
