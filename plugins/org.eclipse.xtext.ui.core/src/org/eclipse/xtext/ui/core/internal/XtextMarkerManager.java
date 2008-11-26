/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.internal;

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
 * @author Sven Efftinge
 */
public final class XtextMarkerManager {

	private static final String MARKER_ID = Diagnostician.MARKER;

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

	/**
	 * @param resource
	 * @param monitor
	 * @param markerType
	 */
	public static final void clearMarkers(final IResource resource, IProgressMonitor monitor) {
		checkResource(resource);
		run(new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource)) {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				resource.deleteMarkers(MARKER_ID, true, IResource.DEPTH_INFINITE);
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
	public static final void createMarker(final IResource resource, final List<Map<String, Object>> markerAttributes,
			IProgressMonitor monitor) {
		checkResource(resource);
		run(new WorkspaceModifyOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(resource)) {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				for (Map<String, Object> map : markerAttributes) {
					IMarker marker = resource.createMarker(MARKER_ID);
					Object lNr = map.get(IMarker.LINE_NUMBER);
					String lineNR = "";
					if (lNr != null) {
						lineNR = "line: " + lNr + " ";
					}
					map.put(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
					marker.setAttributes(map);
				}
			}
		}, monitor);
	}
}
