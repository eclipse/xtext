/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.Iterator;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.Regions;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * 
 * TokenScanner implementation based on {@link XtextDocument#getTokens(int)}
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenScanner extends AbstractTokenScanner {

	private Iterator<ILexerTokenRegion> iterator;
	private ILexerTokenRegion currentToken;

	@Inject
	private AbstractAntlrTokenToAttributeIdMapper tokenIdMapper;

	public void setTokenIdMapper(AbstractAntlrTokenToAttributeIdMapper tokenIdMapper) {
		this.tokenIdMapper = tokenIdMapper;
	}

	public void setRange(IDocument document, final int offset, final int length) {
		currentToken=null;
		iterator = Iterables.filter(getTokens(document),Regions.overlaps(offset, length)).iterator();
	}

	protected Iterable<ILexerTokenRegion> getTokens(IDocument document) {
		XtextDocument doc = (XtextDocument) document;
		return doc.getTokens();
	}

	public IToken nextToken() {
		if (!iterator.hasNext())
			return Token.EOF;
		currentToken = iterator.next();
		return createToken(currentToken);
	}

	protected IToken createToken(ILexerTokenRegion currentToken) {
		String id = tokenIdMapper.getId(currentToken.getLexerTokenType());
		Token token = new Token(getAttribute(id));
		return token;
	}

	public int getTokenOffset() {
		return currentToken.getOffset();
	}

	public int getTokenLength() {
		return currentToken.getLength();
	}
	
	protected Iterator<ILexerTokenRegion> getIterator() {
		return iterator;
	}
	
	protected ILexerTokenRegion getCurrentToken() {
		return currentToken;
	}
	
	protected void setCurrentToken(ILexerTokenRegion currentToken) {
		this.currentToken = currentToken;
	}
	
	protected AbstractAntlrTokenToAttributeIdMapper getTokenIdMapper() {
		return tokenIdMapper;
	}

}
