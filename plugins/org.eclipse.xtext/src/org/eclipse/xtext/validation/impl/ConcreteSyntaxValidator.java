/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ConstraintType;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidator extends AbstractConcreteSyntaxValidator {

	protected static class DependencyComparator implements Comparator<ISyntaxConstraint> {
		public int compare(ISyntaxConstraint o1, ISyntaxConstraint o2) {
			boolean d1 = o1.dependsOn(o2);
			boolean d2 = o2.dependsOn(o1);
			return d1 != d2 ? d1 ? 1 : -1 : 0;
		}
	}

	protected class Quantities {
		protected Map<ISyntaxConstraint, Integer> assignmentQuants = Maps.newHashMap();
		protected EObject delegate;
		protected Map<EStructuralFeature, Integer> featureQuants = Maps.newHashMap();

		public Quantities(EObject delegate) {
			super();
			this.delegate = delegate;
		}

		public Integer getAssignmentQuantity(ISyntaxConstraint assignement) {
			Integer i = assignmentQuants.get(assignement);
			return i == null || i < 0 ? -1 : i;
		}

		public EObject getDelegate() {
			return delegate;
		}

		public Map<EStructuralFeature, Integer> getFeatureQuantities() {
			return featureQuants;
		}

		public Integer getFeatureQuantity(EStructuralFeature feat) {
			Integer i = featureQuants.get(feat);
			return i == null || i < 0 ? -1 : i;
		}

		public Map<EStructuralFeature, Collection<ISyntaxConstraint>> groupByFeature() {
			Multimap<EStructuralFeature, ISyntaxConstraint> map = Multimaps.newHashMultimap();
			for (ISyntaxConstraint e : assignmentQuants.keySet())
				map.put(e.getAssignmentFeature(delegate.eClass()), e);
			return map.asMap();
		}

		public void setAssignmentQuantity(ISyntaxConstraint assignement, int quantity) {
			assignmentQuants.put(assignement, quantity);
		}

		public void setFeatureQuantity(EStructuralFeature feature, int quantity) {
			featureQuants.put(feature, quantity);
		}

		@Override
		public String toString() {
			return toString(null);
		}

		public String toString(Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax) {
			Map<ISyntaxConstraint, String> postfix = Maps.newHashMap();
			for (Map.Entry<ISyntaxConstraint, Integer> e : assignmentQuants.entrySet()) {
				String s = ":" + e.getValue();
				if (minmax != null && minmax.containsKey(e.getKey())) {
					Pair<Integer, Integer> p = minmax.get(e.getKey());
					s += "<" + p.getFirst() + "," + (p.getSecond() == Integer.MAX_VALUE ? "*" : p.getSecond()) + ">";
				}
				postfix.put(e.getKey(), s);
			}
			Iterator<ISyntaxConstraint> i = assignmentQuants.keySet().iterator();
			if (!i.hasNext())
				return "";
			ISyntaxConstraint root = i.next();
			while (i.hasNext())
				root = root.findCommonContainer(i.next());
			return root.toString(postfix);
		}
	}

	protected static class QuantityComparator extends DependencyComparator {
		private Quantities quantities;

		public QuantityComparator(Quantities quantities) {
			super();
			this.quantities = quantities;
		}

		@Override
		public int compare(ISyntaxConstraint o1, ISyntaxConstraint o2) {
			int r = quantities.getAssignmentQuantity(o2).compareTo(quantities.getAssignmentQuantity(o1));
			return r == 0 ? super.compare(o1, o2) : r;
		}
	}

	public static int MAX = Integer.MAX_VALUE;

	public static int UNDEF = -1;

	@Inject
	protected IConcreteSyntaxConstraintProvider constraintProvider;

	@Inject
	protected IConcreteSyntaxDiagnosticProvider diagnosticProvider;

	@Inject
	protected ConcreteSyntaxValidationHelper helper;

	protected boolean allowTransient(EStructuralFeature f, Collection<ISyntaxConstraint> ele) {
		return f.getEType() instanceof EEnum || f.getEType() == EcorePackage.eINSTANCE.getEInt();
	}

	protected void collectAssignments(ISyntaxConstraint rule, EObject obj, ISyntaxConstraint ele,
			Multimap<EStructuralFeature, ISyntaxConstraint> assignments, List<IConcreteSyntaxDiagnostic> acceptor) {
		if (ele.getSemanticType() != null && !ele.getSemanticType().isSuperTypeOf(obj.eClass()))
			return;
		if (ele.getType() == ConstraintType.ASSIGNMENT) {
			EStructuralFeature f = obj.eClass().getEStructuralFeature(
					((Assignment) ele.getGrammarElement()).getFeature());
			if (f == null)
				acceptor.add(diagnosticProvider.createFeatureMissingDiagnostic(rule, obj, ele, Collections
						.<ISyntaxConstraint> emptySet()));
			else
				assignments.put(f, ele);
		}
		for (ISyntaxConstraint e : ele.getContents())
			collectAssignments(rule, obj, e, assignments, acceptor);
	}

	protected Set<ISyntaxConstraint> collectUnfulfilledSemanticElements(EClass cls, ISyntaxConstraint ele) {
		if (ele.isOptional())
			return Collections.emptySet();
		if (ele.getSemanticType() != null && !ele.getSemanticType().isSuperTypeOf(cls))
			return Collections.singleton(ele);
		switch (ele.getType()) {
			case GROUP:
				Set<ISyntaxConstraint> l1 = new HashSet<ISyntaxConstraint>();
				for (ISyntaxConstraint e : ele.getContents())
					l1.addAll(collectUnfulfilledSemanticElements(cls, e));
				return l1;
			case ALTERNATIVE:
				Set<ISyntaxConstraint> l2 = new HashSet<ISyntaxConstraint>();
				for (ISyntaxConstraint e : ele.getContents()) {
					Set<ISyntaxConstraint> r = collectUnfulfilledSemanticElements(cls, e);
					if (r.size() == 0)
						return Collections.emptySet();
					else
						l2.addAll(r);
				}
				return l2;
			default:
				return Collections.emptySet();
		}
	}

	protected boolean containsUnavailableFeature(Quantities ctx, ISyntaxConstraint child, String exclude,
			Set<ISyntaxConstraint> involved) {
		if (child.isOptional())
			return false;
		switch (child.getType()) {
			case ASSIGNMENT:
				if (exclude.equals(child.getAssignmentName()))
					return false;
				involved.add(child);
				return ctx.getAssignmentQuantity(child) == 0;
			case GROUP:
				for (ISyntaxConstraint a : child.getContents())
					if (containsUnavailableFeature(ctx, a, exclude, involved))
						return true;
				return false;
			case ALTERNATIVE:
				for (ISyntaxConstraint a : child.getContents())
					if (!containsUnavailableFeature(ctx, a, exclude, involved))
						return false;
				return true;
			case ACTION:
				return !child.getSemanticType().isInstance(ctx.getDelegate());
			default:
				return false;
		}

	}

	protected int distributeQuantity(List<ISyntaxConstraint> assignments, Quantities quants,
			Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax, int quantity) {
		for (ISyntaxConstraint ass : assignments) {
			int min = Math.max(Math.min(minmax.get(ass).getFirst(), minmax.get(ass).getSecond()), 0);
			int q = quants.getAssignmentQuantity(ass);
			if (q < 0)
				q = 0;
			int toAdd = min - q;
			if (toAdd > 0) {
				if (min <= quantity) {
					quants.setAssignmentQuantity(ass, min);
					quantity -= min;
				} else {
					quants.setAssignmentQuantity(ass, quantity);
					quantity = 0;
				}
			} else
				quants.setAssignmentQuantity(ass, q);
		}
		for (ISyntaxConstraint ass : assignments) {
			if (quantity == 0)
				break;
			int max = minmax.get(ass).getSecond();
			int q = quants.getAssignmentQuantity(ass);
			if (q < max) {
				int nv = Math.min(max, quantity + q);
				quants.setAssignmentQuantity(ass, nv);
				quantity -= nv - q;
			}
		}
		return quantity;
	}

	protected int getHardMax(ISyntaxConstraint e) {
		return e.isMultiple() ? MAX : e.isRoot() ? 1 : getHardMax(e.getContainer());
	}

	protected int getHardMin(ISyntaxConstraint e) {
		return e.isOptional() || e.getType() == ConstraintType.ALTERNATIVE ? 0 : e.isRoot() ? 1 : getHardMin(e
				.getContainer());
	}

	protected int getMaxCount(Quantities ctx, ISyntaxConstraint ass, Set<ISyntaxConstraint> involved,
			String excludeFeature) {
		int c = ass.isRoot() ? 1 : getMaxCountByParent(ctx, ass.getContainer(), ass, excludeFeature, involved);
		return ass.isMultiple() && c > 0 ? MAX : c;
	}

	protected int getMaxCountByParent(Quantities ctx, ISyntaxConstraint ele, ISyntaxConstraint exclude,
			String excludeFeature, Set<ISyntaxConstraint> inv) {
		int max = ele.isRoot() ? (ele.isMultiple() ? MAX : 1) : getMaxCountByParent(ctx, ele.getContainer(), ele,
				excludeFeature, inv);
		if (max == 0)
			return 0;
		switch (ele.getType()) {
			case GROUP:
				if (ele.isMultiple())
					max = MAX;
				if (ele.isOptional() || max == MAX) {
					for (ISyntaxConstraint a : ele.getContents())
						if (a != exclude) {
							int count = getMaxCountForChild(ctx, a, inv);
							if (count != UNDEF && (count < max))
								max = count;
						}
				}
				return max == 0 && !ele.isOptional() ? 1 : max;
			case ALTERNATIVE:
				if (ele.isMultiple())
					return MAX;
				for (ISyntaxConstraint a : ele.getContents())
					if (a != exclude) {
						int count = getMinCountForChild(ctx, a, inv);
						if (count > 0)
							return 0;
					} else if (excludeFeature != null && containsUnavailableFeature(ctx, a, excludeFeature, inv))
						return 0;
				return max;
			default:
				return 1;
		}
	}

	protected int getMaxCountForChild(Quantities ctx, ISyntaxConstraint child, Set<ISyntaxConstraint> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx.getDelegate()))
			return 0;
		if (child.isOptional())
			return MAX;
		switch (child.getType()) {
			case ASSIGNMENT:
				involved.add(child);
				return ctx.getAssignmentQuantity(child);
			case GROUP:
				int count1 = MAX;
				for (ISyntaxConstraint a : child.getContents()) {
					int c = getMaxCountForChild(ctx, a, involved);
					if (c != UNDEF && c < count1)
						count1 = c;
				}
				return count1;
			case ALTERNATIVE:
				int count2 = UNDEF;
				for (ISyntaxConstraint a : child.getContents()) {
					int c = getMaxCountForChild(ctx, a, involved);
					if (c == MAX)
						return MAX;
					if (c != UNDEF)
						count2 = count2 == UNDEF ? c : count2 + c;
				}
				return count2;
			case ACTION:
				return MAX;
			default:
				return UNDEF;
		}
	}

	protected int getMinCount(Quantities ctx, ISyntaxConstraint assignment, Set<ISyntaxConstraint> involved) {
		if (assignment.isOptional())
			return 0;
		if (assignment.isRoot())
			return 1;
		return getMinCountByParent(ctx, assignment.getContainer(), assignment, involved);
	}

	protected int getMinCountByParent(Quantities ctx, ISyntaxConstraint parent, ISyntaxConstraint exclude,
			Set<ISyntaxConstraint> involved) {
		switch (parent.getType()) {
			case GROUP:
				if (parent.isRoot() && !parent.isOptional() && !parent.isMultiple())
					return 1;
				int count1 = UNDEF;
				for (ISyntaxConstraint a : parent.getContents())
					if (a != exclude) {
						int c = getMinCountForChild(ctx, a, involved);
						if (c > count1) {
							count1 = c;
							break;
						}
					}
				if (parent.isOptional())
					return count1 == UNDEF ? 0 : count1;
				if (!parent.isRoot())
					return Math.max(getMinCountByParent(ctx, parent.getContainer(), parent, involved), count1);
				return UNDEF;
			case ALTERNATIVE:
				if (parent.isOptional())
					return 0;
				for (ISyntaxConstraint a : parent.getContents())
					if (a != exclude) {
						int count2 = getMinCountForChild(ctx, a, involved);
						if (count2 > 0)
							return 0;
					}
				if (!parent.isRoot())
					return getMinCountByParent(ctx, parent.getContainer(), parent, involved);
				return 1;
			default:
				return UNDEF;
		}
	}

	protected int getMinCountForChild(Quantities ctx, ISyntaxConstraint child, Set<ISyntaxConstraint> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx.getDelegate()))
			return 0;
		int count = UNDEF;
		switch (child.getType()) {
			case ASSIGNMENT:
				involved.add(child);
				count = ctx.getAssignmentQuantity(child);
				break;
			case GROUP:
				for (ISyntaxConstraint a : child.getContents()) {
					int c = getMinCountForChild(ctx, a, involved);
					if (c > count)
						count = c;
				}
				break;
			case ALTERNATIVE:
				for (ISyntaxConstraint a : child.getContents()) {
					int c = getMinCountForChild(ctx, a, involved);
					count = count == UNDEF ? c : c + count;
				}
				break;
			case ACTION:
				return 1;
		}
		if (child.isMultiple() && count > 1)
			count = 1;
		return count;
	}

	protected List<Quantities> getQuantities(EObject obj, ISyntaxConstraint rule,
			List<IConcreteSyntaxDiagnostic> acceptor) {
		Multimap<EStructuralFeature, ISyntaxConstraint> assignments = Multimaps.newHashMultimap();
		collectAssignments(rule, obj, rule, assignments, acceptor);
		//		Map<EStructuralFeature, Integer> quantities = Maps.newHashMap();
		Quantities quants = new Quantities(obj);
		for (EStructuralFeature f : obj.eClass().getEAllStructuralFeatures()) {
			int quantity = helper.countNonTransientValues(obj, f);
			if (quantity > 0 && !assignments.containsKey(f))
				acceptor.add(diagnosticProvider.createAssignmentMissingDiagnostic(rule, obj, f, Collections
						.<ISyntaxConstraint> emptySet()));
			else
				quants.setFeatureQuantity(f, quantity);
		}
		Multimap<EStructuralFeature, ISyntaxConstraint> multiAssignments = Multimaps.newHashMultimap();
		Multimap<EStructuralFeature, ISyntaxConstraint> allowTransients = Multimaps.newHashMultimap();
		for (Map.Entry<EStructuralFeature, Integer> f : quants.getFeatureQuantities().entrySet()) {
			Collection<ISyntaxConstraint> ass = assignments.get(f.getKey());
			boolean allowTransient = !f.getKey().isMany() && f.getValue() == 0 && allowTransient(f.getKey(), ass);
			boolean multiNeeded = ass.size() > 1 && f.getValue() != 0;
			if (allowTransient)
				allowTransients.putAll(f.getKey(), ass);
			if (multiNeeded)
				multiAssignments.putAll(f.getKey(), ass);
			if (!allowTransient && !multiNeeded)
				for (ISyntaxConstraint a : ass)
					quants.setAssignmentQuantity(a, f.getValue());
		}
		if (multiAssignments.isEmpty() && allowTransients.isEmpty())
			return Collections.singletonList(quants);
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : allowTransients.asMap().entrySet()) {
			int min = 0;
			for (ISyntaxConstraint x : e.getValue())
				min += getMinCount(quants, x, Sets.<ISyntaxConstraint> newHashSet());
			int val = min > 0 ? 1 : 0;
			quants.setFeatureQuantity(e.getKey(), val);
			if (e.getValue().size() == 1)
				quants.setAssignmentQuantity(e.getValue().iterator().next(), val);
		}
		//		System.out.println("AllowTransientsQuantities: " + quants.toString());
		if (multiAssignments.isEmpty())
			return Collections.singletonList(quants);
		Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : multiAssignments.asMap().entrySet()) {
			for (ISyntaxConstraint f : e.getValue()) {
				int min = getMinCount(quants, f, Sets.<ISyntaxConstraint> newHashSet());
				int max = getMaxCount(quants, f, Sets.<ISyntaxConstraint> newHashSet(), e.getKey().getName());
				minmax.put(f, Tuples.create(min, max));
			}
			List<ISyntaxConstraint> ass = new ArrayList<ISyntaxConstraint>(e.getValue());
			Collections.sort(ass, new DependencyComparator());
			int quantity = quants.getFeatureQuantity(e.getKey());
			quantity = distributeQuantity(ass, quants, minmax, quantity);
			if (quantity > 0) {
				//				System.out.println("Quantities: " + quants.toString(minmax));
				for (ISyntaxConstraint x : ass)
					minmax.put(x, Tuples.create(getHardMin(x), getHardMax(x)));
				Collections.sort(ass, new QuantityComparator(quants));
				quantity = distributeQuantity(ass, quants, minmax, quantity);
				if (quantity > 0)
					quants.setAssignmentQuantity(ass.get(0), quants.getAssignmentQuantity(ass.get(0)) + quantity);
			}
		}
		//		System.out.println("FinalQuantities: " + quants.toString(minmax));
		return Collections.singletonList(quants);
	}

	@Override
	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		if (helper.isEObjectTransient(obj))
			return true;
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Collection<ISyntaxConstraint> rules = constraintProvider.getRulesFor(obj.eClass());
		if (rules.isEmpty())
			return true;// no validation if there are no rules for this EClass
		for (ISyntaxConstraint rule : rules) {
			//			System.out.println(rule);
			List<IConcreteSyntaxDiagnostic> diags = validateRule(obj, rule);
			if (diags.size() == 0)
				return true; // validation succeeded
			allDiags.addAll(diags);
		}
		for (IConcreteSyntaxDiagnostic d : allDiags)
			acceptor.accept(d);
		return false;
	}

	protected List<IConcreteSyntaxDiagnostic> validateQuantities(Quantities obj, ISyntaxConstraint rule) {
		List<IConcreteSyntaxDiagnostic> diag = new ArrayList<IConcreteSyntaxDiagnostic>();
		Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : obj.groupByFeature().entrySet()) {
			int min = UNDEF, max = 0;
			Set<ISyntaxConstraint> involved = new HashSet<ISyntaxConstraint>();
			for (ISyntaxConstraint a : e.getValue()) {
				involved.add(a);
				int mi = getMinCount(obj, a, involved);
				if (mi != UNDEF)
					min = min == UNDEF ? mi : mi + min;
				int ma = getMaxCount(obj, a, involved, null);
				if (ma != UNDEF && max != MAX)
					max = ma == MAX ? ma : max + ma;
				minmax.put(a, Tuples.create(mi, ma));
			}
			int actual = obj.getFeatureQuantity(e.getKey());
			if (actual < min || (actual > max))
				diag.add(diagnosticProvider.createFeatureDiagnostic(rule, obj.getDelegate(), e.getKey(), actual, min,
						max, involved));
		}
		//		System.out.println("Validation: " + obj.toString(minmax));
		return diag;
	}

	@Override
	public boolean validateRecursive(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		boolean r = true;
		r &= validateObject(obj, acceptor, context);
		TreeIterator<EObject> i = obj.eAllContents();
		while (i.hasNext())
			r &= validateObject(i.next(), acceptor, context);
		return r;
	}

	protected List<IConcreteSyntaxDiagnostic> validateRule(EObject obj, ISyntaxConstraint rule) {
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Set<ISyntaxConstraint> expectedTypes = collectUnfulfilledSemanticElements(obj.eClass(), rule);
		if (expectedTypes.size() > 0)
			allDiags.add(diagnosticProvider.createObjectDiagnostic(rule, obj, expectedTypes));
		List<Quantities> quantities = getQuantities(obj, rule, allDiags);
		if (!allDiags.isEmpty())
			return allDiags;
		for (Quantities q : quantities) {
			List<IConcreteSyntaxDiagnostic> diags = validateQuantities(q, rule);
			if (diags.isEmpty())
				return diags;
			allDiags.addAll(diags);
		}
		return allDiags;
	}

}
