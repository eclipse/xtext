/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collection;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractNegatedToken;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Michael Clay
 */
public class UsedRulesFinder extends XtextSwitch<Void> {
	
	private final Collection<AbstractRule> usedRules;
	private final Collection<Grammar> visitedGrammars = Sets.newHashSet();

	public UsedRulesFinder(Collection<AbstractRule> usedRules) {
		this.usedRules = usedRules;
	}
	
	@Override
	public Void caseAbstractRule(AbstractRule object) {
		usedRules.add(object);
		return null;
	}
	
	@Override
	public Void caseParserRule(ParserRule object) {
		if (usedRules.add(object)) {
			if (object.getAlternatives() != null)
				doSwitch(object.getAlternatives());
			if (object.isDefinesHiddenTokens())
				for(AbstractRule rule: object.getHiddenTokens())
					doSwitch(rule);
		}
		return null;
	}
	
	@Override
	public Void caseTerminalRule(TerminalRule object) {
		if (usedRules.add(object) && object.getAlternatives() != null) {
			return doSwitch(object.getAlternatives());
		}
		return null;
	}
	
	@Override
	public Void caseAbstractNegatedToken(AbstractNegatedToken object) {
		if (object.getTerminal() != null)
			return doSwitch(object.getTerminal());
		return null;
	}
	
	@Override
	public Void caseRuleCall(RuleCall object) {
		if (object.getRule() != null)
			return doSwitch(object.getRule());
		return null;
	}
	
	@Override
	public Void caseCrossReference(CrossReference object) {
		if (object.getTerminal() != null)
			return doSwitch(object.getTerminal());
		return null;
	}
	
	@Override
	public Void caseAssignment(Assignment object) {
		if (object.getTerminal() != null)
			return doSwitch(object.getTerminal());
		return null;
	}
	
	@Override
	public Void caseCompoundElement(CompoundElement object) {
		for(AbstractElement element: object.getElements())
			doSwitch(element);
		return null;
	}
	
	@Override
	public Void caseGrammar(Grammar object) {
		if (!visitedGrammars.add(object))
			return null;
		if (object.isDefinesHiddenTokens())
			for(AbstractRule rule: object.getHiddenTokens())
				doSwitch(rule);
		for(Grammar grammar: object.getUsedGrammars()) {
			caseGrammar(grammar);
		}
		return null;
	}

	public void compute(Grammar grammar) {
		if (!grammar.getRules().isEmpty()) {
			AbstractRule firstRule = grammar.getRules().get(0);
			if (firstRule instanceof ParserRule) {
				doSwitch(firstRule);
				doSwitch(grammar);
			}
		}
	}
}