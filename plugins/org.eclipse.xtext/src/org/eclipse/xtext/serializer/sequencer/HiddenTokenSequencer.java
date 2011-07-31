/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

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

	protected INode rootNode;

	protected ISyntacticSequencer sequencer;

	@Inject
	protected TokenUtil tokenUtil;

	public void acceptAssignedCrossRefDatatype(RuleCall rc, String tkn, EObject val, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedCrossRefDatatype(rc, tkn, val, index, node);
	}

	public void acceptAssignedCrossRefEnum(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedCrossRefEnum(rc, token, value, index, node);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedCrossRefTerminal(rc, token, value, index, node);
	}

	public void acceptAssignedDatatype(RuleCall rc, String token, Object value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedDatatype(rc, token, value, index, node);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	public void acceptUnassignedAction(Action action) {
		delegate.acceptUnassignedAction(action);
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptUnassignedDatatype(datatypeRC, token, node);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = getLastLeaf(node);
		delegate.acceptUnassignedEnum(enumRC, token, node);
	}

	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptUnassignedKeyword(keyword, token, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
		emitHiddenTokens(getHiddenNodesBetween(lastNode, node));
		lastNode = node;
		delegate.acceptUnassignedTerminal(terminalRC, token, node);
	}

	protected void emitHiddenTokens(List<INode> hiddens /* Set<INode> comments, */) {
		if (hiddens == null)
			return;
		boolean lastNonWhitespace = true;
		for (INode node : hiddens)
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
		if (lastNonWhitespace)// FIXME: determine the whitespace rule correctly 
			delegate.acceptWhitespace(hiddenTokenHelper.getWhitespaceRuleFor(null, ""), "", null);
	}

	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		return delegate.enterAssignedAction(action, semanticChild, node);
	}

	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		return delegate.enterAssignedParserRuleCall(rc, semanticChild, node);
	}

	public void enterUnassignedParserRuleCall(RuleCall rc) {
		delegate.enterUnassignedParserRuleCall(rc);
	}

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

	protected Set<INode> getCommentsForEObject(EObject semanticObject, INode node) {
		if (node == null)
			return Collections.emptySet();
		Set<INode> result = Sets.newHashSet();
		BidiTreeIterator<INode> ti = node.getAsTreeIterable().iterator();
		while (ti.hasNext()) {
			INode next = ti.next();
			if (next.getSemanticElement() != null && next.getSemanticElement() != semanticObject) {
				ti.prune();
				continue;
			}
			if (tokenUtil.isCommentNode(next))
				result.add(next);
		}
		return result;
	}

	protected List<INode> getHiddenNodesBetween(INode from, INode to) {
		if (from == null || to == null)
			return null;
		List<INode> out = Lists.newArrayList();
		NodeIterator ni = new NodeIterator(from);
		while (ni.hasNext()) {
			INode next = ni.next();
			if (tokenUtil.isWhitespaceOrCommentNode(next)) {
				out.add(next);
			} else if (next.equals(to)) {
				if (next instanceof ICompositeNode
						&& (GrammarUtil.isDatatypeRuleCall(next.getGrammarElement())
								|| GrammarUtil.isEnumRuleCall(next.getGrammarElement()) || next.getGrammarElement() instanceof CrossReference))
					while (ni.hasNext()) {
						INode next2 = ni.next();
						if (tokenUtil.isWhitespaceOrCommentNode(next2)) {
							out.add(next2);
						} else if (next2 instanceof ILeafNode)
							return out;
					}
				else
					return out;
			} else if (tokenUtil.isToken(next))
				return null;
		}
		return out;
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

	public void init(EObject context, EObject semanticObject, ISequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		this.delegate = sequenceAcceptor;
		this.lastNode = NodeModelUtils.findActualNodeFor(semanticObject);
		this.rootNode = lastNode;
	}

	public void leaveAssignedAction(Action action, EObject semanticChild) {
		delegate.leaveAssignedAction(action, semanticChild);
	}

	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		delegate.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	public void leaveUnssignedParserRuleCall(RuleCall rc) {
		delegate.leaveUnssignedParserRuleCall(rc);
	}

}
