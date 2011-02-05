/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDATransition;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencer implements ISyntacticSequencer {

	protected class Acceptor implements ISemanticSequenceAcceptor {

		protected ISyntacticSequenceAcceptor delegate;

		protected ISerializationDiagnostic.Acceptor errorAcceptor;

		protected IPDAAbsorberState previousState;

		protected Stack<RuleCall> stack;

		protected EObject context;

		public Acceptor(EObject context, IPDAAbsorberState previousState, ISyntacticSequenceAcceptor delegate,
				ISerializationDiagnostic.Acceptor errorAcceptor) {
			this.context = context;
			this.previousState = previousState;
			this.delegate = delegate;
			this.errorAcceptor = errorAcceptor;
			this.stack = new Stack<RuleCall>();
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value) {
			previousState = emitForElement(previousState, datatypeRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedCrossRefDatatype(datatypeRC, value);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value) {
			previousState = emitForElement(previousState, enumRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedCrossRefEnum(enumRC, value);
		}

		public void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value) {
			previousState = emitForElement(previousState, keyword, stack, delegate, errorAcceptor);
			delegate.acceptAssignedCrossRefKeyword(keyword, value);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value) {
			previousState = emitForElement(previousState, terminalRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedCrossRefTerminal(terminalRC, value);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, Object value) {
			previousState = emitForElement(previousState, datatypeRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedDatatype(datatypeRC, value);
		}

		public void acceptAssignedEnum(RuleCall enumRC, Object value) {
			previousState = emitForElement(previousState, enumRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedEnum(enumRC, value);
		}

		public void acceptAssignedKeyword(Keyword keyword, String value) {
			previousState = emitForElement(previousState, keyword, stack, delegate, errorAcceptor);
			delegate.acceptAssignedKeyword(keyword, value);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, Object value) {
			previousState = emitForElement(previousState, terminalRC, stack, delegate, errorAcceptor);
			delegate.acceptAssignedTerminal(terminalRC, value);
		}

		public void acceptAssignedKeyword(Keyword keyword, Boolean value) {
			previousState = emitForElement(previousState, keyword, stack, delegate, errorAcceptor);
			delegate.acceptAssignedKeyword(keyword, value);
		}

		public void acceptAssignedAction(Action action, EObject semanticChild) {
			previousState = emitForElement(previousState, action, stack, delegate, errorAcceptor);
			delegate.acceptAssignedAction(action, semanticChild);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild) {
			previousState = emitForElement(previousState, ruleCall, stack, delegate, errorAcceptor);
			delegate.acceptAssignedParserRuleCall(ruleCall, semanticChild);
		}

	}

	@Inject
	protected ISyntacticSequencerDiagnosticProvider diagnosticProvider;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	@Inject
	protected ISemanticSequencer semanitcSequencer;

	public ISemanticSequenceAcceptor createAcceptor(EObject ctx, EObject semanticRoot,
			ISyntacticSequenceAcceptor constructor, ISerializationDiagnostic.Acceptor errorAcceptor) {
		IPDAAbsorberState startState = ctx instanceof ParserRule ? pdaProvider.getPDA((ParserRule) ctx) : pdaProvider
				.getPDA((Action) ctx);
		return new Acceptor(ctx, startState, constructor, errorAcceptor);
	}

	protected IPDAAbsorberState emitForActionEnter(IPDAAbsorberState from, Action to, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		return from;
	}

	protected IPDAAbsorberState emitForActionLeave(IPDAAbsorberState from, Action to, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (from == null)
			return null;
		IPDATransition routes = from.getOutTransitionsByElement().get(to);
		if (routes == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(from, to, false));
			return null;
		}
		return emitForElement(routes, stack, delegate, errorAcceptor);
		//		return from;
	}

	protected IPDAAbsorberState emitForElement(IPDAAbsorberState from, AbstractElement to, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (from == null)
			return null;
		IPDATransition routes = from.getOutTransitionsByElement().get(to);
		if (routes == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(from, to, false));
			return null;
		}
		return emitForElement(routes, stack, delegate, errorAcceptor);
	}

	protected abstract IPDAAbsorberState emitForElement(IPDATransition transition, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor);

	protected IPDAAbsorberState emitForRuleCallEnter(IPDAAbsorberState from, RuleCall to, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (from == null)
			return null;
		IPDATransition routes = from.getOutTransitionsByRuleCallEnter().get(to);
		if (routes == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(from, to, false));
			return null;
		}
		IPDAAbsorberState result = emitForElement(routes, stack, delegate, errorAcceptor);
		stack.push(to);
		return result;
	}

	protected IPDAAbsorberState emitForRuleCallLeave(IPDAAbsorberState from, RuleCall to, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (from == null)
			return null;
		IPDATransition routes = from.getOutTransitionsByRuleCallExit().get(to);
		if (routes == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(from, to, true));
			return null;
		}
		IPDAAbsorberState result = emitForElement(routes, stack, delegate, errorAcceptor);
		RuleCall lastRc = stack.pop();
		if (lastRc != to) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createUnexpectedStackStateDiagnostic(result, stack));
		}
		return result;
	}

}
