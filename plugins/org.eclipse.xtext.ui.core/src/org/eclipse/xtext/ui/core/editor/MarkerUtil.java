/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.ui.actions.WorkspaceModifyOperation;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class MarkerUtil {
	
	private static final Logger log = Logger.getLogger(MarkerUtil.class);

	public static final class AddMarkersOperation extends WorkspaceModifyOperation {

		private final List<Map<String, Object>> issues;
		private final IFile file;
		private final String markerId;
		private final boolean deleteMarkers;

		public AddMarkersOperation(ISchedulingRule rule, List<Map<String, Object>> issues, IFile file, String markerId,
				boolean deleteMarkers) {
			super(rule);
			this.issues = issues;
			this.file = file;
			this.markerId = markerId;
			this.deleteMarkers = deleteMarkers;
		}

		@Override
		protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
				InterruptedException {
			if (!file.exists())
				return;
			if (deleteMarkers)
				file.deleteMarkers(markerId, true, IResource.DEPTH_ZERO);
			if (!issues.isEmpty()) {
				// update
				for (Map<String, Object> map : issues) {
					if (monitor.isCanceled())
						return;
					IMarker marker = file.createMarker(markerId);
					Object lNr = map.get(IMarker.LINE_NUMBER);
					String lineNR = "";
					if (lNr != null) {
						lineNR = "line: " + lNr + " ";
					}
					map.put(IMarker.LOCATION, lineNR + file.getFullPath().toString());
					marker.setAttributes(map);
				}
			}
		}
	}

	public static void addMarkers(final IFile file, final List<Map<String, Object>> issues, String markerId, boolean deleteOldMarkers, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(file), issues, file, markerId, deleteOldMarkers)
					.run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}
}
