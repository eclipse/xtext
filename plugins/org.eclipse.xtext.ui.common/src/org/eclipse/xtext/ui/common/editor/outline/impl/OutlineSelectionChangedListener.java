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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.common.editor.outline.ContentOutlineNode;
import org.eclipse.xtext.ui.common.editor.outline.XtextContentOutlinePage;
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * This listener listens to selections in the outline and will update the editor
 * selection accordingly.
 * 
 * @author Peter Friese - Initial contribution and API
 */
public final class OutlineSelectionChangedListener extends AbstractSelectionChangedListener {

	public OutlineSelectionChangedListener(XtextContentOutlinePage outlinePage) {
		super(outlinePage);
	}

	public void selectionChanged(SelectionChangedEvent event) {
		ISelection sel = event.getSelection();
		if (sel instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) sel;
			Object firstElement = structuredSelection.getFirstElement();
			if (firstElement instanceof ContentOutlineNode) {
				final ContentOutlineNode outlineNode = (ContentOutlineNode) firstElement;
				getDocument().readOnly(new UnitOfWork<Object>() {
					public Object exec(XtextResource resource) throws Exception {
						EObject semanticNode = outlineNode.getSemanticNode();
						NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(semanticNode);
						if (nodeAdapter != null) {
							CompositeNode parserNode = nodeAdapter.getParserNode();

							SelectionCoordinates selectionNodeCoordinates = getSelectionNodeCoordinates(parserNode);
							int offset = selectionNodeCoordinates.getOffset();
							int length = selectionNodeCoordinates.getLength();

							getSourceViewer().revealRange(offset, length);
							getSourceViewer().setSelectedRange(offset, length);
						}

						return null;
					}
				});

			}
		}
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
			// if we've got more than one ID elements, we want to select them all
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
