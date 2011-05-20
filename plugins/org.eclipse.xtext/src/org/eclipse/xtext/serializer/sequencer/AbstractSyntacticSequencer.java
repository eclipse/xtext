/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parsetree.reconstr.impl.TokenUtil;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynAbsorberState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynEmitterState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynFollowerOwner;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynState;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.diagnostic.ISyntacticSequencerDiagnosticProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencer implements ISyntacticSequencer, ISemanticSequenceAcceptor {

	protected static class SyntacticalContext {

		protected EObject context;

		private INode lastNode;

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

		protected INode getLastNode() {
			return lastNode;
		}

		protected void setLastNode(INode lastNode) {
			this.lastNode = lastNode;
		}
	}

	protected Stack<SyntacticalContext> contexts = new Stack<SyntacticalContext>();

	protected ISyntacticSequenceAcceptor delegate;

	@Inject
	protected ISyntacticSequencerDiagnosticProvider diagnosticProvider;

	protected ISerializationDiagnostic.Acceptor errorAcceptor;

	@Inject
	protected ISyntacticSequencerPDAProvider pdaProvider;

	@Inject
	protected TokenUtil tokenUtil;

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
				String value3 = getUnassignedRuleCallToken(rc3, node);
				delegate.acceptUnassignedDatatype(rc3, value3, (ICompositeNode) node);
				return;
			case UNASSIGNED_TERMINAL_RULE_CALL:
				RuleCall rc4 = (RuleCall) emitter.getGrammarElement();
				String value4 = getUnassignedRuleCallToken(rc4, node);
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
		navigateToAbsorber(datatypeRC, node);
		delegate.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		navigateToAbsorber(enumRC, node);
		delegate.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		navigateToAbsorber(terminalRC, node);
		delegate.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		navigateToAbsorber(datatypeRC, node);
		delegate.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		navigateToAbsorber(enumRC, node);
		delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, Boolean value, int index, ILeafNode node) {
		navigateToAbsorber(keyword, node);
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedKeyword(Keyword keyword, String token, String value, int index, ILeafNode node) {
		navigateToAbsorber(keyword, node);
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		navigateToAbsorber(terminalRC, node);
		delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	protected void acceptNode(INode node) {
		Object ge = node.getGrammarElement();
		if (ge instanceof Keyword)
			acceptUnassignedKeyword((Keyword) ge, (ILeafNode) node);
		else if (ge instanceof RuleCall) {
			RuleCall rc = (RuleCall) ge;
			if (rc.getRule() instanceof TerminalRule)
				acceptUnassignedTerminal(rc, node.getText(), (ILeafNode) node);
			else if (rc.getRule() instanceof ParserRule)
				acceptUnassignedDatatype(rc, node.getText(), (ICompositeNode) node);
			else if (rc.getRule() instanceof EnumRule)
				acceptUnassignedEnum(rc, node.getText(), (ICompositeNode) node);
		} else if (ge instanceof Action)
			acceptUnassignedAction((Action) ge);
		else
			throw new RuntimeException("Unexpected grammar element: " + node.getGrammarElement());
	}

	protected void acceptNodes(ISynNavigable fromState, INode fromNode, INode toNode) {
		RuleCallStack stack = contexts.peek().stack.clone();
		EmitterNodeIterator ni = new EmitterNodeIterator(fromNode, toNode, false, false);
		while (ni.hasNext()) {
			INode next = ni.next();
			List<ISynState> path = fromState.getShortestPathTo((AbstractElement) next.getGrammarElement(), stack, true);
			if (path != null) {
				if (path.get(path.size() - 1) instanceof ISynEmitterState)
					fromState = (ISynEmitterState) path.get(path.size() - 1);
				else
					return;
				acceptNode(next);
			}
		}
	}

	public void acceptUnassignedAction(Action action) {
		SyntacticalContext i = contexts.peek();
		i.lastState = navigateToEmitter(i.lastState, i.getLastNode(), action, null, i.stack);
		delegate.acceptUnassignedAction(action);
	}

	public void acceptUnassignedDatatype(RuleCall datatypeRC, String value, ICompositeNode node) {
		navigateToEmitter(datatypeRC, node);
		delegate.acceptUnassignedDatatype(datatypeRC, value, node);
	}

	public void acceptUnassignedEnum(RuleCall enumRC, String value, ICompositeNode node) {
		navigateToEmitter(enumRC, node);
		delegate.acceptUnassignedEnum(enumRC, value, node);
	}

	public void acceptUnassignedKeyword(Keyword keyword, ILeafNode node) {
		navigateToEmitter(keyword, node);
		delegate.acceptUnassignedKeyword(keyword, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
		navigateToEmitter(terminalRC, node);
		delegate.acceptUnassignedTerminal(terminalRC, value, node);
	}

	protected abstract void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode,
			INode toNode);

	public boolean enterAssignedAction(Action action, EObject semanticChild, ICompositeNode node) {
		navigateToAbsorber(action, node);
		boolean shouldEnter = delegate.enterAssignedAction(action, semanticChild, node);
		if (shouldEnter) {
			ISynAbsorberState pda = pdaProvider.getPDA(action, semanticChild.eClass());
			SyntacticalContext j = new SyntacticalContext(action, semanticChild, pda, node);
			contexts.push(j);
		}
		return shouldEnter;
	}

	public boolean enterAssignedParserRuleCall(RuleCall rc, EObject semanticChild, ICompositeNode node) {
		navigateToAbsorber(rc, node);
		boolean shouldEnter = delegate.enterAssignedParserRuleCall(rc, semanticChild, node);
		if (shouldEnter) {
			ISynAbsorberState pda = pdaProvider.getPDA(rc.getRule(), semanticChild.eClass());
			SyntacticalContext j = new SyntacticalContext(rc.getRule(), semanticChild, pda, node);
			contexts.push(j);
		}
		return shouldEnter;
	}

	protected ISynTransition findTransition(EObject context, EObject semanticObject, ISynFollowerOwner fromState,
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

	public void finish() {
		navigateToAbsorber(null, null);
		delegate.finish();
	}

	protected INode getLastLeaf(INode node) {
		INode result = node;
		while (result instanceof ICompositeNode)
			result = ((ICompositeNode) result).getLastChild();
		return result != null ? result : node;
	}

	protected String getTokenText(INode node) {
		return tokenUtil.serializeNode(node);
	}

	protected abstract String getUnassignedRuleCallToken(RuleCall ruleCall, INode node);

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

	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		contexts.pop();
	}

	protected void navigateToAbsorber(AbstractElement ele, INode node) {
		SyntacticalContext ctx = contexts.peek();
		ctx.lastState = findTransition(ctx.context, ctx.semanticObject, ctx.lastState, ctx.getLastNode(), ele, node,
				ctx.stack);
		emitUnassignedTokens(ctx.semanticObject, (ISynTransition) ctx.lastState, ctx.getLastNode(), node);
		ctx.lastState = navigateToAbsorber(ctx.lastState, ctx.getLastNode(), null, ctx.stack);
		ctx.setLastNode(getLastLeaf(node));
	}

	protected ISynAbsorberState navigateToAbsorber(ISynFollowerOwner fromState, INode fromNode, INode toNode,
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

	protected void navigateToEmitter(AbstractElement ele, INode node) {
		SyntacticalContext ctx = contexts.peek();
		ctx.lastState = navigateToEmitter(ctx.lastState, ctx.getLastNode(), ele, node, ctx.stack);
		ctx.setLastNode(node);
	}

	protected ISynFollowerOwner navigateToEmitter(ISynFollowerOwner fromState, INode fromNode, AbstractElement toEle,
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

}
