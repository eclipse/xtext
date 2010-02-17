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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parsetree.reconstr.ITransientValueService;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.OnChangeEvictingCacheAdapter;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.internal.Lists;

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

		protected void appendConstraint(StringBuffer msg) {
			if (involved.size() > 1) {
				msg.append(" Constraint: ");
				msg.append(getConstraint());
				msg.append(" Quantities: ");
				msg.append(getValue());
			}
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
				root = root.getCommonContainer(i.next());
			return root;
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

	public class ConcreteSyntaxAssignmentMissingDiagnostic extends AbstractConcreteSyntaxDiagnostic {
		protected EStructuralFeature feature;

		public ConcreteSyntaxAssignmentMissingDiagnostic(Element rule, EObject source, EStructuralFeature feature,
				Set<Element> involved) {
			super(rule, source, involved);
			this.feature = feature;
		}

		public int getCode() {
			return ERROR_ASSIGNMENT_MISSING;
		}

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
			msg.append(" contains non-transient values but has no corresponding assignment in rule ");
			msg.append(getRule().getName());
			msg.append(".");
			appendConstraint(msg);
			return msg.toString();
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
			msg.append(" min:" + min);
			msg.append(" max:" + max);
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
			msg.append(" is needed for serialization with rule ");
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

	protected static class DependencyComparator implements Comparator<Element> {
		public int compare(Element o1, Element o2) {
			boolean d1 = o1.dependsOn(o2);
			boolean d2 = o2.dependsOn(o1);
			return d1 != d2 ? d1 ? 1 : -1 : 0;
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

		public boolean dependsOn(Element ele) {
			Element cnt = getCommonContainer(ele);
			while (ele != cnt) {
				if (ele.isOptional())
					return false;
				ele = ele.getContainer();
			}
			return true;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Element)
				return ((Element) obj).element == element;
			return false;
		}

		public Element getCommonContainer(Element obj1) {
			Element cnt1 = obj1;
			while (cnt1 != null) {
				Element cnt2 = this;
				while (cnt2 != null) {
					if (cnt1.equals(cnt2))
						return cnt1;
					cnt2 = cnt2.getContainer();
				}
				cnt1 = cnt1.getContainer();
			}
			return null;
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

		public ElementType getType() {
			return type;
		}

		@Override
		public int hashCode() {
			return element.hashCode();
		}

		public boolean isAbsolutMandatory() {
			return !optional && type != ElementType.ALTERNATIVE
					&& (container == null || container.isAbsolutMandatory());
		}

		public boolean isMultiple() {
			return multiple;
		}

		public boolean isMultipleRecursive() {
			return multiple || (container != null && container.isMultipleRecursive());
		}

		public boolean isOptional() {
			return optional;
		}

		public boolean isOptionalRecursive() {
			return optional || (container != null && container.isOptionalRecursive());
		}

		public boolean isRoot() {
			return container == null;
		}

		@Override
		public String toString() {
			return toString(null);
		}

		public String toString(final Map<Element, String> postfix) {
			String c = element.getCardinality() == null ? "" : element.getCardinality();
			String t = getSemanticType() == null ? "" : getSemanticType().getName() + ":";
			String p = postfix != null && postfix.containsKey(this) ? postfix.get(this) : "";
			Iterable<String> contents = Iterables.transform(getContents(), new Function<Element, String>() {
				public String apply(Element from) {
					return from.toString(postfix);
				}
			});
			switch (getType()) {
				case ASSIGNMENT:
					return t + ((Assignment) element).getFeature() + p + c;
				case GROUP:
					return t + "(" + Join.join(" ", contents) + ")" + p + c;
				case ALTERNATIVE:
					return t + "(" + Join.join("|", contents) + ")" + p + c;
				case ACTION:
					return "{" + ((Action) element).getType().getClassifier().getName() + "}" + p;
			}
			return "";
		}

	}

	protected class ElementCache {
		private Grammar grammar;
		private Map<ParserRule, Element> rule2element = Maps.newHashMap();
		private Map<EClass, List<Element>> type2Elements = Maps.newHashMap();
		private Set<ParserRule> validRules;

		public ElementCache(Grammar grammar) {
			super();
			this.grammar = grammar;
		}

		protected Element getElement(ParserRule rule) {
			Element e = rule2element.get(rule);
			if (e == null)
				rule2element.put(rule, e = createElement(null, rule.getAlternatives()));
			return e;
		}

		public Collection<Element> getRulesFor(EClass cls) {
			List<Element> eles = type2Elements.get(cls);
			if (eles != null)
				return eles;
			eles = Lists.newArrayList();
			for (ParserRule r : getValidRules()) {
				if (((EClass) r.getType().getClassifier()).isSuperTypeOf(cls)) {
					Element e = getElement(r);
					if (e != null)
						eles.add(e);
				}
			}
			for (Element e : eles)
				if (!isValidateableRule(GrammarUtil.containingParserRule(e.getEle()))) {
					eles.clear();
					break;
				}
			type2Elements.put(cls, eles);
			return eles;
		}

		protected Set<ParserRule> getValidRules() {
			if (validRules != null)
				return validRules;
			validRules = Sets.newHashSet();
			collectReachableRules(getFirstParserRule(grammar), validRules);
			return validRules;
		}
	}

	protected enum ElementType {
		ACTION, ALTERNATIVE, ASSIGNMENT, GROUP
	}

	protected class Quantities {
		private EObject delegate;
		private Map<Element, Integer> quantities = Maps.newHashMap();

		public Quantities(EObject delegate) {
			super();
			this.delegate = delegate;
		}

		public EObject getDelegate() {
			return delegate;
		}

		public Integer getQuantity(Element assignement) {
			Integer i = quantities.get(assignement);
			return i == null || i < 0 ? -1 : i;
		}

		public Map<EStructuralFeature, Collection<Element>> groupByFeature() {
			Multimap<EStructuralFeature, Element> map = Multimaps.newHashMultimap();
			for (Element e : quantities.keySet())
				map.put(delegate.eClass().getEStructuralFeature(((Assignment) e.getEle()).getFeature()), e);
			return map.asMap();
		}

		public Integer setQuantity(Element assignement, int quantity) {
			return quantities.put(assignement, quantity);
		}

		@Override
		public String toString() {
			return toString(null);
		}

		public String toString(Map<Element, Pair<Integer, Integer>> minmax) {
			Map<Element, String> postfix = Maps.newHashMap();
			for (Map.Entry<Element, Integer> e : quantities.entrySet()) {
				String s = ":" + e.getValue();
				if (minmax != null && minmax.containsKey(e.getKey())) {
					Pair<Integer, Integer> p = minmax.get(e.getKey());
					s += "<" + p.getFirst() + "," + (p.getSecond() == Integer.MAX_VALUE ? "*" : p.getSecond()) + ">";
				}
				postfix.put(e.getKey(), s);
			}
			Iterator<Element> i = quantities.keySet().iterator();
			if (!i.hasNext())
				return "";
			Element root = i.next();
			while (i.hasNext())
				root = root.getCommonContainer(i.next());
			return root.toString(postfix);
		}
	}

	protected static class QuantityComparator extends DependencyComparator {
		private Quantities quantities;

		public QuantityComparator(Quantities quantities) {
			super();
			this.quantities = quantities;
		}

		@Override
		public int compare(Element o1, Element o2) {
			int r = quantities.getQuantity(o2).compareTo(quantities.getQuantity(o1));
			return r == 0 ? super.compare(o1, o2) : r;
		}
	}

	public static final int ERROR_ASSIGNMENT_MISSING = 7;

	public static final int ERROR_FEATURE_MISSING = 6;

	public static final int ERROR_LIST_TOO_FEW = 4;

	public static final int ERROR_LIST_TOO_MANY = 5;

	public static final int ERROR_LIST_UNDECIDEABLE = 3;

	public static final int ERROR_VALUE_PROHIBITED = 2;

	public static final int ERROR_VALUE_REQUIRED = 1;

	public static final int ERROR_WRONG_TYPE = 7;

	public static int MAX = Integer.MAX_VALUE;

	public static int UNDEF = -1;

	@Inject
	protected IGrammarAccess grammarAcc;

	@Inject
	protected ITransientValueService transSrvc;

	protected void collectAssignments(Element rule, EObject obj, Element ele,
			Multimap<EStructuralFeature, Element> assignments, List<IConcreteSyntaxDiagnostic> acceptor) {
		if (ele.getSemanticType() != null && !ele.getSemanticType().isSuperTypeOf(obj.eClass()))
			return;
		if (ele.getType() == ElementType.ASSIGNMENT) {
			EStructuralFeature f = obj.eClass().getEStructuralFeature(((Assignment) ele.getEle()).getFeature());
			if (f == null)
				acceptor.add(new ConcreteSyntaxFeatureMissingDiagnostic(rule, obj, ele, Collections
						.<Element> emptySet()));
			else
				assignments.put(f, ele);
		}
		for (Element e : ele.getContents())
			collectAssignments(rule, obj, e, assignments, acceptor);
	}

	protected void collectReachableRules(ParserRule pr, Set<ParserRule> rules) {
		for (Assignment a : GrammarUtil.containedAssignments(pr))
			for (RuleCall rc : GrammarUtil.containedRuleCalls(a))
				if (isParserRule(rc.getRule()) && rules.add((ParserRule) rc.getRule()))
					collectReachableRules((ParserRule) rc.getRule(), rules);
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

	protected int distributeQuantity(List<Element> assignments, Quantities quants,
			Map<Element, Pair<Integer, Integer>> minmax, int quantity) {
		for (Element ass : assignments) {
			int min = Math.max(Math.min(minmax.get(ass).getFirst(), minmax.get(ass).getSecond()), 0);
			int q = quants.getQuantity(ass);
			if (q < 0)
				q = 0;
			int toAdd = min - q;
			if (toAdd > 0) {
				if (min <= quantity) {
					quants.setQuantity(ass, min);
					quantity -= min;
				} else {
					quants.setQuantity(ass, quantity);
					quantity = 0;
				}
			} else
				quants.setQuantity(ass, q);
		}
		for (Element ass : assignments) {
			if (quantity == 0)
				break;
			int max = minmax.get(ass).getSecond();
			int q = quants.getQuantity(ass);
			if (q < max) {
				int nv = Math.min(max, quantity + q);
				quants.setQuantity(ass, nv);
				quantity -= nv - q;
			}
		}
		return quantity;
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

	protected ElementCache getElementCache() {
		String key = ElementCache.class.getName();
		Grammar grammar = grammarAcc.getGrammar();
		OnChangeEvictingCacheAdapter a = OnChangeEvictingCacheAdapter.getOrCreate(grammar);
		ElementCache ec = a.get(key);
		if (ec == null)
			a.set(key, ec = new ElementCache(grammar));
		return ec;
	}

	protected ElementType getElementType(EObject ele) {
		if (ele instanceof Group || ele instanceof UnorderedGroup)
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

	protected ParserRule getFirstParserRule(Grammar grammar) {
		for (AbstractRule r : grammar.getRules())
			if (isParserRule(r))
				return (ParserRule) r;
		throw new RuntimeException("Grammar " + grammar.getName() + " contains no parser rules");
	}

	protected int getHardMax(Element e) {
		return e.isMultiple() ? MAX : e.isRoot() ? 1 : getHardMax(e.getContainer());
	}

	protected int getHardMin(Element e) {
		return e.isOptional() || e.getType() == ElementType.ALTERNATIVE ? 0 : e.isRoot() ? 1 : getHardMin(e
				.getContainer());
	}

	protected int getMaxCount(Quantities ctx, Element ass, Set<Element> involved) {
		int c = ass.isRoot() ? 1 : getRequiredMaxCountByParent(ctx, ass.getContainer(), ass, involved);
		if (c == 0 && ass.isAbsolutMandatory())
			c = 1;
		return ass.isMultiple() && c > 0 ? MAX : c;
	}

	protected int getMinCount(Quantities ctx, Element assignment, Set<Element> involved) {
		if (assignment.isOptional())
			return 0;
		if (assignment.isRoot())
			return 1;
		return getRequiredMinCountByParent(ctx, assignment.getContainer(), assignment, involved);
	}

	protected List<Quantities> getQuantities(EObject obj, Element rule, List<IConcreteSyntaxDiagnostic> acceptor) {
		Multimap<EStructuralFeature, Element> assignments = Multimaps.newHashMultimap();
		collectAssignments(rule, obj, rule, assignments, acceptor);
		Map<EStructuralFeature, Integer> quantities = Maps.newHashMap();
		for (EStructuralFeature f : obj.eClass().getEAllStructuralFeatures()) {
			int quantity = getActualCount(obj, f);
			if (quantity > 0 && !assignments.containsKey(f))
				acceptor.add(new ConcreteSyntaxAssignmentMissingDiagnostic(rule, obj, f, Collections
						.<Element> emptySet()));
			else
				quantities.put(f, quantity);
		}
		Quantities quants = new Quantities(obj);
		Multimap<EStructuralFeature, Element> multiAssignments = Multimaps.newHashMultimap();
		for (Map.Entry<EStructuralFeature, Integer> f : quantities.entrySet()) {
			Collection<Element> ass = assignments.get(f.getKey());
			if (ass.size() == 1 || f.getValue() == 0)
				for (Element a : ass)
					quants.setQuantity(a, f.getValue());
			else
				multiAssignments.putAll(f.getKey(), ass);

		}
		if (multiAssignments.isEmpty())
			return Collections.singletonList(quants);
		Map<Element, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Element e : multiAssignments.values()) {
			int min = getMinCount(quants, e, Sets.<Element> newHashSet());
			int max = getMaxCount(quants, e, Sets.<Element> newHashSet());
			minmax.put(e, Tuples.create(min, max));
		}
		for (Map.Entry<EStructuralFeature, Collection<Element>> e : multiAssignments.asMap().entrySet()) {
			List<Element> ass = new ArrayList<Element>(e.getValue());
			Collections.sort(ass, new DependencyComparator());
			int quantity = quantities.get(e.getKey());
			quantity = distributeQuantity(ass, quants, minmax, quantity);
			if (quantity > 0) {
				//				System.out.println("Quantities: " + quants.toString(minmax));
				for (Element x : ass)
					minmax.put(x, Tuples.create(getHardMin(x), getHardMax(x)));
				Collections.sort(ass, new QuantityComparator(quants));
				quantity = distributeQuantity(ass, quants, minmax, quantity);
				if (quantity > 0)
					quants.setQuantity(ass.get(0), quants.getQuantity(ass.get(0)) + quantity);
			}
		}
		//		System.out.println("FinalQuantities: " + quants.toString(minmax));
		return Collections.singletonList(quants);
	}

	protected int getRequiredMaxCountByParent(Quantities ctx, Element parent, Element exclude, Set<Element> involved) {
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

	protected int getRequiredMaxCountForChild(Quantities ctx, Element child, Set<Element> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx))
			return 0;
		if (child.isOptional())
			return MAX;
		switch (child.getType()) {
			case ASSIGNMENT:
				involved.add(child);
				return ctx.getQuantity(child);
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

	protected int getRequiredMinCountByParent(Quantities ctx, Element parent, Element exclude, Set<Element> involved) {
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
					return count1 == UNDEF ? 0 : count1;
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

	protected int getRequiredMinCountForChild(Quantities ctx, Element child, Set<Element> involved) {
		if (child.getSemanticType() != null && !child.getSemanticType().isInstance(ctx))
			return 0;
		int count = UNDEF;
		switch (child.getType()) {
			case ASSIGNMENT:
				involved.add(child);
				count = ctx.getQuantity(child);
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

	protected boolean isParserRule(AbstractRule rule) {
		return rule instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) rule);
	}

	protected boolean isValidateableRule(ParserRule rule) {
		return !ruleContainsAssignedAction(rule)
				&& !ruleContainsRecursiveUnassignedRuleCall(rule, new HashSet<AbstractRule>());
	}

	protected boolean ruleContainsAssignedAction(AbstractRule rule) {
		return Iterables.any(containedActions(rule), new Predicate<Action>() {
			public boolean apply(Action action) {
				return action.getFeature() != null;
			}
		});
	}

	protected boolean ruleContainsRecursiveUnassignedRuleCall(AbstractRule rule, Set<AbstractRule> visited) {
		if (!visited.add(rule))
			return true;
		TreeIterator<EObject> i = rule.eAllContents();
		while (i.hasNext()) {
			EObject o = i.next();
			if (o instanceof Assignment)
				i.prune();
			else if (o instanceof RuleCall && isParserRule(((RuleCall) o).getRule())) {
				if (ruleContainsRecursiveUnassignedRuleCall(((RuleCall) o).getRule(), visited))
					return true;
			}
		}
		return false;
	}

	@Override
	public boolean validateObject(EObject obj, IDiagnosticAcceptor acceptor, Map<Object, Object> context) {
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Collection<Element> rules = getElementCache().getRulesFor(obj.eClass());
		if (rules.isEmpty())
			return true;// no validation if there are no rules for this EClass
		for (Element rule : rules) {
			List<IConcreteSyntaxDiagnostic> diags = validateRule(obj, rule);
			if (diags.size() == 0)
				return true; // validation succeeded
			allDiags.addAll(diags);
		}
		for (IConcreteSyntaxDiagnostic d : allDiags)
			acceptor.accept(d);
		return false;
	}

	protected List<IConcreteSyntaxDiagnostic> validateQuantities(Quantities obj, Element rule) {
		List<IConcreteSyntaxDiagnostic> diag = new ArrayList<IConcreteSyntaxDiagnostic>();
		Map<Element, Pair<Integer, Integer>> minmax = Maps.newHashMap();
		for (Map.Entry<EStructuralFeature, Collection<Element>> e : obj.groupByFeature().entrySet()) {
			int min = UNDEF, max = 0;
			Set<Element> involved = new HashSet<Element>();
			for (Element a : e.getValue()) {
				involved.add(a);
				int mi = getMinCount(obj, a, involved);
				if (mi != UNDEF)
					min = min == UNDEF ? mi : mi + min;
				int ma = getMaxCount(obj, a, involved);
				if (ma != UNDEF && max != MAX)
					max = ma == MAX ? ma : max + ma;
				minmax.put(a, Tuples.create(mi, ma));
			}
			int actual = getActualCount(obj.getDelegate(), e.getKey());
			if (actual < min || (actual > max))
				diag.add(new ConcreteSyntaxFeatureDiagnostic(rule, obj.getDelegate(), e.getKey(), actual, min, max,
						involved));
		}
		//		System.out.println("Validation: " + obj.toString(minmax));
		return diag;
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

	protected List<IConcreteSyntaxDiagnostic> validateRule(EObject obj, Element rule) {
		List<IConcreteSyntaxDiagnostic> allDiags = new ArrayList<IConcreteSyntaxDiagnostic>();
		Set<Element> expectedTypes = collectUnfulfilledSemanticElements(obj.eClass(), rule);
		if (expectedTypes.size() > 0)
			allDiags.add(new ConcreteSyntaxObjectDiagnostic(rule, obj, expectedTypes));
		List<Quantities> quantities = getQuantities(obj, rule, allDiags);
		if (!allDiags.isEmpty())
			return allDiags;
		for (Quantities q : quantities) {
			List<IConcreteSyntaxDiagnostic> diags = validateQuantities(q, rule);
			if (diags.isEmpty())
				return diags;
			allDiags.addAll(diags);
		}
		return allDiags;
	}

}
