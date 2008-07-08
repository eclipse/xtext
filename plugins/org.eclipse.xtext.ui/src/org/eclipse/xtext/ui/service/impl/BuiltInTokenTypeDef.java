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

import org.eclipse.swt.SWT;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.service.ITokenTypeDefProvider;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.tokentype.TokenTypeDef;
import org.eclipse.xtext.ui.util.GrammarConstants;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuiltInTokenTypeDef implements ITokenTypeDefProvider {
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
		TokenTypeDef ttd = new TokenTypeDef(SL_COMMENT_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof LexerRule) {
					return "SL_COMMENT".equals(((LexerRule) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("Single Line Comment");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.COMMENT_COLOR, null, SWT.NONE, null));
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
		ttd.setTextStyle(new TextStyle("33, 97, 65", null, SWT.NONE, null));
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
		ttd.setTextStyle(new TextStyle(TextStyleConstants.KEYWORD_COLOR, null, TextStyleConstants.KEYWORD_STYLE, null));
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
		ttd.setTextStyle(new TextStyle(TextStyleConstants.STRING_COLOR, null, TextStyleConstants.DEFAULT_STYLE, null));
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
		ttd.setTextStyle(new TextStyle(TextStyleConstants.NUMBER_COLOR, null, TextStyleConstants.DEFAULT_STYLE, null));
		return ttd;
	}
}
