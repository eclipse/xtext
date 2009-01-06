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
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.LeafNode;
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
	 * Checks an {@link XtextResource}
	 * 
	 * @param resource
	 * @return a {@link List} of {@link IMarker} attributes
	 */
	public static List<Map<String, Object>> check(final Resource resource) {
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

			// Semantic Errors
			// EValidator
			if (resource.getAllContents().hasNext()) {
				EObject rootObject = resource.getAllContents().next();
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootObject);
				// diagnostic != null should not happen, but in exception
				// state NPE can occur and and reconciler thread will die,
				// so prevent this
				if (diagnostic != null) {
					// The root Diagnostician is a BasicDiagnostic that
					// normally act as a chain start and has any kind of
					// impotent information if Severity is OK, so just
					// ignore it
					boolean semanticDiagFail = diagnostic.getSeverity() != Diagnostic.OK;
					if (semanticDiagFail) {
						if (!diagnostic.getChildren().isEmpty()) {
							for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
								markers.add(markerFromEValidatorDiagnostic(childDiagnostic));
								if (markers.size()>MAX_ERRORS)
									return markers;
							}
						}
						else {
							markers.add(markerFromEValidatorDiagnostic(diagnostic));
							if (markers.size()>MAX_ERRORS)
								return markers;
						}
					}
					logCheckStatus(resource, semanticDiagFail, "Semantic");
				}
			}
		}
		catch (Exception e) {
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
					for (LeafNode lNode : parserNode.getLeafNodes()) {
						if (structuralFeature.getName().equals(lNode.getFeature())) {
							parserNode = lNode;
							break;
						}
					}
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
		}
		else if (feature instanceof EStructuralFeature) {
			return (EStructuralFeature) feature;
		}
		return null;
	}

}
