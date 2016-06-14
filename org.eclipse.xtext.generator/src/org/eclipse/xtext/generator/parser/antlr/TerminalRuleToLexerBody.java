/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.antlr;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.EOF;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TerminalRuleToLexerBody extends XtextSwitch<String>{

	private final StringBuilder result;

	private TerminalRuleToLexerBody() {
		this.result = new StringBuilder();
	}

	public static String toLexerBody(TerminalRule rule) {
		return new TerminalRuleToLexerBody().print(rule);
	}

	public String print(TerminalRule rule) {
		doSwitch(rule.getAlternatives());
		return result.toString();
	}

	@Override
	public String caseAlternatives(Alternatives object) {
		result.append('(');
		boolean first = true;
		for(AbstractElement elem: object.getElements()) {
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
		for (AbstractElement elem : object.getElements()) {
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
		String value = toLexerString(object.getValue());
		result.append(value).append("'");
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	private String toLexerString(String theString) {
//		return Strings.convertToJavaString(value);
		int len = theString.length();
		int bufLen = len * 2;
		if (bufLen < 0) {
			bufLen = Integer.MAX_VALUE;
		}
		StringBuffer outBuffer = new StringBuffer(bufLen);

		for (int x = 0; x < len; x++) {
			char aChar = theString.charAt(x);
			// Handle common case first, selecting largest block that
			// avoids the specials below
			if ((aChar > 61) && (aChar < 127)) {
				if (aChar == '\\') {
					outBuffer.append('\\');
					outBuffer.append('\\');
					continue;
				}
				outBuffer.append(aChar);
				continue;
			}
			switch (aChar) {
				case ' ':
					outBuffer.append(' ');
					break;
				case '\t':
					outBuffer.append('\\');
					outBuffer.append('t');
					break;
				case '\n':
					outBuffer.append('\\');
					outBuffer.append('n');
					break;
				case '\r':
					outBuffer.append('\\');
					outBuffer.append('r');
					break;
				case '\f':
					outBuffer.append('\\');
					outBuffer.append('f');
					break;
				case '\b':
					outBuffer.append('\\');
					outBuffer.append('b');
					break;
				case '\'':
					outBuffer.append('\\');
					outBuffer.append('\'');
					break;
					// don't escape double quotes
//				case '"':
//					outBuffer.append('\\');
//					outBuffer.append('"');
//					break;
				default:
					if ((aChar < 0x0020) || (aChar > 0x007e)) {
						outBuffer.append('\\');
						outBuffer.append('u');
						outBuffer.append(Strings.toHex((aChar >> 12) & 0xF));
						outBuffer.append(Strings.toHex((aChar >> 8) & 0xF));
						outBuffer.append(Strings.toHex((aChar >> 4) & 0xF));
						outBuffer.append(Strings.toHex(aChar & 0xF));
					}
					else {
						outBuffer.append(aChar);
					}
			}
		}
		return outBuffer.toString();
	}

	@Override
	public String caseWildcard(Wildcard object) {
		result.append('.');
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}
	
	/**
	 * @since 2.0
	 */
	@Override
	public String caseEOF(EOF object) {
		result.append("EOF");
		result.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseTerminalRule(TerminalRule object) {
		result.append(AntlrGrammarGenUtil.getRuleName(object));
		return "";
	}

	@Override
	public String caseParserRule(ParserRule object) {
		throw new IllegalStateException("Cannot call parser rules that are not terminal rules.");
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
	public String caseUntilToken(UntilToken object) {
		result.append("( options {greedy=false;} : . )*");
		doSwitch(object.getTerminal());
		return "";
	}

}
