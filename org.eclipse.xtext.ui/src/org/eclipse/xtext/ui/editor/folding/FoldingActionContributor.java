/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.folding;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;

/**
 * Contributes folding actions for the given <code>XtextEditor</code>.
 * 
 * @author Michael Clay - Initial contribution and API
 */
public class FoldingActionContributor implements IActionContributor {

	/**
	 * @since 2.8
	 */
	protected FoldingActionGroup foldingActionGroup;

	@Override
	public void contributeActions(XtextEditor editor) {
		foldingActionGroup = new FoldingActionGroup(editor, editor.getInternalSourceViewer());
	}

	@Override
	public void editorDisposed(XtextEditor editor) {
		if(foldingActionGroup != null)
			foldingActionGroup.dispose();
	}
}
