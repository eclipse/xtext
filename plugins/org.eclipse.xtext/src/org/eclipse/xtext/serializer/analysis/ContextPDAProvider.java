/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAState;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ContextPDAProvider implements IContextPDAProvider {

	protected static class CallStack {
		private final RuleCall call;
		private final CallStack parent;
		private final Set<ISerState> visited = Sets.newHashSet();

		public CallStack(CallStack parent, RuleCall call) {
			super();
			this.parent = parent;
			this.call = call;
		}

		public boolean isLoop() {
			CallStack current = parent;
			int counter = 0;
			while (current != null) {
				if (current.call == call)
					counter++;
				if (counter >= 2)
					return true;
				current = current.parent;
			}
			return false;
		}
	}

	private final Map<Grammar, Map<EObject, Pda<ISerState, RuleCall>>> cache = Maps.newHashMap();

	@Inject
	private SerializerPDAElementFactory factory;

	@Inject
	private IGrammarPDAProvider grammarPdaProvider;

	@Inject
	private NfaUtil nfaUtil;

	@Inject
	protected PdaUtil pdaUtil;

	protected void collectExtracted(ISerState orig, Collection<? extends ISerState> precedents, SerializerPDAState copy,
			Map<Pair<AbstractElement, SerStateType>, SerializerPDAState> oldToNew, final CallStack inTop,
			SerializerPDAState start) {
		for (ISerState pre : precedents) {
			CallStack top = inTop;
			AbstractElement element = pre.getGrammarElement();
			switch (pre.getType()) {
				case START:
					if (top.call == null)
						connect(start, copy);
					continue;
				case POP:
					top = new CallStack(top, (RuleCall) element);
					if (top.isLoop())
						continue;
					break;
				case PUSH:
					if (top.call == null) {
						connect(start, copy);
						continue;
					} else if (top.call == element) {
						top = top.parent;
					} else {
						continue;
					}
				default:
					break;
			}
			Pair<AbstractElement, SerStateType> key = Tuples.create(element, pre.getType());
			SerializerPDAState pre2 = oldToNew.get(key);
			if (pre2 == null) {
				pre2 = new SerializerPDAState(element, pre.getType());
				oldToNew.put(key, pre2);
			}
			if (GrammarUtil.isAssignedAction(pre.getGrammarElement()) /* && pre.getType() != STOP */) {
				Set<ISerState> entries = collectPushForAction(pre);
				collectExtracted(pre, entries, pre2, oldToNew, top, start);
			} else {
				if (top.visited.add(pre))
					collectExtracted(pre, pre.getPrecedents(), pre2, oldToNew, top, start);
			}
			connect(pre2, copy);
		}
	}

	protected Set<ISerState> collectPushForAction(ISerState action) {
		ParserRule rule = GrammarUtil.containingParserRule(action.getGrammarElement());
		LinkedHashSet<ISerState> result = Sets.<ISerState> newLinkedHashSet();
		collectPushForAction(action, rule, result, Sets.<ISerState> newHashSet());
		return result;
	}

	protected void collectPushForAction(ISerState state, ParserRule rule, Set<ISerState> result,
			Set<ISerState> visited) {
		if (!visited.add(state))
			return;
		switch (state.getType()) {
			case START:
				result.add(state);
				return;
			case PUSH:
				AbstractElement element = state.getGrammarElement();
				if (element instanceof RuleCall && ((RuleCall) element).getRule() == rule) {
					result.add(state);
					return;
				}
			default:
				break;
		}
		List<? extends ISerState> precedents = state.getPrecedents();
		for (ISerState pre : precedents)
			collectPushForAction(pre, rule, result, visited);
	}

	protected void connect(SerializerPDAState precedent, SerializerPDAState follower) {
		if (precedent == null || follower == null)
			return;
		if (follower.getPrecedents().contains(precedent))
			return;
		follower.getPrecedents().add(precedent);
		precedent.getFollowers().add(follower);
	}

	protected Pda<ISerState, RuleCall> extract(ISerState last) {
		SerializerPDA result = factory.create(null, null);
		HashMap<Pair<AbstractElement, SerStateType>, SerializerPDAState> oldToNew = Maps.newHashMap();
		CallStack callStack = new CallStack(null, null);
		collectExtracted(last, last.getPrecedents(), result.getStop(), oldToNew, callStack, result.getStart());
		return result;
	}

	@Override
	public Set<EObject> getAllContexts(Grammar grammar) {
		Map<EObject, Pda<ISerState, RuleCall>> map = getOrCreate(grammar);
		Set<EObject> result = map.keySet();
		return result;
	}

	protected EObject getContext(AbstractElement ele) {
		if (ele instanceof RuleCall) {
			if (GrammarUtil.isAssignedEObjectRuleCall(ele))
				return ((RuleCall) ele).getRule();
		} else if (GrammarUtil.isAssignedAction(ele))
			return ele;
		return null;
	}

	@Override
	public Pda<ISerState, RuleCall> getContextPDA(Grammar grammar, EObject context) {
		Map<EObject, Pda<ISerState, RuleCall>> map = getOrCreate(grammar);
		Pda<ISerState, RuleCall> pda = map.get(context);
		if (pda == null)
			throw new IllegalStateException("Invlid context for serialization: " + context);
		return pda;
	}

	protected Map<EObject, Pda<ISerState, RuleCall>> getOrCreate(Grammar grammar) {
		Map<EObject, Pda<ISerState, RuleCall>> result = cache.get(grammar);
		if (result != null)
			return result;
		result = Maps.newLinkedHashMap();
		Set<ParserRule> allParserRules = grammarPdaProvider.getAllRules(grammar);
		Multimap<Action, Pda<ISerState, RuleCall>> actionPdas = HashMultimap.create();
		for (ParserRule rule : allParserRules) {
			Pda<ISerState, RuleCall> pda = grammarPdaProvider.getGrammarPDA(grammar, rule);
			List<ISerState> actions = Lists.newArrayList();
			for (ISerState state : nfaUtil.collect(pda)) {
				if (GrammarUtil.isAssignedAction(state.getGrammarElement())) {
					actions.add(state);
				}
			}
			if (actions.isEmpty()) {
				result.put(rule, pda);
			} else {
				Pda<ISerState, RuleCall> rulePda = extract(pda.getStop());
				result.put(rule, rulePda);
				for (ISerState action : actions) {
					Pda<ISerState, RuleCall> actionPda = extract(action);
					actionPdas.put((Action) action.getGrammarElement(), actionPda);
				}
			}
		}
		for (Map.Entry<Action, Collection<Pda<ISerState, RuleCall>>> action : actionPdas.asMap().entrySet()) {
			Pda<ISerState, RuleCall> merged = merge(action.getValue());
			result.put(action.getKey(), merged);
		}
		cache.put(grammar, result);
		return result;
	}

	protected Pda<ISerState, RuleCall> merge(Collection<Pda<ISerState, RuleCall>> pdas) {
		if (pdas.isEmpty())
			throw new IllegalStateException();
		if (pdas.size() == 1)
			return pdas.iterator().next();
		SerializerPDA merged = factory.create(null, null);
		Map<ISerState, SerializerPDAState> oldToNew = Maps.newHashMap();
		for (Pda<ISerState, RuleCall> pda : pdas) {
			oldToNew.put(pda.getStop(), merged.getStop());
			merge(pda.getStart(), merged.getStart(), oldToNew, new IdentityHashMap<ISerState, Boolean>());
		}
		return merged;
	}

	protected void merge(ISerState orig, SerializerPDAState copy, Map<ISerState, SerializerPDAState> oldToNew,
			IdentityHashMap<ISerState, Boolean> visited) {
		for (ISerState fol : orig.getFollowers()) {
			SerializerPDAState folCopy = oldToNew.get(fol);
			if (folCopy == null) {
				folCopy = new SerializerPDAState(fol.getGrammarElement(), fol.getType());
				oldToNew.put(fol, folCopy);
			}
			connect(copy, folCopy);
			if (visited.put(fol, Boolean.TRUE) == null)
				merge(fol, folCopy, oldToNew, visited);
		}
	}

}
