/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import static com.google.common.collect.Iterables.*;
import static org.eclipse.xtext.GrammarUtil.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.INFAState;
import org.eclipse.xtext.grammaranalysis.INFATransition;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AbstractNFAState<S extends INFAState<S, T>, T extends INFATransition<S, T>> extends AdapterImpl implements
		INFAState<S, T> {

	protected NFABuilder<S, T> builder;

	protected final AbstractElement element;

	protected boolean endState = false;

	protected List<T> outgoing;

	protected List<T> outgoingRuleCalls;

	public AbstractNFAState(AbstractElement element, NFABuilder<S, T> builder) {
		super();
		this.element = element;
		this.builder = builder;
	}

	@SuppressWarnings("unchecked")
	protected void addFollower(AbstractElement ele) {
		if (filter(ele)) {
			collectCalledRules(ele);
			collectFollowers(ele);
		} else {
			outgoing.add(builder.getTransition((S) this, builder.getState(ele), false));
		}
	}

	protected void collectAllFollowers() {
		if (filter(element))
			outgoing = outgoingRuleCalls = Collections.emptyList();
		else {
			outgoing = new ArrayList<T>();
			outgoingRuleCalls = new ArrayList<T>();
			collectCalledRules(element);
			collectFollowers(element);
			removeDuplicates(outgoing);
			removeDuplicates(outgoingRuleCalls);
		}
	}

	@SuppressWarnings("unchecked")
	protected void collectCalledRules(AbstractElement ele) {
		List<RuleCall> calls = new ArrayList<RuleCall>();
		if (ele instanceof RuleCall)
			calls.add((RuleCall) ele);
		// else if (ele instanceof Assignment)
		// calls.addAll(GrammarUtil.containedRuleCalls(ele));
		for (RuleCall r : calls)
			if (r.getRule() instanceof ParserRule) {
				ParserRule pr = (ParserRule) r.getRule();
				if (!GrammarUtil.isDatatypeRule(pr))
					outgoingRuleCalls
							.add(builder.getTransition((S) this, builder.getState(pr.getAlternatives()), true));
			}
	}

	protected void collectFollowers(AbstractElement ele) {
		if (ele instanceof Group || ele instanceof UnorderedGroup) {
			List<AbstractElement> elements = ((CompoundElement) ele).getElements();
			switch (builder.getDirection()) {
				case FORWARD:
					for (int i = 0; i < elements.size(); i++) {
						addFollower(elements.get(i));
						if (!GrammarUtil.isOptionalCardinality(elements.get(i)))
							break;
					}
					break;
				case BACKWARD:
					for (int i = elements.size() - 1; i >= 0; i--) {
						addFollower(elements.get(i));
						if (!GrammarUtil.isOptionalCardinality(elements.get(i)))
							break;
					}
					break;
			}
		} else if (ele instanceof Alternatives)
			for (AbstractElement e : ((Alternatives) ele).getElements())
				addFollower(e);
		else if (ele instanceof Assignment)
			addFollower(((Assignment) ele).getTerminal());
		else if (ele instanceof CrossReference)
			addFollower(((CrossReference) ele).getTerminal());
		else {
			if (GrammarUtil.isMultipleCardinality(ele) && !filter(ele))
				addFollower(ele);
			collectFollowersOther(ele);
		}
	}

	protected void collectFollowersOther(AbstractElement ele) {
		if (ele.eContainer() instanceof Alternatives) {
			Alternatives cntAlt = (Alternatives) ele.eContainer();
			if (GrammarUtil.isMultipleCardinality(cntAlt))
				addFollower(cntAlt);
			collectFollowersOther(cntAlt);
		} else if (ele.eContainer() instanceof Group || ele.eContainer() instanceof UnorderedGroup) {
			AbstractElement container = (AbstractElement) ele.eContainer();
			List<AbstractElement> siblings = ((CompoundElement) container).getElements();
			int i = siblings.indexOf(ele);
			switch (builder.getDirection()) {
				case FORWARD:
					if ((i + 1) >= siblings.size()) {
						if (GrammarUtil.isMultipleCardinality(container))
							addFollower(container);
						collectFollowersOther(container);
					} else {
						AbstractElement next = siblings.get(i + 1);
						addFollower(next);
						if (GrammarUtil.isOptionalCardinality(next))
							collectFollowersOther(next);
					}
					break;
				case BACKWARD:
					if (i <= 0) {
						if (GrammarUtil.isMultipleCardinality(container))
							addFollower(container);
						collectFollowersOther(container);
					} else {
						AbstractElement next = siblings.get(i - 1);
						addFollower(next);
						if (GrammarUtil.isOptionalCardinality(next))
							collectFollowersOther(next);
					}
					break;
			}
		} else if (ele.eContainer() instanceof Assignment) {
			Assignment cntAss = (Assignment) ele.eContainer();
			if (GrammarUtil.isMultipleCardinality(cntAss))
				addFollower(cntAss);
			collectFollowersOther(cntAss);
		} else if (ele.eContainer() instanceof CrossReference) {
			CrossReference cntAss = (CrossReference) ele.eContainer();
			if (GrammarUtil.isMultipleCardinality(cntAss))
				addFollower(cntAss);
			collectFollowersOther(cntAss);
		} else if (ele.eContainer() instanceof AbstractRule)
			endState = true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected void collectReferencesToThis(S match, Set<Object> visited, List<T> following) {
		if (!visited.add(this))
			return;
		for (T transition : concat(getOutgoing(), getOutgoingAfterReturn()))
			if (!transition.isRuleCall()) {
				((AbstractNFAState) transition.getTarget()).collectReferencesToThis(match, visited, following);
				if (transition.getTarget() == match)
					following.add(transition);
			}
	}

	protected boolean filter(AbstractElement ele) {
		if (ele.eContainer() instanceof AbstractRule)
			return false;
		return builder.filter(ele);
	}

	public NFABuilder<S, T> getBuilder() {
		return builder;
	}

	public AbstractElement getGrammarElement() {
		return element;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> getIncommingWithoutRuleCalls() {
		List<T> result = Lists.newArrayList();
		AbstractElement rootEle = containingRule(element).getAlternatives();
		((AbstractNFAState) builder.getState(rootEle)).collectReferencesToThis(this, Sets.newHashSet(), result);
		return result;
	}

	public List<T> getOutgoing() {
		if (outgoing == null || outgoingRuleCalls == null)
			collectAllFollowers();
		return outgoingRuleCalls.size() == 0 ? outgoing : outgoingRuleCalls;
	}

	public List<T> getOutgoingAfterReturn() {
		if (outgoing == null || outgoingRuleCalls == null)
			collectAllFollowers();
		return outgoingRuleCalls.size() == 0 ? outgoingRuleCalls : outgoing;
	}

	public boolean isEndState() {
		if (outgoing == null || outgoingRuleCalls == null)
			collectAllFollowers();
		return endState;
	}

	public boolean isStartState() {
		return element.eContainer() instanceof AbstractRule;
	}

	protected void removeDuplicates(List<T> list) {
		for (int i = list.size() - 2; i >= 0; i--) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					list.remove(i);
					break;
				}
			}
		}
	}

}