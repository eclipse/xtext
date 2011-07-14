/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
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
public class ContextFinder implements IContextFinder {

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	@Inject
	protected ITransientValueService transientValues;

	protected boolean allFeaturesHaveAssignments(IConstraint constraint, EObject semanicObj) {
		if (constraint == null)
			return false;
		for (int featureID = 0; featureID < semanicObj.eClass().getFeatureCount(); featureID++)
			if (!isTransient(semanicObj, semanicObj.eClass().getEStructuralFeature(featureID))
					&& constraint.getFeatures()[featureID] == null)
				return false;
		return true;
	}

	protected Collection<IConstraint> findContextsByConstraints(EObject semanicObj, EReference ref,
			Iterable<IConstraint> constraints) {
		Multimap<IConstraint, EObject> contexts = HashMultimap.create();
		int refID = semanicObj.eClass().getFeatureID(ref);
		for (IConstraint constraint : constraints)
			contexts.putAll(constraint, constraint.getFeatures()[refID].getCalledContexts());
		Set<EObject> validContexts = Sets.newHashSet(findContextsByReference(semanicObj, ref, contexts.values()));
		for (IConstraint constraint : constraints)
			if (!contexts.get(constraint).containsAll(validContexts))
				contexts.removeAll(constraint);
		return contexts.keySet();
	}

	public Iterable<EObject> findContextsByContents(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		if (semanitcObject == null)
			throw new NullPointerException();

		initConstraints();

		Map<IConstraint, List<EObject>> constraints;
		if (contextCandidates != null)
			constraints = getConstraints(semanitcObject, contextCandidates);
		else
			constraints = getConstraints(semanitcObject.eClass());

		if (constraints.size() < 2)
			return Iterables.concat(constraints.values());

		for (IConstraint cand : Lists.newArrayList(constraints.keySet()))
			if (!allFeaturesHaveAssignments(cand, semanitcObject))
				constraints.remove(cand);

		if (constraints.size() < 2)
			return Iterables.concat(constraints.values());

		for (EReference ref : semanitcObject.eClass().getEAllContainments())
			if (!isTransient(semanitcObject, ref)) {
				constraints.keySet().retainAll(findContextsByConstraints(semanitcObject, ref, constraints.keySet()));
				if (constraints.size() < 2)
					return Iterables.concat(constraints.values());
			}
		return Iterables.concat(constraints.values());
	}

	@Inject
	protected IGrammarAccess grammar;

	protected EObject getRootContext() {
		for (AbstractRule rule : grammar.getGrammar().getRules())
			if (GrammarUtil.isEObjectRule(rule))
				return rule;
		throw new RuntimeException("There is no parser rule in the grammar.");
	}

	protected Iterable<EObject> findContextsByContainer(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		if (semanitcObject.eResource().getContents().contains(semanitcObject))
			return Collections.singleton(getRootContext());
		EReference ref = semanitcObject.eContainmentFeature();
		if (ref == null || (contextCandidates != null && Iterables.size(contextCandidates) < 2))
			return contextCandidates;
		Map<IConstraint, List<EObject>> containerConstraints = getConstraints(semanitcObject.eContainer().eClass());
		int refID = semanitcObject.eContainer().eClass().getFeatureID(ref);
		Set<EObject> childContexts = Sets.newHashSet();
		for (IConstraint constraint : Lists.newArrayList(containerConstraints.keySet()))
			if (constraint.getFeatures()[refID] == null)
				containerConstraints.remove(constraint);
			else
				childContexts.addAll(constraint.getFeatures()[refID].getCalledContexts());

		Set<EObject> result;
		if (contextCandidates != null) {
			result = Sets.newHashSet(contextCandidates);
			result.retainAll(childContexts);
		} else
			result = childContexts;
		if (result.size() < 2)
			return result;
		Iterable<EObject> filteredContexts = findContextsByContainer(semanitcObject.eContainer(),
				Iterables.concat(containerConstraints.values()));
		childContexts = Sets.newHashSet();
		for (Map.Entry<IConstraint, List<EObject>> e : Lists.newArrayList(containerConstraints.entrySet()))
			if (intersect(filteredContexts, e.getValue()))
				childContexts.addAll(e.getKey().getFeatures()[refID].getCalledContexts());
		result.retainAll(childContexts);
		return result;
	}

	protected boolean intersect(Iterable<EObject> it1, Iterable<EObject> it2) {
		for (EObject i1 : it1)
			for (EObject i2 : it2)
				if (i1 == i2)
					return true;
		return false;
	}

	public Iterable<EObject> findContextsByContentsAndContainer(EObject semanticObject,
			Iterable<EObject> contextCandidates) {
		initConstraints();
		contextCandidates = findContextsByContainer(semanticObject, contextCandidates);
		if (Iterables.size(contextCandidates) < 2)
			return contextCandidates;
		return findContextsByContents(semanticObject, contextCandidates);
	}

	protected Iterable<EObject> findContextsByReference(EObject semanicObj, EReference ref,
			Iterable<EObject> contextCandidates) {
		if (ref.isMany()) {
			Set<EObject> result = Sets.newHashSet();
			for (EObject child : getAllNonTransientValues(semanicObj, ref))
				Iterables.addAll(result, findContextsByContents(child, contextCandidates));
			return result;
		} else {
			EObject child = (EObject) semanicObj.eGet(ref);
			return findContextsByContents(child, contextCandidates);
		}
	}

	@SuppressWarnings("unchecked")
	protected List<EObject> getAllNonTransientValues(EObject container, EReference ref) {
		switch (transientValues.isListTransient(container, ref)) {
			case SOME:
				List<EObject> result = Lists.newArrayList();
				List<?> values = (List<?>) container.eGet(ref);
				for (int i = 0; i < values.size(); i++)
					if (!transientValues.isValueInListTransient(container, i, ref))
						result.add((EObject) values.get(i));
				return result;
			case NO:
				return (List<EObject>) container.eGet(ref);
			case YES:
				return Collections.emptyList();
		}
		return Collections.emptyList();
	}

	protected Map<IConstraint, List<EObject>> getConstraints(EClass cls) {
		Map<IConstraint, List<EObject>> result = Maps.newHashMap();
		for (IConstraintContext cc : constraintContexts)
			for (IConstraint constraint : cc.getConstraints())
				if (constraint.getType() == cls) {
					List<EObject> ctxs = result.get(constraint);
					if (ctxs == null)
						result.put(constraint, ctxs = Lists.newArrayList());
					ctxs.add(cc.getContext());
				}
		return result;
	}

	protected Map<IConstraint, List<EObject>> getConstraints(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		Map<IConstraint, List<EObject>> result = Maps.newHashMap();
		for (EObject ctx : contextCandidates) {
			IConstraint constraint = constraints.get(Tuples.create(ctx, semanitcObject.eClass()));
			if (ctx == null)
				continue;
			List<EObject> ctxs = result.get(constraint);
			if (ctxs == null)
				result.put(constraint, ctxs = Lists.newArrayList());
			ctxs.add(ctx);
		}
		return result;
	}

	protected void initConstraints() {
		if (constraintContexts == null) {
			constraints = Maps.newHashMap();
			constraintContexts = grammarConstraintProvider.getConstraints(grammarAccess.getGrammar());
			//			System.out.println(Joiner.on("\n").join(constraintContexts));
			for (IConstraintContext ctx : constraintContexts)
				for (IConstraint constraint : ctx.getConstraints())
					constraints.put(Tuples.create(ctx.getContext(), constraint.getType()), constraint);
		}
	}

	protected boolean isTransient(EObject obj, EStructuralFeature feature) {
		if (feature.isMany())
			switch (transientValues.isListTransient(obj, feature)) {
				case NO:
					return false;
				case YES:
					return true;
				case SOME:
					List<?> values = (List<?>) obj.eGet(feature);
					for (int i = 0; i < values.size(); i++)
						if (!transientValues.isValueInListTransient(obj, i, feature))
							return false;
					return true;
			}
		else
			switch (transientValues.isValueTransient(obj, feature)) {
				case NO:
					return false;
				case YES:
					return true;
				case PREFERABLY:
					return true;

			}
		return true;
	}

}
