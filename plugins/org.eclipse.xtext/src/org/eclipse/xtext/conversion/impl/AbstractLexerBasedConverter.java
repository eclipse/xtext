/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion.impl;

import java.util.Map;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parser.antlr.TokenTool;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractLexerBasedConverter<T> extends AbstractValueConverter<T> implements IValueConverter.RuleSpecific {

	@Inject(optional=true)
	@Named(LexerBindings.RUNTIME)
	private Provider<Lexer> lexerProvider;
	
	@Inject
	private ITokenDefProvider tokenDefProvider;

	private AbstractRule rule;
	
	@Override
	public String toString(T value) {
		assertValidValue(value);
		String result = toEscapedString(value);
		assertTokens(value, result);
		return result;
	}

	/**
	 * @since 2.7
	 */
	protected void assertTokens(T value, String result) {
		TokenSource tokenSource = getTokenSource(result);
		assertTokens(value, tokenSource, result);
	}

	protected void assertTokens(T value, TokenSource tokenSource, String escapedString) {
		if (tokenSource == null)
			return;
		Token token = tokenSource.nextToken();
		if (!escapedString.equals(token.getText())) {
			throw createTokenContentMismatchException(value, escapedString, token);
		}
		if (!getRuleName().toUpperCase().equals(getRuleName(token))) {
			throw createTokenTypeMismatchException(value, escapedString, token);
		}
		T reparsedValue = toValue(token.getText(), null);
		if (value != reparsedValue && !value.equals(reparsedValue)) {
			throw createTokenContentMismatchException(value, escapedString, token);
		}
	}

	protected ValueConverterException createTokenTypeMismatchException(T value, String escapedString, Token token) {
		return new ValueConverterException("The value '" + value + "' is an invalid " + getRuleName(), null, null);
	}

	protected ValueConverterException createTokenContentMismatchException(T value, String escapedString, Token token) {
		return new ValueConverterException("The value '" + value + "' is an invalid " + getRuleName(), null, null);
	}

	protected TokenSource getTokenSource(String escapedValue) {
		Lexer result = getLexer();
		if (result == null)
			return null;
		result.setCharStream(new ANTLRStringStream(escapedValue));
		return result;
	}

	protected void assertValidValue(T value) {
		if (value == null) {
			throw new ValueConverterException(getRuleName() + " may not be null.", null, null);
		}
	}
	
	protected String getRuleName() {
		return getRule().getName();
	}
	
	protected String toEscapedString(T value) {
		return value.toString();
	}
	
	protected Lexer getLexer() {
		if (lexerProvider != null)
			return lexerProvider.get();
		return null;
	}
	
	// TODO: rename to getLexerRuleName() on next API change
	protected String getRuleName(Token token) {
		String result = getTokenDefMap().get(token.getType());
		return TokenTool.getLexerRuleName(result);
	}

	protected Map<Integer, String> getTokenDefMap() {
		return tokenDefProvider.getTokenDefMap();
	}
	
	protected AbstractRule getRule() {
		return rule;
	}
	
	@Override
	public void setRule(AbstractRule rule) {
		if (rule instanceof TerminalRule) {
			this.rule = rule;
		} else {
			throw new IllegalArgumentException("Only terminal rules are supported by lexer based converters but got " + 
				String.valueOf(rule.getName()) + " which is an instance of " + rule.eClass().getName());
		}
	}
	
	public void setLexerProvider(Provider<Lexer> lexerProvider) {
		this.lexerProvider = lexerProvider;
	}
	
	public void setTokenDefProvider(ITokenDefProvider tokenDefProvider) {
		this.tokenDefProvider = tokenDefProvider;
	}
	
	protected ITokenDefProvider getTokenDefProvider() {
		return tokenDefProvider;
	}
	
	protected Provider<Lexer> getLexerProvider() {
		return lexerProvider;
	}
	
}
