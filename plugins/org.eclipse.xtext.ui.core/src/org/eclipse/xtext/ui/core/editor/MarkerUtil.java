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
import java.util.ArrayList;
import java.util.HashMap;
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
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.CheckType;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public class MarkerUtil {
	
	private static final Logger log = Logger.getLogger(MarkerUtil.class);

	public static final String CHECK_MARKER_ID = "org.eclipse.xtext.ui.core.check";

	public static final String EXPENSIVE_CHECK_MARKER_ID = "org.eclipse.xtext.ui.core.check.expensive";

	public static final String NORMAL_CHECK_MARKER_ID = "org.eclipse.xtext.ui.core.check.normal";

	public static final String FAST_CHECK_MARKER_ID = "org.eclipse.xtext.ui.core.check.fast";

	public static final String DEFAULT_MARKER_ID = EValidator.MARKER;

	private static Map<CheckMode, List<String>> checkMode2MarkerIDs = new HashMap<CheckMode, List<String>>();

	public static final class AddMarkersOperation extends WorkspaceModifyOperation {

		private final List<Map<String, Object>> issues;
		private final IFile file;
		private final CheckMode checkMode;
		private final boolean deleteMarkers;

		public AddMarkersOperation(ISchedulingRule rule, List<Map<String, Object>> issues, IFile file, CheckMode checkMode,
				boolean deleteMarkers) {
			super(rule);
			this.issues = issues;
			this.file = file;
			this.checkMode = checkMode;
			this.deleteMarkers = deleteMarkers;
		}

		@Override
		protected void execute(final IProgressMonitor monitor) throws CoreException, InvocationTargetException,
				InterruptedException {
			if (!file.exists())
				return;
			if (deleteMarkers)
				for (String markerID : getMarkerIDs(checkMode)) {
					file.deleteMarkers(markerID, true, IResource.DEPTH_INFINITE);
				}
			if (!issues.isEmpty()) {
				// update
				for (Map<String, Object> map : issues) {
					if (monitor.isCanceled())
						return;
					Diagnostic diagnostic = (Diagnostic) map.get(IXtextResourceChecker.DIAGNOSTIC_KEY);
					map.remove(IXtextResourceChecker.DIAGNOSTIC_KEY);
					String markerID = getMarkerID(diagnostic);
					IMarker marker = file.createMarker(markerID);
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

	public static void addMarkers(final IFile file, final List<Map<String, Object>> issues, CheckMode checkMode, boolean deleteOldMarkers, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(file), issues, file, checkMode, deleteOldMarkers)
					.run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}
	
	public static String getMarkerID(Diagnostic diagnostic) {
		if (diagnostic instanceof AbstractDeclarativeValidator.DiagnosticImpl) {
			CheckType checkType = ((AbstractDeclarativeValidator.DiagnosticImpl) diagnostic).getCheckType();
			if (checkType != null) {
				String markerID = getMarkerID(checkType);
				if (markerID != null)
					return markerID;
			}
		}
		return DEFAULT_MARKER_ID;
	}

	private static String getMarkerID(CheckType checkType) {
		switch (checkType) {
			case EXPENSIVE:
				return EXPENSIVE_CHECK_MARKER_ID;
			case FAST:
				return FAST_CHECK_MARKER_ID;
			case NORMAL:
				return NORMAL_CHECK_MARKER_ID;
			default:
				log.warn("No marker type defined for " + checkType.name());
		}
		return null;
	}

	public static List<String> getMarkerIDs(CheckMode checkMode) {
		List<String> markerIDs = checkMode2MarkerIDs.get(checkMode);
		if (markerIDs == null) {
			markerIDs = new ArrayList<String>();
			for (CheckType checkType : CheckType.values()) {
				if (checkMode.shouldCheck(checkType)) {
					markerIDs.add(getMarkerID(checkType));
				}
			}
			markerIDs.add(DEFAULT_MARKER_ID);
			checkMode2MarkerIDs.put(checkMode, markerIDs);
		}
		return markerIDs;
	}
}
