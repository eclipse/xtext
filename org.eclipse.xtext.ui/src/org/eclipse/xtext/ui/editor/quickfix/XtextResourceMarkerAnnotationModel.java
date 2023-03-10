/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.quickfix;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.ui.texteditor.MarkerAnnotation;
import org.eclipse.ui.texteditor.ResourceMarkerAnnotationModel;
import org.eclipse.xtext.ui.util.IssueUtil;

/**
 * @author Heiko Behrens - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public class XtextResourceMarkerAnnotationModel extends ResourceMarkerAnnotationModel {

	private final IssueResolutionProvider issueResolutionProvider;
	private final IssueUtil issueUtil;
	private boolean connected;

	public XtextResourceMarkerAnnotationModel(IFile file, IssueResolutionProvider issueResolutionProvider, IssueUtil markerUtil) {
		super(file);
		this.issueResolutionProvider = issueResolutionProvider;
		this.issueUtil = markerUtil;
	}

	@Override
	protected MarkerAnnotation createMarkerAnnotation(IMarker marker) {
		MarkerAnnotation annotation = super.createMarkerAnnotation(marker);
		String issueCode = issueUtil.getCode(annotation);
		annotation.setQuickFixable(issueResolutionProvider.hasResolutionFor(issueCode));
		return annotation;
	}
	
	public void fireAnnotationChangedEvent(Annotation annotation) {
		queueAnnotationChanged(annotation);
		fireQueuedEvents();
	}
	
	public void queueAnnotationChanged(Annotation annotation) {
		synchronized (getLockObject()) {
			getAnnotationModelEvent().annotationChanged(annotation);
		}
	}
	
	public void fireQueuedEvents() {
		fireModelChanged();
	}

	@Override
	protected void disconnected() {
		super.disconnected();
		this.connected = false;
	}

	@Override
	protected void connected() {
		super.connected();
		this.connected = true;
	}

	@Override
	public void updateMarkers(IDocument document) throws CoreException {
		if (!this.connected) {
			return;
		}
		super.updateMarkers(document);
	}

}
