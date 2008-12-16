/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * <p>
 * Represents a class used to generate a complete,default minimum template for a
 * given grammar.
 * </p>
 * The generated template can be used as pattern value for the eclipse
 * 'org.eclipse.ui.editors.templates' extension point.
 * 
 * @author Michael Clay - Initial contribution and API
 * 
 */
public final class DefaultGrammarTemplateSwitch extends XtextSwitch<String> {

	// constants
	private static final String END_STRING_VARIABLE = "}\" ";
	private static final String START_STRING_VARIABLE = " \"${";
	private static final String END_VARIABLE = "} ";
	private static final String START_VARIABLE = " ${";
	private static final String LEXER_RULE_STRING = "STRING";

	private final StringBuffer stringBuffer = new StringBuffer();

	@Override
	public String doSwitch(EObject theEObject) {
		super.doSwitch(theEObject);
		return stringBuffer.toString();
	}

	@Override
	public String caseAlternatives(Alternatives alternatives) {
		for (AbstractElement abstractElement : alternatives.getGroups()) {
			doSwitch(abstractElement);
		}
		return super.caseAlternatives(alternatives);
	}

	@Override
	public String caseAssignment(Assignment assignment) {
		doSwitch(assignment.getTerminal());
		return super.caseAssignment(assignment);
	}

	@Override
	public String caseGroup(Group group) {
		for (AbstractElement abstractElement : group.getAbstractTokens()) {
			doSwitch(abstractElement);
		}
		return super.caseGroup(group);
	}

	@Override
	public String caseKeyword(Keyword keyword) {
		stringBuffer.append(keyword.getValue() + " ");
		return super.caseKeyword(keyword);
	}

	@Override
	public String caseRuleCall(RuleCall ruleCall) {

		AbstractRule calledRule = ruleCall.getRule();

		ParserRule containingParserRule = GrammarUtil.containingParserRule(ruleCall);

		String patternName = containingParserRule.getName()
				+ "_"
				+ (ruleCall.eContainer() instanceof Assignment ? ((Assignment) ruleCall.eContainer()).getFeature()
						: ruleCall.getRule().getName());

		if (calledRule instanceof LexerRule) {

			LexerRule lexerRule = (LexerRule) calledRule;

			if (LEXER_RULE_STRING.equalsIgnoreCase(lexerRule.getName())) {
				stringBuffer.append(START_STRING_VARIABLE + patternName + END_STRING_VARIABLE);
			}
			else {
				stringBuffer.append(START_VARIABLE + patternName + END_VARIABLE);
			}

		}
		else if (calledRule instanceof ParserRule) {

			if (((ParserRule) calledRule).getAlternatives() instanceof Assignment) {
				stringBuffer.append(START_VARIABLE + patternName + END_VARIABLE);
			}
			else {
				doSwitch(((ParserRule) calledRule).getAlternatives());
			}
		}

		return super.caseRuleCall(ruleCall);
	}

}
