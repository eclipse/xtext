/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeAdapterFactory;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;

/**
 * @author Peter Friese - Initial contribution and API
 */
public class DefaultSemanticModelTransformer extends AbstractSemanticModelTransformer {
	
	final static Logger logger = Logger.getLogger(AbstractSemanticModelTransformer.class);

	public boolean consumeSemanticNode(EObject semanticNode) {
		if (semanticNode != null) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic node type [" + name + "]?");
			}
			return true;
		}
		else {
			return false;
		}
	}

	public boolean consumeSemanticChildNodes(EObject semanticNode) {
		if (semanticNode != null) {
			String name = semanticNode.eClass().getName();
			if (logger.isDebugEnabled()) {
				logger.debug("Consume semantic children of node type [" + name + "]?");
			}
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	protected ContentOutlineNode createOutlineNode(EObject semanticNode, ContentOutlineNode outlineParentNode) {
		ContentOutlineNode outlineNode = new ContentOutlineNode();

		outlineNode.setLabel(getText(semanticNode));

		NodeAdapter nodeAdapter = (NodeAdapter) NodeAdapterFactory.INSTANCE.adapt(semanticNode, AbstractNode.class);
		CompositeNode parserNode = nodeAdapter.getParserNode();
		if (parserNode != null) {
			SelectionCoordinates selectionNodeCoordinates = getSelectionNodeCoordinates(parserNode);
			outlineNode.setSelectionOffset(selectionNodeCoordinates.getOffset());
			outlineNode.setSelectionLength(selectionNodeCoordinates.getLength());
		}

		// link with parent
		if (outlineParentNode != null) {
			outlineParentNode.getChildren().add(outlineNode);
			outlineNode.setParent(outlineParentNode);
		}

		/*
		 * This adapter will be added to the semantic node in order to later be
		 * able to get the corresponding ContentOutlineNode. This is needed e.g.
		 * when we want to synch the outline with the currently selected editor
		 * position.
		 */
		ContentOutlineNodeAdapter outlineAdapter = (ContentOutlineNodeAdapter) ContentOutlineNodeAdapterFactory.INSTANCE
				.adapt(semanticNode, ContentOutlineNode.class);
		outlineAdapter.setContentOutlineNode(outlineNode);

		return outlineNode;
	}

	private class SelectionCoordinates {
		private int offset;
		private int length;

		public SelectionCoordinates(int offset, int length) {
			this.setOffset(offset);
			this.setLength(length);
		}

		public void setLength(int length) {
			this.length = length;
		}

		public int getLength() {
			return length;
		}

		public void setOffset(int offset) {
			this.offset = offset;
		}

		public int getOffset() {
			return offset;
		}
	}

	private SelectionCoordinates getSelectionNodeCoordinates(CompositeNode startNode) {
		EList<AbstractNode> leafNodes = startNode.getChildren();
		AbstractNode keywordNode = null;
		List<AbstractNode> idNodes = null;
		for (AbstractNode leafNode : leafNodes) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) grammarElement;
				String ruleName = ruleCall.getRule().getName();

				if (ruleName.equals("ID")) {
					if (idNodes == null) {
						idNodes = new ArrayList<AbstractNode>();
					}
					idNodes.add(leafNode);
				}
			}
			else if (grammarElement instanceof Keyword) {
				if (keywordNode == null) {
					keywordNode = leafNode;
				}
			}
		}

		if (idNodes != null) {
			// if we've got more than one ID elements, we want to select
			// them all
			AbstractNode firstIdNode = idNodes.get(0);
			AbstractNode lastIdNode = idNodes.get(idNodes.size() - 1);
			int length = (lastIdNode.getOffset() - firstIdNode.getOffset()) + lastIdNode.getLength();
			return new SelectionCoordinates(firstIdNode.getOffset(), length);
		}
		else if (keywordNode != null) {
			return new SelectionCoordinates(keywordNode.getOffset(), keywordNode.getLength());
		}
		else {
			return new SelectionCoordinates(startNode.getOffset(), startNode.getLength());
		}
	}
}