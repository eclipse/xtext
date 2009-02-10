/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.AbstractTokenScanner;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.PreferenceStoreAccessor;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.SyntaxColoringPreferencePage;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Default implementation for the ITokenScanner. Uses an AntLR based
 * {@link Lexer} and am {@link ITokenColorer} to perform syntax coloring.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrTokenScanner extends AbstractTokenScanner {

	@Inject
	public AntlrTokenScanner(String languageName, Provider<SyntaxColoringPreferencePage> preferencePageProvider,
			PreferenceStoreAccessor accessor,ITokenColorer tokenColorer,Lexer lexer) {
		super(languageName, preferencePageProvider, accessor);
		this.tokenColorer = tokenColorer;
		this.lexer = lexer;
	}

	private ITokenColorer tokenColorer;
	
	private Lexer lexer;

	private int dirtyRegionOffset;
	
	private CommonToken currentAntlrToken;

	public int getTokenLength() {
		return currentAntlrToken.getStopIndex() - currentAntlrToken.getStartIndex() + 1;
	}

	public int getTokenOffset() {
		return dirtyRegionOffset + currentAntlrToken.getStartIndex();
	}

	public IToken nextToken() {
		currentAntlrToken = (CommonToken) lexer.nextToken();
		if (currentAntlrToken.getType() == CommonToken.EOF) {
			return Token.EOF;
		}
		return new Token(createTextAttribute(tokenColorer.getTokenStyle(Integer.toString(currentAntlrToken.getType()))));
	}

	public void setRange(IDocument document, int offset, int length) {
		try {
			String dirtyRegion = document.get(offset, length);
			dirtyRegionOffset = offset;
			lexer.setCharStream(new ANTLRStringStream(dirtyRegion));
		}
		catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
}
