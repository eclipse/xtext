/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;

import com.google.inject.Inject;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class SelectionActionContributor implements IActionContributor {
	private INodeSelectionProvider nodeSelectionProvider;

	@Inject
	public void setNodeSelectionProvider(INodeSelectionProvider nodeSelectionProvider) {
		this.nodeSelectionProvider = nodeSelectionProvider;
	}

	public void contributeActions(XtextEditor xtextEditor) {
		nodeSelectionProvider.initialize(xtextEditor);
	}

	public void editorDisposed(XtextEditor editor) {
		nodeSelectionProvider.dispose();
	}

}
