/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.grammaranalysis.impl;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarElementFullTitleSwitch extends GrammarElementTitleSwitch {

	protected String addCrossRef(String result, AbstractElement ele) {
		CrossReference cr = GrammarUtil.containingCrossReference(ele);
		return cr != null ? "[" + cr.getType().getClassifier().getName() + "|" + result + "]" : result;
	}

	protected String addCrossRefOrAssignemnt(String result, AbstractElement ele) {
		return addAssignemnt(addCrossRef(result, ele), ele);
	}

	protected String addAssignemnt(String result, AbstractElement ele) {
		Assignment ass = GrammarUtil.containingAssignment(ele);
		return ass != null ? ass.getFeature() + ass.getOperator() + result : result;
	}

	@Override
	public String caseCrossReference(CrossReference object) {
		String cr = "[" + object.getType().getClassifier().getName() + "]";
		return addAssignemnt(cr, object) + card(object);
	}

	@Override
	public String caseKeyword(Keyword object) {
		return addCrossRefOrAssignemnt("'" + object.getValue() + "'", object) + card(object);
	}

	@Override
	public String caseRuleCall(RuleCall object) {
		return addCrossRefOrAssignemnt(object.getRule().getName(), object) + card(object);
	}

}
