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
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.ui.core.MarkerUtil;
import org.eclipse.xtext.ui.core.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.core.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public final class IssueUtil {

	public static Issue createIssue(IMarker marker) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setMessage(MarkerUtilities.getMessage(marker));
		
		issue.setLineNumber(MarkerUtilities.getLineNumber(marker) - 1);
		issue.setOffset(MarkerUtilities.getCharStart(marker));
		issue.setLength(MarkerUtilities.getCharEnd(marker)-MarkerUtilities.getCharStart(marker));
		
		issue.setCode(MarkerUtil.getCode(marker));
		issue.setUriToProblem(MarkerUtil.getUriToProblem(marker));
		issue.setSeverity(MarkerUtil.getSeverity(marker));
		// Note, isSyntaxError is unset, but currently the api does not allow fixing
		// syntax errors anyway.
		return issue;
	}
	
	public static Issue getIssueFromAnnotation(Annotation annotation, IAnnotationModel amodel, IXtextDocument document) {
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
