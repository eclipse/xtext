/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.IRecursiveSyntacticSequencer;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.acceptor.IRecursiveSyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.ISyntacticSequencer;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecursiveSyntacticSequencer implements IRecursiveSyntacticSequencer {

	protected static class SemanitcAcceptor implements ISyntacticSequenceAcceptor {

		protected IRecursiveSyntacticSequenceAcceptor delegate;

		protected Acceptor errorAcceptor;

		protected INode lastNode;

		protected ISemanticSequencer semanticSeq;

		protected ISyntacticSequencer syntacticSeq;

		public SemanitcAcceptor(ISyntacticSequencer syndelegate, ISemanticSequencer semdelegate, INode lastNode,
				IRecursiveSyntacticSequenceAcceptor acceptor, Acceptor errors) {
			this.delegate = acceptor;
			this.syntacticSeq = syndelegate;
			this.semanticSeq = semdelegate;
			this.errorAcceptor = errors;
			this.lastNode = lastNode;
		}

		public void acceptAssignedAction(Action action, EObject eobject, ICompositeNode node) {
			delegate.enterAssignedAction(action, eobject, node);
			ISemanticSequenceAcceptor acc = syntacticSeq.createAcceptor(action, eobject, node, this, errorAcceptor);
			semanticSeq.createSequence(action, eobject, acc, errorAcceptor);
			delegate.leaveAssignedAction(action, eobject);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value, ICompositeNode node) {
			delegate.acceptAssignedCrossRefDatatype(datatypeRC, value, node);
			lastNode = node;
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value, ICompositeNode node) {
			delegate.acceptAssignedCrossRefEnum(enumRC, value, node);
			lastNode = node;
		}

		public void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value, ILeafNode node) {
			delegate.acceptAssignedCrossRefKeyword(keyword, value, node);
			lastNode = node;
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value, ILeafNode node) {
			delegate.acceptAssignedCrossRefTerminal(terminalRC, value, node);
			lastNode = node;
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, Object value, ICompositeNode node) {
			delegate.acceptAssignedDatatype(datatypeRC, value, node);
			lastNode = node;
		}

		public void acceptAssignedEnum(RuleCall enumRC, Object value, ICompositeNode node) {
			delegate.acceptAssignedEnum(enumRC, value, node);
			lastNode = node;
		}

		public void acceptAssignedKeyword(Keyword keyword, Boolean value, ILeafNode node) {
			delegate.acceptAssignedKeyword(keyword, value, node);
			lastNode = node;
		}

		public void acceptAssignedKeyword(Keyword keyword, String value, ILeafNode node) {
			delegate.acceptAssignedKeyword(keyword, value, node);
			lastNode = node;
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
			ParserRule pr = (ParserRule) ruleCall.getRule();
			delegate.enterAssignedParserRuleCall(ruleCall, semanticChild, node);
			ISemanticSequenceAcceptor acc = syntacticSeq.createAcceptor(pr, semanticChild, node, this, errorAcceptor);
			semanticSeq.createSequence(pr, semanticChild, acc, errorAcceptor);
			delegate.leaveAssignedParserRuleCall(ruleCall);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, Object value, ILeafNode node) {
			delegate.acceptAssignedTerminal(terminalRC, value, node);
			lastNode = node;
		}

		public void acceptUnassignedAction(Action action) {
			delegate.acceptUnassignedAction(action);
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
			delegate.acceptUnassignedDatatype(datatypeRC, value, node);
			lastNode = node;
		}

		public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
			delegate.acceptUnassignedEnum(enumRC, value, node);
			lastNode = node;
		}

		public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
			delegate.acceptUnassignedKeyword(keyword, node);
			lastNode = node;
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
			delegate.acceptUnassignedTerminal(terminalRC, value, node);
			lastNode = node;
		}

		public void enterUnassignedParserRuleCall(RuleCall rc) {
			delegate.enterUnassignedParserRuleCall(rc);
		}

		public void finish(INode node) {
			lastNode = node;
		}

		public void leaveUnssignedParserRuleCall(RuleCall rc) {
			delegate.leaveUnssignedParserRuleCall(rc);
		}

	}

	public void createSequence(ISyntacticSequencer syndelegate, ISemanticSequencer semdelegate, EObject context,
			EObject semanticObject, IRecursiveSyntacticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		SemanitcAcceptor acceptor = new SemanitcAcceptor(syndelegate, semdelegate, node, sequenceAcceptor,
				errorAcceptor);
		ISemanticSequenceAcceptor acc = syndelegate.createAcceptor(context, semanticObject, node, acceptor,
				errorAcceptor);
		semdelegate.createSequence(context, semanticObject, acc, errorAcceptor);
	}

}
