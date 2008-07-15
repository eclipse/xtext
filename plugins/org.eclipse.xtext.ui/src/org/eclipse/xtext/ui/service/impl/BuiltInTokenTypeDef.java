/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * @author Dennis Hübner - Initial contribution and API
 *******************************************************************************/
package org.eclipse.xtext.ui.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.service.IPreferenceStore;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.tokentype.TokenTypeDef;
import org.eclipse.xtext.ui.util.GrammarConstants;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInTokenTypeDef implements ITokenTypeDefProvider {
	@Inject
	private IPreferenceStore preferenceStore;
	@Inject
	private IServiceScope serviceScope;

	public static final String KEYWORD_ID = "keyword";
	public static final String SL_COMMENT_ID = "slComment";
	public static final String ML_COMMENT_ID = "mlComment";
	public static final String STRING_ID = "string";
	public static final String NUMBER_ID = "number";

	public List<ITokenTypeDef> allTokenTypes() {
		List<ITokenTypeDef> retVal = new ArrayList<ITokenTypeDef>();
		retVal.add(commentTokenType());
		retVal.add(mlCommentTokenType());
		retVal.add(keyWordTokenType());
		retVal.add(stringTokenType());
		retVal.add(numberTokenType());
		return retVal;
	}

	public ITokenTypeDef commentTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(SL_COMMENT_ID, "Single Line Comment") {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof LexerRule) {
					return "SL_COMMENT".equals(((LexerRule) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		calculateTextStyle(ttd, new TextStyle(TextStyleConstants.COMMENT_COLOR, null, TextStyleConstants.DEFAULT_STYLE,
				null));
		return ttd;
	}

	public ITokenTypeDef mlCommentTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(ML_COMMENT_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof LexerRule) {
					return GrammarConstants.LEXER_RULE_MLCOMMENT.equals(((LexerRule) node.getGrammarElement())
							.getName());
				}
				return false;
			}
		};
		ttd.setName("Multi Line Comment");
		calculateTextStyle(ttd, new TextStyle(TextStyleConstants.MULTILINE_COMMENT_COLOR, null,
				TextStyleConstants.DEFAULT_STYLE, null));
		return ttd;
	}

	public TokenTypeDef keyWordTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(KEYWORD_ID) {
			@Override
			public boolean match(LeafNode node) {
				return node.getGrammarElement() instanceof Keyword;
			}
		};
		ttd.setName("Keyword");
		calculateTextStyle(ttd, new TextStyle(TextStyleConstants.KEYWORD_COLOR, null, TextStyleConstants.KEYWORD_STYLE,
				null));
		return ttd;
	}

	public ITokenTypeDef stringTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(STRING_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return GrammarConstants.LEXER_RULE_STRING.equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("String");
		calculateTextStyle(ttd, new TextStyle(TextStyleConstants.STRING_COLOR, null, TextStyleConstants.DEFAULT_STYLE,
				null));
		return ttd;
	}

	public ITokenTypeDef numberTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(NUMBER_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return GrammarConstants.LEXER_RULE_INT.equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("Number");
		calculateTextStyle(ttd, new TextStyle(TextStyleConstants.NUMBER_COLOR, null, TextStyleConstants.DEFAULT_STYLE,
				null));
		return ttd;
	}

	protected void calculateTextStyle(TokenTypeDef tokenType, TextStyle textStyle) {
		tokenType.setTextStyle(new TextStyle(getColorForTokenType(tokenType.getId(), textStyle.getColor()),
				getBackgroundColorForTokenType(tokenType.getId(), textStyle.getBackgroundColor()),
				getStyleForTokenType(tokenType.getId(), textStyle.getStyle()), getFontForTokenType(tokenType.getId(),
						textStyle.getFontName())));
	}

	// TODO set defaults somewhere else if possible, or check if a default
	// already set
	private int getStyleForTokenType(String tokenType, int defaultStyle) {
		String tokenStylePreferenceKey = BuiltInPreferenceStore.getTokenStylePreferenceKey(serviceScope, tokenType);
		getPreferenceStore().setDefault(tokenStylePreferenceKey, defaultStyle);
		return getPreferenceStore().getInt(tokenStylePreferenceKey);
	}

	private org.eclipse.jface.preference.IPreferenceStore getPreferenceStore() {
		return preferenceStore.getPersitablePreferenceStore();
	}

	private String getFontForTokenType(String tokenType, String defaultFont) {
		String tokenFontPreferenceKey = BuiltInPreferenceStore.getTokenFontPreferenceKey(serviceScope, tokenType);
		if (defaultFont != null)
			getPreferenceStore().setDefault(tokenFontPreferenceKey, defaultFont);
		return getPreferenceStore().getString(tokenFontPreferenceKey);
	}

	private String getBackgroundColorForTokenType(String tokenType, String defaultBackgroundColor) {
		String tokenBackgroundColorPreferenceKey = BuiltInPreferenceStore.getTokenBackgroundColorPreferenceKey(
				serviceScope, tokenType);
		if (defaultBackgroundColor != null)
			getPreferenceStore().setDefault(
					BuiltInPreferenceStore.getTokenBackgroundColorPreferenceKey(serviceScope, tokenType),
					defaultBackgroundColor);
		String rgbString = getPreferenceStore().getString(tokenBackgroundColorPreferenceKey);
		return rgbString;
	}

	private String getColorForTokenType(String tokenType, String defaultColor) {
		String preferenceKey = BuiltInPreferenceStore.getTokenColorPreferenceKey(serviceScope, tokenType);
		if (defaultColor != null)
			getPreferenceStore().setDefault(BuiltInPreferenceStore.getTokenColorPreferenceKey(serviceScope, tokenType),
					defaultColor);
		String rgbString = getPreferenceStore().getString(preferenceKey);
		return rgbString;
	}

	public void setServiceScope(IServiceScope iServiceScope) {
		this.serviceScope = iServiceScope;
	}

	public void setPreferenceStore(IPreferenceStore iPreferenceStore) {
		this.preferenceStore = iPreferenceStore;
	}

}
