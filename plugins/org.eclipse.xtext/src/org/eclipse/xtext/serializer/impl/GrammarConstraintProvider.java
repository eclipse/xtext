/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.grammaranalysis.IGrammarNFAProvider.NFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractCachingNFABuilder;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAProvider;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFAState;
import org.eclipse.xtext.grammaranalysis.impl.AbstractNFATransition;
import org.eclipse.xtext.serializer.IGrammarConstraintProvider;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Singleton;
import com.google.inject.internal.Join;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Singleton
public class GrammarConstraintProvider implements IGrammarConstraintProvider {

	protected abstract static class AbstractConstraintContext implements IConstraintContext {

		protected List<IConstraint> constraints = Lists.newArrayList();

		protected void addConstraint(Constraint constraint /*, Map<Object, Constraint> existingConstraints*/) {
			//			Constraint existing = existingConstraints.get(constraint.getCacheKey());
			//			if (existing != null)
			//				constraints.add(existing);
			//			else {
			constraints.add(constraint);
			//				existingConstraints.put(constraint.getCacheKey(), constraint);
			//			}
		}

		public List<IConstraint> getConstraints() {
			return constraints;
		}

		protected abstract String getName();

		protected void initConstraints() {
			Collections.sort(constraints, new Comparator<IConstraint>() {
				public int compare(IConstraint o1, IConstraint o2) {
					return o1.getName().compareTo(o2.getName());
				}
			});
			for (IConstraint ele : constraints)
				((Constraint) ele).initLists();
		}

		@Override
		public String toString() {
			Iterable<String> constraintNames = Iterables.transform(constraints, new Function<IConstraint, String>() {
				public String apply(IConstraint from) {
					return from.getName();
				}
			});
			return getName() + ": " + Join.join(" | ", constraintNames) + ";";
		}
	}

	protected static class ActionConstraint extends Constraint {

		protected Action actionContext;

		public ActionConstraint(Action context, EClass type, ConstraintElement body) {
			super(type, body);
			this.actionContext = context;
		}

		@Override
		protected EObject getMostSpecificContext() {
			return body == null ? actionContext : body.getContext();
		}
	}

	public static class ActionFilterNFAProvider extends AbstractNFAProvider<ActionFilterState, ActionFilterTransition> {
		public static class DefaultBackwardsNFABuilder extends
				AbstractCachingNFABuilder<ActionFilterState, ActionFilterTransition> {

			@Override
			public ActionFilterState createState(AbstractElement ele) {
				return new ActionFilterState(ele, this);
			}

			@Override
			protected ActionFilterTransition createTransition(ActionFilterState source, ActionFilterState target,
					boolean isRuleCall, AbstractElement loopCenter) {
				return new ActionFilterTransition(source, target, isRuleCall, loopCenter);
			}

			@Override
			public boolean filter(AbstractElement ele) {

				// never filter root elements
				if (!(ele.eContainer() instanceof AbstractElement))
					return false;

				// filter unassigned keywords
				if (ele instanceof Keyword && GrammarUtil.containingAssignment(ele) == null)
					return true;

				// filter groups and alternatives, if they contain assigned actions
				if (ele instanceof CompoundElement) {
					TreeIterator<EObject> ti = ele.eAllContents();
					while (ti.hasNext()) {
						EObject obj = ti.next();
						if (obj instanceof Action && ((Action) obj).getFeature() != null)
							return true;
					}
				}

				// don't filter, if there is a child or a sibling that is or contains an assigned action.
				TreeIterator<EObject> ti = ele.eContainer().eAllContents();
				while (ti.hasNext()) {
					EObject obj = ti.next();
					if (obj instanceof Action && ((Action) obj).getFeature() != null)
						return false;
				}
				return true;
			}

			public NFADirection getDirection() {
				return NFADirection.BACKWARD;
			}
		}

		@Override
		protected NFABuilder<ActionFilterState, ActionFilterTransition> createBuilder() {
			return new DefaultBackwardsNFABuilder();
		}

	}

	public static class ActionFilterState extends AbstractNFAState<ActionFilterState, ActionFilterTransition> {

		public ActionFilterState(AbstractElement element, NFABuilder<ActionFilterState, ActionFilterTransition> builder) {
			super(element, builder);
		}

	}

	public static class ActionFilterTransition extends AbstractNFATransition<ActionFilterState, ActionFilterTransition> {

		public ActionFilterTransition(ActionFilterState source, ActionFilterState target, boolean ruleCall,
				AbstractElement loopCenter) {
			super(source, target, ruleCall, loopCenter);
		}
	}

	protected class AssignedActionConstraintContext extends AbstractConstraintContext {

		protected Action action;

		public AssignedActionConstraintContext(Action action) {
			super();
			this.action = action;
		}

		public EClass getCommonType() {
			return (EClass) action.getType().getClassifier();
		}

		public EObject getContext() {
			return action;
		}

		@Override
		protected String getName() {
			return getContextName(action);
		}

	}

	protected static abstract class Constraint implements IConstraint {

		protected IConstraintElement[] assignments;

		protected ConstraintElement body;

		protected IConstraintElement[] elements;

		protected IFeatureInfo[] features;

		protected String name;

		protected EObject specificContext;

		protected EClass type;

		public Constraint(EClass type, ConstraintElement body) {
			super();
			this.type = type;
			this.body = body;
			if (this.body != null)
				this.body.setContainingConstraint(this);
		}

		public Iterable<IFeatureInfo> getMultiAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length > 1)
					result.add(info);
			return result;
		}

		public Iterable<IFeatureInfo> getSingleAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length == 1)
					result.add(info);
			return result;
		}

		protected void collectElements(ConstraintElement ele, List<IConstraintElement> elements,
				List<IConstraintElement> assignments, List<IConstraintElement>[] assignmentsByFeature) {
			ele.setElementId(elements.size());
			elements.add(ele);
			switch (ele.getType()) {
				case ASSIGNED_ACTION_CALL:
				case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				case ASSIGNED_CROSSREF_KEYWORD:
				case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				case ASSIGNED_DATATYPE_RULE_CALL:
				case ASSIGNED_ENUM_RULE_CALL:
				case ASSIGNED_KEYWORD:
				case ASSIGNED_BOOLEAN_KEYWORD:
				case ASSIGNED_PARSER_RULE_CALL:
				case ASSIGNED_TERMINAL_RULE_CALL:
					EClass type = ele.getContainingConstraint().getType();
					int featureID = type.getEStructuralFeature(ele.getFeatureName()).getFeatureID();
					List<IConstraintElement> assignmentByFeature = assignmentsByFeature[featureID];
					if (assignmentByFeature == null)
						assignmentsByFeature[featureID] = assignmentByFeature = Lists.newArrayList();
					ele.setFeatureAssignmentId(assignmentByFeature.size());
					assignmentByFeature.add(ele);
					ele.setAssignmentId(assignments.size());
					assignments.add(ele);
					return;
				case ALTERNATIVE:
				case GROUP:
					for (IConstraintElement e : ele.getChildren())
						collectElements((ConstraintElement) e, elements, assignments, assignmentsByFeature);
					return;
				case UNASSIGNED_DATATYPE_RULE_CALL:
				case UNASSIGNED_TERMINAL_RULE_CALL:
					return;
			}
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Constraint))
				return false;
			Constraint c = (Constraint) obj;
			return type == c.type && ((body == null && c.body == null) || body.equals(c.body));
		}

		public IConstraintElement[] getAssignments() {
			return assignments;
		}

		public IConstraintElement getBody() {
			return body;
		}

		protected Object getCacheKey() {
			return Tuples.create(body.getContext(), type);
		}

		public IConstraintElement[] getElements() {
			return elements;
		}

		public IFeatureInfo[] getFeatures() {
			return features;
		}

		protected abstract EObject getMostSpecificContext();

		public String getName() {
			return name;
		}

		public EClass getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return type.hashCode() + (body == null ? 0 : (7 * body.hashCode()));
		}

		protected void initLists() {
			List<IConstraintElement> ele = Lists.newArrayList();
			List<IConstraintElement> ass = Lists.newArrayList();
			@SuppressWarnings("unchecked")
			List<IConstraintElement>[] feat = new List[getType().getFeatureCount()];
			if (body != null)
				collectElements(body, ele, ass, feat);
			elements = ele.toArray(new IConstraintElement[ele.size()]);
			assignments = ass.toArray(new IConstraintElement[ass.size()]);
			features = new IFeatureInfo[feat.length];
			for (int i = 0; i < feat.length; i++)
				if (feat[i] != null) {
					EStructuralFeature feature = getType().getEStructuralFeature(i);
					IConstraintElement[] fass = feat[i].toArray(new IConstraintElement[feat[i].size()]);
					features[i] = new FeatureInfo(this, feature, fass);
				}
		}

		protected void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			String body = getBody() != null ? getBody().toString() : "{" + type.getName() + "}";
			return getName() + " returns " + getType().getName() + ": " + body + ";";
		}

	}

	protected static class ConstraintElement implements IConstraintElement {

		protected int assignmentId = -1;

		//		protected Boolean cardinalityOneForFeature;

		protected List<IConstraintElement> children;

		protected ConstraintElement container;

		//		protected IConstraintElement excludingAlternative = UNINTITIALIZED;

		protected IConstraint containingConstraint;

		protected List<IConstraintElement> containedAssignments = null;

		protected EObject context;

		protected AbstractElement element;

		protected int elementId = -1;

		protected int featureAssignmentId = -1;

		protected IFeatureInfo featureInfo;

		protected boolean many;

		protected boolean optional;

		protected ConstraintElementType type;

		protected boolean typeMatch = false;

		protected ConstraintElement() {
		}

		protected ConstraintElement(EObject context, ConstraintElementType type) {
			this(context, type, null, false, false);
		}

		protected ConstraintElement(EObject context, ConstraintElementType type, AbstractElement element) {
			this(context, type, element, GrammarUtil.isMultipleCardinality(element), GrammarUtil
					.isOptionalCardinality(element));
		}

		protected ConstraintElement(EObject context, ConstraintElementType type, AbstractElement element, boolean many,
				boolean optional) {
			super();
			this.context = context;
			this.type = type;
			this.element = element;
			this.many = many;
			this.optional = optional;
			if (type == ConstraintElementType.ALTERNATIVE || type == ConstraintElementType.GROUP)
				children = Lists.newArrayList();
		}

		protected void addAllChilden(ConstraintElement childrenOwner) {
			for (IConstraintElement c : childrenOwner.children)
				addChild((ConstraintElement) c);
			childrenOwner.getChildren().clear();
			if (childrenOwner.isTypeMatch())
				typeMatch();
		}

		protected void addChild(ConstraintElement child) {
			child.container = this;
			this.children.add(child);
			if (child.isTypeMatch())
				typeMatch();
		}

		protected boolean containsChild(ConstraintElement child) {
			if (children == null)
				return false;
			for (IConstraintElement c : children)
				if (c.equals(child))
					return true;
			return false;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ConstraintElement))
				return false;
			ConstraintElement ce = (ConstraintElement) obj;
			return element == ce.element && ((children == null && ce.children == null) || children.equals(ce.children));
		}

		protected IConstraintElement findCommonContainer(List<IConstraintElement> elements) {
			if (elements.size() == 0)
				return null;
			if (elements.size() == 1)
				return elements.get(0);
			IConstraintElement result = elements.get(0);
			for (int i = 1; i < elements.size(); i++) {
				boolean found = false;
				while (!found && result != null) {
					IConstraintElement cand = elements.get(i);
					while (!found && cand != null)
						if (cand == result)
							found = true;
						else
							cand = cand.getContainer();
					if (!found)
						result = result.getContainer();
				}
			}
			return result;
		}

		public Action getAction() {
			return element instanceof Action ? (Action) element : null;
		}

		public int getAssignmentID() {
			return this.assignmentId;
		}

		protected String getAssignmentOperator() {
			if (element instanceof Action)
				return ((Action) element).getOperator();
			Assignment ass = GrammarUtil.containingAssignment(element);
			if (ass != null)
				return ass.getOperator();
			return null;
		}

		public EObject getCallContext() {
			switch (type) {
				case ASSIGNED_ACTION_CALL:
					return getAction();
				case ASSIGNED_PARSER_RULE_CALL:
					return getRuleCall().getRule();
				default:
					return null;
			}
		}

		public String getCardinality() {
			return isMany() ? (isOptional() ? "*" : "+") : (isOptional() ? "?" : "");
		}

		public List<IConstraintElement> getChildren() {
			return children;
		}

		public IConstraintElement getContainer() {
			return container;
		}

		public IConstraint getContainingConstraint() {
			if (containingConstraint == null)
				containingConstraint = getContainer().getContainingConstraint();
			return containingConstraint;
		}

		protected EObject getContext() {
			return context;
		}

		public CrossReference getCrossReference() {
			if (element == null)
				return null;
			return GrammarUtil.containingCrossReference(element);
		}

		public EClass getCrossReferenceType() {
			if (element == null)
				return null;
			CrossReference cr = GrammarUtil.containingCrossReference(element);
			if (cr == null)
				return null;
			return (EClass) cr.getType().getClassifier();
		}

		public int getElementID() {
			return elementId;
		}

		public EStructuralFeature getFeature() {
			return getFeatureInfo().getFeature();
		}

		public int getFeatureAssignmentID() {
			return featureAssignmentId;
		}

		public IFeatureInfo getFeatureInfo() {
			return featureInfo;
		}

		protected String getFeatureName() {
			if (element instanceof Action)
				return ((Action) element).getFeature();
			Assignment ass = GrammarUtil.containingAssignment(element);
			if (ass != null)
				return ass.getFeature();
			return null;
		}

		public AbstractElement getGrammarElement() {
			return element;
		}

		public Keyword getKeyword() {
			return element instanceof Keyword ? (Keyword) element : null;
		}

		public RuleCall getRuleCall() {
			return element instanceof RuleCall ? (RuleCall) element : null;
		}

		public ConstraintElementType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			int result = element != null ? element.hashCode() : 0;
			if (children != null)
				result += 7 * children.hashCode();
			return result;
		}

		protected void insertChild(ConstraintElement child) {
			child.container = this;
			this.children.add(0, child);
		}

		public boolean isCardinalityOneAmongAssignments(List<IConstraintElement> assignments) {
			if (assignments.size() < 2)
				return false;
			IConstraintElement commonContainer = findCommonContainer(assignments);
			return commonContainer.getType() != ConstraintElementType.ALTERNATIVE
					&& !isOptionalRecursive(commonContainer) && !isManyRecursive(commonContainer);
		}

		public boolean isMany() {
			return many;
		}

		public boolean isManyRecursive(IConstraintElement root) {
			return isMany() || (getContainer() != root && getContainer().isMany());
		}

		public boolean isOptional() {
			return optional && !typeMatch;
		}

		public boolean isOptionalRecursive(IConstraintElement root) {
			if (isOptional())
				return true;
			if (getContainer() != root) {
				if (getContainer().getType() == ConstraintElementType.ALTERNATIVE)
					return true;
				if (getContainer().isOptional())
					return true;
			}
			return false;
		}

		protected boolean isTypeMatch() {
			return this.typeMatch;
		}

		protected void setAssignmentId(int id) {
			this.assignmentId = id;
		}

		protected void setContainingConstraint(IConstraint containingConstraint) {
			this.containingConstraint = containingConstraint;
		}

		protected void setElementId(int id) {
			this.elementId = id;
		}

		protected void setFeatureAssignmentId(int id) {
			this.featureAssignmentId = id;
		}

		protected void setFeatureInfo(IFeatureInfo featureInfo) {
			this.featureInfo = featureInfo;
		}

		protected void setMany(boolean many) {
			this.many = many;
		}

		protected void setOptional(boolean optional) {
			this.optional = optional;
		}

		@Override
		public String toString() {
			if (this == INVALID)
				return "INVALID";
			if (this == TYPEMATCH)
				return "TYPEMATCH";
			if (type == null)
				return "error(type is null)";
			switch (type) {
				case ALTERNATIVE:
					return "(" + Join.join(" | ", getChildren()) + ")" + getCardinality();
				case GROUP:
					return "(" + Join.join(" ", getChildren()) + ")" + getCardinality();
				case ASSIGNED_ACTION_CALL:
					return getFeatureName() + getAssignmentOperator() + getContextName(getAction()) + getCardinality();
				case ASSIGNED_PARSER_RULE_CALL:
					return getFeatureName() + getAssignmentOperator()
							+ getContextName((ParserRule) getRuleCall().getRule()) + getCardinality();
				case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
					return getFeatureName() + getAssignmentOperator() + "[" + getCrossReferenceType().getName() + "|"
							+ getRuleCall().getRule().getName() + "]" + getCardinality();
				case ASSIGNED_TERMINAL_RULE_CALL:
				case ASSIGNED_DATATYPE_RULE_CALL:
				case ASSIGNED_ENUM_RULE_CALL:
					return getFeatureName() + getAssignmentOperator() + getRuleCall().getRule().getName()
							+ getCardinality();
				case ASSIGNED_CROSSREF_KEYWORD:
				case ASSIGNED_KEYWORD:
				case ASSIGNED_BOOLEAN_KEYWORD:
					return getFeatureName() + getAssignmentOperator() + "'" + getKeyword().getValue() + "'"
							+ getCardinality();
				case UNASSIGNED_DATATYPE_RULE_CALL:
				case UNASSIGNED_TERMINAL_RULE_CALL:
					return getRuleCall().getRule().getName() + getCardinality();
			}
			return "error";
		}

		protected void typeMatch() {
			this.typeMatch = true;
		}

		public boolean isRoot() {
			return container == null;
		}

		//
		//		public IConstraintElement getExcludingAlternative() {
		//			if (excludingAlternative == UNINTITIALIZED) {
		//				IConstraintElement ele = getContainer();
		//				while (ele != null) {
		//					if (ele.getType() == ConstraintElementType.ALTERNATIVE) {
		//						if (ele.isManyRecursive(null))
		//							return excludingAlternative = null;
		//						else
		//							return excludingAlternative = ele;
		//
		//					} else
		//						ele = ele.getContainer();
		//				}
		//				return excludingAlternative = null;
		//			}
		//			return excludingAlternative;
		//		}

		public List<IConstraintElement> getContainedAssignments() {
			if (containedAssignments == null) {
				containedAssignments = Lists.newArrayList();
				if (assignmentId >= 0)
					containedAssignments.add(this);
				if (getChildren() != null)
					for (IConstraintElement child : getChildren())
						containedAssignments.addAll(child.getContainedAssignments());
			}
			return containedAssignments;
		}

		protected List<Pair<IConstraintElement, AssignmentDependencyKind>> dependingAssignments;

		public List<Pair<IConstraintElement, AssignmentDependencyKind>> getDependingAssignment() {
			if (assignmentId < 0)
				return null;
			if (dependingAssignments == null) {
				dependingAssignments = Lists.newArrayList();
				collectDependingAssignmentsByContainer(this, dependingAssignments, isMany(), isOptional());
			}
			return dependingAssignments;
		}

		protected void collectDependingAssignmentsByContainer(IConstraintElement child,
				List<Pair<IConstraintElement, AssignmentDependencyKind>> result, boolean childMany,
				boolean childOptional) {
			IConstraintElement container = child.getContainer();
			if (container == null)
				return;
			boolean cntOptional = container.isOptionalRecursive(null);
			boolean cntMany = container.isManyRecursive(null);
			switch (container.getType()) {
				case ALTERNATIVE:
					if (!container.isManyRecursive(null))
						for (IConstraintElement choice : container.getChildren())
							if (choice != child)
								for (IConstraintElement ass : choice.getContainedAssignments())
									result.add(Tuples.create(ass, AssignmentDependencyKind.EXCLUDE_IF_SET));
					break;
				case GROUP:
					if (!cntOptional && !cntMany)
						return;
					for (IConstraintElement choice : container.getChildren())
						if (choice != child)
							for (IConstraintElement ass : choice.getContainedAssignments()) {
								boolean assMany = ass.isManyRecursive(container);
								boolean assOptional = ass.isOptionalRecursive(container);
								boolean exclude_if_unset = !assOptional;
								boolean mandatory_if_set = !childOptional;
								boolean same = false, same_or_less = false, same_or_more = false;
								if (cntMany) {
									if (!assMany && !assOptional && !childMany && !childOptional)
										same = true;
									else if ((childOptional && !childMany && !assOptional)
											|| (!assOptional && !childMany && !assOptional && assMany))
										same_or_less = true;
									else if ((!childOptional && !childMany && assOptional && !assMany)
											|| (!childOptional && childMany && !assOptional && !assMany)
											|| (!childOptional && childMany && assOptional && !assMany))
										same_or_more = true;
								}
								if (exclude_if_unset && !same_or_less && !same)
									result.add(Tuples.create(ass, AssignmentDependencyKind.EXCLUDE_IF_UNSET));
								if (mandatory_if_set && !same_or_more && !same)
									result.add(Tuples.create(ass, AssignmentDependencyKind.MANDATORY_IF_SET));
								if (same)
									result.add(Tuples.create(ass, AssignmentDependencyKind.SAME));
								if (same_or_less)
									result.add(Tuples.create(ass, AssignmentDependencyKind.SAME_OR_LESS));
								if (same_or_more)
									result.add(Tuples.create(ass, AssignmentDependencyKind.SAME_OR_MORE));
							}
					break;
				default:
			}
			childMany = childMany || container.isMany();
			childOptional = childOptional || container.isOptional()
					|| container.getType() == ConstraintElementType.ALTERNATIVE;
			collectDependingAssignmentsByContainer(container, result, childMany, childOptional);
		}
	}

	protected static class FeatureInfo implements IFeatureInfo {

		protected IConstraintElement[] assignments;

		protected IConstraint constraint;

		protected Boolean contentValidationNeeded;

		protected EStructuralFeature feature;

		public FeatureInfo(IConstraint constraint, EStructuralFeature feature, IConstraintElement[] assignments) {
			super();
			this.constraint = constraint;
			this.feature = feature;
			this.assignments = assignments;
			for (IConstraintElement ass : assignments)
				((ConstraintElement) ass).setFeatureInfo(this);
		}

		public int getAssignmentCount() {
			return assignments.length;
		}

		public IConstraintElement[] getAssignments() {
			return assignments;
		}

		public IConstraint getContainingConstraint() {
			return constraint;
		}

		public EStructuralFeature getFeature() {
			return feature;
		}

		public boolean isContentValidationNeeded() {
			if (contentValidationNeeded != null)
				return contentValidationNeeded;
			if (assignments.length < 2)
				return contentValidationNeeded = false;
			IConstraintElement first = assignments[0];
			for (int i = 1; i < assignments.length; i++)
				if (first.getCrossReferenceType() != assignments[i].getCrossReferenceType()
						|| EcoreUtil.equals(first.getGrammarElement(), assignments[i].getGrammarElement()))
					return contentValidationNeeded = true;
			return contentValidationNeeded = true;
		}

	}

	protected static class ParserRuleConstraintContext extends AbstractConstraintContext {

		protected ParserRule rule;

		public ParserRuleConstraintContext(ParserRule rule) {
			super();
			this.rule = rule;
		}

		public EClass getCommonType() {
			return (EClass) rule.getType().getClassifier();
		}

		public EObject getContext() {
			return rule;
		}

		@Override
		protected String getName() {
			return getContextName(rule);
		}

	}

	protected static class RuleConstraint extends Constraint {

		protected ParserRule context;

		public RuleConstraint(ParserRule context, EClass type, ConstraintElement body) {
			super(type, body);
			this.context = context;
		}

		@Override
		protected EObject getMostSpecificContext() {
			return body == null ? context : body.getContext();
		}

	}

	protected final static ConstraintElement INVALID = new ConstraintElement();

	protected final static ConstraintElement UNINTITIALIZED = new ConstraintElement();

	protected final static ConstraintElement TYPEMATCH = new ConstraintElement();

	protected static String getContextName(Action ctx) {
		ParserRule rule = EcoreUtil2.getContainerOfType(ctx, ParserRule.class);
		return rule.getName() + "_" + getUniqueActionName(ctx);
	}

	protected static String getContextName(ParserRule ctx) {
		return ctx.getName();
	}

	protected static String getUniqueActionName(Action action) {
		List<Integer> indices = Lists.newArrayList();
		EObject current = action;
		while (current.eContainer() instanceof AbstractElement) {
			indices.add(current.eContainer().eContents().indexOf(current));
			current = current.eContainer();
		}
		Collections.reverse(indices);
		return action.getType().getClassifier().getName() + "_" + Join.join("_", indices);
	}

	protected static boolean isParserRuleCall(EObject ele) {
		if (!(ele instanceof RuleCall))
			return false;
		RuleCall call = (RuleCall) ele;
		return call.getRule() instanceof ParserRule
				&& ((ParserRule) call.getRule()).getType().getClassifier() instanceof EClass;
	}

	protected static boolean isUnassignedParserRuleCall(EObject ele) {
		if (!isParserRuleCall(ele))
			return false;
		return GrammarUtil.containingAssignment(ele) == null;
	}

	protected ActionFilterNFAProvider nfaProvider = createNfaProvider();

	protected void collectTypesForContext(AbstractElement context, Set<EClass> types, Set<Object> visited) {
		if (!visited.add(context))
			return;
		TreeIterator<EObject> ti = EcoreUtil2.eAll(context);
		while (ti.hasNext()) {
			EObject obj = ti.next();
			if (isUnassignedParserRuleCall(obj))
				collectTypesForContext((ParserRule) ((RuleCall) obj).getRule(), types, visited);
			else if (obj instanceof Action)
				types.add((EClass) ((Action) obj).getType().getClassifier());
		}
	}

	protected void collectTypesForContext(ActionFilterState state, Set<EClass> types, boolean allowLocal,
			Set<Object> visited) {
		if (allowLocal) {
			if (state.isEndState())
				types.add((EClass) GrammarUtil.containingRule(state.getGrammarElement()).getType().getClassifier());
			collectTypesForContext(state.getGrammarElement(), types, visited);
			if (isAssignedAction(state.getGrammarElement()))
				return;
		}
		if (!visited.add(state))
			return;
		for (ActionFilterTransition t : state.getAllOutgoing())
			if (!t.isRuleCall())
				collectTypesForContext(t.getTarget(), types, true, visited);
	}

	protected void collectTypesForContext(ParserRule context, Set<EClass> types, Set<Object> visited) {
		if (!visited.add(context))
			return;
		if (containsAssignedAction(context)) {
			ActionFilterState start = nfaProvider.getNFA(context.getAlternatives());
			collectTypesForContext(start, types, false, visited);
		} else {
			types.add((EClass) context.getType().getClassifier());
			collectTypesForContext(context.getAlternatives(), types, visited);
		}
	}

	protected boolean containsAssignedAction(ParserRule rule) {
		TreeIterator<EObject> ti = rule.eAllContents();
		while (ti.hasNext()) {
			EObject obj = ti.next();
			if (obj instanceof Action && ((Action) obj).getFeature() != null)
				return true;
		}
		return false;
	}

	protected ConstraintElement createConstraintElement(EObject context, AbstractElement ele, EClass requiredType,
			Set<Object> visited) {
		boolean isOptional = GrammarUtil.isOptionalCardinality(ele);
		if (ele instanceof Action) {
			Action action = (Action) ele;
			if (action.getFeature() == null) {
				if (action.getType().getClassifier() == requiredType)
					return TYPEMATCH;
				else
					return isOptional ? null : INVALID;
			} else
				new ConstraintElement(context, getConstraintElementType(ele), ele);
		} else if (ele instanceof RuleCall) {
			RuleCall rc = (RuleCall) ele;
			if (isUnassignedParserRuleCall(rc)) {
				if (!visited.add(rc))
					return null;
				ConstraintElement result = createConstraintElement((ParserRule) rc.getRule(), requiredType, visited);
				if (result != null && result != INVALID) {
					if (rc.getRule().getType().getClassifier() == requiredType)
						result.typeMatch();
					if (result.isTypeMatch())
						return result;
				}
				return isOptional ? null : INVALID;
			} else
				return new ConstraintElement(context, getConstraintElementType(ele), ele);
		} else if (ele instanceof Keyword) {
			if (GrammarUtil.containingAssignment(ele) != null)
				return new ConstraintElement(context, getConstraintElementType(ele), ele);
			return null;
		} else if (ele instanceof Assignment) {
			Assignment ass = (Assignment) ele;
			ConstraintElement result = createConstraintElement(context, ass.getTerminal(), requiredType, visited);
			if (result != null && result != INVALID) {
				result.setMany(result.isMany() || GrammarUtil.isMultipleCardinality(ele));
				result.setOptional(result.isOptional() || GrammarUtil.isOptionalCardinality(ele));
			}
			return result;
		} else if (ele instanceof CrossReference) {
			CrossReference cr = (CrossReference) ele;
			ConstraintElement result = createConstraintElement(context, cr.getTerminal(), requiredType, visited);
			if (result != null && result != INVALID) {
				result.setMany(result.isMany() || GrammarUtil.isMultipleCardinality(ele));
				result.setOptional(result.isOptional() || GrammarUtil.isOptionalCardinality(ele));
			}
			return result;
		} else if (ele instanceof Alternatives) {
			Alternatives alt = (Alternatives) ele;
			List<ConstraintElement> children = Lists.newArrayList();
			List<ConstraintElement> typeMatchChildren = Lists.newArrayList();
			boolean allInvalid = true;
			boolean nullExists = false;
			boolean typeMatch = false;
			for (AbstractElement ae : alt.getElements()) {
				ConstraintElement ce = createConstraintElement(context, ae, requiredType, visited);
				if (ce != INVALID) {
					allInvalid = false;
					if (ce != TYPEMATCH) {
						if (ce != null) {
							if (ce.isTypeMatch())
								typeMatchChildren.add(ce);
							else
								children.add(ce);
						} else
							nullExists = true;
					} else
						typeMatch = true;
				}
			}
			if (allInvalid)
				return isOptional ? null : INVALID;
			if (typeMatch || !typeMatchChildren.isEmpty()) {
				children = typeMatchChildren;
				nullExists = typeMatch;
			}
			if (children.isEmpty())
				return typeMatch ? TYPEMATCH : null;
			else if (children.size() == 1) {
				ConstraintElement result = children.get(0);
				result.setMany(result.isMany() || GrammarUtil.isMultipleCardinality(ele));
				result.setOptional(result.isOptional() || nullExists || GrammarUtil.isOptionalCardinality(ele));
				return result;
			} else {
				ConstraintElement result = new ConstraintElement(context, getConstraintElementType(ele), ele);
				result.setOptional(result.isOptional() || nullExists);
				for (ConstraintElement child : children)
					if (child.getType() == ConstraintElementType.ALTERNATIVE && !child.isOptional() && !child.isMany())
						result.addAllChilden(child);
					else
						result.addChild(child);
				return result;
			}
		} else if (ele instanceof Group || ele instanceof UnorderedGroup) {
			CompoundElement group = (CompoundElement) ele;
			List<ConstraintElement> children = Lists.newArrayList();
			boolean typeMatch = false;
			for (AbstractElement ae : group.getElements()) {
				ConstraintElement ce = createConstraintElement(context, ae, requiredType, visited);
				if (ce == INVALID && !ce.isOptional())
					return isOptional ? null : INVALID;
				if (ce != INVALID && ce != null && ce != TYPEMATCH)
					children.add(ce);
				else if (ce == TYPEMATCH)
					typeMatch = true;
			}
			if (children.isEmpty())
				return typeMatch ? TYPEMATCH : null;
			else if (children.size() == 1) {
				ConstraintElement result = children.get(0);
				result.setMany(result.isMany() || GrammarUtil.isMultipleCardinality(ele));
				result.setOptional(result.isOptional() || GrammarUtil.isOptionalCardinality(ele));
				if (typeMatch)
					result.typeMatch();
				return result;
			} else {
				ConstraintElement result = new ConstraintElement(context, getConstraintElementType(ele), ele);
				for (ConstraintElement child : children)
					if (child.getType() == ConstraintElementType.GROUP && !child.isOptional() && !child.isMany())
						result.addAllChilden(child);
					else
						result.addChild(child);
				if (typeMatch)
					result.typeMatch();
				return result;
			}
		}
		return null;
	}

	protected ConstraintElement createConstraintElement(EObject context, ActionFilterState state, EClass requiredType,
			boolean allowLocal, Set<Object> visited) {
		if (allowLocal && isAssignedAction(state.getGrammarElement())) {
			if (((Action) state.getGrammarElement()).getType().getClassifier() == requiredType) {
				ConstraintElement result = new ConstraintElement(context, ConstraintElementType.ASSIGNED_ACTION_CALL,
						state.getGrammarElement());
				result.typeMatch();
				return result;
			} else
				return INVALID;
		}
		if (allowLocal && state.isEndState() && !isUnassignedParserRuleCall(state.getGrammarElement())) {
			if (GrammarUtil.containingRule(state.getGrammarElement()).getType().getClassifier() != requiredType)
				return INVALID;
		}
		if (!visited.add(state))
			return null;
		List<ConstraintElement> followers = Lists.newArrayList();
		boolean allInvalid = true, containsOne = false;
		for (ActionFilterTransition t : state.getAllOutgoing())
			if (!t.isRuleCall() && t.getTarget() != state) {
				containsOne = true;
				ConstraintElement f = createConstraintElement(context, t.getTarget(), requiredType, true, visited);
				if (f != INVALID) {
					allInvalid = false;
					if (f != null)
						followers.add(f);
				}
			}
		if (containsOne && allInvalid)
			return INVALID;
		ConstraintElement local = allowLocal ? createConstraintElement(context, state.getGrammarElement(),
				requiredType, visited) : null;
		if (local == INVALID && !GrammarUtil.isOptionalCardinality(state.getGrammarElement()))
			return INVALID;
		if (followers.isEmpty())
			return local == INVALID || local == null ? null : local;
		if (local != INVALID && local != null)
			for (int i = 0; i < followers.size(); i++) {
				ConstraintElement follower = followers.get(i);
				if (follower.getType() == ConstraintElementType.GROUP && !follower.isMany() && !follower.isOptional())
					follower.insertChild(local);
				else {
					ConstraintElement group = new ConstraintElement(context, ConstraintElementType.GROUP);
					group.addChild(follower);
					group.addChild(local);
					followers.set(i, group);
				}
			}
		followers = filterDuplicates(followers);
		if (followers.size() == 1)
			return followers.get(0);
		ConstraintElement alt = new ConstraintElement(context, ConstraintElementType.ALTERNATIVE);
		for (ConstraintElement f : followers)
			alt.addChild(f);
		return alt;
	}

	protected ConstraintElement createConstraintElement(ParserRule rule, EClass requiredType, Set<Object> visited) {
		if (!visited.add(rule))
			return INVALID;
		if (containsAssignedAction(rule)) {
			ActionFilterState start = nfaProvider.getNFA(rule.getAlternatives());
			return createConstraintElement(rule, start, requiredType, false, visited);
		} else {
			return createConstraintElement(rule, rule.getAlternatives(), requiredType, visited);
		}
	}

	protected ActionFilterNFAProvider createNfaProvider() {
		return new ActionFilterNFAProvider();
	}

	protected void filterDuplicateConstraintsAndSetNames(List<IConstraintContext> contexts) {
		Map<IConstraint, List<IConstraint>> equalConstraints = Maps.newHashMap();
		for (IConstraintContext context : contexts)
			for (IConstraint constraint : context.getConstraints()) {
				List<IConstraint> same = equalConstraints.get(constraint);
				if (same == null)
					equalConstraints.put(constraint, same = Lists.newArrayList());
				same.add(constraint);
			}
		Map<IConstraint, IConstraint> allConstraints = Maps.newIdentityHashMap();
		for (Collection<IConstraint> equal : equalConstraints.values()) {
			IConstraint representative = findRepresentativeConstraint(equal);
			((Constraint) representative).setName(findBestConstraintName(equal));
			for (IConstraint constraint : equal)
				allConstraints.put(constraint, representative);
		}
		for (IConstraintContext context : contexts) {
			for (int i = 0; i < context.getConstraints().size(); i++) {
				IConstraint replacement = allConstraints.get(context.getConstraints().get(i));
				context.getConstraints().set(i, replacement);
			}
			((AbstractConstraintContext) context).initConstraints();
		}
	}

	protected List<ConstraintElement> filterDuplicates(List<ConstraintElement> list) {
		List<ConstraintElement> result = Lists.newArrayList();
		for (ConstraintElement ce : list) {
			boolean found = false;
			for (ConstraintElement r : result)
				if (ce.equals(r)) {
					found = true;
					break;
				}
			if (!found)
				result.add(ce);
		}
		return result;
	}

	protected String findBestConstraintName(Collection<IConstraint> equalConstraints) {
		// strategy 1: if there is a parser rule context, use it for a name
		for (IConstraint c : equalConstraints)
			if (((Constraint) c).getMostSpecificContext() instanceof ParserRule)
				return getContextName((ParserRule) ((Constraint) c).getMostSpecificContext()) + "_"
						+ c.getType().getName();

		// strategy 2: use the names of all actions
		List<String> actions = Lists.newArrayList();
		for (IConstraint c : equalConstraints)
			actions.add(getUniqueActionName((Action) ((ConstraintElement) c.getBody()).getContext()));
		Set<ParserRule> visited = Sets.newHashSet();
		List<String> rules = Lists.newArrayList();
		for (IConstraint c : equalConstraints) {
			ParserRule pr = GrammarUtil.containingParserRule(((ConstraintElement) c.getBody()).getContext());
			if (visited.add(pr))
				rules.add(pr.getName());
		}
		return Join.join("_", rules) + "_" + Join.join("_", actions) + "_"
				+ equalConstraints.iterator().next().getType().getName();
	}

	protected IConstraint findRepresentativeConstraint(Collection<IConstraint> equalConstraints) {
		for (IConstraint c : equalConstraints)
			if (((Constraint) c).getMostSpecificContext() instanceof ParserRule)
				return c;
		return equalConstraints.iterator().next();
	}

	protected ConstraintElementType getConstraintElementType(AbstractElement ele) {
		Assignment ass;
		if (ele instanceof Action) {
			if (((Action) ele).getFeature() != null)
				return ConstraintElementType.ASSIGNED_ACTION_CALL;
		} else if (ele instanceof Alternatives) {
			return ConstraintElementType.ALTERNATIVE;
		} else if (ele instanceof Group || ele instanceof UnorderedGroup) {
			return ConstraintElementType.GROUP;
		} else if (GrammarUtil.containingCrossReference(ele) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule)
					return ConstraintElementType.ASSIGNED_CROSSREF_DATATYPE_RULE_CALL;
				if (rc.getRule() instanceof TerminalRule)
					return ConstraintElementType.ASSIGNED_CROSSREF_TERMINAL_RULE_CALL;
				if (rc.getRule() instanceof EnumRule)
					return ConstraintElementType.ASSIGNED_CROSSREF_ENUM_RULE_CALL;
			} else if (ele instanceof Keyword)
				return ConstraintElementType.ASSIGNED_CROSSREF_KEYWORD;
		} else if ((ass = GrammarUtil.containingAssignment(ele)) != null) {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule) {
					if (rc.getRule().getType().getClassifier() instanceof EClass)
						return ConstraintElementType.ASSIGNED_PARSER_RULE_CALL;
					return ConstraintElementType.ASSIGNED_DATATYPE_RULE_CALL;
				}
				if (rc.getRule() instanceof TerminalRule)
					return ConstraintElementType.ASSIGNED_TERMINAL_RULE_CALL;
				if (rc.getRule() instanceof EnumRule)
					return ConstraintElementType.ASSIGNED_ENUM_RULE_CALL;

			} else if (ele instanceof Keyword) {
				if (GrammarUtil.isBooleanAssignment(ass))
					return ConstraintElementType.ASSIGNED_BOOLEAN_KEYWORD;
				else
					return ConstraintElementType.ASSIGNED_KEYWORD;
			}
		} else {
			if (ele instanceof RuleCall) {
				RuleCall rc = (RuleCall) ele;
				if (rc.getRule() instanceof ParserRule)
					return ConstraintElementType.UNASSIGNED_DATATYPE_RULE_CALL;
				if (rc.getRule() instanceof TerminalRule)
					return ConstraintElementType.UNASSIGNED_TERMINAL_RULE_CALL;
			}
		}
		throw new RuntimeException("Unknown Grammar Element: " + EmfFormatter.objPath(ele));
	}

	protected IConstraintContext getConstraints(Action context /*, Map<Object, Constraint> constraints*/) {
		//		IConstraintContext ruleConstraints = getConstraints(GrammarUtil.containingParserRule(context), constraints);
		AssignedActionConstraintContext result = new AssignedActionConstraintContext(context);
		ActionFilterState start = nfaProvider.getNFA(context);
		Set<EClass> types = Sets.newHashSet();
		collectTypesForContext(start, types, false, Sets.newHashSet());
		for (EClass type : types) {
			ConstraintElement ce = createConstraintElement(context, start, type, false, Sets.newHashSet());
			if (ce == TYPEMATCH) {
				Constraint constraint = new ActionConstraint(context, type, null);
				result.addConstraint(constraint);
			} else if (ce != null && ce != INVALID) {
				Constraint constraint = new ActionConstraint(context, type, ce);
				result.addConstraint(constraint);
			}
		}
		return result;
	}

	protected Map<Grammar, List<IConstraintContext>> cache = Maps.newHashMap();

	public List<IConstraintContext> getConstraints(Grammar context) {
		List<IConstraintContext> result = cache.get(context);
		if (result == null) {
			result = Lists.newArrayList();
			for (ParserRule parserRule : GrammarUtil.allParserRules(context))
				if (parserRule.getType().getClassifier() instanceof EClass) {
					result.add(getConstraints(parserRule));
					for (Action action : GrammarUtil.containedActions(parserRule))
						if (action.getFeature() != null)
							result.add(getConstraints(action));
				}
			filterDuplicateConstraintsAndSetNames(result);
			cache.put(context, result);
		}
		return result;
	}

	protected IConstraintContext getConstraints(ParserRule context) {
		ParserRuleConstraintContext result = new ParserRuleConstraintContext(context);
		Set<EClass> types = Sets.newHashSet();
		collectTypesForContext(context, types, Sets.newHashSet());
		for (EClass type : types) {
			ConstraintElement ce = createConstraintElement(context, type, Sets.newHashSet());
			if (ce == TYPEMATCH) {
				Constraint constraint = new RuleConstraint(context, type, null);
				result.addConstraint(constraint);
			} else if (ce != null && ce != INVALID) {
				Constraint constraint = new RuleConstraint(context, type, ce);
				result.addConstraint(constraint);
			}
		}
		return result;
	}

	protected boolean isAssignedAction(AbstractElement ele) {
		return ele instanceof Action && ((Action) ele).getFeature() != null;
	}

}
