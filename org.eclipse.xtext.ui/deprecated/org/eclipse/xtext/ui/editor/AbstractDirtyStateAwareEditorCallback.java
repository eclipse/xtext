/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
 * @deprecated since 2.7 the {@link DirtyStateEditorSupport} is directly served by the {@link XtextEditor}
 */
@Deprecated
public abstract class AbstractDirtyStateAwareEditorCallback implements IXtextEditorCallback, IDirtyStateEditorSupportClient {
	
	@Inject
	private DirtyStateEditorSupport editorSupport;
	
	private XtextEditor currentEditor;
	
	@Override
	public void afterCreatePartControl(final XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.initializeDirtyStateSupport(this);
	}
	
	@Override
	public void beforeDispose(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.removeDirtyStateSupport(this);
		this.currentEditor = null;
	}
	
	@Override
	public void afterSave(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		editorSupport.markEditorClean(this);
	}
	
	@Override
	public boolean onValidateEditorInputState(XtextEditor editor) {
		if (this.currentEditor != editor)
			throw new IllegalStateException("different instances of editor were given.");
		return editorSupport.isEditingPossible(this);
	}
	
	@Override
	public void beforeSetInput(XtextEditor editor) {
		if (this.currentEditor != null) {
			editorSupport.removeDirtyStateSupport(this);
		}
	}
	
	@Override
	public void afterSetInput(XtextEditor editor) {
		if (this.currentEditor != null) {
			if (this.currentEditor != editor)
				throw new IllegalStateException("different instances of editor were given.");
			editorSupport.initializeDirtyStateSupport(this);
		} else {
			this.currentEditor = editor;
		}
	}
	
	@Override
	public boolean isDirty() {
		return currentEditor.isDirty();
	}
	
	@Override
	public IXtextDocument getDocument() {
		return currentEditor.getDocument();
	}
	
	@Override
	public void addVerifyListener(VerifyListener listener) {
		ISourceViewer sourceViewer = currentEditor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		widget.addVerifyListener(listener);
	}

	@Override
	public Shell getShell() {
		return currentEditor.getEditorSite().getShell();
	}

	@Override
	public void removeVerifyListener(VerifyListener listener) {
		ISourceViewer sourceViewer = currentEditor.getInternalSourceViewer();
		StyledText widget = sourceViewer.getTextWidget();
		if (widget != null)
			widget.removeVerifyListener(listener);
	}
}
