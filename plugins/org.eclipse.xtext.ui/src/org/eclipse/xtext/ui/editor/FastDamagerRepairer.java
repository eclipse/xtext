/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor;

import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.ITypedRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.LexerUIBindings;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FastDamagerRepairer extends AbstractDamagerRepairer {

	private static class TokenInfo {
		
		private final int length;
		private final int type;
		
		private TokenInfo(CommonToken token) {
			length = token.getStopIndex() - token.getStartIndex() + 1;
			type = token.getType();
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + length;
			result = prime * result + type;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TokenInfo other = (TokenInfo) obj;
			if (length != other.length)
				return false;
			if (type != other.type)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "TokenInfo [length=" + length + ", type=" + type + "]";
		}
	}
	
	private boolean checkInvariant = false;
	private List<TokenInfo> tokenInfos;
	private IRegion previousRegion;
	private DocumentEvent previousEvent;
	
	private final Provider<Lexer> lexer;

	@Inject
	public FastDamagerRepairer(ITokenScanner scanner, @Named(LexerUIBindings.HIGHLIGHTING) Provider<Lexer> lexer) {
		super(scanner);
		this.lexer = lexer;
	}

	@Override
	public void setDocument(IDocument document) {
		super.setDocument(document);
		tokenInfos = createTokenInfos(document.get());
	}

	private List<TokenInfo> createTokenInfos(String string) {
		List<TokenInfo> result = Lists.newArrayListWithExpectedSize(string.length() / 3);
		TokenSource source = createLexer(string);
		CommonToken token = (CommonToken) source.nextToken();
		while(token != Token.EOF_TOKEN) {
			TokenInfo info = createTokenInfo(token);
			result.add(info);
			token = (CommonToken) source.nextToken();
		}
		return result;
	}

	protected TokenInfo createTokenInfo(CommonToken token) {
		TokenInfo info = new TokenInfo(token);
		return info;
	}

	@Override
	public IRegion getDamageRegion(ITypedRegion partition, final DocumentEvent e, boolean documentPartitioningChanged) {
		if (documentPartitioningChanged) {
			previousEvent = null;
			previousRegion = null;
			tokenInfos = Lists.newArrayList();
			return partition;
		}
		if (previousEvent == e && previousRegion != null) {
			if (isCheckInvariant()) {
				doCheckInvariant(e);
			}
			return previousRegion;
		}
		previousEvent = e;
		previousRegion = computeDamageRegion(e);
		if (isCheckInvariant()) {
			doCheckInvariant(e);
		}
		return previousRegion;
	}

	protected void doCheckInvariant(final DocumentEvent e) {
		List<TokenInfo> parsedTokenInfos = createTokenInfos(e.fDocument.get());
		if (!parsedTokenInfos.equals(tokenInfos)) {
			throw new IllegalStateException("Expected: '" + parsedTokenInfos + "' but was: '" + tokenInfos + "'.");
		}
	}
	
	private IRegion computeDamageRegion(final DocumentEvent e) {
		// empty document -> no dirty region
		if (e.getDocument().getLength() == 0) {
			tokenInfos = createTokenInfos(e.fDocument.get());
			return new Region(0, 0);
		}

		// previously empty -> full document dirty
		if (tokenInfos.isEmpty()) {
			tokenInfos = createTokenInfos(e.fDocument.get());
			return new Region(0, e.getDocument().getLength());
		}

		int tokenStartsAt = 0;
		int tokenInfoIdx = 0;
		int regionOffset = 0;
		int regionLength = e.fDocument.getLength();
		
		TokenSource source = createLexer(e.fDocument.get());
		CommonToken token = (CommonToken) source.nextToken();
		// find start idx
		while(true) {
			if (token == Token.EOF_TOKEN) {
				tokenInfos.subList(tokenInfoIdx, tokenInfos.size()).clear();
				break;
			}
			if (tokenInfoIdx >= tokenInfos.size())
				break;
			TokenInfo tokenInfo = tokenInfos.get(tokenInfoIdx);
			if (tokenInfo.type != token.getType() || token.getStopIndex() - token.getStartIndex() + 1 != tokenInfo.length)
				break;
			if (tokenStartsAt + tokenInfo.length > e.fOffset)
				break;
			tokenStartsAt += tokenInfo.length;
			tokenInfoIdx++;
			token = (CommonToken) source.nextToken();
		}
		regionLength -= tokenStartsAt;
		regionOffset = tokenStartsAt;
		
		int lengthDiff = e.fText.length() - e.fLength;
		// compute region length
		while(true) {
			if (token == Token.EOF_TOKEN || tokenInfoIdx >= tokenInfos.size())
				break;
			while(true) {
				if (tokenInfoIdx >= tokenInfos.size())
					break;
				TokenInfo tokenInfo = tokenInfos.get(tokenInfoIdx);
				if (token.getStartIndex() >= e.fOffset + e.fText.length()) {
					if (tokenStartsAt + lengthDiff == token.getStartIndex() && 
							tokenInfo.type == token.getType() && 
							token.getStopIndex() - token.getStartIndex() + 1 == tokenInfo.length) {
						return new Region(regionOffset, token.getStartIndex() - regionOffset);
					}
				}
				if (tokenStartsAt + lengthDiff + tokenInfo.length > token.getStopIndex() + 1)
					break;
				tokenInfos.remove(tokenInfoIdx);
				tokenStartsAt += tokenInfo.length;
				if (tokenStartsAt + lengthDiff > token.getStartIndex())
					break;
			}
			tokenInfos.add(tokenInfoIdx++, createTokenInfo(token));
			token = (CommonToken) source.nextToken();
		}
		tokenInfos.subList(tokenInfoIdx, tokenInfos.size()).clear();
		// add subsequent tokens
		if (tokenInfoIdx >= tokenInfos.size()) {
			while(token != Token.EOF_TOKEN) {
				tokenInfos.add(createTokenInfo(token));
				token = (CommonToken) source.nextToken();
			}
		}
		return new Region(regionOffset, regionLength);
	}

	protected Lexer createLexer(String string) {
		Lexer l = lexer.get();
		l.setCharStream(new ANTLRStringStream(string));
		return l;
	}

	public void setCheckInvariant(boolean checkInvariant) {
		this.checkInvariant = checkInvariant;
	}

	public boolean isCheckInvariant() {
		return checkInvariant;
	}


}
