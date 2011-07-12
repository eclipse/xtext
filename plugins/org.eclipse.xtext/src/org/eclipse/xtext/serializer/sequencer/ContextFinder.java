/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
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

	protected boolean allChildrenHaveContexts(EObject context, EObject semanicObj) {
		IConstraint constraint = constraints.get(Tuples.create(context, semanicObj.eClass()));
		if (constraint == null)
			return false;
		for (EReference ref : semanicObj.eClass().getEAllContainments())
			if (!isTransient(semanicObj, ref)) {
				IFeatureInfo fi = constraint.getFeatures()[semanicObj.eClass().getFeatureID(ref)];
				List<EObject> calledContexts = fi.getCalledContexts();
				if (ref.isMany()) {
					for (EObject child : getAllNonTransientValues(semanicObj, ref))
						if (Iterables.isEmpty(findContextsByContents(child, calledContexts)))
							return false;
				} else {
					EObject child = (EObject) semanicObj.eGet(ref);
					if (Iterables.isEmpty(findContextsByContents(child, calledContexts)))
						return false;
				}
			}
		return true;
	}

	protected boolean allFeaturesHaveAssignments(EObject context, EObject semanicObj) {
		IConstraint constraint = constraints.get(Tuples.create(context, semanicObj.eClass()));
		if (constraint == null)
			return false;
		for (int featureID = 0; featureID < semanicObj.eClass().getFeatureCount(); featureID++)
			if (!isTransient(semanicObj, semanicObj.eClass().getEStructuralFeature(featureID))
					&& constraint.getFeatures()[featureID] == null)
				return false;
		return true;
	}

	public Iterable<EObject> findContextsByContents(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		initConstraints();
		if (contextCandidates != null) {
			List<EObject> cands = Lists.newArrayList();
			for (EObject ctx : contextCandidates)
				if (constraints.get(Tuples.create(ctx, semanitcObject.eClass())) != null)
					cands.add(ctx);
			contextCandidates = cands;
		} else
			contextCandidates = getAllContextsForType(semanitcObject.eClass());
		//		if (Iterables.size(contextCandidates) < 2)
		//			return contextCandidates;
		List<EObject> filtered1 = Lists.newArrayList();
		for (EObject cand : contextCandidates)
			if (allFeaturesHaveAssignments(cand, semanitcObject))
				filtered1.add(cand);
		//		if (filtered1.size() < 2)
		//			return filtered1;
		List<EObject> filtered2 = Lists.newArrayList();
		for (EObject cand : filtered1)
			if (allChildrenHaveContexts(cand, semanitcObject))
				filtered2.add(cand);
		//		if (filtered2.size() < 2)
		//			return filtered2;
		return filtered2;
	}

	public Iterable<EObject> findContextsByContentsAndContainer(EObject semanitcObject,
			Iterable<EObject> contextCandidates) {
		return findContextsByContents(semanitcObject, contextCandidates);
	}

	protected Set<EObject> getAllContextsForType(EClass cls) {
		Set<EObject> result = Sets.newHashSet();
		for (IConstraintContext cc : constraintContexts)
			for (IConstraint c : cc.getConstraints())
				if (c.getType() == cls) {
					result.add(cc.getContext());
					break;
				}
		return result;
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
