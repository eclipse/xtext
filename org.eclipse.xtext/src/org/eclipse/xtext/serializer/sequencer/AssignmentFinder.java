/*******************************************************************************
 * Copyright (c) 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContext;
import org.eclipse.xtext.serializer.impl.FeatureFinderUtil;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IEnumLiteralSerializer;
import org.eclipse.xtext.serializer.tokens.IKeywordSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;

import com.google.common.collect.ArrayListMultimap;
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

	@Override
	public Set<AbstractElement> findAssignmentsByValue(EObject semanticObj,
			Multimap<AbstractElement, ISerializationContext> assignments, Object value, INode node) {
		List<AbstractElement> assignedElements = Lists.newArrayList(assignments.keySet());
		EStructuralFeature feature = FeatureFinderUtil.getFeature(assignedElements.iterator().next(),
				semanticObj.eClass());
		if (feature instanceof EAttribute) {
			Class<?> clazz = feature.getEType().getInstanceClass();
			if (clazz == Boolean.class || clazz == boolean.class)
				return findValidBooleanAssignments(semanticObj, assignedElements, value);
			else
				return findValidValueAssignments(semanticObj, assignedElements, value);
		} else if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			if (ref.isContainment())
				return findValidAssignmentsForContainmentRef(semanticObj, assignments, (EObject) value);
			else
				return findValidAssignmentsForCrossRef(semanticObj, assignedElements, (EObject) value, node);
		}
		throw new RuntimeException("unknown feature type");
	}

	protected Set<AbstractElement> findValidAssignmentsForContainmentRef(EObject semanticObj,
			Multimap<AbstractElement, ISerializationContext> assignments, EObject value) {
		Multimap<ISerializationContext, AbstractElement> children = ArrayListMultimap.create();
		for (Entry<AbstractElement, Collection<ISerializationContext>> e : assignments.asMap().entrySet()) {
			AbstractElement ele = e.getKey();
			if (ele instanceof RuleCall) {
				EClassifier classifier = ((RuleCall) ele).getRule().getType().getClassifier();
				if (!classifier.isInstance(value))
					continue;
			}
			for (ISerializationContext container : e.getValue()) {
				ISerializationContext child = SerializationContext.forChild(container, ele, value);
				children.put(child, ele);
			}
		}
		if (children.size() < 2)
			return Sets.newHashSet(children.values());
		Set<ISerializationContext> found = contextFinder.findByContents(value, children.keySet());
		Set<AbstractElement> result = Sets.newLinkedHashSet();
		for (ISerializationContext ctx : children.keySet())
			if (found.contains(ctx))
				result.addAll(children.get(ctx));
		return result;
	}

	protected Set<AbstractElement> findValidAssignmentsForCrossRef(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, EObject value, INode node) {
		Set<AbstractElement> result = Sets.newLinkedHashSet();
		for (AbstractElement ass : assignedElements) {
			CrossReference crossref = GrammarUtil.containingCrossReference(ass);
			EReference eref = GrammarUtil.getReference(crossref, semanticObj.eClass());
			if (EcoreUtil2.isAssignableFrom(eref.getEReferenceType(), value.eClass())
					&& crossRefSerializer.isValid(semanticObj, crossref, value, node, null))
				result.add(ass);
		}
		return result;
	}

	protected Set<AbstractElement> findValidBooleanAssignments(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value) {
		Set<AbstractElement> result = Sets.newLinkedHashSet();
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

	protected Set<AbstractElement> findValidValueAssignments(EObject semanticObj,
			Iterable<AbstractElement> assignedElements, Object value) {
		Set<AbstractElement> result = Sets.newLinkedHashSet();
		for (AbstractElement ass : assignedElements) {
			if (ass instanceof Keyword && keywordSerializer.isValid(semanticObj, (Keyword) ass, value, null))
				result.add(ass);
			else if (ass instanceof RuleCall) {
				RuleCall rc = (RuleCall) ass;
				if (rc.getRule() instanceof EnumRule) {
					if (enumLiteralSerializer.isValid(semanticObj, rc, value, null))
						result.add(ass);
				} else if (valueSerializer.isValid(semanticObj, rc, value, null))
					result.add(ass);
			}
		}
		return result;
	}

}
