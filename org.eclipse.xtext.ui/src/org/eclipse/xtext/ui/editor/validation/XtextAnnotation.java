/*******************************************************************************
 * Copyright (c) 2009, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.validation;

import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationAccessExtension;
import org.eclipse.jface.text.source.IAnnotationPresentation;
import org.eclipse.jface.text.source.ImageUtilities;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;
import org.eclipse.ui.texteditor.AnnotationPreferenceLookup;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.validation.Issue;

/**
 * @author Heiko Behrens - Initial contribution and API
 */
public class XtextAnnotation extends Annotation implements IAnnotationPresentation {

	private final IXtextDocument document;
	private final Issue issue;
	private final int layer;
	private final boolean isQuickfixable;
	private final AnnotationPreferenceLookup lookup= EditorsUI.getAnnotationPreferenceLookup();

	public String getIssueCode() {
		return issue.getCode();
	}
	
	public String[] getIssueData() {
		return issue.getData();
	}
	
	public IXtextDocument getDocument() {
		return document;
	}
	
	public URI getUriToProblem() {
		return issue.getUriToProblem();
	}
	
	public Issue getIssue() {
		return issue;
	}
	
	public boolean isQuickFixable() {
		return isQuickfixable;
	}
	
	public XtextAnnotation(String type, boolean isPersistent, IXtextDocument document, Issue issue, boolean isQuickfixable) {
		super(type, isPersistent, issue.getMessage());
		
		AnnotationPreference preference= lookup.getAnnotationPreference(this);
		if (preference != null)
			this.layer = preference.getPresentationLayer() + 1;
		else
			this.layer = IAnnotationAccessExtension.DEFAULT_LAYER + 1;
		
		this.document = document;
		this.issue = issue;
		this.isQuickfixable = isQuickfixable;
	}

	@Override
	public int getLayer() {
		return layer;
	}

	@Override
	public void paint(GC gc, Canvas canvas, Rectangle bounds) {
		Image image = getImages().get(getType());
		if(image != null)
			ImageUtilities.drawImage(image, gc, canvas, bounds, SWT.CENTER, SWT.TOP);
	}

	private Map<String, Image> getImages() {
		return isQuickfixable ? XtextPluginImages.getAnnotationImagesFixable() : XtextPluginImages.getAnnotationImagesNonfixable();
	}
	
	@Override
	public String toString() {
		if (issue.getSeverity() != null && issue.getMessage() != null)
			return issue.getSeverity() + ": " + issue.getMessage();
		else
			return super.toString();
	}
	
}
