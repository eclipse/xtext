/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Set;

import org.antlr.runtime.Token;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parsetree.AbstractNode;

import com.google.common.base.Function;
import com.google.common.base.Join;
import com.google.common.collect.Iterables;
import com.google.common.collect.Sets;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;

/**
 * Abstract implementation of a value converter that escapes a string
 * based on a set of values. The strategy to compute this values and how the 
 * the string is found in this set is the responsibility of the concrete 
 * implementation. A common use-case is to collect the keywords in a grammar
 * and match the string against these keywords or to use some ignore-case matching
 * algorithm against the list of normalized keywords.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(IDValueConverter.class)
public abstract class AbstractIDValueConverter extends AbstractLexerBasedConverter<String> {

	@Inject
	private IGrammarAccess grammarAccess;
	
	private Set<String> valuesToEscape;

	/**
	 * @deprecated this implementation is {@link IValueConverter.RuleSpecific} thus {@link #setRule(AbstractRule)}
	 * will be used to initialize this converter.
	 */
	@Deprecated
	protected AbstractIDValueConverter(Grammar grammar, String ruleName) {
		super(GrammarUtil.findRuleForName(grammar, ruleName));
	}
	
	protected AbstractIDValueConverter() {
		super();
	}
	
	protected abstract Set<String> computeValuesToEscape(Grammar grammar);
	
	protected Set<String> getValuesToEscape() {
		if (valuesToEscape == null)
			valuesToEscape = computeValuesToEscape(grammarAccess.getGrammar());
		return valuesToEscape;
	}

	protected abstract boolean mustEscape(String value);
	
	@Override
	protected String toEscapedString(String value) {
		if (mustEscape(value))
			return "^" + value;
		return value;
	}
	
	@Override
	protected void assertValidValue(String value) {
		super.assertValidValue(value);
		if (value.length() == 0) {
			throw new ValueConverterException(getRuleName() + " may not be empty.", null, null);
		}
	}
	
	@Override
	protected ValueConverterException createTokenContentMismatchException(String value, String escapedString, Token token) {
		Set<Character> invalidChars = collectInvalidCharacters(value);
		if (invalidChars != null) {
			String chars = Join.join(", ", Iterables.transform(invalidChars, new Function<Character, String>() {
				public String apply(Character from) {
					return "'" + from + "' (0x" + Integer.toHexString(from) + ")";
				}
			}));
			return new ValueConverterException("ID '" + value + "' contains invalid characters: " + chars, null, null);
		}
		return super.createTokenContentMismatchException(value, escapedString, token);
	}

	protected Set<Character> collectInvalidCharacters(String value) {
		Set<Character> result = null;
		for (int i = 0; i < value.length(); i++) {
			char c = value.charAt(i);
			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
				continue;
			if (i != 0 && c >= '0' && c <= '9')
				continue;
			if (c == '_')
				continue;
			if (result == null)
				result = Sets.newHashSet();
			result.add(c);
		}
		return result;
	}
	
	public String toValue(String string, AbstractNode node) {
		if (string == null)
			return null;
		return string.startsWith("^") ? string.substring(1) : string;
	}
	
	protected IGrammarAccess getGrammarAccess() {
		return grammarAccess;
	}
	
	public void setGrammarAccess(IGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}