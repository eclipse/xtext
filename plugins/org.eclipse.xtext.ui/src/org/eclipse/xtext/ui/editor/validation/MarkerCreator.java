/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class MarkerCreator {
	
	public void createMarker(Issue issue, IResource resource, String markerId) throws CoreException {
		IMarker marker = resource.createMarker(markerId);
		String lineNR = "";
		if (issue.getLineNumber() != null) {
			lineNR = "line: " + issue.getLineNumber() + " ";
		}
		marker.setAttribute(IMarker.LOCATION, lineNR + resource.getFullPath().toString());
		marker.setAttribute(IMarker.CHAR_START, issue.getOffset());
		if(issue.getOffset() != null && issue.getLength() != null)
			marker.setAttribute(IMarker.CHAR_END, issue.getOffset()+issue.getLength());
		marker.setAttribute(IMarker.LINE_NUMBER, issue.getLineNumber());
		marker.setAttribute(IMarker.MESSAGE, issue.getMessage());
		marker.setAttribute(IMarker.SEVERITY, getSeverity(issue));
		marker.setAttribute(Issue.CODE_KEY, issue.getCode());
		if (issue.getUriToProblem()!=null) 
			marker.setAttribute(Issue.URI_KEY, issue.getUriToProblem().toString());
		if(issue.getData() != null && issue.getData().length > 0) {
			marker.setAttribute(Issue.DATA_KEY, Strings.pack(issue.getData()));
		}
	}

	private Object getSeverity(Issue issue) {
		switch (issue.getSeverity()) {
			case ERROR : 
				return IMarker.SEVERITY_ERROR;
			case WARNING : 
				return IMarker.SEVERITY_WARNING;
			case INFO : 
				return IMarker.SEVERITY_INFO;
		}
		throw new IllegalArgumentException();
	}
}
