/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementFullTitleSwitch;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SequenceParserPDAProvider implements ISyntacticSequencerPDAProvider {

	protected class PDAStartState extends PDAEmittingState implements IPDAAbsorberState {

		public PDAStartState(SequenceParserState nfaState) {
			super(nfaState, PDAEmitterStateType.START, false);
		}

		public List<IPDAEmitterState> getFollowers() {
			if (following == null)
				following = Lists.newArrayList();
			return following;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return null;
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByElement() {
			return Collections.emptyMap(); // TODO: implement
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallEnter() {
			return Collections.emptyMap(); // TODO: implement
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallExit() {
			return Collections.emptyMap(); // TODO: implement
		}

	}

	protected class PDAStopState extends PDAEmittingState implements IPDAAbsorberState {

		public PDAStopState(SequenceParserState nfaState) {
			super(nfaState, PDAEmitterStateType.STOP, true);
		}

		public List<IPDAEmitterState> getFollowers() {
			return Collections.emptyList();
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByElement() {
			return Collections.emptyMap();
		}

		@Override
		public AbstractElement getGrammarElement() {
			return null;
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallEnter() {
			return Collections.emptyMap();
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallExit() {
			return Collections.emptyMap();
		}

	}

	protected class PDAEmitterState extends PDAEmittingState {

		protected IPDAAbsorberState target;

		public PDAEmitterState(IPDAAbsorberState target, SequenceParserState nfaState, boolean returning) {
			super(nfaState, returning);
			this.target = target;
		}

		protected void setFollowers(List<IPDAEmitterState> followers) {
			this.following = followers;
		}

		public List<IPDAEmitterState> getFollowers() {
			if (following == null) {
				boolean canReturn = returning || !isParserRuleCall(getGrammarElement());
				following = createEmitterStates(this, this.nfaState, this.target, returning, canReturn);
			}
			return following;
		}

	}

	protected abstract class PDAState {
		protected SequenceParserState nfaState;

		public PDAState(SequenceParserState nfaState) {
			super();
			this.nfaState = nfaState;
		}

	}

	protected boolean isParserRuleCall(AbstractElement ele) {
		return ele instanceof RuleCall && ((RuleCall) ele).getRule() instanceof ParserRule;
	}

	protected abstract class PDAEmittingState extends PDAState implements IPDAEmitterState {

		protected List<IPDAEmitterState> following;

		protected PDAEmitterStateType type;

		protected boolean returning;

		public PDAEmittingState(SequenceParserState nfaState, boolean returning) {
			super(nfaState);
			this.returning = returning;
			this.type = createKey(nfaState, returning).getFirst();
		}

		public PDAEmittingState(SequenceParserState nfaState, PDAEmitterStateType type, boolean returning) {
			super(nfaState);
			this.returning = returning;
			this.type = type;
		}

		public PDAEmitterStateType getType() {
			return type;
		}

		public AbstractElement getGrammarElement() {
			return nfaState.getGrammarElement();
		}

		@Override
		public String toString() {
			if (type == null)
				return "(type==null)" + titles.doSwitch(getGrammarElement());
			switch (type) {
				case PARSER_RULE_ENTER:
					return ">>" + titles.doSwitch(getGrammarElement());
				case PARSER_RULE_EXIT:
					return "<<" + titles.doSwitch(getGrammarElement());
				case PASS_ACTION:
				case PASS_KEYWORD:
				case UNKNOWN:
					return titles.doSwitch(getGrammarElement());
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return titles.doSwitch(getGrammarElement());
		}

	}

	public class SequenceParserNFAProvider extends AbstractNFAProvider<SequenceParserState, SequenceParserTransition> {
		public class SequenceParserNFABuilder extends
				AbstractCachingNFABuilder<SequenceParserState, SequenceParserTransition> {

			@Override
			public SequenceParserState createState(AbstractElement ele) {
				return new SequenceParserState(ele, this);
			}

			@Override
			protected SequenceParserTransition createTransition(SequenceParserState source, SequenceParserState target,
					boolean isRuleCall, AbstractElement loopCenter) {
				return new SequenceParserTransition(source, target, isRuleCall, loopCenter);
			}

			@Override
			public boolean filter(AbstractElement ele) {
				return !isAbsorberOrEmitter(ele);
			}

			public NFADirection getDirection() {
				return NFADirection.FORWARD;
			}
		}

		@Override
		protected NFABuilder<SequenceParserState, SequenceParserTransition> createBuilder() {
			return new SequenceParserNFABuilder();
		}

	}

	public class SequenceParserState extends AbstractNFAState<SequenceParserState, SequenceParserTransition> {

		public SequenceParserState(AbstractElement element,
				NFABuilder<SequenceParserState, SequenceParserTransition> builder) {
			super(element, builder);
		}

		protected PDAAbsorberState returningAbsorber;
		protected PDAAbsorberState enteringAbsorber;
		protected Map<IPDAAbsorberState, PDAEmitterState> emitters;
		protected PDAStartState startState;
		protected PDAStopState stopState;

		protected List<SequenceParserTransition> collectOutgoingTransitions() {
			outgoing = Lists.newArrayList();
			outgoingRuleCalls = Lists.newArrayList();
			collectOutgoing(element, Sets.<AbstractElement> newHashSet(), false, null);
			removeDuplicates(outgoing);
			removeDuplicates(outgoingRuleCalls);
			return outgoingRuleCalls.isEmpty() ? outgoing : outgoingRuleCalls;
		}

		public PDAAbsorberState getOrCreateAbsorberState(boolean returning) {
			if (isParserRuleCall(getGrammarElement()) && returning) {
				if (returningAbsorber == null)
					return returningAbsorber = new PDAAbsorberState(this, returning);
				return returningAbsorber;
			} else {
				if (enteringAbsorber == null)
					return enteringAbsorber = new PDAAbsorberState(this, returning);
				return enteringAbsorber;
			}
		}

		public boolean equals(IPDAEmitterState target, boolean returning) {
			if (getGrammarElement() != target.getGrammarElement())
				return false;
			if (!isParserRuleCall(getGrammarElement()))
				return true;
			if (target instanceof PDAEmittingState)
				return ((PDAEmittingState) target).returning == returning;
			return true;
		}

		public PDAEmitterState getOrCreateEmitterState(IPDAAbsorberState target, boolean returning) {
			if (emitters == null)
				emitters = Maps.newHashMap();
			PDAEmitterState result = emitters.get(target);
			if (result == null)
				emitters.put(target, result = new PDAEmitterState(target, this, returning));
			return result;
		}
	}

	protected boolean canBeAbsorber(AbstractElement ele) {
		return false;
	}

	public class PDAAbsorberState extends PDAEmittingState implements IPDAAbsorberState {

		protected Map<AbstractElement, List<IPDAEmitterState>> followersByElement;
		protected Map<AbstractElement, List<IPDAEmitterState>> followersByRuleCallEnter;
		protected Map<AbstractElement, List<IPDAEmitterState>> followersByRuleCallExit;

		public PDAAbsorberState(SequenceParserState nfaState, boolean returning) {
			super(nfaState, returning);
		}

		public void initFollowers() {
			if (following == null) {
				following = Lists.newArrayList();
				Set<IPDAAbsorberState> targets = Sets.newHashSet();
				boolean canReturn = returning || !isParserRuleCall(getGrammarElement());
				collectAbsorberStates(nfaState, false, returning, canReturn, targets);
				for (IPDAAbsorberState target : targets)
					if (isMandatoryAbsorber(target.getGrammarElement()) || canBeAbsorber(target.getGrammarElement())
							|| target.getType() == PDAEmitterStateType.STOP) {
						List<IPDAEmitterState> startStates = createEmitterStates(this, nfaState, target, returning,
								canReturn);
						following.addAll(startStates);
						switch (target.getType()) {
							case PARSER_RULE_ENTER:
								if (followersByRuleCallEnter == null)
									followersByRuleCallEnter = Maps.newHashMap();
								followersByRuleCallEnter.put(target.getGrammarElement(), startStates);
								break;
							case PARSER_RULE_EXIT:
								if (followersByRuleCallExit == null)
									followersByRuleCallExit = Maps.newHashMap();
								followersByRuleCallExit.put(target.getGrammarElement(), startStates);
								break;
							default:
								if (followersByElement == null)
									followersByElement = Maps.newHashMap();
								followersByElement.put(target.getGrammarElement(), startStates);
						}
					}
			}
		}

		public List<IPDAEmitterState> getFollowers() {
			initFollowers();
			return following;
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallEnter() {
			return followersByRuleCallEnter == null ? Collections.<AbstractElement, List<IPDAEmitterState>> emptyMap()
					: followersByRuleCallEnter;
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByRuleCallExit() {
			return followersByRuleCallExit == null ? Collections.<AbstractElement, List<IPDAEmitterState>> emptyMap()
					: followersByRuleCallExit;
		}

		public Map<AbstractElement, List<IPDAEmitterState>> getFollowersByElement() {
			return followersByElement == null ? Collections.<AbstractElement, List<IPDAEmitterState>> emptyMap()
					: followersByElement;
		}

	}

	public class SequenceParserTransition extends AbstractNFATransition<SequenceParserState, SequenceParserTransition> {

		public SequenceParserTransition(SequenceParserState source, SequenceParserState target, boolean ruleCall,
				AbstractElement loopCenter) {
			super(source, target, ruleCall, loopCenter);
		}
	}

	protected SequenceParserNFAProvider nfaProvider = createSequenceParserNFAProvider();

	protected GrammarElementTitleSwitch titles = new GrammarElementFullTitleSwitch();

	protected void collectAbsorberStates(SequenceParserState from, boolean collectNode, boolean returning,
			boolean canReturn, Set<IPDAAbsorberState> visited) {
		if (collectNode && !visited.add(from.getOrCreateAbsorberState(returning)))
			return;

		if (collectNode && isMandatoryAbsorber(from.getGrammarElement()))
			return;

		for (SequenceParserTransition transition : returning ? from.getOutgoingAfterReturn() : from.getOutgoing()) {
			collectAbsorberStates(transition.getTarget(), true, false, !transition.isRuleCall(), visited);
		}
		if (canReturn && from.isEndState()) {
			AbstractRule pr = GrammarUtil.containingRule(from.getGrammarElement());
			SequenceParserState ruleState = nfaProvider.getNFA(pr.getAlternatives());
			if (ruleState != null && ruleState.stopState != null)
				visited.add(ruleState.stopState);

			for (SequenceParserState caller : findRuleCallsTo(GrammarUtil.containingRule(from.getGrammarElement()),
					Sets.<AbstractRule> newHashSet()))
				collectAbsorberStates(caller, true, true, true, visited);
		}
	}

	protected List<IPDAEmitterState> createEmitterStates(IPDAEmitterState from, SequenceParserState fromNfa,
			IPDAAbsorberState to, boolean returning, boolean canReturn) {
		List<IPDAEmitterState> result = Lists.newArrayList();

		for (SequenceParserTransition transition : returning ? fromNfa.getOutgoingAfterReturn() : fromNfa.getOutgoing())
			if (transition.getTarget().equals(to, false))
				result.add(to);
			else if (!isMandatoryAbsorber(transition.getTarget().getGrammarElement())
					&& canReachAbsorberState(transition.getTarget(), to, false, !transition.isRuleCall(),
							Sets.<SequenceParserState> newHashSet())) {
				PDAEmitterState state = transition.getTarget().getOrCreateEmitterState(to, false);
				result.add(state);
			}

		if (canReturn && fromNfa.isEndState()) {
			AbstractRule pr = GrammarUtil.containingRule(from.getGrammarElement());
			SequenceParserState ruleState = nfaProvider.getNFA(pr.getAlternatives());
			if (ruleState != null && ruleState.stopState == to)
				result.add(ruleState.stopState);
			for (SequenceParserState caller : findRuleCallsTo(pr, Sets.<AbstractRule> newHashSet())) {
				if (caller.equals(to, true))
					result.add(to);
				else if (!isMandatoryAbsorber(caller.getGrammarElement())
						&& canReachAbsorberState(caller, to, true, true, Sets.<SequenceParserState> newHashSet())) {
					PDAEmitterState state = caller.getOrCreateEmitterState(to, true);
					result.add(state);
				}
			}
		}
		return result;
	}

	protected boolean canReachAbsorberState(SequenceParserState fromNfa, IPDAAbsorberState to, boolean returning,
			boolean canReturn, Set<SequenceParserState> visited) {
		if (!visited.add(fromNfa))
			return false;

		for (SequenceParserTransition transition : returning ? fromNfa.getOutgoingAfterReturn() : fromNfa.getOutgoing())
			if (transition.getTarget().equals(to, false))
				return true;
			else if (!isMandatoryAbsorber(transition.getTarget().getGrammarElement())) {
				if (canReachAbsorberState(transition.getTarget(), to, false, !transition.isRuleCall(), visited))
					return true;
			}

		if (canReturn && fromNfa.isEndState()) {
			AbstractRule pr = GrammarUtil.containingRule(fromNfa.getGrammarElement());
			SequenceParserState ruleState = nfaProvider.getNFA(pr.getAlternatives());
			if (ruleState != null && ruleState.stopState == to)
				return true;
			for (SequenceParserState caller : findRuleCallsTo(pr, Sets.<AbstractRule> newHashSet())) {
				if (caller.equals(to, true))
					return true;
				else if (!isMandatoryAbsorber(caller.getGrammarElement())) {
					if (canReachAbsorberState(caller, to, true, true, visited))
						return true;
				}
			}
		}
		return false;
	}

	protected Pair<PDAEmitterStateType, SequenceParserState> createKey(SequenceParserState target, boolean returning) {
		if (target.getGrammarElement() instanceof Keyword)
			return Tuples.create(PDAEmitterStateType.PASS_ACTION, target);
		else if (target.getGrammarElement() instanceof Action)
			return Tuples.create(PDAEmitterStateType.PASS_ACTION, target);
		else if (target.getGrammarElement() instanceof RuleCall
				&& ((RuleCall) target.getGrammarElement()).getRule() instanceof ParserRule) {
			if (returning)
				return Tuples.create(PDAEmitterStateType.PARSER_RULE_EXIT, target);
			else
				return Tuples.create(PDAEmitterStateType.PARSER_RULE_ENTER, target);
		}
		return Tuples.create(PDAEmitterStateType.UNKNOWN, target);
	}

	protected SequenceParserNFAProvider createSequenceParserNFAProvider() {
		return new SequenceParserNFAProvider();
	}

	protected Set<SequenceParserState> findRuleCallsTo(AbstractRule rule, Set<AbstractRule> visited) {
		if (!visited.add(rule))
			return Collections.emptySet();
		Set<SequenceParserState> result = Sets.newHashSet();
		Iterator<EObject> i = rule.eAllContents();
		while (i.hasNext()) {
			EObject obj = i.next();
			if (obj instanceof AbstractElement) {
				SequenceParserState state = nfaProvider.getNFA((AbstractElement) obj);
				for (SequenceParserTransition incoming : state.getAllIncoming())
					if (incoming.isRuleCall() && result.add(incoming.getSource()) && incoming.getSource().isEndState())
						result.addAll(findRuleCallsTo(
								GrammarUtil.containingRule(incoming.getSource().getGrammarElement()), visited));
			}
		}
		return result;
	}

	protected boolean collectPDAStates(SequenceParserState startNfa, PDAStartState result) {
		if (isMandatoryAbsorber(startNfa.getGrammarElement())
				|| (canBeAbsorber(startNfa.getGrammarElement()) && isAbsorberOrEmitter(startNfa.getGrammarElement()))) {
			result.getFollowers().add(startNfa.getOrCreateAbsorberState(false));
		}
		if (!isMandatoryAbsorber(startNfa.getGrammarElement()) && isAbsorberOrEmitter(startNfa.getGrammarElement())) {
			Set<IPDAAbsorberState> targets = Sets.newHashSet();
			collectAbsorberStates(startNfa, false, false, false, targets);
			for (IPDAAbsorberState target : targets)
				if (isMandatoryAbsorber(target.getGrammarElement()) || canBeAbsorber(target.getGrammarElement()))
					//					PDAEmitterState e = ;
					//					e.setFollowers(createEmitterStates(result, startNfa, target, false, false));
					result.getFollowers().add(startNfa.getOrCreateEmitterState(target, false));
		}
		return !result.getFollowers().isEmpty();
	}

	public IPDAAbsorberState getPDA(Grammar grammar) {
		ParserRule rootRule = GrammarUtil.allParserRules(grammar).get(0);
		SequenceParserState startNfa = nfaProvider.getNFA(rootRule.getAlternatives());
		startNfa.startState = new PDAStartState(startNfa);
		startNfa.stopState = new PDAStopState(startNfa);
		PDAStartState result = new PDAStartState(startNfa);
		if (collectPDAStates(startNfa, result))
			return result;
		for (SequenceParserTransition transition : startNfa.collectOutgoingTransitions())
			collectPDAStates(transition.getTarget(), result);
		return result;
	}

	protected boolean isAbsorberOrEmitter(AbstractElement ele) {
		if (ele == null)
			return true;
		if (ele instanceof CompoundElement)
			return false;
		if (ele instanceof Assignment)
			return false;
		if (ele instanceof CrossReference)
			return false;
		return true;
	}

	protected boolean isMandatoryAbsorber(AbstractElement ele) {
		if (ele == null)
			return false;
		if (!isAbsorberOrEmitter(ele))
			return false;
		if (GrammarUtil.containingAssignment(ele) != null)
			return true;
		//		if (ele instanceof Action && ((Action) ele).getFeature() != null)
		//			return true;
		if (ele instanceof RuleCall && ((RuleCall) ele).getRule().getType().getClassifier() instanceof EDataType)
			return true;
		return false;
	}

}
