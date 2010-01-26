/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.model.edit;

import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.ui.core.MarkerUtil;
import org.eclipse.xtext.ui.core.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class IssueUtil {

	@Inject MarkerUtil markerUtil;
	
	public MarkerUtil getMarkerUtil() {
		return markerUtil;
	}

	public void setMarkerUtil(MarkerUtil markerUtil) {
		this.markerUtil = markerUtil;
	}

	public Issue createIssue(IMarker marker) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setMessage(MarkerUtilities.getMessage(marker));
		
		issue.setLineNumber(MarkerUtilities.getLineNumber(marker) - 1);
		issue.setOffset(MarkerUtilities.getCharStart(marker));
		issue.setLength(MarkerUtilities.getCharEnd(marker)-MarkerUtilities.getCharStart(marker));
		
		issue.setCode(markerUtil.getCode(marker));
		issue.setUriToProblem(markerUtil.getUriToProblem(marker));
		issue.setSeverity(markerUtil.getSeverity(marker));
		// Note, isSyntaxError is unset, but currently the api does not allow fixing
		// syntax errors anyway.
		return issue;
	}
	
	public Issue getIssueFromAnnotation(Annotation annotation) {
		if (annotation instanceof XtextAnnotation) {
			XtextAnnotation xtextAnnotation = (XtextAnnotation) annotation;
			return xtextAnnotation.getIssue();
		} else if(annotation instanceof MarkerAnnotation) {
			MarkerAnnotation markerAnnotation = (MarkerAnnotation)annotation;
			return createIssue(markerAnnotation.getMarker());
		} else
			return null;
	}


}
