/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CommonToken;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.TextAttribute;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.rules.Token;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * Default implementation for the ITokenScanner.
 * Uses an AntLR based {@link Lexer} and am {@link ITokenColorer} to perform syntax coloring.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public class DefaultTokenScanner implements ITokenScanner {

	private int dirtyRegionOffset;
	
	@Inject
	private ITokenColorer tokenColorer;

	@Inject
	private Lexer lexer;

	private org.antlr.runtime.CommonToken currentAntlrToken;
	
	public int getTokenLength() {
		return currentAntlrToken.getStopIndex() - currentAntlrToken.getStartIndex() + 1;
	}

	public int getTokenOffset() {
		return dirtyRegionOffset + currentAntlrToken.getStartIndex();
	}

	public IToken nextToken() {
		currentAntlrToken = (CommonToken) lexer.nextToken();
		if(currentAntlrToken.getType() == CommonToken.EOF) {
			return Token.EOF;
		}
		return new Token(createTextAttribute());
	}

	public void setRange(IDocument document, int offset, int length) {
		try {
			String dirtyRegion = document.get(offset, length);
			dirtyRegionOffset = offset;
			lexer.setCharStream(new ANTLRStringStream(dirtyRegion));
		}
		catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private TextAttribute createTextAttribute() {
		ITokenStyle tokenStyle = tokenColorer.getTokenStyle(currentAntlrToken.getType());
		// we need difference to an default TextAttribute(null,null,0,null) in
		// DefaultDamagerRepair
		if (tokenStyle == null) {
			return new TextAttribute(null, null, 0, null) {
				@Override
				public boolean equals(Object object) {
					return false;
				}
			};
		}
		TextStyle textStyle = tokenStyle.getDefaultTextStyle();
		int style = textStyle.getStyle();
		Font fontFromFontData = null;
		if (style == SWT.NORMAL) {
			fontFromFontData = EditorUtils.fontFromFontData(textStyle.getFontData());
		}
		return new TextAttribute(EditorUtils.colorFromRGB(textStyle.getColor()), EditorUtils.colorFromRGB(textStyle
				.getBackgroundColor()), style, fontFromFontData);
	}
}
