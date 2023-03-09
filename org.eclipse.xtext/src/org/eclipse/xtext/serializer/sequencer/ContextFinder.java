/*******************************************************************************
 * Copyright (c) 2011, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import static org.eclipse.xtext.serializer.analysis.SerializationContext.*;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ContextFinder implements IContextFinder {

	@Inject
	protected IAssignmentFinder assignmentFinder;

	protected SerializationContextMap<IConstraint> constraints;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	@Inject
	protected ISemanticNodeProvider nodesProvider;

	@Inject
	protected RuleNames ruleNames;

	@Inject
	protected ITransientValueService transientValues;

	@Inject
	protected TransientValueUtil transientValueUtil;

	protected Set<AbstractElement> findAssignedElements(EObject obj, EStructuralFeature feature,
			Multimap<AbstractElement, ISerializationContext> assignments) {
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
							r.addAll(assignmentFinder.findAssignmentsByValue(obj, assignments, value, node));
							j++;
						}
					return r;
				case NO:
					List<?> values2 = (List<?>) obj.eGet(feature);
					for (int i = 0; i < values2.size(); i++) {
						Object value = values2.get(i);
						INode node = nodes.getNodeForMultiValue(feature, i, i, value);
						r.addAll(assignmentFinder.findAssignmentsByValue(obj, assignments, value, node));
					}
					return r;
				default:
					return Collections.emptySet();
			}
		} else {
			if (transientValues.isValueTransient(obj, feature) == ValueTransient.YES)
				return Collections.emptySet();
			Object value = obj.eGet(feature);
			INode node = nodesProvider.getNodesForSemanticObject(obj, null).getNodeForSingelValue(feature, value);
			return assignmentFinder.findAssignmentsByValue(obj, assignments, value, node);
		}
	}

	protected Multimap<AbstractElement, ISerializationContext> collectAssignments(Multimap<IConstraint, ISerializationContext> constraints,
			EStructuralFeature feature) {
		Multimap<AbstractElement, ISerializationContext> result = ArrayListMultimap.create();
		for (Entry<IConstraint, Collection<ISerializationContext>> e : constraints.asMap().entrySet()) {
			IConstraint constraint = e.getKey();
			Collection<ISerializationContext> contexts = e.getValue();
			IFeatureInfo featureInfo = constraint.getFeatures()[constraint.getType().getFeatureID(feature)];
			List<IConstraintElement> assignments = featureInfo.getAssignments();
			for (IConstraintElement assignment : assignments) {
				result.putAll(assignment.getGrammarElement(), contexts);
			}
		}
		return result;
	}

	@Override
	public Set<ISerializationContext> findByContents(EObject semanticObject, Iterable<ISerializationContext> contextCandidates) {
		if (semanticObject == null)
			throw new NullPointerException();

		initConstraints();

		Multimap<IConstraint, ISerializationContext> constraints;
		if (contextCandidates != null)
			constraints = getConstraints(semanticObject, contextCandidates);
		else
			constraints = getConstraints(semanticObject);

		if (constraints.size() < 2)
			return Sets.newLinkedHashSet(constraints.values());

		for (IConstraint cand : Lists.newArrayList(constraints.keySet()))
			if (!isValidValueQuantity(cand, semanticObject))
				constraints.removeAll(cand);

		if (constraints.size() < 2)
			return Sets.newLinkedHashSet(constraints.values());

		LinkedHashSet<ISerializationContext> result = Sets.newLinkedHashSet(constraints.values());
		for (EStructuralFeature feat : semanticObject.eClass().getEAllStructuralFeatures()) {
			if (transientValueUtil.isTransient(semanticObject, feat) != ValueTransient.NO)
				continue;
			if (feat.isMany() && ((List<?>) semanticObject.eGet(feat)).isEmpty())
				continue;
			Multimap<AbstractElement, ISerializationContext> assignments = collectAssignments(constraints, feat);
			Set<AbstractElement> assignedElements = findAssignedElements(semanticObject, feat, assignments);
			Set<ISerializationContext> keep = Sets.newHashSet();
			for (AbstractElement ele : assignedElements)
				keep.addAll(assignments.get(ele));
			result.retainAll(keep);
		}
		return result;
	}

	@Override
	public Set<ISerializationContext> findByContentsAndContainer(EObject semanticObject,
			Iterable<ISerializationContext> contextCandidates) {
		initConstraints();
		contextCandidates = findContextsByContainer(semanticObject, contextCandidates);
		if (contextCandidates != null && Iterables.size(contextCandidates) < 2)
			return Sets.newLinkedHashSet(contextCandidates);
		return findByContents(semanticObject, contextCandidates);
	}

	protected List<ISerializationContext> createContextsForFeatures(Collection<ISerializationContext> containers, IFeatureInfo feature,
			EObject sem) {
		List<ISerializationContext> result = Lists.newArrayList();
		for (IConstraintElement assignment : feature.getAssignments()) {
			for (ISerializationContext container : containers) {
				result.add(SerializationContext.forChild(container, assignment.getGrammarElement(), sem));
			}
		}
		return result;
	}

	protected Iterable<ISerializationContext> findContextsByContainer(EObject sem, Iterable<ISerializationContext> contextCandidates) {
		if (sem.eResource() != null && sem.eResource().getContents().contains(sem))
			return Collections.singleton(getRootContext(sem));
		EReference ref = sem.eContainmentFeature();
		if (ref == null || (contextCandidates != null && Iterables.size(contextCandidates) < 2))
			return contextCandidates;
		Multimap<IConstraint, ISerializationContext> containerConstraints = getConstraints(sem.eContainer());
		int refID = sem.eContainer().eClass().getFeatureID(ref);
		Set<ISerializationContext> childContexts = Sets.newLinkedHashSet();
		for (Entry<IConstraint, Collection<ISerializationContext>> e : Lists.newArrayList(containerConstraints.asMap().entrySet())) {
			IConstraint constraint = e.getKey();
			Collection<ISerializationContext> contexts = e.getValue();
			if (constraint.getFeatures()[refID] == null)
				containerConstraints.removeAll(constraint);
			else {
				childContexts.addAll(createContextsForFeatures(contexts, constraint.getFeatures()[refID], sem));
			}
		}
		Set<ISerializationContext> result;
		if (contextCandidates != null) {
			result = Sets.newLinkedHashSet(contextCandidates);
			result.retainAll(childContexts);
		} else
			result = childContexts;
		if (result.size() < 2)
			return result;
		Iterable<ISerializationContext> filteredContexts = findContextsByContainer(sem.eContainer(), containerConstraints.values());
		childContexts = Sets.newLinkedHashSet();
		for (Entry<IConstraint, Collection<ISerializationContext>> e : Lists.newArrayList(containerConstraints.asMap().entrySet()))
			if (intersect(filteredContexts, e.getValue()))
				childContexts.addAll(createContextsForFeatures(e.getValue(), e.getKey().getFeatures()[refID], sem));
		result.retainAll(childContexts);
		return result;
	}

	@Override
	@Deprecated
	public Iterable<EObject> findContextsByContents(EObject semanticObject, Iterable<EObject> contextCandidates) {
		List<ISerializationContext> candidates = fromEObjects(contextCandidates, semanticObject);
		return fromIContexts(findByContents(semanticObject, candidates));
	}

	@Override
	@Deprecated
	public Iterable<EObject> findContextsByContentsAndContainer(EObject semanticObject, Iterable<EObject> contextCandidates) {
		List<ISerializationContext> candidates = fromEObjects(contextCandidates, semanticObject);
		return fromIContexts(findByContentsAndContainer(semanticObject, candidates));
	}

	protected Multimap<IConstraint, ISerializationContext> getConstraints(EObject sem) {
		EClass type = sem == null ? null : sem.eClass();
		Multimap<IConstraint, ISerializationContext> result = ArrayListMultimap.create();
		for (SerializationContextMap.Entry<IConstraint> e : constraints.values()) {
			IConstraint constraint = e.getValue();
			for (ISerializationContext context : e.getContexts()) {
				if (constraint.getType() == type) {
					result.put(constraint, context);
				}
			}
		}
		return result;
	}

	protected Multimap<IConstraint, ISerializationContext> getConstraints(EObject sem, Iterable<ISerializationContext> contextCandidates) {
		EClass type = sem == null ? null : sem.eClass();
		Multimap<IConstraint, ISerializationContext> result = ArrayListMultimap.create();
		for (ISerializationContext ctx : contextCandidates) {
			IConstraint constraint = constraints.get(ctx);
			if (constraint != null && constraint.getType() == type) {
				result.put(constraint, ctx);
			}
		}
		return result;
	}

	protected ISerializationContext getRootContext(EObject sem) {
		for (AbstractRule rule : ruleNames.getAllRules())
			if (GrammarUtil.isEObjectRule(rule))
				return SerializationContext.fromEObject(rule, sem);
		throw new RuntimeException("There is no parser rule in the grammar.");
	}

	public void initConstraints() {
		if (constraints == null) {
			constraints = grammarConstraintProvider.getConstraints(ruleNames.getContextGrammar());
		}
	}

	protected boolean intersect(Iterable<ISerializationContext> it1, Iterable<ISerializationContext> it2) {
		for (ISerializationContext i1 : it1)
			for (ISerializationContext i2 : it2)
				if (i1.equals(i2))
					return true;
		return false;
	}

	protected boolean isValidValueQuantity(IConstraint constraint, EObject semanicObj) {
		if (constraint == null)
			return false;
		for (int featureID = 0; featureID < semanicObj.eClass().getFeatureCount(); featureID++) {
			IFeatureInfo featureInfo = constraint.getFeatures()[featureID];
			EStructuralFeature feature = semanicObj.eClass().getEStructuralFeature(featureID);
			if (feature.isMany()) {
				int count = transientValueUtil.countNonTransientListValues(semanicObj, feature);
				if (count > featureInfo.getUpperBound())
					return false;
				if (count < featureInfo.getLowerBound())
					return false;
			} else {
				ValueTransient valueTransient = transientValues.isValueTransient(semanicObj, feature);
				switch (valueTransient) {
					case NO:
						if (featureInfo == null)
							return false;
						if (featureInfo.getUpperBound() <= 0)
							return false;
						break;
					case YES:
						if (featureInfo == null)
							break;
						if (featureInfo.getLowerBound() > 0)
							return false;
						break;
					case PREFERABLY:
						break;
				}
			}
		}
		return true;
	}

}
