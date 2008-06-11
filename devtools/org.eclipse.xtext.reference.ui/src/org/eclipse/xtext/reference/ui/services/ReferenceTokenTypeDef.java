/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.reference.ui.services;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.xtext.parsetree.LeafNode;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.tokentype.BuildInTokenTypeDef;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.tokentype.TokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceTokenTypeDef extends BuildInTokenTypeDef {
	@Override
	public List<ITokenTypeDef> allTokenTypes() {
		List<ITokenTypeDef> allTokenTypes = new ArrayList<ITokenTypeDef>();
		allTokenTypes.add(fieldTokenType());
		allTokenTypes.add(rot());
		allTokenTypes.addAll(super.allTokenTypes());
		return allTokenTypes;
	}

	TokenTypeDef rot() {
		TokenTypeDef ttd = new TokenTypeDef("rot") {
			@Override
			public boolean match(LeafNode node) {
				return keyWordTokenType().match(node) && "ROT".equals(node.getText());
			}
		};
		TextStyle ts = keyWordTokenType().getTextStyle();
		ts.setColor("250,50,50");
		ttd.setTextStyle(ts);
		return ttd;
	}

	private ITokenTypeDef fieldTokenType() {
		// TODO want print all "featured" nodes italic, but can't
		TokenTypeDef ttd = new TokenTypeDef("field") {
			@Override
			public boolean match(LeafNode node) {
				return false;// DISABLED node.getFeature() != null;
			}
		};
		return ttd;
	}
}
