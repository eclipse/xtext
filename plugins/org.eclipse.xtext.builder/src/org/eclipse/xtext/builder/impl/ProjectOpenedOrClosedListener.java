/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.xtext.builder.builderState.IBuilderState;

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
	
	public void resourceChanged(IResourceChangeEvent event) {
		if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
			try {
				event.getDelta().accept(new IResourceDeltaVisitor() {

					public boolean visit(IResourceDelta delta) throws CoreException {
						if (delta.getResource() instanceof IWorkspaceRoot)
							return true;
						if (delta.getResource() instanceof IProject) {
							IProject project = (IProject) delta.getResource();
							if ((delta.getFlags() & IResourceDelta.OPEN) != 0 && project.isOpen()) {
								ToBeBuilt toBeBuilt = toBeBuiltComputer.updateProject(project, new NullProgressMonitor());
								builderState.update(toBeBuilt.getToBeUpdated(), toBeBuilt.getToBeDeleted());
							}
						}
						return false;
					}
				});
			} catch (CoreException e) {
				log.error(e);
			}
		}
		if ((event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
			if (event.getResource() instanceof IProject) {
				ToBeBuilt toBeBuilt = toBeBuiltComputer.removeProject((IProject) event.getResource(), new NullProgressMonitor());
				builderState.update(toBeBuilt.getToBeUpdated(), toBeBuilt.getToBeDeleted());
			}
		}
	}
}
