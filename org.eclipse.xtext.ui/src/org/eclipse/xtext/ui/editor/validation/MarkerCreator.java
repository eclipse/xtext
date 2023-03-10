/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MarkerCreator {
	
	private static final String FIXABLE_KEY = "FIXABLE_KEY";
	
	@Inject(optional=true)
	private IssueResolutionProvider resolutionProvider;
	
	public void createMarker(Issue issue, IResource resource, String markerType) throws CoreException {
		IMarker marker = resource.createMarker(markerType);
		setMarkerAttributes(issue, resource, marker);
	}

	/**
	 * @since 2.0
	 */
	protected void setMarkerAttributes(Issue issue, IResource resource, IMarker marker) throws CoreException {
		// Do this in one single setAttributes() call, as each set of an attribute is a workspace operation
		Map<String, Object> attributes = new HashMap<>(16);

		String lineNR = "";
		if (issue.getLineNumber() != null) {
			lineNR = "line: " + issue.getLineNumber() + " ";
		}
		attributes.put(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
		attributes.put(Issue.CODE_KEY, issue.getCode());		
		attributes.put(IMarker.SEVERITY, getSeverity(issue));
		attributes.put(IMarker.CHAR_START, issue.getOffset());
		if(issue.getOffset() != null && issue.getLength() != null)
			attributes.put(IMarker.CHAR_END, issue.getOffset()+issue.getLength());
		attributes.put(IMarker.LINE_NUMBER, issue.getLineNumber());
		attributes.put(Issue.COLUMN_KEY, issue.getColumn());
		attributes.put(IMarker.MESSAGE, issue.getMessage());

		if (issue.getUriToProblem()!=null) 
			attributes.put(Issue.URI_KEY, issue.getUriToProblem().toString());
		if(issue.getData() != null && issue.getData().length > 0) {
			attributes.put(Issue.DATA_KEY, Strings.pack(issue.getData()));
		}
		if (resolutionProvider != null && resolutionProvider.hasResolutionFor(issue.getCode())) {
			attributes.put(FIXABLE_KEY, true);
		}
		marker.setAttributes(attributes);
	}

	private Object getSeverity(Issue issue) {
		switch (issue.getSeverity()) {
			case ERROR : 
				return IMarker.SEVERITY_ERROR;
			case WARNING : 
				return IMarker.SEVERITY_WARNING;
			case INFO : 
				return IMarker.SEVERITY_INFO;
			default:
				throw new IllegalArgumentException(String.valueOf(issue.getSeverity()));
		}
	}
}
