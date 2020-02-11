/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;

/**
 * Used by the {@link AbstractPartialContentAssistParser} to find the node at which to start parsing.
 * @since 2.9
 */
public class EntryPointFinder {
	public ICompositeNode findEntryPoint(IParseResult parseResult, int offset) {
		ICompositeNode rootNode = parseResult.getRootNode();
		if (rootNode.getTotalLength() == offset) {
			return null;
		}
		ILeafNode leafNode = NodeModelUtils.findLeafNodeAtOffset(rootNode, offset);
		ICompositeNode parent = leafNode.getParent();
		ICompositeNode result = findEntryPoint(parent, offset);
		if (result != null) {
			EObject grammarElement = result.getGrammarElement();
			if (grammarElement instanceof AbstractElement) {
				return result;
			}
		}
		return null;
	}

	protected ICompositeNode findEntryPoint(ICompositeNode node, int offset) {
		ICompositeNode result = node;
		result = getApplicableNode(result);
		while (result != null) {
			int remainingLookAhead = result.getLookAhead();
			if (remainingLookAhead != 0) {
				Iterator<ILeafNode> leafNodes = result.getLeafNodes().iterator();
				while (leafNodes.hasNext() && remainingLookAhead > 0) {
					ILeafNode leaf = leafNodes.next();
					if (leaf.getTotalOffset() >= offset) {
						break;
					}
					if (!leaf.isHidden()) {
						if (remainingLookAhead > 0) {
							remainingLookAhead--;
						}
						if (remainingLookAhead == 0) {
							if (shouldUseParent(result, offset, leaf)) {
								ICompositeNode parent = result.getParent();
								return parent;
							}
							return result;
						}
					}
				}
			}
			result = getApplicableNode(result.getParent());
		}
		return result;
	}

	protected boolean shouldUseParent(ICompositeNode result, int offset, ILeafNode leaf) {
		if (leaf.getTotalEndOffset() == offset) {
			return true;
		}
		if (result.getGrammarElement() instanceof RuleCall) {
			RuleCall rc = (RuleCall) result.getGrammarElement();
			if (!rc.getArguments().isEmpty()) {
				return true;
			}
			Assignment assignment = GrammarUtil.containingAssignment(rc);
			if (assignment != null
					&& (GrammarUtil.isMultipleCardinality(assignment) || (assignment.eContainer() instanceof AbstractElement && GrammarUtil
							.isMultipleCardinality((AbstractElement) assignment.eContainer())))) {
				return true;
			}
		}
		return false;
	}

	protected ICompositeNode normalizeToParent(ICompositeNode result) {
		if (result == null) {
			return result;
		}
		ICompositeNode parent = result.getParent();
		while (parent != null && parent.getFirstChild().equals(result)
				&& parent.getLookAhead() == result.getLookAhead()) {
			result = parent;
			parent = result.getParent();
		}
		return result;
	}

	protected ICompositeNode getApplicableNode(ICompositeNode result) {
		while (result != null && (result.getGrammarElement() == null)) {
			result = result.getParent();
		}
		return normalizeToParent(result);
	}
}
