/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.util;

import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
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
 * @author Holger Schill
 */
public class IssueUtil {

	@Inject(optional=true)
	private MarkerTypeProvider markerTypeProvider;
	
	/**
	 * Creates an Issue out of a Marker.
	 * setSyntaxError is unset since the current API does not allow fixing systax errors anyway.
	 * 
	 * @param marker The marker to create an issue from
	 * @return an issue created out of the given marker or <code>null</code>
	 */
	public Issue createIssue(IMarker marker) {
		Issue.IssueImpl issue = new Issue.IssueImpl();
		try {
			Map<String, Object> attributes = marker.getAttributes();
			String markerType = marker.getType();
			Object message = attributes.get(IMarker.MESSAGE);
			issue.setMessage(message  instanceof String ? (String) message : null);
			Object lineNumber = attributes.get(IMarker.LINE_NUMBER);
			issue.setLineNumber(lineNumber instanceof Integer ? (Integer) lineNumber : null);
			Object column = attributes.get(Issue.COLUMN_KEY);
			issue.setColumn(column instanceof Integer ? (Integer) column : null);
			Object offset = attributes.get(IMarker.CHAR_START);
			Object endOffset = attributes.get(IMarker.CHAR_END);
			if(offset instanceof Integer && endOffset instanceof Integer) {
				issue.setOffset((Integer) offset);
				issue.setLength((Integer) endOffset - (Integer) offset); 
			} else {
				issue.setOffset(-1);
				issue.setLength(0);
			}
			Object code = attributes.get(Issue.CODE_KEY);
			issue.setCode(code instanceof String ? (String) code:null);
			Object data = attributes.get(Issue.DATA_KEY);
			issue.setData(data instanceof String ? Strings.unpack((String) data) : null);
			Object uri = attributes.get(Issue.URI_KEY);
			issue.setUriToProblem(uri instanceof String ? URI.createURI((String) uri) : null);
			Object severity = attributes.get(IMarker.SEVERITY);
			Severity translatedSeverity = translateSeverity(severity instanceof Integer ? (Integer) severity : 0);
			if(translatedSeverity == null)
				throw new IllegalArgumentException(marker.toString());
			issue.setSeverity(translatedSeverity);
			if(markerTypeProvider != null)
				issue.setType(markerTypeProvider.getCheckType(markerType));
			else
				issue.setType(MarkerTypes.toCheckType(markerType));
		} catch (CoreException e) {
			return null;
		}
		return issue;
	}
	
	/**
	 * @since 2.9
	 */
	protected MarkerTypeProvider getMarkerTypeProvider() {
		return markerTypeProvider;
	}

	/**
	 * @deprecated As we are using IMarker.getAttributes() in {@link #createIssue(IMarker)}, we do not call this method any more
	 * @since 2.3
	 */
	@Deprecated
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
	
	/**
	 * @deprecated As we are using IMarker.getAttributes() in {@link #createIssue(IMarker)}, we do not call this method any more
	 */
	@Deprecated
	public Severity getSeverity(IMarker marker) {
		Severity translatedSeverity = translateSeverity(marker.getAttribute(IMarker.SEVERITY, 0));
		if(translatedSeverity == null)
			throw new IllegalArgumentException(marker.toString());
		return translatedSeverity;
	}

	/**
	 * Translates IMarker.SEVERITY to Severity
	 * @param severity Severity to translate
	 * @return Translated severity or <code>null</code>
	 * @since 2.9
	 */
	protected Severity translateSeverity(int severity) {
		switch (severity) {
			case IMarker.SEVERITY_ERROR:
				return Severity.ERROR;
			case IMarker.SEVERITY_WARNING:
				return Severity.WARNING;
			case IMarker.SEVERITY_INFO:
				return Severity.INFO;
			default:
				return null;
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
