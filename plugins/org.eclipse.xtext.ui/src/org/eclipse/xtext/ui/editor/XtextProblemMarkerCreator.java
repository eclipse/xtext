/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.parsetree.SyntaxError;
import org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.internal.Activator;
import org.eclipse.xtext.ui.internal.CoreLog;
import org.eclipse.xtext.ui.internal.XtextMarkerManager;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextProblemMarkerCreator implements IXtextEditorModelListener {

	private final IResource resource;
	private IProgressMonitor monitor;
	private Resource emfResource;

	public XtextProblemMarkerCreator(IResource resource) {
		this.resource = resource;
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	private Map<String, Object> collectMarkerAttributes(SyntaxError error) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_ERROR));
		// TODO map.put(IMarker.LINE_NUMBER,
		// Integer.valueOf(error.getNode().line()));
		map.put(IMarker.CHAR_START, Integer.valueOf(error.getNode().offset()));
		map.put(IMarker.CHAR_END, Integer.valueOf(error.getNode().offset() + error.getNode().length()));
		map.put(IMarker.MESSAGE, error.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.xtext.ui.editor.model.IXtextEditorModelListener#modelChanged
	 * (org.eclipse.xtext.ui.editor.model.XtextEditorModelChangeEvent)
	 */
	public void modelChanged(XtextEditorModelChangeEvent event) {
		XtextMarkerManager.clearXtextMarker(resource, monitor);
		XtextMarkerManager.clearEMFMarker(resource, monitor);
		emfResource = event.getModel().getResource();
		// get resource set for grammar validation
		List<Diagnostic> diagnostics = validateResourceSet(emfResource.getResourceSet());
		for (Diagnostic diagnostic : diagnostics) {
			if (!diagnostic.getChildren().isEmpty()) {
				for (Diagnostic childDiagnostic : diagnostic.getChildren()) {
					XtextMarkerManager.createEMFMarker(resource, collectMarkerAttributesForDiagnostic(childDiagnostic),
							monitor);
				}
			}
			else {
				XtextMarkerManager.createEMFMarker(resource, collectMarkerAttributesForDiagnostic(diagnostic), monitor);
			}
		}
		if (event.getModel().hasErrors()) {
			for (SyntaxError error : event.getModel().getSyntaxErrors()) {
				XtextMarkerManager.createXtextMarker(resource, collectMarkerAttributes(error), monitor);
			}
		}
	}

	private Map<String, Object> collectMarkerAttributesForDiagnostic(Diagnostic diagnostic) {
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
			if (!emfResource.equals(ele.eResource())) {
				map.put(IMarker.TRANSIENT, Boolean.TRUE);
				map.put(IMarker.MESSAGE, "Referenced resource contains problems. " + diagnostic.getMessage());
			}
			else {
				NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(ele);
				if (nodeAdapter != null) {
					CompositeNode parserNode = nodeAdapter.getParserNode();
					// TODO map.put(IMarker.LINE_NUMBER,
					// Integer.valueOf(parserNode.line()));
					int offset = parserNode.offset();
					map.put(IMarker.CHAR_START, Integer.valueOf(offset));
					map.put(IMarker.CHAR_END, Integer.valueOf(offset + parserNode.length()));
				}
				map.put(IMarker.MESSAGE, diagnostic.getMessage());
			}
		}
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;
	}

	private List<Diagnostic> validateResourceSet(ResourceSet resourceSet) {
		List<Diagnostic> retVal = new ArrayList<Diagnostic>();
		for (Resource resource : resourceSet.getResources()) {
			Diagnostic diagnostic = validateResource(resource);
			// diagnostic != null should not happen, but in exception state NPE
			// can occur and and reconciler thread will die, so prevent this
			if (diagnostic != null) {
				if (diagnostic.getSeverity() != Diagnostic.OK)
					retVal.add(diagnostic);
				if (Activator.DEBUG_MARKERCREATOR)
					System.out.println("XtextProblemMarkerCreator.validateResourceSet()" + diagnostic.toString());
			}
		}
		return retVal;
	}

	private Diagnostic validateResource(Resource resource) {
		if (resource.getAllContents().hasNext()) {
			EObject rootObject = resource.getAllContents().next();
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(rootObject);
			return diagnostic;
		}
		CoreLog.logWarning("No content found in Resource: " + resource.getURI());
		return null;
	}
}
