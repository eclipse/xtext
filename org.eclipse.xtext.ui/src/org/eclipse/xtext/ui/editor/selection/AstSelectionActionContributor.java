/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class AstSelectionActionContributor implements IActionContributor {
	@Inject
	private AstSelectionProvider astSelectionProvider;

	@Override
	public void contributeActions(XtextEditor xtextEditor) {
		astSelectionProvider.initialize(xtextEditor);
	}

	@Override
	public void editorDisposed(XtextEditor editor) {
	}
}
