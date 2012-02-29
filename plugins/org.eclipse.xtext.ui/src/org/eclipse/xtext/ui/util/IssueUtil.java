/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import org.eclipse.core.resources.IMarker;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ui.MarkerTypes;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.Inject;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class IssueUtil {

	@Inject(optional=true)
	private MarkerTypeProvider markerTypeProvider;
	
	public Issue createIssue(IMarker marker) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		issue.setMessage(MarkerUtilities.getMessage(marker));
		
		issue.setLineNumber(MarkerUtilities.getLineNumber(marker) - 1);
		issue.setOffset(MarkerUtilities.getCharStart(marker));
		issue.setLength(MarkerUtilities.getCharEnd(marker)-MarkerUtilities.getCharStart(marker));
		
		issue.setCode(getCode(marker));
		issue.setData(getIssueData(marker));
		issue.setUriToProblem(getUriToProblem(marker));
		issue.setSeverity(getSeverity(marker));
		
		issue.setType(getCheckType(marker));
		// Note, isSyntaxError is unset, but currently the api does not allow fixing
		// syntax errors anyway.
		return issue;
	}

	/**
	 * @since 2.3
	 */
	protected CheckType getCheckType(IMarker marker) {
		String markerType = MarkerUtilities.getMarkerType(marker);
		if (markerTypeProvider != null)
			return markerTypeProvider.getCheckType(markerType);
		return MarkerTypes.toCheckType(markerType);
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

	public String[] getIssueData(Annotation annotation) {
		if (annotation instanceof MarkerAnnotation) {
			MarkerAnnotation ma = (MarkerAnnotation) annotation;
			return getIssueData(ma.getMarker());
		}
		if (annotation instanceof XtextAnnotation) {
			XtextAnnotation xa = (XtextAnnotation) annotation;
			return xa.getIssueData();	
		}
		return null;
	}
	
	public String[] getIssueData(IMarker marker) {
		return Strings.unpack(marker.getAttribute(Issue.DATA_KEY, null));
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
			case IMarker.SEVERITY_INFO:
				return Severity.INFO;
			default:
				throw new IllegalArgumentException(marker.toString());
		}
	}

	public boolean refersToSameIssue(IMarker marker, Annotation annotation) {
		URI markerURI = getUriToProblem(marker);
		String markerIssue = getCode(marker);
		if(markerURI == null || markerIssue == null)
			return false;
		
		return markerURI.equals(getUriToProblem(annotation)) && markerIssue.equals(getCode(annotation));
	}

}
