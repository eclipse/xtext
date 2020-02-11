/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Set;

import org.eclipse.xtext.Condition;
import org.eclipse.xtext.Conjunction;
import org.eclipse.xtext.Disjunction;
import org.eclipse.xtext.LiteralCondition;
import org.eclipse.xtext.Negation;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParameterReference;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ConditionEvaluator extends XtextSwitch<Boolean> {
	
	private final Set<Parameter> paramValues;

	public ConditionEvaluator(Set<Parameter> paramValues) {
		this.paramValues = paramValues;
	}
	
	public boolean evaluate(Condition condition) {
		return doSwitch(condition);
	}
	
	@Override
	public Boolean caseDisjunction(Disjunction object) {
		return doSwitch(object.getLeft()) || doSwitch(object.getRight());
	}

	@Override
	public Boolean caseConjunction(Conjunction object) {
		return doSwitch(object.getLeft()) && doSwitch(object.getRight());
	}

	@Override
	public Boolean caseNegation(Negation object) {
		return !doSwitch(object.getValue());
	}

	@Override
	public Boolean caseParameterReference(ParameterReference object) {
		return paramValues.contains(object.getParameter());
	}

	@Override
	public Boolean caseLiteralCondition(LiteralCondition object) {
		return object.isTrue();
	}
}
