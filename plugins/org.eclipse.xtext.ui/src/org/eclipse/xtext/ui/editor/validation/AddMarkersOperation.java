/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.validation.Issue;

import com.google.common.collect.ImmutableList;

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
	private final ImmutableList<String> markerIds;

	private MarkerCreator markerCreator;

	@Deprecated
	public AddMarkersOperation(IResource resource, List<Issue> issues, String markerId,
			boolean deleteMarkers, MarkerCreator markerCreator) {
		this(resource, issues, Collections.singleton(markerId), deleteMarkers, markerCreator);
	}
	
	public AddMarkersOperation(IResource resource, List<Issue> issues, Set<String> markerIds,
			boolean deleteMarkers, MarkerCreator markerCreator) {
		super(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource));
		this.issues = issues;
		this.markerIds = ImmutableList.copyOf(markerIds);
		this.resource = resource;
		this.deleteMarkers = deleteMarkers;
		this.markerCreator = markerCreator;
	}

	/**
	 * @return the first markerID if any. 
	 * @deprecated use {@link #getMarkerIds()} instead.
	 */
	@Deprecated
	public String getMarkerId() {
		if (markerIds.isEmpty())
			return null;
		return markerIds.iterator().next();
	}

	public ImmutableList<String> getMarkerIds() {
		return markerIds;
	}
	
	@Override
	protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
			InterruptedException {
		if (!resource.exists())
			return;
		if (deleteMarkers) {
			for(String markerId: getMarkerIds()) {
				resource.deleteMarkers(markerId, false, IResource.DEPTH_INFINITE);	
			}
		}
		if (!issues.isEmpty()) {
			// update
			for (Issue issue : issues) {
				if (monitor.isCanceled())
					return;
				markerCreator.createMarker(issue, resource, MarkerTypes.forCheckType(issue.getType()));
			}
		}
	}

}
