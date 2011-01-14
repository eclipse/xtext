/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.ISequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ITransientValueService;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericSequencer extends AbstractSequencer {

	protected abstract class Allocation {

		public Allocation() {
			super();
		}

		public abstract void collectGrammarValuePairs(IConstraintElement constraint, List<IGrammarValuePair> result);

		@Override
		public String toString() {
			return toString("");
		}

		public abstract String toString(String prefix);
	}

	protected class AllocationValue extends Allocation {
		protected Object value;

		public AllocationValue(Object value) {
			super();
			this.value = value;
		}

		@Override
		public void collectGrammarValuePairs(IConstraintElement constraint, List<IGrammarValuePair> result) {
			result.add(newPair(constraint, value));
		}

		public Object getValue() {
			return value;
		}

		@Override
		public String toString(String prefix) {
			return value instanceof EObject ? EmfFormatter.objPath((EObject) value) : value.toString();
		}
	}

	protected class AlternativeAllocation extends Allocation {
		protected Quantity child;

		public AlternativeAllocation(Quantity child) {
			super();
			this.child = child;
		}

		@Override
		public void collectGrammarValuePairs(IConstraintElement constraint, List<IGrammarValuePair> result) {
			child.collectGrammarValuePairs(result);
		}

		@Override
		public String toString(String prefix) {
			String newPrefix = "  " + prefix;
			return "Alternative {\n" + newPrefix + child.toString(newPrefix) + "\n" + prefix + "}";
		}
	}

	protected class AssignedAllocationValue extends AllocationValue {
		protected EStructuralFeature feature;

		public AssignedAllocationValue(EStructuralFeature feature, Object value) {
			super(value);
			this.feature = feature;
		}
	}

	protected abstract class Feature2Assignment {
		public abstract IFeatureInfo getFeature();

		public abstract List<AllocationValue> getValuesFor(IConstraintElement assignment);

		public abstract boolean isUnambiguous();

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			for (IConstraintElement assign : getFeature().getAssignments()) {
				result.add(assign + "=>(" + Join.join(", ", getValuesFor(assign)) + ")");
			}
			return Join.join(", ", result);
		}
	}

	protected class GroupAllocation extends Allocation {
		protected List<Quantity> children = Lists.newArrayList();

		public GroupAllocation() {
			super();
		}

		public GroupAllocation(List<Quantity> children) {
			super();
			this.children = children;
		}

		public void addChild(Quantity quantity) {
			children.add(quantity);
		}

		@Override
		public void collectGrammarValuePairs(IConstraintElement constraint, List<IGrammarValuePair> result) {
			for (Quantity q : children)
				q.collectGrammarValuePairs(result);
		}

		public List<Quantity> getChildren() {
			return children;
		}

		@Override
		public String toString(String prefix) {
			String newPrefix = "  " + prefix;
			StringBuilder r = new StringBuilder();
			r.append("Group {\n");
			for (Quantity child : children) {
				r.append(newPrefix);
				r.append(child.getConstraintElement());
				r.append(" => ");
				r.append(child.toString(newPrefix));
				r.append("\n");
			}
			r.append(prefix);
			r.append("}");
			return r.toString();
		}

	}

	protected class MVFeature2AssignmentAmbiguous extends Feature2Assignment {
		protected List<IConstraintElement> assignments;

		protected List<AllocationValue> values;

		public MVFeature2AssignmentAmbiguous(List<IConstraintElement> assignments, List<AllocationValue> values) {
			super();
			this.assignments = assignments;
			this.values = values;
		}

		@Override
		public IFeatureInfo getFeature() {
			return assignments.get(0).getFeatureInfo();
		}

		@Override
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			return assignments.contains(assignment) ? values : Collections.<AllocationValue> emptyList();
		}

		@Override
		public boolean isUnambiguous() {
			return true;
		}
	}

	protected class MVFeature2AssignmentUnambiguous extends Feature2Assignment {

		protected IConstraintElement assignment;

		protected List<AllocationValue> values;

		public MVFeature2AssignmentUnambiguous(IConstraintElement assignment, List<AllocationValue> values) {
			super();
			this.assignment = assignment;
			this.values = values;
		}

		@Override
		public IFeatureInfo getFeature() {
			return assignment.getFeatureInfo();
		}

		@Override
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			return assignment == this.assignment ? values : Collections.<AllocationValue> emptyList();
		}

		@Override
		public boolean isUnambiguous() {
			return true;
		}

	}

	protected class Quantity {

		protected IConstraintElement constraintElement;

		protected List<? extends Allocation> instances;

		public Quantity(IConstraintElement constraintElement, Allocation allocation) {
			this.instances = Collections.singletonList(allocation);
			this.constraintElement = constraintElement;
		}

		public Quantity(IConstraintElement constraintElement, List<? extends Allocation> allocation) {
			this.instances = allocation;
			this.constraintElement = constraintElement;
		}

		public void collectGrammarValuePairs(List<IGrammarValuePair> result) {
			if (instances != null)
				for (Allocation a : instances)
					a.collectGrammarValuePairs(constraintElement, result);
		}

		public List<? extends Allocation> getAllocations() {
			return instances;
		}

		public IConstraintElement getConstraintElement() {
			return constraintElement;
		}

		@Override
		public String toString() {
			return toString("");
		}

		public String toString(String prefix) {
			if (instances == null)
				return "(null)";
			else if (!constraintElement.isMany() && instances.size() < 2) {
				return instances.isEmpty() ? "(empty)" : instances.get(0).toString();
			} else {
				return instances.isEmpty() ? "(empty)" : "[" + Join.join("\n" + prefix, instances) + "]";
			}
		}
	}

	protected abstract class SVFeature2Assignment extends Feature2Assignment {

		protected boolean optional;

		protected AllocationValue value;

		public SVFeature2Assignment(boolean optional, AllocationValue value) {
			super();
			this.optional = optional;
			this.value = value;
		}

	}

	protected class SVFeature2AssignmentAmbiguous extends SVFeature2Assignment {

		protected List<IConstraintElement> assignments;

		public SVFeature2AssignmentAmbiguous(List<IConstraintElement> assignments, boolean optional,
				AllocationValue value) {
			super(optional, value);
			this.assignments = assignments;
		}

		@Override
		public IFeatureInfo getFeature() {
			return assignments.get(0).getFeatureInfo();
		}

		@Override
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			if (assignments.contains(assignment))
				return Collections.singletonList(value);
			return Collections.emptyList();
		}

		@Override
		public boolean isUnambiguous() {
			return true;
		}
	}

	protected class SVFeature2AssignmentUnambiguous extends SVFeature2Assignment {

		protected IConstraintElement assignment;

		public SVFeature2AssignmentUnambiguous(IConstraintElement assignment, boolean optional, AllocationValue value) {
			super(optional, value);
			this.assignment = assignment;
		}

		@Override
		public IFeatureInfo getFeature() {
			return assignment.getFeatureInfo();
		}

		@Override
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			if (assignment == this.assignment)
				return Collections.singletonList(value);
			return Collections.emptyList();
		}

		@Override
		public boolean isUnambiguous() {
			return true;
		}
	}

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected ITokenSerializer.ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected ISequencerDiagnosticProvider diagnosticProvider;

	@Inject
	protected ITokenSerializer.IEnumLiteralSerializer enumLiteralSerializer;

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	@Inject
	protected ITokenSerializer.IKeywordSerializer keywordSerializer;

	@Inject
	protected ITransientValueService transientValueService;

	@Inject
	protected ITokenSerializer.IValueSerializer valueSerializer;

	public Iterable<IGrammarValuePair> createSequence(EObject context, EObject semanticObject,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		initConstraints();
		IConstraint constraint = getConstraint(context, semanticObject.eClass());
		//		System.out.println("Constraint: " + constraint);
		if (constraint == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context,
						constraintContexts, grammarAccess.getGrammar()));
			return Collections.emptyList();
		}
		Feature2Assignment[] values = createValues(semanticObject, constraint);
		//		System.out.println("Values: " + f2aToStr(constraint.getBody(), values));
		Quantity quant = new Quantity(constraint.getBody(), createUnambiguousAllocation(constraint.getBody(), values));
		//		System.out.println("Quantity: " + quant);
		List<IGrammarValuePair> result = Lists.newArrayList();
		quant.collectGrammarValuePairs(result);
		return result;
	}

	//	protected Iterable<Quantity> createIndependentlyDecideableQuantity(List<IConstraintElement> assignments,
	//			List<AllocationValue> values) {
	//		return null;
	//	}

	//	protected int[] createQuantities(IConstraint constraint, Feature2Assignment[] values) {
	//		int[] quantities = new int[constraint.getAllElements().size()];
	//	}

	//	final static int UNDEF = -1;
	//
	//	protected int getQuantity(IConstraintElement constraint, Feature2Assignment[] values) {
	//		switch (constraint.getType()) {
	//			case ALTERNATIVE:
	//				int result1 = 0;
	//				for (IConstraintElement child : constraint.getChildren()) {
	//					int quant = getQuantity(child, values);
	//					if (quant == UNDEF)
	//						return UNDEF;
	//					if (quant > 0) {
	//						if (child.isMany())
	//							result1 += 1;
	//						else
	//							result1 += quant;
	//					}
	//				}
	//				return result1;
	//			case GROUP:
	//				int min = 0;
	//				int max = Integer.MAX_VALUE;
	//				for (IConstraintElement child : constraint.getChildren()) {
	//					int quant = getQuantity(child, values);
	//					if (quant == UNDEF)
	//						return UNDEF;
	//					if (quant > 0)
	//						min = Math.max(min, constraint.isMany() ? 1 : quant);
	//					if (!child.isOptional())
	//						max = Math.max(max, quant);
	//				}
	//				if (min <= max)
	//					return min;
	//				return UNDEF; // TODO: handle this error
	//			case ASSIGNED_ACTION_CALL:
	//			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
	//			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
	//			case ASSIGNED_CROSSREF_KEYWORD:
	//			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
	//			case ASSIGNED_DATATYPE_RULE_CALL:
	//			case ASSIGNED_ENUM_RULE_CALL:
	//			case ASSIGNED_KEYWORD:
	//			case ASSIGNED_PARSER_RULE_CALL:
	//			case ASSIGNED_TERMINAL_RULE_CALL:
	//				Feature2Assignment f2a = values[constraint.getID()];
	//				if (f2a.isUnambiguous())
	//					return f2a.getValuesFor(constraint).size();
	//				else
	//					return UNDEF;
	//			case UNASSIGNED_DATATYPE_RULE_CALL:
	//			case UNASSIGNED_TERMINAL_RULE_CALL:
	//				return UNDEF;
	//		}
	//		return UNDEF;
	//	}

	//	protected Quantity createUnambiguousQuantity(IConstraintElement constraint, Feature2Assignment[] values) {
	//		int quantity = getQuantity(constraint, values);
	//		Quantity result = new Quantity();
	//		for (int i = 0; i < quantity; i++)
	//			result.addAllocation(createUnambiguousAllocation(constraint, values));
	//		return result;
	//	}

	protected List<? extends Allocation> createUnambiguousAllocation(IConstraintElement constraint,
			Feature2Assignment[] values) {
		switch (constraint.getType()) {
			case ALTERNATIVE:
				List<Allocation> result = Lists.newArrayList();
				for (IConstraintElement child : constraint.getChildren()) {
					List<? extends Allocation> allocs = createUnambiguousAllocation(child, values);
					if (allocs == null)
						return null;
					if (child.isMany()) {
						Quantity q = new Quantity(child, allocs);
						result.add(new AlternativeAllocation(q));
					} else {
						for (Allocation a : allocs) {
							AlternativeAllocation alloc = new AlternativeAllocation(new Quantity(child, a));
							result.add(alloc);
						}
					}
				}
				return result;
			case GROUP:
				int min = 0;
				int max = Integer.MAX_VALUE;
				List<Pair<IConstraintElement, List<? extends Allocation>>> children = Lists
						.newArrayListWithExpectedSize(constraint.getChildren().size());
				for (IConstraintElement child : constraint.getChildren()) {
					List<? extends Allocation> allocs = createUnambiguousAllocation(child, values);
					if (allocs == null)
						return null;
					if (allocs.size() > 0)
						min = Math.max(min, child.isMany() ? 1 : allocs.size());
					if (!child.isOptional())
						max = Math.max(max, allocs.size());
					children.add(Tuples.<IConstraintElement, List<? extends Allocation>> create(child, allocs));
				}
				if (max < min)
					throw new RuntimeException("err"); // TODO: handle this error
				List<Allocation> result2 = Lists.newArrayListWithExpectedSize(min);
				for (int i = 0; i < min; i++) {
					List<Quantity> ch = Lists.newArrayList();
					for (Pair<IConstraintElement, List<? extends Allocation>> p : children) {
						if (i < p.getSecond().size()) {
							if (i == min - 1)
								ch.add(new Quantity(p.getFirst(), p.getSecond().subList(i, p.getSecond().size())));
							else
								ch.add(new Quantity(p.getFirst(), p.getSecond().get(i)));
						}
					}
					result2.add(new GroupAllocation(ch));
				}
				//				System.out.println(constraint + " => " + result2);
				return result2;
			case ASSIGNED_ACTION_CALL:
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
			case ASSIGNED_CROSSREF_KEYWORD:
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
			case ASSIGNED_DATATYPE_RULE_CALL:
			case ASSIGNED_ENUM_RULE_CALL:
			case ASSIGNED_KEYWORD:
			case ASSIGNED_PARSER_RULE_CALL:
			case ASSIGNED_TERMINAL_RULE_CALL:
				Feature2Assignment f2a = values[constraint.getAssignmentID()];
				if (f2a == null)
					return Collections.emptyList();
				else if (f2a.isUnambiguous())
					return f2a.getValuesFor(constraint);
				else
					return null;
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
		}
		return null;
	}

	//	protected List<Quantity> createIndependentlyDecideableQuantities(IConstraint constraint,
	//			List<List<AllocationValue>> mandatory) {
	//		List<List<IConstraintElement>> feature2assignment = constraint.getAssignmentsByFeature();
	//		for (int featureID = 0; featureID < mandatory.size(); featureID++) {
	//			List<AllocationValue> values = mandatory.get(featureID);
	//			if (values != null) {
	//				List<IConstraintElement> assignments = feature2assignment.get(featureID);
	//				Iterable<Quantity> quantities = createIndependentlyDecideableQuantity(assignments, values);
	//				if (quantities != null) {
	//
	//				}
	//
	//			}
	//		}
	//	}
	//
	//	protected void collectValues(EObject semanticObject, IConstraint constraint, List<List<AllocationValue>> mandatory,
	//			List<List<AllocationValue>> optional) {
	//		List<List<IConstraintElement>> feature2assignment = constraint.getAssignmentsByFeature();
	//		for (int featureID = 0; featureID < feature2assignment.size(); featureID++)
	//			if (feature2assignment.get(featureID) != null) {
	//				EStructuralFeature feature = semanticObject.eClass().getEStructuralFeature(featureID);
	//				if (feature.isMany()) {
	//					List<AllocationValue> result = Lists.newArrayList();
	//					Iterable<Object> values = transientValueService.getNonTransientValues(semanticObject, feature);
	//					for (Object v : values)
	//						result.add(new AssignedAllocationValue(feature, v));
	//					mandatory.set(featureID, result);
	//				} else {
	//					if (!transientValueService.isTransient(semanticObject, feature)) {
	//						Object value = semanticObject.eGet(feature);
	//						AllocationValue alloc = new AssignedAllocationValue(feature, value);
	//						if (transientValueService.isOptional(feature, feature))
	//							optional.set(featureID, Lists.newArrayList(alloc));
	//						else
	//							mandatory.set(featureID, Lists.newArrayList(alloc));
	//					}
	//				}
	//			}
	//	}

	protected Feature2Assignment[] createValues(EObject semanticObject, IConstraint constraint) {
		Feature2Assignment[] result = new Feature2Assignment[constraint.getAssignments().length];
		for (int featureID = 0; featureID < constraint.getFeatures().length; featureID++) {
			IFeatureInfo feature = constraint.getFeatures()[featureID];
			if (feature != null) {
				if (feature.getFeature().isMany()) {
					Iterable<Object> values = transientValueService.getNonTransientValues(semanticObject,
							feature.getFeature());
					List<AllocationValue> allocs = Lists.newArrayList();
					for (Object v : values)
						allocs.add(new AssignedAllocationValue(feature.getFeature(), v));
					if (!allocs.isEmpty())
						createValues(feature, allocs, result);
				} else {
					if (!transientValueService.isTransient(semanticObject, feature.getFeature())) {
						Object value = semanticObject.eGet(feature.getFeature());
						AllocationValue alloc = new AssignedAllocationValue(feature.getFeature(), value);
						boolean optional = transientValueService.isOptional(feature.getFeature(), feature.getFeature());
						createValues(semanticObject, feature, optional, alloc, result);
					}
				}
			}
		}
		return result;
	}

	protected void createValues(EObject semanticObj, IFeatureInfo feature, boolean optional, AllocationValue value,
			Feature2Assignment[] target) {
		if (feature.getAssignments().length == 1) {
			IConstraintElement ass = feature.getAssignments()[0];
			target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, optional, value);
			return;
		}
		List<IConstraintElement> validAssignments = null;
		if (feature.isContentValidationNeeded()) {
			validAssignments = findValidAssignments(semanticObj, feature.getAssignments(), value.getValue());
			if (validAssignments.isEmpty())
				return; // TODO: handle this error, no valid assignment has been found for the value.
			else if (validAssignments.size() == 1) {
				IConstraintElement ass = validAssignments.get(0);
				target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, optional, value);
				return;
			}
		}
		if (validAssignments == null)
			validAssignments = Lists.newArrayList(feature.getAssignments());
		SVFeature2AssignmentAmbiguous f2a = new SVFeature2AssignmentAmbiguous(validAssignments, optional, value);
		for (IConstraintElement ass : validAssignments)
			target[ass.getAssignmentID()] = f2a;
	}

	protected void createValues(IFeatureInfo feature, List<AllocationValue> values, Feature2Assignment[] target) {
		if (feature.getAssignments().length == 1) {
			IConstraintElement ass = feature.getAssignments()[0];
			target[ass.getAssignmentID()] = new MVFeature2AssignmentUnambiguous(ass, values);
			return;
		}
		List<IConstraintElement> remainingAssignments = Lists.newArrayList(feature.getAssignments());
		List<AllocationValue> remainingValues = Lists.newArrayList(values);
		distributeValuesByQuantity(remainingAssignments, remainingValues, target);
		if (remainingAssignments.size() == 1) {
			IConstraintElement ass = remainingAssignments.get(0);
			target[ass.getAssignmentID()] = new MVFeature2AssignmentUnambiguous(ass, remainingValues);
			return;
		}
		MVFeature2AssignmentAmbiguous f2a = new MVFeature2AssignmentAmbiguous(remainingAssignments, remainingValues);
		for (IConstraintElement ass : remainingAssignments)
			target[ass.getAssignmentID()] = f2a;
	}

	protected void distributeValuesByQuantity(List<IConstraintElement> assignments, List<AllocationValue> values,
			Feature2Assignment[] target) {
		for (int i = 0; i < assignments.size() && !values.isEmpty(); i++) {
			IConstraintElement ass = assignments.get(i);
			if (ass.isCardinalityOneForFeature()) {
				target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, false, values.get(0));
				values.remove(0);
				assignments.set(i, null);
			} else
				break;
		}
		for (int i = assignments.size() - 1; i >= 0 && !values.isEmpty(); i--) {
			IConstraintElement ass = assignments.get(i);
			if (ass != null && ass.isCardinalityOneForFeature()) {
				target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, false, values.get(values
						.size() - 1));
				values.remove(values.size() - 1);
				assignments.set(i, null);
			} else
				break;
		}
		for (int i = assignments.size() - 1; i >= 0; i--)
			if (assignments.get(i) == null)
				assignments.remove(i);
	}

	protected String f2aToStr(IConstraintElement ele, Feature2Assignment[] values) {
		if (ele == null)
			return "(null)";
		StringBuilder result = new StringBuilder();
		f2aToStr(ele, values, "", result);
		return result.toString();
	}

	protected void f2aToStr(IConstraintElement ele, Feature2Assignment[] values, String prefix, StringBuilder result) {
		result.append(prefix);
		if (ele.getChildren() != null) {
			result.append(ele.getType().name());
			result.append(ele.getCardinality());
			result.append(" {\n");
			for (IConstraintElement child : ele.getChildren())
				f2aToStr(child, values, prefix + "  ", result);
			result.append(prefix);
			result.append("}\n");
		} else if (ele.getAssignmentID() >= 0) {
			result.append(ele.toString());
			result.append(" => ");
			if (values[ele.getAssignmentID()] != null)
				result.append(Join.join(", ", values[ele.getAssignmentID()].getValuesFor(ele)));
			result.append("\n");
		}
	}

	protected Iterable<EObject> findContexts(EObject semanitcObject) {
		EClass cls = semanitcObject.eClass();
		Set<EObject> result = Sets.newHashSet();
		for (IConstraintContext cc : constraintContexts)
			for (IConstraint c : cc.getConstraints())
				if (c.getType() == cls) {
					result.add(cc.getContext());
					break;
				}
		return result;
	}

	public Iterable<EObject> findContexts(EObject semanitcObject, Iterable<EObject> contextCandidates) {
		initConstraints();
		// TODO: actually validate if the constraints match
		if (contextCandidates == null)
			return findContexts(semanitcObject);
		EClass cls = semanitcObject.eClass();
		Set<EObject> result = Sets.newHashSet();
		for (EObject candidate : contextCandidates)
			if (getConstraint(candidate, cls) != null)
				result.add(candidate);
		return result;
	}

	protected List<IConstraintElement> findValidAssignments(EObject semanitcObj, IConstraintElement[] assignments,
			Object value) {
		EStructuralFeature feature = assignments[0].getFeature();
		if (feature instanceof EAttribute) {
			if (feature.getEType() instanceof EEnum)
				return findValidAssignmentsForEnum(semanitcObj, assignments, value);
			else
				return findValidAssignmentsForDatatype(semanitcObj, assignments, value);
		}
		if (feature instanceof EReference) {
			EReference ref = (EReference) feature;
			if (ref.isContainment())
				return findValidAssignmentsForContainmentRef(semanitcObj, assignments, (EObject) value);
			else
				return findValidAssignmentsForCrossRef(semanitcObj, assignments, (EObject) value);
		}
		throw new RuntimeException("unknown feature type");
	}

	protected List<IConstraintElement> findValidAssignmentsForContainmentRef(EObject semanitcObj,
			IConstraintElement[] assignments, EObject value) {
		Set<EObject> contexts = Sets.newHashSet();
		for (IConstraintElement ass : assignments)
			contexts.add(ass.getCallContext());
		contexts = Sets.newHashSet(findContexts(value, contexts));
		List<IConstraintElement> result = Lists.newArrayList();
		for (IConstraintElement ass : assignments)
			if (contexts.contains(ass.getCallContext()))
				result.add(ass);
		return result;
	}

	protected List<IConstraintElement> findValidAssignmentsForCrossRef(EObject semanitcObj,
			IConstraintElement[] assignments, EObject value) {
		Map<CrossReference, List<IConstraintElement>> candidates = Maps.newHashMap();
		for (IConstraintElement ass : assignments) {
			List<IConstraintElement> cand = candidates.get(ass.getCrossReference());
			if (cand == null) {
				if (EcoreUtil2.isAssignableFrom(ass.getCrossReferenceType(), value.eClass())
						&& crossRefSerializer.isValid(semanitcObj, ass.getCrossReference(), value, null))
					candidates.put(ass.getCrossReference(), Lists.newArrayList(ass));
				else
					candidates.put(ass.getCrossReference(), Collections.<IConstraintElement> emptyList());
			} else if (cand != Collections.EMPTY_LIST)
				cand.add(ass);
		}
		List<IConstraintElement> result = Lists.newArrayList();
		for (List<IConstraintElement> l : candidates.values())
			result.addAll(l);
		return result;
	}

	// keywords have precedence over everything else
	protected List<IConstraintElement> findValidAssignmentsForDatatype(EObject semanticObj,
			IConstraintElement[] assignments, Object value) {
		// keywords have precedence over everything else
		for (int i = 0; i < assignments.length; i++) {
			Keyword kw = assignments[i].getKeyword();
			if (kw != null && keywordSerializer.isValid(semanticObj, kw, value, null))
				return Collections.singletonList(assignments[i]);
		}

		// now check the remaining assignments
		List<IConstraintElement> result = Lists.newArrayList();
		for (int i = 0; i < assignments.length; i++) {
			RuleCall rc = assignments[i].getRuleCall();
			if (rc != null && valueSerializer.isValid(semanticObj, rc, value, null))
				result.add(assignments[i]);
		}
		return result;
	}

	protected List<IConstraintElement> findValidAssignmentsForEnum(EObject semanticObj,
			IConstraintElement[] assignments, Object value) {
		List<IConstraintElement> result = Lists.newArrayList();
		for (IConstraintElement ass : assignments)
			if (ass.getRuleCall() != null && ass.getRuleCall().getRule() instanceof EnumRule) {
				if (enumLiteralSerializer.isValid(semanticObj, ass.getRuleCall(), value, null))
					result.add(ass);
			}
		return result;

	}

	protected IConstraint getConstraint(EObject context, EClass type) {
		return constraints.get(Tuples.create(context, type));
	}

	protected void initConstraints() {
		if (constraintContexts == null) {
			constraints = Maps.newHashMap();
			constraintContexts = grammarConstraintProvider.getConstraints(grammarAccess.getGrammar());
			//			System.out.println(Join.join("\n", constraintContexts));
			for (IConstraintContext ctx : constraintContexts)
				for (IConstraint constraint : ctx.getConstraints())
					constraints.put(Tuples.create(ctx.getContext(), constraint.getType()), constraint);
		}
	}
}
