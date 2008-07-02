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
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextMarkerManager {
	private static final String XTEXT_PARSEERROR_MARKER_TYPE = Activator.PLUGIN_ID + ".problemmarker";

	private static void checkResource(final IResource resource) {
		Assert.isLegal(resource != null);
		Assert.isLegal(resource.exists(), "Can't handle Marker for a non existing resource '" + resource.getFullPath()
				+ "'");
		Assert.isLegal(!resource.getResourceAttributes().isReadOnly(), "Can't handle Marker for read only resource'"
				+ resource.getFullPath() + "'");
	}

	private static void run(WorkspaceModifyOperation workspaceModifyOperation, IProgressMonitor monitor) {
		try {
			workspaceModifyOperation.run(monitor);
		}
		catch (InvocationTargetException e) {
			CoreLog.logError(e);
		}
		catch (InterruptedException e) {
			CoreLog.logError(e);
		}
	}

	public static void createMarker(final IResource resource, final Map<String, Object> markerAttributes,
			IProgressMonitor monitor) {
		final String markerType = XTEXT_PARSEERROR_MARKER_TYPE;
		clearMarkerForType(resource, markerAttributes, monitor, markerType);
	}

	/**
	 * @param resource
	 * @param markerAttributes
	 * @param monitor
	 * @param markerType
	 */
	private static void clearMarkerForType(final IResource resource, final Map<String, Object> markerAttributes,
			IProgressMonitor monitor, final String markerType) {
		checkResource(resource);
		run(new WorkspaceModifyOperation() {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				IMarker marker = resource.createMarker(markerType);
				markerAttributes.put(IMarker.LOCATION, resource.getFullPath().toString());
				marker.setAttributes(markerAttributes);
			}
		}, monitor);
	}

	/**
	 * @param resource
	 * @param monitor
	 */
	public static final void clearXtextMarker(final IResource resource, IProgressMonitor monitor) {
		String markerType = XTEXT_PARSEERROR_MARKER_TYPE;
		clearMarkerForType(resource, monitor, markerType);
	}

	/**
	 * @param resource
	 * @param monitor
	 */
	public static void clearEMFMarker(IResource resource, IProgressMonitor monitor) {
		String markerType = Diagnostician.MARKER;
		clearMarkerForType(resource, monitor, markerType);
	}

	/**
	 * @param resource
	 * @param monitor
	 * @param markerType
	 */
	private static void clearMarkerForType(final IResource resource, IProgressMonitor monitor, final String markerType) {
		checkResource(resource);
		run(new WorkspaceModifyOperation() {
			@Override
			protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				resource.deleteMarkers(markerType, true, IResource.DEPTH_INFINITE);
			}
		}, monitor);
	}

}
