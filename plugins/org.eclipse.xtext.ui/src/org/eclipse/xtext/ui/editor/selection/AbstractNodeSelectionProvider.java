/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.selection;

import static org.eclipse.xtext.nodemodel.util.NodeModelUtils.*;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.action.IAction;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.TextRegion;

/**
 * @author Michael Clay - Initial contribution and API
 */
public abstract class AbstractNodeSelectionProvider implements INodeSelectionProvider {

	public void initialize(XtextEditor xtextEditor) {
		IAction action = createAction(xtextEditor);
		xtextEditor.setAction(action.getActionDefinitionId(), action);
	}

	public ITextRegion select(ICompositeNode rootNode, ITextRegion currentTextSelection) {
		int totalEndOffsetOfCurrentSelection = getTotalEndOffset(currentTextSelection);
		boolean selectionAtEndOfText = rootNode.getTotalEndOffset() == totalEndOffsetOfCurrentSelection;
		int offset = selectionAtEndOfText && currentTextSelection.getOffset() > 0 ? currentTextSelection.getOffset() - 1
				: currentTextSelection.getOffset();
		ICompositeNode startNode = findCompositeNodeAtOffset(findLeafNodeAtOffset(rootNode, offset));
		int endOffset = selectionAtEndOfText || currentTextSelection.getLength() > 0 ? totalEndOffsetOfCurrentSelection - 1
				: totalEndOffsetOfCurrentSelection;
		ICompositeNode endNode = findCompositeNodeAtTotalEndOffset(findLeafNodeAtOffset(rootNode, endOffset));
		return currentTextSelection.getLength()==0 ? createTextRegion(startNode, endNode) : doSelect(startNode, endNode, currentTextSelection);
	}

	protected abstract ITextRegion doSelect(ICompositeNode startNode, ICompositeNode endNode, ITextRegion currentTextSelection);

	protected IAction createAction(XtextEditor xtextEditor) {
		Assert.isNotNull(xtextEditor);
		SelectionHistory selectionHistory = (SelectionHistory) xtextEditor.getAdapter(SelectionHistory.class);
		return createAction(xtextEditor, selectionHistory);
	}

	protected abstract IAction createAction(XtextEditor xtextEditor, SelectionHistory selectionHistory);

	// NodeModel util methods for selection
	protected ICompositeNode findNextCompositeSibling(INode compositeNode) {
		INode node = compositeNode;
		while ((node.getTotalEndOffset() <= compositeNode.getTotalEndOffset() || node instanceof ILeafNode)
				&& node.hasNextSibling()) {
			node = node.getNextSibling();
		}
		return findCompositeNodeAtOffset(node);
	}

	protected ICompositeNode findCompositeNodeAtTotalEndOffset(INode rootNode) {
		return findCompositeNodeAtTotalEndOffset((ICompositeNode) (rootNode instanceof ILeafNode ? rootNode.getParent()
				: rootNode));
	}

	protected ICompositeNode findCompositeNodeAtTotalEndOffset(ICompositeNode compositeNode) {
		while (hasParent(compositeNode)
				&& compositeNode.getParent().getTotalEndOffset() <= compositeNode.getTotalEndOffset()) {
			compositeNode = compositeNode.getParent();
		}
		return compositeNode;
	}

	protected ICompositeNode findPreviousCompositeSibling(INode compositeNode) {
		INode node = compositeNode;
		while ((node.getOffset() >= compositeNode.getOffset() || node instanceof ILeafNode)
				&& node.hasPreviousSibling()) {
			node = node.getPreviousSibling();
		}
		return findCompositeNodeAtOffset(node);
	}

	protected ICompositeNode findCompositeNodeAtOffset(INode rootNode) {
		return findCompositeNodeAtOffset((ICompositeNode) (rootNode instanceof ILeafNode ? rootNode.getParent()
				: rootNode));
	}

	protected ICompositeNode findCompositeNodeAtOffset(ICompositeNode compositeNode) {
		while (hasParent(compositeNode) && compositeNode.getParent().getOffset() >= compositeNode.getOffset()) {
			compositeNode = compositeNode.getParent();
		}
		return compositeNode;
	}

	protected boolean hasParent(INode node) {
		return node != null && node.getParent() != null;
	}

	protected ITextRegion createTextRegion(INode node) {
		return createTextRegion(node, node);
	}

	protected ITextRegion createTextRegion(INode startNode, INode endNode) {
		return new TextRegion(startNode.getOffset(), endNode.getTotalEndOffset() - startNode.getOffset());
	}

	protected int getTotalEndOffset(ITextRegion textRegion) {
		return textRegion.getOffset() + textRegion.getLength();
	}

}

