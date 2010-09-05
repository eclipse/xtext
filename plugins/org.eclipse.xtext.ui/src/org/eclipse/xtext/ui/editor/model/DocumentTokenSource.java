/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.LexerUIBindings;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class DocumentTokenSource {

	public static class TokenInfo {

		private final int length;
		private final int type;

		public TokenInfo(CommonToken token) {
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

		public int getAntlrTokenType() {
			return this.type;
		}

		public int getLength() {
			return this.length;
		}
	}

	/**
	 * @author Sven Efftinge - Initial contribution and API
	 */
	public static class TokenAdapter implements ILexerTokenRegion {

		private TokenInfo token;
		private int offset;

		public TokenAdapter(TokenInfo token, int offset) {
			this.token = token;
			this.offset = offset;
		}

		public int getLength() {
			return token.getLength();
		}

		public int getOffset() {
			return offset;
		}

		public int getLexerTokenType() {
			return token.getAntlrTokenType();
		}

	}

	public static class IRegionIterable implements Iterable<ILexerTokenRegion> {

		private Iterable<TokenInfo> tokens = null;

		public IRegionIterable(Iterable<TokenInfo> tokens) {
			this.tokens = tokens;
		}

		public Iterator<ILexerTokenRegion> iterator() {
			return new AbstractIterator<ILexerTokenRegion>() {

				private int offset = 0;
				private Iterator<TokenInfo> infos = tokens.iterator();

				@Override
				protected ILexerTokenRegion computeNext() {
					if (!infos.hasNext()) {
						endOfData();
						return null;
					}
					TokenInfo next = infos.next();
					try {
						return new TokenAdapter(next, offset);
					} finally {
						offset += next.getLength();
					}
				}
			};
		}
	}

	private boolean checkInvariant = false;
	private List<TokenInfo> internalModifyableTokenInfos = Collections.emptyList();
	private List<TokenInfo> tokenInfos = Collections.emptyList();
	private IRegion previousRegion;
	private DocumentEvent previousEvent;

	private Provider<Lexer> lexer;

	public Iterable<ILexerTokenRegion> getTokenInfos() {
		return new IRegionIterable(tokenInfos);
	}
	
	public IRegion getLastDamagedRegion() {
		return previousRegion;
	}

	@Inject
	public void setLexer(@Named(LexerUIBindings.HIGHLIGHTING) Provider<Lexer> lexer) {
		this.lexer = lexer;
	}

	protected void setTokens(List<TokenInfo> infos) {
		this.internalModifyableTokenInfos = infos;
		this.tokenInfos = Collections.unmodifiableList(infos);
	}

	protected List<TokenInfo> createTokenInfos(String string) {
		List<TokenInfo> result = Lists.newArrayListWithExpectedSize(string.length() / 3);
		TokenSource source = createLexer(string);
		CommonToken token = (CommonToken) source.nextToken();
		while (token != Token.EOF_TOKEN) {
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

	public void updateStructure(final DocumentEvent e) {
		try {
			if (previousEvent == e && previousRegion != null) {
				return;
			}
			previousRegion = computeDamageRegion(e);
		} finally {
			previousEvent = e;
			if (isCheckInvariant()) {
				doCheckInvariant(e);
			}
		}
	}

	protected void doCheckInvariant(final DocumentEvent e) {
		List<TokenInfo> parsedTokenInfos = createTokenInfos(e.fDocument.get());
		if (!parsedTokenInfos.equals(internalModifyableTokenInfos)) {
			throw new IllegalStateException("Expected: '" + parsedTokenInfos + "' but was: '"
					+ internalModifyableTokenInfos + "'.");
		}
	}

	private IRegion computeDamageRegion(final DocumentEvent e) {
		// empty document -> no dirty region
		if (e.getDocument().getLength() == 0) {
			setTokens(createTokenInfos(e.fDocument.get()));
			return new Region(0, 0);
		}

		// previously empty -> full document dirty
		if (internalModifyableTokenInfos.isEmpty()) {
			setTokens(createTokenInfos(e.fDocument.get()));
			return new Region(0, e.getDocument().getLength());
		}

		int tokenStartsAt = 0;
		int tokenInfoIdx = 0;
		int regionOffset = 0;
		int regionLength = e.fDocument.getLength();

		TokenSource source = createLexer(e.fDocument.get());
		CommonToken token = (CommonToken) source.nextToken();
		// find start idx
		while (true) {
			if (token == Token.EOF_TOKEN) {
				internalModifyableTokenInfos.subList(tokenInfoIdx, internalModifyableTokenInfos.size()).clear();
				break;
			}
			if (tokenInfoIdx >= internalModifyableTokenInfos.size())
				break;
			TokenInfo tokenInfo = internalModifyableTokenInfos.get(tokenInfoIdx);
			if (tokenInfo.type != token.getType()
					|| token.getStopIndex() - token.getStartIndex() + 1 != tokenInfo.length)
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
		while (true) {
			if (token == Token.EOF_TOKEN || tokenInfoIdx >= internalModifyableTokenInfos.size())
				break;
			while (true) {
				if (tokenInfoIdx >= internalModifyableTokenInfos.size())
					break;
				TokenInfo tokenInfo = internalModifyableTokenInfos.get(tokenInfoIdx);
				if (token.getStartIndex() >= e.fOffset + e.fText.length()) {
					if (tokenStartsAt + lengthDiff == token.getStartIndex() && tokenInfo.type == token.getType()
							&& token.getStopIndex() - token.getStartIndex() + 1 == tokenInfo.length) {
						return new Region(regionOffset, token.getStartIndex() - regionOffset);
					}
				}
				if (tokenStartsAt + lengthDiff + tokenInfo.length > token.getStopIndex() + 1)
					break;
				internalModifyableTokenInfos.remove(tokenInfoIdx);
				tokenStartsAt += tokenInfo.length;
				if (tokenStartsAt + lengthDiff > token.getStartIndex())
					break;
			}
			internalModifyableTokenInfos.add(tokenInfoIdx++, createTokenInfo(token));
			token = (CommonToken) source.nextToken();
		}
		internalModifyableTokenInfos.subList(tokenInfoIdx, internalModifyableTokenInfos.size()).clear();
		// add subsequent tokens
		if (tokenInfoIdx >= internalModifyableTokenInfos.size()) {
			while (token != Token.EOF_TOKEN) {
				internalModifyableTokenInfos.add(createTokenInfo(token));
				token = (CommonToken) source.nextToken();
			}
		}
		setTokens(internalModifyableTokenInfos);
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
