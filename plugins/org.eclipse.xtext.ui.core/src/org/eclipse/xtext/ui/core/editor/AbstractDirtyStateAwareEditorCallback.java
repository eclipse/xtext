/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.editor;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractDirtyStateAwareEditorCallback implements IXtextEditorCallback {
	
	@Inject
	private DirtyStateEditorSupport editorSupport;
	
	public void afterCreatePartControl(XtextEditor editor) {
		editorSupport.initializeDirtyStateSupport(editor);
	}
	
	public void beforeDispose(XtextEditor editor) {
		editorSupport.removeDirtyStateSupport(editor);
	}
	
	public void afterSave(XtextEditor editor) {
		editorSupport.markEditorClean(editor);
	}
	
	public boolean onValidateEditorInputState(XtextEditor editor) {
		return editorSupport.isEditingPossible(editor);
	}
	
}
