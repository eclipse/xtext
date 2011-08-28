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
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
public class PreviousNodeSelection extends AbstractNodeSelectionProvider {
	public static final String ACTION_DEFINITION_ID = "org.eclipse.xtext.ui.editor.select.previous"; //$NON-NLS-1$

	@Override
	public ITextRegion doSelect(ICompositeNode startNode, ICompositeNode endNode, ITextRegion currentTextSelection) {
		INode nextStartNode = startNode;
		INode nextEndNode = endNode;
		if (nextStartNode.hasPreviousSibling() && nextStartNode.getTotalEndOffset() <= nextEndNode.getTotalEndOffset()) {
			nextStartNode = findPreviousCompositeSibling(startNode);
			if (nextStartNode.getTotalEndOffset() > nextEndNode.getTotalEndOffset()) {
				nextEndNode = findNextCompositeSibling(nextEndNode);
				if (nextEndNode.getOffset() < startNode.getOffset()) {
					nextStartNode = nextEndNode;
				} else {
					nextStartNode = startNode;
				}
			}
		} else if (nextEndNode.hasNextSibling()) {
			nextEndNode = findNextCompositeSibling(nextEndNode);
		}
		return createTextRegion(nextStartNode, nextEndNode);
	}

	@Override
	protected IAction createAction(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction nodeSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectPrevious_label, xtextEditor, selectionHistory, this);
		nodeSelectionAction.setActionDefinitionId(ACTION_DEFINITION_ID);
		nodeSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectPrevious_tooltip);
		nodeSelectionAction.setDescription(NodeSelectionMessages.NodeSelectPrevious_description);
		return nodeSelectionAction;
	}

}
