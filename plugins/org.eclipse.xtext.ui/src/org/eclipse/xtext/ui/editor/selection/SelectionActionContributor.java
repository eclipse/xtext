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
import com.google.inject.Provider;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class SelectionActionContributor implements IActionContributor {
	@Inject
	private Provider<EnclosingNodeSelection> enclosingNodeSelectionProvider;
	@Inject
	private Provider<NextNodeSelection> nextNodeSelectionProvider;
	@Inject
	private Provider<PreviousNodeSelection> previousNodeSelectionProvider;
	@Inject
	private Provider<PreviousHistorySelection> previousHistorySelectionProvider;

	public void contributeActions(XtextEditor xtextEditor) {
		createNodeSelectionProvider(enclosingNodeSelectionProvider, xtextEditor);
		createNodeSelectionProvider(nextNodeSelectionProvider, xtextEditor);
		createNodeSelectionProvider(previousNodeSelectionProvider, xtextEditor);
		createNodeSelectionProvider(previousHistorySelectionProvider, xtextEditor);
	}

	private INodeSelectionProvider createNodeSelectionProvider(
			Provider<? extends INodeSelectionProvider> nodeSelectionFactory, XtextEditor xtextEditor) {
		INodeSelectionProvider nodeSelectionProvider = nodeSelectionFactory.get();
		nodeSelectionProvider.initialize(xtextEditor);
		return nodeSelectionProvider;
	}

	public void editorDisposed(XtextEditor editor) {
	}

}
