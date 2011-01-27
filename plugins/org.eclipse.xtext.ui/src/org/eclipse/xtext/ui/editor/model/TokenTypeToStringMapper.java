/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import java.util.Map;
import java.util.Map.Entry;

import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TokenTypeToStringMapper {

	private String[] mappedValues;
	
	@Inject
	public void setTokenDefProvider(@Named(LexerUIBindings.HIGHLIGHTING) ITokenDefProvider tokenDefProvider) {
		initIds(tokenDefProvider.getTokenDefMap());
	}

	protected void initIds(Map<Integer, String> tokenDefMap) {
		mappedValues = new String[tokenDefMap.size()];
		for (Entry<Integer, String> entry : tokenDefMap.entrySet()) {
			if (entry.getKey() >= Token.MIN_TOKEN_TYPE)
				mappedValues[entry.getKey() - Token.MIN_TOKEN_TYPE] = calculateId(entry.getValue(), entry.getKey());
		}
	}

	protected abstract String calculateId(String tokenName, int tokenType);
	
	protected String getMappedValue(int tokenType) {
		if (tokenType == Token.INVALID_TOKEN_TYPE)
			return DefaultHighlightingConfiguration.INVALID_TOKEN_ID;
		return mappedValues[tokenType-Token.MIN_TOKEN_TYPE];
	}
}
