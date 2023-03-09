/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IAfterElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBeforeElement;
import org.eclipse.xtext.formatting.IElementMatcherProvider.IBetweenElements;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class MatcherState extends AbstractNFAState<MatcherState, MatcherTransition> {

	protected Set<IBetweenElements> afterBetweenElements;

	protected Set<IAfterElement> afterPatterns;

	protected Set<IBetweenElements> beforeBetweenElements;

	protected Set<IBeforeElement> beforePatterns;

	protected Boolean ruleCallOptional = null;

	public MatcherState(AbstractElement element, NFABuilder<MatcherState, MatcherTransition> builder) {
		super(element, builder);
	}

	/**
	 * @since 2.0
	 */
	public List<MatcherTransition> collectOutgoingTransitions() {
		outgoing = Lists.newArrayList();
		outgoingRuleCalls = Lists.newArrayList();
		collectOutgoing(element, Sets.<AbstractElement> newHashSet(), false, null);
		removeDuplicates(outgoing);
		removeDuplicates(outgoingRuleCalls);
		return outgoingRuleCalls.isEmpty() ? outgoing : outgoingRuleCalls;
	}

	public Set<IBetweenElements> getAfterBetweenElements() {
		if (afterBetweenElements == null)
			afterBetweenElements = Sets.newHashSet();
		return afterBetweenElements;
	}

	public Set<IAfterElement> getAfterPatterns() {
		if (afterPatterns == null)
			afterPatterns = Sets.newHashSet();
		return afterPatterns;
	}

	public Set<IBetweenElements> getBeforeBetweenElements() {
		if (beforeBetweenElements == null)
			beforeBetweenElements = Sets.newHashSet();
		return beforeBetweenElements;
	}

	public Set<IBeforeElement> getBeforePatterns() {
		if (beforePatterns == null)
			beforePatterns = Sets.newHashSet();
		return beforePatterns;
	}

	public boolean hasTransitions() {
		return isEndState() || !getOutgoing().isEmpty();
	}

	protected boolean isOptional(AbstractElement ele) {
		if (GrammarUtil.isOptionalCardinality(ele) || ele instanceof Action)
			return true;
		if (ele instanceof CompoundElement) {
			List<EObject> children = ele.eContents();
			if (children.isEmpty() && getBuilder().filter(ele))
				return true;
			if (ele instanceof Alternatives) {
				for (AbstractElement a : ((Alternatives) ele).getElements())
					if (isOptional(a))
						return true;
				return false;
			}
			for (EObject e : children)
				if (e instanceof AbstractElement && !isOptional((AbstractElement) e))
					return false;
			return true;
		} else
			return false;
	}

	public boolean isParserRuleCall() {
		return GrammarUtil.isEObjectRuleCall(element);
	}

	public boolean isParserRuleCallOptional() {
		if (ruleCallOptional == null)
			ruleCallOptional = isParserRuleCall() && isOptional(((RuleCall) element).getRule().getAlternatives());
		return ruleCallOptional;
	}
}
