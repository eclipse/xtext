/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynFollowerOwner;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.IUnassignedTokenSequenceAcceptor;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencer implements ISyntacticSequencer {

	protected class SemAcceptor implements ISemanticSequenceAcceptor, IUnassignedTokenSequenceAcceptor {

		protected EObject context;

		protected ISyntacticSequenceAcceptor delegate;

		protected ISerializationDiagnostic.Acceptor errorAcceptor;

		protected INode lastNode;

		protected ISynFollowerOwner lastState;

		protected RCStack stack;

		public SemAcceptor(EObject context, ISynAbsorberState previousState, INode previousNode,
				ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
			this.context = context;
			this.lastState = previousState;
			this.lastNode = previousNode;
			this.delegate = delegate;
			this.errorAcceptor = errorAcceptor;
			this.stack = new RCStack();
		}

		public void acceptAssignedAction(Action action, EObject semanticChild) {
			lastState = transitionBegin(lastState, lastNode, action, null, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, null, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			lastNode = delegate.acceptAssignedAction2(action, semanticChild);
		}

		public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, EObject value, ICompositeNode node) {
			lastState = transitionBegin(lastState, lastNode, datatypeRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedCrossRefDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedCrossRefEnum(RuleCall enumRC, EObject value, ICompositeNode node) {
			lastState = transitionBegin(lastState, lastNode, enumRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedCrossRefEnum(enumRC, value, node);
		}

		public void acceptAssignedCrossRefKeyword(Keyword keyword, EObject value, ILeafNode node) {
			lastState = transitionBegin(lastState, lastNode, keyword, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedCrossRefKeyword(keyword, value, node);
		}

		public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, EObject value, ILeafNode node) {
			lastState = transitionBegin(lastState, lastNode, terminalRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedCrossRefTerminal(terminalRC, value, node);
		}

		public void acceptAssignedDatatype(RuleCall datatypeRC, Object value, ICompositeNode node) {
			lastState = transitionBegin(lastState, lastNode, datatypeRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedDatatype(datatypeRC, value, node);
		}

		public void acceptAssignedEnum(RuleCall enumRC, Object value, ICompositeNode node) {
			lastState = transitionBegin(lastState, lastNode, enumRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedEnum(enumRC, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, Boolean value, ILeafNode node) {
			lastState = transitionBegin(lastState, lastNode, keyword, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedKeyword(Keyword keyword, String value, ILeafNode node) {
			lastState = transitionBegin(lastState, lastNode, keyword, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedKeyword(keyword, value, node);
		}

		public void acceptAssignedParserRuleCall(RuleCall ruleCall, EObject semanticChild) {
			lastState = transitionBegin(lastState, null, ruleCall, null, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, null, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			lastNode = delegate.acceptAssignedParserRuleCall2(ruleCall, semanticChild);
		}

		public void acceptAssignedTerminal(RuleCall terminalRC, Object value, ILeafNode node) {
			lastState = transitionBegin(lastState, lastNode, terminalRC, node, stack, delegate, errorAcceptor);
			transition(lastState, lastNode, node, stack, this, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptAssignedTerminal(terminalRC, value, node);
		}

		public void acceptUnassignedAction(Action action) {
			lastState = transition(lastState, lastNode, action, null, stack, delegate, errorAcceptor);
			delegate.acceptUnassignedAction(action);
		}

		public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
			lastState = transition(lastState, lastNode, datatypeRC, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptUnassignedDatatype(datatypeRC, value, node);
		}

		public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
			lastState = transition(lastState, lastNode, enumRC, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptUnassignedEnum(enumRC, value, node);
		}

		public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
			lastState = transition(lastState, lastNode, keyword, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptUnassignedKeyword(keyword, node);
		}

		public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
			lastState = transition(lastState, lastNode, terminalRC, node, stack, delegate, errorAcceptor);
			lastNode = node;
			delegate.acceptUnassignedTerminal(terminalRC, value, node);
		}

		public void finish() {
			lastState = transitionBegin(lastState, null, null, null, stack, delegate, errorAcceptor);
			lastState = transitionFinish(lastState, lastNode, null, stack, delegate, errorAcceptor);
			delegate.finish(lastNode);
		}

	}

	@Inject
	protected ISyntacticSequencerDiagnosticProvider diagnosticProvider;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	@Inject
	protected ISemanticSequencer semanitcSequencer;

	protected void accept(INode fromNode, List<ISynState> path, RCStack stack, ISyntacticSequenceAcceptor delegate,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (path.isEmpty())
			return;
		EmitterNodeFinder nodes = new EmitterNodeFinder(fromNode);
		RCStack bak = stack.clone();
		for (ISynState emitter : path)
			accept(emitter, nodes.next(emitter.getGrammarElement()), stack, delegate, errorAcceptor);
	}

	protected void accept(ISynState emitter, INode node, RCStack stack, ISyntacticSequenceAcceptor delegate,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		switch (emitter.getType()) {
			case UNASSIGNED_PARSER_RULE_ENTER:
				RuleCall rc1 = (RuleCall) emitter.getGrammarElement();
				delegate.enterUnassignedParserRuleCall(rc1);
				stack.push(rc1);
				return;
			case UNASSIGNED_PARSER_RULE_EXIT:
				RuleCall rc2 = (RuleCall) emitter.getGrammarElement();
				delegate.leaveUnssignedParserRuleCall(rc2);
				RuleCall lastRc = stack.pop();
				if (lastRc != rc2) {
					if (errorAcceptor != null)
						errorAcceptor.accept(diagnosticProvider.createUnexpectedStackStateDiagnostic(emitter, stack));
				}
				return;
			case UNASSIGEND_ACTION_CALL:
				delegate.acceptUnassignedAction((Action) emitter.getGrammarElement());
				return;
			case UNASSIGEND_KEYWORD:
				Keyword keyword = (Keyword) emitter.getGrammarElement();
				delegate.acceptUnassignedKeyword(keyword, (ILeafNode) node);
				return;
			case UNASSIGNED_DATATYPE_RULE_CALL:
				RuleCall rc3 = (RuleCall) emitter.getGrammarElement();
				delegate.acceptUnassignedDatatype(rc3, "foo", (ICompositeNode) node); // TODO: allow to customize this value
				return;
			case UNASSIGNED_TERMINAL_RULE_CALL:
				RuleCall rc4 = (RuleCall) emitter.getGrammarElement();
				delegate.acceptUnassignedDatatype(rc4, "foo", (ICompositeNode) node); // TODO: allow to customize this value
				return;
			case ASSIGNED_ACTION_CALL:
			case ASSIGNED_BOOLEAN_KEYWORD:
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
			case ASSIGNED_CROSSREF_KEYWORD:
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
			case ASSIGNED_DATATYPE_RULE_CALL:
			case ASSIGNED_ENUM_RULE_CALL:
			case ASSIGNED_KEYWORD:
			case ASSIGNED_PARSER_RULE_CALL:
			case ASSIGNED_TERMINAL_RULE_CALL:
			case START:
			case STOP:
			case TRANSITION:
		}
		throw new RuntimeException("invalid state for emitting: " + emitter + " (" + emitter.getType() + ")");
	}

	public ISemanticSequenceAcceptor createAcceptor(EObject ctx, EObject semanticRoot, INode previousNode,
			ISyntacticSequenceAcceptor constructor, ISerializationDiagnostic.Acceptor errorAcceptor) {
		ISynAbsorberState startState = ctx instanceof ParserRule ? pdaProvider.getPDA((ParserRule) ctx) : pdaProvider
				.getPDA((Action) ctx);
		return new SemAcceptor(ctx, startState, previousNode, constructor, errorAcceptor);
	}

	protected ISynFollowerOwner transition(ISynFollowerOwner fromState, INode fromNode, AbstractElement toEle,
			INode toNode, RCStack stack, ISyntacticSequenceAcceptor delegate,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (fromState instanceof ISynAbsorberState)
			return fromState;
		if (fromState instanceof ISynNavigable) {
			ISynNavigable fromEmitter = (ISynNavigable) fromState;
			if (!fromEmitter.hasEmitters())
				return fromEmitter.getTarget();
			List<ISynState> pathAndElement = fromEmitter.getShortestPathTo(toEle, stack, true);
			if (pathAndElement == null) {
				if (errorAcceptor != null)
					errorAcceptor.accept(diagnosticProvider
							.createUnexpectedEmitterDiagnostic(fromEmitter, toEle, stack));
				return null;
			}
			List<ISynState> path = pathAndElement.subList(0, pathAndElement.size() - 1);
			accept(fromNode, path, stack, delegate, errorAcceptor);
			return pathAndElement.get(pathAndElement.size() - 1);
		}
		return null;
	}

	protected abstract void transition(ISynTransition transition, INode fromNode, INode toNode, RCStack stack,
			IUnassignedTokenSequenceAcceptor tokenAcceptor, ISerializationDiagnostic.Acceptor errorAcceptor);

	protected void transition(ISynFollowerOwner fromState, INode fromNode, INode toNode, RCStack stack,
			IUnassignedTokenSequenceAcceptor tokenAcceptor, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (fromState instanceof ISynTransition)
			transition((ISynTransition) fromState, fromNode, toNode, stack, tokenAcceptor, errorAcceptor);
	}

	protected ISynNavigable transitionBegin(ISynFollowerOwner fromState, INode fromNode, AbstractElement toEle,
			INode toNode, RCStack stack, IUnassignedTokenSequenceAcceptor tokenAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (fromState == null)
			return null;
		if (fromState instanceof ISynAbsorberState) {
			ISynAbsorberState fromAbsorber = (ISynAbsorberState) fromState;
			ISynTransition transition = fromAbsorber.getOutTransitionsByElement().get(toEle);
			if (transition == null) {
				if (errorAcceptor != null)
					errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(fromAbsorber,
							toEle, true));
				return null;
			}
			return transition;
		}
		return null;
	}

	protected ISynAbsorberState transitionFinish(ISynFollowerOwner fromState, INode fromNode, INode toNode,
			RCStack stack, ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		if (fromState instanceof ISynAbsorberState)
			return (ISynAbsorberState) fromState;
		if (fromState instanceof ISynNavigable) {
			ISynNavigable fromEmitter = (ISynNavigable) fromState;
			RCStack back = stack.clone();
			if (fromEmitter.hasEmitters())
				accept(fromNode, fromEmitter.getShortestPathToAbsorber(stack), stack, delegate, errorAcceptor);
			return fromEmitter.getTarget();
		}
		return null;
	}

}
