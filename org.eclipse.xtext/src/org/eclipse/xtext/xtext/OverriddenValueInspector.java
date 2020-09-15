/*******************************************************************************
 * Copyright (c) 2009, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverriddenValueInspector extends XtextRuleInspector<Boolean, ParserRule> {

	public static final String ISSUE_CODE = "OverriddenValueInspector.potentialOverride";
	
	private Multimap<String, AbstractElement> assignedFeatures;
	
	/**
	 * Remember all visited rules in case the grammar is broken, e.g. has
	 * no assignments (yet).
	 */
	private Set<AbstractRule> permanentlyVisited;
	
	private Set<RuleCall> fragmentStack;
	
	private Map<AbstractRule, ImmutableMultimap<String, AbstractElement>> assignedFeaturesAtEnd;
	
	public OverriddenValueInspector(ValidationMessageAcceptor acceptor) {
		super(acceptor);
		assignedFeatures = newMultimap();
		assignedFeaturesAtEnd = new HashMap<>();
		permanentlyVisited = Sets.newHashSet();
		fragmentStack = Sets.newHashSet();
	}
	
	@Override
	protected String getIssueCode() {
		return ISSUE_CODE;
	}
	
	@Override
	public boolean addVisited(AbstractRule rule) {
		return permanentlyVisited.add(rule) && super.addVisited(rule);
	}
	
	@Override
	protected boolean canInspect(ParserRule rule) {
		if (GrammarUtil.isDatatypeRule(rule) || rule.getAlternatives() == null)
			return false;
		return super.canInspect(rule);
	}
	
	@Override
	protected Boolean doInspect(ParserRule rule) {
		permanentlyVisited.clear();
		fragmentStack.clear();
		assignedFeatures.clear();
		visitedRules.clear();
		return doSwitch(rule.getAlternatives());
	}
	
	protected Multimap<String, AbstractElement> newMultimap() {
		return LinkedHashMultimap.create();
	}

	@Override
	public Boolean caseAssignment(Assignment object) {
		if (GrammarUtil.isMultipleAssignment(object))
			return Boolean.FALSE;
		checkAssignment(object, object.getFeature());
		if (GrammarUtil.isMultipleCardinality(object))
			checkAssignment(object, object.getFeature());
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseAction(Action object) {
		if (!fragmentStack.isEmpty()) {
			return Boolean.TRUE;
		}
		assignedFeatures = newMultimap();
		if (GrammarUtil.isMultipleAssignment(object))
			return null;
		if (object.getFeature() == null)
			return Boolean.FALSE;
		checkAssignment(object, object.getFeature());
		return Boolean.FALSE;
	}

	private void checkAssignment(AbstractElement object, String feature) {
		if (assignedFeatures.containsKey(feature)) {
			Collection<AbstractElement> sources = Lists.newArrayList(assignedFeatures.get(feature));
			assignedFeatures.replaceValues(feature, Collections.<AbstractElement> emptyList());
			if (sources != null && sources.equals(Collections.singletonList(object))) {
				if (getNestingLevel() == 0 && fragmentStack.isEmpty()) {
					if (object instanceof RuleCall) {
						acceptWarning("The fragment will possibly override the assigned value of feature '" + feature
								+ "' it is used inside of a loop.", object, null);
					} else {
						acceptWarning("The assigned value of feature '" + feature
								+ "' will possibly override itself because it is used inside of a loop.", object, null);
					}
				}
			}
			else {
				if (sources != null) {
					if (getNestingLevel() == 0 && fragmentStack.isEmpty()) {
						for (AbstractElement source : sources) {
							acceptWarning("The possibly assigned value of feature '" + feature
									+ "' may be overridden by subsequent assignments.", source, null);
						}
					}
				}
				if (getNestingLevel() == 0 && fragmentStack.isEmpty()) {
					if (object instanceof RuleCall) {
						acceptWarning("The fragment will potentially override the possibly assigned value of feature '"
								+ feature + "'.", object, null);
					} else {
						acceptWarning("This assignment will override the possibly assigned value of feature '"
								+ feature + "'.", object, null);
					}
				}
			}
		}
		else {
			assignedFeatures.put(feature, object);
		}
	}

	@Override
	public Boolean caseRuleCall(RuleCall object) {
		AbstractRule calledRule = object.getRule();
		if (calledRule == null || calledRule.eIsProxy() || calledRule instanceof TerminalRule || calledRule instanceof EnumRule)
			return Boolean.FALSE;
		ParserRule parserRule = (ParserRule) calledRule;
		if (GrammarUtil.isDatatypeRule(parserRule))
			return Boolean.FALSE;
		if (parserRule.isFragment()) {
			visitFragment(object);
			if (GrammarUtil.isMultipleCardinality(object))
				visitFragment(object);
		}
		if (!addVisited(parserRule))
			return Boolean.FALSE;
		Multimap<String, AbstractElement> prevAssignedFeatures = assignedFeatures;
		
		// Cannot use #computeIfAbsent since we will call this recursively and that causes ConcurrentModificationExceptions
		ImmutableMultimap<String, AbstractElement> assignedInCalledRule = assignedFeaturesAtEnd.get(parserRule);
		if (assignedInCalledRule == null) {
			assignedFeatures = newMultimap();
			doSwitch(parserRule.getAlternatives());
			assignedInCalledRule = ImmutableMultimap.copyOf(assignedFeatures);
			assignedFeaturesAtEnd.put(parserRule, assignedInCalledRule);
		}
		for (String feature : assignedInCalledRule.keySet())
			prevAssignedFeatures.put(feature, object);
		assignedFeatures = prevAssignedFeatures;
		removeVisited(parserRule);
		return Boolean.FALSE;
	}

	private void visitFragment(RuleCall object) {
		Multimap<String, AbstractElement> prevAssignedFeatures = assignedFeatures;
		assignedFeatures = newMultimap();
		if (fragmentStack.add(object)) {
			try {
				doSwitch(object.getRule().getAlternatives());
			} finally {
				fragmentStack.remove(object);
			}
		}
		Multimap<String, AbstractElement> assignedByFragment = assignedFeatures;
		assignedFeatures = prevAssignedFeatures;
		for (String feature : assignedByFragment.keySet())
			checkAssignment(object, feature);
	}

	@Override
	public Boolean caseAlternatives(Alternatives object) {
		Multimap<String, AbstractElement> prevAssignedFeatures = assignedFeatures;
		Multimap<String, AbstractElement> mergedAssignedFeatures = LinkedHashMultimap.create();
		Set<AbstractRule> prevPermanentlyVisited = permanentlyVisited;
		Set<AbstractRule> mergedPermanentlyVisited = Sets.newHashSet();
		boolean allAborted = true;
		for (AbstractElement element : object.getElements()) {
			assignedFeatures = newMultimap(prevAssignedFeatures);
			permanentlyVisited = Sets.newHashSet(prevPermanentlyVisited);
			if (!doSwitch(element)) {
				allAborted = false;
			}
			mergedAssignedFeatures.putAll(assignedFeatures);
			mergedPermanentlyVisited.addAll(prevPermanentlyVisited);
		}
		if (GrammarUtil.isOptionalCardinality(object)) {
			mergedAssignedFeatures.putAll(prevAssignedFeatures);
		}
		assignedFeatures = mergedAssignedFeatures;
		if (!allAborted && GrammarUtil.isMultipleCardinality(object)) {
			prevAssignedFeatures = assignedFeatures;
			for (AbstractElement element : object.getElements()) {
				assignedFeatures = newMultimap(prevAssignedFeatures);
				permanentlyVisited = Sets.newHashSet(prevPermanentlyVisited);
				doSwitch(element);
				mergedAssignedFeatures.putAll(assignedFeatures);
			}
			assignedFeatures = mergedAssignedFeatures;
		}
		permanentlyVisited = mergedPermanentlyVisited;
		return Boolean.FALSE;
	}

	private Multimap<String, AbstractElement> newMultimap(Multimap<String, AbstractElement> from) {
		return LinkedHashMultimap.create(from);
	}
	
	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseCompoundElement(CompoundElement object) {
		Multimap<String, AbstractElement> prevAssignedFeatures = newMultimap(assignedFeatures);
		for (AbstractElement element : object.getElements()) {
			if (doSwitch(element)) {
				if (GrammarUtil.isOptionalCardinality(object))
					assignedFeatures.putAll(prevAssignedFeatures);
				return Boolean.TRUE;
			}
		}
		if (GrammarUtil.isMultipleCardinality(object)) {
			for (AbstractElement element : object.getElements()) {
				doSwitch(element);
			}
		}
		if (GrammarUtil.isOptionalCardinality(object))
			assignedFeatures.putAll(prevAssignedFeatures);
		return Boolean.FALSE;
	}
	
}