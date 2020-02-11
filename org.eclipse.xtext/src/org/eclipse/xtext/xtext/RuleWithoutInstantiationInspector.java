/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Checks if a parser rule ensures object instantiation. A rule that can be consumed
 * without instantiating an object or providing an object that was instantiated by 
 * another unassigned called rule, is considered to be invalid as it leads to surprises 
 * when clients traverse the model.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class RuleWithoutInstantiationInspector extends XtextRuleInspector<Boolean, ParserRule> {

	public static final String ISSUE_CODE = "RuleWithoutInstantiationInspector.noInstantiation";
	
	public RuleWithoutInstantiationInspector(ValidationMessageAcceptor acceptor) {
		super(acceptor);
	}
	
	@Override
	protected String getIssueCode() {
		return ISSUE_CODE;
	}
	
	@Override
	protected boolean canInspect(ParserRule rule) {
		// special treatment of first rule
		if (GrammarUtil.getGrammar(rule).getRules().get(0) == rule)
			return false;
		if (GrammarUtil.isDatatypeRule(rule) || rule.getAlternatives() == null || rule.isFragment())
			return false;
		return super.canInspect(rule);
	}
	
	@Override
	protected void handleResult(Boolean r, ParserRule rule) {
		if (!r.booleanValue())
			acceptWarning(
					"The rule '" + rule.getName() + "' may be consumed without object instantiation. " +
					"Add an action to ensure object creation, e.g. '{" + getTypeRefName(rule.getType()) + "}'." , 
					rule, 
					XtextPackage.Literals.ABSTRACT_RULE__NAME);
	}

	@Override
	public Boolean caseCompoundElement(CompoundElement object) {
		if (GrammarUtil.isOptionalCardinality(object))
			return Boolean.FALSE;
		for(AbstractElement element: object.getElements()) {
			if (doSwitch(element))
				return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseAbstractElement(AbstractElement object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseAction(Action object) {
		if (GrammarUtil.isOptionalCardinality(object))
			return Boolean.FALSE;
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseAlternatives(Alternatives object) {
		if (GrammarUtil.isOptionalCardinality(object))
			return Boolean.FALSE;
		for(AbstractElement element: object.getElements()) {
			if (!doSwitch(element))
				return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseAssignment(Assignment object) {
		if (GrammarUtil.isOptionalCardinality(object))
			return Boolean.FALSE;
		return Boolean.TRUE;
	}
	
	@Override
	public Boolean caseRuleCall(RuleCall object) {
		if (GrammarUtil.isOptionalCardinality(object))
			return Boolean.FALSE;
		return object.getRule() == null || (object.getRule() instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) object.getRule()));
	}

}
