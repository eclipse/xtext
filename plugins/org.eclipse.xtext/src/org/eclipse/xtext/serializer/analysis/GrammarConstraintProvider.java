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

import org.eclipse.emf.common.util.URI;
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
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.grammaranalysis.impl.GrammarElementTitleSwitch;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterState;
import org.eclipse.xtext.serializer.analysis.ActionFilterNFAProvider.ActionFilterTransition;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.ProductionFormatter;

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
@SuppressWarnings("deprecation")
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

		@Override
		public List<IConstraint> getConstraints() {
			return constraints;
		}

		@Override
		public String getName() {
			return name;
		}

		protected void initConstraints() {
			Collections.sort(constraints, new Comparator<IConstraint>() {
				@Override
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
				@Override
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

		@Override
		public EClass getCommonType() {
			return (EClass) action.getType().getClassifier();
		}

		@Override
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
				case ASSIGNED_CROSSREF_KEYWORD:
				case ASSIGNED_DATATYPE_RULE_CALL:
				case ASSIGNED_ENUM_RULE_CALL:
				case ASSIGNED_KEYWORD:
				case ASSIGNED_PARSER_RULE_CALL:
				case ASSIGNED_TERMINAL_RULE_CALL:
					EClass type = ele.getContainingConstraint().getType();
					EStructuralFeature feature = type.getEStructuralFeature(ele.getFeatureName());
					if (feature == null) {
						// TODO find a meaningful way to handle this
						System.err.println("Feature " + ele.getFeatureName() + " not found in "
								+ type.getName());
					} else {
						int featureID = type.getFeatureID(feature);
						List<IConstraintElement> assignmentByFeature = assignmentsByFeature[featureID];
						if (assignmentByFeature == null)
							assignmentsByFeature[featureID] = assignmentByFeature = Lists.newArrayList();
						ele.setFeatureAssignmentId(assignmentByFeature.size());
						assignmentByFeature.add(ele);
						ele.setAssignmentId(assignments.size());
						assignments.add(ele);
					}
					return;
				case ALTERNATIVE:
				case GROUP:
					for (IConstraintElement e : ele.getChildren())
						collectElements((ConstraintElement) e, elements, assignments, assignmentsByFeature);
					return;
			}
		}

		@Override
		public int compareTo(IConstraint o) {
			return getName().compareTo(o.getName());
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Constraint))
				return false;
			Constraint c = (Constraint) obj;
			if (type != null && c.type != null) {
				if (!type.getName().equals(c.type.getName()))
					return false;
				if (!type.getEPackage().getNsURI().equals(c.type.getEPackage().getNsURI()))
					return false;
			} else if (type != null || c.type != null)
				return false;
			return (body == null && c.body == null) || (body != null && body.equals(c.body));
		}

		@Override
		public IConstraintElement[] getAssignments() {
			return assignments;
		}

		@Override
		public IConstraintElement getBody() {
			return body;
		}

		protected Object getCacheKey() {
			return Tuples.create(body.getContext(), type);
		}

		@Override
		public IConstraintElement[] getElements() {
			return elements;
		}

		@Override
		public IFeatureInfo[] getFeatures() {
			return features;
		}

		protected abstract EObject getMostSpecificContext();

		protected Collection<EObject> getAllContext() {
			Set<EObject> result = Sets.newLinkedHashSet();
			result.add(getMostSpecificContext());
			collectContexts(body, result);
			return result;
		}

		protected void collectContexts(ConstraintElement ele, Set<EObject> result) {
			if (ele != null) {
				EObject context = ele.getContext();
				if (context != null)
					result.add(context);
				if (ele.getChildren() != null)
					for (IConstraintElement child : ele.getChildren())
						collectContexts((ConstraintElement) child, result);
			}
		}

		@Override
		public Iterable<IFeatureInfo> getMultiAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length > 1)
					result.add(info);
			return result;
		}

		@Override
		public String getName() {
			return name + "_" + (type == null ? "null" : type.getName());
		}

		@Override
		public String getSimpleName() {
			return name;
		}

		@Override
		public Iterable<IFeatureInfo> getSingleAssignementFeatures() {
			List<IFeatureInfo> result = Lists.newArrayList();
			for (IFeatureInfo info : features)
				if (info != null && info.getAssignments().length == 1)
					result.add(info);
			return result;
		}

		@Override
		public EClass getType() {
			return type;
		}

		@Override
		public int hashCode() {
			int result = body == null ? 0 : body.hashCode();
			if (type != null) {
				result += 7 * type.getName().hashCode();
				result += 13 * type.getEPackage().getNsURI().hashCode();
			}
			return result;
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

		protected URI elementURI;

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

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof ConstraintElement))
				return false;
			ConstraintElement ce = (ConstraintElement) obj;
			switch (type) {
				case ALTERNATIVE: {
					if (children == null || ce.children == null || children.size() != ce.children.size())
						return false;
					for (IConstraintElement child : children)
						if (!ce.containsChild(child))
							return false;
					return true;
				}
				case GROUP:
					return children.equals(ce.children);
				default:
					return getElementURI().equals(ce.getElementURI());
			}
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

		@Override
		public Action getAction() {
			return element instanceof Action ? (Action) element : null;
		}

		@Override
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

		@Override
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

		@Override
		public String getCardinality() {
			return isMany() ? (isOptional() ? "*" : "+") : (isOptional() ? "?" : "");
		}

		@Override
		public List<IConstraintElement> getChildren() {
			return children;
		}

		@Override
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

		@Override
		public IConstraintElement getContainer() {
			return container;
		}

		@Override
		public IConstraint getContainingConstraint() {
			if (containingConstraint == null)
				containingConstraint = getContainer().getContainingConstraint();
			return containingConstraint;
		}

		protected EObject getContext() {
			return context;
		}

		@Override
		public CrossReference getCrossReference() {
			if (element == null)
				return null;
			return GrammarUtil.containingCrossReference(element);
		}

		@Override
		public EClass getCrossReferenceType() {
			if (element == null)
				return null;
			CrossReference cr = GrammarUtil.containingCrossReference(element);
			if (cr == null)
				return null;
			return (EClass) cr.getType().getClassifier();
		}

		@Override
		public List<Pair<IConstraintElement, RelationalDependencyType>> getDependingAssignment() {
			if (assignmentId < 0)
				return null;
			if (dependingAssignments == null) {
				dependingAssignments = Lists.newArrayList();
				collectDependingAssignmentsByContainer(this, dependingAssignments, isMany(), isOptional());
			}
			return dependingAssignments;
		}

		@Override
		public int getElementID() {
			return elementId;
		}

		@Override
		public EStructuralFeature getFeature() {
			return getFeatureInfo().getFeature();
		}

		@Override
		public int getFeatureAssignmentID() {
			return featureAssignmentId;
		}

		@Override
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

		@Override
		public AbstractElement getGrammarElement() {
			return element;
		}

		@Override
		public Keyword getKeyword() {
			return element instanceof Keyword ? (Keyword) element : null;
		}

		@Override
		public RuleCall getRuleCall() {
			return element instanceof RuleCall ? (RuleCall) element : null;
		}

		@Override
		public ConstraintElementType getType() {
			return type;
		}

		protected URI getElementURI() {
			if (elementURI == null)
				elementURI = element == null ? URI.createURI("null") : EcoreUtil.getURI(element);
			return elementURI;
		}

		@Override
		public int hashCode() {
			switch (type) {
				case ALTERNATIVE: {
					// has code must be independent of children's order
					int result = 0;
					for (IConstraintElement child : children)
						result += child.hashCode();
					return result;
				}
				case GROUP: {
					// has code must depend of children's order
					int result = 0;
					for (int i = 0; i < children.size(); i++)
						result += children.get(i).hashCode() + i;
					return result;
				}
				default:
					return getElementURI().hashCode();
			}
		}

		@Override
		public boolean isCardinalityOneAmongAssignments(List<IConstraintElement> assignments) {
			if (assignments.size() < 2)
				return false;
			IConstraintElement commonContainer = findCommonContainer(assignments);
			return commonContainer.getType() != ConstraintElementType.ALTERNATIVE
					&& !isOptionalRecursive(commonContainer) && !isManyRecursive(commonContainer);
		}

		@Override
		public boolean isMany() {
			return many;
		}

		@Override
		public boolean isManyRecursive(IConstraintElement root) {
			return isMany() || (container != null && container != root && container.isManyRecursive(root));
		}

		@Override
		public boolean isOptional() {
			return optional && !typeMatch;
		}

		@Override
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

		@Override
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
			GrammarElementTitleSwitch t2s = new GrammarElementTitleSwitch().hideCardinality().showActionsAsRuleCalls()
					.showAssignments();
			ProductionFormatter<IConstraintElement, AbstractElement> formatter = new ProductionFormatter<IConstraintElement, AbstractElement>();
			formatter.setTokenToString(t2s);
			return formatter.format(new ConstraintElementProduction(getContainingConstraint()), this, true);
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

		@Override
		public IConstraintElement[] getAssignments() {
			return assignments;
		}

		@Override
		public IConstraint getContainingConstraint() {
			return constraint;
		}

		@Override
		public List<Pair<IFeatureInfo, RelationalDependencyType>> getDependingFeatures() {
			if (dependingFeatures == null) {
				dependingFeatures = Lists.newArrayList();
				for (Pair<IConstraintElement, RelationalDependencyType> p : getRelationalAssignemntConstraintIntersection())
					dependingFeatures.add(Tuples.create(p.getFirst().getFeatureInfo(), p.getSecond()));
			}
			return dependingFeatures;
		}

		@Override
		public EStructuralFeature getFeature() {
			return feature;
		}

		@Override
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

		@Override
		public int getUpperBound() {
			for (IConstraintElement ass : getAssignments())
				if (ass.isManyRecursive(null))
					return -1;
			return getAssignmentCount(); // TODO: consider assignments excluding each other
		}

		@Override
		public boolean isContentValidationNeeded() {
			if (contentValidationNeeded != null)
				return contentValidationNeeded;
			contentValidationNeeded = false;
			if (assignments.length >= 2) {
				IConstraintElement first = assignments[0];
				if (first.getType() == ConstraintElementType.ASSIGNED_ACTION_CALL)
					contentValidationNeeded = true;
				else
					for (int i = 1; i < assignments.length; i++) {
						IConstraintElement a = assignments[i];
						if (a.getType() == ConstraintElementType.ASSIGNED_ACTION_CALL
								|| first.getCrossReferenceType() != a.getCrossReferenceType()
								|| !EcoreUtil.equals(first.getGrammarElement(), a.getGrammarElement())) {
							contentValidationNeeded = true;
							break;
						}
					}
			}
			return contentValidationNeeded;
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

		@Override
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

		@Override
		public EClass getCommonType() {
			return (EClass) rule.getType().getClassifier();
		}

		@Override
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
	protected RuleNames ruleNames;

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
				return null; //new ConstraintElement(context, getConstraintElementType(ele), ele);
		} else if (ele instanceof RuleCall) {
			RuleCall rc = (RuleCall) ele;
			if (GrammarUtil.isUnassignedEObjectRuleCall(rc)) {
				ParserRule rule = (ParserRule) rc.getRule();
				if (!rule.isFragment()) {
					if (!visited.add(rc))
						return null;
					ConstraintElement result = createConstraintElement(rule, requiredType, visited);
					if (result != null && result != INVALID) {
						TypeRef returnType = rc.getRule().getType();
						if (returnType.getClassifier() == requiredType)
							result.typeMatch();
						if (result.isTypeMatch())
							return result;
					}
					return isOptional ? null : INVALID;
				} else {
					ConstraintElement result = createConstraintElement(context, rule.getAlternatives(), requiredType, visited);
					if (result != null && result != INVALID) {
						result.setMany(result.isMany() || GrammarUtil.isMultipleCardinality(ele));
						result.setOptional(result.isOptional() || GrammarUtil.isOptionalCardinality(ele));
					}
					return result;
				}
			} else if (GrammarUtil.containingAssignment(ele) != null) {
				return new ConstraintElement(context, getConstraintElementType(ele), ele);
			} else {
				return null;
			}
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
		if (GrammarUtil.containsAssignedAction(rule)) { // also check actions in used fragments
			ActionFilterState start = nfaProvider.getNFA(rule.getAlternatives());
			return createConstraintElement(rule, start, requiredType, false, visited);
		} else {
			return createConstraintElement(rule, rule.getAlternatives(), requiredType, visited);
		}
	}

	protected void filterDuplicateConstraintsAndSetNames(Grammar grammar, List<IConstraintContext> contexts) {
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
			//			Collection<IConstraint> equal = filterConstraintsFromSubGrammars(grammar, allEqual);
			IConstraint representative = findRepresentativeConstraint(equal);
			((Constraint) representative).setName(findBestConstraintName(grammar, equal));
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

	protected Map<Grammar, Integer> getInheritanceDistance(Grammar grammar) {
		Map<Grammar, Integer> result = Maps.newHashMap();
		Grammar current = grammar;
		int distance = 0;
		while (current != null) {
			result.put(current, distance);
			current = current.getUsedGrammars().isEmpty() ? null : current.getUsedGrammars().get(0);
			distance++;
		}
		return result;
	}

	//	protected Collection<IConstraint> filterConstraintsFromSubGrammars(Grammar grammar,
	//			Collection<IConstraint> constraints) {
	//		if (constraints.size() <= 1)
	//			return constraints;
	//		Map<Grammar, Integer> inheritanceDistance = getInheritanceDistance(grammar);
	//		int maxDistance = 0;
	//		for (IConstraint c : constraints)
	//			maxDistance = Math.max(maxDistance, inheritanceDistance.get(c.getDeclaringGrammar()));
	//		Collection<IConstraint> filteredConstraints = Lists.newArrayList();
	//		for (IConstraint c : constraints) {
	//			if (inheritanceDistance.get(c.getDeclaringGrammar()) == maxDistance)
	//				filteredConstraints.add(c);
	//		}
	//		return filteredConstraints;
	//	}

	protected void collectElements(IConstraintElement ele, List<AbstractElement> result) {
		if (ele.getGrammarElement() != null)
			result.add(ele.getGrammarElement());
		if (ele.getChildren() != null)
			for (IConstraintElement e : ele.getChildren())
				collectElements(e, result);
	}

	protected String findBestConstraintName(Grammar grammar, Collection<IConstraint> equalConstraints) {
		Set<ParserRule> relevantRules = Sets.newLinkedHashSet();
		Set<Action> relevantActions = Sets.newLinkedHashSet();
		Set<ParserRule> contextRules = Sets.newLinkedHashSet();
		for (IConstraint c : equalConstraints)
			for (EObject ctx : ((Constraint) c).getAllContext())
				if (ctx instanceof ParserRule)
					contextRules.add((ParserRule) ctx);
		List<AbstractElement> ele = Lists.newArrayList();
		IConstraint first = equalConstraints.iterator().next();
		if (first.getBody() != null)
			collectElements(first.getBody(), ele);
		for (AbstractElement e : ele)
			relevantRules.add(GrammarUtil.containingParserRule(e));
		for (IConstraint c : equalConstraints)
			for (EObject ctx : ((Constraint) c).getAllContext())
				if (ctx instanceof Action) {
					Action action = (Action) ctx;
					ParserRule rule = GrammarUtil.containingParserRule(action);
					if (!contextRules.contains(rule)) {
						relevantActions.add(action);
						relevantRules.add(rule);
					}
				}
		if (relevantRules.isEmpty()) {
			EClass type = first.getType();
			if (type != null) {
				for (ParserRule context : contextRules)
					for (Action a : GrammarUtil.containedActions(context))
						if (a.getType().getClassifier() == type) {
							relevantRules.add(context);
						}
				if (relevantRules.isEmpty())
					for (ParserRule context : contextRules)
						if (context.getType().getClassifier() == type) {
							relevantRules.add(context);
						}
			}
			if (relevantRules.isEmpty())
				relevantRules.addAll(contextRules);
		}
		List<String> actions = Lists.newArrayList();
		List<String> rules = Lists.newArrayList();
		for (Action a : relevantActions)
			actions.add(context2Name.getUniqueActionName(a));
		for (ParserRule a : relevantRules)
			rules.add(context2Name.getContextName(grammar, a));
		Collections.sort(rules);
		String result = Joiner.on("_").join(rules);
		if (!actions.isEmpty()) {
			Collections.sort(actions);
			result += "_" + Joiner.on('_').join(actions);
		}
		return result;
	}

	protected IConstraint findRepresentativeConstraint(Collection<IConstraint> equalConstraints) {
		for (IConstraint c : equalConstraints)
			if (((Constraint) c).getMostSpecificContext() instanceof ParserRule)
				return c;
		return equalConstraints.iterator().next();
	}

	protected ConstraintElementType getConstraintElementType(AbstractElement ele) {
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
		} else if (GrammarUtil.containingAssignment(ele) != null) {
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
				return ConstraintElementType.ASSIGNED_KEYWORD;
			}
		}
		throw new RuntimeException("Unknown Grammar Element: " + EmfFormatter.objPath(ele));
	}

	protected IConstraintContext getConstraints(Grammar grammar, Action context) {
		AssignedActionConstraintContext result = new AssignedActionConstraintContext(context,
				context2Name.getContextName(grammar, context));
		ActionFilterState start = nfaProvider.getNFA(context);
		Set<EClass> types = contextProvider.getTypesForContext(grammar, context);
		for (EClass type : types) {
			if (type == null) {
				Constraint constraint = new ActionConstraint(context, null, null, this);
				result.addConstraint(constraint);
			} else {
				ConstraintElement ce = createConstraintElement(context, start, type, false, Sets.newLinkedHashSet());
				if (ce == TYPEMATCH) {
					Constraint constraint = new ActionConstraint(context, type, null, this);
					result.addConstraint(constraint);
				} else if (ce != null && ce != INVALID) {
					Constraint constraint = new ActionConstraint(context, type, ce, this);
					result.addConstraint(constraint);
				} else
					// TODO find a meaningful way to handle this
					System.err.println("constraint is " + ce + " for context " + context2Name.getContextName(grammar, context)
							+ " and type " + type.getName());
			}
		}
		return result;
	}

	@Override
	public List<IConstraintContext> getConstraints(Grammar context) {
		List<IConstraintContext> result = cache.get(context);
		if (result == null) {
			result = Lists.newArrayList();
			for (ParserRule parserRule : GrammarUtil.allParserRules(context)) {
				if (parserRule.getType() != null && parserRule.getType().getClassifier() instanceof EClass && !parserRule.isFragment()) {
					result.add(getConstraints(context, parserRule));
					for (Action action : GrammarUtil.containedActions(parserRule))
						if (action.getFeature() != null)
							result.add(getConstraints(context, action));
				}
			}
			filterDuplicateConstraintsAndSetNames(context, result);
			cache.put(context, result);
		}
		return result;
	}

	protected IConstraintContext getConstraints(Grammar grammar, ParserRule context) {
		ParserRuleConstraintContext result = new ParserRuleConstraintContext(context,
				context2Name.getContextName(grammar, context));
		Set<EClass> types = contextProvider.getTypesForContext(grammar, context);
		for (EClass type : types) {
			if (type == null) {
				Constraint constraint = new RuleConstraint(context, null, null, this);
				result.addConstraint(constraint);
			} else {
				ConstraintElement ce = createConstraintElement(context, type, Sets.newLinkedHashSet());
				if (ce == TYPEMATCH) {
					Constraint constraint = new RuleConstraint(context, type, null, this);
					result.addConstraint(constraint);
				} else if (ce != null && ce != INVALID) {
					Constraint constraint = new RuleConstraint(context, type, ce, this);
					result.addConstraint(constraint);
				} else
					// TODO find a meaningful way to handle this
					System.err.println("constraint is " + ce + " for context " + context2Name.getContextName(grammar, context)
							+ " and type " + type.getName());
			}
		}
		return result;
	}

}
