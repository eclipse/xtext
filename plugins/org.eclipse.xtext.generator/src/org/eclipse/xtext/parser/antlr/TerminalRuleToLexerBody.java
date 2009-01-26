/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UpToToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TerminalRuleToLexerBody extends XtextSwitch<String>{

	private final StringBuilder result;

	public TerminalRuleToLexerBody() {
		this.result = new StringBuilder();
	}
	
	public static String toLexerBody(ParserRule rule) {
		return new TerminalRuleToLexerBody().print(rule);
	}
	
	public String print(ParserRule rule) {
		doSwitch(rule.getAlternatives());
		return result.toString();
	}
	
	@Override
	public String caseAlternatives(Alternatives object) {
		result.append('(');
		boolean first = true;
		for(AbstractElement elem: object.getGroups()) {
			if (!first) result.append('|');
			first = false;
			doSwitch(elem);
		}
		result.append(')').append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseCharacterRange(CharacterRange object) {
		if (!Strings.isEmpty(object.getCardinality()))
			result.append('(');
		doSwitch(object.getLeft());
		result.append("..");
		doSwitch(object.getRight());
		if (!Strings.isEmpty(object.getCardinality())) {
			result.append(')');
			result.append(Strings.emptyIfNull(object.getCardinality()));
		}
		return "";
	}
	
	@Override
	public String defaultCase(EObject object) {
		throw new IllegalArgumentException(object.eClass().getName() + " is not a valid argument.");
	}

	@Override
	public String caseGroup(Group object) {
		if (!Strings.isEmpty(object.getCardinality()))
			result.append('(');
		boolean first = true;
		for (AbstractElement elem : object.getAbstractTokens()) {
			if (!first) result.append(' ');
			first = false;
			doSwitch(elem);
		}
		if (!Strings.isEmpty(object.getCardinality()))
			result.append(')');
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseKeyword(Keyword object) {
		result.append("'");
		String value = Strings.convertToJavaString(object.getValue());
		result.append(value).append("'");
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseWildcard(Wildcard object) {
		result.append('.');
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseLexerRule(LexerRule object) {
		throw new IllegalStateException("Cannot interpret native lexer rules!");
	}

	@Override
	public String caseParserRule(ParserRule object) {
		if (!object.isTerminal())
			throw new IllegalStateException("Cannot call parser rules that are not terminal rules.");
		result.append("RULE_").append(object.getName().toUpperCase());
		return "";
	}

	@Override
	public String caseRuleCall(RuleCall object) {
		doSwitch(object.getRule());
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseNegatedToken(NegatedToken object) {
		result.append("~(");
		doSwitch(object.getTerminal());
		result.append(")").append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseUpToToken(UpToToken object) {
		result.append("( options {greedy=false;} : . )*");
		doSwitch(object.getTerminal());
		return "";
	}
	
	
}
