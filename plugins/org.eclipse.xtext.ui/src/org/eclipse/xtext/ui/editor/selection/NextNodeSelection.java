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
public class NextNodeSelection extends AbstractNodeSelectionProvider {
	public static final String ACTION_DEFINITION_ID = "org.eclipse.xtext.ui.editor.select.next"; //$NON-NLS-1$

	@Override
	public ITextRegion doSelect(ICompositeNode startNode, ICompositeNode endNode, ITextRegion currentTextSelection) {
		INode nextStartNode = startNode;
		INode nextEndNode = endNode;
		if (nextEndNode.hasNextSibling() && nextEndNode.getOffset() >= nextStartNode.getOffset()) {
			nextEndNode = findNextCompositeSibling(nextEndNode);
			if (nextEndNode.getOffset() < nextStartNode.getOffset()) {
				nextStartNode = findPreviousCompositeSibling(nextStartNode);
				if (nextStartNode.getTotalEndOffset() > endNode.getTotalEndOffset()) {
					nextEndNode = nextStartNode;
				} else {
					nextEndNode = endNode;
				}
			}
		} else if (nextStartNode.hasPreviousSibling()) {
			nextStartNode = findPreviousCompositeSibling(nextStartNode);
		}
		return createTextRegion(nextStartNode, nextEndNode);
	}

	@Override
	protected IAction createAction(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction nodeSelectionAction = new NodeSelectionAction(NodeSelectionMessages.NodeSelectNext_label,
				xtextEditor, selectionHistory, this);
		nodeSelectionAction.setActionDefinitionId(ACTION_DEFINITION_ID);
		nodeSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectNext_tooltip);
		nodeSelectionAction.setDescription(NodeSelectionMessages.NodeSelectNext_description);
		return nodeSelectionAction;
	}

}