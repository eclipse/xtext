/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.core.internal.XtextMarkerManager;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextProblemMarkerCreator {

	private static final Logger LOG = Logger.getLogger(XtextProblemMarkerCreator.class);

	private XtextProblemMarkerCreator() {
	}

	private static Map<String, Object> collectMarkerAttributes(SyntaxError error) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_ERROR));
		map.put(IMarker.LINE_NUMBER, Integer.valueOf(error.getNode().getLine()));
		map.put(IMarker.CHAR_START, Integer.valueOf(error.getNode().getOffset()));
		map.put(IMarker.CHAR_END, Integer.valueOf(error.getNode().getOffset() + error.getNode().getLength()));
		map.put(IMarker.MESSAGE, error.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;
	}
	
	private static Map<String, Object> collectMarkerAttributes(org.eclipse.emf.ecore.resource.Resource.Diagnostic diagnostic, Object severity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, severity);
		map.put(IMarker.LINE_NUMBER, diagnostic.getLine());
		map.put(IMarker.MESSAGE, diagnostic.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		
		if (diagnostic instanceof XtextResource.Diagnostic) {
			XtextResource.Diagnostic xtextDiagnostic = (XtextResource.Diagnostic) diagnostic;
			map.put(IMarker.CHAR_START, xtextDiagnostic.getOffset());
			map.put(IMarker.CHAR_END, xtextDiagnostic.getOffset() + xtextDiagnostic.getLength());
		}
		
		return map;
	}


	/*
	 * (non-Javadoc)
	 */
	public static void checkAndUpdateMarkers(final XtextResource resource, IFile file) {
		IProgressMonitor monitor = new NullProgressMonitor();

		XtextMarkerManager.clearMarkers(file, null);
		List<Map<String, Object>> emfMarkers = new ArrayList<Map<String, Object>>();
		if (resource.getAllContents().hasNext()) {
			EObject rootObject = resource.getAllContents().next();
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootObject);
			// diagnostic != null should not happen, but in exception state NPE
			// can occur and and reconciler thread will die, so prevent this
			if (diagnostic != null) {
				// The root Diagnostician is a BasicDiagnostic that normally act
				// as a chain start and has any kind of impotent information if
				// Severity is OK, so just ignore it
				boolean emfDiagFail = diagnostic.getSeverity() != Diagnostic.OK;
				if (emfDiagFail) {
					if (!diagnostic.getChildren().isEmpty()) {
						for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
							emfMarkers.add(collectMarkerAttributesForDiagnostic(childDiagnostic));
						}
					}
					else {
						emfMarkers.add(collectMarkerAttributesForDiagnostic(diagnostic));
					}
				}
				if (LOG.isDebugEnabled()) {
					LOG.debug("EMF Diagnostic " + (emfDiagFail ? "FAIL" : "OK") + "!");
				}
			}
		}

		List<SyntaxError> parseErrors = resource.getParseResult().getParseErrors();
		boolean parserDiagFail = !parseErrors.isEmpty();
		if (parserDiagFail) {
			for (SyntaxError error : parseErrors) {
				emfMarkers.add(collectMarkerAttributes(error));
			}
		}
		if (LOG.isDebugEnabled()) {
			LOG.debug("Parser Diagnostic " + (parserDiagFail ? "FAIL" : "OK") + "!");
		}
		
		for(org.eclipse.emf.ecore.resource.Resource.Diagnostic error: resource.getErrors())
			emfMarkers.add(collectMarkerAttributes(error, IMarker.SEVERITY_ERROR));
		for(org.eclipse.emf.ecore.resource.Resource.Diagnostic warning: resource.getWarnings())
			emfMarkers.add(collectMarkerAttributes(warning, IMarker.SEVERITY_WARNING));
		
		if (!emfMarkers.isEmpty())
			XtextMarkerManager.createMarker(file, emfMarkers, monitor);

	}

	private static Map<String, Object> collectMarkerAttributesForDiagnostic(Diagnostic diagnostic) {
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
		List<?> data = diagnostic.getData();
		Object causer = data.get(0);
		if (causer instanceof EObject) {
			EObject ele = (EObject) causer;
			// Persist only own marker
			NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ele);
			if (nodeAdapter != null) {
				CompositeNode parserNode = nodeAdapter.getParserNode();
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

}
