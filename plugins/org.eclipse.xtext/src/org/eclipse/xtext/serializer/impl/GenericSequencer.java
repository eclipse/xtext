/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Arrays;
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
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.ITokenSerializer;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.AssignmentDependencyKind;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.ISemanticNodeProvider;
import org.eclipse.xtext.serializer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.ISemanticSequencer;
import org.eclipse.xtext.serializer.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.ISerializationDiagnostic;
import org.eclipse.xtext.serializer.ITransientValueService;
import org.eclipse.xtext.serializer.ITransientValueService.ListTransient;
import org.eclipse.xtext.serializer.ITransientValueService.ValueTransient;
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
public class GenericSequencer implements ISemanticSequencer {

	protected abstract class Allocation {

		public Allocation() {
			super();
		}

		public abstract void collectGrammarValuePairs(IConstraintElement constraint, ISemanticSequenceAcceptor acceptor);

		@Override
		public String toString() {
			return toString("");
		}

		public abstract int minValues(IConstraintElement constraint);

		public abstract int maxValues(IConstraintElement constraint);

		public abstract String toString(String prefix);
	}

	protected class AllocationValue extends Allocation {
		protected Object value;

		protected INode node;

		public AllocationValue(Object value, INode node) {
			super();
			this.value = value;
			this.node = node;
		}

		@Override
		public void collectGrammarValuePairs(IConstraintElement constraint, ISemanticSequenceAcceptor acceptor) {
			acceptSemantic(acceptor, constraint, value, node);
			//			result.add(newPair(constraint, value));
		}

		public Object getValue() {
			return value;
		}

		@Override
		public String toString(String prefix) {
			return value instanceof EObject ? EmfFormatter.objPath((EObject) value) : value.toString();
		}

		@Override
		public int minValues(IConstraintElement constraint) {
			return 1;
		}

		@Override
		public int maxValues(IConstraintElement constraint) {
			return 1;
		}
	}

	protected class AlternativeAllocation extends Allocation {
		protected Quantity child;

		public AlternativeAllocation(Quantity child) {
			super();
			this.child = child;
		}

		@Override
		public void collectGrammarValuePairs(IConstraintElement constraint, ISemanticSequenceAcceptor acceptor) {
			child.collectGrammarValuePairs(acceptor);
		}

		protected Quantity getChild() {
			return child;
		}

		@Override
		public String toString(String prefix) {
			String newPrefix = "  " + prefix;
			return "Alt-Choice {\n" + newPrefix + child.toString(newPrefix) + "\n" + prefix + "}";
		}

		@Override
		public int minValues(IConstraintElement constraint) {
			return 0;
		}

		@Override
		public int maxValues(IConstraintElement constraint) {
			return 0;
		}
	}

	//	protected class AssignedAllocationValue extends AllocationValue {
	//		protected EStructuralFeature feature;
	//
	//		public AssignedAllocationValue(EStructuralFeature feature, Object value) {
	//			super(value);
	//			this.feature = feature;
	//		}
	//	}

	protected abstract class Feature2Assignment {
		public abstract IFeatureInfo getFeature();

		public abstract List<AllocationValue> getValuesFor(IConstraintElement assignment);

		public abstract int getQuantity(IConstraintElement assignment);

		public abstract void setQuantity(IConstraintElement assignment, int quantity);

		public abstract boolean isAmbiguous();

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
		public void collectGrammarValuePairs(IConstraintElement constraint, ISemanticSequenceAcceptor acceptor) {
			for (Quantity q : children)
				q.collectGrammarValuePairs(acceptor);
		}

		public List<Quantity> getChildren() {
			return children;
		}

		@Override
		public String toString(String prefix) {
			String newPrefix = "  " + prefix;
			StringBuilder r = new StringBuilder();
			r.append("Group {");
			for (Quantity child : children) {
				r.append("\n");
				r.append(newPrefix);
				r.append(child.getConstraintElement());
				r.append(" => ");
				r.append(child.toString(newPrefix));
			}
			r.append("\n");
			r.append(prefix);
			r.append("}");
			return r.toString();
		}

		@Override
		public int minValues(IConstraintElement constraint) {
			return 0;
		}

		@Override
		public int maxValues(IConstraintElement constraint) {
			return 0;
		}

	}

	protected class MVFeature2AssignmentAmbiguous extends Feature2Assignment {
		protected List<IConstraintElement> assignments;

		protected List<AllocationValue> values;

		protected int[] quantities; //TODO: implement

		public MVFeature2AssignmentAmbiguous(List<IConstraintElement> assignments, List<AllocationValue> values) {
			super();
			this.assignments = assignments;
			this.values = values;
			this.quantities = new int[assignments.get(0).getFeatureInfo().getAssignments().length];
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
		public boolean isAmbiguous() {
			int undefs = 0;
			for (IConstraintElement ass : assignments)
				if (quantities[ass.getFeatureAssignmentID()] == UNDEFINED_QUANTITY)
					undefs++;
			return undefs > 1;
		}

		@Override
		public int getQuantity(IConstraintElement assignment) {
			if (isAmbiguous())
				return UNDEF;
			return UNDEF; // TODO: implement
		}

		@Override
		public void setQuantity(IConstraintElement assignment, int quantity) {
			// TODO: implement			
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
		public boolean isAmbiguous() {
			return false;
		}

		@Override
		public int getQuantity(IConstraintElement assignment) {
			return assignment == this.assignment ? values.size() : UNDEF;
		}

		@Override
		public void setQuantity(IConstraintElement assignment, int quantity) {
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

		public void collectGrammarValuePairs(ISemanticSequenceAcceptor acceptor) {
			if (instances != null)
				for (Allocation a : instances)
					a.collectGrammarValuePairs(constraintElement, acceptor);
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
			if (instances.isEmpty())
				return "(empty)";
			else if (!constraintElement.isMany() && instances.size() < 2) {
				return instances.get(0).toString(prefix);
			} else {
				StringBuilder buf = new StringBuilder();
				buf.append("[");
				for (Allocation a : instances) {
					buf.append("\n");
					buf.append(prefix + "  ");
					buf.append(a.toString(prefix + "  "));
				}
				buf.append("\n");
				buf.append(prefix);
				buf.append("]");
				return buf.toString();
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

	protected final static int UNDEFINED_QUANTITY = -1;
	protected final static int NO_ASSIGNMENT = -2;

	protected class SVFeature2AssignmentAmbiguous extends SVFeature2Assignment {

		protected List<IConstraintElement> assignments;

		protected Boolean[] enabled;

		public SVFeature2AssignmentAmbiguous(List<IConstraintElement> assignments, boolean optional,
				AllocationValue value) {
			super(optional, value);
			this.assignments = assignments;
			this.enabled = new Boolean[assignments.get(0).getFeatureInfo().getAssignments().length];
			Arrays.fill(this.enabled, null);
		}

		@Override
		public IFeatureInfo getFeature() {
			return assignments.get(0).getFeatureInfo();
		}

		@Override
		public void setQuantity(IConstraintElement assignment, int quantity) {
			this.enabled[assignment.getFeatureAssignmentID()] = quantity != 0;
		}

		@Override
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			if (assignments.contains(assignment)) {
				Boolean en = enabled[assignment.getFeatureAssignmentID()];
				if (en == null && !isAmbiguous()) {
					for (IConstraintElement ass : assignments)
						if (enabled[ass.getFeatureAssignmentID()] == Boolean.TRUE)
							return Collections.emptyList();
					return Collections.singletonList(value);
				}
				if (en != null && en)
					return Collections.singletonList(value);
			}
			return Collections.emptyList();
		}

		@Override
		public boolean isAmbiguous() {
			int undefined = 0;
			for (IConstraintElement ass : assignments)
				if (enabled[ass.getFeatureAssignmentID()] == null)
					undefined++;
			return undefined > 1;
		}

		@Override
		public int getQuantity(IConstraintElement assignment) {
			if (isAmbiguous() || !assignments.contains(assignment))
				return UNDEF;
			Boolean en = enabled[assignment.getFeatureAssignmentID()];
			return en != null && en ? 1 : 0;
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
		public boolean isAmbiguous() {
			return false;
		}

		@Override
		public int getQuantity(IConstraintElement assignment) {
			return 1;
		}

		@Override
		public void setQuantity(IConstraintElement assignment, int quantity) {
		}
	}

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected ITokenSerializer.ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;

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

	@Inject
	protected ISemanticNodeProvider nodeProvider;

	public void createSequence(EObject context, EObject semanticObject, ISemanticSequenceAcceptor sequenceAcceptor,
			ISerializationDiagnostic.Acceptor errorAcceptor) {
		initConstraints();
		IConstraint constraint = getConstraint(context, semanticObject.eClass());
		//		System.out.println("Constraint: " + constraint);
		if (constraint == null) {
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context,
					constraintContexts, grammarAccess.getGrammar()));
			return;
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		Feature2Assignment[] values = createValues(semanticObject, constraint, nodes);
		//		System.out.println("Values: " + f2aToStr(constraint.getBody(), values));
		applydeterministicQuantities(constraint, values);
		//		System.out.println("Values (Disambiguated): " + f2aToStr(constraint.getBody(), values));
		Quantity quant = new Quantity(constraint.getBody(), createUnambiguousAllocation(constraint.getBody(), values));
		//		System.out.println("Quantity: " + quant + " EndQuantity");
		//		List<IGrammarValuePair> result = Lists.newArrayList();
		quant.collectGrammarValuePairs(sequenceAcceptor);
		sequenceAcceptor.finish();
	}

	protected void applydeterministicQuantities(IConstraint constraint, Feature2Assignment[] values) {
		boolean changed;
		do {
			changed = false;
			for (IConstraintElement assignment : constraint.getAssignments())
				if (values[assignment.getAssignmentID()] != null && values[assignment.getAssignmentID()].isAmbiguous()) {
					int min = getMin(values, assignment);
					int max = getMax(values, assignment);
					if (min == max && min != UNDEF) {
						values[assignment.getAssignmentID()].setQuantity(assignment, min);
						changed = true;
						//						System.out.println("Setting quantity of " + assignment + " to " + min);
					}
				}
		} while (changed);
	}

	protected boolean isAmbiguous(Feature2Assignment[] allocations) {
		for (Feature2Assignment feat : allocations)
			if (feat.isAmbiguous())
				return true;
		return false;
	}

	//	protected boolean disableInvalidAlternativeChoices(Quantity quant, Feature2Assignment[] values) {
	//		if (quant.getConstraintElement().isMany())
	//			return false;
	//		switch (quant.getConstraintElement().getType()) {
	//			case ALTERNATIVE:
	//				if (quant.getAllocations().size() == 1) {
	//					Quantity child = ((AlternativeAllocation) quant.getAllocations().get(0)).getChild();
	//					return disableInvalidAlternativeChoices(child, values);
	//				}
	//				return;
	//			case GROUP:
	//				boolean changed = false;
	//				for (Allocation alloc : quant.getAllocations())
	//					for (Quantity child : ((GroupAllocation) alloc).getChildren())
	//						changed = changed || disableInvalidAlternativeChoices(child, values);
	//				return changed;
	//			default:
	//				return false;
	//		}
	//		return false;
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
			case ASSIGNED_BOOLEAN_KEYWORD:
				Feature2Assignment f2a = values[constraint.getAssignmentID()];
				if (f2a == null)
					return Collections.emptyList();
				else if (!f2a.isAmbiguous()) {
					return f2a.getValuesFor(constraint);
					//					List<? extends Allocation> r = f2a.getValuesFor(constraint);
					//					return r.isEmpty() ? null : r;
				} else
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

	protected Feature2Assignment[] createValues(EObject semanticObject, IConstraint constraint,
			INodesForEObjectProvider nodes) {
		Feature2Assignment[] result = new Feature2Assignment[constraint.getAssignments().length];
		for (IFeatureInfo feature : constraint.getSingleAssignementFeatures()) {
			if (feature.getFeature().isMany()) {
				List<AllocationValue> allocs = getNonTransientValuesForMVFeature(semanticObject, feature, nodes);
				if (!allocs.isEmpty()) {
					IConstraintElement ass = feature.getAssignments()[0];
					result[ass.getAssignmentID()] = new MVFeature2AssignmentUnambiguous(ass, allocs);
				}
			} else {
				ValueTransient trans = transientValueService.isValueTransient(semanticObject, feature.getFeature());
				if (trans != ValueTransient.YES) {
					Object value = semanticObject.eGet(feature.getFeature());
					INode node = nodes.getNodeForSingelValue(feature.getFeature(), value);
					IConstraintElement ass = feature.getAssignments()[0];
					AllocationValue alloc = new AllocationValue(value, node);
					result[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass,
							trans == ValueTransient.PREFERABLY, alloc);
				}
			}
		}
		for (IFeatureInfo feature : constraint.getMultiAssignementFeatures()) {
			if (feature.getFeature().isMany()) {
				List<AllocationValue> allocs = getNonTransientValuesForMVFeature(semanticObject, feature, nodes);
				if (!allocs.isEmpty())
					createValues(feature, allocs, result);
			} else {
				ValueTransient trans = transientValueService.isValueTransient(semanticObject, feature.getFeature());
				if (trans != ValueTransient.YES) {
					Object value = semanticObject.eGet(feature.getFeature());
					INode node = nodes.getNodeForSingelValue(feature.getFeature(), value);
					AllocationValue alloc = new AllocationValue(value, node);
					createValues(semanticObject, feature, trans == ValueTransient.PREFERABLY, alloc, result);
				}
			}
		}
		return result;
	}

	protected boolean acceptSemantic(ISemanticSequenceAcceptor out, IConstraintElement constr, Object value, INode node) {
		switch (constr.getType()) {
			case ASSIGNED_ACTION_CALL:
				out.acceptAssignedAction(constr.getAction(), (EObject) value);
				return true;
			case ASSIGNED_PARSER_RULE_CALL:
				out.acceptAssignedParserRuleCall(constr.getRuleCall(), (EObject) value);
				return true;
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				out.acceptAssignedCrossRefDatatype(constr.getRuleCall(), (EObject) value, (ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				out.acceptAssignedCrossRefTerminal(constr.getRuleCall(), (EObject) value, (ILeafNode) node);
				return true;
			case ASSIGNED_CROSSREF_KEYWORD:
				out.acceptAssignedCrossRefKeyword(constr.getKeyword(), (EObject) value, (ILeafNode) node);
				return true;
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				out.acceptAssignedCrossRefEnum(constr.getRuleCall(), (EObject) value, (ICompositeNode) node);
				return true;
			case ASSIGNED_DATATYPE_RULE_CALL:
				out.acceptAssignedDatatype(constr.getRuleCall(), value, (ICompositeNode) node);
				return true;
			case ASSIGNED_ENUM_RULE_CALL:
				out.acceptAssignedEnum(constr.getRuleCall(), value, (ICompositeNode) node);
				return true;
			case ASSIGNED_TERMINAL_RULE_CALL:
				out.acceptAssignedTerminal(constr.getRuleCall(), value, (ILeafNode) node);
				return true;
			case ASSIGNED_KEYWORD:
				out.acceptAssignedKeyword(constr.getKeyword(), (String) value, (ILeafNode) node);
				return true;
			case ASSIGNED_BOOLEAN_KEYWORD:
				out.acceptAssignedKeyword(constr.getKeyword(), (Boolean) value, (ILeafNode) node);
				return true;
			case ALTERNATIVE:
			case GROUP:
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return false;
		}
		return false;
	}

	//	protected AllocationValue getNonTransientValuesForSVFeature(EObject semanticObject, IFeatureInfo feature,
	//			INodesForEObjectProvider nodes) {
	//		if (transientValueService.isValueTransient(semanticObject, feature.getFeature()) != ValueTransient.NO) {
	//			Object value = semanticObject.eGet(feature.getFeature());
	//			INode node = nodes.getNodeForSingelValue(feature.getFeature(), value);
	//			return new AllocationValue(value, node);
	//		}
	//		return null;
	//	}

	protected List<AllocationValue> getNonTransientValuesForMVFeature(EObject semanticObject, IFeatureInfo feature,
			INodesForEObjectProvider nodes) {
		switch (transientValueService.isListTransient(semanticObject, feature.getFeature())) {
			case NO:
				List<AllocationValue> allocs1 = Lists.newArrayList();
				List<?> values1 = (List<?>) semanticObject.eGet(feature.getFeature());
				for (int i = 0; i < values1.size(); i++) {
					Object value = values1.get(i);
					INode node = nodes.getNodeForMultiValue(feature.getFeature(), i, i, value);
					allocs1.add(new AllocationValue(value, node));
				}
				return allocs1;
			case SOME:
				List<AllocationValue> allocs2 = Lists.newArrayList();
				List<?> values2 = (List<?>) semanticObject.eGet(feature.getFeature());
				for (int i = 0, j = 0; i < values2.size(); i++)
					if (!transientValueService.isValueInListTransient(semanticObject, i, feature.getFeature())) {
						Object value = values2.get(i);
						INode node = nodes.getNodeForMultiValue(feature.getFeature(), i, j++, value);
						allocs2.add(new AllocationValue(value, node));
					}
				return allocs2;
			case YES:
		}
		return Collections.emptyList();
	}

	protected void createValues(EObject semanticObj, IFeatureInfo feature, boolean optional, AllocationValue value,
			Feature2Assignment[] target) {
		//		if (feature.getAssignments().length == 1) {
		//			IConstraintElement ass = feature.getAssignments()[0];
		//			target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, optional, value);
		//			return;
		//		}
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

	protected boolean isExcludedByDependees(IConstraintElement assignments, Feature2Assignment[] target) {
		List<Pair<IConstraintElement, AssignmentDependencyKind>> dependees = assignments.getDependingAssignment();
		if (dependees == null || dependees.isEmpty())
			return false;
		for (Pair<IConstraintElement, AssignmentDependencyKind> e : dependees)
			switch (e.getSecond()) {
				case EXCLUDE_IF_SET:
					if (target[e.getFirst().getAssignmentID()] != null)
						return true;
					break;
				case SAME:
				case SAME_OR_LESS:
				case EXCLUDE_IF_UNSET:
					if (target[e.getFirst().getAssignmentID()] == null
							&& e.getFirst().getFeatureInfo().getAssignments().length == 1)
						return true;
					break;
				case MANDATORY_IF_SET:
				case SAME_OR_MORE:
			}
		return false;
	}

	protected void createValues(IFeatureInfo feature, List<AllocationValue> values, Feature2Assignment[] target) {
		List<IConstraintElement> remainingAssignments = Lists.newArrayList();
		for (IConstraintElement ass : feature.getAssignments())
			if (!isExcludedByDependees(ass, target))
				remainingAssignments.add(ass);
		if (remainingAssignments.size() == 0)
			throw new RuntimeException("no valid assignments"); // TODO: handle this better
		if (remainingAssignments.size() == 1) {
			IConstraintElement ass = remainingAssignments.get(0);
			target[ass.getAssignmentID()] = new MVFeature2AssignmentUnambiguous(ass, values);
			return;
		}
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
		while (true) {
			IConstraintElement ass = assignments.get(0);
			if (ass.isCardinalityOneAmongAssignments(assignments)) {
				target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, false, values.get(0));
				values.remove(0);
				assignments.remove(0);
			} else
				break;
		}
		for (int i = assignments.size() - 1; i >= 0 && !values.isEmpty(); i--) {
			IConstraintElement ass = assignments.get(i);
			if (ass != null && ass.isCardinalityOneAmongAssignments(assignments)) {
				target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, false, values.get(values
						.size() - 1));
				values.remove(values.size() - 1);
				assignments.remove(i);
			} else
				break;
		}
		//		for (int i = assignments.size() - 1; i >= 0; i--)
		//			if (assignments.get(i) == null)
		//				assignments.remove(i);
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
			Feature2Assignment value = values[ele.getAssignmentID()];
			if (value != null) {
				if (value.isAmbiguous()) {
					result.append("[");
					result.append(getMin(values, ele));
					result.append(", ");
					result.append(getMax(values, ele));
					result.append("] ");

				}
				result.append(Join.join(", ", values[ele.getAssignmentID()].getValuesFor(ele)));
			}
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

	protected boolean containsUnavailableFeature(Feature2Assignment[] values, IConstraintElement element,
			IConstraintElement excludeAssignment) {
		if (element.isOptional())
			return false;
		switch (element.getType()) {
			case GROUP:
				for (IConstraintElement a : element.getChildren())
					if (containsUnavailableFeature(values, a, excludeAssignment))
						return true;
				return false;
			case ALTERNATIVE:
				for (IConstraintElement a : element.getChildren())
					if (!containsUnavailableFeature(values, a, excludeAssignment))
						return false;
				return true;
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
			case ASSIGNED_BOOLEAN_KEYWORD:
				Feature2Assignment f2a = values[element.getAssignmentID()];
				if (f2a == null)
					return true;
				if (f2a.isAmbiguous())
					return false;
				if (f2a.getValuesFor(element).isEmpty())
					return true;
				return false;
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return false;
		}
		return false;
	}

	protected int getMax(Feature2Assignment[] values, IConstraintElement element) {
		int result = element.isRoot() ? 1 : getMaxByParent(values, element.getContainer(), element, null);
		return element.isMany() && result > 0 ? MAX : result;
	}

	/**
	 * max occurrences of a child with this parent
	 */
	protected int getMaxByParent(Feature2Assignment[] values, IConstraintElement parent, IConstraintElement exclude,
			IConstraintElement excludeAssignment) {
		int result;
		if (parent.isRoot())
			result = parent.isMany() ? MAX : 1;
		else {
			result = getMaxByParent(values, parent.getContainer(), parent, excludeAssignment);
			if (result == 0)
				return 0;
		}
		switch (parent.getType()) {
			case GROUP:
				if (parent.isMany())
					result = MAX;
				for (IConstraintElement a : parent.getChildren())
					if (a != exclude) {
						int count = getMaxForChild(values, a);
						if (count != UNDEF && (count < result))
							result = count;
					}
				return result;
			case ALTERNATIVE:
				if (parent.isMany())
					return MAX;
				for (IConstraintElement a : parent.getChildren())
					if (a != exclude) {
						int count = getMinForChild(values, a);
						if (count != UNDEF && count > 0)
							return 0;
					} else if (excludeAssignment != null && containsUnavailableFeature(values, a, excludeAssignment))
						return 0;
				return result;
			default:
				return 1;
		}
	}

	public final static int MAX = Integer.MAX_VALUE;
	public final static int UNDEF = -1;

	/**
	 * max occurrences of a parent with this child
	 */
	protected int getMaxForChild(Feature2Assignment[] values, IConstraintElement child) {
		if (child.isOptional())
			return MAX;
		switch (child.getType()) {
			case GROUP:
				int count1 = MAX;
				for (IConstraintElement a : child.getChildren()) {
					int c = getMaxForChild(values, a);
					if (c != UNDEF && c < count1)
						count1 = c;
				}
				return count1;
			case ALTERNATIVE:
				int count2 = UNDEF;
				for (IConstraintElement a : child.getChildren()) {
					int c = getMaxForChild(values, a);
					if (c == MAX)
						return MAX;
					if (c != UNDEF)
						count2 = count2 == UNDEF ? c : count2 + c;
				}
				return count2;
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
			case ASSIGNED_BOOLEAN_KEYWORD:
				Feature2Assignment f2a = values[child.getAssignmentID()];
				return f2a == null ? 0 : f2a.getQuantity(child);
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return UNDEF;
		}
		return UNDEF;
	}

	protected int getMin(Feature2Assignment[] values, IConstraintElement assignment) {
		if (assignment.isOptional())
			return 0;
		if (assignment.isRoot())
			return 1;
		return getMinByParent(values, assignment.getContainer(), assignment);
	}

	/**
	 * min occurrences of a child within this parent
	 */
	protected int getMinByParent(Feature2Assignment[] values, IConstraintElement parent, IConstraintElement exclude) {
		if (parent == null)
			return 1;
		switch (parent.getType()) {
			case GROUP:
				if (!parent.isManyRecursive(null) && !parent.isOptionalRecursive(null))
					return 1;
				int count1 = getMinByParent(values, parent.getContainer(), parent);
				for (IConstraintElement a : parent.getChildren())
					if (a != exclude) {
						int c = getMinForChild(values, a);
						if (c != UNDEF && c > count1)
							count1 = c;
					}
				return count1;
			case ALTERNATIVE:
				if (parent.isOptional())
					return 0;
				boolean isUndef = false;
				for (IConstraintElement a : parent.getChildren())
					if (a != exclude) {
						int count2 = getMinForChild(values, a);
						if (count2 == UNDEF)
							isUndef = true;
						else if (count2 > 0)
							return 0;
					}
				if (isUndef)
					return UNDEF;
				return getMinByParent(values, parent.getContainer(), parent);
			default:
				return UNDEF;
		}
	}

	protected int getMinForChild(Feature2Assignment[] values, IConstraintElement child) {
		int count = UNDEF;
		switch (child.getType()) {
			case GROUP:
				for (IConstraintElement a : child.getChildren()) {
					int c = getMinForChild(values, a);
					if (c > count)
						count = c;
				}
				break;
			case ALTERNATIVE:
				for (IConstraintElement a : child.getChildren()) {
					int c = getMinForChild(values, a);
					count = count == UNDEF ? c : c + count;
				}
				break;
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
			case ASSIGNED_BOOLEAN_KEYWORD:
				Feature2Assignment f2a = values[child.getAssignmentID()];
				return f2a == null ? 0 : f2a.getQuantity(child);
			case UNASSIGNED_DATATYPE_RULE_CALL:
			case UNASSIGNED_TERMINAL_RULE_CALL:
				return UNDEF;
		}
		if (child.isMany() && count > 1)
			count = 1;
		return count;
	}

}
