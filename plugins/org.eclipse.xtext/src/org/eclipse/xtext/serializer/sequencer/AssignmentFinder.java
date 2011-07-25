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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IEnumLiteralSerializer;
import org.eclipse.xtext.serializer.tokens.IKeywordSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class AssignmentFinder implements IAssignmentFinder {

	@Inject
	protected IContextFinder contextFinder;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected IEnumLiteralSerializer enumLiteralSerializer;

	@Inject
	protected IKeywordSerializer keywordSerializer;

	@Inject
	protected IValueSerializer valueSerializer;

	public Iterable<AbstractElement> findAssignmentsByValue(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value, INode node) {
		EStructuralFeature feature = FeatureFinderUtil.getFeature(assignedElements.iterator().next(),
				semanticObj.eClass());
		if (feature instanceof EAttribute) {
			Class<?> clazz = feature.getEType().getInstanceClass();
			if (clazz == Boolean.class || clazz == boolean.class)
				return findValidBooleanAssignments(semanticObj, assignedElements, value);
			else if (feature.getEType() instanceof EEnum)
				return findValidAssignmentsForEnum(semanticObj, assignedElements, value);
			else
				return findValidAssignmentsForDatatype(semanticObj, assignedElements, value);
		} else if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			if (ref.isContainment())
				return findValidAssignmentsForContainmentRef(semanticObj, assignedElements, (EObject) value);
			else
				return findValidAssignmentsForCrossRef(semanticObj, assignedElements, (EObject) value, node);
		}
		throw new RuntimeException("unknown feature type");
	}

	protected Iterable<AbstractElement> findValidBooleanAssignments(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value) {
		List<AbstractElement> result = Lists.newArrayList();
		for (AbstractElement ele : assignedElements)
			if (GrammarUtil.isBooleanAssignment(GrammarUtil.containingAssignment(ele))) {
				if (Boolean.TRUE.equals(value))
					result.add(ele);
			} else {
				if (ele instanceof RuleCall && valueSerializer.isValid(semanticObj, (RuleCall) ele, value, null))
					result.add(ele);
			}
		return result;
	}

	protected Iterable<AbstractElement> findValidAssignmentsForContainmentRef(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, EObject value) {
		Multimap<EObject, AbstractElement> candidates = HashMultimap.create();
		for (AbstractElement ass : assignedElements)
			if (ass instanceof RuleCall)
				candidates.put(((RuleCall) ass).getRule(), ass);
			else if (ass instanceof Action)
				candidates.put(ass, ass);
		Iterable<EObject> contexts = Sets.newHashSet(contextFinder.findContextsByContents(value, candidates.keySet()));
		List<AbstractElement> result = Lists.newArrayList();
		for (EObject ctx : contexts)
			result.addAll(candidates.get(ctx));
		return result;
	}

	protected Iterable<AbstractElement> findValidAssignmentsForCrossRef(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, EObject value, INode node) {
		List<AbstractElement> result = Lists.newArrayList();
		for (AbstractElement ass : assignedElements) {
			CrossReference crossref = GrammarUtil.containingCrossReference(ass);
			EReference eref = GrammarUtil.getReference(crossref, semanticObj.eClass());
			if (EcoreUtil2.isAssignableFrom(eref.getEReferenceType(), value.eClass())
					&& crossRefSerializer.isValid(semanticObj, crossref, value, node, null))
				result.add(ass);
		}
		return result;
	}

	protected Iterable<AbstractElement> findValidAssignmentsForDatatype(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value) {
		// keywords have precedence over everything else
		for (AbstractElement ass : assignedElements)
			if (ass instanceof Keyword && keywordSerializer.isValid(semanticObj, (Keyword) ass, value, null))
				return Collections.singletonList(ass);

		// now check the remaining assignments
		List<AbstractElement> result = Lists.newArrayList();
		for (AbstractElement ass : assignedElements)
			if (ass instanceof RuleCall && valueSerializer.isValid(semanticObj, (RuleCall) ass, value, null))
				result.add(ass);
		return result;
	}

	protected Iterable<AbstractElement> findValidAssignmentsForEnum(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value) {
		List<AbstractElement> result = Lists.newArrayList();
		for (AbstractElement ass : assignedElements)
			if (ass instanceof RuleCall && ((RuleCall) ass).getRule() instanceof EnumRule) {
				if (enumLiteralSerializer.isValid(semanticObj, (RuleCall) ass, value, null))
					result.add(ass);
			}
		return result;

	}
}
