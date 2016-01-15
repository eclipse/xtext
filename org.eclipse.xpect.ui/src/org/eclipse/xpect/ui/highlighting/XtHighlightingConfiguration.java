/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xpect.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.xpect.registry.DefaultBinding;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtHighlightingConfiguration implements IHighlightingConfiguration {

	@DefaultBinding
	@Inject(optional = true)
	private IHighlightingConfiguration delegate;

	public static final String KEYWORD_ID = "xpect.keyword";
	public static final String PUNCTUATION_ID = "xpect.punctuation";
	public static final String COMMENT_ID = "xpect.comment";
	public static final String STRING_ID = "xpect.string";
	public static final String NUMBER_ID = "xpect.number";
	public static final String DEFAULT_ID = "xpect.default";
	public static final String WHITESPACE_ID = "xpect.whitespace";
	public static final String INVALID_TOKEN_ID = "xpect.error";

	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		if (delegate != null)
			delegate.configure(acceptor);
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, "Xpect Keyword", keywordTextStyle());
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, "Xpect Punctuation character", punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Xpect Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(STRING_ID, "Xpect String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Xpect Number", numberTextStyle());
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, "Xpect Default", defaultTextStyle());
		acceptor.acceptDefaultHighlighting(WHITESPACE_ID, "Xpect Whitespace", whitespaceTextStyle());
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, "Xpect Invalid Symbol", errorTextStyle());
	}

	public TextStyle defaultTextStyle() {
		TextStyle textStyle = new TextStyle();
		textStyle.setBackgroundColor(new RGB(195, 250, 223));
		textStyle.setColor(new RGB(0, 0, 0));
		return textStyle;
	}

	public TextStyle errorTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

	public TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	public TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	public TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}

	public TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	public TextStyle punctuationTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

	public TextStyle whitespaceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		return textStyle;
	}

}
