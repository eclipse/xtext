/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.util.Pair;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenTokenSequencer implements IHiddenTokenSequencer, ISyntacticSequenceAcceptor {

	//		protected Set<INode> comments;

	protected ISequenceAcceptor delegate;

	@Inject
	protected IHiddenTokenHelper hiddenTokenHelper;

	protected INode lastNode;
	
	protected INode lastEmittedNode;

	protected INode rootNode;
	
	private int rootOffset;
	
	private int rootEndOffset;

	protected ISyntacticSequencer sequencer;

	@Inject
	protected TokenUtil tokenUtil;

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall rc, String tkn, EObject val, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedCrossRefDatatype(rc, tkn, val, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedCrossRefEnum(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedCrossRefTerminal(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall rc, String token, Object value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedDatatype(rc, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptUnassignedAction(Action action) {
		delegate.acceptUnassignedAction(action);
	}

	@Override
	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptUnassignedDatatype(datatypeRC, token, node);
	}

	@Override
	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptUnassignedEnum(enumRC, token, node);
	}

	@Override
	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptUnassignedKeyword(keyword, token, node);
	}

	@Override
	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptUnassignedTerminal(terminalRC, token, node);
	}

	protected void emitHiddenTokens(List<INode> hiddens /* Set<INode> comments, */) {
		if (hiddens == null)
			return;
		boolean lastNonWhitespace = true;
		for (INode node : hiddens) {
			if (tokenUtil.isCommentNode(node)) {
				if (lastNonWhitespace)
					delegate.acceptWhitespace(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "", null);
				lastNonWhitespace = true;
				//				comments.remove(node);
				delegate.acceptComment((AbstractRule) node.getGrammarElement(), node.getText(), (ILeafNode) node);
			} else {
				delegate.acceptWhitespace((AbstractRule) node.getGrammarElement(), node.getText(), (ILeafNode) node);
				lastNonWhitespace = false;
			}
			lastEmittedNode = node;
		}
		if (lastNonWhitespace)// FIXME: determine the whitespace rule correctly 
			delegate.acceptWhitespace(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "", null);
	}

	@Override
	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		return delegate.enterAssignedAction(action, semanticChild, node);
	}

	@Override
	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		return delegate.enterAssignedParserRuleCall(rc, semanticChild, node);
	}

	@Override
	@Deprecated
	public void enterUnassignedParserRuleCall(RuleCall rc) {
		delegate.enterUnassignedParserRuleCall(rc);
	}

	@Override
	public void finish() {
		if (rootNode != null && rootNode == rootNode.getRootNode()) {
			List<INode> hidden = getRemainingHiddenNodesInContainer(lastNode, rootNode);
			if (!hidden.isEmpty()) {
				emitHiddenTokens(hidden);
				lastNode = rootNode;
			}
		}
		delegate.finish();
	}

	/**
	 * @return null if the whitespace between these nodes is unknown. 
	 * In this case, the formatter needs to decide.
	 */
	protected List<INode> getHiddenNodesBetween(INode from, INode to) {
		if (from == null && to == null)
			return null;
		List<INode> out = Lists.newArrayList();
		Set<EObject> deletedSemanticElements = Sets.newHashSet();

		if (to == null) {
			NodeIterator ni = new NodeIterator(from);
			while (ni.hasNext()) {
				INode next = ni.next();
				if (next.getTotalOffset() > rootEndOffset) {
					break;
				}
				if (next == lastEmittedNode) {
					break;
				} else if (tokenUtil.isWhitespaceOrCommentNode(next)) {
					out.add(next);
				} else if (belongsToDeletedElement(next)) {
					handleDeletedElement(out, deletedSemanticElements, next);
					ni.prune();
				} else {
					break;
				}
			}
		} else if (from == null) {
			NodeIterator ni = new NodeIterator(to);
			while (ni.hasPrevious()) {
				INode prev = ni.previous();
				if (prev.getTotalEndOffset()  < rootOffset) {
					break;
				}
				if (prev == lastEmittedNode) {
					break;
				} else if (tokenUtil.isWhitespaceOrCommentNode(prev)) {
					out.add(0, prev);
				} else if (belongsToDeletedElement(prev)) {
					handleDeletedElement(out, deletedSemanticElements, prev);
					ni.prune();
				} else {
					break;
				}
			}
		} else {
			NodeIterator ni = new NodeIterator(from);
			while (ni.hasNext()) {
				INode next = ni.next();
				if (tokenUtil.isWhitespaceOrCommentNode(next)) {
					out.add(next);
				} else if (next.equals(to)) {
					if (next instanceof ICompositeNode
							&& (GrammarUtil.isDatatypeRuleCall(next.getGrammarElement())
									|| GrammarUtil.isEnumRuleCall(next.getGrammarElement()) || next.getGrammarElement() instanceof CrossReference)) {
						while (ni.hasNext()) {
							INode next2 = ni.next();
							if (tokenUtil.isWhitespaceOrCommentNode(next2)) {
								out.add(next2);
							} else if (next2 instanceof ILeafNode) {
								break;
							}
						}
						break;
					} else {
						break;
					}
				} else if (belongsToDeletedElement(next)) {
					handleDeletedElement(out, deletedSemanticElements, next);
					ni.prune();
				} else if (tokenUtil.isToken(next)) {
					break;
				}
			}
		}
		if ((from == null || to == null) && out.isEmpty()) {
			return null;
		} else {
			return filterNodesOfDeletedElements(out, deletedSemanticElements);
		}
	}

	protected boolean belongsToDeletedElement(INode node) {
		return node instanceof ICompositeNode 
				&& node.getSemanticElement() != null
				&& node.getSemanticElement().eResource() == null;
	}
	
	protected void handleDeletedElement(List<INode> out, Set<EObject> deletedSemanticElements, INode nodeOfDeletedElement) {
		deletedSemanticElements.add(nodeOfDeletedElement.getSemanticElement());
		Pair<List<ILeafNode>, List<ILeafNode>> surroundingHiddenTokens = tokenUtil
				.getLeadingAndTrailingHiddenTokens(nodeOfDeletedElement);
		out.addAll(surroundingHiddenTokens.getFirst());
		out.addAll(surroundingHiddenTokens.getSecond());
	}
	
	protected List<INode> filterNodesOfDeletedElements(List<INode> allNodes, Set<EObject> deletedElements) {
		List<INode> filtered = Lists.newArrayList();
		filtered.addAll(allNodes);
		for (EObject deletedElement : deletedElements) {
			filtered.removeAll(getHiddenNodesBelongingTo(deletedElement));
		}
		return filtered;
	}

	protected Set<INode> getHiddenNodesBelongingTo(EObject semanticElement) {
		ICompositeNode node = NodeModelUtils.findActualNodeFor(semanticElement);
		if (node == null) return Sets.newHashSet();
		
		Set<INode> associatedNodes = Sets.newHashSet();
		associatedNodes.addAll(getLeadingCommentsIncludingWhitespace(node));
		associatedNodes.addAll(getTrailingCommentsIncludingWhitespace(node));
		//we want trailing comments to have precedence over leading comments
		INode previousNode = node.getPreviousSibling();
		if (previousNode instanceof ICompositeNode) {
			associatedNodes.removeAll(getTrailingCommentsIncludingWhitespace((ICompositeNode) previousNode));
		}
		return associatedNodes;
	}
	
	protected Set<INode> getLeadingCommentsIncludingWhitespace(ICompositeNode node) {
		for (INode child : node.getAsTreeIterable()) {
			if (child instanceof ILeafNode && !((ILeafNode) child).isHidden()) {
				return getLeadingCommentsIncludingWhitespace((ILeafNode) child);
			}
		}
		return Sets.newHashSet();
	}
	
	protected Set<INode> getTrailingCommentsIncludingWhitespace(ICompositeNode node) {
		for (INode child : node.getAsTreeIterable().reverse()) {
			if (child instanceof ILeafNode && !((ILeafNode) child).isHidden()) {
				return getTrailingCommentsIncludingWhitespace((ILeafNode) child);
			}
		}
		return Sets.newHashSet();
	}
	
	protected Set<INode> getLeadingCommentsIncludingWhitespace(ILeafNode node) {
		Set<INode> associatedNodes = Sets.newHashSet();
		Set<INode> pendingWhitespace = Sets.newHashSet();
		INode lastLink = node;
		NodeIterator ni = new NodeIterator(lastLink);
		while(ni.hasPrevious()) {
			INode prev = ni.previous();
			if (tokenUtil.isCommentNode(prev)) {
				if (isLeadingCommentFor(prev, lastLink)) {
					lastLink = prev;
					associatedNodes.addAll(pendingWhitespace);
					associatedNodes.add(prev);
				} else {
					break;
				}
			} else if (tokenUtil.isWhitespaceNode(prev)) {
				pendingWhitespace.add(prev);
			} else if (prev instanceof ILeafNode){
				break;
			}
		}
		return associatedNodes;
	}
	
	protected Set<INode> getTrailingCommentsIncludingWhitespace(ILeafNode node) {
		Set<INode> associatedNodes = Sets.newHashSet();
		Set<INode> pendingWhitespace = Sets.newHashSet();
		INode lastLink = node;
		NodeIterator ni = new NodeIterator(lastLink);
		while(ni.hasNext()) {
			INode next = ni.next();
			if (tokenUtil.isCommentNode(next)) {
				if (isTrailingCommentFor(next, lastLink)) {
					lastLink = next;
					associatedNodes.addAll(pendingWhitespace);
					associatedNodes.add(next);
				} else {
					break;
				}
			} else if (tokenUtil.isWhitespaceNode(next)) {
				pendingWhitespace.add(next);
			} else if (next instanceof ILeafNode){
				break;
			}
		}
		return associatedNodes;
	}
	
	protected boolean isLeadingCommentFor(INode comment, INode node) {
		if (!tokenUtil.isCommentNode(comment)) 
			return false;
		if (comment.getText().endsWith("\n")) {
			return node.getStartLine() == comment.getEndLine();
		} else {
			return node.getStartLine() - comment.getEndLine() <= 1;
		}
	}
	
	protected boolean isTrailingCommentFor(INode comment, INode node) {
		if (!tokenUtil.isCommentNode(comment)) 
			return false;
		if (node.getText().endsWith("\n")) 
			return false;
		return comment.getStartLine() == node.getEndLine();
	}

	protected INode getLastLeaf(INode node) {
		while (node instanceof ICompositeNode)
			node = ((ICompositeNode) node).getLastChild();
		return node;
	}

	protected List<INode> getRemainingHiddenNodesInContainer(INode from, INode root) {
		if (from == null || root == null)
			return Collections.emptyList();
		List<INode> out = Lists.newArrayList();
		NodeIterator ni = new NodeIterator(from);
		while (ni.hasNext()) {
			INode next = ni.next();
			if (next.getTotalOffset() > root.getTotalEndOffset())
				return out;
			else if (tokenUtil.isWhitespaceOrCommentNode(next)) {
				out.add(next);
			} else if (tokenUtil.isToken(next))
				return Collections.emptyList();
		}
		return out;
	}

	@Override
	@Deprecated
	public void init(EObject context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this.delegate = sequenceAcceptor;
		this.lastNode = NodeModelUtils.findActualNodeFor(semanticObject);
		this.rootNode = lastNode;
		if (rootNode != null) {
			this.rootOffset = rootNode.getTotalOffset();
			this.rootEndOffset = rootNode.getTotalEndOffset();
		}
	}
	
	@Override
	public void init(ISerializationContext context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this.delegate = sequenceAcceptor;
		this.lastNode = NodeModelUtils.findActualNodeFor(semanticObject);
		this.rootNode = lastNode;
		if (rootNode != null) {
			this.rootOffset = rootNode.getTotalOffset();
			this.rootEndOffset = rootNode.getTotalEndOffset();
		}
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
		delegate.leaveAssignedAction(action, semanticChild);
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		delegate.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	@Override
	@Deprecated
	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		delegate.leaveUnssignedParserRuleCall(rc);
	}
}
