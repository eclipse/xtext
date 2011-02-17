/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.IHiddenTokenSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencer.ISyntacticSequencerOwner;
import org.eclipse.xtext.serializer.acceptor.IHiddenTokensAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class HiddenTokenSequencer implements IHiddenTokenSequencer, ISyntacticSequencerOwner {

	protected class SynAcceptor implements ISyntacticSequenceAcceptor {

		protected Set<INode> comments;

		protected ISequenceAcceptor delegate;

		protected INode lastNode;

		protected INode rootNode;

		public SynAcceptor(ISequenceAcceptor delegate, INode lastNode, Set<INode> comments) {
			super();
			this.delegate = delegate;
			this.lastNode = lastNode;
			this.rootNode = lastNode;
			this.comments = comments;
		}

		public void acceptAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedAction(action, semanticChild, node);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall rc, String tkn, EObject val, int index, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedCrossRefDatatype(rc, tkn, val, index, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall rc, String token, EObject value, int index, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedCrossRefEnum(rc, token, value, index, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall rc, String token, EObject value, int index, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptAssignedCrossRefTerminal(rc, token, value, index, node);
		}

		public void acceptAssignedDatatype(RuleCall rc, String token, Object value, int index, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedDatatype(rc, token, value, index, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedEnum(enumRC, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptAssignedParserRuleCall(ruleCall, semanticChild, node);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
		}

		public void acceptUnassignedAction(Action action) {
			delegate.acceptUnassignedAction(action);
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, String token, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptUnassignedDatatype(datatypeRC, token, node);
		}

		public void acceptUnassignedEnum(RuleCall enumRC, String token, ICompositeNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = getLastLeaf(node);
			delegate.acceptUnassignedEnum(enumRC, token, node);
		}

		public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptUnassignedKeyword(keyword, node);
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, String token, ILeafNode node) {
			emitHiddenTokens(getHiddenNodesBetween(lastNode, node), comments, delegate);
			lastNode = node;
			delegate.acceptUnassignedTerminal(terminalRC, token, node);
		}

		public void enterUnassignedParserRuleCall(RuleCall rc) {
			delegate.enterUnassignedParserRuleCall(rc);
		}

		protected INode getLastLeaf(INode node) {
			while (node instanceof ICompositeNode)
				node = ((ICompositeNode) node).getLastChild();
			return node;
		}

		public void finish() {
			if (rootNode == rootNode.getRootNode())
				emitHiddenTokens(getRemainingHiddenNodesInContainer(lastNode, rootNode), comments, delegate);
			delegate.finish();
		}

		public void leaveUnssignedParserRuleCall(RuleCall rc) {
			delegate.leaveUnssignedParserRuleCall(rc);
		}

	}

	protected ISyntacticSequencer sequencer;

	@Inject
	protected TokenUtil tokenUtil;

	protected boolean canPass(INode node) {
		EObject ge = node.getGrammarElement();
		return GrammarUtil.isParserParserRuleCall(ge) || GrammarUtil.isUnassignedAction(ge);
	}

	public void createSequence(EObject context, EObject semanticObject, INode previousNode,
			ISequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		Set<INode> comments = getCommentsForEObject(semanticObject, previousNode);
		SynAcceptor acc = new SynAcceptor(sequenceAcceptor, previousNode, comments);
		sequencer.createSequence(context, semanticObject, previousNode, acc, errorAcceptor);
	}

	protected void emitHiddenTokens(List<INode> hiddens, Set<INode> comments, IHiddenTokensAcceptor acc) {
		for (INode node : hiddens)
			if (tokenUtil.isCommentNode(node)) {
				comments.remove(node);
				acc.acceptComment((AbstractRule) node.getGrammarElement(), node.getText(), (ILeafNode) node);
			} else
				acc.acceptWhitespace((AbstractRule) node.getGrammarElement(), node.getText(), (ILeafNode) node);
	}

	protected Set<INode> getCommentsForEObject(EObject semanticObject, INode node) {
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
			return Collections.emptyList();
		List<INode> out = Lists.newArrayList();
		NodeIterator ni = new NodeIterator(from);
		while (ni.hasNext()) {
			INode next = ni.next();
			if (tokenUtil.isWhitespaceOrCommentNode(next)) {
				out.add(next);
			} else if (next == to) {
				if (GrammarUtil.isDatatypeRuleCall(next.getGrammarElement())
						|| GrammarUtil.isEnumRuleCall(next.getGrammarElement()))
					while (ni.hasNext()) {
						INode next2 = ni.next();
						if (tokenUtil.isWhitespaceOrCommentNode(next2)) {
							out.add(next2);
						} else
							return out;
					}
				else
					return out;
			} else if (!canPass(next))
				return Collections.emptyList();
		}
		return out;
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
			} else if (!canPass(next))
				return Collections.emptyList();
		}
		return out;
	}

	@Inject
	public void setSyntacticSequencer(ISyntacticSequencer sequencer) {
		this.sequencer = sequencer;
	}

}
