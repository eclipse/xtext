/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import static org.eclipse.xtext.validation.IAssignmentQuantityIntervalProvider.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider.IConcreteSyntaxDiagnostic;
import org.eclipse.xtext.validation.IAssignmentQuantityIntervalProvider;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator;
import org.eclipse.xtext.validation.IConcreteSyntaxValidator;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator.IQuantities;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidator implements IConcreteSyntaxValidator {

	@Inject
	protected IConcreteSyntaxConstraintProvider constraintProvider;

	@Inject
	protected IConcreteSyntaxDiagnosticProvider diagnosticProvider;

	@Inject
	protected IAssignmentQuantityIntervalProvider intervalProvider;

	@Inject
	protected IAssignmentQuantityAllocator quantityProvider;

	@Inject
	protected ITransientValueService transSrvc;

	protected Set<ISyntaxConstraint> collectUnfulfilledSemanticElements(EClass cls, ISyntaxConstraint ele) {
		if (ele.isOptional())
			return Collections.emptySet();
		if (ele.getSemanticTypesToCheck() != null && !ele.getSemanticTypesToCheck().contains(cls))
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

	public boolean isEObjectTransient(EObject obj) {
		if (obj.eContainmentFeature() == null)
			return false;
		EReference ref = obj.eContainmentFeature();
		EObject cnt = obj.eContainer();
		if (ref.isMany() && transSrvc.isCheckElementsIndividually(cnt, ref)) {
			if (transSrvc.isTransient(cnt, ref, ((List<?>) cnt.eGet(ref)).indexOf(obj)))
				return true;
		} else if (transSrvc.isTransient(cnt, ref, 0))
			return true;
		return false;
	}

	@Override
	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		if (isEObjectTransient(obj))
			return true;
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Collection<ISyntaxConstraint> rules = constraintProvider.getConstraints(obj.eClass());
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

	protected List<IConcreteSyntaxDiagnostic> validateQuantities(IQuantities quants, ISyntaxConstraint rule) {
		List<IConcreteSyntaxDiagnostic> diag = new ArrayList<IConcreteSyntaxDiagnostic>();
		Map<ISyntaxConstraint, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<ISyntaxConstraint>> e : quants.groupByFeature().entrySet()) {
			int min = UNDEF, max = 0;
			Set<ISyntaxConstraint> involved = new HashSet<ISyntaxConstraint>();
			for (ISyntaxConstraint a : e.getValue()) {
				involved.add(a);
				int mi = intervalProvider.getMin(quants, a, involved);
				if (mi != UNDEF)
					min = min == UNDEF ? mi : mi + min;
				int ma = intervalProvider.getMax(quants, a, involved, null);
				if (ma != UNDEF && max != MAX)
					max = ma == MAX ? ma : max + ma;
				minmax.put(a, Tuples.create(mi, ma));
			}
			int actual = quants.getFeatureQuantity(e.getKey());
			if (actual < min || actual > max)
				diag.add(diagnosticProvider.createFeatureQuantityDiagnostic(rule, quants, e.getKey(), actual, min, max,
						involved));
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
			allDiags.add(diagnosticProvider.createUnexpectedTypeDiagnostic(rule, obj, expectedTypes));
		if (!allDiags.isEmpty())
			return allDiags;
		IQuantities quantities = quantityProvider.getAssignmentQuantities(obj, rule, allDiags);
		if (quantities == null || !allDiags.isEmpty())
			return allDiags;
		List<IConcreteSyntaxDiagnostic> diags = validateQuantities(quantities, rule);
		if (diags.isEmpty())
			return diags;
		allDiags.addAll(diags);
		return allDiags;
	}

}
