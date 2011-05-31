/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.serializer.analysis.Context2NameFunction;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.base.Function;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarElementTitleSwitch extends XtextSwitch<String> implements Function<AbstractElement, String> {

	protected boolean showActionAsRuleCall = false;

	protected boolean showAssignment = false;

	protected boolean showCardinality = true;

	protected String addAssignemnt(String result, AbstractElement ele) {
		if (!showAssignment)
			return result;
		Assignment ass = GrammarUtil.containingAssignment(ele);
		return ass != null ? ass.getFeature() + ass.getOperator() + result : result;
	}

	protected String addCrossRef(String result, AbstractElement ele) {
		if (!showAssignment)
			return result;
		CrossReference cr = GrammarUtil.containingCrossReference(ele);
		return cr != null ? "[" + cr.getType().getClassifier().getName() + "|" + result + "]" : result;
	}

	protected String addCrossRefOrAssignemnt(String result, AbstractElement ele) {
		if (!showAssignment)
			return result;
		return addAssignemnt(addCrossRef(result, ele), ele);
	}

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
		if (showActionAsRuleCall && f != null) {
			return f + o + new Context2NameFunction().apply(object) + card(object);
		} else {
			String t = object.getType().getClassifier().getName();
			t = (t == null) ? "" : t;
			f = (f == null) ? "" : "." + f;
			return "{" + t + f + o + "}" + card(object);
		}
	}

	@Override
	public String caseAlternatives(Alternatives object) {
		return "\\|" + card(object);
	}

	@Override
	public String caseAssignment(Assignment object) {
		return object.getFeature() + object.getOperator() + " " + card(object);
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

	@Override
	public String defaultCase(EObject object) {
		return object.eClass().getName();
	}

	public GrammarElementTitleSwitch hideCardinality() {
		showCardinality = false;
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

}
