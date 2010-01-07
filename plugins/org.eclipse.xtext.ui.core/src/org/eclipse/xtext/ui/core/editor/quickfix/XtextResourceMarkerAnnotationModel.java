/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.core.MarkerUtil;
import org.eclipse.xtext.validation.IssueResolutionProvider;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextResourceMarkerAnnotationModel extends ResourceMarkerAnnotationModel {

	private final IssueResolutionProvider issueResolutionProvider;

	public XtextResourceMarkerAnnotationModel(IFile file, IssueResolutionProvider issueResolutionProvider) {
		super(file);
		this.issueResolutionProvider = issueResolutionProvider;
	}

	@Override
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		MarkerAnnotation annotation = super.createMarkerAnnotation(marker);
		String issueCode = MarkerUtil.getCode(annotation);
		annotation.setQuickFixable(issueResolutionProvider.hasResolutionFor(issueCode));
		return annotation;
	}
	
	public void fireAnnotationChangedEvent(Annotation annotation) {
		synchronized (getLockObject()) {
			getAnnotationModelEvent().annotationChanged(annotation);
		}

		fireModelChanged();
	}

}
