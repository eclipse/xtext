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
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

/**
 * @author Dennis Hübner - Initial contribution and API
 */
public class DefaultXtextResourceChecker implements IXtextResourceChecker {

	private static final Logger log = Logger.getLogger(DefaultXtextResourceChecker.class);

	/**
	 * Checks an {@link XtextResource}
	 * 
	 * @param resource
	 * @return a {@link List} of {@link IMarker} attributes
	 */
	public List<Map<String, Object>> check(final Resource resource, Map<?, ?> context, IProgressMonitor monitor) {
		List<Map<String, Object>> markers = new ArrayList<Map<String, Object>>(resource.getErrors().size() + resource.getWarnings().size());
		try {
			// Syntactical errors
			// Collect EMF Resource Diagnostics
			for (int i = 0; i < resource.getErrors().size(); i++) {
				markers.add(markerFromXtextResourceDiagnostic(resource.getErrors().get(i), IMarker.SEVERITY_ERROR));
			}

			if (monitor.isCanceled())
				return null;

			for (int i = 0; i < resource.getWarnings().size(); i++) {
				markers.add(markerFromXtextResourceDiagnostic(resource.getWarnings().get(i), IMarker.SEVERITY_WARNING));
			}

			if (monitor.isCanceled())
				return null;

			boolean syntaxDiagFail = !markers.isEmpty();
			logCheckStatus(resource, syntaxDiagFail, "Syntax");

			for (EObject ele : resource.getContents()) {
				try {
					Diagnostic diagnostic = Diagnostician.INSTANCE.validate(ele, context);
					if (monitor.isCanceled())
						return null;
					if (!diagnostic.getChildren().isEmpty()) {
						for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
							Map<String, Object> marker = markerFromEValidatorDiagnostic(childDiagnostic);
							if (marker != null) {
								markers.add(marker);
							}
						}
					}
					else {
						Map<String, Object> marker = markerFromEValidatorDiagnostic(diagnostic);
						if (marker != null) {
							markers.add(marker);
						}
					}
				}
				catch (RuntimeException e) {
					log.error(e.getMessage(), e);
				}
			}
		}
		catch (RuntimeException e) {
			log.error(e.getMessage(), e);
		}
		return markers;
	}

	private void logCheckStatus(final Resource resource, boolean parserDiagFail, String string) {
		if (log.isDebugEnabled()) {
			log.debug(string + " check " + (parserDiagFail ? "FAIL" : "OK") + "! Resource: " + resource.getURI());
		}
	}

	private Map<String, Object> markerFromXtextResourceDiagnostic(
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

	private Map<String, Object> markerFromEValidatorDiagnostic(Diagnostic diagnostic) {
		if (diagnostic.getSeverity() == Diagnostic.OK)
			return null;
		Map<String, Object> map = new HashMap<String, Object>();
		int sever = IMarker.SEVERITY_ERROR;
		switch (diagnostic.getSeverity()) {
			case Diagnostic.WARNING:
				sever = IMarker.SEVERITY_WARNING;
				break;
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
			if (nodeAdapter != null) {
				AbstractNode parserNode = nodeAdapter.getParserNode();
				// feature is the second element see Diagnostician.getData
				Object feature = data.hasNext() ? data.next() : null;
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
				map.put(DIAGNOSTIC_KEY, diagnostic);
			}
		}
		map.put(IMarker.MESSAGE, diagnostic.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;
	}

	private EStructuralFeature resolveStructuralFeature(EObject ele, Object feature) {
		if (feature instanceof String) {
			return ele.eClass().getEStructuralFeature((String) feature);
		}
		else if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		}
		else if (feature instanceof Integer) {
			return ele.eClass().getEStructuralFeature((Integer) feature);
		}
		return null;
	}

}
