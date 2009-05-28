/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.ITokenStyle;
import org.eclipse.xtext.ui.common.editor.syntaxcoloring.TokenStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class CommonTokenStyles {

	public static final String KEYWORD_ID = "keyword";
	public static final String PUNCTUATION_ID = "punctuation";
	public static final String COMMENT_ID = "comment";
	public static final String STRING_ID = "string";
	public static final String NUMBER_ID = "number";
	public static final String DEFAULT_ID = "default";

	public static final ITokenStyle KEYWORD = new TokenStyle("Keyword", KEYWORD_ID, keywordTextStyle());
	public static final ITokenStyle PUNCTUATION = new TokenStyle("Punctuation character", PUNCTUATION_ID, punctuationTextStyle());
	public static final ITokenStyle COMMENT = new TokenStyle("Comment",COMMENT_ID, commentTextStyle());
	public static final ITokenStyle STRING = new TokenStyle("String", STRING_ID, stringTextStyle());
	public static final ITokenStyle NUMBER = new TokenStyle("Number", NUMBER_ID, numberTextStyle());
	public static final ITokenStyle DEFAULT = new TokenStyle("Default", DEFAULT_ID, defaultTextStyle());
	
	private static TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(255, 255, 255));
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}
	
	private static TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	private static TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	private static TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}

	private static TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	private static TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

}
