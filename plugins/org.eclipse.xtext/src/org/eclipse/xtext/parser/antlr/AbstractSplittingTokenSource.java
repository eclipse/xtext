/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.antlr;

import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;

import com.google.common.collect.BiMap;
import com.google.inject.Inject;

/**
 * Delegating token source that is capable of splitting a given token
 * into other tokens. This allows clients to implement sophisticated semantics when
 * dealing with certain token types in different use cases, e.g. a token source that
 * will provide tokens for a python-like whitespace aware language.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractSplittingTokenSource implements TokenSource {

	public static final String LEXER_RULE_PREFIX = "RULE_";
	
	private TokenSource delegate;
	
	private TokenAcceptor nextTokens;
	
	private BiMap<Integer, String> tokenDefs;
	
	protected AbstractSplittingTokenSource() {
		nextTokens = new TokenAcceptor();
	}
	
	public void setDelegate(TokenSource delegate) {
		this.delegate = delegate;
	}
	
	public TokenSource getDelegate() {
		return delegate;
	}
	
	public Token nextToken() {
		if (nextTokens.hasNext()) {
			Token result = nextTokens.next(); 
			return result;
		}
		Token result = delegate.nextToken();
		splitToken(result, nextTokens);
		result = nextTokens.next();
		return result;
	}
	
	protected String getRuleName(Token token) {
		String result = tokenDefs.get(token.getType());
		result = getLexerRuleName(result);
		return result;
	}
	
	protected int getTokenType(String ruleNameWithRulePrefix) {
		int result = tokenDefs.inverse().get(ruleNameWithRulePrefix);
		return result;
	}
	
	public String getLexerRuleName(String antlrTokenDef) {
		if (antlrTokenDef.startsWith(LEXER_RULE_PREFIX))
			return antlrTokenDef.substring(LEXER_RULE_PREFIX.length());
		return antlrTokenDef;
	}
	
	@Inject
	public void initializeTokenDefsFrom(ITokenDefProvider provider) {
		tokenDefs.clear();
		tokenDefs.putAll(provider.getTokenDefMap());
	}

	protected void splitToken(Token splitMe, ITokenAcceptor acceptor) {
		if (shouldSplitToken(splitMe)) {
			doSplitToken(splitMe, acceptor);
		} else {
			acceptor.accept(splitMe);
		}
	}
	
	protected abstract boolean shouldSplitToken(Token candidate);
	
	protected abstract void doSplitToken(Token splitMe, ITokenAcceptor acceptor);
	
	/**
	 * Create a new token from the given prototype. Any argument besides the prototype is optional and
	 * will be ignored if its value is <code>null</code>.
	 */
	protected CommonToken createToken(CommonToken prototype, String text, 
			Integer charPosInLine, Integer channel, Integer start, Integer stop, Integer type) {
		if (prototype == null)
			throw new IllegalArgumentException("Prototype may not be null.");
		CommonToken result = new CommonToken(prototype);
		if (text != null)
			result.setText(text);
		if (charPosInLine != null)
			result.setCharPositionInLine(charPosInLine.intValue());
		if (channel != null)
			result.setChannel(channel.intValue());
		if (start != null)
			result.setStartIndex(start.intValue());
		if (stop != null)
			result.setStopIndex(stop.intValue());
		if (type != null)
			result.setType(type.intValue());
		return result;
	}

}
