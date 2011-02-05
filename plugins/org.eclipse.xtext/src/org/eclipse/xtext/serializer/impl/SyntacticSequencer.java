/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ISyntacticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAAbsorberState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDAEmitterState;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.IPDATransition;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider.PDAEmitterStateType;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencer extends AbstractSyntacticSequencer {

	protected final static int UNREACHABLE = Integer.MAX_VALUE;

	protected void accept(IPDAEmitterState emitter, Stack<RuleCall> stack, ISyntacticSequenceAcceptor delegate,
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
				delegate.acceptUnassignedKeyword(keyword);
				return;
			case UNASSIGNED_DATATYPE_RULE_CALL:
				RuleCall rc3 = (RuleCall) emitter.getGrammarElement();
				delegate.acceptUnassignedDatatype(rc3, "foo"); // TODO: allow to customize this value
				return;
			case UNASSIGNED_TERMINAL_RULE_CALL:
				RuleCall rc4 = (RuleCall) emitter.getGrammarElement();
				delegate.acceptUnassignedDatatype(rc4, "foo"); // TODO: allow to customize this value
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
		}
		throw new RuntimeException("invalid state for emitting: " + emitter + " (" + emitter.getType() + ")");
	}

	protected IPDAAbsorberState accept(List<IPDAEmitterState> path, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		for (IPDAEmitterState emitter : path) {
			if (emitter instanceof IPDAAbsorberState)
				return (IPDAAbsorberState) emitter;
			else
				accept(emitter, stack, delegate, errorAcceptor);
		}
		throw new RuntimeException();
	}

	protected int distanceToAbsorber(IPDAEmitterState state, Stack<RuleCall> stack, Set<IPDAEmitterState> visited) {
		if (state instanceof IPDAAbsorberState)
			return 0;
		if (!visited.add(state))
			return UNREACHABLE;
		if (state.getType() == PDAEmitterStateType.UNASSIGNED_PARSER_RULE_EXIT) {
			if (stack.isEmpty() || stack.pop() != state.getGrammarElement())
				return UNREACHABLE;
		}
		if (state.getType() == PDAEmitterStateType.UNASSIGNED_PARSER_RULE_ENTER) {
			stack.push((RuleCall) state.getGrammarElement());
		}
		int dist = UNREACHABLE;
		for (IPDAEmitterState follower : state.getFollowers())
			dist = Math.min(dist, distanceToAbsorber(follower, newStack(stack), visited));
		return dist == UNREACHABLE ? UNREACHABLE : dist + 1;
	}

	@Override
	protected IPDAAbsorberState emitForElement(IPDATransition routes, Stack<RuleCall> stack,
			ISyntacticSequenceAcceptor delegate, ISerializationDiagnostic.Acceptor errorAcceptor) {
		List<IPDAEmitterState> path = findShortestPath(routes.getDirectEmittersAndAbsorber(), newStack(stack));
		return accept(path, stack, delegate, errorAcceptor);
	}

	protected Stack<RuleCall> newStack(Stack<RuleCall> stack) {
		Stack<RuleCall> result = new Stack<RuleCall>();
		result.addAll(stack);
		return result;
	}

	protected List<IPDAEmitterState> findShortestPath(List<IPDAEmitterState> routes, Stack<RuleCall> stack) {
		List<IPDAEmitterState> result = Lists.newArrayList();
		Set<IPDAEmitterState> visited = Sets.newHashSet();
		IPDAEmitterState next;
		do {
			next = null;
			if (routes.size() == 1)
				next = routes.get(0);
			else {
				int minDist = UNREACHABLE;
				for (IPDAEmitterState follower : routes) {
					int dist = distanceToAbsorber(follower, newStack(stack), Sets.newHashSet(visited));
					if (dist < minDist) {
						next = follower;
						minDist = dist;
					}
				}
			}
			if (next == null)
				throw new RuntimeException();
			if (next.getType() == PDAEmitterStateType.UNASSIGNED_PARSER_RULE_EXIT)
				stack.pop();
			if (next.getType() == PDAEmitterStateType.UNASSIGNED_PARSER_RULE_ENTER)
				stack.push((RuleCall) next.getGrammarElement());
			routes = next.getFollowers();
			visited.add(next);
			result.add(next);
		} while (!(next instanceof IPDAAbsorberState));
		return result;
	}

}
