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
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
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

	@Inject
	protected IAssignmentFinder assignmentFinder;

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected RuleNames ruleNames;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	@Inject
	protected TransientValueUtil transientValueUtil;
	
	@Inject
	protected ITransientValueService transientValues;
	
	@Inject
	protected ISemanticNodeProvider nodesProvider;

	protected Iterable<AbstractElement> findAssignedElements(EObject obj, EStructuralFeature feature,
			Iterable<AbstractElement> candidates) {
		if (feature.isMany()) {
			Set<AbstractElement> r = Sets.newLinkedHashSet();
			INodesForEObjectProvider nodes = nodesProvider.getNodesForSemanticObject(obj, null);
			switch (transientValues.isListTransient(obj, feature)) {
				case SOME:
					List<?> values1 = (List<?>) obj.eGet(feature);
					int j = 0;
					for (int i = 0; i < values1.size(); i++)
						if (!transientValues.isValueInListTransient(obj, i, feature)) {
							Object value = values1.get(i);
							INode node = nodes.getNodeForMultiValue(feature, i, j, value);
							Iterables.addAll(r, assignmentFinder.findAssignmentsByValue(obj, candidates, value, node));
							j++;
						}
					return r;
				case NO:
					List<?> values2 = (List<?>) obj.eGet(feature);
					for (int i = 0; i < values2.size(); i++) {
						Object value = values2.get(i);
						INode node = nodes.getNodeForMultiValue(feature, i, i, value);
						Iterables.addAll(r, assignmentFinder.findAssignmentsByValue(obj, candidates, value, node));
					}
					return r;
				default:
					return Collections.emptyList();
			}
		} else {
			if (transientValues.isValueTransient(obj, feature) == ValueTransient.YES)
				return Collections.emptyList();
			Object value = obj.eGet(feature);
			INode node = nodesProvider.getNodesForSemanticObject(obj, null).getNodeForSingelValue(feature, value);
			return assignmentFinder.findAssignmentsByValue(obj, candidates, value, node);
		}
	}

	protected Iterable<EObject> findContextsByContainer(EObject semanticObject, Iterable<EObject> contextCandidates) {
		if (semanticObject.eResource() != null && semanticObject.eResource().getContents().contains(semanticObject))
			return Collections.singleton(getRootContext());
		EReference ref = semanticObject.eContainmentFeature();
		if (ref == null || (contextCandidates != null && Iterables.size(contextCandidates) < 2))
			return contextCandidates;
		Map<IConstraint, List<EObject>> containerConstraints = getConstraints(semanticObject.eContainer().eClass());
		int refID = semanticObject.eContainer().eClass().getFeatureID(ref);
		Set<EObject> childContexts = Sets.newLinkedHashSet();
		for (IConstraint constraint : Lists.newArrayList(containerConstraints.keySet()))
			if (constraint.getFeatures()[refID] == null)
				containerConstraints.remove(constraint);
			else
				childContexts.addAll(constraint.getFeatures()[refID].getCalledContexts());

		Set<EObject> result;
		if (contextCandidates != null) {
			result = Sets.newLinkedHashSet(contextCandidates);
			result.retainAll(childContexts);
		} else
			result = childContexts;
		if (result.size() < 2)
			return result;
		Iterable<EObject> filteredContexts = findContextsByContainer(semanticObject.eContainer(),
				Iterables.concat(containerConstraints.values()));
		childContexts = Sets.newLinkedHashSet();
		for (Map.Entry<IConstraint, List<EObject>> e : Lists.newArrayList(containerConstraints.entrySet()))
			if (intersect(filteredContexts, e.getValue()))
				childContexts.addAll(e.getKey().getFeatures()[refID].getCalledContexts());
		result.retainAll(childContexts);
		return result;
	}

	@Override
	public Iterable<EObject> findContextsByContents(EObject semanticObject, Iterable<EObject> contextCandidates) {
		if (semanticObject == null)
			throw new NullPointerException();

		initConstraints();

		Map<IConstraint, List<EObject>> constraints;
		if (contextCandidates != null)
			constraints = getConstraints(semanticObject, contextCandidates);
		else
			constraints = getConstraints(semanticObject.eClass());

		if (constraints.size() < 2)
			return Iterables.concat(constraints.values());

		for (IConstraint cand : Lists.newArrayList(constraints.keySet()))
			if (!isValidValueQuantity(cand, semanticObject))
				constraints.remove(cand);

		if (constraints.size() < 2)
			return Iterables.concat(constraints.values());

		for (EStructuralFeature feat : semanticObject.eClass().getEAllStructuralFeatures())
			if (transientValueUtil.isTransient(semanticObject, feat) == ValueTransient.NO) {
				constraints.keySet().retainAll(findContextsByValue(semanticObject, feat, constraints.keySet()));
				if (constraints.size() < 2)
					return Iterables.concat(constraints.values());
			}
		return Iterables.concat(constraints.values());
	}

	@Override
	public Iterable<EObject> findContextsByContentsAndContainer(EObject semanticObject,
			Iterable<EObject> contextCandidates) {
		initConstraints();
		contextCandidates = findContextsByContainer(semanticObject, contextCandidates);
		if (contextCandidates != null && Iterables.size(contextCandidates) < 2)
			return contextCandidates;
		return findContextsByContents(semanticObject, contextCandidates);
	}

	protected Collection<IConstraint> findContextsByValue(EObject semanicObj, EStructuralFeature feature,
			Iterable<IConstraint> constraints) {
		Multimap<IConstraint, AbstractElement> contexts = LinkedHashMultimap.create();
		int refID = semanicObj.eClass().getFeatureID(feature);
		for (IConstraint constraint : constraints)
			for (IConstraintElement ass : constraint.getFeatures()[refID].getAssignments())
				contexts.put(constraint, ass.getGrammarElement());
		Set<AbstractElement> ass = Sets.newHashSet(findAssignedElements(semanicObj, feature, contexts.values()));
		for (IConstraint constraint : constraints)
			if (Collections.disjoint(contexts.get(constraint), ass))
				contexts.removeAll(constraint);
		return contexts.keySet();
	}

	protected Map<IConstraint, List<EObject>> getConstraints(EClass cls) {
		Map<IConstraint, List<EObject>> result = Maps.newLinkedHashMap();
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

	protected Map<IConstraint, List<EObject>> getConstraints(EObject semanticObject, Iterable<EObject> contextCandidates) {
		Map<IConstraint, List<EObject>> result = Maps.newLinkedHashMap();
		for (EObject ctx : contextCandidates) {
			IConstraint constraint = constraints.get(Tuples.create(ctx, semanticObject.eClass()));
			if (ctx == null)
				continue;
			List<EObject> ctxs = result.get(constraint);
			if (ctxs == null)
				result.put(constraint, ctxs = Lists.newArrayList());
			ctxs.add(ctx);
		}
		return result;
	}

	protected EObject getRootContext() {
		for (AbstractRule rule : ruleNames.getAllRules())
			if (GrammarUtil.isEObjectRule(rule))
				return rule;
		throw new RuntimeException("There is no parser rule in the grammar.");
	}

	protected void initConstraints() {
		if (constraintContexts == null) {
			constraints = Maps.newLinkedHashMap();
			constraintContexts = grammarConstraintProvider.getConstraints(ruleNames.getContextGrammar());
			//			System.out.println(Joiner.on("\n").join(constraintContexts));
			for (IConstraintContext ctx : constraintContexts)
				for (IConstraint constraint : ctx.getConstraints())
					constraints.put(Tuples.create(ctx.getContext(), constraint.getType()), constraint);
		}
	}

	protected boolean intersect(Iterable<EObject> it1, Iterable<EObject> it2) {
		for (EObject i1 : it1)
			for (EObject i2 : it2)
				if (i1 == i2)
					return true;
		return false;
	}

	protected boolean isMandatory(IFeatureInfo feature) {
		if (feature == null)
			return false;
		for (IConstraintElement ce : feature.getAssignments())
			if (!ce.isOptionalRecursive(null))
				return true;
		return false;
	}

	protected boolean isValidValueQuantity(IConstraint constraint, EObject semanicObj) {
		if (constraint == null)
			return false;
		for (int featureID = 0; featureID < semanicObj.eClass().getFeatureCount(); featureID++) {
			IFeatureInfo featureInfo = constraint.getFeatures()[featureID];
			EStructuralFeature structuralFeature = semanicObj.eClass().getEStructuralFeature(featureID);
			ValueTransient trans = transientValueUtil.isTransient(semanicObj, structuralFeature);
			if (trans == ValueTransient.NO && featureInfo == null)
				return false;
			if (trans == ValueTransient.YES && isMandatory(featureInfo))
				return false;
		}
		return true;
	}

}
