/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.sequencer;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraint;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintContext;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IConstraintElement;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.IFeatureInfo;
import org.eclipse.xtext.serializer.analysis.IGrammarConstraintProvider.RelationalDependencyType;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.eclipse.xtext.serializer.tokens.ICrossReferenceSerializer;
import org.eclipse.xtext.serializer.tokens.IEnumLiteralSerializer;
import org.eclipse.xtext.serializer.tokens.IKeywordSerializer;
import org.eclipse.xtext.serializer.tokens.IValueSerializer;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GenericSemanticSequencer extends AbstractSemanticSequencer {

	protected abstract class Allocation {

		public Allocation() {
			super();
		}

		public abstract void accept(EObject semanticObj, IConstraintElement constraint);

		@Override
		public String toString() {
			return toString("");
		}

		public abstract String toString(String prefix);
	}

	protected class AllocationValue extends Allocation {
		protected int index;

		protected INode node;

		protected Object value;

		protected boolean optional;

		public AllocationValue(Object value, int index, boolean optional, INode node) {
			super();
			this.value = value;
			this.index = index;
			this.optional = optional;
			this.node = node;
		}

		@Override
		public void accept(EObject semanticObj, IConstraintElement constraint) {
			acceptSemantic(semanticObj, constraint, value, index, node);
		}

		public INode getNode() {
			return node;
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
		public void accept(EObject semanticObj, IConstraintElement constraint) {
			child.accept(semanticObj);
		}

		protected Quantity getChild() {
			return child;
		}

		@Override
		public String toString(String prefix) {
			String newPrefix = "  " + prefix;
			return "Alt-Choice {\n" + newPrefix + child.toString(newPrefix) + "\n" + prefix + "}";
		}
	}

	protected abstract class Feature2Assignment {
		public abstract IFeatureInfo getFeature();

		public abstract List<AllocationValue> getValuesFor(IConstraintElement assignment);

		public abstract boolean isAmbiguous();

		@Override
		public String toString() {
			List<String> result = Lists.newArrayList();
			for (IConstraintElement assign : getFeature().getAssignments()) {
				result.add(assign + "=>(" + Joiner.on(", ").join(getValuesFor(assign)) + ")");
			}
			return Joiner.on(", ").join(result);
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

		@Override
		public void accept(EObject semanticObj, IConstraintElement constraint) {
			for (Quantity q : children)
				q.accept(semanticObj);
		}

		public void addChild(Quantity quantity) {
			children.add(quantity);
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

	}

	protected class MVFeature2AssignmentAmbiguous extends Feature2Assignment {
		protected List<IConstraintElement> assignments;

		protected int[] quantities; //TODO: implement

		protected List<AllocationValue> values;

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

		public void accept(EObject semanticObj) {
			if (instances != null)
				for (Allocation a : instances)
					a.accept(semanticObj, constraintElement);
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
		public List<AllocationValue> getValuesFor(IConstraintElement assignment) {
			if (assignments.contains(assignment)) {
				Boolean en = enabled[assignment.getFeatureAssignmentID()];
				if (en == null && !isAmbiguous()) {
					for (IConstraintElement ass : assignments)
						if (enabled[ass.getFeatureAssignmentID()] == Boolean.TRUE)
							return Collections.emptyList();
					return Collections.singletonList(value);
				}
				if (Boolean.TRUE.equals(en))
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

	}

	public final static int MAX = Integer.MAX_VALUE;

	protected final static int NO_ASSIGNMENT = -2;

	public final static int UNDEF = -1;

	protected final static int UNDEFINED_QUANTITY = -1;

	protected List<IConstraintContext> constraintContexts;

	protected Map<Pair<EObject, EClass>, IConstraint> constraints;

	@Inject
	protected ICrossReferenceSerializer crossRefSerializer;

	@Inject
	protected ISemanticSequencerDiagnosticProvider diagnosticProvider;

	@Inject
	protected IEnumLiteralSerializer enumLiteralSerializer;

	@Inject
	protected IGrammarAccess grammarAccess;

	@Inject
	protected IGrammarConstraintProvider grammarConstraintProvider;

	@Inject
	protected IKeywordSerializer keywordSerializer;

	@Inject
	protected ITransientValueService transientValueService;

	@Inject
	protected IValueSerializer valueSerializer;

	protected void acceptAction(Action action, EObject semanticChild, ICompositeNode node) {
		if (sequenceAcceptor.enterAssignedAction(action, semanticChild, node)) {
			masterSequencer.createSequence(action, semanticChild);
			sequenceAcceptor.leaveAssignedAction(action, semanticChild);
		}
	}

	protected void acceptEObjectRuleCall(RuleCall ruleCall, EObject semanticChild, ICompositeNode node) {
		if (sequenceAcceptor.enterAssignedParserRuleCall(ruleCall, semanticChild, node)) {
			masterSequencer.createSequence(ruleCall.getRule(), semanticChild);
			sequenceAcceptor.leaveAssignedParserRuleCall(ruleCall, semanticChild);
		}
	}

	protected boolean acceptSemantic(EObject semanticObj, IConstraintElement constr, Object value, int index, INode node) {
		switch (constr.getType()) {
			case ASSIGNED_ACTION_CALL:
				acceptAction(constr.getAction(), (EObject) value, (ICompositeNode) node);
				return true;
			case ASSIGNED_PARSER_RULE_CALL:
				acceptEObjectRuleCall(constr.getRuleCall(), (EObject) value, (ICompositeNode) node);
				return true;
			case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				RuleCall datatypeRC = constr.getRuleCall();
				EObject value1 = (EObject) value;
				ICompositeNode node1 = (ICompositeNode) node;
				String token1 = crossRefSerializer.serializeCrossRef(semanticObj,
						GrammarUtil.containingCrossReference(datatypeRC), value1, node1, errorAcceptor);
				sequenceAcceptor.acceptAssignedCrossRefDatatype(datatypeRC, token1, value1, index, node1);
				return true;
			case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				RuleCall terminalRC = constr.getRuleCall();
				EObject value2 = (EObject) value;
				ILeafNode node2 = (ILeafNode) node;
				String token2 = crossRefSerializer.serializeCrossRef(semanticObj,
						GrammarUtil.containingCrossReference(terminalRC), value2, node2, errorAcceptor);
				sequenceAcceptor.acceptAssignedCrossRefTerminal(terminalRC, token2, value2, index, node2);
				return true;
			case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				RuleCall enumRC = constr.getRuleCall();
				ICompositeNode node3 = (ICompositeNode) node;
				EObject target3 = (EObject) value;
				String token3 = crossRefSerializer.serializeCrossRef(semanticObj,
						GrammarUtil.containingCrossReference(enumRC), target3, node3, errorAcceptor);
				sequenceAcceptor.acceptAssignedCrossRefEnum(enumRC, token3, target3, index, node3);
				return true;
			case ASSIGNED_DATATYPE_RULE_CALL:
				RuleCall datatypeRC1 = constr.getRuleCall();
				ICompositeNode node4 = (ICompositeNode) node;
				String token4 = valueSerializer.serializeAssignedValue(semanticObj, datatypeRC1, value, node4,
						errorAcceptor);
				sequenceAcceptor.acceptAssignedDatatype(datatypeRC1, token4, value, index, node4);
				return true;
			case ASSIGNED_ENUM_RULE_CALL:
				RuleCall enumRC1 = constr.getRuleCall();
				ICompositeNode node5 = (ICompositeNode) node;
				String token5 = enumLiteralSerializer.serializeAssignedEnumLiteral(semanticObj, enumRC1, value, node5,
						errorAcceptor);
				sequenceAcceptor.acceptAssignedEnum(enumRC1, token5, value, index, node5);
				return true;
			case ASSIGNED_TERMINAL_RULE_CALL:
				RuleCall terminalRC1 = constr.getRuleCall();
				ILeafNode node6 = (ILeafNode) node;
				String token6 = valueSerializer.serializeAssignedValue(semanticObj, terminalRC1, value, node6,
						errorAcceptor);
				sequenceAcceptor.acceptAssignedTerminal(terminalRC1, token6, value, index, node6);
				return true;
			case ASSIGNED_KEYWORD:
				Keyword keyword = constr.getKeyword();
				String value3 = (String) value;
				ILeafNode node7 = (ILeafNode) node;
				String token7 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword, value3, node7,
						errorAcceptor);
				sequenceAcceptor.acceptAssignedKeyword(keyword, token7, value3, index, node7);
				return true;
			case ASSIGNED_BOOLEAN_KEYWORD:
				Keyword keyword1 = constr.getKeyword();
				Boolean value4 = (Boolean) value;
				ILeafNode node8 = (ILeafNode) node;
				String token71 = keywordSerializer.serializeAssignedKeyword(semanticObj, keyword1, value4, node8,
						errorAcceptor);
				sequenceAcceptor
						.acceptAssignedKeyword(keyword1, token71, value4 == null ? false : value4, index, node8);
				return true;
			case ALTERNATIVE:
			case GROUP:
				return false;
		}
		return false;
	}

	//	protected void applydeterministicQuantities(IConstraint constraint, Feature2Assignment[] values) {
	//		boolean changed;
	//		do {
	//			changed = false;
	//			for (IConstraintElement assignment : constraint.getAssignments())
	//				if (values[assignment.getAssignmentID()] != null && values[assignment.getAssignmentID()].isAmbiguous()) {
	//					int min = getMin(values, assignment);
	//					int max = getMax(values, assignment);
	//					if (min == max && min != UNDEF) {
	//						values[assignment.getAssignmentID()].setQuantity(assignment, min);
	//						changed = true;
	//						//						System.out.println("Setting quantity of " + assignment + " to " + min);
	//					}
	//				}
	//		} while (changed);
	//	}

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
		}
		return false;
	}

	public void createSequence(EObject context, EObject semanticObject) {
		initConstraints();
		IConstraint constraint = getConstraint(context, semanticObject.eClass());
		//		System.out.println("Constraint: " + constraint);
		if (constraint == null) {
			if (errorAcceptor != null)
				errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
			return;
		}
		INodesForEObjectProvider nodes = nodeProvider.getNodesForSemanticObject(semanticObject, null);
		Feature2Assignment[] values = createValues(semanticObject, constraint, nodes);
//		System.out.println("Values: " + f2aToStr(constraint.getBody(), values));
		//				System.out.println("Values (Disambiguated): " + f2aToStr(constraint.getBody(), values));
		if (constraint.getBody() != null) {
			Quantity quant = new Quantity(constraint.getBody(), createUnambiguousAllocation(constraint.getBody(),
					values));
			//		System.out.println("Quantity: " + quant + " EndQuantity");
			//		List<IGrammarValuePair> result = Lists.newArrayList();
			quant.accept(semanticObject);
		}
		sequenceAcceptor.finish();
	}

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
		}
		return null;
	}

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
					if (trans != ValueTransient.PREFERABLY || node != null) {
						IConstraintElement ass = feature.getAssignments()[0];
						AllocationValue alloc = new AllocationValue(value, -1, trans == ValueTransient.PREFERABLY, node);
						result[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass,
								trans == ValueTransient.PREFERABLY, alloc);
					}
				}
			}
		}
		for (IFeatureInfo feature : constraint.getMultiAssignementFeatures()) {
			if (feature.getFeature().isMany()) {
				List<AllocationValue> allocs = getNonTransientValuesForMVFeature(semanticObject, feature, nodes);
				if (!allocs.isEmpty())
					createValues(semanticObject, feature, allocs, result);
			} else {
				ValueTransient trans = transientValueService.isValueTransient(semanticObject, feature.getFeature());
				if (trans != ValueTransient.YES) {
					Object value = semanticObject.eGet(feature.getFeature());
					INode node = nodes.getNodeForSingelValue(feature.getFeature(), value);
					AllocationValue alloc = new AllocationValue(value, -1, trans == ValueTransient.PREFERABLY, node);
					createValues(semanticObject, feature, trans == ValueTransient.PREFERABLY, alloc, result);
				}
			}
		}
		return result;
	}

	protected void createValues(EObject semanticObj, IFeatureInfo feature, boolean optional, AllocationValue value,
			Feature2Assignment[] target) {
		List<IConstraintElement> remainingAssignments = Lists.newArrayList();
		for (IConstraintElement ass : feature.getAssignments())
			if (!isExcludedByDependees(ass, target))
				remainingAssignments.add(ass);
		if (!remainingAssignments.isEmpty() && feature.isContentValidationNeeded())
			remainingAssignments = findValidAssignments(semanticObj,
					remainingAssignments.toArray(new IConstraintElement[remainingAssignments.size()]), value);
		if (remainingAssignments.isEmpty())
			return; // TODO: handle this error, no valid assignment has been found for the value.
		else if (remainingAssignments.size() == 1) {
			IConstraintElement ass = remainingAssignments.get(0);
			target[ass.getAssignmentID()] = new SVFeature2AssignmentUnambiguous(ass, optional, value);
			return;
		}
		SVFeature2AssignmentAmbiguous f2a = new SVFeature2AssignmentAmbiguous(remainingAssignments, optional, value);
		for (IConstraintElement ass : remainingAssignments)
			target[ass.getAssignmentID()] = f2a;
	}

	protected void createValues(EObject semanticObj, IFeatureInfo feature, List<AllocationValue> values,
			Feature2Assignment[] target) {
		List<IConstraintElement> remainingAssignments = Lists.newArrayList();
		for (IConstraintElement ass : feature.getAssignments())
			if (!isExcludedByDependees(ass, target))
				remainingAssignments.add(ass);
		if (feature.isContentValidationNeeded())
			remainingAssignments = findValidAssignments(semanticObj, remainingAssignments, values);
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
				if (value.isAmbiguous())
					result.append("ambiguous!");
				result.append(Joiner.on(", ").join(values[ele.getAssignmentID()].getValuesFor(ele)));
			}
			result.append("\n");
		}
	}

	@Inject
	protected IAssignmentFinder assignmentFinder;

	protected List<IConstraintElement> findValidAssignments(EObject semanticObj, IConstraintElement[] assignments,
			AllocationValue value) {
		List<AbstractElement> assignedElements = Lists.newArrayList();
		for (IConstraintElement ass : assignments)
			assignedElements.add(ass.getGrammarElement());
		Set<AbstractElement> assignedElements2 = Sets.newHashSet(assignmentFinder.findAssignmentsByValue(semanticObj,
				assignedElements, value.getValue(), value.getNode()));
		List<IConstraintElement> result = Lists.newArrayList();
		for (IConstraintElement ass : assignments)
			if (assignedElements2.contains(ass.getGrammarElement()))
				result.add(ass);
		return result;
	}

	protected List<IConstraintElement> findValidAssignments(EObject semanticObj, List<IConstraintElement> assignments,
			List<AllocationValue> values) {
		BitSet bs = new BitSet();
		IConstraintElement[] assignmentsAr = assignments.toArray(new IConstraintElement[assignments.size()]);
		for (AllocationValue value : values)
			for (IConstraintElement validAssignments : findValidAssignments(semanticObj, assignmentsAr, value))
				bs.set(validAssignments.getFeatureAssignmentID());
		List<IConstraintElement> result = Lists.newArrayList();
		for (IConstraintElement ass : assignments)
			if (bs.get(ass.getFeatureAssignmentID()))
				result.add(ass);
		return result;
	}

	protected IConstraint getConstraint(EObject context, EClass type) {
		return constraints.get(Tuples.create(context, type));
	}

	protected List<AllocationValue> getNonTransientValuesForMVFeature(EObject semanticObject, IFeatureInfo feature,
			INodesForEObjectProvider nodes) {
		switch (transientValueService.isListTransient(semanticObject, feature.getFeature())) {
			case NO:
				List<AllocationValue> allocs1 = Lists.newArrayList();
				List<?> values1 = (List<?>) semanticObject.eGet(feature.getFeature());
				for (int i = 0; i < values1.size(); i++) {
					Object value = values1.get(i);
					INode node = nodes.getNodeForMultiValue(feature.getFeature(), i, i, value);
					allocs1.add(new AllocationValue(value, i, false, node));
				}
				return allocs1;
			case SOME:
				List<AllocationValue> allocs2 = Lists.newArrayList();
				List<?> values2 = (List<?>) semanticObject.eGet(feature.getFeature());
				for (int i = 0, j = 0; i < values2.size(); i++)
					if (!transientValueService.isValueInListTransient(semanticObject, i, feature.getFeature())) {
						Object value = values2.get(i);
						INode node = nodes.getNodeForMultiValue(feature.getFeature(), i, j++, value);
						allocs2.add(new AllocationValue(value, i, false, node));
					}
				return allocs2;
			case YES:
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

	protected boolean isAmbiguous(Feature2Assignment[] allocations) {
		for (Feature2Assignment feat : allocations)
			if (feat.isAmbiguous())
				return true;
		return false;
	}

	protected boolean isExcludedByDependees(IConstraintElement assignments, Feature2Assignment[] target) {
		List<Pair<IConstraintElement, RelationalDependencyType>> dependees = assignments.getDependingAssignment();
		if (dependees == null || dependees.isEmpty())
			return false;
		for (Pair<IConstraintElement, RelationalDependencyType> e : dependees)
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

}
