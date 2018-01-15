/*******************************************************************************
 * Copyright (c) 2011, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.ISerState.SerStateType;
import org.eclipse.xtext.serializer.analysis.SerializationContext.ActionContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap.Builder;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDACloneFactory;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAElementFactory;
import org.eclipse.xtext.serializer.analysis.SerializerPDA.SerializerPDAState;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.Pda;
import org.eclipse.xtext.util.formallang.PdaUtil;

import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedHashMultimap;
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

	private static Logger LOG = Logger.getLogger(ContextPDAProvider.class);

	@Inject
	protected SerializerPDAElementFactory factory;

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
			if (GrammarUtil.isAssignedAction(
					pre.getGrammarElement()) /* && pre.getType() != STOP */) {
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
		LinkedHashSet<ISerState> result = Sets.<ISerState>newLinkedHashSet();
		collectPushForAction(action, rule, result, Sets.<ISerState>newHashSet());
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

	protected SerializerPDA extract(ISerState last) {
		SerializerPDA result = factory.create(null, null);
		HashMap<Pair<AbstractElement, SerStateType>, SerializerPDAState> oldToNew = Maps.newHashMap();
		CallStack callStack = new CallStack(null, null);
		collectExtracted(last, last.getPrecedents(), result.getStop(), oldToNew, callStack, result.getStart());
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

	protected ParserRule getFilterableRule(ISerState state) {
		if (state.getType() == SerStateType.PUSH) {
			RuleCall rc = (RuleCall) state.getGrammarElement();
			AbstractRule rule = rc.getRule();
			if (rule instanceof ParserRule) {
				ParserRule pr = (ParserRule) rule;
				if (pr.isFragment()) {
					return null;
				}
				if (pr.isDefinesHiddenTokens()) {
					return null;
				}
				return pr;
			}
		}
		return null;
	}

	protected Pda<ISerState, RuleCall> filterUnneededUnassignedRuleCalls(Pda<ISerState, RuleCall> pda,
			Map<ParserRule, Integer> indexedRules) {
		Set<ParserRule> exclude = findRuleCallsToExclude(pda, indexedRules);
		if (exclude.isEmpty())
			return pda;
		SerializerPDA filtered = pdaUtil.filter(pda, new Predicate<ISerState>() {
			@Override
			public boolean apply(ISerState input) {
				SerStateType type = input.getType();
				if (type == SerStateType.PUSH || type == SerStateType.POP) {
					AbstractRule rule = ((RuleCall) input.getGrammarElement()).getRule();
					return !exclude.contains(rule);
				}
				return true;
			}
		}, new SerializerPDACloneFactory());
		return filtered;
	}

	protected Set<ParserRule> findRuleCallsToExclude(Pda<ISerState, RuleCall> pda,
			Map<ParserRule, Integer> indexedRules) {
		Map<ParserRule, Integer> result = Maps.newLinkedHashMap();
		for (ISerState s : nfaUtil.collect(pda)) {
			ParserRule pr = getFilterableRule(s);
			if (pr != null) {
				Integer integer = result.get(pr);
				result.put(pr, integer == null ? 1 : integer + 1);
			}
		}
		Iterator<Integer> it = result.values().iterator();
		while (it.hasNext()) {
			if (it.next() > 1) {
				it.remove();
			}
		}
		nfaUtil.findCycles(pda, new IAcceptor<List<ISerState>>() {
			@Override
			public void accept(List<ISerState> states) {
				ParserRule candidate = null;
				Integer candiateIndex = Integer.MAX_VALUE;
				for (ISerState state : states) {
					ParserRule rule = getFilterableRule(state);
					if (rule != null) {
						Integer index = indexedRules.get(rule);
						if (candiateIndex > index) {
							candidate = rule;
							candiateIndex = index;
						}
					}
				}
				if (candidate != null) {
					result.remove(candidate);
				}
			}
		});
		return result.keySet();
	}

	protected Map<ParserRule, Integer> indexRules(Grammar grammar) {
		List<ParserRule> rules = GrammarUtil.allParserRules(grammar);
		Map<ParserRule, Integer> map = Maps.newHashMap();
		for (int i = 0; i < rules.size(); i++) {
			map.put(rules.get(i), i);
		}
		return map;
	}

	@Override
	public SerializationContextMap<Pda<ISerState, RuleCall>> getContextPDAs(Grammar grammar) {
		Builder<Pda<ISerState, RuleCall>> result = SerializationContextMap.<Pda<ISerState, RuleCall>>builder();
		SerializationContextMap<Pda<ISerState, RuleCall>> grammarPDAs = grammarPdaProvider.getGrammarPDAs(grammar);
		Multimap<Action, SerializerPDA> actionPdas = ArrayListMultimap.create();
		Multimap<Action, ISerializationContext> actionContexts = LinkedHashMultimap.create();
		Map<ParserRule, Integer> indexedRules = indexRules(grammar);
		for (SerializationContextMap.Entry<Pda<ISerState, RuleCall>> e : grammarPDAs.values()) {
			List<ISerializationContext> contexts = e.getContexts();
			Pda<ISerState, RuleCall> pda = e.getValue();
			List<ISerState> actions = Lists.newArrayList();
			for (ISerState state : nfaUtil.collect(pda)) {
				if (GrammarUtil.isAssignedAction(state.getGrammarElement())) {
					actions.add(state);
				}
			}
			if (actions.isEmpty()) {
				Pda<ISerState, RuleCall> filtered = filterUnneededUnassignedRuleCalls(pda, indexedRules);
				result.put(contexts, filtered);
			} else {
				try {
					SerializerPDA rulePda = extract(pda.getStop());
					Pda<ISerState, RuleCall> filtered = filterUnneededUnassignedRuleCalls(rulePda, indexedRules);
					result.put(contexts, filtered);
					for (ISerState state : actions) {
						Action action = (Action) state.getGrammarElement();
						SerializerPDA actionPda = extract(state);
						actionPdas.put(action, actionPda);
						actionContexts.putAll(action, contexts);
					}
				} catch (Exception x) {
					LOG.error("Error extracting PDA for action in context '" + contexts + "': " + x.getMessage(), x);
				}
			}
		}
		for (Map.Entry<Action, Collection<SerializerPDA>> action : actionPdas.asMap().entrySet()) {
			SerializerPDA merged = merge(new ActionContext(null, action.getKey()), action.getValue());
			Set<Set<Parameter>> parameterPermutations = Sets.newLinkedHashSet();
			for (ISerializationContext container : actionContexts.get(action.getKey())) {
				parameterPermutations.add(container.getEnabledBooleanParameters());
			}
			// for (IContext container : actionContexts.get(action.getKey())) {
			for (Set<Parameter> parameters : parameterPermutations) {
				ISerializationContext context = new ActionContext( /* container */ null, action.getKey());
				if (!parameters.isEmpty())
					context = new SerializationContext.ParameterValueContext(context, parameters);
				Pda<ISerState, RuleCall> filtered = filterUnneededUnassignedRuleCalls(merged, indexedRules);
				result.put(context, filtered);
			}
			// }
		}
		return result.create();
	}

	protected SerializerPDA merge(ISerializationContext context, Collection<SerializerPDA> pdas) {
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
