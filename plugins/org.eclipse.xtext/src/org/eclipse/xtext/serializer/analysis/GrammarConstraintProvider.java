/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.analysis;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterState;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterTransition;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.GrammarFormatter;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
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
public class GrammarConstraintProvider implements IGrammarConstraintProvider {

	protected abstract static class AbstractConstraintContext implements IConstraintContext {

		protected List<IConstraint> constraints = Lists.newArrayList();

		protected String name;

		private AbstractConstraintContext(String name) {
			super();
			this.name = name;
		}

		protected void addConstraint(Constraint constraint) {
			constraints.add(constraint);
		}

		public List<IConstraint> getConstraints() {
			return constraints;
		}

		public String getName() {
			return name;
		}

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
			return getName() + ": " + Joiner.on(" | ").join(constraintNames) + ";";
		}
	}

	protected static class ActionConstraint extends Constraint {

		protected Action actionContext;

		public ActionConstraint(Action context, EClass type, ConstraintElement body, GrammarConstraintProvider provider) {
			super(type, body, provider);
			this.actionContext = context;
		}

		@Override
		protected EObject getMostSpecificContext() {
			return body == null ? actionContext : body.getContext();
		}

	}

	protected static class AssignedActionConstraintContext extends AbstractConstraintContext {

		protected Action action;

		public AssignedActionConstraintContext(Action action, String name) {
			super(name);
			this.action = action;
		}

		public EClass getCommonType() {
			return (EClass) action.getType().getClassifier();
		}

		public EObject getContext() {
			return action;
		}

	}

	protected static abstract class Constraint implements IConstraint {

		protected IConstraintElement[] assignments;

		protected ConstraintElement body;

		protected GrammarConstraintProvider provider;

		protected IConstraintElement[] elements;

		protected IFeatureInfo[] features;

		protected String name;

		protected EObject specificContext;

		protected EClass type;

		public Constraint(EClass type, ConstraintElement body, GrammarConstraintProvider provider) {
			super();
			this.type = type;
			this.body = body;
			if (this.body != null)
				this.body.setContainingConstraint(this);
		}

		protected void collectElements(ConstraintElement ele, List<IConstraintElement> elements,
				List<IConstraintElement> assignments, List<IConstraintElement>[] assignmentsByFeature) {
			ele.setElementId(elements.size());
			elements.add(ele);
			switch (ele.getType()) {
				case ASSIGNED_ACTION_CALL:
				case ASSIGNED_CROSSREF_DATATYPE_RULE_CALL:
				case ASSIGNED_CROSSREF_ENUM_RULE_CALL:
				case ASSIGNED_CROSSREF_TERMINAL_RULE_CALL:
				case ASSIGNED_DATATYPE_RULE_CALL:
				case ASSIGNED_ENUM_RULE_CALL:
				case ASSIGNED_KEYWORD:
				case ASSIGNED_BOOLEAN_KEYWORD:
				case ASSIGNED_PARSER_RULE_CALL:
				case ASSIGNED_TERMINAL_RULE_CALL:
					EClass type = ele.getContainingConstraint().getType();
					EStructuralFeature feature = type.getEStructuralFeature(ele.getFeatureName());
					if (feature == null)
						throw new RuntimeException("Feature " + ele.getFeatureName() + " not found in "
								+ type.getName());
					int featureID = type.getFeatureID(feature);
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
			}
		}

		public int compareTo(IConstraint o) {
			return getName().compareTo(o.getName());
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

		public Iterable<IFeatureInfo> getMultiAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length > 1)
					result.add(info);
			return result;
		}

		public String getName() {
			return name;
		}

		public Iterable<IFeatureInfo> getSingleAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length == 1)
					result.add(info);
			return result;
		}

		public EClass getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return (type == null ? 0 : type.hashCode()) + (body == null ? 0 : (7 * body.hashCode()));
		}

		protected void initLists() {
			List<IConstraintElement> ele = Lists.newArrayList();
			List<IConstraintElement> ass = Lists.newArrayList();
			@SuppressWarnings("unchecked")
			List<IConstraintElement>[] feat = new List[getType() == null ? 0 : getType().getFeatureCount()];
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
			String typeName = getType() == null ? "null" : getType().getName();
			String body = getBody() != null ? getBody().toString() : "{" + typeName + "}";
			return getName() + " returns " + typeName + ": " + body + ";";
		}

	}

	protected static class ConstraintElement implements IConstraintElement {

		protected int assignmentId = -1;

		//		protected Boolean cardinalityOneForFeature;

		protected List<IConstraintElement> children;

		protected List<IConstraintElement> containedAssignments = null;

		//		protected IConstraintElement excludingAlternative = UNINTITIALIZED;

		protected ConstraintElement container;

		protected IConstraint containingConstraint;

		protected EObject context;

		protected List<Pair<IConstraintElement, RelationalDependencyType>> dependingAssignments;

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
			this(context, type, element, type != ConstraintElementType.ASSIGNED_ACTION_CALL
					&& GrammarUtil.isMultipleCardinality(element), type != ConstraintElementType.ASSIGNED_ACTION_CALL
					&& GrammarUtil.isOptionalCardinality(element));
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
			if (child == INVALID || child == TYPEMATCH)
				throw new RuntimeException("This is not a valid child: '" + child + "'");
			this.children.add(child);
			if (child.isTypeMatch())
				typeMatch();
		}

		protected void collectDependingAssignmentsByContainer(IConstraintElement child,
				List<Pair<IConstraintElement, RelationalDependencyType>> result, boolean childMany,
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
									result.add(Tuples.create(ass, RelationalDependencyType.EXCLUDE_IF_SET));
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
									result.add(Tuples.create(ass, RelationalDependencyType.EXCLUDE_IF_UNSET));
								if (mandatory_if_set && !same_or_more && !same)
									result.add(Tuples.create(ass, RelationalDependencyType.MANDATORY_IF_SET));
								if (same)
									result.add(Tuples.create(ass, RelationalDependencyType.SAME));
								if (same_or_less)
									result.add(Tuples.create(ass, RelationalDependencyType.SAME_OR_LESS));
								if (same_or_more)
									result.add(Tuples.create(ass, RelationalDependencyType.SAME_OR_MORE));
							}
					break;
				default:
			}
			childMany = childMany || container.isMany();
			childOptional = childOptional || container.isOptional()
					|| container.getType() == ConstraintElementType.ALTERNATIVE;
			collectDependingAssignmentsByContainer(container, result, childMany, childOptional);
		}

		protected boolean containsChild(IConstraintElement child) {
			if (children == null)
				return false;
			for (IConstraintElement c : children)
				if (c.equals(child))
					return true;
			return false;
		}

		protected String context2Name(EObject context) {
			return ((Constraint) getContainingConstraint()).provider.context2Name.apply(context);
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ConstraintElement))
				return false;
			ConstraintElement ce = (ConstraintElement) obj;
			if (element == ce.element) {
				if (children == null && ce.children == null)
					return true;
				else if (getType() == ConstraintElementType.ALTERNATIVE && children.size() == ce.children.size()) {
					for (IConstraintElement child : children)
						if (!ce.containsChild(child))
							return false;
					return true;
				} else
					return children.equals(ce.children);
			}
			return false;
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

		public List<Pair<IConstraintElement, RelationalDependencyType>> getDependingAssignment() {
			if (assignmentId < 0)
				return null;
			if (dependingAssignments == null) {
				dependingAssignments = Lists.newArrayList();
				collectDependingAssignmentsByContainer(this, dependingAssignments, isMany(), isOptional());
			}
			return dependingAssignments;
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

		//		protected void insertChild(ConstraintElement child) {
		//			child.container = this;
		//			this.children.add(0, child);
		//		}

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
			//			if (children != null)
			//				result += 7 * children.hashCode();
			return result;
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
			return isMany() || (container != null && container != root && container.isManyRecursive(root));
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
				if (getContainer().isOptionalRecursive(root))
					return true;
			}
			return false;
		}

		public boolean isRoot() {
			return container == null;
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
			GrammarFormatter<IConstraintElement, AbstractElement> formatter = GrammarFormatter.newFormatter(
					IConstraintElement.ADAPTER, new GrammarElementTitleSwitch().hideCardinality()
							.showActionsAsRuleCalls().showAssignments());
			return formatter.format(this, true);
		}

		protected void typeMatch() {
			this.typeMatch = true;
		}
	}

	protected static class FeatureInfo implements IFeatureInfo {

		protected IConstraintElement[] assignments;

		protected IConstraint constraint;

		protected Boolean contentValidationNeeded;

		protected List<Pair<IFeatureInfo, RelationalDependencyType>> dependingFeatures;

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

		public List<Pair<IFeatureInfo, RelationalDependencyType>> getDependingFeatures() {
			if (dependingFeatures == null) {
				dependingFeatures = Lists.newArrayList();
				for (Pair<IConstraintElement, RelationalDependencyType> p : getRelationalAssignemntConstraintIntersection())
					dependingFeatures.add(Tuples.create(p.getFirst().getFeatureInfo(), p.getSecond()));
			}
			return dependingFeatures;
		}

		public EStructuralFeature getFeature() {
			return feature;
		}

		public int getLowerBound() {
			int result = 0;
			for (IConstraintElement ass : getAssignments())
				if (!ass.isOptionalRecursive(null))
					result++;
			return result; // TODO: consider assignments excluding each other
		}

		protected List<Pair<IConstraintElement, RelationalDependencyType>> getRelationalAssignemntConstraintIntersection() {
			List<Pair<IConstraintElement, RelationalDependencyType>> r = getAssignments()[0].getDependingAssignment();
			if (getAssignmentCount() == 1)
				return r;
			r = Lists.newArrayList(r);
			for (int i = 1; i < getAssignments().length; i++)
				for (int j = r.size() - 1; j >= 0; j--)
					if (getAssignments()[i] == r.get(j).getFirst()
							|| !getAssignments()[i].getDependingAssignment().contains(r.get(j)))
						r.remove(j);
			return r;
		}

		public int getUpperBound() {
			for (IConstraintElement ass : getAssignments())
				if (ass.isManyRecursive(null))
					return -1;
			return getAssignmentCount(); // TODO: consider assignments excluding each other
		}

		public boolean isContentValidationNeeded() {
			if (contentValidationNeeded != null)
				return contentValidationNeeded;
			if (assignments.length < 2)
				return contentValidationNeeded = false;
			IConstraintElement first = assignments[0];
			for (int i = 1; i < assignments.length; i++)
				if (first.getCrossReferenceType() != assignments[i].getCrossReferenceType()
						|| !EcoreUtil.equals(first.getGrammarElement(), assignments[i].getGrammarElement()))
					return contentValidationNeeded = true;
			return contentValidationNeeded = false;
		}

		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			b.append(feature.getName());
			b.append("[");
			b.append(getLowerBound());
			b.append(", ");
			b.append(getUpperBound() == -1 ? "*" : getUpperBound());
			b.append("]");
			for (Pair<IFeatureInfo, RelationalDependencyType> rel : getDependingFeatures()) {
				b.append("\n    ");
				b.append(rel.getSecond());
				b.append(" ");
				b.append(rel.getFirst().getFeature().getName());
			}
			return b.toString();
		}

		public List<EObject> getCalledContexts() {
			List<EObject> result = Lists.newArrayList();
			for (IConstraintElement ass : getAssignments()) {
				EObject ctx = ass.getCallContext();
				if (ctx != null)
					result.add(ctx);
			}
			return result;
		}
	}

	protected static class ParserRuleConstraintContext extends AbstractConstraintContext {

		protected ParserRule rule;

		public ParserRuleConstraintContext(ParserRule rule, String name) {
			super(name);
			this.rule = rule;
		}

		public EClass getCommonType() {
			return (EClass) rule.getType().getClassifier();
		}

		public EObject getContext() {
			return rule;
		}

	}

	protected static class RuleConstraint extends Constraint {

		protected ParserRule context;

		public RuleConstraint(ParserRule context, EClass type, ConstraintElement body,
				GrammarConstraintProvider provider) {
			super(type, body, provider);
			this.context = context;
		}

		@Override
		protected EObject getMostSpecificContext() {
			return body == null ? context : body.getContext();
		}

	}

	protected final static ConstraintElement INVALID = new ConstraintElement();

	protected final static ConstraintElement TYPEMATCH = new ConstraintElement() {
		@Override
		protected boolean isTypeMatch() {
			return true;
		}
	};

	protected final static ConstraintElement UNINTITIALIZED = new ConstraintElement();

	protected Map<Grammar, List<IConstraintContext>> cache = Maps.newHashMap();

	@Inject
	protected Context2NameFunction context2Name;

	@Inject
	protected IContextProvider contextProvider;

	@Inject
	protected ActionFilterNFAProvider nfaProvider;

	protected ConstraintElement createConstraintElement(EObject context, AbstractElement ele, EClass requiredType,
			Set<Object> visited) {
		boolean isOptional = GrammarUtil.isOptionalCardinality(ele);
		if (ele instanceof Action) {
			if (requiredType == null)
				return INVALID;
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
			if (GrammarUtil.isUnassignedEObjectRuleCall(rc)) {
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
			} else if (GrammarUtil.containingAssignment(ele) != null)
				return new ConstraintElement(context, getConstraintElementType(ele), ele);
			else
				return null;
		} else if (ele instanceof Keyword) {
			if (GrammarUtil.containingAssignment(ele) != null)
				return new ConstraintElement(context, getConstraintElementType(ele), ele);
			return null;
		} else if (ele instanceof Assignment) {
			if (requiredType == null)
				return INVALID;
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
			else if (children.size() == 1 && (!children.get(0).isOptional() || !typeMatch)) {
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
		if (allowLocal && GrammarUtil.isAssignedAction(state.getGrammarElement())) {
			if (((Action) state.getGrammarElement()).getType().getClassifier() == requiredType) {
				ConstraintElement result = new ConstraintElement(context, ConstraintElementType.ASSIGNED_ACTION_CALL,
						state.getGrammarElement());
				result.typeMatch();
				return result;
			} else
				return INVALID;
		}
		if (!visited.add(state))
			return INVALID;
		List<ConstraintElement> followers = Lists.newArrayList();
		boolean allInvalid = true, containsOne = false, typematch = false;
		for (ActionFilterTransition t : state.getAllOutgoing())
			if (!t.isRuleCall() /* && t.getTarget() != state */) {
				containsOne = true;
				ConstraintElement f = createConstraintElement(context, t.getTarget(), requiredType, true, visited);
				if (f == TYPEMATCH) {
					allInvalid = false;
					typematch = true;
				} else if (f != INVALID) {
					allInvalid = false;
					if (f != null)
						followers.add(f);
				}
			}
		if (containsOne && allInvalid)
			return INVALID;
		ConstraintElement local = allowLocal ? createConstraintElement(context, state.getGrammarElement(),
				requiredType, visited) : null;
		if (typematch && local != null)
			local.typeMatch();
		if (allowLocal && state.isEndState() && !GrammarUtil.isUnassignedEObjectRuleCall(state.getGrammarElement())) {
			if (GrammarUtil.containingRule(state.getGrammarElement()).getType().getClassifier() != requiredType
					&& (local == null || !local.isTypeMatch()))
				return INVALID;
		}
		if (local == INVALID && !GrammarUtil.isOptionalCardinality(state.getGrammarElement()))
			return INVALID;
		if (followers.isEmpty())
			return local == INVALID || local == null ? (typematch ? TYPEMATCH : null) : local;
		if (local != INVALID && local != null)
			for (int i = 0; i < followers.size(); i++) {
				ConstraintElement follower = followers.get(i);
				if (follower.getType() == ConstraintElementType.GROUP && !follower.isMany() && !follower.isOptional())
					follower.addChild(local);
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
		ConstraintElement alt = null;
		for (ConstraintElement f : followers)
			if (f.getType() == ConstraintElementType.ALTERNATIVE && !f.isMany() && !f.isOptional()) {
				alt = f;
				break;
			}
		if (alt != null)
			followers.remove(alt);
		else
			alt = new ConstraintElement(context, ConstraintElementType.ALTERNATIVE);
		for (ConstraintElement f : followers)
			alt.addChild(f);
		return alt;
	}

	protected ConstraintElement createConstraintElement(ParserRule rule, EClass requiredType, Set<Object> visited) {
		if (!visited.add(rule))
			return INVALID;
		if (GrammarUtil.containsAssignedAction(rule)) {
			ActionFilterState start = nfaProvider.getNFA(rule.getAlternatives());
			return createConstraintElement(rule, start, requiredType, false, visited);
		} else {
			return createConstraintElement(rule, rule.getAlternatives(), requiredType, visited);
		}
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
			if (((Constraint) c).getMostSpecificContext() instanceof ParserRule) {
				String type = c.getType() != null ? c.getType().getName() : "null";
				return context2Name.getContextName((ParserRule) ((Constraint) c).getMostSpecificContext()) + "_" + type;
			}

		// strategy 2: use the names of all actions
		List<String> actions = Lists.newArrayList();
		for (IConstraint c : equalConstraints)
			actions.add(context2Name.getUniqueActionName(((ActionConstraint) c).actionContext));
		Set<ParserRule> visited = Sets.newHashSet();
		List<String> rules = Lists.newArrayList();
		for (IConstraint c : equalConstraints) {
			ParserRule pr = GrammarUtil.containingParserRule(((Constraint) c).getMostSpecificContext());
			if (visited.add(pr))
				rules.add(pr.getName());
		}
		return Joiner.on("_").join(rules) + "_" + Joiner.on('_').join(actions) + "_"
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
			}
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
		}
		throw new RuntimeException("Unknown Grammar Element: " + EmfFormatter.objPath(ele));
	}

	protected IConstraintContext getConstraints(Action context) {
		AssignedActionConstraintContext result = new AssignedActionConstraintContext(context,
				context2Name.getContextName(context));
		ActionFilterState start = nfaProvider.getNFA(context);
		Set<EClass> types = contextProvider.getTypesForContext(context);
		for (EClass type : types) {
			if (type == null) {
				Constraint constraint = new ActionConstraint(context, null, null, this);
				result.addConstraint(constraint);
			} else {
				ConstraintElement ce = createConstraintElement(context, start, type, false, Sets.newHashSet());
				if (ce == TYPEMATCH) {
					Constraint constraint = new ActionConstraint(context, type, null, this);
					result.addConstraint(constraint);
				} else if (ce != null && ce != INVALID) {
					Constraint constraint = new ActionConstraint(context, type, ce, this);
					result.addConstraint(constraint);
				} else
					System.err.println("constraint is " + ce + " for context " + context2Name.getContextName(context)
							+ " and type " + type.getName());
			}
		}
		return result;
	}

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
		ParserRuleConstraintContext result = new ParserRuleConstraintContext(context,
				context2Name.getContextName(context));
		Set<EClass> types = contextProvider.getTypesForContext(context);
		for (EClass type : types) {
			if (type == null) {
				Constraint constraint = new RuleConstraint(context, null, null, this);
				result.addConstraint(constraint);
			} else {
				ConstraintElement ce = createConstraintElement(context, type, Sets.newHashSet());
				if (ce == TYPEMATCH) {
					Constraint constraint = new RuleConstraint(context, type, null, this);
					result.addConstraint(constraint);
				} else if (ce != null && ce != INVALID) {
					Constraint constraint = new RuleConstraint(context, type, ce, this);
					result.addConstraint(constraint);
				} else
					System.err.println("constraint is " + ce + " for context " + context2Name.getContextName(context)
							+ " and type " + type.getName());
			}
		}
		return result;
	}

}
