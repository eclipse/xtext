/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * @author Dennis Hübner - Initial contribution and API
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.tokentype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.core.util.GrammarConstants;

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

	private List<ITokenTypeDef> tokenTypeDefs;

	public List<ITokenTypeDef> allTokenTypes() {
		if (tokenTypeDefs == null) {
			tokenTypeDefs = new ArrayList<ITokenTypeDef>();
			tokenTypeDefs.add(commentTokenType());
			tokenTypeDefs.add(mlCommentTokenType());
			tokenTypeDefs.add(keyWordTokenType());
			tokenTypeDefs.add(stringTokenType());
			tokenTypeDefs.add(numberTokenType());
		}
		return tokenTypeDefs;
	}

	public ITokenTypeDef commentTokenType() {
		return new TokenTypeDef(SL_COMMENT_ID, "Single Line Comment") {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof LexerRule) {
					return "SL_COMMENT".equals(((LexerRule) node.getGrammarElement()).getName());
				}
				return false;
			}

			@Override
			public TextStyle defaultTextStyle() {
				TextStyle textStyle = super.defaultTextStyle();
				textStyle.setColor(TextStyleConstants.COMMENT_COLOR);
				return textStyle;
			}
		};

	}

	public ITokenTypeDef mlCommentTokenType() {
		return new TokenTypeDef(ML_COMMENT_ID, "Multi Line Comment") {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof LexerRule) {
					return GrammarConstants.LEXER_RULE_MLCOMMENT.equals(((LexerRule) node.getGrammarElement())
							.getName());
				}
				return false;
			}

			@Override
			public TextStyle defaultTextStyle() {
				TextStyle textStyle = super.defaultTextStyle();
				textStyle.setColor(TextStyleConstants.MULTILINE_COMMENT_COLOR);
				return textStyle;
			}
		};
	}

	public TokenTypeDef keyWordTokenType() {
		return new TokenTypeDef(KEYWORD_ID, "Keyword") {
			@Override
			public boolean match(LeafNode node) {
				return node.getGrammarElement() instanceof Keyword;
			}

			@Override
			public TextStyle defaultTextStyle() {
				TextStyle textStyle = super.defaultTextStyle();
				textStyle.setColor(TextStyleConstants.KEYWORD_COLOR);
				textStyle.setStyle(SWT.BOLD);
				return textStyle;
			}
		};
	}

	public ITokenTypeDef stringTokenType() {
		return new TokenTypeDef(STRING_ID, "String") {

			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return GrammarConstants.LEXER_RULE_STRING.equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}

			@Override
			public TextStyle defaultTextStyle() {
				TextStyle textStyle = super.defaultTextStyle();
				textStyle.setColor(TextStyleConstants.STRING_COLOR);
				return textStyle;
			}
		};
	}

	public ITokenTypeDef numberTokenType() {
		return new TokenTypeDef(NUMBER_ID, "Number") {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return GrammarConstants.LEXER_RULE_INT.equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}

			@Override
			public TextStyle defaultTextStyle() {
				TextStyle textStyle = super.defaultTextStyle();
				textStyle.setColor(TextStyleConstants.NUMBER_COLOR);
				return textStyle;
			}
		};
	}

}
