/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
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
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.CompoundAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSyntacticSequencer implements ISyntacticSequencer, ISemanticSequenceAcceptor {

	protected static class SyntacticalContext {

		protected EObject context;

		protected INode lastNode;
		
		protected INode rootNode;

		protected ISynFollowerOwner lastState;

		protected EObject semanticObject;

		protected RuleCallStack stack;

		public SyntacticalContext(EObject context, EObject semanticObject, ISynAbsorberState previousState,
				INode previousNode) {
			this.context = context;
			this.semanticObject = semanticObject;
			this.lastState = previousState;
			this.lastNode = previousNode;
			this.rootNode = previousNode;
			this.stack = new RuleCallStack();
		}

		public INode getLastNode() {
			return lastNode;
		}

		public RuleCallStack getStack() {
			return stack;
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
		if (path == null || path.isEmpty())
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
						errorAcceptor.accept(diagnosticProvider.createUnexpectedStackStateDiagnostic(
								contexts.get(contexts.size() - 1).semanticObject, stack, lastRc, emitter));
				}
				return;
			case UNASSIGEND_ACTION_CALL:
				delegate.acceptUnassignedAction((Action) emitter.getGrammarElement());
				return;
			case UNASSIGEND_KEYWORD:
				Keyword keyword = (Keyword) emitter.getGrammarElement();
				String token = node != null ? node.getText() : keyword.getValue();
				delegate.acceptUnassignedKeyword(keyword, token, (ILeafNode) node);
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

	@Override
	public void acceptAssignedCrossRefDatatype(RuleCall datatypeRC, String token, EObject value, int index,
			ICompositeNode node) {
		navigateToAbsorber(datatypeRC, node);
		delegate.acceptAssignedCrossRefDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefEnum(RuleCall enumRC, String token, EObject value, int index, ICompositeNode node) {
		navigateToAbsorber(enumRC, node);
		delegate.acceptAssignedCrossRefEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefKeyword(Keyword kw, String token, EObject value, int index, ILeafNode node) {
		navigateToAbsorber(kw, node);
		delegate.acceptAssignedCrossRefKeyword(kw, token, value, index, node);
	}

	@Override
	public void acceptAssignedCrossRefTerminal(RuleCall terminalRC, String token, EObject value, int index,
			ILeafNode node) {
		navigateToAbsorber(terminalRC, node);
		delegate.acceptAssignedCrossRefTerminal(terminalRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedDatatype(RuleCall datatypeRC, String token, Object value, int index, ICompositeNode node) {
		navigateToAbsorber(datatypeRC, node);
		if (token == null)
			token = getUnassignedRuleCallToken(datatypeRC, node);
		delegate.acceptAssignedDatatype(datatypeRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedEnum(RuleCall enumRC, String token, Object value, int index, ICompositeNode node) {
		navigateToAbsorber(enumRC, node);
		delegate.acceptAssignedEnum(enumRC, token, value, index, node);
	}

	@Override
	public void acceptAssignedKeyword(Keyword keyword, String token, Object value, int index, ILeafNode node) {
		navigateToAbsorber(keyword, node);
		delegate.acceptAssignedKeyword(keyword, token, value, index, node);
	}

	@Override
	public void acceptAssignedTerminal(RuleCall terminalRC, String token, Object value, int index, ILeafNode node) {
		navigateToAbsorber(terminalRC, node);
		if (token == null)
			token = getUnassignedRuleCallToken(terminalRC, node);
		delegate.acceptAssignedTerminal(terminalRC, token, value, index, node);
	}

	protected void acceptNode(INode node) {
		Object ge = node.getGrammarElement();
		if (ge instanceof Keyword)
			acceptUnassignedKeyword((Keyword) ge, node.getText(), (ILeafNode) node);
		else if (ge instanceof RuleCall) {
			RuleCall rc = (RuleCall) ge;
			if (rc.getRule() instanceof TerminalRule)
				acceptUnassignedTerminal(rc, node.getText(), (ILeafNode) node);
			else if (rc.getRule() instanceof ParserRule) {
				StringBuilder text = new StringBuilder();
				for (ILeafNode leaf : node.getLeafNodes())
					if (text.length() > 0 || !leaf.isHidden())
						text.append(leaf.getText());
				acceptUnassignedDatatype(rc, text.toString(), (ICompositeNode) node);
			} else if (rc.getRule() instanceof EnumRule)
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
			List<ISynState> path = fromState.getShortestPathTo((AbstractElement) next.getGrammarElement(), stack);
			if (path != null) {
				if (path.get(path.size() - 1) instanceof ISynEmitterState)
					fromState = (ISynEmitterState) path.get(path.size() - 1);
				else
					return;
				acceptNode(next);
			}
		}
	}

	protected void acceptNodes(ISynNavigable fromState, List<INode> nodes) {
		if (nodes == null)
			return;
		RuleCallStack stack = contexts.peek().stack.clone();
		for (INode next : nodes) {
			List<ISynState> path = fromState.getShortestPathTo((AbstractElement) next.getGrammarElement(), stack);
			if (path != null) {
				if (path.get(path.size() - 1) instanceof ISynEmitterState)
					fromState = (ISynEmitterState) path.get(path.size() - 1);
				else
					return;
				acceptNode(next);
			}
		}
		return;
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

	public void acceptUnassignedKeyword(Keyword keyword, String token, ILeafNode node) {
		navigateToEmitter(keyword, node);
		delegate.acceptUnassignedKeyword(keyword, token, node);
	}

	public void acceptUnassignedTerminal(RuleCall terminalRC, String value, ILeafNode node) {
		navigateToEmitter(terminalRC, node);
		delegate.acceptUnassignedTerminal(terminalRC, value, node);
	}

	protected void collectAbstractElements(AbstractElementAlias ele, Set<AbstractElement> elments) {
		if (ele instanceof TokenAlias)
			elments.add(((TokenAlias) ele).getToken());
		else if (ele instanceof CompoundAlias)
			for (AbstractElementAlias child : ((CompoundAlias) ele).getChildren())
				collectAbstractElements(child, elments);
	}

	protected List<INode> collectNodes(INode fromNode, INode toNode) {
		if (fromNode == null)
			return null;
		return Lists.newArrayList(new EmitterNodeIterator(fromNode, toNode, false, false));
	}

	protected abstract void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode,
			INode toNode);

	@Override
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

	@Override
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

	@Override
	public void finish() {
		navigateToAbsorber(null, contexts.peek().rootNode);
		delegate.finish();
	}

	protected INode getLastLeaf(INode node) {
		INode result = node;
		while (result instanceof ICompositeNode)
			result = ((ICompositeNode) result).getLastChild();
		return result != null ? result : node;
	}

	protected ISynNavigable getLastNavigableState() {
		ISynFollowerOwner state = contexts.peek().lastState;
		return state instanceof ISynNavigable ? (ISynNavigable) state : null;
	}

	protected List<INode> getNodesFor(List<INode> nodes, AbstractElementAlias ele) {
		if (nodes == null)
			return null;
		Set<AbstractElement> elments = Sets.newHashSet();
		collectAbstractElements(ele, elments);
		List<INode> result = Lists.newArrayList();
		for (INode n : nodes)
			if (elments.contains(n.getGrammarElement()))
				result.add(n);
		return result;
	}

	protected String getTokenText(INode node) {
		return tokenUtil.serializeNode(node);
	}

	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}

	protected String getUnassignedRuleCallToken(RuleCall ruleCall, INode node) {
		Assignment ass = GrammarUtil.containingAssignment(ruleCall);
		if (ass != null && !GrammarUtil.isBooleanAssignment(ass))
			throw new IllegalStateException("RuleCall is invalid; Can not determine token.");
		return getUnassignedRuleCallToken(contexts.peek().semanticObject, ruleCall, node);
	}

	@Override
	public void init(EObject context, EObject semanticObject, ISyntacticSequenceAcceptor sequenceAcceptor,
			Acceptor errorAcceptor) {
		INode node = NodeModelUtils.findActualNodeFor(semanticObject);
		SyntacticalContext acceptor = new SyntacticalContext(context, semanticObject, pdaProvider.getPDA(context,
				semanticObject.eClass()), node);
		contexts.push(acceptor);
		delegate = sequenceAcceptor;
		this.errorAcceptor = errorAcceptor;
	}

	@Override
	public void leaveAssignedAction(Action action, EObject semanticChild) {
		contexts.pop();
		delegate.leaveAssignedAction(action, semanticChild);
	}

	@Override
	public void leaveAssignedParserRuleCall(RuleCall rc, EObject semanticChild) {
		contexts.pop();
		delegate.leaveAssignedParserRuleCall(rc, semanticChild);
	}

	protected void navigateToAbsorber(AbstractElement ele, INode node) {
		SyntacticalContext ctx = contexts.peek();
		ctx.lastState = findTransition(ctx.context, ctx.semanticObject, ctx.lastState, ctx.getLastNode(), ele, node,
				ctx.stack);
		emitUnassignedTokens(ctx.semanticObject, (ISynTransition) ctx.lastState, ctx.getLastNode(), node);
		ctx.lastState = navigateToAbsorber(ctx.lastState, ctx.lastNode, null, ctx.stack);
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
				accept(fromNode, fromEmitter.getShortestStackpruningPathToAbsorber(stack), stack);
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
			List<ISynState> pathAndElement = fromEmitter.getShortestPathTo(toEle, stack);
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
