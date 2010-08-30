/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentToken;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * 
 * TokenScanner implmentation based on {@link XtextDocument#getTokens()}
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class TokenScanner extends AbstractTokenScanner {

	private List<? extends IXtextDocumentToken> list;
	private int currentTokenIdx;
	private int currentOffset;
	private int stopIndex;
	private IXtextDocumentToken currentToken;

	@Inject
	private AbstractAntlrTokenToAttributeIdMapper tokenIdMapper;

	public void setTokenIdMapper(AbstractAntlrTokenToAttributeIdMapper tokenIdMapper) {
		this.tokenIdMapper = tokenIdMapper;
	}

	public void setRange(IDocument document, int offset, int length) {
		currentToken=null;
		list = getTokens(document);
		currentOffset = 0;
		stopIndex = offset+length;
		for (currentTokenIdx = 0; currentTokenIdx < list.size(); currentTokenIdx++) {
			IXtextDocumentToken token = list.get(currentTokenIdx);
			if (currentOffset >= offset) {
				return;
			}
			currentOffset += token.getLength();
		}
	}

	protected List<? extends IXtextDocumentToken> getTokens(IDocument document) {
		XtextDocument doc = (XtextDocument) document;
		return doc.getTokens();
	}

	public IToken nextToken() {
		if (currentToken != null)
			currentOffset += currentToken.getLength();
		if (currentTokenIdx >= list.size() || stopIndex<=currentOffset)
			return Token.EOF;
		currentToken = list.get(currentTokenIdx++);
		IToken token = createToken();
		return token;
	}

	protected IToken createToken() {
		String id = tokenIdMapper.getId(currentToken.getAntlrTokenType());
		Token token = new Token(getAttribute(id));
		return token;
	}

	public int getTokenOffset() {
		return currentOffset;
	}

	public int getTokenLength() {
		return currentToken.getLength();
	}

}
