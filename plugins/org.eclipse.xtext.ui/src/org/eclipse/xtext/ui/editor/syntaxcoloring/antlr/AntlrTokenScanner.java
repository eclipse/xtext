/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.antlr.runtime.TokenSource;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractTokenScanner;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Default implementation for the ITokenScanner. Uses an AntLR based
 * {@link Lexer} and am {@link ITokenColorer} to perform syntax coloring.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrTokenScanner extends AbstractTokenScanner {

	@Inject
	@Named(LexerUIBindings.HIGHLIGHTING)
	private Lexer lexer;

	@Inject
	private AbstractAntlrTokenToAttributeIdMapper tokenIdMapper;
	
	private int dirtyRegionOffset;

	private CommonToken currentAntlrToken;
	
	public int getTokenLength() {
		return currentAntlrToken.getStopIndex() - currentAntlrToken.getStartIndex() + 1;
	}

	public int getTokenOffset() {
		return dirtyRegionOffset + currentAntlrToken.getStartIndex();
	}

	public IToken nextToken() {
		currentAntlrToken = nextAntlrToken();
		if (currentAntlrToken.getType() == org.antlr.runtime.Token.EOF) {
			return Token.EOF;
		}
		String id = tokenIdMapper.getId(currentAntlrToken.getType());
		return new Token(getAttribute(id));
	}

	public void setRange(IDocument document, int offset, int length) {
		try {
			String dirtyRegion = document.get(offset, length);
			dirtyRegionOffset = offset;
			configureTokenSource(dirtyRegion);
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
	}

	protected void configureTokenSource(String dirtyRegion) {
		lexer.setCharStream(new ANTLRStringStream(dirtyRegion));
	}
	
	public CommonToken nextAntlrToken() {
		return (CommonToken) getLexer().nextToken();
	}

	public void setTokenIdMapper(AbstractAntlrTokenToAttributeIdMapper tokenIdMapper) {
		this.tokenIdMapper = tokenIdMapper;
	}

	public AbstractAntlrTokenToAttributeIdMapper getTokenIdMapper() {
		return tokenIdMapper;
	}

	public void setLexer(Lexer lexer) {
		this.lexer = lexer;
	}

	public TokenSource getLexer() {
		return lexer;
	}
}
