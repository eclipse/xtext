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
import org.eclipse.xtext.serializer.IRecursiveSemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISerializationDiagnostic.Acceptor;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class RecursiveSemanticSequencer implements IRecursiveSemanitcSequencer {

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

		public void acceptAssignedAction(Action action, EObject semanticChild) {
			delegateAcceptor.enterAssignedAction(action, semanticChild);
			delegateSequencer.createSequence(action, semanticChild, this, errorAcceptor);
			delegateAcceptor.leaveAssignedAction(action, semanticChild);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedCrossRefEnum(enumRC, value, node);
		}

		public void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value, ILeafNode node) {
			delegateAcceptor.acceptAssignedCrossRefKeyword(keyword, value, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value, ILeafNode node) {
			delegateAcceptor.acceptAssignedCrossRefTerminal(terminalRC, value, node);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, Object value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, Object value, ICompositeNode node) {
			delegateAcceptor.acceptAssignedEnum(enumRC, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, Boolean value, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String value, ILeafNode node) {
			delegateAcceptor.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild) {
			delegateAcceptor.enterAssignedParserRuleCall(ruleCall, semanticChild);
			delegateSequencer.createSequence(ruleCall.getRule(), semanticChild, this, errorAcceptor);
			delegateAcceptor.leaveAssignedParserRuleCall(ruleCall);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, Object value, ILeafNode node) {
			delegateAcceptor.acceptAssignedTerminal(terminalRC, value, node);
		}

		public void finish() {
		}

	}

	protected ISemanticSequencer delegate;

	public void createSequence(ISemanticSequencer delegate, EObject context, EObject semanticObject,
			IRecursiveSemanticSequenceAcceptor sequenceAcceptor, Acceptor errorAcceptor) {
		SemanitcAcceptor acceptor = new SemanitcAcceptor(delegate, sequenceAcceptor, errorAcceptor);
		delegate.createSequence(context, semanticObject, acceptor, errorAcceptor);
	}

}
