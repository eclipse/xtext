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

	public List<ITokenTypeDef> allTokenTypes() {
		List<ITokenTypeDef> retVal = new ArrayList<ITokenTypeDef>();
		retVal.add(keyWordTokenType());
		retVal.add(commentTokenType());
		return retVal;
	}

	protected ITokenTypeDef commentTokenType() {
		TokenTypeDef ttd = new TokenTypeDef("slComment") {
			@Override
			public boolean match(LeafNode node) {
				if (node.getGrammarElement() instanceof RuleCall) {
					RuleCall ruleCall = (RuleCall) node.getGrammarElement();
					return ruleCall != null && ruleCall.getName().equals("SL_COMMENT");
				}
				return false;
			}
		};
		ttd.setName("Single Line Comment");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.COMMENT_COLOR, null, SWT.NONE, null));
		return ttd;
	}

	protected TokenTypeDef keyWordTokenType() {
		TokenTypeDef ttd = new TokenTypeDef("keyword") {
			@Override
			public boolean match(LeafNode node) {
				return node.getGrammarElement() instanceof Keyword;// && node.
																	// getText().
																	// length() >
																	// 1;
			}
		};
		ttd.setName("Keyword");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.KEYWORD_COLOR, null, TextStyleConstants.KEYWORD_STYLE, null));
		return ttd;
	}
}
