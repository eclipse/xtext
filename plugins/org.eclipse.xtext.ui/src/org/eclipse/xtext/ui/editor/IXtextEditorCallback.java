/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import com.google.inject.ImplementedBy;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Michael Clay
 */
@ImplementedBy(IXtextEditorCallback.NullImpl.class)
public interface IXtextEditorCallback {
	
	void beforeSetInput(XtextEditor xtextEditor);
	
	void afterSetInput(XtextEditor xtextEditor);
	
	void afterCreatePartControl(XtextEditor editor);
	
	/**
	 * Announce that the given editor's state is the same as the persisted state.
	 * @param editor the editor which has not any unsaved changes
	 */
	void afterSave(XtextEditor editor);
	
	void beforeDispose(XtextEditor editor);
	
	boolean onValidateEditorInputState(XtextEditor editor);
	
	public static class NullImpl implements IXtextEditorCallback {

		public void beforeSetInput(XtextEditor xtextEditor) {
		}
		
		public void afterSetInput(XtextEditor xtextEditor) {
		}
		
		public void afterCreatePartControl(XtextEditor editor) {
		}

		public void afterSave(XtextEditor editor) {
		}

		public void beforeDispose(XtextEditor editor) {
		}

		public boolean onValidateEditorInputState(XtextEditor editor) {
			return true;
		}
	}

}
