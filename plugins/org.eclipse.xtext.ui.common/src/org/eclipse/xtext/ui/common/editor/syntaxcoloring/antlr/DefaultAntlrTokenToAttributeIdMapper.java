/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring.antlr;

import java.util.regex.Pattern;

import org.eclipse.xtext.ui.common.editor.syntaxcoloring.DefaultLexicalHighlightingConfiguration;

import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class DefaultAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

	private static final Pattern QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);
	
	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");
	
	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if(PUNCTUATION.matcher(tokenName).matches()) {
			return DefaultLexicalHighlightingConfiguration.PUNCTUATION_ID;
		}
		if(QUOTED.matcher(tokenName).matches()) {
			return DefaultLexicalHighlightingConfiguration.KEYWORD_ID;
		}
		if("RULE_STRING".equals(tokenName)) {
			return DefaultLexicalHighlightingConfiguration.STRING_ID;
		}
		if("RULE_INT".equals(tokenName)) {
			return DefaultLexicalHighlightingConfiguration.NUMBER_ID;
		}
		if("RULE_ML_COMMENT".equals(tokenName) | "RULE_SL_COMMENT".equals(tokenName)) {
			return DefaultLexicalHighlightingConfiguration.COMMENT_ID;
		}
		return DefaultLexicalHighlightingConfiguration.DEFAULT_ID;
	}
	
}
