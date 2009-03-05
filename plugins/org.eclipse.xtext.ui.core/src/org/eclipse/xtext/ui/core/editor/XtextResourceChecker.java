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
import java.util.Iterator;
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextResourceChecker {

	private static final int MAX_ERRORS = 99;
	private static final Logger log = Logger.getLogger(XtextResourceChecker.class);

	private XtextResourceChecker() {
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 * 
	 */
	public static final class AddMarkersOperation extends WorkspaceModifyOperation {
		/**
		 * 
		 */
		private final List<Map<String, Object>> issues;
		private IFile file;
		private String markerId;
		private boolean deleteMarkers;

		/**
		 * @param rule
		 * @param issues
		 */
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
			if (deleteMarkers)
				file.deleteMarkers(markerId, true, IResource.DEPTH_INFINITE);
			if (!issues.isEmpty()) {
				// update
				for (Map<String, Object> map : issues) {
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

	public static void addMarkers(final IFile file, final List<Map<String, Object>> issues, boolean deleteOldMarkers, IProgressMonitor monitor) {
		try {
			new AddMarkersOperation(ResourcesPlugin.getWorkspace().getRuleFactory().markerRule(file), issues, file, EValidator.MARKER, deleteOldMarkers)
					.run(monitor);
		} catch (InvocationTargetException e) {
			log.error("Could not create marker.", e);
		} catch (InterruptedException e) {
			log.error("Could not create marker.", e);
		}
	}

	/**
	 * Checks an {@link XtextResource}
	 * 
	 * @param resource
	 * @return a {@link List} of {@link IMarker} attributes
	 */
	public static List<Map<String, Object>> check(final Resource resource, Map<?, ?> context) {
		List<Map<String, Object>> markers = new ArrayList<Map<String, Object>>();
		try {
			// Syntactical errors
			// Collect EMF Resource Diagnostics
			for (org.eclipse.emf.ecore.resource.Resource.Diagnostic error : resource.getErrors())
				markers.add(markerFromXtextResourceDiagnostic(error, IMarker.SEVERITY_ERROR));
			for (org.eclipse.emf.ecore.resource.Resource.Diagnostic warning : resource.getWarnings())
				markers.add(markerFromXtextResourceDiagnostic(warning, IMarker.SEVERITY_WARNING));
			boolean syntaxDiagFail = !markers.isEmpty();
			logCheckStatus(resource, syntaxDiagFail, "Syntax");

			for (EObject ele : resource.getContents()) {
				try {
					Diagnostic diagnostic = Diagnostician.INSTANCE.validate(ele, context);
					if (!diagnostic.getChildren().isEmpty()) {
						for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
							markers.add(markerFromEValidatorDiagnostic(childDiagnostic));
							if (markers.size() > MAX_ERRORS)
								return markers;
						}
					} else {
						markers.add(markerFromEValidatorDiagnostic(diagnostic));
						if (markers.size() > MAX_ERRORS)
							return markers;
					}
				} catch (RuntimeException e) {
					log.error(e.getMessage(), e);
				}
			}
		} catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return markers;
	}

	private static void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}

	private static Map<String, Object> markerFromXtextResourceDiagnostic(
			org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic, Object severity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, severity);
		map.put(IMarker.LINE_NUMBER, diagnostic.getLine());
		map.put(IMarker.MESSAGE, diagnostic.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));

		if (diagnostic instanceof org.eclipse.xtext.diagnostics.Diagnostic) {
			org.eclipse.xtext.diagnostics.Diagnostic xtextDiagnostic = (org.eclipse.xtext.diagnostics.Diagnostic) diagnostic;
			map.put(IMarker.CHAR_START, xtextDiagnostic.getOffset());
			map.put(IMarker.CHAR_END, xtextDiagnostic.getOffset() + xtextDiagnostic.getLength());
		}

		return map;
	}

	private static Map<String, Object> markerFromEValidatorDiagnostic(Diagnostic diagnostic) {
		Map<String, Object> map = new HashMap<String, Object>();
		int sever = IMarker.SEVERITY_ERROR;
		switch (diagnostic.getSeverity()) {
		case Diagnostic.WARNING:
			sever = IMarker.SEVERITY_WARNING;
			break;
		case Diagnostic.OK:
		case Diagnostic.INFO:
			sever = IMarker.SEVERITY_INFO;
			break;
		}
		map.put(IMarker.SEVERITY, sever);
		Iterator<?> data = diagnostic.getData().iterator();
		// causer is the first element see Diagnostician.getData
		Object causer = data.next();
		if (causer instanceof EObject) {
			EObject ele = (EObject) causer;
			NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ele);
			if (nodeAdapter != null && data.hasNext()) {
				AbstractNode parserNode = nodeAdapter.getParserNode();
				// feature is the second element see Diagnostician.getData
				Object feature = data.next();
				EStructuralFeature structuralFeature = resolveStructuralFeature(ele, feature);
				if (structuralFeature != null) {
					List<AbstractNode> nodes = NodeUtil.findNodesForFeature(ele, structuralFeature);
					if (!nodes.isEmpty())
						parserNode = nodes.iterator().next();
				}
				map.put(IMarker.LINE_NUMBER, Integer.valueOf(parserNode.getLine()));
				int offset = parserNode.getOffset();
				map.put(IMarker.CHAR_START, Integer.valueOf(offset));
				map.put(IMarker.CHAR_END, Integer.valueOf(offset + parserNode.getLength()));
			}
			map.put(IMarker.MESSAGE, diagnostic.getMessage());
		}
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;
	}

	private static EStructuralFeature resolveStructuralFeature(EObject ele, Object feature) {
		if (feature instanceof String) {
			return ele.eClass().getEStructuralFeature((String) feature);
		} else if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		} else if (feature instanceof Integer) {
			return ele.eClass().getEStructuralFeature((Integer) feature);
		}
		return null;
	}

}
