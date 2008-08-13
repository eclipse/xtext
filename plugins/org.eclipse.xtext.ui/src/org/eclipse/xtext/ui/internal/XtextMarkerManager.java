/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.internal;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public final class XtextMarkerManager {
	
	private static final Logger log = Logger.getLogger(XtextMarkerManager.class);
	
	public static final String XTEXT_PARSEERROR_MARKER_TYPE = Activator.PLUGIN_ID + ".problemmarker";

	private XtextMarkerManager() {
	}

	private static final void checkResource(final IResource resource) {
		Assert.isLegal(resource != null);
		Assert.isLegal(resource.exists(), "Can't handle Marker for a non existing resource '" + resource.getFullPath()
				+ "'");
		Assert.isLegal(!resource.getResourceAttributes().isReadOnly(), "Can't handle Marker for read only resource'"
				+ resource.getFullPath() + "'");
	}

	private static final void run(WorkspaceModifyOperation workspaceModifyOperation, IProgressMonitor monitor) {
		try {
			workspaceModifyOperation.run(monitor);
		}
		catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		}
		catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}

	private final static void createMarkerForType(final IResource resource,
			final List<Map<String, Object>> markerAttributes, final String markerType) throws CoreException {
		for (Map<String, Object> map : markerAttributes) {
			IMarker marker = resource.createMarker(markerType);
			map.put(IMarker.LOCATION, resource.getFullPath().toString());
			marker.setAttributes(map);
		}

	}

	/**
	 * @param resource
	 * @param monitor
	 */
	public static final void clearXtextMarker(final IResource resource, IProgressMonitor monitor) {
		clearMarkerForType(resource, monitor, XTEXT_PARSEERROR_MARKER_TYPE);
	}

	/**
	 * @param resource
	 * @param monitor
	 */
	public static final void clearEMFMarker(IResource resource, IProgressMonitor monitor) {
		clearMarkerForType(resource, monitor, Diagnostician.MARKER);
	}

	/**
	 * @param resource
	 * @param monitor
	 * @param markerType
	 */
	public static final void clearMarkerForType(final IResource resource, IProgressMonitor monitor,
			final String markerType) {
		checkResource(resource);
		run(new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource)) {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				resource.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
			}
		}, monitor);
	}

	/**
	 * Creates marker by type in one operation
	 * 
	 * @param resource
	 * @param markerAttributesByType
	 *            a map contains a List of marker attributes by type
	 * @param monitor
	 */
	public static final void createMarker(final IResource resource,
			final Map<String, List<Map<String, Object>>> markerAttributesByType, IProgressMonitor monitor) {
		checkResource(resource);
		run(new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource)) {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				for (String markerType : markerAttributesByType.keySet()) {
					createMarkerForType(resource, markerAttributesByType.get(markerType), markerType);
				}
			}
		}, monitor);
	}
}
