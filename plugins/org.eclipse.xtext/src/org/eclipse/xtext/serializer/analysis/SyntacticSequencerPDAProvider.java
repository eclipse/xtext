/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
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
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.sequencer.RuleCallStack;
import org.eclipse.xtext.util.formallang.ITokenPdaAdapter;
import org.eclipse.xtext.util.formallang.NfaToGrammar;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.PdaUtil;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class SyntacticSequencerPDAProvider implements ISyntacticSequencerPDAProvider {

	protected static class NavigablePDA implements ITokenPdaAdapter<ISynState, RuleCall, AbstractElement> {

		protected ISynNavigable navigable;

		public NavigablePDA(ISynNavigable navigable) {
			super();
			this.navigable = navigable;
		}

		public Iterable<ISynState> getFinalStates() {
			return Collections.<ISynState> singleton(navigable.getTarget());
		}

		public Iterable<ISynState> getFollowers(ISynState node) {
			if (node instanceof ISynAbsorberState) {
				if (navigable instanceof ISynTransition && ((ISynTransition) navigable).getSource() == node)
					return navigable.getFollowers();
				return Collections.emptyList();
			}
			return node.getFollowers();
		}

		public RuleCall getPop(ISynState state) {
			return state.getType().getSimpleType() == PDAStateType.RULECALL_EXIT ? (RuleCall) state.getGrammarElement()
					: null;
		}

		public RuleCall getPush(ISynState state) {
			return state.getType().getSimpleType() == PDAStateType.RULECALL_ENTER ? (RuleCall) state
					.getGrammarElement() : null;
		}

		public Iterable<ISynState> getStartStates() {
			if (navigable instanceof ISynTransition)
				return Collections.<ISynState> singleton(((ISynTransition) navigable).getSource());
			return Collections.singleton((ISynState) navigable);
		}

		public AbstractElement getToken(ISynState owner) {
			return owner.getGrammarElement();
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

	public static class SequencerPDAContext {
		protected EObject context;
		protected EClass type;

		public SequencerPDAContext(EObject context, EClass type) {
			super();
			this.context = context;
			this.type = type;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			SequencerPDAContext other = (SequencerPDAContext) obj;
			return context == other.context && type == other.type;
		}

		public EObject getContext() {
			return context;
		}

		public EClass getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return context.hashCode() + (type == null ? 0 : type.hashCode());
		}
	}

	public static class SequencerPDAProvider extends AbstractPDAProvider<SequencerPDAContext> {

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

		@Override
		protected boolean canPass(SequencerPDAContext context, INFAState<?, ?> state, EClass constructedType) {
			AbstractElement ele = state.getGrammarElement();
			if (ele instanceof Action)
				return ((Action) ele).getType().getClassifier() == context.getType();
			if (constructedType != null)
				return true;
			if (GrammarUtil.containingAssignment(ele) != null)
				return GrammarUtil.containingRule(ele).getType().getClassifier() == context.getType();
			return true;
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
		protected List<INFAState<?, ?>> getFollowers(SequencerPDAContext context, INFAState<?, ?> state,
				boolean returning, boolean canReturn) {
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

		protected List<INFAState<?, ?>> getParserRuleStartFollowers(ParserRule rule) {
			List<INFAState<?, ?>> result = Lists.newArrayList();
			for (INFAState<?, ?> state : getAllRuleStartFollowers(rule))
				if (canReachEndState(state, Sets.newHashSet()))
					result.add(state);
			return result;
		}

		@Override
		protected List<INFAState<?, ?>> getStartFollowers(SequencerPDAContext context) {
			if (context.getContext() instanceof ParserRule)
				return getParserRuleStartFollowers((ParserRule) context.getContext());
			else if (context.getContext() instanceof Action)
				return getActionStartFollowers((Action) context.getContext());
			return Collections.emptyList();
		}

		@Override
		protected boolean isFinalState(SequencerPDAContext context, INFAState<?, ?> state, boolean returning,
				boolean canReturn) {
			if (context.getContext() instanceof Action) {
				for (INFATransition<?, ?> transition : returning ? state.getOutgoingAfterReturn() : state.getOutgoing())
					if (transition.getTarget().getGrammarElement() == context.getContext())
						return true;
			} else if (canReturn && context.getContext() instanceof ParserRule && state.isEndState()
					&& GrammarUtil.containingParserRule(state.getGrammarElement()) == context.getContext())
				return true;
			return false;

		}
	}

	protected static class SynAbsorberState extends SynState implements ISynAbsorberState {

		protected EObject context;

		protected EClass eClass;

		protected Map<AbstractElement, ISynTransition> outTransitionsByElement = Maps.newHashMap();

		protected Map<AbstractElement, ISynTransition> outTransitionsByRuleCallEnter = Maps.newHashMap();

		protected Map<AbstractElement, ISynTransition> outTransitionsByRuleCallExit = Maps.newHashMap();

		public SynAbsorberState(SynStateType type, AbstractElement element, EObject context, EClass eClass) {
			super(type, element);
			this.context = context;
			this.eClass = eClass;
		}

		protected void addTransition(ISynTransition transition) {
			addFollower(transition.getFollowers());
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

		public EObject getContext() {
			return context;
		}

		public EClass getEClass() {
			return eClass;
		}

		public List<ISynTransition> getOutTransitions() {
			List<ISynTransition> result = Lists.newArrayList();
			result.addAll(outTransitionsByElement.values());
			result.addAll(outTransitionsByRuleCallEnter.values());
			result.addAll(outTransitionsByRuleCallExit.values());
			return result;
		}

		public Map<AbstractElement, ISynTransition> getOutTransitionsByElement() {
			return outTransitionsByElement;
		}

		public Map<AbstractElement, ISynTransition> getOutTransitionsByRuleCallEnter() {
			return outTransitionsByRuleCallEnter;
		}

		public Map<AbstractElement, ISynTransition> getOutTransitionsByRuleCallExit() {
			return outTransitionsByRuleCallExit;
		}

	}

	protected static class SynEmitterState extends SynNavigable implements ISynEmitterState {

		public SynEmitterState(SynStateType type, AbstractElement element, SynAbsorberState target) {
			super(type, element, target);
		}

	}

	protected static class SynNavigable extends SynState implements ISynNavigable {

		protected final static List<ISynState> RULE_EXIT_DEPENDENT = Lists.newArrayList();

		protected int distanceToAbsorber = -1;

		protected Boolean involvesRuleExit;

		protected Boolean involvesUnassignedTokenRuleCalls = null;

		protected List<ISynState> shortestPathToAbsorber = null;

		protected Boolean syntacticallyAmbiguous = null;

		protected ISynAbsorberState target;

		public SynNavigable(SynStateType type, AbstractElement element, ISynAbsorberState target) {
			super(type, element);
			this.target = target;
		}

		public EObject getContext() {
			return target.getContext();
		}

		public EClass getEClass() {
			return target.getEClass();
		}

		public ITokenPdaAdapter<ISynState, RuleCall, AbstractElement> getPathToTarget() {
			return new NavigablePDA(this);
		}

		public List<ISynState> getShortestPathTo(final AbstractElement ele, RuleCallStack stack) {
			return shortestPathTo(stack.iterator(), new Predicate<ISynState>() {
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele;
				}
			}, true);
		}

		public List<ISynState> getShortestPathToAbsorber(RuleCallStack stack) {
			if (involvesRuleExit())
				return shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()), false);
			if (shortestPathToAbsorber == null)
				shortestPathToAbsorber = shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()),
						false);
			return shortestPathToAbsorber;
		}

		public List<ISynState> getShortestStackpruningPathTo(final AbstractElement ele, RuleCallStack stack) {
			return shortestStackpruningPathTo(stack.iterator(), new Predicate<ISynState>() {
				public boolean apply(ISynState input) {
					return input.getGrammarElement() == ele;
				}
			}, true);
		}

		public List<ISynState> getShortestStackpruningPathToAbsorber(RuleCallStack stack) {
			if (involvesRuleExit())
				return shortestStackpruningPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()), false);
			if (shortestPathToAbsorber == null)
				shortestPathToAbsorber = shortestPathTo(stack.iterator(), Predicates.<ISynState> equalTo(getTarget()),
						false);
			return shortestPathToAbsorber;
		}

		public ISynAbsorberState getTarget() {
			return target;
		}

		public boolean hasEmitters() {
			if (getFollowers().size() == 1 && getFollowers().get(0) instanceof ISynAbsorberState)
				return false;
			return true;
		}

		protected boolean involves(ISynState from, Set<SynStateType> types, Set<ISynState> visited) {
			if (types.contains(from.getType()))
				return true;
			if (!visited.add(from))
				return false;
			for (ISynState state : from.getFollowers())
				if (!(state instanceof ISynAbsorberState) && involves(state, types, visited))
					return true;
			return false;
		}

		protected boolean involves(Set<SynStateType> types) {
			Set<ISynState> visited = Sets.newHashSet();
			for (ISynState state : followers)
				if (involves(state, types, visited))
					return true;
			return false;
		}

		protected Boolean involvesRuleExit() {
			if (involvesRuleExit == null)
				involvesRuleExit = involves(EnumSet.of(SynStateType.UNASSIGNED_PARSER_RULE_EXIT));
			return involvesRuleExit;
		}

		public boolean involvesUnassignedTokenRuleCalls() {
			if (involvesUnassignedTokenRuleCalls == null)
				involvesUnassignedTokenRuleCalls = involves(EnumSet.of(SynStateType.UNASSIGNED_DATATYPE_RULE_CALL,
						SynStateType.UNASSIGNED_TERMINAL_RULE_CALL));
			return involvesUnassignedTokenRuleCalls;
		}

		public boolean isSyntacticallyAmbiguous() {
			if (syntacticallyAmbiguous == null)
				syntacticallyAmbiguous = isSyntacticallyAmbiguous(followers);
			return syntacticallyAmbiguous;
		}

		protected boolean isSyntacticallyAmbiguous(ISynState state, RuleCallStack exits, RuleCallStack stack,
				List<RuleCallStack> results, Set<ISynState> visited) {
			if (!visited.add(state))
				return true;
			if (state instanceof ISynAbsorberState) {
				results.add(exits);
				return false;
			}
			switch (state.getType().getSimpleType()) {
				case RULECALL_ENTER:
					stack = stack.cloneAndPush((RuleCall) state.getGrammarElement());
					break;
				case RULECALL_EXIT:
					RuleCall rc = (RuleCall) state.getGrammarElement();
					if (!stack.isEmpty()) {
						if (rc == stack.peek())
							stack = stack.cloneAndPop();
						else
							return false;
					} else {
						if (exits.contains(rc))
							return false;
						else {
							visited = Sets.newHashSet();
							exits = exits.cloneAndPush(rc);
						}
					}
					break;
				default:
					break;
			}
			for (ISynState follower : state.getFollowers())
				if (isSyntacticallyAmbiguous(follower, exits, stack, results, visited))
					return true;
			return false;
		}

		protected boolean isSyntacticallyAmbiguous(List<ISynState> states) {
			RuleCallStack exits = new RuleCallStack();
			RuleCallStack stack = new RuleCallStack();
			List<RuleCallStack> results = Lists.newArrayList();
			Set<ISynState> visited = Sets.newHashSet();
			for (ISynState state : states)
				if (isSyntacticallyAmbiguous(state, exits, stack, results, visited))
					return true;
			return results.size() != Sets.newHashSet(results).size();
		}

		protected List<ISynState> shortestPathTo(Iterator<RuleCall> stack, Predicate<ISynState> matches,
				boolean includeMatch) {
			List<ISynState> pathTo = new PdaUtil().shortestPathTo(getPathToTarget(), stack, matches);
			if (pathTo != null)
				return pathTo.subList(1, pathTo.size() - (includeMatch ? 0 : 1));
			return null;
		}

		protected List<ISynState> shortestStackpruningPathTo(Iterator<RuleCall> stack, Predicate<ISynState> matches,
				boolean includeMatch) {
			List<ISynState> pathTo = new PdaUtil().shortestStackpruningPathTo(getPathToTarget(), stack, matches);
			if (pathTo != null)
				return pathTo.subList(1, pathTo.size() - (includeMatch ? 0 : 1));
			return null;
		}

	}

	protected abstract static class SynState implements ISynState {

		protected AbstractElement element;

		protected List<ISynState> followers = Collections.emptyList();

		protected SynStateType type;

		public SynState(SynStateType type, AbstractElement element) {
			super();
			this.type = type;
			this.element = element;
			this.followers = Collections.emptyList();
		}

		protected void addFollower(ISynState follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.add(follower);
		}

		protected void addFollower(List<ISynState> follower) {
			if (followers.isEmpty())
				followers = Lists.newArrayList();
			followers.addAll(follower);
		}

		public List<ISynState> getFollowers() {
			return followers;
		}

		public AbstractElement getGrammarElement() {
			return element;
		}

		public SynStateType getType() {
			return type;
		}

		protected void setFollowers(List<ISynState> followers) {
			this.followers = followers;
		}

		@Override
		public String toString() {
			if (type == null)
				return "(type is null)";
			GrammarElementTitleSwitch titles = new GrammarElementTitleSwitch().showAssignments();
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

	protected static class SynTransition extends SynNavigable implements ISynTransition {

		private final class Filter implements Predicate<ISynState> {
			public boolean apply(ISynState input) {
				AbstractElement ge = input.getGrammarElement();
				return ge instanceof Keyword || GrammarUtil.isDatatypeRuleCall(ge) || GrammarUtil.isEnumRuleCall(ge)
						|| GrammarUtil.isTerminalRuleCall(ge);
			}
		}

		protected static final AbstractElementAlias UNINITIALIZED = new TokenAlias(false, false, null);

		protected AbstractElementAlias ambiguousSyntax = UNINITIALIZED;

		protected ISynAbsorberState source;

		public SynTransition(ISynAbsorberState source, ISynAbsorberState target) {
			super(SynStateType.TRANSITION, null, target);
			this.source = source;
		}

		public AbstractElementAlias getAmbiguousSyntax() {
			if (ambiguousSyntax != UNINITIALIZED)
				return ambiguousSyntax;
			ambiguousSyntax = getShortSyntax();
			if (ambiguousSyntax instanceof GroupAlias) {
				GroupAlias group = (GroupAlias) ambiguousSyntax;
				List<AbstractElementAlias> children = group.getChildren();
				int start = 0;
				while (start < children.size() && children.get(start) instanceof TokenAlias
						&& !children.get(start).isMany() && !children.get(start).isOptional())
					start++;
				int end = children.size() - 1;
				while (end >= 0 && children.get(end) instanceof TokenAlias && !children.get(end).isMany()
						&& !children.get(end).isOptional())
					end--;
				if (start <= end) {
					ambiguousSyntax = group = new GroupAlias(false, false, children.subList(start, end + 1));
					if (group.children.size() == 1)
						ambiguousSyntax = group.children.get(0);
				} else
					ambiguousSyntax = null;
			}
			return ambiguousSyntax;
		}

		public AbstractElementAlias getShortSyntax() {
			return new NfaToGrammar().nfaToGrammar(new NfaUtil().filter(getPathToTarget(), new Filter()),
					new GrammarAlias.GrammarAliasFactory());
		}

		public ISynAbsorberState getSource() {
			return source;
		}

		public AbstractElementAlias getSyntax() {
			return new NfaToGrammar().nfaToGrammar(getPathToTarget(), new GrammarAlias.GrammarAliasFactory());
		}

		@Override
		public String toString() {
			return getSyntax().toString();
		}

	}

	protected Map<SequencerPDAContext, ISynAbsorberState> cache = Maps.newHashMap();

	protected SequencerPDAProvider pdaProvider = createSequencerPDAProvider();

	protected boolean canReachAbsorber(IPDAState from, IPDAState to, Set<IPDAState> visited) {
		if (isMandatoryAbsorber(from.getGrammarElement()) || !visited.add(from))
			return false;
		for (IPDAState follower : from.getFollowers())
			if (follower == to)
				return true;
			else if (canReachAbsorber(follower, to, visited))
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

	protected SynAbsorberState createAbsorberState(IPDAState state, Map<IPDAState, SynAbsorberState> absorbers,
			Map<SynAbsorberState, Map<IPDAState, SynState>> emitters, EObject context, EClass eClass) {
		SynAbsorberState result = absorbers.get(state);
		if (result != null)
			return result;
		if (state.getType() == PDAStateType.STOP) {
			absorbers.put(state, result = createAbsorberState(SynStateType.STOP, null, context, eClass));
			return result;
		}
		absorbers.put(state, result = createAbsorberState(getType(state), state.getGrammarElement(), context, eClass));
		Set<IPDAState> followers = Sets.newHashSet();
		collectFollowingAbsorberStates(state, false, Sets.<IPDAState> newHashSet(), followers);
		for (IPDAState follower : followers) {
			SynAbsorberState target = createAbsorberState(follower, absorbers, emitters, context, eClass);
			SynTransition transition = createTransition(result, target);
			Map<IPDAState, SynState> emitter = emitters.get(target);
			if (emitter == null)
				emitters.put(target, emitter = Maps.newHashMap());
			transition.setFollowers(createEmitterStates(state, follower, target, emitter));
			result.addTransition(transition);
		}
		return result;
	}

	protected SynAbsorberState createAbsorberState(SynStateType type, AbstractElement element, EObject context,
			EClass eClass) {
		return new SynAbsorberState(type, element, context, eClass);
	}

	protected SynState createEmitterState(SynStateType type, AbstractElement element, SynAbsorberState target) {
		return new SynEmitterState(type, element, target);
	}

	protected List<ISynState> createEmitterStates(IPDAState from, IPDAState to, SynAbsorberState target,
			Map<IPDAState, SynState> emitters) {
		List<ISynState> result = Lists.newArrayList();
		for (IPDAState next : from.getFollowers())
			if (next == to)
				result.add(target);
			else if (canReachAbsorber(next, to, Sets.<IPDAState> newHashSet())) {
				SynState emitter = emitters.get(next);
				if (emitter == null) {
					emitters.put(next, emitter = createEmitterState(getType(next), next.getGrammarElement(), target));
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

	protected SynTransition createTransition(SynAbsorberState source, SynAbsorberState target) {
		return new SynTransition(source, target);
	}

	public ISynAbsorberState getPDA(EObject context, EClass type) {
		SequencerPDAContext ctx = new SequencerPDAContext(context, type);
		ISynAbsorberState result = cache.get(ctx);
		if (result == null) {
			Map<IPDAState, SynAbsorberState> absorbers = Maps.newHashMap();
			Map<SynAbsorberState, Map<IPDAState, SynState>> emitters = Maps.newHashMap();
			result = createAbsorberState(pdaProvider.getPDA(ctx), absorbers, emitters, context, type);
			cache.put(ctx, result);
		}
		return result;
	}

	protected SynStateType getType(IPDAState state) {
		switch (state.getType()) {
			case ELEMENT:
				AbstractElement ele = state.getGrammarElement();
				Assignment ass;
				if (ele instanceof Action) {
					if (((Action) ele).getFeature() == null)
						return SynStateType.UNASSIGEND_ACTION_CALL;
					else
						return SynStateType.ASSIGNED_ACTION_CALL;
				} else if (GrammarUtil.containingCrossReference(ele) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return SynStateType.ASSIGNED_CROSSREF_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.ASSIGNED_CROSSREF_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return SynStateType.ASSIGNED_CROSSREF_ENUM_RULE_CALL;
					} else if (ele instanceof Keyword)
						return SynStateType.ASSIGNED_CROSSREF_KEYWORD;
				} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule) {
							if (rc.getRule().getType().getClassifier() instanceof EClass)
								return SynStateType.ASSIGNED_PARSER_RULE_CALL;
							return SynStateType.ASSIGNED_DATATYPE_RULE_CALL;
						}
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.ASSIGNED_TERMINAL_RULE_CALL;
						if (rc.getRule() instanceof EnumRule)
							return SynStateType.ASSIGNED_ENUM_RULE_CALL;

					} else if (ele instanceof Keyword) {
						if (GrammarUtil.isBooleanAssignment(ass))
							return SynStateType.ASSIGNED_BOOLEAN_KEYWORD;
						else
							return SynStateType.ASSIGNED_KEYWORD;
					}
				} else {
					if (ele instanceof RuleCall) {
						RuleCall rc = (RuleCall) ele;
						if (rc.getRule() instanceof ParserRule)
							return SynStateType.UNASSIGNED_DATATYPE_RULE_CALL;
						if (rc.getRule() instanceof TerminalRule)
							return SynStateType.UNASSIGNED_TERMINAL_RULE_CALL;
					} else if (ele instanceof Keyword)
						return SynStateType.UNASSIGEND_KEYWORD;
				}
				break;
			case RULECALL_ENTER:
				return SynStateType.UNASSIGNED_PARSER_RULE_ENTER;
			case RULECALL_EXIT:
				return SynStateType.UNASSIGNED_PARSER_RULE_EXIT;
			case START:
				return SynStateType.START;
			case STOP:
				return SynStateType.STOP;
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
		//		if (GrammarUtil.isDatatypeRuleCall(ele))
		//			return true;
		return false;
	}

	protected boolean isOptionalAbsorber(AbstractElement ele) {
		return false;
	}

}
