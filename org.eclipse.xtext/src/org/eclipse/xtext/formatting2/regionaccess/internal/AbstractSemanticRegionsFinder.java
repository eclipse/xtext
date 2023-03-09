/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractSemanticRegionsFinder implements ISemanticRegionsFinder {

	protected static class FeaturePredicate implements Predicate<ISemanticRegion> {

		private final String name;
		private final EClass type;

		public FeaturePredicate(EStructuralFeature feature) {
			this.name = feature.getName();
			this.type = feature.getEContainingClass();
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			EObject element = input.getGrammarElement();
			Assignment assignment = GrammarUtil.containingAssignment(element);
			if (assignment == null || !name.equals(assignment.getFeature()))
				return false;
			EObject semanticElement = input.getSemanticElement();
			return type.isInstance(semanticElement);
		}

	}

	protected static class GrammarElementPredicate implements Predicate<ISemanticRegion> {
		private final EObject grammarElement;

		public GrammarElementPredicate(EObject grammarElement) {
			super();
			this.grammarElement = grammarElement;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			return input.getGrammarElement() == grammarElement;
		}

		@Override
		public String toString() {
			String string = new GrammarElementTitleSwitch().showRule().showQualified().doSwitch(grammarElement);
			return "Predicate[" + string + "]";
		}

	}

	protected static class GrammarElementsPredicate implements Predicate<ISemanticRegion> {
		private final Set<? extends EObject> grammarElements;

		public GrammarElementsPredicate(Set<? extends EObject> grammarElements) {
			super();
			this.grammarElements = grammarElements;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			return grammarElements.contains(input.getGrammarElement());
		}

		@Override
		public String toString() {
			List<String> strings = Lists.newArrayList();
			GrammarElementTitleSwitch toString = new GrammarElementTitleSwitch().showRule().showQualified();
			for (EObject ele : grammarElements)
				strings.add(toString.doSwitch(ele));
			return "Predicate[" + Joiner.on(", ").join(strings) + "]";
		}
	}

	protected static class KeywordPredicate implements Predicate<ISemanticRegion> {
		private final String keyword;

		public KeywordPredicate(String keyword) {
			super();
			this.keyword = keyword;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			EObject element = input.getGrammarElement();
			return element instanceof Keyword && keyword.equals(((Keyword) element).getValue());
		}

		@Override
		public String toString() {
			return "Predicate[" + keyword + "]";
		}
	}

	protected static class KeywordsPredicate implements Predicate<ISemanticRegion> {
		private final Set<String> keywords;

		public KeywordsPredicate(Set<String> keywords) {
			super();
			this.keywords = keywords;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			EObject element = input.getGrammarElement();
			return element instanceof Keyword && keywords.contains(((Keyword) element).getValue());
		}

		@Override
		public String toString() {
			return "Predicate[" + Joiner.on(", ").join(keywords) + "]";
		}
	}

	protected static class RulePredicate implements Predicate<ISemanticRegion> {
		private final AbstractRule rule;

		public RulePredicate(AbstractRule rule) {
			super();
			this.rule = rule;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			EObject element = input.getGrammarElement();
			return element instanceof RuleCall && ((RuleCall) element).getRule() == rule;
		}

		@Override
		public String toString() {
			return "Predicate[" + rule.getName() + "]";
		}
	}

	protected static class RulesPredicate implements Predicate<ISemanticRegion> {
		private final Set<AbstractRule> rules;

		public RulesPredicate(Set<AbstractRule> rules) {
			super();
			this.rules = rules;
		}

		@Override
		public boolean apply(ISemanticRegion input) {
			if (input == null)
				return false;
			EObject element = input.getGrammarElement();
			return element instanceof RuleCall && rules.contains(((RuleCall) element).getRule());
		}

		@Override
		public String toString() {
			List<String> strings = Lists.newArrayList();
			for (AbstractRule rule : rules)
				strings.add(rule.getName());
			return "Predicate[" + Joiner.on(", ").join(strings) + "]";
		}
	}

	protected void assertNoContainment(EStructuralFeature feat) {
		if (!(feat instanceof EAttribute) && !(feat instanceof EReference && !((EReference) feat).isContainment()))
			throw new IllegalStateException("Only EAttributes and CrossReferences allowed.");
	}

	protected void assertNoEObjectRule(AbstractRule rule) {
		if (GrammarUtil.isEObjectRule(rule))
			throw new IllegalStateException("Only Enum, Datatype and Terminal Rule Calls allowed.");
	}

	protected void assertNoEObjectRuleCall(RuleCall ruleCall) {
		assertNoEObjectRule(ruleCall.getRule());
	}

	@Override
	public ISemanticRegion assignment(Assignment assignment) {
		return findFirst(createPredicate(assignment));
	}

	@Override
	public List<ISemanticRegion> assignments(Assignment... assignments) {
		return findAll(createPredicate(assignments));
	}

	protected void collectMatchableElements(AbstractElement ele, Collection<AbstractElement> result) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.RULE_CALL:
				assertNoEObjectRuleCall((RuleCall) ele);
			case XtextPackage.KEYWORD:
				result.add(ele);
				break;
			case XtextPackage.CROSS_REFERENCE:
				collectMatchableElements(((CrossReference) ele).getTerminal(), result);
				break;
			case XtextPackage.ASSIGNMENT:
				collectMatchableElements(((Assignment) ele).getTerminal(), result);
				break;
			case XtextPackage.ALTERNATIVES:
			case XtextPackage.GROUP:
			case XtextPackage.UNORDERED_GROUP:
				for (AbstractElement child : ((CompoundElement) ele).getElements())
					collectMatchableElements(child, result);
				break;
		}
	}

	protected Predicate<ISemanticRegion> createPredicate(AbstractElement ele) {
		switch (ele.eClass().getClassifierID()) {
			case XtextPackage.RULE_CALL:
				assertNoEObjectRuleCall((RuleCall) ele);
			case XtextPackage.KEYWORD:
				return new GrammarElementPredicate(ele);
		}
		return createPredicate(new AbstractElement[] { ele });
	}

	protected Predicate<ISemanticRegion> createPredicate(AbstractElement... ele) {
		Set<AbstractElement> result = Sets.newHashSet();
		for (AbstractElement e : ele)
			collectMatchableElements(e, result);
		switch (result.size()) {
			case 0:
				return Predicates.alwaysFalse();
			case 1:
				return new GrammarElementPredicate(result.iterator().next());
			default:
				return new GrammarElementsPredicate(result);
		}
	}

	@Override
	public ISemanticRegion crossRef(CrossReference crossReference) {
		return findFirst(createPredicate(crossReference));
	}

	@Override
	public List<ISemanticRegion> crossRefs(CrossReference... crossReferences) {
		return findAll(createPredicate(crossReferences));
	}

	@Override
	public ISemanticRegion element(AbstractElement element) {
		return findFirst(createPredicate(element));
	}

	@Override
	public List<ISemanticRegion> elements(AbstractElement... elements) {
		return findAll(createPredicate(elements));
	}

	@Override
	public ISemanticRegion feature(EStructuralFeature feature) {
		assertNoContainment(feature);
		return findFirst(new FeaturePredicate(feature));
	}

	@Override
	public List<ISemanticRegion> features(EStructuralFeature... features) {
		Set<Predicate<ISemanticRegion>> predicates = Sets.newHashSet();
		for (int i = 0; i < features.length; i++) {
			EStructuralFeature feat = features[i];
			assertNoContainment(feat);
			predicates.add(new FeaturePredicate(feat));
		}
		return findAll(Predicates.or(predicates));
	}

	protected abstract ImmutableList<ISemanticRegion> findAll(Predicate<ISemanticRegion> predicate);

	protected abstract ISemanticRegion findFirst(Predicate<ISemanticRegion> predicate);

	@Override
	public ISemanticRegion keyword(Keyword keyword) {
		return findFirst(createPredicate(keyword));
	}

	@Override
	public ISemanticRegion keyword(String keyword) {
		return findFirst(new KeywordPredicate(keyword));
	}

	@Override
	public List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(Keyword kw1, Keyword kw2) {
		Preconditions.checkNotNull(kw1);
		Preconditions.checkNotNull(kw2);
		Preconditions.checkArgument(kw1 != kw2);
		Predicate<ISemanticRegion> p1 = createPredicate(kw1);
		Predicate<ISemanticRegion> p2 = createPredicate(kw2);
		List<ISemanticRegion> all = findAll(Predicates.or(p1, p2));
		Builder<Pair<ISemanticRegion, ISemanticRegion>> result = ImmutableList.builder();
		LinkedList<ISemanticRegion> stack = new LinkedList<ISemanticRegion>();
		for (ISemanticRegion region : all) {
			if (p1.apply(region))
				stack.push(region);
			else if (!stack.isEmpty())
				result.add(Pair.of(stack.pop(), region));
		}
		return result.build();
	}

	@Override
	public List<Pair<ISemanticRegion, ISemanticRegion>> keywordPairs(String kw1, String kw2) {
		Preconditions.checkNotNull(kw1);
		Preconditions.checkNotNull(kw2);
		Preconditions.checkArgument(!kw1.equals(kw2));
		Predicate<ISemanticRegion> p1 = new KeywordPredicate(kw1);
		Predicate<ISemanticRegion> p2 = new KeywordPredicate(kw2);
		List<ISemanticRegion> all = findAll(Predicates.or(p1, p2));
		Builder<Pair<ISemanticRegion, ISemanticRegion>> result = ImmutableList.builder();
		LinkedList<ISemanticRegion> stack = new LinkedList<ISemanticRegion>();
		for (ISemanticRegion region : all) {
			if (p1.apply(region))
				stack.push(region);
			else {
				AbstractRule regionRule = GrammarUtil.containingRule(region.getGrammarElement());
				while (!stack.isEmpty()) {
					ISemanticRegion candidate = stack.pop();
					if (region.getSemanticElement() == candidate.getSemanticElement()) {
						AbstractRule candidateRule = GrammarUtil.containingRule(candidate.getGrammarElement());
						if (regionRule == candidateRule) {
							result.add(Pair.of(candidate, region));
							break;
						}
					}
				}
			}
		}
		return result.build();
	}

	@Override
	public List<ISemanticRegion> keywords(Keyword... keywords) {
		return findAll(createPredicate(keywords));
	}

	@Override
	public List<ISemanticRegion> keywords(String... keywords) {
		Predicate<ISemanticRegion> predicate;
		if (keywords.length == 1)
			predicate = new KeywordPredicate(keywords[0]);
		else
			predicate = new KeywordsPredicate(Sets.newHashSet(keywords));
		return findAll(predicate);
	}

	@Override
	public ISemanticRegion ruleCall(RuleCall ruleCall) {
		return findFirst(createPredicate(ruleCall));
	}

	@Override
	public List<ISemanticRegion> ruleCalls(RuleCall... ruleCalls) {
		return findAll(createPredicate(ruleCalls));
	}

	@Override
	public List<ISemanticRegion> ruleCallsTo(AbstractRule... rules) {
		for (int i = 0; i < rules.length; i++)
			assertNoEObjectRule(rules[i]);
		Predicate<ISemanticRegion> predicate;
		if (rules.length == 1)
			predicate = new RulePredicate(rules[0]);
		else
			predicate = new RulesPredicate(Sets.newHashSet(rules));
		return findAll(predicate);
	}

	@Override
	public ISemanticRegion ruleCallTo(AbstractRule rule) {
		assertNoEObjectRule(rule);
		return findFirst(new RulePredicate(rule));
	}

}
