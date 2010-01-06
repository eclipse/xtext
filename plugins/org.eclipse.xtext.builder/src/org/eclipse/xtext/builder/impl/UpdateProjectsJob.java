/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;

public class UpdateProjectsJob extends Job {
	
	private final static Logger log = Logger.getLogger(UpdateProjectsJob.class);

	private Set<IProject> projects;
	private ToBeBuiltComputer toBeBuiltComputer;
	private IBuilderState builderState;
	private IResourceSetProvider resourceSetProvider;

	public UpdateProjectsJob(String name, IResourceSetProvider resourceSetProvider, Set<IProject> projects, ToBeBuiltComputer toBeBuiltComputer, IBuilderState builderState) {
		super(name);
		this.projects = projects;
		this.toBeBuiltComputer = toBeBuiltComputer;
		this.builderState = builderState;
		this.resourceSetProvider = resourceSetProvider;
		setRule(ResourcesPlugin.getWorkspace().getRoot());
	}
	
	@Override
	public boolean belongsTo(Object family) {
		return family == ResourcesPlugin.FAMILY_AUTO_BUILD;
	}

	@Override
	protected IStatus run(IProgressMonitor monitor) {
		try {
			new WorkspaceModifyOperation(getRule()) {
	
				@Override
				protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
						InterruptedException {
					for (IProject project : projects) {
						try {
							ToBeBuilt updateProject = toBeBuiltComputer.updateProject(project, monitor);
							builderState.update(resourceSetProvider.get(project), 
									updateProject.getToBeUpdated(), updateProject.getToBeDeleted(), monitor);
						} catch (CoreException e) {
							log.error(e.getMessage(), e);
						}
					}
				}
				
			}.run(monitor);
		} catch (InvocationTargetException e) {
			log.error(e.getMessage(), e);
		} catch (InterruptedException e) {
			log.error(e.getMessage(), e);
		}
		
		return Status.OK_STATUS;
	}

}