/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.core.editor.utils.TextStyle;
import org.eclipse.xtext.ui.core.editor.utils.TextStyleConstants;
import org.eclipse.xtext.ui.core.tokentype.BuildInTokenTypeDef;
import org.eclipse.xtext.ui.core.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.core.tokentype.TokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceTokenTypeDef extends BuildInTokenTypeDef {
	@Override
	public Set<ITokenTypeDef> allTokenTypes() {
		Set<ITokenTypeDef> allTokenTypes = super.allTokenTypes();
		allTokenTypes.add(commentTokenType());
		allTokenTypes.add(fieldTokenType());
		allTokenTypes.add(rot());
		return allTokenTypes;
	}

	TokenTypeDef rot() {
		TokenTypeDef ttd = new TokenTypeDef("rot") {
			@Override
			public boolean match(LeafNode node) {
				return keyWordTokenType().match(node) && node.getText().equals("ROT");
			}
		};
		TextStyle ts = keyWordTokenType().getTextStyle();
		ts.setColor("250,50,50");
		ttd.setTextStyle(ts);
		return ttd;
	}

	private ITokenTypeDef commentTokenType() {
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

	private ITokenTypeDef fieldTokenType() {
		TokenTypeDef ttd = new TokenTypeDef("field") {
			@Override
			public boolean match(LeafNode node) {
				return node.getFeature() != null;
			}
		};
		ttd.setName("Attribute");
		ttd.setTextStyle(new TextStyle(TextStyleConstants.STRING_COLOR, null, SWT.NONE, null));
		return ttd;
	}

	// @TokenType(name = "Singleline Comment")
	// public boolean slComment(LeafNode node) {
	// return ((RuleCall) node.getGrammarElement()).getName().equals(
	// "SL_COMMENT");
	// }
	//
	// @TokenType(name = "Multiline Comment")
	// public boolean mlComment(LeafNode node) {
	// return ((RuleCall) node.getGrammarElement()).getName().equals(
	// "ML_COMMENT");
	// }
	//
	// @TokenType(name = "Plus Sign")
	// public boolean plus_sign(LeafNode node) {
	// return node.getText().length() == 1 && node.getText().startsWith("+");
	// }
}
