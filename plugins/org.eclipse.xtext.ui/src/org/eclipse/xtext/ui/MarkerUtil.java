/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.Severity;

/**
 * @author Heiko Behrens - Initial contribution and API
 *
 */
public class MarkerUtil {

	public String getCode(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation ma = (MarkerAnnotation) annotation;
			return getCode(ma.getMarker());
		}
		if (annotation instanceof XtextAnnotation) {
			XtextAnnotation xa = (XtextAnnotation) annotation;
			return xa.getIssueCode();	
		}
		return null;
	}

	public String getCode(IMarker marker) {
		return marker.getAttribute(Issue.CODE_KEY, null);
	}

	public URI getUriToProblem(IMarker marker) {
		String uri = marker.getAttribute(Issue.URI_KEY, null);
		return uri != null ? URI.createURI(uri) : null;
	}
	
	public URI getUriToProblem(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation ma = (MarkerAnnotation) annotation;
			return getUriToProblem(ma.getMarker());
		}
		if (annotation instanceof XtextAnnotation) {
			XtextAnnotation xa = (XtextAnnotation) annotation;
			return xa.getUriToProblem();
		}
		return null;
	}
	
	public Severity getSeverity(IMarker marker) {
		switch (marker.getAttribute(IMarker.SEVERITY, 0)) {
			case IMarker.SEVERITY_ERROR:
				return Severity.ERROR;
			case IMarker.SEVERITY_WARNING:
				return Severity.WARNING;
			default:
				return Severity.INFO;
		}
	}

	public final boolean refersToSameIssue(IMarker marker, Annotation annotation) {
		URI markerURI = getUriToProblem(marker);
		String markerIssue = getCode(marker);
		if(markerURI == null || markerIssue == null)
			return false;
		
		return markerURI.equals(getUriToProblem(annotation)) && markerIssue.equals(getCode(annotation));
	}

}
