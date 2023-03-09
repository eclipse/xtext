/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.grammaranalysis.INFAState;
import org.eclipse.xtext.grammaranalysis.IPDAProvider;
import org.eclipse.xtext.grammaranalysis.IPDAState;
import org.eclipse.xtext.grammaranalysis.IPDAState.PDAStateType;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractPDAProvider<CTX> implements IPDAProvider<CTX> {

	protected static class PDAContext<CTX> {
		protected CTX context;
		protected Map<INFAState<?, ?>, PDAState> elements = Maps.newHashMap();
		protected Map<INFAState<?, ?>, PDAState> ruleCallEnter = Maps.newHashMap();
		protected Map<INFAState<?, ?>, PDAState> ruleCallExit = Maps.newHashMap();
		protected PDAState start;
		protected PDAState stop;

		/**
		 * @since 2.0
		 */
		public PDAContext(CTX context) {
			super();
			this.context = context;
		}

		protected void setStart(PDAState start) {
			this.start = start;
		}

		protected void setStop(PDAState stop) {
			this.stop = stop;
		}
	}

	protected static class PDAState implements IPDAState {

		protected AbstractElement element;

		protected Set<IPDAState> followers = Collections.emptySet();

		protected PDAStateType type;

		public PDAState(PDAStateType type, AbstractElement element) {
			super();
			this.type = type;
			this.element = element;
		}

		@Override
		public Collection<IPDAState> getFollowers() {
			return followers;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return element;
		}

		@Override
		public PDAStateType getType() {
			return type;
		}

		@Override
		public String toString() {
			if (type == null)
				return "(type is null)";
			GrammarElementTitleSwitch title = new GrammarElementTitleSwitch().showAssignments();
			switch (type) {
				case ELEMENT:
					return title.doSwitch(element);
				case RULECALL_ENTER:
					return ">>" + title.doSwitch(element);
				case RULECALL_EXIT:
					return "<<" + title.doSwitch(element);
				case START:
					return "start";
				case STOP:
					return "stop";
			}
			return super.toString();
		}

	}

	protected static class RuleCallStackElement {
		protected RuleCallStackElement parent;
		protected INFAState<?, ?> ruleCall;
		protected boolean stopCheck = false;

		public RuleCallStackElement(RuleCallStackElement parent, INFAState<?, ?> ruleCall) {
			super();
			this.parent = parent;
			this.ruleCall = ruleCall;
		}

		protected RuleCallStackElement getParent() {
			return parent;
		}

		public boolean hasEnteredTwice(INFAState<?, ?> element) {
			RuleCallStackElement e = this;
			int count = 0;
			while (e != null) {
				if (e.ruleCall == element) {
					count++;
					if (count >= 2)
						return true;
				}
				e = e.parent;
			}
			return false;
		}

		public RuleCallStackElement cloneWithoutVisited() {
			RuleCallStackElement result = new RuleCallStackElement(parent, ruleCall);
			result.stopCheck = true;
			return result;
		}

		protected INFAState<?, ?> getRuleCall() {
			return ruleCall;
		}

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			RuleCallStackElement e = this;
			while (e != null) {
				result.add((e.stopCheck ? "!" : "") + e.getRuleCall());
				e = e.parent;
			}
			return result.toString();
		}
	}

	protected abstract boolean canEnterRuleCall(INFAState<?, ?> state);

	/**
	 * @since 2.0
	 */
	protected abstract boolean canPass(CTX context, INFAState<?, ?> state, EClass constructedType);

	/**
	 * @since 2.0
	 */
	protected EClass getConstructedType(AbstractElement ele) {
		if (ele instanceof Action)
			return (EClass) ((Action) ele).getType().getClassifier();
		if (GrammarUtil.containingAssignment(ele) != null)
			return (EClass) GrammarUtil.containingRule(ele).getType().getClassifier();
		return null;
	}

	protected boolean canReachContextEnd(PDAContext<CTX> context, RuleCallStackElement stack, INFAState<?, ?> fromNfa,
			EClass constructedType, boolean returning, boolean canReturn, Set<Pair<Boolean, INFAState<?, ?>>> visited) {
		if (stack == null || !visited.add(Tuples.<Boolean, INFAState<?, ?>> create(returning, fromNfa)))
			return false;

		if (!canPass(context.context, fromNfa, constructedType))
			return false;
		else if (constructedType == null)
			constructedType = getConstructedType(fromNfa.getGrammarElement());

		if (isFinalState(context.context, fromNfa, returning, canReturn))
			return true;

		if (!returning && canEnterRuleCall(fromNfa)) {
			if (stack.hasEnteredTwice(fromNfa))
				return false;
			stack = stackPush(stack, fromNfa);
			visited = Sets.newHashSet();
		}

		for (INFAState<?, ?> follower : getFollowers(context.context, fromNfa, returning, canReturn)) {
			boolean targetCanReturn = !canEnterRuleCall(follower);
			boolean targetReturning = follower.hasOutgoingRuleCall() && targetCanReturn;
			if (canReachContextEnd(context, stack, follower, constructedType, targetReturning, targetCanReturn, visited))
				return true;
		}

		if (canReturn && fromNfa.isEndState() && stack != null && stack.getRuleCall() != null) {
			visited = Sets.newHashSet();
			if (canReachContextEnd(context, stack.getParent(), stack.getRuleCall(), constructedType, true, true,
					visited))
				return true;
		}
		return false;
	}

	/**
	 * @since 2.0
	 */
	protected PDAContext<CTX> createContext(CTX obj) {
		return new PDAContext<CTX>(obj);
	}

	protected PDAState createState(IPDAState.PDAStateType type, AbstractElement element) {
		return new PDAState(type, element);
	}

	/**
	 * @since 2.0
	 */
	protected PDAState createState(PDAContext<CTX> ctx, RuleCallStackElement stack, INFAState<?, ?> fromNfa,
			EClass constructedType, boolean returning, boolean canReturn, Set<Pair<Boolean, INFAState<?, ?>>> visited) {
		Set<Pair<Boolean, INFAState<?, ?>>> visited2 = Sets.newHashSet();
		if (stack == null
				|| !canReachContextEnd(ctx, stack.cloneWithoutVisited(), fromNfa, constructedType, returning,
						canReturn, visited2))
			return null;
		if (constructedType == null)
			constructedType = getConstructedType(fromNfa.getGrammarElement());
		AbstractElement ge = fromNfa.getGrammarElement();
		PDAState result = null;
		if (canEnterRuleCall(fromNfa)) {
			if (returning) {
				if ((result = ctx.ruleCallExit.get(fromNfa)) == null)
					ctx.ruleCallExit.put(fromNfa, result = createState(PDAStateType.RULECALL_EXIT, ge));
			} else {
				if ((result = ctx.ruleCallEnter.get(fromNfa)) == null)
					ctx.ruleCallEnter.put(fromNfa, result = createState(PDAStateType.RULECALL_ENTER, ge));
			}
		} else {
			if ((result = ctx.elements.get(fromNfa)) == null)
				ctx.elements.put(fromNfa, result = createState(PDAStateType.ELEMENT, ge));
		}
		if (!visited.add(Tuples.<Boolean, INFAState<?, ?>> create(returning, fromNfa)))
			return result;

		if (!returning && canEnterRuleCall(fromNfa)) {
			if (stack.hasEnteredTwice(fromNfa))
				return result;
			stack = stackPush(stack, fromNfa);
			visited = Sets.newHashSet();
		}
		if (result.followers == null || result.followers == Collections.EMPTY_SET) {
			result.followers = Sets.newHashSet();
		}
		if (isFinalState(ctx.context, fromNfa, returning, canReturn))
			result.followers.add(ctx.stop);

		for (INFAState<?, ?> follower : getFollowers(ctx.context, fromNfa, returning, canReturn)) {
			boolean folCanReturn = !canEnterRuleCall(follower);
			boolean folReturning = follower.hasOutgoingRuleCall() && folCanReturn;
			PDAState r = createState(ctx, stack, follower, constructedType, folReturning, folCanReturn, visited);
			if (r != null)
				result.followers.add(r);
		}

		if (canReturn && fromNfa.isEndState() && stack != null && stack.getRuleCall() != null) {
			visited = Sets.newHashSet();
			PDAState r = createState(ctx, stack.getParent(), stack.getRuleCall(), constructedType, true, true, visited);
			if (r != null)
				result.followers.add(r);
		}
		return result;
	}

	/**
	 * @since 2.0
	 */
	@Override
	public IPDAState getPDA(CTX context) {
		PDAContext<CTX> ctx = createContext(context);
		ctx.start = createState(IPDAState.PDAStateType.START, null);
		ctx.stop = createState(IPDAState.PDAStateType.STOP, null);
		Set<Pair<Boolean, INFAState<?, ?>>> visited = Sets.newHashSet();
		ctx.start.followers = Sets.newHashSet();
		for (INFAState<?, ?> state : getStartFollowers(context)) {
			boolean targetCanReturn = !canEnterRuleCall(state);
			boolean targetReturning = !state.getOutgoingAfterReturn().isEmpty() && targetCanReturn;
			RuleCallStackElement stack = new RuleCallStackElement(null, null);
			IPDAState s = createState(ctx, stack, state, null, targetReturning, targetCanReturn, visited);
			if (s != null)
				ctx.start.followers.add(s);
		}
		return ctx.start;
	}

	/**
	 * @since 2.0
	 */
	protected abstract List<INFAState<?, ?>> getStartFollowers(CTX context);

	protected PDAState getState(PDAContext<CTX> ctx, INFAState<?, ?> state, boolean returning) {
		PDAState result = ctx.elements.get(state);
		if (result == null) {
			if (returning)
				result = ctx.ruleCallExit.get(state);
			else
				result = ctx.ruleCallEnter.get(state);
		}
		return result;
	}

	protected abstract boolean isFinalState(CTX context, INFAState<?, ?> state, boolean returning, boolean canReturn);

	/**
	 * @since 2.0
	 */
	protected abstract List<INFAState<?, ?>> getFollowers(CTX context, INFAState<?, ?> state, boolean returning,
			boolean canReturn);

	protected RuleCallStackElement stackPush(RuleCallStackElement stack, INFAState<?, ?> value) {
		return new RuleCallStackElement(stack, value);
	}

}
