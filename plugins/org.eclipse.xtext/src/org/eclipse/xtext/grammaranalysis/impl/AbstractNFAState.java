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
import org.eclipse.emf.ecore.EObject;
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
	protected void addOutgoing(AbstractElement ele) {
		if (filter(ele)) {
			collectOutgoingRuleCalls(ele);
			collectOutgoing(ele);
		} else {
			outgoing.add(builder.getTransition((S) this, builder.getState(ele), false));
		}
	}

	protected void collectAllOutgoingTransitions() {
		if (filter(element))
			outgoing = outgoingRuleCalls = Collections.emptyList();
		else {
			outgoing = new ArrayList<T>();
			outgoingRuleCalls = new ArrayList<T>();
			collectOutgoingRuleCalls(element);
			collectOutgoing(element);
			removeDuplicates(outgoing);
			removeDuplicates(outgoingRuleCalls);
		}
	}

	protected void collectOutgoing(AbstractElement element) {
		if (element instanceof Group || element instanceof UnorderedGroup) {
			List<AbstractElement> elements = ((CompoundElement) element).getElements();
			switch (builder.getDirection()) {
				case FORWARD:
					throw new UnsupportedOperationException();
					//					for (int i = 0; i < elements.size(); i++) {
					//						addOutgoing(elements.get(i));
					//						if (!GrammarUtil.isOptionalCardinality(elements.get(i)))
					//							break;
					//					}
					//				break;
				case BACKWARD:
					int i = elements.size() - 1;
					while (i >= 0) {
						addOutgoing(elements.get(i));
						if (!GrammarUtil.isOptionalCardinality(elements.get(i)))
							break;
						i--;
					}
					// add transitions to the next sibling of this element if all children are optional
					if (i < 0)
						collectOutgoingByContainer(element);
					break;
			}
		} else if (element instanceof Alternatives)
			for (AbstractElement e : ((Alternatives) element).getElements())
				addOutgoing(e);
		else if (element instanceof Assignment)
			addOutgoing(((Assignment) element).getTerminal());
		else if (element instanceof CrossReference)
			addOutgoing(((CrossReference) element).getTerminal());
		else {
			if (GrammarUtil.isMultipleCardinality(element) && !filter(element))
				addOutgoing(element);
			collectOutgoingByContainer(element);
		}
	}

	protected void collectOutgoingByContainer(AbstractElement element) {
		EObject container = element.eContainer();
		if (container instanceof Group || container instanceof UnorderedGroup) {
			CompoundElement compoundContainer = (CompoundElement) container;
			List<AbstractElement> siblings = compoundContainer.getElements();
			int i = siblings.indexOf(element);
			switch (builder.getDirection()) {
				case FORWARD:
					if ((i + 1) >= siblings.size()) {
						if (GrammarUtil.isMultipleCardinality(compoundContainer))
							addOutgoing(compoundContainer);
						collectOutgoingByContainer(compoundContainer);
					} else {
						AbstractElement next = siblings.get(i + 1);
						addOutgoing(next);
						if (GrammarUtil.isOptionalCardinality(next))
							collectOutgoingByContainer(next);
					}
					break;
				case BACKWARD:
					if (i <= 0) {
						if (GrammarUtil.isMultipleCardinality(compoundContainer))
							addOutgoing(compoundContainer);
						collectOutgoingByContainer(compoundContainer);
					} else {
						AbstractElement next = siblings.get(i - 1);
						addOutgoing(next);
						if (GrammarUtil.isOptionalCardinality(next))
							collectOutgoingByContainer(next);
					}
					break;
			}
		} else if (container instanceof AbstractRule)
			endState = true;
		else if (container instanceof AbstractElement) {
			AbstractElement elementContainer = (AbstractElement) container;
			if (GrammarUtil.isMultipleCardinality(elementContainer))
				addOutgoing(elementContainer);
			collectOutgoingByContainer(elementContainer);
		} else
			throw new IllegalStateException("Unknown container: " + container);
	}

	@SuppressWarnings("unchecked")
	protected void collectOutgoingRuleCalls(AbstractElement element) {
		if (element instanceof RuleCall && ((RuleCall) element).getRule() instanceof ParserRule) {
			ParserRule rule = (ParserRule) ((RuleCall) element).getRule();
			if (!GrammarUtil.isDatatypeRule(rule))
				outgoingRuleCalls.add(builder.getTransition((S) this, builder.getState(rule.getAlternatives()), true));
		}
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
			collectAllOutgoingTransitions();
		return outgoingRuleCalls.isEmpty() ? outgoing : outgoingRuleCalls;
	}

	public List<T> getOutgoingAfterReturn() {
		if (outgoing == null || outgoingRuleCalls == null)
			collectAllOutgoingTransitions();
		return outgoingRuleCalls.isEmpty() ? Collections.<T> emptyList() : outgoing;
	}

	public boolean isEndState() {
		if (outgoing == null || outgoingRuleCalls == null)
			collectAllOutgoingTransitions();
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