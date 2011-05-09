/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.serializer.ISyntacticSequencer;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynFollowerOwner;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.IUnassignedTokenSequenceAcceptor;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ISyntacticSequencerDiagnosticProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencer implements ISyntacticSequencer, ISemanticSequenceAcceptor,
		IUnassignedTokenSequenceAcceptor {

	protected class SyntacticalContext {

		protected EObject context;

		protected INode lastNode;

		protected ISynFollowerOwner lastState;

		protected EObject semanticObject;

		protected RuleCallStack stack;

		public SyntacticalContext(EObject context, EObject semanticObject, ISynAbsorberState previousState,
				INode previousNode) {
			this.context = context;
			this.semanticObject = semanticObject;
			this.lastState = previousState;
			this.lastNode = previousNode;
			this.stack = new RuleCallStack();
		}
	}

	protected Stack<SyntacticalContext> contexts = new Stack<SyntacticalContext>();

	protected ISyntacticSequenceAcceptor delegate;

	@Inject
	protected ISyntacticSequencerDiagnosticProvider diagnosticProvider;

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	protected void accept(INode fromNode, List<ISynState> path, RuleCallStack stack) {
		if (path.isEmpty())
			return;
		EmitterNodeFinder nodes = new EmitterNodeFinder(fromNode);
		//		RCStack bak = stack.clone();
		for (ISynState emitter : path)
			accept(emitter, nodes.next(emitter.getGrammarElement()), stack);
	}

	protected void accept(ISynState emitter, INode node, RuleCallStack stack) {
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
				String value3 = getUnassignedRuleCallValue(rc3, node);
				delegate.acceptUnassignedDatatype(rc3, value3, (ICompositeNode) node);
				return;
			case UNASSIGNED_TERMINAL_RULE_CALL:
				RuleCall rc4 = (RuleCall) emitter.getGrammarElement();
				String value4 = getUnassignedRuleCallValue(rc4, node);
				delegate.acceptUnassignedTerminal(rc4, value4, (ILeafNode) node);
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

	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
			ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, datatypeRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, null, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, enumRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, null, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, terminalRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, datatypeRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, enumRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, keyword, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, keyword, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, terminalRC, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, null, i.stack);
		i.lastNode = node;
		delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	public void acceptUnassignedAction(Action action) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transition(i.lastState, i.lastNode, action, null, i.stack);
		delegate.acceptUnassignedAction(action);
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transition(i.lastState, i.lastNode, datatypeRC, node, i.stack);
		i.lastNode = node;
		delegate.acceptUnassignedDatatype(datatypeRC, value, node);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transition(i.lastState, i.lastNode, enumRC, node, i.stack);
		i.lastNode = node;
		delegate.acceptUnassignedEnum(enumRC, value, node);
	}

	public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transition(i.lastState, i.lastNode, keyword, node, i.stack);
		i.lastNode = node;
		delegate.acceptUnassignedKeyword(keyword, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transition(i.lastState, i.lastNode, terminalRC, node, i.stack);
		i.lastNode = node;
		delegate.acceptUnassignedTerminal(terminalRC, value, node);
	}

	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, action, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = getLastLeaf(node);
		boolean shouldEnter = delegate.enterAssignedAction(action, semanticChild, node);
		if (shouldEnter) {
			ISynAbsorberState pda = pdaProvider.getPDA(action, semanticChild.eClass());
			SyntacticalContext j = new SyntacticalContext(action, semanticChild, pda, node);
			contexts.push(j);
		}
		return shouldEnter;
	}

	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, i.lastNode, rc, node, i.stack);
		transition(i.lastState, i.lastNode, node, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, node, i.stack);
		i.lastNode = getLastLeaf(node);
		boolean shouldEnter = delegate.enterAssignedParserRuleCall(rc, semanticChild, node);
		if (shouldEnter) {
			ISynAbsorberState pda = pdaProvider.getPDA(rc.getRule(), semanticChild.eClass());
			SyntacticalContext j = new SyntacticalContext(rc.getRule(), semanticChild, pda, node);
			contexts.push(j);
		}
		return shouldEnter;
	}

	public void finish() {
		SyntacticalContext i = contexts.peek();
		i.lastState = transitionBegin(i.context, i.semanticObject, i.lastState, null, null, null, i.stack);
		transition(i.lastState, i.lastNode, i.lastNode, i.stack);
		i.lastState = transitionFinish(i.lastState, i.lastNode, null, i.stack);
		delegate.finish();
	}

	protected INode getLastLeaf(INode node) {
		while (node instanceof ICompositeNode)
			node = ((ICompositeNode) node).getLastChild();
		return node;
	}

	protected abstract String getUnassignedRuleCallValue(RuleCall ruleCall, INode node);

	public void init(EObject context, EObject semanticObject, ISyntacticSequenceAcceptor sequenceAcceptor,
			Acceptor errorAcceptor) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		SyntacticalContext acceptor = new SyntacticalContext(context, semanticObject, pdaProvider.getPDA(context,
				semanticObject.eClass()), node);
		contexts.push(acceptor);
		delegate = sequenceAcceptor;
	}

	public void leaveAssignedAction(Action action, EObject semanticChild) {
		contexts.pop();
	}

	//	public ISemanticSequenceAcceptor createAcceptor(EObject ctx, EObject semanticRoot, INode previousNode,
	//			ISyntacticSequenceAcceptor constructor, ISerializationDiagnostic.Acceptor errorAcceptor) {
	//		ISynAbsorberState startState = getStartState(ctx);
	//		return new SemAcceptor(ctx, startState, previousNode, constructor, errorAcceptor);
	//	}

	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		contexts.pop();
	}

	protected ISynFollowerOwner transition(ISynFollowerOwner fromState, INode fromNode, AbstractElement toEle,
			INode toNode, RuleCallStack stack) {
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
			accept(fromNode, path, stack);
			return pathAndElement.get(pathAndElement.size() - 1);
		}
		return null;
	}

	protected void transition(ISynFollowerOwner fromState, INode fromNode, INode toNode, RuleCallStack stack) {
		if (fromState instanceof ISynTransition)
			transition((ISynTransition) fromState, fromNode, toNode, stack);
	}

	protected abstract void transition(ISynTransition transition, INode fromNode, INode toNode, RuleCallStack stack);

	protected ISynNavigable transitionBegin(EObject context, EObject semanticObject, ISynFollowerOwner fromState,
			INode fromNode, AbstractElement toEle, INode toNode, RuleCallStack stack) {
		if (fromState == null)
			return null;
		if (fromState instanceof ISynAbsorberState) {
			ISynAbsorberState fromAbsorber = (ISynAbsorberState) fromState;
			ISynTransition transition = fromAbsorber.getOutTransitionsByElement().get(toEle);
			if (transition == null) {
				if (errorAcceptor != null)
					errorAcceptor.accept(diagnosticProvider.createInvalidFollowingAbsorberDiagnostic(context,
							semanticObject, fromAbsorber, toEle));
				return null;
			}
			return transition;
		}
		return null;
	}

	protected ISynAbsorberState transitionFinish(ISynFollowerOwner fromState, INode fromNode, INode toNode,
			RuleCallStack stack) {
		if (fromState instanceof ISynAbsorberState)
			return (ISynAbsorberState) fromState;
		if (fromState instanceof ISynNavigable) {
			ISynNavigable fromEmitter = (ISynNavigable) fromState;
			//			RCStack back = stack.clone();
			if (fromEmitter.hasEmitters())
				accept(fromNode, fromEmitter.getShortestPathToAbsorber(stack), stack);
			return fromEmitter.getTarget();
		}
		return null;
	}

}
