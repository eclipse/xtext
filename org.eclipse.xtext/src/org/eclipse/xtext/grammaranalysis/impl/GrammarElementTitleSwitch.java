/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarElementTitleSwitch extends XtextSwitch<String> implements Function<AbstractElement, String> {

	protected static class Node {
		protected List<Node> children = Lists.newArrayList();
		protected CompoundElement compound;
		protected String text;

		public Node(CompoundElement compound, String text) {
			super();
			this.compound = compound;
			this.text = text;
		}

		@Override
		public String toString() {
			if (text != null)
				return text;
			if (children.size() == 1)
				return children.get(0).toString();
			if (compound instanceof Group)
				return "(" + Joiner.on(" ").join(children) + ")";
			if (compound instanceof UnorderedGroup)
				return "(" + Joiner.on("&").join(children) + ")";
			if (compound instanceof Alternatives)
				return "(" + Joiner.on("|").join(children) + ")";
			return "";
		}
	}

	protected boolean showActionAsRuleCall = false;

	protected boolean showAssignment = false;

	protected boolean showCardinality = true;

	protected boolean showQualified = false;

	protected boolean showRule = false;

	protected String valueForNull = "(null)";

	protected String addAssignemnt(String result, AbstractElement ele) {
		if (!showAssignment)
			return result;
		Assignment ass = GrammarUtil.containingAssignment(ele);
		result = ass != null ? ass.getFeature() + ass.getOperator() + result : result;
		return addQualified(result, ele);
	}

	protected String addCrossRef(String result, AbstractElement ele) {
		if (!showAssignment)
			return result;
		CrossReference cr = GrammarUtil.containingCrossReference(ele);
		if (cr == null)
			return result;
		String name = cr.getType() != null && cr.getType().getClassifier() != null ? cr.getType().getClassifier()
				.getName() : "null";
		return "[" + name + "|" + result + "]";
	}

	protected String addCrossRefOrAssignemnt(String result, AbstractElement ele) {
		return addAssignemnt(addCrossRef(result, ele), ele);
	}

	protected String addQualified(String result, AbstractElement ele) {
		if (!showQualified && !showRule)
			return result;
		AbstractRule rule = GrammarUtil.containingRule(ele);
		if (!showQualified)
			return result + ":" + rule.getName();
		GrammarElementTitleSwitch others = copy();
		others.showQualified = false;
		others.showRule = false;
		List<AbstractElement> elementsWithSameName = Lists.newArrayList();
		for (AbstractElement candidate : EcoreUtil2.getAllContentsOfType(rule, ele.getClass()))
			if (candidate == ele || result.equals(others.doSwitch(candidate)))
				elementsWithSameName.add(candidate);
		if (elementsWithSameName.size() < 2) {
			if (showRule)
				return rule.getName() + ":" + result;
			return result;
		}
		Map<CompoundElement, Node> nodes = Maps.newHashMap();
		for (AbstractElement collision : elementsWithSameName) {
			EObject current = EcoreUtil2.getContainerOfType(collision, CompoundElement.class);
			Node node = new Node(null, collision == ele ? result : "");
			while (current instanceof CompoundElement) {
				CompoundElement container = (CompoundElement) current;
				Node cntNode = nodes.get(container);
				if (cntNode == null)
					nodes.put(container, cntNode = new Node(container, null));
				if (!cntNode.children.contains(node))
					cntNode.children.add(node);
				node = cntNode;
				current = current.eContainer();
			}
		}
		if (showRule)
			return rule.getName() + ":" + nodes.get(rule.getAlternatives());
		return nodes.get(rule.getAlternatives()).toString();
	}

	@Override
	public String apply(AbstractElement from) {
		return doSwitch(from);
	}

	protected String card(AbstractElement ele) {
		if (!showCardinality)
			return "";
		return ele.getCardinality() == null ? "" : ele.getCardinality();
	}

	@Override
	public String caseAbstractElement(AbstractElement object) {
		return object.eClass().getName() + card(object);
	}

	@Override
	public String caseAbstractRule(AbstractRule object) {
		String classifier = object.getType().getClassifier().getName();
		if (object.getName().equals(classifier))
			return object.getName() + ":";
		return object.getName() + " returns " + classifier + ":";
	}

	@Override
	public String caseAction(Action object) {
		String f = object.getFeature();
		String o = object.getOperator();
		o = (o == null) ? "" : o;
		String result;
		if (showActionAsRuleCall && f != null) {
			result = f + o + new Context2NameFunction().toFunction(null).apply(object) + card(object);
		} else {
			String t = object.getType() != null && object.getType().getClassifier() != null ? object.getType()
					.getClassifier().getName() : "null";
			t = (t == null) ? "" : t;
			f = (f == null) ? "" : "." + f;
			result = "{" + t + f + o + "}" + card(object);
		}
		return addQualified(result, object);
	}

	@Override
	public String caseAlternatives(Alternatives object) {
		return "\\|" + card(object);
	}

	@Override
	public String caseAssignment(Assignment object) {
		String result = object.getFeature() + object.getOperator() + " " + card(object);
		return addQualified(result, object);
	}

	@Override
	public String caseCrossReference(CrossReference object) {
		String cr = "[" + object.getType().getClassifier().getName() + "]";
		return addAssignemnt(cr, object) + card(object);
	}

	@Override
	public String caseGroup(Group object) {
		return "( )" + card(object);
	}

	@Override
	public String caseKeyword(Keyword object) {
		return addCrossRefOrAssignemnt("'" + object.getValue() + "'", object) + card(object);
	}

	@Override
	public String caseRuleCall(RuleCall object) {
		return addCrossRefOrAssignemnt(object.getRule().getName(), object) + card(object);
	}

	@Override
	public String caseUnorderedGroup(UnorderedGroup object) {
		return "\\&" + card(object);
	}

	protected GrammarElementTitleSwitch copy() {
		GrammarElementTitleSwitch result = new GrammarElementTitleSwitch();
		result.showActionAsRuleCall = showActionAsRuleCall;
		result.showAssignment = showAssignment;
		result.showCardinality = showCardinality;
		result.showQualified = showQualified;
		result.showRule = showRule;
		return result;
	}

	@Override
	public String defaultCase(EObject object) {
		return object.eClass().getName();
	}

	@Override
	public String doSwitch(EObject theEObject) {
		if (theEObject == null)
			return valueForNull;
		return super.doSwitch(theEObject);
	}

	public GrammarElementTitleSwitch hideCardinality() {
		showCardinality = false;
		return this;
	}

	public GrammarElementTitleSwitch setValueForNull(String value) {
		valueForNull = value;
		return this;
	}

	public GrammarElementTitleSwitch showActionsAsRuleCalls() {
		showActionAsRuleCall = true;
		return this;
	}

	public GrammarElementTitleSwitch showAssignments() {
		showAssignment = true;
		return this;
	}

	public GrammarElementTitleSwitch showQualified() {
		showQualified = true;
		return this;
	}

	public GrammarElementTitleSwitch showRule() {
		showRule = true;
		return this;
	}

}
