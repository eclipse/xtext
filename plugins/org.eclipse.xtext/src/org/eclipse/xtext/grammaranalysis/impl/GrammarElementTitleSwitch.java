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
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarElementTitleSwitch extends XtextSwitch<String> {

	private String card(AbstractElement ele) {
		return ele.getCardinality() == null ? "" : ele.getCardinality();
	}

	@Override
	public String caseAbstractElement(AbstractElement object) {
		return object.eClass().getName() + card(object);
	}

	@Override
	public String caseAction(Action object) {
		String o = object.getOperator();
		String t = object.getType().getClassifier().getName();
		String f = object.getFeature();
		o = (o == null) ? "" : o;
		t = (t == null) ? "" : t;
		f = (f == null) ? "" : "." + f;
		return "{" + t + f + o + "}" + card(object);
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
		return "[" + object.getType().getClassifier().getName() + "]" + card(object);
	}

	@Override
	public String caseGroup(Group object) {
		return "( )" + card(object);
	}

	@Override
	public String caseKeyword(Keyword object) {
		return "\"" + object.getValue() + "\"" + card(object);
	}

	@Override
	public String caseRuleCall(RuleCall object) {
		return "=>" + object.getRule().getName() + card(object);
	}

	@Override
	public String caseUnorderedGroup(UnorderedGroup object) {
		return "\\&" + card(object);
	}

	@Override
	public String defaultCase(EObject object) {
		return object.eClass().getName();
	}

}
