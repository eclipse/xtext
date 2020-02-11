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
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

/**
 * Checks the entry rule for validity. A rule is considered to be a valid entry rule
 * if it either accepts the empty input or if it ensures that a model is instantiated.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ValidEntryRuleInspector extends XtextRuleInspector<Pair<Boolean, Boolean>, ParserRule>{

	public static final String ISSUE_CODE = "ValidEntryRuleInspector.noInstantiation";
	
	public ValidEntryRuleInspector(ValidationMessageAcceptor acceptor) {
		super(acceptor);
	}
	
	@Override
	protected String getIssueCode() {
		return ISSUE_CODE;
	}

	@Override
	protected boolean canInspect(ParserRule rule) {
		if (GrammarUtil.getGrammar(rule).getRules().get(0) != rule)
			return false;
		if (GrammarUtil.isDatatypeRule(rule) || rule.getAlternatives() == null)
			return false;
		return super.canInspect(rule);
	}
	
	@Override
	protected void handleResult(Pair<Boolean, Boolean> r, ParserRule rule) {
		if (!r.getFirst().booleanValue())
			acceptWarning(
					"The entry rule '" + rule.getName() + "' may consume non empty input without object instantiation. " +
					"Add an action to ensure object creation, e.g. '{" + getTypeRefName(rule.getType()) + "}'." , 
					rule, XtextPackage.Literals.ABSTRACT_RULE__NAME);
	}

	@Override
	public Pair<Boolean, Boolean> caseCompoundElement(CompoundElement object) {
		boolean valid = true;
		boolean instantiated = false;
		for(AbstractElement element: object.getElements()) {
			Pair<Boolean, Boolean> elementResult = doSwitch(element);
			instantiated |= elementResult.getSecond().booleanValue();
			if (!instantiated)
				valid &= elementResult.getFirst().booleanValue();
		}
		valid |= instantiated;
		instantiated &= !(GrammarUtil.isOptionalCardinality(object));
		return Tuples.create(valid, instantiated);
	}
	
	@Override
	public Pair<Boolean, Boolean> caseAbstractElement(AbstractElement object) {
		return Tuples.create(false, false);
	}
	
	@Override
	public Pair<Boolean, Boolean> caseAction(Action object) {
		return Tuples.create(true, true);
	}
	
	@Override
	public Pair<Boolean, Boolean> caseAlternatives(Alternatives object) {
		boolean valid = true;
		boolean instantiated = !GrammarUtil.isOptionalCardinality(object);
		for(AbstractElement element: object.getElements()) {
			Pair<Boolean, Boolean> elementResult = doSwitch(element);
			valid &= elementResult.getFirst().booleanValue();
			instantiated &= elementResult.getSecond().booleanValue();
		}
		return Tuples.create(valid, instantiated);
	}
	
	@Override
	public Pair<Boolean, Boolean> caseAssignment(Assignment object) {
		return Tuples.create(true, !GrammarUtil.isOptionalCardinality(object));
	}
	
	@Override
	public Pair<Boolean, Boolean> caseRuleCall(RuleCall object) {
		boolean instantiated = !GrammarUtil.isOptionalCardinality(object) && ((object.getRule() == null) || 
			(object.getRule() instanceof ParserRule && !GrammarUtil.isDatatypeRule((ParserRule) object.getRule())));
		return Tuples.create(instantiated, instantiated);
	}

}
