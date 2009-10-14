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
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 */
public class AddMarkersOperation extends WorkspaceModifyOperation {

	private final static Logger log = Logger.getLogger(AddMarkersOperation.class);

	private final List<Map<String, Object>> issues;
	private final IResource resource;
	private final boolean deleteMarkers;
	private final String markerId;

	public AddMarkersOperation(IResource resource, List<Map<String, Object>> issues, String markerId,
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
			for (Map<String, Object> map : issues) {
				if (monitor.isCanceled())
					return;
				IMarker marker = resource.createMarker(getMarkerId());
				Object lNr = map.get(IMarker.LINE_NUMBER);
				String lineNR = "";
				if (lNr != null) {
					lineNR = "line: " + lNr + " ";
				}
				map.put(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
				for (Entry<String, Object> entry : map.entrySet()) {
					try {
						marker.setAttribute(entry.getKey(),entry.getValue());
					} catch (IllegalArgumentException e) {
						log.debug("Couldn't set attribute '" +entry.getKey()+"' : "+e.getMessage());
					}
				}
			}
		}
	}

	public static void run(final IResource resource, final List<Map<String, Object>> issues, boolean deleteOldMarkers,
			IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(resource, issues, EValidator.MARKER, deleteOldMarkers).run(monitor);
		}
		catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		}
		catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}

}
