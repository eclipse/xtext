/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.generator.parser.packrat;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CharacterRange;
import org.eclipse.xtext.EOF;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.NegatedToken;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UntilToken;
import org.eclipse.xtext.Wildcard;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.matching.StringWithOffset;
import org.eclipse.xtext.util.XtextSwitch;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Deprecated(forRemoval = true)
public class TerminalRuleInterpreter extends XtextSwitch<Boolean>{

	private final ICharSequenceWithOffset input;
	private final IMarkerFactory markerFactory;

	public TerminalRuleInterpreter(Keyword keyword) {
		this(keyword.getValue());
	}

	public TerminalRuleInterpreter(String input) {
		this(new StringWithOffset(input));
	}

	public TerminalRuleInterpreter(StringWithOffset input) {
		this(input, input);
	}

	public boolean matches(TerminalRule rule) {
		return doSwitch(rule) && eof();
	}

	private boolean eof() {
		return input.getOffset() >= input.length();
	}

	public TerminalRuleInterpreter(ICharSequenceWithOffset input, IMarkerFactory markerFactory) {
		super();
		this.input = input;
		this.markerFactory = markerFactory;
	}

	@Override
	public Boolean caseAlternatives(Alternatives object) {
		boolean result = false;
		OUTER: do {
			for (AbstractElement element: object.getElements()) {
				if (doSwitch(element)) {
					result = true;
					continue OUTER;
				}
			}
			break OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	@Override
	public Boolean caseCharacterRange(CharacterRange object) {
		boolean result = false;
		if (object.getLeft().getValue().length() != 1 || object.getRight().getValue().length() != 1)
			throw new IllegalStateException("ranges cannot use strings as left or right, that are longer then 1 character.");
		OUTER: do {
			if (eof())
				break OUTER;
			char left = object.getLeft().getValue().charAt(0);
			char right = object.getRight().getValue().charAt(0);
			char candidate = input.charAt(input.getOffset());
			if (left <= candidate && right >= candidate) {
				input.incOffset();
				result = true;
				continue OUTER;
			}
			break OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	@Override
	public Boolean defaultCase(EObject object) {
		throw new IllegalArgumentException(object.eClass().getName() + " is not a valid argument.");
	}

	@Override
	public Boolean caseGroup(Group object) {
		boolean result = false;
		OUTER: do {
			IMarker marker = markerFactory.mark();
			for(AbstractElement element: object.getElements()) {
				if (!doSwitch(element)) {
					marker.rollback();
					break OUTER;
				}
			}
			result = true;
			continue OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	@Override
	public Boolean caseKeyword(Keyword object) {
		boolean result = false;
		String value = object.getValue();
		OUTER: do {
			if (input.getOffset() + value.length() > input.length())
				break OUTER;
			if (value.equals(input.subSequence(input.getOffset(), input.getOffset() +  value.length()).toString())) {
				input.incOffset(value.length());
				result = true;
				continue OUTER;
			}
			break OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	@Override
	public Boolean caseWildcard(Wildcard object) {
		boolean result = false;
		OUTER: do {
			if (eof())
				break OUTER;
			input.incOffset();
			result = true;
			continue OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}
	
	@Override
	public Boolean caseEOF(EOF object) {
		if (eof())
			return Boolean.TRUE;
		return Boolean.FALSE;
	}

	@Override
	public Boolean caseTerminalRule(TerminalRule object) {
		return doSwitch(object.getAlternatives());
	}

	@Override
	public Boolean caseParserRule(ParserRule object) {
		throw new IllegalStateException("Cannot call parser rules that are not terminal rules.");
	}

	@Override
	public Boolean caseRuleCall(RuleCall object) {
		boolean result = false;
		OUTER: do {
			if (doSwitch(object.getRule())) {
				result = true;
				continue OUTER;
			}
			break OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

	@Override
	public Boolean caseUntilToken(UntilToken object) {
		if (GrammarUtil.isOptionalCardinality(object) || GrammarUtil.isMultipleCardinality(object))
			throw new IllegalStateException("cardinality has to be default for until tokens");
		IMarker marker = markerFactory.mark();
		while (!eof()) {
			if (doSwitch(object.getTerminal())) {
				return true;
			}
			input.incOffset();
		}
		marker.rollback();
		return false;
	}

	@Override
	public Boolean caseNegatedToken(NegatedToken object) {
		boolean result = false;
		OUTER: do {
			if (eof())
				break OUTER;
			IMarker marker = markerFactory.mark();
			if (!doSwitch(object.getTerminal())) {
				result = true;
				input.incOffset();
				continue OUTER;
			}
			marker.rollback();
			break OUTER;
		} while(GrammarUtil.isMultipleCardinality(object));
		return result || GrammarUtil.isOptionalCardinality(object);
	}

}