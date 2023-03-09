/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IElementMatcherProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementMatcherProvider implements IElementMatcherProvider {

	protected static class TransitionMatcher<T extends IElementPattern> implements IElementMatcherExtension<T> {

		protected IGrammarAccess grammar;

		protected MatcherState lastState = null;

		protected MatcherNFAProvider nfaProvider;

		protected Stack<MatcherState> ruleCallStack = new Stack<MatcherState>();

		public TransitionMatcher(IGrammarAccess grammar, MatcherNFAProvider nfaProvider, Iterable<T> patterns) {
			super();
			this.grammar = grammar;
			this.nfaProvider = nfaProvider;
			installAllPatterns(patterns);
		}

		protected Set<MatcherState> findRuleCallsTo(AbstractRule rule, Set<AbstractRule> visited) {
			if (!visited.add(rule))
				return Collections.emptySet();
			Set<MatcherState> result = Sets.newHashSet();
			Iterator<EObject> i = rule.eAllContents();
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof AbstractElement) {
					MatcherState state = nfaProvider.getNFA((AbstractElement) obj);
					if (state.hasTransitions())
						for (MatcherTransition incoming : state.getAllIncoming())
							if (incoming.isRuleCall() && result.add(incoming.getSource())
									&& incoming.getSource().isEndState())
								result.addAll(findRuleCallsTo(
										GrammarUtil.containingRule(incoming.getSource().getGrammarElement()), visited));
				}
			}
			return result;
		}

		@Override
		public Pair<Integer, RuleCall> findTopmostRuleCall(Predicate<RuleCall> predicate) {
			for (int i = ruleCallStack.size() - 1; i >= 0; i--)
				if (predicate.apply((RuleCall) ruleCallStack.get(i).getGrammarElement()))
					return Tuples.create(i, (RuleCall) ruleCallStack.get(i).getGrammarElement());
			return null;
		}

		protected Pair<List<MatcherTransition>, List<MatcherState>> findTransitionPath(MatcherState from,
				AbstractElement to, boolean returning, boolean canReturn, Set<Pair<Boolean, MatcherState>> visited) {
			if (!visited.add(Tuples.create(returning, from)))
				return null;
			if (from != null) {
				List<MatcherTransition> transitions;
				if (from.getAllOutgoing().isEmpty())
					transitions = from.collectOutgoingTransitions();
				else
					transitions = returning ? from.getOutgoingAfterReturn() : from.getOutgoing();
				for (MatcherTransition transition : transitions) {
					if (transition.getTarget().getGrammarElement() == to)
						return Tuples.create(Collections.singletonList(transition), Collections.singletonList(from));
					else if (transition.getTarget().isParserRuleCall()) {
						ruleCallStack.push(transition.getTarget());
						Pair<List<MatcherTransition>, List<MatcherState>> next = findTransitionPath(
								transition.getTarget(), to, false, transition.getTarget().isParserRuleCallOptional(),
								visited);
						if (next != null) {
							List<MatcherTransition> trans = Lists.newArrayList(transition);
							trans.addAll(next.getFirst());
							List<MatcherState> stats = Lists.newArrayList(from);
							stats.addAll(next.getSecond());
							return Tuples.create(trans, stats);
						} else
							ruleCallStack.pop();
					}
				}
				if (canReturn && from.isEndState() && !ruleCallStack.isEmpty()) {
					MatcherState lastRuleCall = ruleCallStack.pop();
					Pair<List<MatcherTransition>, List<MatcherState>> next = findTransitionPath(lastRuleCall, to, true,
							true, visited);
					if (next != null) {
						List<MatcherState> result = Lists.newArrayList(from);
						result.addAll(next.getSecond());
						return Tuples.create(next.getFirst(), result);
					} else
						ruleCallStack.push(lastRuleCall);
				}
			}
			return null;
		}

		protected List<MatcherTransition> findTransitionsToToken(MatcherState from, Set<MatcherState> targets,
				boolean returning, boolean canReturn, Set<MatcherState> visited) {
			if (!visited.add(from))
				return Collections.emptyList();
			if (targets != null && targets.contains(from))
				targets = null;
			List<MatcherTransition> result = Lists.newArrayList();
			for (MatcherTransition transition : returning ? from.getOutgoingAfterReturn() : from.getOutgoing()) {
				if (transition.getTarget().isParserRuleCall())
					result.addAll(findTransitionsToToken(transition.getTarget(), targets, false, transition.getTarget()
							.isParserRuleCallOptional(), visited));
				else if (targets == null || targets.contains(transition.getTarget()))
					result.add(transition);
			}
			if (canReturn && from.isEndState())
				for (MatcherState caller : findRuleCallsTo(GrammarUtil.containingRule(from.getGrammarElement()),
						Sets.<AbstractRule> newHashSet()))
					result.addAll(findTransitionsToToken(caller, targets, true, true, visited));
			return result;
		}

		@Override
		@SuppressWarnings("unchecked")
		public Collection<T> finish() {
			if (lastState != null) {
				List<IElementPattern> result = Lists.<IElementPattern> newArrayList(lastState.getAfterPatterns());
				while (!ruleCallStack.isEmpty())
					result.addAll(ruleCallStack.pop().getAfterPatterns());
				//				String file = lastState.getGrammarElement().eResource().getURI().lastSegment() + "3.pdf";
				//				try {
				//					new ElementMatcherToDot().draw(this, file, "-T pdf");
				//				} catch (IOException e) {
				//					e.printStackTrace();
				//				}
				lastState = null;
				return (Collection<T>) result;
			} else
				return Collections.emptyList();
		}

		protected Set<MatcherState> getAllStates(AbstractElement element) {
			Set<MatcherState> result = newHashSet();
			Iterator<EObject> i = EcoreUtil2.eAll(element);
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof AbstractElement) {
					MatcherState state = nfaProvider.getNFA((AbstractElement) obj);
					if (state.hasTransitions())
						result.add(state);
				}
			}
			return result;
		}

		public IGrammarAccess getGrammar() {
			return grammar;
		}

		public MatcherNFAProvider getNfaProvider() {
			return nfaProvider;
		}

		protected void installAfter(IAfterElement pattern) {
			Set<MatcherState> states = getAllStates(pattern.matchAfter());
			AbstractRule rule = GrammarUtil.containingRule(pattern.matchAfter());
			for (MatcherState state : states) {
				state.getAfterPatterns().add(pattern);
				for (MatcherTransition out : state.isParserRuleCall() ? state.getOutgoingAfterReturn() : state
						.getOutgoing())
					if (pattern.matchAfter() == out.getLoopCenter() || !states.contains(out.getTarget()))
						out.addPattern(pattern);
				if (state.isEndState())
					for (MatcherState caller : findRuleCallsTo(rule, Sets.<AbstractRule> newHashSet()))
						for (MatcherTransition afterReturn : caller.getOutgoingAfterReturn())
							afterReturn.addPattern(state, pattern);
			}
		}

		protected void installAllPatterns(Iterable<T> patterns) {
			for (IElementPattern pattern : patterns) {
				if (pattern instanceof IBeforeElement && ((IBeforeElement) pattern).matchBefore() != null)
					installBefore((IBeforeElement) pattern);
				if (pattern instanceof IAfterElement && ((IAfterElement) pattern).matchAfter() != null)
					installAfter((IAfterElement) pattern);
				if (pattern instanceof IBetweenElements && ((IBetweenElements) pattern).matchBetween() != null)
					installBetween((IBetweenElements) pattern);
			}
		}

		protected void installBefore(IBeforeElement pattern) {
			Set<MatcherState> states = getAllStates(pattern.matchBefore());
			for (MatcherState state : states) {
				state.getBeforePatterns().add(pattern);
				for (MatcherTransition incoming : state.getAllIncoming())
					if (pattern.matchBefore() == incoming.getLoopCenter() || !states.contains(incoming.getSource()))
						incoming.addPattern(pattern);
			}
		}

		protected void installBetween(IBetweenElements pattern) {
			if (pattern.matchBetween().getFirst() == pattern.matchBetween().getSecond())
				installBetween(pattern, pattern.matchBetween().getFirst());
			else
				installBetween(pattern, pattern.matchBetween().getFirst(), pattern.matchBetween().getSecond());
		}

		protected void installBetween(IBetweenElements pattern, AbstractElement loopCenter) {
			Set<MatcherState> states = getAllStates(loopCenter);
			for (MatcherState state : states) {
				state.getBeforeBetweenElements().add(pattern);
				state.getAfterBetweenElements().add(pattern);
				for (MatcherTransition transition : state.getAllOutgoing())
					if (transition.getLoopCenter() == loopCenter && states.contains(transition.getTarget()))
						transition.addPattern(pattern);
			}
		}

		protected void installBetween(IBetweenElements pattern, AbstractElement first, AbstractElement second) {
			Set<MatcherState> sources = getAllStates(first);
			Set<MatcherState> targets = getAllStates(second);
			for (MatcherState target : targets)
				target.getBeforeBetweenElements().add(pattern);
			for (MatcherState source : sources) {
				source.getAfterBetweenElements().add(pattern);
				for (MatcherTransition transition : findTransitionsToToken(source, targets, source.isParserRuleCall(),
						true, Sets.<MatcherState> newHashSet())) {
					if (transition.getSource() == source)
						transition.addPattern(pattern);
					else
						transition.addPattern(source, pattern);
				}
			}
		}

		/**
		 * @since 2.0
		 */
		@Override
		public void init(ParserRule rule) {
			lastState = nfaProvider.getNFA(rule.getAlternatives());
		}

		@Override
		public Collection<T> matchNext(AbstractElement nextElement) {
			Pair<List<MatcherTransition>, List<MatcherState>> path = findTransitionPath(lastState, nextElement, false,
					true, Sets.<Pair<Boolean, MatcherState>> newHashSet());
			if (path == null) {
				MatcherState previousState = lastState;
				lastState = nfaProvider.getNFA(nextElement);
				//				System.out.println("Not Found! looking for " + new GrammarElementTitleSwitch().doSwitch(nextElement));
				return patternsForTwoStates(previousState, lastState);
			} else {
				//				System.out.println("Found " + path + " -> " + patternsForTransition(path));
				lastState = path.getFirst().get(path.getFirst().size() - 1).getTarget();
				return patternsForTransition(path);
			}
		}

		@SuppressWarnings("unchecked")
		protected Collection<T> patternsForTransition(Pair<List<MatcherTransition>, List<MatcherState>> transition) {
			List<IElementPattern> result = Lists.newArrayList();
			Set<MatcherState> exits = Sets.newHashSet(transition.getSecond());
			for (MatcherTransition transitio : transition.getFirst())
				result.addAll(transitio.getPatterns(exits));
			return (Collection<T>) result;
		}

		@SuppressWarnings("unchecked")
		protected Collection<T> patternsForTwoStates(MatcherState first, MatcherState second) {
			Collection<IElementPattern> result = Sets.newHashSet();
			if (first != null) {
				result.addAll(first.getAfterPatterns());
				for (IBetweenElements between : first.getAfterBetweenElements())
					if (getAllStates(between.matchBetween().getSecond()).contains(second))
						result.add(between);
				for (IBetweenElements between : second.getBeforeBetweenElements())
					if (getAllStates(between.matchBetween().getFirst()).contains(first))
						result.add(between);
			}
			result.addAll(second.getBeforePatterns());
			return (Collection<T>) result;
		}
	}

	@Inject
	protected IGrammarAccess grammar;

	@Inject
	protected MatcherNFAProvider nfaProvider;

	@Override
	public <T extends IElementPattern> IElementMatcher<T> createMatcher(Iterable<T> rules) {
		return new TransitionMatcher<T>(grammar, nfaProvider, rules);
	}

}
