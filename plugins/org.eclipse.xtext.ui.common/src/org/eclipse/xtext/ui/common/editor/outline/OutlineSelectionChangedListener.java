/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.outline;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
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
import org.eclipse.xtext.ui.core.editor.model.UnitOfWork;

/**
 * This listener listens to selections in the outline and will update the
 * editor selection accordingly.
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
			if (firstElement instanceof URI) {
				final URI uri = (URI) firstElement;
				getDocument().readOnly(new UnitOfWork<Object>() {
					public Object exec(XtextResource resource) throws Exception {
						EObject astNode = resource.getResourceSet().getEObject(uri, true);
						NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(astNode);
						CompositeNode parserNode = nodeAdapter.getParserNode();

						AbstractNode selectionNode = findSelectionNode(parserNode);
						int offset = selectionNode.getOffset();
						int length = selectionNode.getLength();

						getSourceViewer().revealRange(offset, length);
						getSourceViewer().setSelectedRange(offset, length);

						return null;
					}
				});

			}
		}
	}

	private AbstractNode findSelectionNode(CompositeNode startNode) {
		EList<AbstractNode> leafNodes = startNode.getChildren();
		AbstractNode keywordNode = null;
		AbstractNode idNode = null;
		for (AbstractNode leafNode : leafNodes) {
			EObject grammarElement = leafNode.getGrammarElement();
			if (grammarElement instanceof RuleCall) {
				RuleCall ruleCall = (RuleCall) grammarElement;
				String ruleName = ruleCall.getName();
				if (idNode == null && ruleName.equals("ID")) {
					idNode = leafNode;
				}
			}
			else if (grammarElement instanceof Keyword) {
				if (keywordNode == null) {
					keywordNode = leafNode;
				}
			}
		}

		if (idNode != null) {
			return idNode;
		}
		else if (keywordNode != null) {
			return keywordNode;
		}
		else {
			return startNode;
		}
	}
}
