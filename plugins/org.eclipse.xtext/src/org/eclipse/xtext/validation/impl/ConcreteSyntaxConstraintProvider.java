/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import static org.eclipse.xtext.GrammarUtil.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ConcreteSyntaxConstraintProvider implements IConcreteSyntaxConstraintProvider {
	public class SyntaxConstraintNode implements ISyntaxConstraint {
		protected ISyntaxConstraint container = null;
		protected List<ISyntaxConstraint> contents;
		protected AbstractElement element;
		protected List<AbstractElement> lazyContents;
		protected boolean multiple = false;
		protected boolean optional = false;
		protected EClass semanticType = null;
		protected ConstraintType type;

		public SyntaxConstraintNode(ConstraintType type, AbstractElement ele, List<AbstractElement> lazyContents,
				List<ISyntaxConstraint> eagerContents, EClass semanticType, boolean multiple, boolean optional) {
			super();
			if (type == null)
				throw new NullPointerException("type must not be null");
			this.type = type;
			this.element = ele;
			this.semanticType = semanticType;
			this.multiple = multiple;
			this.optional = optional;
			this.contents = eagerContents;
			this.lazyContents = lazyContents;
			for (ISyntaxConstraint e : contents)
				((SyntaxConstraintNode) e).container = this;
		}

		public boolean dependsOn(ISyntaxConstraint ele) {
			ISyntaxConstraint cnt = findCommonContainer(ele);
			while (ele != cnt) {
				if (ele.isOptional())
					return false;
				ele = ele.getContainer();
			}
			return true;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof SyntaxConstraintNode)
				return ((SyntaxConstraintNode) obj).element == element;
			return false;
		}

		public ISyntaxConstraint findCommonContainer(ISyntaxConstraint obj1) {
			ISyntaxConstraint cnt1 = obj1;
			while (cnt1 != null) {
				ISyntaxConstraint cnt2 = this;
				while (cnt2 != null) {
					if (cnt1.equals(cnt2))
						return cnt1;
					cnt2 = cnt2.getContainer();
				}
				cnt1 = cnt1.getContainer();
			}
			return null;
		}

		public EStructuralFeature getAssignmentFeature(EClass clazz) {
			String name = getAssignmentName();
			EStructuralFeature f = clazz.getEStructuralFeature(name);
			if (f == null)
				throw new RuntimeException("Feature " + name + " not found for " + clazz.getName());
			return f;
		}

		public String getAssignmentName() {
			if (type != ConstraintType.ASSIGNMENT)
				throw new RuntimeException("Constraint '" + this + "' is not an assignment, but a " + getType());
			return ((Assignment) element).getFeature();
		}

		public String getCardinality() {
			return optional ? (multiple ? "*" : "?") : (multiple ? "+" : "");
		}

		public ISyntaxConstraint getContainer() {
			return container;
		}

		public List<ISyntaxConstraint> getContents() {
			if (lazyContents != null) {
				for (EObject obj : lazyContents) {
					ISyntaxConstraint e = createElement(obj);
					if (e != null) {
						((SyntaxConstraintNode) e).container = this;
						contents.add(e);
					}
				}
				lazyContents = null;
			}
			return contents;
		}

		public AbstractElement getGrammarElement() {
			return element;
		}

		public EClass getSemanticType() {
			return semanticType;
		}

		public ConstraintType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return element.hashCode();
		}

		public boolean isMultiple() {
			return multiple;
		}

		public boolean isOptional() {
			return optional;
		}

		public boolean isRoot() {
			return container == null;
		}

		@Override
		public String toString() {
			return toString(null);
		}

		public String toString(final Map<ISyntaxConstraint, String> postfix) {
			String t = getSemanticType() == null ? "" : getSemanticType().getName() + ":";
			String p = postfix != null && postfix.containsKey(this) ? postfix.get(this) : "";
			Iterable<String> contents = Iterables.transform(getContents(), new Function<ISyntaxConstraint, String>() {
				public String apply(ISyntaxConstraint from) {
					return from.toString(postfix);
				}
			});
			switch (getType()) {
				case ASSIGNMENT:
					return t + ((Assignment) element).getFeature() + p + getCardinality();
				case GROUP:
					return t + "(" + Join.join(" ", contents) + ")" + p + getCardinality();
				case ALTERNATIVE:
					return t + "(" + Join.join("|", contents) + ")" + p + getCardinality();
				case ACTION:
					return "{" + ((Action) element).getType().getClassifier().getName() + "}" + p;
			}
			return "";
		}
	}

	@Inject
	private IGrammarAccess grammar;
	private Map<ParserRule, ISyntaxConstraint> rule2element = Maps.newHashMap();
	private Map<EClass, List<ISyntaxConstraint>> type2Elements = Maps.newHashMap();
	private Set<ParserRule> validRules;

	protected void collectReachableRules(ParserRule pr, Set<ParserRule> rules, Set<ParserRule> visited) {
		if (!visited.add(pr))
			return;
		for (RuleCall rc : GrammarUtil.containedRuleCalls(pr))
			if (isParserRule(rc.getRule())) {
				if (GrammarUtil.containingAssignment(rc) != null)
					rules.add((ParserRule) rc.getRule());
				collectReachableRules((ParserRule) rc.getRule(), rules, visited);
			}
	}

	protected boolean containsRelevantElement(AbstractElement ele) {
		Iterator<EObject> i = Iterators.concat(Collections.singleton(ele).iterator(), ele.eAllContents());
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Action || o instanceof Assignment)
				return true;
			if (o instanceof RuleCall && containsRelevantElement(((RuleCall) o).getRule().getAlternatives()))
				return true;
		}
		return false;
	}

	protected ISyntaxConstraint createElement(ConstraintType type, AbstractElement ele, EClass semanticType,
			boolean multiple, boolean optional) {
		List<AbstractElement> ctns = ele instanceof CompoundElement ? ((CompoundElement) ele).getElements() : null;
		return createElement(type, ele, ctns, new ArrayList<ISyntaxConstraint>(), semanticType, multiple, optional);
	}

	protected ISyntaxConstraint createElement(ConstraintType type, AbstractElement ele,
			List<AbstractElement> lazyContents, List<ISyntaxConstraint> eagerContents, EClass semanticType,
			boolean multiple, boolean optional) {
		return new SyntaxConstraintNode(type, ele, lazyContents, eagerContents, semanticType, multiple, optional);
	}

	protected ISyntaxConstraint createElement(EObject obj) {
		if (!(obj instanceof AbstractElement))
			return null;
		AbstractElement ele = (AbstractElement) obj;
		boolean multiple = false;
		boolean optional = false;
		EClass semanticType = null;
		while (true) {
			multiple = multiple || isMultipleCardinality(ele);
			optional = optional || isOptionalCardinality(ele);
			if (ele.eContainer() instanceof ParserRule
					&& ((ParserRule) ele.eContainer()).getType().getClassifier() instanceof EClass)
				semanticType = (EClass) ((ParserRule) ele.eContainer()).getType().getClassifier();
			if (ele instanceof Assignment) {
				return createElement(ConstraintType.ASSIGNMENT, ele, semanticType, multiple, optional);
			} else if (ele instanceof Group || ele instanceof UnorderedGroup) {
				CompoundElement comp = (CompoundElement) ele;
				AbstractElement lastChild = null;
				for (AbstractElement o : comp.getElements())
					if (containsRelevantElement(o)) {
						if (lastChild == null)
							lastChild = o;
						else {
							List<AbstractElement> c = new ArrayList<AbstractElement>(comp.getElements());
							List<ISyntaxConstraint> e = createSummarizedAssignments(comp, c, semanticType, optional);
							if (e.size() == 1 && c.size() == 0)
								return e.get(0);
							return createElement(ConstraintType.GROUP, ele, c, e, semanticType, multiple, optional);
						}
					}
				ele = lastChild;
				continue;
			} else if (ele instanceof Alternatives) {
				int relevantChildren = 0;
				AbstractElement lastChild = null;
				for (AbstractElement o : ((CompoundElement) ele).getElements())
					if (containsRelevantElement(o)) {
						relevantChildren++;
						lastChild = o;
					}
				if (relevantChildren < ((CompoundElement) ele).getElements().size())
					optional = true;
				if (relevantChildren > 1)
					return createElement(ConstraintType.ALTERNATIVE, ele, semanticType, multiple, optional);
				ele = lastChild;
				continue;
			} else if (ele instanceof Action) {
				semanticType = (EClass) ((Action) ele).getType().getClassifier();
				return createElement(ConstraintType.ACTION, ele, semanticType, multiple, optional);
			} else if (ele instanceof RuleCall) {
				ele = ((RuleCall) ele).getRule().getAlternatives();
				continue;
			}
			return null;
		}
	}

	protected List<ISyntaxConstraint> createSummarizedAssignments(CompoundElement group,
			List<AbstractElement> candidates, EClass semanticType, boolean optional) {
		Multimap<String, Assignment> feature2ass = Multimaps.newHashMultimap();
		Multimap<String, AbstractElement> feature2child = Multimaps.newHashMultimap();
		for (AbstractElement c : candidates) {
			TreeIterator<EObject> i = EcoreUtil2.eAll(c);
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof RuleCall || obj instanceof Action || obj instanceof Alternatives)
					break;
				else if (obj instanceof Assignment) {
					Assignment a = (Assignment) obj;
					feature2ass.put(a.getFeature(), a);
					feature2child.put(a.getFeature(), c);
					i.prune();
				}
			}
		}
		List<ISyntaxConstraint> result = Lists.newArrayList();
		for (Map.Entry<String, Collection<Assignment>> ent : feature2ass.asMap().entrySet()) {
			if (ent.getValue().size() < 2 || feature2child.get(ent.getKey()).size() < 2)
				continue;
			int required = 0, multiplies = 0;
			for (Assignment assignment : ent.getValue()) {
				AbstractElement e = assignment;
				while (e != group)
					if (isMultipleCardinality(e)) {
						multiplies++;
						break;
					} else
						e = (AbstractElement) e.eContainer();
				e = assignment;
				while (e != group)
					if (isOptionalCardinality(e))
						break;
					else
						e = (AbstractElement) e.eContainer();
				if (e == group)
					required++;
			}
			if (required > 1 || multiplies < 1)
				continue;
			candidates.removeAll(feature2child.get(ent.getKey()));
			optional = optional || required < 1;
			result.add(createElement(ConstraintType.ASSIGNMENT, ent.getValue().iterator().next(), semanticType, true,
					optional));
		}
		return result;
	}

	protected ISyntaxConstraint getElement(ParserRule rule) {
		ISyntaxConstraint e = rule2element.get(rule);
		if (e == null)
			rule2element.put(rule, e = createElement(rule.getAlternatives()));
		return e;
	}

	protected ParserRule getFirstParserRule(Grammar grammar) {
		for (AbstractRule r : grammar.getRules())
			if (isParserRule(r))
				return (ParserRule) r;
		throw new RuntimeException("Grammar " + grammar.getName() + " contains no parser rules");
	}

	public Collection<ISyntaxConstraint> getRulesFor(EClass cls) {
		List<ISyntaxConstraint> eles = type2Elements.get(cls);
		if (eles != null)
			return eles;
		eles = Lists.newArrayList();
		for (ParserRule r : getValidRules()) {
			if (((EClass) r.getType().getClassifier()).isSuperTypeOf(cls)) {
				ISyntaxConstraint e = getElement(r);
				if (e != null)
					eles.add(e);
			}
		}
		for (ISyntaxConstraint e : eles)
			if (!isValidateableRule(GrammarUtil.containingParserRule(e.getGrammarElement()))) {
				eles.clear();
				break;
			}
		type2Elements.put(cls, eles);
		return eles;
	}

	protected Set<ParserRule> getValidRules() {
		if (validRules != null)
			return validRules;
		validRules = Sets.newHashSet();
		ParserRule first = getFirstParserRule(grammar.getGrammar());
		validRules.add(first);
		collectReachableRules(first, validRules, new HashSet<ParserRule>());
		return validRules;
	}

	protected boolean isParserRule(AbstractRule rule) {
		return rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule);
	}

	protected boolean isValidateableRule(ParserRule rule) {
		return !ruleContainsAssignedAction(rule)
				&& !ruleContainsRecursiveUnassignedRuleCall(rule, new HashSet<AbstractRule>());
	}

	protected boolean ruleContainsAssignedAction(AbstractRule rule) {
		return Iterables.any(containedActions(rule), new Predicate<Action>() {
			public boolean apply(Action action) {
				return action.getFeature() != null;
			}
		});
	}

	protected boolean ruleContainsRecursiveUnassignedRuleCall(AbstractRule rule, Set<AbstractRule> visited) {
		if (!visited.add(rule))
			return true;
		TreeIterator<EObject> i = rule.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Assignment)
				i.prune();
			else if (o instanceof RuleCall && isParserRule(((RuleCall) o).getRule())) {
				if (ruleContainsRecursiveUnassignedRuleCall(((RuleCall) o).getRule(), visited))
					return true;
			}
		}
		return false;
	}
}
