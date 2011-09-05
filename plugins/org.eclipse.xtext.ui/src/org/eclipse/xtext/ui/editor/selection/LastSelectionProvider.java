/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class LastSelectionProvider extends AbstractNodeSelectionProvider {

	@Override
	protected void initialize(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		IAction nodeSelectionAction = createLastSelectionAction(xtextEditor, selectionHistory);
		nodeSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectLast_tooltip);
		nodeSelectionAction.setDescription(NodeSelectionMessages.NodeSelectLast_description);
		setAction(xtextEditor, nodeSelectionAction, SELECT_LAST);
	}

	protected NodeSelectionAction createLastSelectionAction(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction nodeSelectionAction = new LastSelectionAction(NodeSelectionMessages.NodeSelectLast_label,
				xtextEditor, selectionHistory, this);
		return nodeSelectionAction;
	}

	public static class LastSelectionAction extends NodeSelectionAction {

		public LastSelectionAction(String text, XtextEditor xtextEditor, SelectionHistory selectionHistory,
				INodeSelectionProvider nodeSelectionProvider) {
			super(text, xtextEditor, selectionHistory, nodeSelectionProvider);
		}

		@Override
		public void run() {
			ITextRegion old = getSelectionHistory().getLast();
			if (old != null) {
				try {
					getSelectionHistory().ignoreSelectionChanges();
					getXtextEditor().selectAndReveal(old.getOffset(), old.getLength());
				} finally {
					getSelectionHistory().listenToSelectionChanges();
				}
			}
		}
	}

}
