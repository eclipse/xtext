/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ProjectOpenedOrClosedListener implements IResourceChangeListener {

	private final static Logger log = Logger.getLogger(ProjectOpenedOrClosedListener.class);

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	public void resourceChanged(final IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			try {
				final Set<IProject> toUpdate = Sets.newLinkedHashSet();
				event.getDelta().accept(new IResourceDeltaVisitor() {

					public boolean visit(IResourceDelta delta) throws CoreException {
						if (delta.getResource() instanceof IWorkspaceRoot)
							return true;
						if (delta.getResource() instanceof IProject) {
							IProject project = (IProject) delta.getResource();
							if ((delta.getFlags() & IResourceDelta.OPEN) != 0 && project.isOpen()) {
								toUpdate.add(project);
							}
						}
						return false;
					}
				});
				if (!toUpdate.isEmpty())
					new UpdateProjectsJob("updating projects", resourceSetProvider, toUpdate, toBeBuiltComputer,
							builderState).schedule();
			} catch (CoreException e) {
				log.error(e);
			}
		}
		if ((event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
			if (event.getResource() instanceof IProject) {
				final ToBeBuilt toBeBuilt = toBeBuiltComputer.removeProject((IProject) event.getResource(),
						new NullProgressMonitor());
				new Job("removing project " + event.getResource().getName() + " from xtext index.") {
					{
						setRule(ResourcesPlugin.getWorkspace().getRoot());
						this.belongsTo(ResourcesPlugin.FAMILY_AUTO_BUILD);
					}

					@Override
					protected IStatus run(IProgressMonitor monitor) {
						builderState.update(getResourceSetProvider().get(event.getResource().getProject()), toBeBuilt
								.getToBeUpdated(), toBeBuilt.getToBeDeleted(), monitor);
						return Status.OK_STATUS;
					}
				}.schedule();
			}
		}
	}

}
