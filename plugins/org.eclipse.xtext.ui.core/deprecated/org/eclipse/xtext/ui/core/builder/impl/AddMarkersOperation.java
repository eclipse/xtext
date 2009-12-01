/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.builder.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
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

	public AddMarkersOperation(IResource resource, List<Issue> issues, String markerId,
			boolean deleteMarkers) {
		super(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource));
		this.issues = issues;
		this.markerId = markerId;
		this.resource = resource;
		this.deleteMarkers = deleteMarkers;
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
				IMarker marker = resource.createMarker(getMarkerId());
				String lineNR = "";
				if (issue.getLineNumber() != null) {
					lineNR = "line: " + issue.getLineNumber() + " ";
				}
				marker.setAttribute(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
				marker.setAttribute(IMarker.CHAR_START, issue.getOffset());
				marker.setAttribute(IMarker.CHAR_END, issue.getOffset()+issue.getLength());
				marker.setAttribute(IMarker.LINE_NUMBER, issue.getLineNumber());
				marker.setAttribute(IMarker.MESSAGE, issue.getMessage());
				marker.setAttribute(IMarker.SEVERITY, getSeverity(issue));
				marker.setAttribute(Issue.CODE_KEY, issue.getCode());
				marker.setAttribute(Issue.URI_KEY, issue.getUriToProblem());
			}
		}
	}

	private Object getSeverity(Issue issue) {
		switch (issue.getSeverity()) {
			case ERROR : 
				return IMarker.SEVERITY_ERROR;
			case WARNING : 
				return IMarker.SEVERITY_WARNING;
			case INFO : 
				return IMarker.SEVERITY_INFO;
		}
		throw new IllegalArgumentException();
	}

}
