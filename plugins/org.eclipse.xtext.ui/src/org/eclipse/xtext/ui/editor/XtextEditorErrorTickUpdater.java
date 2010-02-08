/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.Iterator;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.text.source.Annotation;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.viewers.DecorationOverlayIcon;
import org.eclipse.jface.viewers.IDecoration;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.IImageHelper;
import org.eclipse.xtext.ui.editor.model.edit.IssueUtil;
import org.eclipse.xtext.ui.internal.XtextPluginImages;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.Severity;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Sven Efftinge
 */
public class XtextEditorErrorTickUpdater extends IXtextEditorCallback.NullImpl implements IAnnotationModelListener {

	@Inject
	private IImageHelper imageHelper;

	@Inject
	private IssueUtil issueUtil;

	private Image defaultImage;
	
	private XtextEditor editor;

	private IAnnotationModel annotationModel;

	@Override
	public void beforeDispose(XtextEditor xtextEditor) {
		if (annotationModel != null) {
			annotationModel.removeAnnotationModelListener(this);
			annotationModel = null;
		}
		this.editor = null;
		if (defaultImage!=null)
			defaultImage.dispose();
	}

	@Override
	public void afterCreatePartControl(XtextEditor xtextEditor) {
		editor = xtextEditor;
		defaultImage = xtextEditor.getDefaultImage();
		updateEditorImage(xtextEditor);
		annotationModel = xtextEditor.getInternalSourceViewer().getAnnotationModel();
		if (annotationModel != null)
			annotationModel.addAnnotationModelListener(this);
	}

	protected void updateEditorImage(XtextEditor xtextEditor) {
		Issue.Severity severity = getSeverity(xtextEditor);
		if (severity != null) {
			ImageDescriptor descriptor = severity == Severity.ERROR ? XtextPluginImages.DESC_OVR_ERROR
					: XtextPluginImages.DESC_OVR_WARNING;
			DecorationOverlayIcon decorationOverlayIcon = new DecorationOverlayIcon(defaultImage, descriptor,
					IDecoration.BOTTOM_LEFT);
			Image decoratedImage = imageHelper.getImage(decorationOverlayIcon);
			if (xtextEditor.getTitleImage() != decoratedImage) {
				postImageChange(xtextEditor, decoratedImage);
			}
		} else {
			postImageChange(xtextEditor, defaultImage);
		}
	}

	@SuppressWarnings("unchecked")
	protected Severity getSeverity(XtextEditor xtextEditor) {
		IAnnotationModel model = xtextEditor.getInternalSourceViewer().getAnnotationModel();
		if (model != null) {
			Iterator<Annotation> iterator = model.getAnnotationIterator();
			boolean hasWarnings = false;
			while (iterator.hasNext()) {
				Issue issue = issueUtil.getIssueFromAnnotation(iterator.next());
				if (issue != null) {
					if (issue.getSeverity() == Severity.ERROR) {
						return Severity.ERROR;
					} else if (issue.getSeverity() == Severity.WARNING) {
						hasWarnings = true;
					}
				}
			}
			return hasWarnings?Severity.WARNING:null;
		}
		return null;
	}

	private void postImageChange(final XtextEditor xtextEditor, final Image newImage) {
		Shell shell = xtextEditor.getEditorSite().getShell();
		if (shell != null && !shell.isDisposed()) {
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					xtextEditor.updatedTitleImage(newImage);
				}
			});
		}
	}

	public void modelChanged(IAnnotationModel model) {
		updateEditorImage(editor);
	}

}
