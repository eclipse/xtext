/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collection;
import java.util.Collections;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverriddenValueInspector extends XtextRuleInspector<Void, ParserRule> {

	private Multimap<String, AbstractElement> assignedFeatures;

	public OverriddenValueInspector(ValidationMessageAcceptor acceptor) {
		super(acceptor);
		assignedFeatures = newMultimap();
	}

	@Override
	protected boolean canInspect(ParserRule rule) {
		if (GrammarUtil.isDatatypeRule(rule) || rule.getAlternatives() == null)
			return false;
		return super.canInspect(rule);
	}
	
	protected Multimap<String, AbstractElement> newMultimap() {
		return Multimaps.newLinkedHashMultimap();
	}

	@Override
	public Void caseAssignment(Assignment object) {
		if (GrammarUtil.isMultipleAssignment(object))
			return null;
		checkAssignment(object, object.getFeature());
		if (GrammarUtil.isMultipleCardinality(object))
			checkAssignment(object, object.getFeature());
		return null;
	}

	@Override
	public Void caseAction(Action object) {
		if (GrammarUtil.isMultipleAssignment(object))
			return null;
		assignedFeatures = newMultimap();
		if (object.getFeature() == null)
			return null;
		checkAssignment(object, object.getFeature());
		return null;
	}

	private void checkAssignment(AbstractElement object, String feature) {
		if (assignedFeatures.containsKey(feature)) {
			Collection<AbstractElement> sources = Lists.newArrayList(assignedFeatures.get(feature));
			assignedFeatures.replaceValues(feature, Iterables.<AbstractElement> emptyIterable());
			if (sources != null && sources.equals(Collections.singletonList(object))) {
				acceptWarning("The assigned value of feature '" + feature
						+ "' will possibly override itself because it is used inside of a loop.", object, null);
			}
			else {
				if (sources != null) {
					for (AbstractElement source : sources)
						acceptWarning("The possibly assigned value of feature '" + feature
								+ "' may be overridden by subsequent assignments.", source, null);
				}
				acceptWarning("This assignment will override the possibly assigned value of feature '"
						+ feature + "'.", object, null);
			}
		}
		else {
			assignedFeatures.put(feature, object);
		}
	}

	@Override
	public Void caseRuleCall(RuleCall object) {
		AbstractRule calledRule = object.getRule();
		if (calledRule == null || calledRule instanceof TerminalRule || calledRule instanceof EnumRule)
			return null;
		ParserRule parserRule = (ParserRule) calledRule;
		if (GrammarUtil.isDatatypeRule(parserRule))
			return null;
		if (!addVisited(parserRule))
			return null;
		Multimap<String, AbstractElement> prevAssignedFeatures = assignedFeatures;
		assignedFeatures = newMultimap();
		doSwitch(parserRule.getAlternatives());
		for (String feature : assignedFeatures.keySet())
			prevAssignedFeatures.put(feature, object);
		assignedFeatures = prevAssignedFeatures;
		removeVisited(parserRule);
		return null;
	}

	@Override
	public Void caseAlternatives(Alternatives object) {
		Multimap<String, AbstractElement> prevAssignedFeatures = assignedFeatures;
		Multimap<String, AbstractElement> mergedAssignedFeatures = newMultimap(prevAssignedFeatures);
		for (AbstractElement element : object.getGroups()) {
			assignedFeatures = newMultimap(prevAssignedFeatures);
			doSwitch(element);
			mergedAssignedFeatures.putAll(assignedFeatures);
		}
		assignedFeatures = mergedAssignedFeatures;
		if (GrammarUtil.isMultipleCardinality(object)) {
			prevAssignedFeatures = assignedFeatures;
			for (AbstractElement element : object.getGroups()) {
				assignedFeatures = newMultimap(prevAssignedFeatures);
				doSwitch(element);
				mergedAssignedFeatures.putAll(assignedFeatures);
			}
			assignedFeatures = mergedAssignedFeatures;
		}
		return null;
	}

	private Multimap<String, AbstractElement> newMultimap(Multimap<String, AbstractElement> from) {
		return Multimaps.newLinkedHashMultimap(from);
	}

	@Override
	public Void caseGroup(Group object) {
		Multimap<String, AbstractElement> prevAssignedFeatures = newMultimap(assignedFeatures);
		for (AbstractElement element : object.getTokens()) {
			doSwitch(element);
		}
		if (GrammarUtil.isMultipleCardinality(object)) {
			for (AbstractElement element : object.getTokens()) {
				doSwitch(element);
			}
		}
		if (GrammarUtil.isOptionalCardinality(object))
			assignedFeatures.putAll(prevAssignedFeatures);
		return null;
	}
}