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
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.serializer.IRecursiveSemanitcSequencer;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISemanticSequencer.ISemanticSequencerOwner;
import org.eclipse.xtext.serializer.acceptor.IRecursiveSemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecursiveSemanticSequencer implements IRecursiveSemanitcSequencer, ISemanticSequencerOwner {

	protected static class SemanitcAcceptor implements ISemanticSequenceAcceptor {

		protected IRecursiveSemanticSequenceAcceptor delegateAcceptor;

		protected ISemanticSequencer delegateSequencer;

		protected Acceptor errorAcceptor;

		public SemanitcAcceptor(ISemanticSequencer sequencer, IRecursiveSemanticSequenceAcceptor acceptor,
				Acceptor errors) {
			this.delegateAcceptor = acceptor;
			this.delegateSequencer = sequencer;
			this.errorAcceptor = errors;
		}

		public void acceptAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
			delegateAcceptor.enterAssignedAction(action, semanticChild, node);
			delegateSequencer.createSequence(action, semanticChild, this, errorAcceptor);
			delegateAcceptor.leaveAssignedAction(action, semanticChild);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
				ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index,
				ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
				ILeafNode node) {
			delegateAcceptor.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index,
				ICompositeNode node) {
			delegateAcceptor.acceptAssignedDatatype(datatypeRC, token, value, index, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
			delegateAcceptor.acceptAssignedEnum(enumRC, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, token, value, index, node);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
			delegateAcceptor.enterAssignedParserRuleCall(ruleCall, semanticChild, node);
			delegateSequencer.createSequence(ruleCall.getRule(), semanticChild, this, errorAcceptor);
			delegateAcceptor.leaveAssignedParserRuleCall(ruleCall);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
			delegateAcceptor.acceptAssignedTerminal(terminalRC, token, value, index, node);
		}

		public void finish() {
		}
	}

	protected ISemanticSequencer delegate;

	public void createSequence(EObject context, EObject semanticObject,
			IRecursiveSemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		SemanitcAcceptor acceptor = new SemanitcAcceptor(delegate, sequenceAcceptor, errorAcceptor);
		delegate.createSequence(context, semanticObject, acceptor, errorAcceptor);
	}

	@Inject
	public void setSemanticSequencer(ISemanticSequencer delegate) {
		this.delegate = delegate;
	}

}
