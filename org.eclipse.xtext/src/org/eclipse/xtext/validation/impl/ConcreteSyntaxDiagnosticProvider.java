/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.validation.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator;
import org.eclipse.xtext.validation.IAssignmentQuantityAllocator.IQuantities;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ConstraintType;
import org.eclipse.xtext.validation.IConcreteSyntaxConstraintProvider.ISyntaxConstraint;
import org.eclipse.xtext.validation.IConcreteSyntaxDiagnosticProvider;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxDiagnosticProvider implements IConcreteSyntaxDiagnosticProvider {

	public abstract class AbstractConcreteSyntaxDiagnostic implements IConcreteSyntaxDiagnostic {
		protected Set<ISyntaxConstraint> involved;
		protected ISyntaxConstraint rule;
		protected EObject source;

		public AbstractConcreteSyntaxDiagnostic(ISyntaxConstraint rule, EObject source, Set<ISyntaxConstraint> involved) {
			super();
			this.rule = rule;
			this.source = source;
			this.involved = involved;
		}

		protected void appendConstraint(StringBuffer msg) {
			if (involved.size() > 1) {
				msg.append(" Constraint: ");
				msg.append(getConstraint());
				msg.append(" Quantities: ");
				msg.append(getValue());
			}
		}

		@Override
		public List<Diagnostic> getChildren() {
			return Collections.emptyList();
		}

		protected List<String> getChildren(ISyntaxConstraint obj, final Set<ISyntaxConstraint> included) {
			ArrayList<String> r = new ArrayList<String>();
			for (ISyntaxConstraint o : obj.getContents())
				if (included.contains(o))
					r.add(getConstraint(o, included));
			return r;
		}

		protected ISyntaxConstraint getCommonContainer() {
			Iterator<ISyntaxConstraint> i = involved.iterator();
			if (!i.hasNext())
				return null;
			ISyntaxConstraint root = i.next();
			while (i.hasNext())
				root = root.findCommonContainer(i.next());
			return root;
		}

		public String getConstraint() {
			if (involved.size() > 1) {
				ISyntaxConstraint commonContainer = getCommonContainer();
				return getConstraint(commonContainer, getInvolvedIncludingContainers(commonContainer));
			} else
				return "";
		}

		protected String getConstraint(ISyntaxConstraint element, Set<ISyntaxConstraint> all) {
			switch (element.getType()) {
				case ASSIGNMENT:
					return ((Assignment) element.getGrammarElement()).getFeature() + element.getCardinality();
				case GROUP:
					List<String> children1 = getChildren(element, all);
					if (children1.size() == 1)
						return children1.get(0) + element.getCardinality();
					return "(" + Joiner.on(" ").join(children1) + ")" + element.getCardinality();
				case ALTERNATIVE:
					List<String> children2 = getChildren(element, all);
					return "(" + Joiner.on("|").join(children2) + ")" + element.getCardinality();
				case ACTION:
					return "{" + ((Action) element.getGrammarElement()).getType().getClassifier().getName() + "}";
			}
			return "";
		}

		@Override
		public List<?> getData() {
			return Arrays.asList(source);
		}

		@Override
		public Throwable getException() {
			return null;
		}

		protected Set<ISyntaxConstraint> getInvolvedIncludingContainers(ISyntaxConstraint commonRoot) {
			HashSet<ISyntaxConstraint> all = new HashSet<ISyntaxConstraint>(involved);
			all.add(commonRoot);
			for (ISyntaxConstraint a : involved) {
				ISyntaxConstraint cnt = a.getContainer();
				while (all.add(cnt))
					cnt = cnt.getContainer();
			}
			return all;
		}

		public ParserRule getRule() {
			return GrammarUtil.containingParserRule(rule.getGrammarElement());
		}

		@Override
		public int getSeverity() {
			return Diagnostic.ERROR;
		}

		@Override
		public String getSource() {
			return EmfFormatter.objPath(source);
		}

		public String getValue() {
			Set<EStructuralFeature> feats = new HashSet<EStructuralFeature>();
			for (ISyntaxConstraint a : involved)
				if (a.getType() == ConstraintType.ASSIGNMENT)
					feats.add(a.getAssignmentFeature(source.eClass()));
			return Joiner.on(", ").join(Iterables.transform(feats, new Function<EStructuralFeature, String>() {
				@Override
				public String apply(EStructuralFeature from) {
					return from.getName() + ":" + quantityAllocator.getFeatureQuantity(source, from);
				}
			}));
		}

		@Override
		public String toString() {
			return getMessage() + " Source: " + getSource();
		}

	}

	public class ConcreteSyntaxAssignmentMissingDiagnostic extends AbstractConcreteSyntaxDiagnostic {
		protected EStructuralFeature feature;
		protected Set<EClass> requiredTypes;

		public ConcreteSyntaxAssignmentMissingDiagnostic(ISyntaxConstraint rule, EObject source,
				EStructuralFeature feature, Set<ISyntaxConstraint> involved) {
			super(rule, source, involved);
			this.feature = feature;
			this.requiredTypes = Sets.newHashSet();
			collectAssignments(this.rule, this.feature, requiredTypes);
		}

		protected void collectAssignments(ISyntaxConstraint ele, EStructuralFeature matcher, Set<EClass> types) {
			if (ele.getType() == ConstraintType.ASSIGNMENT && ele.getAssignmentName().equals(matcher.getName()))
				types.addAll(ele.getSemanticTypes());
			for (ISyntaxConstraint e : ele.getContents())
				collectAssignments(e, matcher, types);
		}

		@Override
		public int getCode() {
			if (requiredTypes.isEmpty())
				return ERROR_ASSIGNMENT_MISSING;
			return ERROR_ASSIGNMENT_PROHIBITED;
		}

		@Override
		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("The feature ");
			msg.append(feature.getEContainingClass().getName());
			if (feature.getEContainingClass() != source.eClass()) {
				msg.append("(");
				msg.append(source.eClass().getName());
				msg.append(")");
			}
			msg.append(".");
			msg.append(feature.getName());
			switch (getCode()) {
				case ERROR_ASSIGNMENT_MISSING:
					msg.append(" contains non-transient values but has no corresponding assignment in rule ");
					msg.append(getRule().getName());
					break;
				case ERROR_ASSIGNMENT_PROHIBITED:
					msg.append(" is not allowed to contain non-transient values. ");
					msg.append("The object needs to be of type ");
					msg.append(Joiner.on(" or ").join(Iterables.transform(requiredTypes, new Function<EClass, String>() {
						@Override
						public String apply(EClass from) {
							return from.getName();
						}
					})));
			}
			msg.append(".");
			appendConstraint(msg);
			return msg.toString();
		}
	}

	public class ConcreteSyntaxFeatureDiagnostic extends AbstractConcreteSyntaxDiagnostic {

		protected EStructuralFeature feature;
		protected int min, max, actual;

		public ConcreteSyntaxFeatureDiagnostic(ISyntaxConstraint rule, IQuantities source, EStructuralFeature feature,
				int actual, int min, int max, Set<ISyntaxConstraint> involved) {
			super(rule, source.getEObject(), involved);
			this.feature = feature;
			this.actual = actual;
			this.min = min;
			this.max = max;
		}

		public int getActual() {
			return actual;
		}

		@Override
		public int getCode() {
			if (feature == null)
				return ERROR_FEATURE_MISSING;
			if (feature.isMany()) {
				if (actual < min && actual > max)
					return ERROR_LIST_UNDECIDEABLE;
				if (actual < min)
					return ERROR_LIST_TOO_FEW;
				if (actual > max)
					return ERROR_LIST_TOO_MANY;
			} else {
				if (actual < min)
					return ERROR_VALUE_REQUIRED;
				if (actual > max)
					return ERROR_VALUE_PROHIBITED;
			}
			return 0;
		}

		@Override
		public List<?> getData() {
			return Arrays.asList(source, feature);
		}

		public EStructuralFeature getFeature() {
			return feature;
		}

		public int getMax() {
			return max;
		}

		@Override
		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("Feature ");
			msg.append(source.eClass().getName());
			msg.append(".");
			msg.append(feature.getName());
			switch (getCode()) {
				case ERROR_LIST_UNDECIDEABLE:
					msg.append(" holds " + actual + " non-transient value(s), but at least " + min + " and at most "
							+ max + " are expected. ");
					msg.append("Since this is impossible, please resolve other constraint-violations first. ");
					msg.append("If that doesn't help, ask Chuck Norris for help or file a bug report.");
					break;
				case ERROR_LIST_TOO_FEW:
					msg.append(" holds " + actual + " non-transient value(s), ");
					if (min == max)
						msg.append("but exactly " + min + " are required.");
					else
						msg.append("but at least " + min + " are required.");
					break;
				case ERROR_LIST_TOO_MANY:
					msg.append(" holds " + actual + " non-transient value(s), ");
					if (min == max)
						msg.append("but exactly " + max + " are required.");
					else
						msg.append("but at most " + max + " are allowed.");
					break;
				case ERROR_VALUE_REQUIRED:
					msg.append(" must be set.");
					break;
				case ERROR_VALUE_PROHIBITED:
					msg.append(" must not be set.");
					break;
			}
			appendConstraint(msg);
			//			msg.append(" min:" + min);
			//			msg.append(" max:" + max);
			return msg.toString();
		}

		public int getMin() {
			return min;
		}

	}

	public class ConcreteSyntaxFeatureMissingDiagnostic extends AbstractConcreteSyntaxDiagnostic {
		protected ISyntaxConstraint element;

		public ConcreteSyntaxFeatureMissingDiagnostic(ISyntaxConstraint rule, EObject source,
				ISyntaxConstraint element, Set<ISyntaxConstraint> involved) {
			super(rule, source, involved);
			this.element = element;
		}

		@Override
		public int getCode() {
			return ERROR_FEATURE_MISSING;
		}

		@Override
		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("A feature named '");
			msg.append(element.getAssignmentName());
			msg.append("' in ");
			msg.append(source.eClass().getName());
			msg.append(" is needed for serialization with rule ");
			msg.append(getRule().getName());
			msg.append(".");
			appendConstraint(msg);
			return msg.toString();
		}
	}

	public class ConcreteSyntaxObjectDiagnostic extends AbstractConcreteSyntaxDiagnostic {
		public ConcreteSyntaxObjectDiagnostic(ISyntaxConstraint rule, EObject source, Set<ISyntaxConstraint> involved) {
			super(rule, source, involved);
		}

		@Override
		public int getCode() {
			return ERROR_WRONG_TYPE;
		}

		@Override
		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("An object of type ");
			msg.append(Joiner.on(" or ").join(Iterables.transform(getSemanticTypes(), new Function<EClass, String>() {
				@Override
				public String apply(EClass from) {
					return from.getName();
				}
			})));
			msg.append(" is needed instead of ");
			msg.append(source.eClass().getName());
			msg.append(" for serialization with rule ");
			msg.append(getRule().getName());
			msg.append(".");
			appendConstraint(msg);
			return msg.toString();
		}

		protected Set<EClass> getSemanticTypes() {
			Set<EClass> types = Sets.newHashSet();
			for (ISyntaxConstraint c : involved)
				if (c.getSemanticTypesToCheck() != null)
					types.addAll(c.getSemanticTypesToCheck());
			return types;
		}
	}

	@Inject
	protected IAssignmentQuantityAllocator quantityAllocator;

	@Override
	public IConcreteSyntaxDiagnostic createAssignmentMissingDiagnostic(ISyntaxConstraint rule, EObject source,
			EStructuralFeature feature, Set<ISyntaxConstraint> involved) {
		return new ConcreteSyntaxAssignmentMissingDiagnostic(rule, source, feature, involved);
	}

	@Override
	public IConcreteSyntaxDiagnostic createFeatureMissingDiagnostic(ISyntaxConstraint rule, EObject source,
			ISyntaxConstraint element, Set<ISyntaxConstraint> involved) {
		return new ConcreteSyntaxFeatureMissingDiagnostic(rule, source, element, involved);
	}

	@Override
	public IConcreteSyntaxDiagnostic createFeatureQuantityDiagnostic(ISyntaxConstraint rule, IQuantities source,
			EStructuralFeature feature, int actual, int min, int max, Set<ISyntaxConstraint> involved) {
		return new ConcreteSyntaxFeatureDiagnostic(rule, source, feature, actual, min, max, involved);
	}

	@Override
	public IConcreteSyntaxDiagnostic createUnexpectedTypeDiagnostic(ISyntaxConstraint rule, EObject source,
			Set<ISyntaxConstraint> involved) {
		return new ConcreteSyntaxObjectDiagnostic(rule, source, involved);
	}

}
