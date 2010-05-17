/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import org.eclipse.jface.text.source.ISourceViewer;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.xtext.ui.editor.DirtyStateEditorSupport.IDirtyStateEditorSupportClient;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDirtyStateAwareEditorCallback implements IXtextEditorCallback, IDirtyStateEditorSupportClient {
	
	@Inject
	private DirtyStateEditorSupport editorSupport;
	
	private XtextEditor currentEditor;
	
	public void afterCreatePartControl(final XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.initializeDirtyStateSupport(this);
	}
	
	public void beforeDispose(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.removeDirtyStateSupport(this);
		this.currentEditor = null;
	}
	
	public void afterSave(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.markEditorClean(this);
	}
	
	public boolean onValidateEditorInputState(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		return editorSupport.isEditingPossible(this);
	}
	
	public void beforeSetInput(XtextEditor editor) {
		if (this.currentEditor != null) {
			editorSupport.removeDirtyStateSupport(this);
		}
	}
	
	public void afterSetInput(XtextEditor editor) {
		if (this.currentEditor != null) {
			if (this.currentEditor != editor)
				throw new IllegalStateException("different instances of editor were given.");
			editorSupport.initializeDirtyStateSupport(this);
		} else {
			this.currentEditor = editor;
		}
	}
	
	public boolean isDirty() {
		return currentEditor.isDirty();
	}
	
	public IXtextDocument getDocument() {
		return currentEditor.getDocument();
	}
	
	public void addVerifyListener(VerifyListener listener) {
		ISourceViewer sourceViewer = currentEditor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		widget.addVerifyListener(listener);
	}

	public Shell getShell() {
		return currentEditor.getEditorSite().getShell();
	}

	public void removeVerifyListener(VerifyListener listener) {
		ISourceViewer sourceViewer = currentEditor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		if (widget != null)
			widget.removeVerifyListener(listener);
	}
	
}
