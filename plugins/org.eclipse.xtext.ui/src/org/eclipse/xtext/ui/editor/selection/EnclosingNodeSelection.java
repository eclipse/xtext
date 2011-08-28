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
public class EnclosingNodeSelection extends AbstractNodeSelectionProvider {
	public static final String ACTION_DEFINITION_ID = "org.eclipse.xtext.ui.editor.select.enclosing"; //$NON-NLS-1$

	@Override
	public ITextRegion doSelect(ICompositeNode startNode, ICompositeNode endNode, ITextRegion currentTextSelection) {
		return hasParent(startNode) ? createTextRegion(findCompositeNodeAtOffset(startNode.getParent())) : currentTextSelection;
	}

	@Override
	protected IAction createAction(XtextEditor xtextEditor, SelectionHistory selectionHistory) {
		NodeSelectionAction nodeSelectionAction = new NodeSelectionAction(
				NodeSelectionMessages.NodeSelectEnclosing_label, xtextEditor, selectionHistory, this);
		nodeSelectionAction.setActionDefinitionId(ACTION_DEFINITION_ID);
		nodeSelectionAction.setToolTipText(NodeSelectionMessages.NodeSelectEnclosing_tooltip);
		nodeSelectionAction.setDescription(NodeSelectionMessages.NodeSelectEnclosing_description);
		return nodeSelectionAction;
	}

}
