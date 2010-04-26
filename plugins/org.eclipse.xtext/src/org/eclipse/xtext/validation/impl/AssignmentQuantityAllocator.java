/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import static org.eclipse.xtext.validation.IAssignmentQuantityIntervalProvider.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ConstraintType;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider;
import org.eclipse.xtext.validation.IAssignmentQuantityIntervalProvider;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentQuantityAllocator implements IAssignmentQuantityAllocator {
	protected static class DependencyComparator implements Comparator<ISyntaxConstraint> {
		public int compare(ISyntaxConstraint o1, ISyntaxConstraint o2) {
			boolean d1 = o1.dependsOn(o2);
			boolean d2 = o2.dependsOn(o1);
			return d1 != d2 ? d1 ? 1 : -1 : 0;
		}
	}

	protected class Quantities implements IQuantities {
		protected Map<ISyntaxConstraint, Integer> assignmentQuants = Maps.newHashMap();
		protected EObject delegate;
		protected Map<EStructuralFeature, Integer> featureQuants = Maps.newHashMap();

		public Quantities(EObject delegate) {
			super();
			this.delegate = delegate;
		}

		public void consistencyCheck() {
			Map<EStructuralFeature, Integer> quantities = Maps.newHashMap();
			for (Map.Entry<ISyntaxConstraint, Integer> e : assignmentQuants.entrySet()) {
				EStructuralFeature f = e.getKey().getAssignmentFeature(delegate.eClass());
				Integer q = quantities.get(f);
				quantities.put(f, q == null ? e.getValue() : q + e.getValue());
			}
			for (Map.Entry<EStructuralFeature, Integer> q : quantities.entrySet())
				if (!featureQuants.get(q.getKey()).equals(q.getValue()))
					throw new RuntimeException("Feature " + q.getKey().getName() + ": Quantity " + q.getValue()
							+ " found, but " + featureQuants.get(q.getKey()) + " expected. Please report a bug.");
		}

		public Map<ISyntaxConstraint, Integer> getAssignmentQuantities() {
			return assignmentQuants;
		}

		public Integer getAssignmentQuantity(ISyntaxConstraint assignement) {
			Integer i = assignmentQuants.get(assignement);
			return i == null || i < 0 ? -1 : i;
		}

		public EObject getEObject() {
			return delegate;
		}

		public Map<EStructuralFeature, Integer> getFeatureQuantities() {
			return featureQuants;
		}

		public Integer getFeatureQuantity(EStructuralFeature feat) {
			Integer i = featureQuants.get(feat);
			return i == null || i < 0 ? -1 : i;
		}

		public int getQuality() {
			int quality = 0;
			for (Map.Entry<ISyntaxConstraint, Integer> e : assignmentQuants.entrySet()) {
				int min = intervalProvider.getMin(this, e.getKey(), Sets.<ISyntaxConstraint> newHashSet());
				int max = intervalProvider.getMax(this, e.getKey(), Sets.<ISyntaxConstraint> newHashSet(), e.getKey()
						.getAssignmentName());
				if (e.getValue() < min)
					quality += min - e.getValue();
				if (e.getValue() > max)
					quality += e.getValue() - max;
			}
			return quality;
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
		private IQuantities quantities;

		public QuantityComparator(IQuantities quantities) {
			super();
			this.quantities = quantities;
		}

		@Override
		public int compare(ISyntaxConstraint o1, ISyntaxConstraint o2) {
			int r = quantities.getAssignmentQuantity(o2).compareTo(quantities.getAssignmentQuantity(o1));
			return r == 0 ? super.compare(o1, o2) : r;
		}
	}

	@Inject
	protected IConcreteSyntaxDiagnosticProvider diagnosticProvider;

	@Inject
	protected IAssignmentQuantityIntervalProvider intervalProvider;

	protected Random random = new Random();

	@Inject
	protected ITransientValueService transSrvc;

	protected boolean allowTransient(EStructuralFeature f, Collection<ISyntaxConstraint> ele) {
		return f.getEType() instanceof EEnum || f.getEType() == EcorePackage.eINSTANCE.getEInt();
	}

	protected void collectAssignments(ISyntaxConstraint rule, EObject obj, ISyntaxConstraint ele,
			Multimap<EStructuralFeature, ISyntaxConstraint> assignments, List<IConcreteSyntaxDiagnostic> acceptor) {
		if (ele.getSemanticTypesToCheck() != null && !ele.getSemanticTypesToCheck().contains(obj.eClass()))
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

	protected Quantities createQuantities(EObject obj) {
		return new Quantities(obj);
	}

	public IQuantities getAssignmentQuantities(EObject obj, ISyntaxConstraint rule,
			List<IConcreteSyntaxDiagnostic> acceptor) {
		Multimap<EStructuralFeature, ISyntaxConstraint> assignments = Multimaps.newHashMultimap();
		collectAssignments(rule, obj, rule, assignments, acceptor);
		//		Map<EStructuralFeature, Integer> quantities = Maps.newHashMap();
		Quantities quants = createQuantities(obj);
		for (EStructuralFeature f : obj.eClass().getEAllStructuralFeatures()) {
			int quantity = getFeatureQuantity(obj, f);
			if (quantity > 0 && !assignments.containsKey(f))
				acceptor.add(diagnosticProvider.createAssignmentMissingDiagnostic(rule, obj, f, Collections
						.<ISyntaxConstraint> emptySet()));
			else
				quants.setFeatureQuantity(f, quantity);
		}
		Multimap<EStructuralFeature, ISyntaxConstraint> multipleAssignments = Multimaps.newHashMultimap();
		Multimap<EStructuralFeature, ISyntaxConstraint> allowTransients = Multimaps.newHashMultimap();
		for (Map.Entry<EStructuralFeature, Integer> f : quants.getFeatureQuantities().entrySet()) {
			Collection<ISyntaxConstraint> ass = assignments.get(f.getKey());
			boolean allowTransient = !f.getKey().isMany() && f.getValue() == 0 && allowTransient(f.getKey(), ass);
			boolean multiNeeded = ass.size() > 1 && f.getValue() != 0;
			if (allowTransient)
				allowTransients.putAll(f.getKey(), ass);
			if (multiNeeded)
				multipleAssignments.putAll(f.getKey(), ass);
			if (!allowTransient && !multiNeeded)
				for (ISyntaxConstraint a : ass)
					quants.setAssignmentQuantity(a, f.getValue());
		}
		if (multipleAssignments.isEmpty() && allowTransients.isEmpty())
			return quants;
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : allowTransients.asMap().entrySet()) {
			int min = 0;
			for (ISyntaxConstraint x : e.getValue())
				min += intervalProvider.getMin(quants, x, Sets.<ISyntaxConstraint> newHashSet());
			int val = min > 0 ? 1 : 0;
			quants.setFeatureQuantity(e.getKey(), val);
			if (e.getValue().size() == 1)
				quants.setAssignmentQuantity(e.getValue().iterator().next(), val);
		}
		//		System.out.println("AllowTransientsQuantities: " + quants.toString());
		if (multipleAssignments.isEmpty())
			return quants;
		heuristicSolver(quants, multipleAssignments);
		//		System.out.println("FinalQuantities: " + quants.toString(minmax));
		return quants;
	}

	public int getFeatureQuantity(EObject obj, EStructuralFeature feat) {
		if (feat.isMany()) {
			int count = 0, max = ((List<?>) obj.eGet(feat)).size();
			if (transSrvc.isMixedList(obj, feat)) {
				for (int i = 0; i < max; i++)
					if (!transSrvc.isTransient(obj, feat, i))
						count++;
				return count;
			}
			return transSrvc.isTransient(obj, feat, 0) ? 0 : max;
		}
		return transSrvc.isTransient(obj, feat, 0) ? 0 : 1;
	}

	protected int getHardMax(ISyntaxConstraint e) {
		return e.isMultiple() ? MAX : e.isRoot() ? 1 : getHardMax(e.getContainer());
	}

	protected int getHardMin(ISyntaxConstraint e) {
		return e.isOptional() || e.getType() == ConstraintType.ALTERNATIVE ? 0 : e.isRoot() ? 1 : getHardMin(e
				.getContainer());
	}

	protected int heuristicDistributeQuantity(List<ISyntaxConstraint> assignments, Quantities quants,
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

	protected void heuristicInitialSolution(Quantities quants,
			Multimap<EStructuralFeature, ISyntaxConstraint> multiAssignments) {
		Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : multiAssignments.asMap().entrySet()) {
			for (ISyntaxConstraint f : e.getValue()) {
				int min = intervalProvider.getMin(quants, f, Sets.<ISyntaxConstraint> newHashSet());
				int max = intervalProvider.getMax(quants, f, Sets.<ISyntaxConstraint> newHashSet(), e.getKey()
						.getName());
				minmax.put(f, Tuples.create(min, max));
			}
			List<ISyntaxConstraint> ass = new ArrayList<ISyntaxConstraint>(e.getValue());
			Collections.sort(ass, new DependencyComparator());
			int quantity = quants.getFeatureQuantity(e.getKey());
			quantity = heuristicDistributeQuantity(ass, quants, minmax, quantity);
			if (quantity > 0) {
				//				System.out.println("Quantities: " + quants.toString(minmax));
				for (ISyntaxConstraint x : ass)
					minmax.put(x, Tuples.create(getHardMin(x), getHardMax(x)));
				Collections.sort(ass, new QuantityComparator(quants));
				quantity = heuristicDistributeQuantity(ass, quants, minmax, quantity);
				if (quantity > 0)
					quants.setAssignmentQuantity(ass.get(0), quants.getAssignmentQuantity(ass.get(0)) + quantity);
			}
		}
	}

	protected int heuristicMaxTries(IQuantities quants, Multimap<EStructuralFeature, ISyntaxConstraint> multiAssignments) {
		int result = 10;
		for (EStructuralFeature f : quants.getEObject().eClass().getEAllStructuralFeatures())
			if (quants.getEObject().eIsSet(f)) {
				if (f.isMany())
					result += ((List<?>) quants.getEObject().eGet(f)).size();
				else
					result += 1;
			}
		return result * multiAssignments.values().size();
	}

	protected boolean heuristicOptimizeSolution(Quantities quants,
			Multimap<EStructuralFeature, ISyntaxConstraint> multiAssignments) {
		List<Triple<Integer, ISyntaxConstraint, Collection<ISyntaxConstraint>>> cands = Lists.newArrayList();
		Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : multiAssignments.asMap().entrySet()) {
			for (ISyntaxConstraint f : e.getValue()) {
				int min = intervalProvider.getMin(quants, f, Sets.<ISyntaxConstraint> newHashSet());
				int max = intervalProvider.getMax(quants, f, Sets.<ISyntaxConstraint> newHashSet(), e.getKey()
						.getName());
				minmax.put(f, Tuples.create(min, max));
			}
			for (ISyntaxConstraint f : e.getValue()) {
				int q = quants.getAssignmentQuantity(f);
				int diff = Math.max(0, minmax.get(f).getFirst() - q) + Math.max(0, q - minmax.get(f).getSecond());
				if (diff > 0)
					cands.add(Tuples.create(diff, f, e.getValue()));
			}
		}
		if (cands.isEmpty())
			return false;
		Triple<Integer, ISyntaxConstraint, Collection<ISyntaxConstraint>> c = cands.get(random.nextInt(cands.size()));
		ISyntaxConstraint f = c.getSecond();
		int q = quants.getAssignmentQuantity(f);
		if (q < minmax.get(f).getFirst()) {
			int addition = (int) Math.ceil((minmax.get(f).getFirst() - q) * 0.5f);
			addition = heuristicPullQuantities(quants, c.getThird(), minmax, f, addition);
			quants.setAssignmentQuantity(f, q + addition);
			//			System.out.println(f.getAssignmentName() + " + " + addition + "-> " + quants.toString() + " => "
			//					+ quants.getQuality());
		} else if (q > minmax.get(f).getSecond()) {
			int subtraction = (int) Math.ceil((q - minmax.get(f).getSecond()) * 0.5f);
			subtraction = heuristicPushQuantities(quants, c.getThird(), minmax, f, subtraction);
			quants.setAssignmentQuantity(f, q - subtraction);
			//			System.out.println(f.getAssignmentName() + " - " + subtraction + "-> " + quants.toString() + " => "
			//					+ quants.getQuality());
		}
		quants.consistencyCheck();
		return true;
	}

	protected int heuristicPullQuantities(Quantities quants, Collection<ISyntaxConstraint> assignments,
			Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax, ISyntaxConstraint ass, int wanted) {
		int result = 0;
		List<ISyntaxConstraint> involved = Lists.newArrayList();
		for (ISyntaxConstraint c : assignments)
			if (c != ass) {
				involved.add(c);
				int q = quants.getAssignmentQuantity(c);
				if (q > minmax.get(c).getFirst()) {
					int subtract = Math.min(wanted, q - minmax.get(c).getFirst());
					result += subtract;
					quants.setAssignmentQuantity(c, q - subtract);
					wanted -= subtract;
				}
			}
		while (result != wanted && involved.size() > 0) {
			int choice = random.nextInt(involved.size());
			ISyntaxConstraint c = involved.get(choice);
			int q = quants.getAssignmentQuantity(c);
			int subtract = Math.min(wanted, q);
			result += subtract;
			quants.setAssignmentQuantity(c, q - subtract);
			wanted -= subtract;
			involved.remove(choice);
		}
		return result;
	}

	protected int heuristicPushQuantities(Quantities quants, Collection<ISyntaxConstraint> assignments,
			Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax, ISyntaxConstraint ass, int wanted) {
		int result = 0;
		List<ISyntaxConstraint> involved = Lists.newArrayList();
		for (ISyntaxConstraint c : assignments)
			if (c != ass) {
				involved.add(c);
				int q = quants.getAssignmentQuantity(c);
				if (q < minmax.get(c).getSecond()) {
					int addition = Math.min(wanted, minmax.get(c).getSecond() - q);
					result += addition;
					quants.setAssignmentQuantity(c, q + addition);
					wanted -= addition;
				}
			}
		if (result != wanted) {
			ISyntaxConstraint c = involved.get(random.nextInt(involved.size()));
			result += wanted;
			quants.setAssignmentQuantity(c, quants.getAssignmentQuantity(c) + wanted);
		}
		return result;
	}

	protected void heuristicSolver(Quantities quants, Multimap<EStructuralFeature, ISyntaxConstraint> multiAssignments) {
		//		System.out.println();
		//		System.out.println("BeforeHeuristic: " + quants.toString());
		heuristicInitialSolution(quants, multiAssignments);
		//		System.out.println("InitalHeuristic: " + quants.toString());
		int currentTry = 0;
		int currentNoImprovement = 0;
		int bestQuality = MAX;
		int maxTries = heuristicMaxTries(quants, multiAssignments);
		int maxNoImprovement = (maxTries / 10) + 10;
		//		System.out.println("MaxTries: " + maxTries + " maxNoImprovement: " + maxNoImprovement);
		while (currentTry < maxTries && currentNoImprovement < maxNoImprovement
				&& heuristicOptimizeSolution(quants, multiAssignments)) {
			int quality = quants.getQuality();
			if (quality < bestQuality) {
				bestQuality = quality;
				currentNoImprovement = 0;
			} else
				currentNoImprovement++;
			currentTry++;
		}
	}

}
