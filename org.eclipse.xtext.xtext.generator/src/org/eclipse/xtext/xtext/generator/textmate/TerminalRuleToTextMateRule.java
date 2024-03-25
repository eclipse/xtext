/**
 * Copyright (c) 2024 Sigasi (http://www.sigasi.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.textmate;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.EOF;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * Converter from Xtext {@link TerminalRule} to TextMate regular expressions.
 * 
 * @author David Medina
 * @author Sebastian Zarnekow
 * @since 2.35
 */
public class TerminalRuleToTextMateRule extends XtextSwitch<String> {

	private final StringBuilder match;
	private boolean negationMode = false;

	public TerminalRuleToTextMateRule() {
		this.match = new StringBuilder();
	}

	public String getMatchRegEx(TerminalRule rule) {
		doSwitch(rule.getAlternatives());
		String result = match.toString();
		match.setLength(0);
		return result;
	}
	
	public String getMatchRegEx(AbstractElement element) {
		doSwitch(element);
		String result = match.toString();
		match.setLength(0);
		return result;
	}

	@Override
	public String caseAlternatives(Alternatives object) {
		if (negationMode) {
			for (var elem : object.getElements()) {
				doSwitch(elem);
			}
		} else {
			match.append("(");
			boolean first = true;
			for (var elem : object.getElements()) {
				if (!first) match.append("|");
				first = false;
				doSwitch(elem);
			}
			match.append(')');
			match.append(Strings.emptyIfNull(object.getCardinality()));
		}

		return "";
	}

	@Override
	public String caseWildcard(Wildcard object) {
		match.append(".");
		match.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseTerminalRule(TerminalRule object) {
		doSwitch(object.getAlternatives());
		return "";
	}

	@Override
	public String caseCharacterRange(CharacterRange object) {
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append('(');
		}
		match.append("[");
		doSwitch(object.getLeft());
		match.append("-");
		doSwitch(object.getRight());
		match.append("]");
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append(')');
			match.append(Strings.emptyIfNull(object.getCardinality()));
		}
		return "";
	}

	@Override
	public String caseRuleCall(RuleCall object) {
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append("(");
		}
		doSwitch(object.getRule());
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append(")");
			match.append(Strings.emptyIfNull(object.getCardinality()));
		}
		return "";
	}

	@Override
	public String caseGroup(Group object) {
		if (negationMode) {
			throw new UnsupportedOperationException("Negation is not supported for group rules");
		}
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append("(");
		}
		for (var elem : object.getElements()) {
			doSwitch(elem);
		}
		if (!Strings.isEmpty(object.getCardinality())) {
			match.append(")");
		}
		match.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseNegatedToken(NegatedToken object) {
		match.append("[^");
		negationMode = true;
		doSwitch(object.getTerminal());
		negationMode = false;
		match.append("]").append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	@Override
	public String caseUntilToken(UntilToken object) {
		throw new UnsupportedOperationException("Until token not supported, use begin and end TextMate rules");
	}

	@Override
	public String defaultCase(EObject object) {
		throw new UnsupportedOperationException(
				"Encountered a non terminal rule or a terminal rule that is not supported: " + object.toString());
	}

	@Override
	public String caseKeyword(Keyword object) {
		String value = object.getValue();
		match.append(toTextMateString(value));
		match.append(Strings.emptyIfNull(object.getCardinality()));
		return "";
	}

	// Do nothing
	@Override
	public String caseEOF(EOF object) {
		return "";
	}

	// see https://macromates.com/manual/en/regular_expressions
	private String toTextMateString(String base) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < base.length(); i++) {
			char c = base.charAt(i);
			if (c == '*' || c == '+' || c == '.' || c == '?' || c == '\\' || c == '\r' || c == '\n' || c == '"' || c == '\t'
					|| c == '$' || c == '^' || c == '|' || c == '{' || c == '}'|| c == '[' || c == ']') {
				builder.append("\\");
			}
			if (c == ' ') {
				builder.append("\\s");
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

}
