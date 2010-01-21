/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.validation;

import static org.eclipse.xtext.GrammarUtil.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ConcreteSyntaxValidator extends AbstractConcreteSyntaxValidator {

	public abstract class AbstractConcreteSyntaxDiagnostic implements IConcreteSyntaxDiagnostic {
		protected Set<Element> involved;
		protected Element rule;
		protected EObject source;

		public AbstractConcreteSyntaxDiagnostic(Element rule, EObject source, Set<Element> involved) {
			super();
			this.rule = rule;
			this.source = source;
			this.involved = involved;
		}

		public List<Diagnostic> getChildren() {
			return Collections.emptyList();
		}

		private List<String> getChildren(Element obj, final Set<Element> included) {
			ArrayList<String> r = new ArrayList<String>();
			for (Element o : obj.getContents())
				if (included.contains(o))
					r.add(getConstraint(o, included));
			return r;
		}

		private Element getCommonContainer() {
			Iterator<Element> i = involved.iterator();
			if (!i.hasNext())
				return null;
			Element root = i.next();
			while (i.hasNext())
				root = getCommonRoot(root, i.next());
			return root;
		}

		private Element getCommonRoot(Element obj1, Element obj2) {
			Element cnt1 = obj1;
			while (cnt1 != null) {
				Element cnt2 = obj2;
				while (cnt2 != null) {
					if (cnt1.equals(cnt2))
						return cnt1;
					cnt2 = cnt2.getContainer();
				}
				cnt1 = cnt1.getContainer();
			}
			return null;
		}

		public String getConstraint() {
			if (involved.size() > 1) {
				Element commonContainer = getCommonContainer();
				return getConstraint(commonContainer, getInvolvedIncludingContainers(commonContainer));
			} else
				return "";
		}

		private String getConstraint(Element element, Set<Element> all) {
			String card = element.getEle().getCardinality() != null ? element.getEle().getCardinality() : "";
			switch (element.getType()) {
				case ASSIGNMENT:
					return ((Assignment) element.getEle()).getFeature() + card;
				case GROUP:
					List<String> children1 = getChildren(element, all);
					if (children1.size() == 1)
						return children1.get(0) + card;
					return "(" + Join.join(" ", children1) + ")" + card;
				case ALTERNATIVE:
					List<String> children2 = getChildren(element, all);
					return "(" + Join.join("|", children2) + ")" + card;
				case ACTION:
					return "{" + ((Action) element.getEle()).getType().getClassifier().getName() + "}";
			}
			return "";
		}

		public List<?> getData() {
			return Arrays.asList(source);
		}

		protected void appendConstraint(StringBuffer msg) {
			if (involved.size() > 1) {
				msg.append(" Constraint: ");
				msg.append(getConstraint());
				msg.append(" Quantities: ");
				msg.append(getValue());
			}
		}

		public Throwable getException() {
			return null;
		}

		private Set<Element> getInvolvedIncludingContainers(Element commonRoot) {
			HashSet<Element> all = new HashSet<Element>(involved);
			all.add(commonRoot);
			for (Element a : involved) {
				Element cnt = a.getContainer();
				while (all.add(cnt))
					cnt = cnt.getContainer();
			}
			return all;
		}

		public ParserRule getRule() {
			return GrammarUtil.containingParserRule(rule.getEle());
		}

		public int getSeverity() {
			return Diagnostic.ERROR;
		}

		public String getSource() {
			return EmfFormatter.objPath(source);
		}

		public String getValue() {
			Set<EStructuralFeature> feats = new HashSet<EStructuralFeature>();
			for (Element a : involved)
				if (a.getType() == ElementType.ASSIGNMENT)
					feats.add(ConcreteSyntaxValidator.this.getFeature(source.eClass(), a));
			return Join.join(", ", Iterables.transform(feats, new Function<EStructuralFeature, String>() {
				public String apply(EStructuralFeature from) {
					return from.getName() + ":" + getActualCount(source, from);
				}
			}));
		}

		@Override
		public String toString() {
			return getMessage() + " Source: " + getSource();
		}

	}

	public class ConcreteSyntaxFeatureDiagnostic extends AbstractConcreteSyntaxDiagnostic {

		protected EStructuralFeature feature;
		protected int min, max, actual;

		public ConcreteSyntaxFeatureDiagnostic(Element rule, EObject source, EStructuralFeature feature, int actual,
				int min, int max, Set<Element> involved) {
			super(rule, source, involved);
			this.feature = feature;
			this.actual = actual;
			this.min = min;
			this.max = max;
		}

		@Override
		public List<?> getData() {
			return Arrays.asList(source, feature);
		}

		public int getActual() {
			return actual;
		}

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

		public EStructuralFeature getFeature() {
			return feature;
		}

		public int getMax() {
			return max;
		}

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
		protected Element element;

		public ConcreteSyntaxFeatureMissingDiagnostic(Element rule, EObject source, Element element,
				Set<Element> involved) {
			super(rule, source, involved);
			this.element = element;
		}

		public int getCode() {
			return ERROR_FEATURE_MISSING;
		}

		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("A feature named '");
			msg.append(((Assignment) element.getEle()).getFeature());
			msg.append("' in ");
			msg.append(source.eClass().getName());
			msg.append(" is needed for serialization with rule");
			msg.append(getRule().getName());
			msg.append(".");
			appendConstraint(msg);
			return msg.toString();
		}
	}

	public class ConcreteSyntaxObjectDiagnostic extends AbstractConcreteSyntaxDiagnostic {
		public ConcreteSyntaxObjectDiagnostic(Element rule, EObject source, Set<Element> involved) {
			super(rule, source, involved);
		}

		public int getCode() {
			return ERROR_WRONG_TYPE;
		}

		public String getMessage() {
			StringBuffer msg = new StringBuffer();
			msg.append("An object of type ");
			msg.append(Join.join(" or ", Iterables.transform(involved, new Function<Element, String>() {
				public String apply(Element from) {
					return from.getSemanticType().getName();
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
	}

	protected class Element {
		protected Element container;
		protected List<Element> contents;
		protected AbstractElement element;
		protected boolean multiple = false;
		protected boolean optional = false;
		protected EClass semanticType = null;
		protected ElementType type;

		public Element(ElementType type, Element container, AbstractElement ele, boolean multiple, boolean optional) {
			super();
			if (type == null)
				throw new NullPointerException("type must not be null");
			this.type = type;
			this.container = container;
			this.element = ele;
			this.multiple = multiple;
			this.optional = optional;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Element)
				return ((Element) obj).element == element;
			return false;
		}

		public Element getContainer() {
			return container;
		}

		public List<Element> getContents() {
			if (contents == null) {
				contents = new ArrayList<Element>();
				if (getType() == ElementType.ALTERNATIVE || getType() == ElementType.GROUP)
					for (EObject e : element.eContents()) {
						Element x = createElement(this, e);
						if (x != null)
							contents.add(x);

					}
			}
			return contents;
		}

		public AbstractElement getEle() {
			return element;
		}

		public EClass getSemanticType() {
			if (semanticType == null) {
				EClassifier clsf = null;
				if (getType() == ElementType.ACTION)
					clsf = ((Action) element).getType().getClassifier();
				else if (element.eContainer() instanceof AbstractRule)
					clsf = ((AbstractRule) element.eContainer()).getType().getClassifier();
				if (clsf instanceof EClass)
					semanticType = (EClass) clsf;
			}
			return semanticType;
		}

		public EClass getMinSemanticType() {
			EClass s = getSemanticType();
			return s != null ? s : container.getMinSemanticType();
		}

		public ElementType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return element.hashCode();
		}

		public boolean isMultiple() {
			return multiple;
		}

		public boolean isOptional() {
			return optional;
		}

		public boolean isRoot() {
			return container == null;
		}

		@Override
		public String toString() {
			String c = element.getCardinality() == null ? "" : element.getCardinality();
			String t = getSemanticType() == null ? "" : getSemanticType().getName() + ":";
			switch (getType()) {
				case ASSIGNMENT:
					return t + ((Assignment) element).getFeature() + c;
				case GROUP:
					return t + "(" + Join.join(" ", getContents()) + ")" + c;
				case ALTERNATIVE:
					return t + "(" + Join.join("|", getContents()) + ")" + c;
				case ACTION:
					return "{" + ((Action) element).getType().getClassifier().getName() + "}";
			}
			return "";
		}

	}

	protected enum ElementType {
		ACTION, ALTERNATIVE, ASSIGNMENT, GROUP
	}

	public static final int ERROR_FEATURE_MISSING = 6;

	public static final int ERROR_LIST_UNDECIDEABLE = 3;

	public static final int ERROR_LIST_TOO_FEW = 4;

	public static final int ERROR_LIST_TOO_MANY = 5;

	public static final int ERROR_VALUE_PROHIBITED = 2;

	public static final int ERROR_VALUE_REQUIRED = 1;

	public static final int ERROR_WRONG_TYPE = 7;

	public static int MAX = Integer.MAX_VALUE;

	public static int UNDEF = -1;

	@Inject
	protected IGrammarAccess grammarAcc;

	@Inject
	protected ITransientValueService transSrvc;

	protected void collectAssignments(EClass type, Element root, List<Element> assignments) {
		if (root.getSemanticType() != null && !root.getSemanticType().isSuperTypeOf(type))
			return;
		if (root.getType() == ElementType.ASSIGNMENT)
			assignments.add(root);
		for (Element e : root.getContents())
			collectAssignments(type, e, assignments);
	}

	protected void collectAssignmentsForFeature(EClass type, Element root, EStructuralFeature feat,
			List<Element> assignments) {
		if (root.getSemanticType() != null && !root.getSemanticType().isSuperTypeOf(type))
			return;
		if (root.getType() == ElementType.ASSIGNMENT
				&& ((Assignment) root.getEle()).getFeature().equals(feat.getName()))
			assignments.add(root);
		for (Element e : root.getContents())
			collectAssignmentsForFeature(type, e, feat, assignments);
	}

	protected Element createElement(Element parent, EObject e) {
		ElementType t = getElementType(e);
		if (t != null) {
			AbstractElement x = (AbstractElement) e;
			return new Element(t, parent, x, isMultipleCardinality(x), isOptionalCardinality(x));
		} else if (e instanceof RuleCall) {
			RuleCall rc = (RuleCall) e;
			AbstractElement x = rc.getRule().getAlternatives();
			t = getElementType(x);
			if (t != null)
				return new Element(t, parent, x, isMultipleCardinality(x) || isMultipleCardinality(rc),
						isOptionalCardinality(x) || isOptionalCardinality(rc));
		}
		return null;
	}

	protected List<Element> findRulesForType(final EClass cls) {
		List<ParserRule> rules = new ArrayList<ParserRule>();

		// collect all rules with matching return type
		for (ParserRule r : allParserRules(grammarAcc.getGrammar()))
			if (r.getType().getClassifier() instanceof EClass
					&& ((EClass) r.getType().getClassifier()).isSuperTypeOf(cls))
				rules.add(r);

		// remove rules which are called via unassigned rule call
		for (ParserRule r : new ArrayList<ParserRule>(rules)) {
			TreeIterator<EObject> i = r.eAllContents();
			while (i.hasNext()) {
				EObject o = i.next();
				if (o instanceof Assignment)
					i.prune();
				else if (o instanceof RuleCall)
					rules.remove(((RuleCall) o).getRule());
			}
		}

		// transform to elements
		List<Element> elements = new ArrayList<Element>();
		for (ParserRule r : rules) {
			Element e = createElement(null, r.getAlternatives());
			if (e != null)
				elements.add(e);
		}
		return elements;
	}

	protected int getActualCount(EObject obj, EStructuralFeature feat) {
		if (feat.isMany()) {
			int count = 0, max = ((List<?>) obj.eGet(feat)).size();
			if (transSrvc.isMixedList(obj, feat)) {
				for (int i = 0; i < max; i++)
					if (!transSrvc.isTransient(obj, feat, i))
						count++;
				return count;
			}
			return transSrvc.isTransient(obj, feat, 0) ? 0 : max;
		}
		return transSrvc.isTransient(obj, feat, 0) ? 0 : 1;
	}

	protected ElementType getElementType(EObject ele) {
		if (ele instanceof Group)
			return ElementType.GROUP;
		if (ele instanceof Alternatives)
			return ElementType.ALTERNATIVE;
		if (ele instanceof Assignment)
			return ElementType.ASSIGNMENT;
		if (ele instanceof Action)
			return ElementType.ACTION;
		return null;
	}

	protected EStructuralFeature getFeature(EClass cls, Element ele) {
		String name = ((Assignment) ele.getEle()).getFeature();
		EStructuralFeature f = cls.getEStructuralFeature(name);
		if (f == null)
			throw new RuntimeException("Feature " + name + " not found for " + cls.getName());
		return f;
	}

	protected int getMaxCount(EObject ctx, Element ass, Set<Element> involved) {
		int c = ass.isRoot() ? 1 : getRequiredMaxCountByParent(ctx, ass.getContainer(), ass, involved);
		return ass.isMultiple() && c > 0 ? MAX : c;
	}

	protected int getMinCount(EObject ctx, Element assignment, Set<Element> involved) {
		if (assignment.isOptional())
			return 0;
		if (assignment.isRoot())
			return 1;
		return getRequiredMinCountByParent(ctx, assignment.getContainer(), assignment, involved);
	}

	protected int getRequiredMaxCountByParent(EObject ctx, Element parent, Element exclude, Set<Element> involved) {
		switch (parent.getType()) {
			case GROUP:
				if (parent.isRoot() && !parent.isMultiple() && !parent.isOptional())
					return 1;
				int max = UNDEF;
				for (Element a : parent.getContents())
					if (a != exclude) {
						int count = getRequiredMaxCountForChild(ctx, a, involved);
						if (count != UNDEF && (count < max || max == UNDEF))
							max = count;
					}
				max = max == UNDEF ? parent.isMultiple() ? MAX : 1 : max;
				if (!parent.isRoot()) {
					int p = getRequiredMaxCountByParent(ctx, parent.getContainer(), parent, involved);
					max = p == 0 || max == 0 ? 0 : Math.max(max, p);
				}
				return max;
			case ALTERNATIVE:
				if (parent.isMultiple())
					return MAX;
				for (Element a : parent.getContents())
					if (a != exclude) {
						int count = getRequiredMinCountForChild(ctx, a, involved);
						if (count > 0)
							return 0;
					}
				if (!parent.isRoot())
					return getRequiredMaxCountByParent(ctx, parent.getContainer(), parent, involved);
				return 1;
			default:
				return 1;
		}
	}

	protected int getRequiredMaxCountForChild(EObject ctx, Element child, Set<Element> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx))
			return 0;
		if (child.isOptional())
			return MAX;
		switch (child.getType()) {
			case ASSIGNMENT:
				EStructuralFeature f = getFeature(ctx.eClass(), child);
				involved.add(child);
				return getActualCount(ctx, f);
			case GROUP:
				int count = UNDEF;
				for (Element a : child.getContents()) {
					int c = getRequiredMaxCountForChild(ctx, a, involved);
					if (c > count)
						count = c;
				}
				return count;
			default:
				return UNDEF;
		}
	}

	protected int getRequiredMinCountByParent(EObject ctx, Element parent, Element exclude, Set<Element> involved) {
		switch (parent.getType()) {
			case GROUP:
				if (parent.isRoot() && !parent.isOptional() && !parent.isMultiple())
					return 1;
				int count1 = UNDEF;
				for (Element a : parent.getContents())
					if (a != exclude) {
						int c = getRequiredMinCountForChild(ctx, a, involved);
						if (c > count1) {
							count1 = c;
							break;
						}
					}
				if (parent.isOptional())
					return count1;
				if (!parent.isRoot())
					return Math.max(getRequiredMinCountByParent(ctx, parent.getContainer(), parent, involved), count1);
				return UNDEF;
			case ALTERNATIVE:
				if (parent.isOptional())
					return 0;
				for (Element a : parent.getContents())
					if (a != exclude) {
						int count2 = getRequiredMinCountForChild(ctx, a, involved);
						if (count2 > 0)
							return 0;
					}
				if (!parent.isRoot())
					return getRequiredMinCountByParent(ctx, parent.getContainer(), parent, involved);
				return 1;
			default:
				return UNDEF;
		}
	}

	protected int getRequiredMinCountForChild(EObject ctx, Element child, Set<Element> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx))
			return 0;
		int count = UNDEF;
		switch (child.getType()) {
			case ASSIGNMENT:
				EStructuralFeature f = getFeature(ctx.eClass(), child);
				involved.add(child);
				count = getActualCount(ctx, f);
				break;
			case GROUP:
				for (Element a : child.getContents()) {
					int c = getRequiredMinCountForChild(ctx, a, involved);
					if (c > count)
						count = c;
				}
				break;
			case ALTERNATIVE:
				for (Element a : child.getContents()) {
					int c = getRequiredMinCountForChild(ctx, a, involved);
					count = count == UNDEF ? c : c + count;
				}
				break;
			case ACTION:
				if (child.getSemanticType().isInstance(ctx))
					return 1;
			default:
				count = UNDEF;
		}
		if (child.isMultiple() && count > 1)
			count = 1;
		return count;
	}

	protected boolean isOneCardinality(AbstractElement ele) {
		return ele.getCardinality() == null || "".equals(ele.getCardinality());
	}

	protected boolean isValidateableRule(Element rule) {
		return !ruleContainsAssignedAction(rule);
	}

	protected boolean ruleContainsAssignedAction(Element rule) {
		return Iterables.any(containedActions(rule.getEle()), new Predicate<Action>() {
			public boolean apply(Action arg0) {
				return arg0.getFeature() != null;
			}
		});
	}

	@Override
	public boolean validateRecursive(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		boolean r = true;
		r &= validateObject(obj, acceptor, context);
		TreeIterator<EObject> i = obj.eAllContents();
		while (i.hasNext())
			r &= validateObject(i.next(), acceptor, context);
		return r;
	}

	@Override
	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Iterable<Element> rules = findRulesForType(obj.eClass());
		for (Element rule : rules)
			if (!isValidateableRule(rule))
				return true;// validation is not supported if there is a not-validatable rule
		for (Element rule : rules) {
			List<IConcreteSyntaxDiagnostic> diags = validate(obj, rule);
			if (diags.size() == 0)
				return true; // validation succeeded
			allDiags.addAll(diags);
		}
		for (IConcreteSyntaxDiagnostic d : allDiags)
			acceptor.accept(d);
		return false;
	}

	protected List<IConcreteSyntaxDiagnostic> validate(EObject obj, Element rule) {
		List<IConcreteSyntaxDiagnostic> diag = new ArrayList<IConcreteSyntaxDiagnostic>();
		Set<Element> checkedAssignments = new HashSet<Element>();
		for (EStructuralFeature f : obj.eClass().getEAllStructuralFeatures()) {
			int min = UNDEF, max = 0;
			Set<Element> involved = new HashSet<Element>();
			List<Element> assignments = new ArrayList<Element>();
			collectAssignmentsForFeature(obj.eClass(), rule, f, assignments);
			checkedAssignments.addAll(assignments);
			for (Element a : assignments) {
				involved.add(a);
				int mi = getMinCount(obj, a, involved);
				if (mi != UNDEF)
					min = min == UNDEF ? mi : mi + min;
				int ma = getMaxCount(obj, a, involved);
				if (ma != UNDEF)
					max = ma == MAX ? ma : max + ma;
			}
			int actual = getActualCount(obj, f);
			if (actual < min || (actual > max))
				diag.add(new ConcreteSyntaxFeatureDiagnostic(rule, obj, f, actual, min, max, involved));
		}
		List<Element> requiredAssignments = new ArrayList<Element>();
		collectAssignments(obj.eClass(), rule, requiredAssignments);
		requiredAssignments.removeAll(checkedAssignments);
		for (Element a : requiredAssignments) {
			Set<Element> involved = new HashSet<Element>();
			int min = getMinCount(obj, a, involved);
			if (min > 0)
				diag.add(new ConcreteSyntaxFeatureMissingDiagnostic(rule, obj, a, involved));
		}
		Set<Element> expectedTypes = collectUnfulfilledSemanticElements(obj.eClass(), rule);
		if (expectedTypes.size() > 0)
			diag.add(new ConcreteSyntaxObjectDiagnostic(rule, obj, expectedTypes));
		return diag;
	}

	protected Set<Element> collectUnfulfilledSemanticElements(EClass cls, Element ele) {
		if (ele.isOptional())
			return Collections.emptySet();
		if (ele.getSemanticType() != null && !ele.getSemanticType().isSuperTypeOf(cls))
			return Collections.singleton(ele);
		switch (ele.getType()) {
			case GROUP:
				Set<Element> l1 = new HashSet<Element>();
				for (Element e : ele.getContents())
					l1.addAll(collectUnfulfilledSemanticElements(cls, e));
				return l1;
			case ALTERNATIVE:
				Set<Element> l2 = new HashSet<Element>();
				for (Element e : ele.getContents()) {
					Set<Element> r = collectUnfulfilledSemanticElements(cls, e);
					if (r.size() == 0)
						return Collections.emptySet();
					else
						l2.addAll(r);
				}
				return l2;
			default:
				return Collections.emptySet();
		}

	}

}
