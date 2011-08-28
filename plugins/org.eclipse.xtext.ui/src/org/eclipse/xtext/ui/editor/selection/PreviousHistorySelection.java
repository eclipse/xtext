/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class PreviousHistorySelection extends AbstractNodeSelectionProvider {
	public static final String ACTION_DEFINITION_ID = "org.eclipse.xtext.ui.editor.select.last"; //$NON-NLS-1$

	@Override
	protected IAction createAction(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction nodeSelectionAction = new PreviousFromHistorySelectionAction(
				NodeSelectionMessages.NodeSelectHistory_label, xtextEditor, selectionHistory, this);
		nodeSelectionAction.setActionDefinitionId(ACTION_DEFINITION_ID);
		nodeSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectHistory_tooltip);
		nodeSelectionAction.setDescription(NodeSelectionMessages.NodeSelectHistory_description);
		return nodeSelectionAction;
	}

	public static class PreviousFromHistorySelectionAction extends NodeSelectionAction {

		public PreviousFromHistorySelectionAction(String text, XtextEditor xtextEditor,
				SelectionHistory selectionHistory, INodeSelectionProvider nodeSelectionProvider) {
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

	@Override
	protected ITextRegion doSelect(ICompositeNode startNode, ICompositeNode endNode, ITextRegion currentTextSelection) {
		return ITextRegion.EMPTY_REGION;
	}

}
