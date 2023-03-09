/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
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
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class ConcreteSyntaxConstraintProvider implements IConcreteSyntaxConstraintProvider {
	public static class SyntaxConstraintNode implements ISyntaxConstraint {
		protected ISyntaxConstraint container = null;
		protected List<ISyntaxConstraint> contents;
		protected AbstractElement element;
		protected boolean multiple = false;
		protected boolean optional = false;
		protected EClass semanticType = null;
		protected Set<EClass> semanticTypes = UNINITIALIZED;
		protected ConstraintType type;

		protected SyntaxConstraintNode() {
		}

		public SyntaxConstraintNode(ConstraintType type, AbstractElement ele, List<ISyntaxConstraint> contents,
				EClass semanticType, boolean multiple, boolean optional) {
			super();
			if (type == null)
				throw new NullPointerException("type must not be null");
			this.type = type;
			this.element = ele;
			this.semanticType = semanticType;
			this.multiple = multiple;
			this.optional = optional;
			this.contents = contents;
			for (ISyntaxConstraint e : contents)
				((SyntaxConstraintNode) e).container = this;
		}

		protected boolean containsType() {
			for (ISyntaxConstraint c : getContents()) {
				SyntaxConstraintNode n = (SyntaxConstraintNode) c;
				if (n.semanticType != null || n.containsType())
					return true;
			}
			return false;
		}

		@Override
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

		@Override
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

		protected Pair<Set<EClass>, Set<EClass>> getAllSemanticTypesPairs(Set<ISyntaxConstraint> exclude) {
			Set<EClass> mandatory = Sets.newHashSet();
			Set<EClass> optional = Sets.newHashSet();
			boolean allChildrenContributeMandatoryType = !getContents().isEmpty();
			for (ISyntaxConstraint sc : getContents())
				if (exclude == null || !exclude.contains(sc)) {
					Pair<Set<EClass>, Set<EClass>> t = ((SyntaxConstraintNode) sc).getAllSemanticTypesPairs(exclude);
					if (sc.isOptional()) {
						optional.addAll(t.getFirst());
						optional.addAll(t.getSecond());
						allChildrenContributeMandatoryType = false;
					} else {
						mandatory.addAll(t.getFirst());
						optional.addAll(t.getSecond());
						if (t.getFirst().isEmpty())
							allChildrenContributeMandatoryType = false;
					}
				}
			if ((isRoot() && isOptional())
					|| (type == ConstraintType.ALTERNATIVE && !allChildrenContributeMandatoryType)) {
				optional.addAll(mandatory);
				mandatory.clear();
			}
			if (semanticType != null) {
				if (mandatory.isEmpty()
						&& (optional.isEmpty() || (optional.size() == 1 && optional.contains(semanticType))))
					mandatory.add(semanticType);
				else
					optional.add(semanticType);
			}
			if (exclude == null && !isRoot() && mandatory.isEmpty() && optional.isEmpty())
				optional.addAll(((SyntaxConstraintNode) getContainer()).getSemanticTypeByParent(Sets
						.<ISyntaxConstraint> newHashSet(this)));
			return Tuples.create(mandatory, optional);
		}

		@Override
		public EStructuralFeature getAssignmentFeature(EClass clazz) {
			String name = getAssignmentName();
			EStructuralFeature f = clazz.getEStructuralFeature(name);
			if (f == null)
				throw new RuntimeException("Feature " + name + " not found for " + clazz.getName());
			return f;
		}

		@Override
		public String getAssignmentName() {
			if (type != ConstraintType.ASSIGNMENT)
				throw new RuntimeException("Constraint '" + this + "' is not an assignment, but a " + getType());
			return ((Assignment) element).getFeature();
		}

		@Override
		public String getCardinality() {
			return optional ? (multiple ? "*" : "?") : (multiple ? "+" : "");
		}

		@Override
		public ISyntaxConstraint getContainer() {
			return container;
		}

		@Override
		public List<ISyntaxConstraint> getContents() {
			return contents;
		}

		@Override
		public AbstractElement getGrammarElement() {
			return element;
		}

		protected Set<EClass> getSemanticTypeByParent(Set<ISyntaxConstraint> exclude) {
			if (type == ConstraintType.ALTERNATIVE) {
				exclude.addAll(getContents());
				if (semanticType != null)
					return Sets.newHashSet(semanticType);
			} else {
				Pair<Set<EClass>, Set<EClass>> types = getAllSemanticTypesPairs(exclude);
				if (!types.getFirst().isEmpty())
					return types.getFirst();
				if (isRoot())
					return types.getSecond();
			}
			return ((SyntaxConstraintNode) getContainer()).getSemanticTypeByParent(exclude);
		}

		@Override
		public Set<EClass> getSemanticTypes() {
			Pair<Set<EClass>, Set<EClass>> types = getAllSemanticTypesPairs(null);
			return !types.getFirst().isEmpty() ? types.getFirst() : types.getSecond();
		}

		@Override
		public Set<EClass> getSemanticTypesToCheck() {
			if (semanticTypes == UNINITIALIZED) {
				semanticTypes = getSemanticTypes();
				if (semanticTypes.isEmpty()
						|| (!isRoot() && semanticTypes.equals(((SyntaxConstraintNode) getContainer())
								.getSemanticTypes())))
					semanticTypes = null;
			}
			return semanticTypes;
		}

		@Override
		public ConstraintType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return element.hashCode();
		}

		@Override
		public boolean isMultiple() {
			return multiple;
		}

		@Override
		public boolean isOptional() {
			return optional;
		}

		@Override
		public boolean isRoot() {
			return container == null;
		}

		@Override
		public String toString() {
			return toString(null);
		}

		@Override
		public String toString(final Map<ISyntaxConstraint, String> postfix) {
			// String t = getSemanticTypes() == null ? "" : getSemanticTypes().getName() + ":";
			String p = postfix != null && postfix.containsKey(this) ? postfix.get(this) : "";
			Iterable<String> contents = Iterables.transform(getContents(), new Function<ISyntaxConstraint, String>() {
				@Override
				public String apply(ISyntaxConstraint from) {
					return from.toString(postfix);
				}
			});
			switch (getType()) {
				case ASSIGNMENT:
					return /*t +*/((Assignment) element).getFeature() + p + getCardinality();
				case GROUP:
					return /*t +*/"(" + Joiner.on(" ").join(contents) + ")" + p + getCardinality();
				case ALTERNATIVE:
					return /*t +*/"(" + Joiner.on("|").join(contents) + ")" + p + getCardinality();
				case ACTION:
					return "{" + ((Action) element).getType().getClassifier().getName() + "}" + p;
			}
			return "";
		}
	}

	protected final static Set<EClass> UNINITIALIZED = Sets.newHashSet();

	protected Grammar grammar;

	protected final ISyntaxConstraint INVALID_RULE = new SyntaxConstraintNode();

	protected Map<ParserRule, ISyntaxConstraint> rule2element = Maps.newHashMap();

	protected Map<EClass, List<ISyntaxConstraint>> type2Elements = Maps.newHashMap();

	protected Set<ParserRule> validRules;

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
			List<AbstractElement> lazyContents, List<ISyntaxConstraint> contents, EClass semanticType,
			boolean multiple, boolean optional) {
		if (lazyContents != null)
			for (EObject obj : lazyContents) {
				ISyntaxConstraint e = createElement(obj);
				if (e != null)
					contents.add(e);
			}
		return new SyntaxConstraintNode(type, ele, contents, semanticType, multiple, optional);
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
				if (lastChild == null)
					return null;
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
				if (lastChild == null)
					return null;
				ele = lastChild;
				continue;
			} else if (ele instanceof Action) {
				semanticType = (EClass) ((Action) ele).getType().getClassifier();
				return createElement(ConstraintType.ACTION, ele, semanticType, multiple, optional);
			} else if (ele instanceof RuleCall) {
				AbstractRule rule = ((RuleCall) ele).getRule();
				if (rule.getType().getClassifier() instanceof EClass) {
					ele = rule.getAlternatives();
					continue;
				}
			}
			return null;
		}
	}

	protected List<ISyntaxConstraint> createSummarizedAssignments(CompoundElement group,
			List<AbstractElement> candidates, EClass semanticType, boolean optional) {
		Multimap<String, Assignment> feature2ass = HashMultimap.create();
		Multimap<String, AbstractElement> feature2child = HashMultimap.create();
		for (AbstractElement c : candidates) {
			TreeIterator<EObject> i = EcoreUtil2.eAll(c);
			while (i.hasNext()) {
				EObject obj = i.next();
				if (obj instanceof RuleCall || obj instanceof Action || obj instanceof Alternatives)
					return Lists.newArrayList();
				else if (obj instanceof Group) {
					Set<String> names = Sets.newHashSet();
					for (Assignment ass : EcoreUtil2.getAllContentsOfType(obj, Assignment.class))
						names.add(ass.getFeature());
					if (names.size() > 1)
						i.prune();
				} else if (obj instanceof Assignment) {
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

	@Override
	public ISyntaxConstraint getConstraint(ParserRule rule) {
		ISyntaxConstraint e = rule2element.get(rule);
		if (e == null) {
			if (isValidateableRule(rule))
				e = createElement(rule.getAlternatives());
			else
				e = INVALID_RULE;
			rule2element.put(rule, e);
		}
		return e != INVALID_RULE ? e : null;
	}

	@Override
	public Collection<ISyntaxConstraint> getConstraints(EClass cls) {
		List<ISyntaxConstraint> eles = type2Elements.get(cls);
		if (eles != null)
			return eles;
		eles = Lists.newArrayList();
		for (ParserRule r : getValidRules()) {
			if (((EClass) r.getType().getClassifier()).isSuperTypeOf(cls)) {
				ISyntaxConstraint e = getConstraint(r);
				if (e != null)
					eles.add(e);
				else {
					eles.clear();
					break;
				}
			}
		}
		type2Elements.put(cls, eles);
		return eles;
	}

	protected ParserRule getFirstParserRule(Grammar grammar) {
		for (AbstractRule r : grammar.getRules())
			if (isParserRule(r))
				return (ParserRule) r;
		throw new RuntimeException("Grammar " + grammar.getName() + " contains no parser rules");
	}

	protected Set<ParserRule> getValidRules() {
		if (validRules != null)
			return validRules;
		validRules = Sets.newHashSet();
		ParserRule first = getFirstParserRule(grammar);
		validRules.add(first);
		collectReachableRules(first, validRules, new HashSet<ParserRule>());
		return validRules;
	}

	protected boolean isParserRule(AbstractRule rule) {
		return rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule);
	}

	protected boolean isValidateableRule(ParserRule rule) {
		return !ruleContainsAssignedAction(rule, new HashSet<AbstractRule>())
				&& !ruleContainsRecursiveUnassignedRuleCall(rule, new HashSet<AbstractRule>());
	}

	protected boolean ruleContainsAssignedAction(AbstractRule rule, Set<AbstractRule> visited) {
		if (!visited.add(rule))
			return false;
		TreeIterator<EObject> i = rule.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Action && ((Action) o).getFeature() != null)
				return true;
			else if (o instanceof Assignment)
				i.prune();
			else if (o instanceof RuleCall && isParserRule(((RuleCall) o).getRule())) {
				if (ruleContainsAssignedAction(((RuleCall) o).getRule(), visited))
					return true;
			}
		}
		return false;
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

	@Inject
	protected void setGrammar(IGrammarAccess grammar) {
		this.grammar = grammar.getGrammar();
	}
}
