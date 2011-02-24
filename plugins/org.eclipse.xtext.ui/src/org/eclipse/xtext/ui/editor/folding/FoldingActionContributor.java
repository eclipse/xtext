/*******************************************************************************
 * Copyright (c) 2010 Michael Clay and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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

	private FoldingActionGroup foldingActionGroup;

	public void contributeActions(XtextEditor editor) {
		foldingActionGroup = new FoldingActionGroup(editor, editor.getInternalSourceViewer());
	}

	public void editorDisposed(XtextEditor editor) {
		if(foldingActionGroup != null)
			foldingActionGroup.dispose();
	}
}
