/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.doubleClicking;

import java.util.Iterator;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSourceAccess;
import org.eclipse.xtext.ui.editor.model.ILexerTokenRegion;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.inject.Inject;

/**
 * This implementation uses the {@link XtextDocument#getTokens() tokens} of an Xtext document to identify
 * words in the document. Thereby it recognizes keywords that consist only of characters
 * that are no letters, e.g. <code>+=</code> or <code>?=</code>. Furthermore it will select
 * the contents of a brace pair if the opening or closing peer is clicked.
 * Tokens with a length of one character have a lower priority in case a token boundary is selected.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerTokenAndCharacterPairAwareStrategy extends AbstractWordAwareDoubleClickStrategy {

	@Inject
	private ICharacterPairMatcher characterPairMatcher;
	
	@Inject
	private DocumentTokenSourceAccess tokenSourceAccess;
	
	@Override
	protected IRegion findWord(IDocument document, int offset) {
		Iterable<ILexerTokenRegion> tokenIterable = tokenSourceAccess.getTokens(document, true);
		if (tokenIterable == null) {
			return super.findWord(document, offset);
		}
		Iterator<ILexerTokenRegion> tokenIterator = tokenIterable.iterator();
		ILexerTokenRegion leadingToken = null;
		ILexerTokenRegion trailingToken = null;
		while(tokenIterator.hasNext()) {
			ILexerTokenRegion token = tokenIterator.next();
			if (token.getOffset() <= offset && token.getOffset() + token.getLength() >= offset) {
				if (leadingToken != null)
					trailingToken = token;
				else
					leadingToken = token;
			}
			if (token.getOffset() > offset)
				break;
		}
		if (leadingToken != null) {
			try {
				if (leadingToken.getLength() > 1 && (trailingToken == null || !Character.isLetter(document.getChar(trailingToken.getOffset())))) {
					return new Region(leadingToken.getOffset(), leadingToken.getLength());
				} else if (trailingToken != null) {
					return new Region(trailingToken.getOffset(), trailingToken.getLength());
				}
			} catch(BadLocationException ignore) {}
		}
		return super.findWord(document, offset);
	}
	
	@Override
	protected IRegion findExtendedDoubleClickSelection(IDocument document, int offset) {
		IRegion match= characterPairMatcher.match(document, offset);
		if (match != null && match.getLength() >= 2)
			return new Region(match.getOffset() + 1, match.getLength() - 2);
		return findWord(document, offset);
	}
	
	protected ICharacterPairMatcher getCharacterPairMatcher() {
		return characterPairMatcher;
	}

}
