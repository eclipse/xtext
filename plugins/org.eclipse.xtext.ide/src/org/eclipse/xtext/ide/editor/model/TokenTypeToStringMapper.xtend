/** 
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.model

import com.google.inject.Inject
import com.google.inject.name.Named
import java.util.Map
import org.antlr.runtime.Token
import org.eclipse.xtext.ide.LexerIdeBindings
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles
import org.eclipse.xtext.parser.antlr.ITokenDefProvider

/**
 * @author Anton Kosyakov
 * 
 * @since 2.9
 */
abstract class TokenTypeToStringMapper {

	String[] mappedValues

	@Inject
	def void setTokenDefProvider(@Named(LexerIdeBindings.HIGHLIGHTING) ITokenDefProvider tokenDefProvider) {
		initIds(tokenDefProvider.tokenDefMap)
	}

	def protected void initIds(Map<Integer, String> tokenDefMap) {
		mappedValues = newArrayOfSize(tokenDefMap.size)
		for (entry : tokenDefMap.entrySet) {
			if (entry.key >= Token.MIN_TOKEN_TYPE) {
				mappedValues.set(entry.key - Token.MIN_TOKEN_TYPE, calculateId(entry.value, entry.key))
			}
		}
	}

	def protected abstract String calculateId(String tokenName, int tokenType)

	def protected String getMappedValue(int tokenType) {
		if (tokenType == Token.INVALID_TOKEN_TYPE) {
			HighlightingStyles.INVALID_TOKEN_ID
		} else {
			mappedValues.get(tokenType - Token.MIN_TOKEN_TYPE)
		}
	}

}
