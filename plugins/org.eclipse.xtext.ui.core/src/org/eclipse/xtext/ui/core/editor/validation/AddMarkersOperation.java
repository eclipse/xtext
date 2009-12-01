/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AddMarkersOperation extends WorkspaceModifyOperation {

	@SuppressWarnings("unused")
	private final static Logger log = Logger.getLogger(AddMarkersOperation.class);

	private final List<Issue> issues;
	private final IResource resource;
	private final boolean deleteMarkers;
	private final String markerId;

	private MarkerCreator markerCreator;

	public AddMarkersOperation(IResource resource, List<Issue> issues, String markerId,
			boolean deleteMarkers, MarkerCreator markerCreator) {
		super(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource));
		this.issues = issues;
		this.markerId = markerId;
		this.resource = resource;
		this.deleteMarkers = deleteMarkers;
		this.markerCreator = markerCreator;
	}

	public String getMarkerId() {
		return markerId;
	}

	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		if (!resource.exists())
			return;
		if (deleteMarkers)
			resource.deleteMarkers(getMarkerId(), false, IResource.DEPTH_INFINITE);
		if (!issues.isEmpty()) {
			// update
			for (Issue issue : issues) {
				if (monitor.isCanceled())
					return;
				markerCreator.createMarker(issue,resource,getMarkerId());
			}
		}
	}

	

}
