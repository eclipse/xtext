/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.xtext.ui.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.impl.BuildInTokenTypeDef;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.tokentype.TokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class XtextTokenTypeDef extends BuildInTokenTypeDef {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.ui.service.ITokenTypeDefProvider#allTokenTypes()
	 */
	@Override
	public List<ITokenTypeDef> allTokenTypes() {
		List<ITokenTypeDef> allTokenTypes = new ArrayList<ITokenTypeDef>();
		allTokenTypes.add(special());

		allTokenTypes.addAll(super.allTokenTypes());
		return allTokenTypes;
	}

	private ITokenTypeDef special() {
		TokenTypeDef ttd = new TokenTypeDef("special") {
			@Override
			public boolean match(LeafNode node) {
				return RuleCall.class.isInstance(node.getGrammarElement())
						&& ("ID".equals(node.getText()) || "STRING".equals(node.getText()) || "INT".equals(node
								.getText()));
			}
		};
		TextStyle ts = keyWordTokenType().getTextStyle();
		ts.setStyle(ts.getStyle() | SWT.ITALIC);
		ttd.setTextStyle(ts);
		return ttd;
	}
}
