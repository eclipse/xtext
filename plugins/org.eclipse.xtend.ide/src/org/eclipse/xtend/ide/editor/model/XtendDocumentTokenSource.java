/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.editor.model;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.antlr.runtime.CommonToken;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendDocumentTokenSource extends DocumentTokenSource {

	public static final int JAVA_DOC_TOKEN_TYPE = -10000;

	@Inject
	@Named(LexerUIBindings.HIGHLIGHTING)
	protected ITokenDefProvider tokenDefProvider;

	protected int multilineTokenType = -1;

	@Override
	protected List<TokenInfo> createTokenInfos(String string) {
		Map<Integer, String> tokenDefMap = tokenDefProvider.getTokenDefMap();
		Set<Entry<Integer, String>> entrySet = tokenDefMap.entrySet();
		for(Entry<Integer, String> entry : entrySet){
			if(entry.getValue().equals("RULE_ML_COMMENT")){
				multilineTokenType = entry.getKey();
			}
		}
		if(multilineTokenType == -1){
			throw new RuntimeException("No Token for RULE ML_COMMENT found in tokenTypeDefs!");
		}
		return super.createTokenInfos(string);
	}

	@Override
	protected TokenInfo createTokenInfo(CommonToken token) {
		if(token.getType() == multilineTokenType){
			String text = token.getText();
			if(text.startsWith("/**") && !text.startsWith("/***")){
				token.setType(JAVA_DOC_TOKEN_TYPE);
			}
		}
		return new TokenInfo(token);
	}
}
