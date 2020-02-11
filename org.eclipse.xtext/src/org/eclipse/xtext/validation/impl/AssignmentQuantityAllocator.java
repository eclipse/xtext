/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer.IValueSerializer;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator;
import org.eclipse.xtext.validation.IAssignmentQuantityIntervalProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ConstraintType;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentQuantityAllocator implements IAssignmentQuantityAllocator {

	protected class Quantities implements IQuantities {
		protected Map<ISyntaxConstraint, Integer> assignmentQuants = Maps.newHashMap();
		protected EObject delegate;
		protected Map<EStructuralFeature, Integer> featureQuants = Maps.newHashMap();

		public Quantities(EObject delegate) {
			super();
			this.delegate = delegate;
		}

		@Override
		public Map<ISyntaxConstraint, Integer> getAssignmentQuantities() {
			return assignmentQuants;
		}

		@Override
		public Integer getAssignmentQuantity(ISyntaxConstraint assignement) {
			Integer i = assignmentQuants.get(assignement);
			return i == null || i < 0 ? -1 : i;
		}

		@Override
		public EObject getEObject() {
			return delegate;
		}

		@Override
		public Map<EStructuralFeature, Integer> getFeatureQuantities() {
			return featureQuants;
		}

		@Override
		public Integer getFeatureQuantity(EStructuralFeature feat) {
			Integer i = featureQuants.get(feat);
			return i == null || i < 0 ? -1 : i;
		}

		@Override
		public Map<EStructuralFeature, Collection<ISyntaxConstraint>> groupByFeature() {
			Multimap<EStructuralFeature, ISyntaxConstraint> map = HashMultimap.create();
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

	@Inject
	protected IConcreteSyntaxDiagnosticProvider diagnosticProvider;

	@Inject
	protected IAssignmentQuantityIntervalProvider intervalProvider;

	@Inject
	protected ITransientValueService transSrvc;

	@Inject
	protected IValueSerializer valueSerializer;

	protected boolean allowTransient(EObject obj, EStructuralFeature feature, Collection<ISyntaxConstraint> constraint) {
		if (feature.getEType() instanceof EEnum)
			return true;
		Object value = obj.eGet(feature);
		List<RuleCall> ruleCalls = GrammarUtil.containedRuleCalls(constraint.iterator().next().getGrammarElement());
		if (ruleCalls.isEmpty())
			return false;
		return valueSerializer.isValid(obj, ruleCalls.get(0), value, null);

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

	@Override
	public IQuantities getAssignmentQuantities(EObject obj, ISyntaxConstraint rule,
			List<IConcreteSyntaxDiagnostic> acceptor) {
		Multimap<EStructuralFeature, ISyntaxConstraint> assignments = HashMultimap.create();
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
		Multimap<EStructuralFeature, ISyntaxConstraint> multipleAssignments = HashMultimap.create();
		Multimap<EStructuralFeature, ISyntaxConstraint> allowTransients = HashMultimap.create();
		for (Map.Entry<EStructuralFeature, Integer> f : quants.getFeatureQuantities().entrySet()) {
			Collection<ISyntaxConstraint> ass = assignments.get(f.getKey());
			if (ass.isEmpty())
				continue;
			boolean allowTransient = f.getKey() instanceof EAttribute && !f.getKey().isMany() && f.getValue() == 0
					&& allowTransient(obj, f.getKey(), ass);
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
		return null;
		// TODO: implement an algorithm to handle multipleAssignments. For details, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=310454 
	}

	@Override
	public int getFeatureQuantity(EObject obj, EStructuralFeature feat) {
		if (feat.isMany()) {
			int count = 0, max = ((List<?>) obj.eGet(feat)).size();
			if (transSrvc.isCheckElementsIndividually(obj, feat)) {
				for (int i = 0; i < max; i++)
					if (!transSrvc.isTransient(obj, feat, i))
						count++;
				return count;
			}
			return transSrvc.isTransient(obj, feat, 0) ? 0 : max;
		}
		return transSrvc.isTransient(obj, feat, 0) ? 0 : 1;
	}

}
