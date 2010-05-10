/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import static com.google.common.collect.Sets.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IElementMatcherProvider;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ElementMatcherProvider implements IElementMatcherProvider {

	protected static class TransitionMatcher<T extends IElementPattern> implements IElementMatcher<T> {

		protected MatcherState lastState = null;

		protected MatcherNFAProvider nfaProvider;

		protected Set<AbstractElement> seenTokens = newHashSet();

		public TransitionMatcher(MatcherNFAProvider nfaProvider, Iterable<T> patterns) {
			super();
			this.nfaProvider = nfaProvider;
			installAllPatterns(patterns);
		}

		protected MatcherTransition findTransition(AbstractElement nextElement) {
			if (lastState != null)
				for (MatcherTransition transition : lastState.getAllOutgoing())
					if (transition.getTarget().getGrammarElement() == nextElement)
						return transition;
			return null;
		}

		public Collection<T> finish() {
			if (lastState != null) {
				@SuppressWarnings("unchecked")
				Collection<T> result = (Collection<T>) lastState.getAfterPatterns();
				//				String file = lastState.getGrammarElement().eResource().getURI().lastSegment() + "3.pdf";
				//				try {
				//					new TransitionMatcherToDot().draw(this, file, "-T pdf");
				//				} catch (IOException e) {
				//					e.printStackTrace();
				//				}
				lastState = null;
				return result;
			} else
				return Collections.emptyList();
		}

		protected Set<MatcherState> getAllStates(AbstractElement element) {
			boolean folowRuleCalls = element instanceof Assignment || element instanceof RuleCall;
			Set<MatcherState> result = newHashSet();
			Iterator<EObject> i = EcoreUtil2.eAll(element);
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof AbstractElement) {
					result.add(nfaProvider.getNFA((AbstractElement) obj));
					if (folowRuleCalls && obj instanceof RuleCall) {
						AbstractRule rule = ((RuleCall) obj).getRule();
						if (rule.getType().getClassifier() instanceof EClass)
							result.addAll(getAllStates(rule.getAlternatives()));
					}
				}
			}
			return result;
		}

		public MatcherNFAProvider getNfaProvider() {
			return nfaProvider;
		}

		public Set<AbstractElement> getSeenTokens() {
			return seenTokens;
		}

		protected void installAfter(IAfterElement pattern) {
			Set<MatcherState> states = getAllStates(pattern.matchAfter());
			for (MatcherState state : states) {
				state.getAfterPatterns().add(pattern);
				for (MatcherTransition outgoing : state.getAllOutgoing())
					if (pattern.matchAfter() == outgoing.getLoopCenter() || !states.contains(outgoing.getTarget()))
						outgoing.getPatterns().add(pattern);
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
						incoming.getPatterns().add(pattern);
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
						transition.getPatterns().add(pattern);
			}
		}

		protected void installBetween(IBetweenElements pattern, AbstractElement first, AbstractElement second) {
			Set<MatcherState> sources = getAllStates(first);
			Set<MatcherState> targets = getAllStates(second);
			for (MatcherState target : targets)
				target.getBeforeBetweenElements().add(pattern);
			for (MatcherState source : sources) {
				source.getAfterBetweenElements().add(pattern);
				for (MatcherTransition transition : source.getAllOutgoing())
					if (targets.contains(transition.getTarget()))
						transition.getPatterns().add(pattern);
			}
		}

		public Collection<T> matchNext(AbstractElement nextElement) {
			seenTokens.add(nextElement);
			MatcherTransition transition = findTransition(nextElement);
			if (transition == null) {
				MatcherState previousState = lastState;
				lastState = nfaProvider.getNFA(nextElement);
				return patternsForTwoStates(previousState, lastState);
			} else {
				lastState = transition.getTarget();
				return patternsForTransition(transition);
			}
		}

		@SuppressWarnings("unchecked")
		protected Collection<T> patternsForTransition(MatcherTransition transition) {
			return (Collection<T>) transition.getPatterns();
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
	protected MatcherNFAProvider nfaProvider;

	public <T extends IElementPattern> IElementMatcher<T> createMatcher(Iterable<T> rules) {
		return new TransitionMatcher<T>(nfaProvider, rules);
	}

}
