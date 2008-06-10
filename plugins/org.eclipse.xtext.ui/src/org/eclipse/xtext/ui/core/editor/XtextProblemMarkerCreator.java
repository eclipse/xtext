/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.xtext.parser.IParseError;
import org.eclipse.xtext.ui.core.editor.model.IXtextEditorModelListener;
import org.eclipse.xtext.ui.core.editor.model.XtextEditorModelChangeEvent;
import org.eclipse.xtext.ui.core.internal.XtextMarkerManager;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextProblemMarkerCreator implements IXtextEditorModelListener {

	private final IResource resource;
	private IProgressMonitor monitor;

	public XtextProblemMarkerCreator(IResource resource) {
		this.resource = resource;
	}

	public void setProgressMonitor(IProgressMonitor monitor) {
		this.monitor = monitor;
	}

	private Map<String, Object> collectMarkerAttributes(IParseError error) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(IMarker.SEVERITY, Integer.valueOf(IMarker.SEVERITY_ERROR));
		map.put(IMarker.LINE_NUMBER, Integer.valueOf(error.getLine()));
		map.put(IMarker.CHAR_START, Integer.valueOf(error.getOffset()));
		map.put(IMarker.CHAR_END, Integer.valueOf(error.getOffset() + error.getLength()));
		map.put(IMarker.MESSAGE, error.getMessage());
		map.put(IMarker.PRIORITY, Integer.valueOf(IMarker.PRIORITY_LOW));
		return map;

	}

	public void modelChanged(XtextEditorModelChangeEvent event) {
		XtextMarkerManager.clearXtextMarker(resource, monitor);
		if (event.getModel() != null && event.getModel().hasErrors()) {
			for (IParseError error : event.getModel().getErrors()) {
				XtextMarkerManager.createMarker(resource, collectMarkerAttributes(error), monitor);
			}
		}
	}
}
