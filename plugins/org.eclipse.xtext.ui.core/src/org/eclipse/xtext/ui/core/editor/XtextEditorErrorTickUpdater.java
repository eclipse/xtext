/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import org.eclipse.core.resources.IResource;
import org.eclipse.jface.viewers.DecoratingLabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.core.editor.validation.IProblemMarkerChangedListener;
import org.eclipse.xtext.ui.core.editor.validation.ProblemMarkerChangeManager;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class XtextEditorErrorTickUpdater implements IProblemMarkerChangedListener, IXtextEditorCallback {
	@Inject
	private XtextEditor xtextEditor;
	@Inject
	private DecoratingLabelProvider labelProvider;
	private ProblemMarkerChangeManager problemMarkerManager;

	@Inject
	public void registerAsProblemMarkerChangeListener(ProblemMarkerChangeManager problemMarkerManager) {
		this.problemMarkerManager = problemMarkerManager;
		this.problemMarkerManager.addChangeListener(this);
	}

	public void problemsChanged(IResource[] changedResources, boolean isMarkerChange) {
		IResource resource = xtextEditor.getResource();
		if (resource != null) {
			for (int i = 0; i < changedResources.length; i++) {
				if (changedResources[i].equals(resource)) {
					updateEditorImage(resource);
				}
			}
		}
	}

	public void updateEditorImage(IResource resource) {
		Image titleImage = xtextEditor.getTitleImage();
		if (titleImage == null) {
			return;
		}
		Image decoratedImage = labelProvider.getImage(resource);
		if (titleImage != decoratedImage) {
			postImageChange(decoratedImage);
		}
	}

	public void afterCreatePartControl(XtextEditor xtextEditor) {
	}

	public void afterSave(XtextEditor xtextEditor) {
	}

	public void beforeDispose(XtextEditor xtextEditor) {
		problemMarkerManager.removeListener(this);
	}

	public boolean onValidateEditorInputState(XtextEditor xtextEditor) {
		return true;
	}

	public void afterSetInput(XtextEditor xtextEditor) {
		this.xtextEditor = xtextEditor;
		updateEditorImage(xtextEditor.getResource());
	}

	private void postImageChange(final Image newImage) {
		Shell shell = xtextEditor.getEditorSite().getShell();
		if (shell != null && !shell.isDisposed()) {
			shell.getDisplay().syncExec(new Runnable() {
				public void run() {
					xtextEditor.updatedTitleImage(newImage);
				}
			});
		}
	}
}
