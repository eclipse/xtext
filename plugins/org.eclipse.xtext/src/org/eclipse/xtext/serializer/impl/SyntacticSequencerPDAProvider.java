/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.INFAState;
import org.eclipse.xtext.grammaranalysis.INFATransition;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.grammaranalysis.impl.AbstractPDAProvider;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementFullTitleSwitch;
import org.eclipse.xtext.serializer.ISyntacticSequencerPDAProvider;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class SyntacticSequencerPDAProvider implements ISyntacticSequencerPDAProvider {

	protected static class PDAAbsorberState extends PDAEmitterState implements IPDAAbsorberState {

		protected Map<AbstractElement, IPDATransition> outTransitionsByElement = Maps.newHashMap();

		protected Map<AbstractElement, IPDATransition> outTransitionsByRuleCallEnter = Maps.newHashMap();

		protected Map<AbstractElement, IPDATransition> outTransitionsByRuleCallExit = Maps.newHashMap();

		public PDAAbsorberState(PDAEmitterStateType type, AbstractElement element) {
			super(type, element);
		}

		protected void addTransition(IPDATransition transition) {
			addFollower(transition.getDirectEmittersAndAbsorber());
			switch (transition.getTarget().getType().getSimpleType()) {
				case START:
					throw new UnsupportedOperationException("StartStates can not have incoming transitions");
				case ELEMENT:
				case STOP:
					if (outTransitionsByElement.isEmpty())
						outTransitionsByElement = Maps.newHashMap();
					outTransitionsByElement.put(transition.getTarget().getGrammarElement(), transition);
					break;
				case RULECALL_ENTER:
					if (outTransitionsByRuleCallEnter.isEmpty())
						outTransitionsByRuleCallEnter = Maps.newHashMap();
					outTransitionsByRuleCallEnter.put(transition.getTarget().getGrammarElement(), transition);
					break;
				case RULECALL_EXIT:
					if (outTransitionsByRuleCallExit.isEmpty())
						outTransitionsByRuleCallExit = Maps.newHashMap();
					outTransitionsByRuleCallExit.put(transition.getTarget().getGrammarElement(), transition);
					break;
			}

		}

		public List<IPDATransition> getOutTransitions() {
			List<IPDATransition> result = Lists.newArrayList();
			result.addAll(outTransitionsByElement.values());
			result.addAll(outTransitionsByRuleCallEnter.values());
			result.addAll(outTransitionsByRuleCallExit.values());
			return result;
		}

		public Map<AbstractElement, IPDATransition> getOutTransitionsByElement() {
			return outTransitionsByElement;
		}

		public Map<AbstractElement, IPDATransition> getOutTransitionsByRuleCallEnter() {
			return outTransitionsByRuleCallEnter;
		}

		public Map<AbstractElement, IPDATransition> getOutTransitionsByRuleCallExit() {
			return outTransitionsByRuleCallExit;
		}

	}

	protected static class PDAEmitterState implements IPDAEmitterState {

		protected AbstractElement element;

		protected List<IPDAEmitterState> followers = Collections.emptyList();

		protected PDAEmitterStateType type;

		public PDAEmitterState(PDAEmitterStateType type, AbstractElement element) {
			super();
			this.type = type;
			this.element = element;
			this.followers = Collections.emptyList();
		}

		protected void addFollower(IPDAEmitterState follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.add(follower);
		}

		protected void addFollower(List<IPDAEmitterState> follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.addAll(follower);
		}

		public List<IPDAEmitterState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return element;
		}

		public PDAEmitterStateType getType() {
			return type;
		}

		protected void setFollowers(List<IPDAEmitterState> followers) {
			this.followers = followers;
		}

		@Override
		public String toString() {
			if (type == null)
				return "(type is null)";
			GrammarElementFullTitleSwitch titles = new GrammarElementFullTitleSwitch();
			switch (type.getSimpleType()) {
				case ELEMENT:
					return element == null ? "(null)" : titles.doSwitch(element);
				case RULECALL_ENTER:
					return ">>" + (element == null ? "(null)" : titles.doSwitch(element));
				case RULECALL_EXIT:
					return "<<" + (element == null ? "(null)" : titles.doSwitch(element));
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return "";
		}

	}

	protected static class PDATransition implements IPDATransition {

		protected List<IPDAEmitterState> emitters = Collections.emptyList();
		protected IPDAAbsorberState source;
		protected IPDAAbsorberState target;

		public PDATransition(IPDAAbsorberState source, IPDAAbsorberState target) {
			super();
			this.source = source;
			this.target = target;
		}

		public List<IPDAEmitterState> getDirectEmittersAndAbsorber() {
			return emitters;
		}

		public List<IPDAEmitterState> getShortestPathToAbsorber() {
			return Collections.emptyList();
		}

		public IPDAAbsorberState getSource() {
			return source;
		}

		public IPDAAbsorberState getTarget() {
			return target;
		}

		public boolean involvesRuleExit() {
			return false;
		}

		public boolean isSyntacticallyAmbiguous() {
			return false;
		}

		protected void setEmitters(List<IPDAEmitterState> emitters) {
			this.emitters = emitters;
		}

		public boolean involvesUnassignedTokenRuleCalls() {
			return false;
		}

		@Override
		public String toString() {
			return source + " -> " + target;
		}

	}

	public static class SequencerNFAProvider extends AbstractNFAProvider<SequencerNFAState, SequencerNFATransition> {
		public class SequencerNFABuilder extends AbstractCachingNFABuilder<SequencerNFAState, SequencerNFATransition> {

			@Override
			public SequencerNFAState createState(AbstractElement ele) {
				return new SequencerNFAState(ele, this);
			}

			@Override
			protected SequencerNFATransition createTransition(SequencerNFAState source, SequencerNFAState target,
					boolean isRuleCall, AbstractElement loopCenter) {
				return new SequencerNFATransition(source, target, isRuleCall, loopCenter);
			}

			@Override
			public boolean filter(AbstractElement ele) {
				if (ele instanceof CompoundElement)
					return true;
				if (ele instanceof Assignment)
					return true;
				if (ele instanceof CrossReference)
					return true;
				return false;
			}

			public NFADirection getDirection() {
				return NFADirection.FORWARD;
			}
		}

		@Override
		protected NFABuilder<SequencerNFAState, SequencerNFATransition> createBuilder() {
			return new SequencerNFABuilder();
		}

		public NFABuilder<SequencerNFAState, SequencerNFATransition> getBuilder() {
			return builder;
		}

	}

	public static class SequencerNFAState extends AbstractNFAState<SequencerNFAState, SequencerNFATransition> {

		public SequencerNFAState(AbstractElement element, NFABuilder<SequencerNFAState, SequencerNFATransition> builder) {
			super(element, builder);
		}

		public List<SequencerNFATransition> collectOutgoingTransitions() {
			outgoing = Lists.newArrayList();
			outgoingRuleCalls = Lists.newArrayList();
			collectOutgoing(element, Sets.<AbstractElement> newHashSet(), false, null);
			removeDuplicates(outgoing);
			removeDuplicates(outgoingRuleCalls);
			return outgoingRuleCalls.isEmpty() ? outgoing : outgoingRuleCalls;
		}

	}

	public static class SequencerNFATransition extends AbstractNFATransition<SequencerNFAState, SequencerNFATransition> {

		public SequencerNFATransition(SequencerNFAState source, SequencerNFAState target, boolean ruleCall,
				AbstractElement loopCenter) {
			super(source, target, ruleCall, loopCenter);
		}
	}

	public static class SequencerPDAProvider extends AbstractPDAProvider {

		protected SequencerNFAProvider nfaProvider;

		public SequencerPDAProvider(SequencerNFAProvider nfaProvider) {
			super();
			this.nfaProvider = nfaProvider;
		}

		@Override
		protected boolean canEnterRuleCall(INFAState<?, ?> state) {
			if (!(state.getGrammarElement() instanceof RuleCall))
				return false;
			RuleCall rc = (RuleCall) state.getGrammarElement();
			if (!(rc.getRule() instanceof ParserRule && rc.getRule().getType().getClassifier() instanceof EClass))
				return false;
			return GrammarUtil.containingAssignment(rc) == null;
		}

		protected boolean canReachElement(INFAState<?, ?> from, AbstractElement to, Set<Object> visited) {
			if (!visited.add(from))
				return false;
			if (from.getGrammarElement() == to)
				return true;
			for (INFATransition<?, ?> trans : from.getAllOutgoing())
				if (!trans.isRuleCall() && canReachElement(trans.getTarget(), to, visited))
					return true;
			return false;
		}

		protected boolean canReachEndState(INFAState<?, ?> from, Set<Object> visited) {
			if (!visited.add(from))
				return false;
			if (from.isEndState())
				return true;
			for (INFATransition<?, ?> trans : from.getAllOutgoing())
				if (!trans.isRuleCall() && canReachEndState(trans.getTarget(), visited))
					return true;
			return false;
		}

		protected List<INFAState<?, ?>> getActionStartFollowers(Action action) {
			ParserRule rule = GrammarUtil.containingParserRule(action);
			List<INFAState<?, ?>> result = Lists.newArrayList();
			for (INFAState<?, ?> state : getAllRuleStartFollowers(rule))
				if (canReachElement(state, action, Sets.newHashSet()))
					result.add(state);
			return result;
		}

		protected List<INFAState<?, ?>> getParserRuleStartFollowers(ParserRule rule) {
			List<INFAState<?, ?>> result = Lists.newArrayList();
			for (INFAState<?, ?> state : getAllRuleStartFollowers(rule))
				if (canReachEndState(state, Sets.newHashSet()))
					result.add(state);
			return result;
		}

		protected List<INFAState<?, ?>> getAllRuleStartFollowers(ParserRule pr) {
			SequencerNFAState startNfa = nfaProvider.getNFA(pr.getAlternatives());
			List<INFAState<?, ?>> result = Lists.newArrayList();
			if (nfaProvider.getBuilder().filter(pr.getAlternatives())) {
				for (SequencerNFATransition transition : startNfa.collectOutgoingTransitions())
					result.add(transition.getTarget());
			} else
				result.add(startNfa);
			for (Action a : GrammarUtil.containedActions(pr))
				if (GrammarUtil.isAssignedAction(a))
					result.add(nfaProvider.getNFA(a));
			return result;
		}

		@Override
		protected List<INFAState<?, ?>> getStartFollowers(EObject context) {
			if (context instanceof ParserRule)
				return getParserRuleStartFollowers((ParserRule) context);
			else if (context instanceof Action)
				return getActionStartFollowers((Action) context);
			return Collections.emptyList();
		}

		@Override
		protected boolean isFinalState(EObject context, INFAState<?, ?> state, boolean returning, boolean canReturn) {
			if (context instanceof Action) {
				for (INFATransition<?, ?> transition : returning ? state.getOutgoingAfterReturn() : state.getOutgoing())
					if (transition.getTarget().getGrammarElement() == context)
						return true;
			} else if (canReturn && context instanceof ParserRule && state.isEndState()
					&& GrammarUtil.containingParserRule(state.getGrammarElement()) == context)
				return true;
			return false;

		}

		@Override
		protected List<INFAState<?, ?>> getFollowers(EObject context, INFAState<?, ?> state, boolean returning,
				boolean canReturn) {
			List<INFAState<?, ?>> result = Lists.newArrayList();
			for (INFATransition<?, ?> transition : returning ? state.getOutgoingAfterReturn() : state.getOutgoing()) {
				if (!GrammarUtil.isAssignedAction(transition.getTarget().getGrammarElement()))
					result.add(transition.getTarget());
				if (transition.isRuleCall())
					for (Action action : GrammarUtil.containedActions(GrammarUtil.containingRule(transition.getTarget()
							.getGrammarElement())))
						if (GrammarUtil.isAssignedAction(action))
							result.add(nfaProvider.getNFA(action));
			}
			return result;
		}
	}

	protected SequencerPDAProvider pdaProvider = createSequencerPDAProvider();

	protected boolean canReachAbsorber(IPDAState from, IPDAState to, Set<IPDAState> visited) {
		if (!visited.add(from))
			return false;
		for (IPDAState follower : from.getFollowers())
			if (follower == to)
				return true;
			else if (!isMandatoryAbsorber(follower.getGrammarElement()) && canReachAbsorber(follower, to, visited))
				return true;
		return false;
	}

	protected void collectFollowingAbsorberStates(IPDAState state, boolean collect, Set<IPDAState> visited,
			Set<IPDAState> absorber) {
		if (collect) {
			if (!visited.add(state))
				return;
			if (isMandatoryAbsorber(state.getGrammarElement()) || state.getType() == PDAStateType.STOP) {
				absorber.add(state);
				return;
			} else if (isOptionalAbsorber(state.getGrammarElement()))
				absorber.add(state);
		}
		for (IPDAState follower : state.getFollowers())
			collectFollowingAbsorberStates(follower, true, visited, absorber);
	}

	protected PDAAbsorberState createAbsorberState(IPDAState state, Map<IPDAState, PDAAbsorberState> absorbers,
			Map<PDAAbsorberState, Map<IPDAState, PDAEmitterState>> emitters) {
		PDAAbsorberState result = absorbers.get(state);
		if (result != null)
			return result;
		if (state.getType() == PDAStateType.STOP) {
			absorbers.put(state, result = createAbsorberState(PDAEmitterStateType.STOP, null));
			return result;
		}
		absorbers.put(state, result = createAbsorberState(getType(state), state.getGrammarElement()));
		Set<IPDAState> followers = Sets.newHashSet();
		collectFollowingAbsorberStates(state, false, Sets.<IPDAState> newHashSet(), followers);
		for (IPDAState follower : followers) {
			PDAAbsorberState target = createAbsorberState(follower, absorbers, emitters);
			PDATransition transition = createTransition(result, target);
			Map<IPDAState, PDAEmitterState> emitter = emitters.get(target);
			if (emitter == null)
				emitters.put(target, emitter = Maps.newHashMap());
			transition.setEmitters(createEmitterStates(state, follower, target, emitter));
			result.addTransition(transition);
		}
		return result;
	}

	protected PDAAbsorberState createAbsorberState(PDAEmitterStateType type, AbstractElement element) {
		return new PDAAbsorberState(type, element);
	}

	protected PDAEmitterState createEmitterState(PDAEmitterStateType type, AbstractElement element) {
		return new PDAEmitterState(type, element);
	}

	protected List<IPDAEmitterState> createEmitterStates(IPDAState from, IPDAState to, PDAAbsorberState target,
			Map<IPDAState, PDAEmitterState> emitters) {
		List<IPDAEmitterState> result = Lists.newArrayList();
		for (IPDAState next : from.getFollowers())
			if (next == to)
				result.add(target);
			else if (canReachAbsorber(next, to, Sets.<IPDAState> newHashSet())) {
				PDAEmitterState emitter = emitters.get(next);
				if (emitter == null) {
					emitters.put(next, emitter = createEmitterState(getType(next), next.getGrammarElement()));
					emitter.setFollowers(createEmitterStates(next, to, target, emitters));
				}
				result.add(emitter);
			}
		return result;
	}

	protected SequencerNFAProvider createSequenceParserNFAProvider() {
		return new SequencerNFAProvider();
	}

	protected SequencerPDAProvider createSequencerPDAProvider() {
		return new SequencerPDAProvider(createSequenceParserNFAProvider());
	}

	protected PDATransition createTransition(PDAAbsorberState source, PDAAbsorberState target) {
		return new PDATransition(source, target);
	}

	public IPDAAbsorberState getPDA(Action context) {
		Map<IPDAState, PDAAbsorberState> absorbers = Maps.newHashMap();
		Map<PDAAbsorberState, Map<IPDAState, PDAEmitterState>> emitters = Maps.newHashMap();
		return createAbsorberState(pdaProvider.getPDA(context), absorbers, emitters);
	}

	public IPDAAbsorberState getPDA(ParserRule context) {
		Map<IPDAState, PDAAbsorberState> absorbers = Maps.newHashMap();
		Map<PDAAbsorberState, Map<IPDAState, PDAEmitterState>> emitters = Maps.newHashMap();
		return createAbsorberState(pdaProvider.getPDA(context), absorbers, emitters);
	}

	protected PDAEmitterStateType getType(IPDAState state) {
		switch (state.getType()) {
			case ELEMENT:
				AbstractElement ele = state.getGrammarElement();
				Assignment ass;
				if (ele instanceof Action) {
					if (((Action) ele).getFeature() == null)
						return PDAEmitterStateType.UNASSIGEND_ACTION_CALL;
					else
						return PDAEmitterStateType.ASSIGNED_ACTION_CALL;
				} else if (GrammarUtil.containingCrossReference(ele) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return PDAEmitterStateType.ASSIGNED_CROSSREF_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return PDAEmitterStateType.ASSIGNED_CROSSREF_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return PDAEmitterStateType.ASSIGNED_CROSSREF_ENUM_RULE_CALL;
					} else if (ele instanceof Keyword)
						return PDAEmitterStateType.ASSIGNED_CROSSREF_KEYWORD;
				} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule) {
							if (rc.getRule().getType().getClassifier() instanceof EClass)
								return PDAEmitterStateType.ASSIGNED_PARSER_RULE_CALL;
							return PDAEmitterStateType.ASSIGNED_DATATYPE_RULE_CALL;
						}
						if (rc.getRule() instanceof TerminalRule)
							return PDAEmitterStateType.ASSIGNED_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return PDAEmitterStateType.ASSIGNED_ENUM_RULE_CALL;

					} else if (ele instanceof Keyword) {
						if (GrammarUtil.isBooleanAssignment(ass))
							return PDAEmitterStateType.ASSIGNED_BOOLEAN_KEYWORD;
						else
							return PDAEmitterStateType.ASSIGNED_KEYWORD;
					}
				} else {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return PDAEmitterStateType.UNASSIGNED_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return PDAEmitterStateType.UNASSIGNED_TERMINAL_RULE_CALL;
					} else if (ele instanceof Keyword)
						return PDAEmitterStateType.UNASSIGEND_KEYWORD;
				}
				break;
			case RULECALL_ENTER:
				return PDAEmitterStateType.UNASSIGNED_PARSER_RULE_ENTER;
			case RULECALL_EXIT:
				return PDAEmitterStateType.UNASSIGNED_PARSER_RULE_EXIT;
			case START:
				return PDAEmitterStateType.START;
			case STOP:
				return PDAEmitterStateType.STOP;
		}
		throw new RuntimeException("no type found for " + state);
	}

	protected boolean isMandatoryAbsorber(AbstractElement ele) {
		if (ele == null)
			return true;
		if (GrammarUtil.isAssigned(ele))
			return true;
		if (GrammarUtil.isAssignedAction(ele))
			return true;
		if (GrammarUtil.isDatatypeRuleCall(ele))
			return true;
		return false;
	}

	protected boolean isOptionalAbsorber(AbstractElement ele) {
		return true;
	}

}
