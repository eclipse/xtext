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
import org.eclipse.xtext.service.ILanguageDescriptor;
import org.eclipse.xtext.service.Inject;
import org.eclipse.xtext.ui.editor.preferences.AbstractRootPreferencePage;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.ui.service.impl.BuiltInTokenTypeDef;
import org.eclipse.xtext.ui.tokentype.ITokenTypeDef;
import org.eclipse.xtext.ui.tokentype.TokenTypeDef;

/**
 * @author Dennis Hübner - Initial contribution and API
 * 
 */
public class ReferenceTokenTypeDef extends BuiltInTokenTypeDef {
	@Inject
	public void setLanguageDescriptor(ILanguageDescriptor language) {
		if (AbstractRootPreferencePage.language == null)
			AbstractRootPreferencePage.language = language;

	}

	@Override
	public List<ITokenTypeDef> allTokenTypes() {

		List<ITokenTypeDef> allTokenTypes = new ArrayList<ITokenTypeDef>();
		// allTokenTypes.add(fieldTokenType());
		allTokenTypes.add(rot());
		allTokenTypes.add(gelb());
		allTokenTypes.add(grün());
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
		ts.setColor("200,10,50");
		ttd.setTextStyle(ts);
		return ttd;
	}

	TokenTypeDef gelb() {
		TokenTypeDef ttd = new TokenTypeDef("gelb") {
			@Override
			public boolean match(LeafNode node) {
				return keyWordTokenType().match(node) && "GELB".equals(node.getText());
			}
		};
		TextStyle ts = keyWordTokenType().getTextStyle();
		ts.setColor("221,212,88");
		ttd.setTextStyle(ts);
		return ttd;
	}

	TokenTypeDef grün() {
		TokenTypeDef ttd = new TokenTypeDef("grün") {
			@Override
			public boolean match(LeafNode node) {
				return keyWordTokenType().match(node) && "GRÜN".equals(node.getText());
			}
		};
		TextStyle ts = keyWordTokenType().getTextStyle();
		ts.setColor("10,200,10");
		ttd.setTextStyle(ts);
		return ttd;
	}

}
