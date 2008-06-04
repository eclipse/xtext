/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * @author Dennis Hübner - Initial contribution and API
 *******************************************************************************/
package org.eclipse.xtext.ui.core.tokentype;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.core.service.ITokenTypeDefService;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class BuildInTokenTypeDef implements ITokenTypeDefService {
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

	protected ITokenTypeDef commentTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(SL_COMMENT_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return "SL_COMMENT".equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("Single Line Comment");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.COMMENT_COLOR, null, SWT.NONE, null));
		return ttd;
	}

	protected ITokenTypeDef mlCommentTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(ML_COMMENT_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return "ML_COMMENT".equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("Multi Line Comment");
		ttd.setTextStyle(new TextStyle("33, 97, 65", null, SWT.NONE, null));
		return ttd;
	}

	protected TokenTypeDef keyWordTokenType() {
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

	protected ITokenTypeDef stringTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(STRING_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return "STRING".equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("String");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.STRING_COLOR, null, TextStyleConstants.DEFAULT_STYLE, null));
		return ttd;
	}

	protected ITokenTypeDef numberTokenType() {
		TokenTypeDef ttd = new TokenTypeDef(NUMBER_ID) {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					return "INT".equals(((RuleCall) node.getGrammarElement()).getName());
				}
				return false;
			}
		};
		ttd.setName("Number");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.NUMBER_COLOR, null, TextStyleConstants.DEFAULT_STYLE, null));
		return ttd;
	}
}
