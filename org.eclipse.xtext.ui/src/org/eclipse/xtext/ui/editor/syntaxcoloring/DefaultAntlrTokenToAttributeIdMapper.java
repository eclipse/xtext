/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.syntaxcoloring;

import java.util.regex.Pattern;

import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;

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
			return HighlightingStyles.PUNCTUATION_ID;
		}
		if(QUOTED.matcher(tokenName).matches()) {
			return HighlightingStyles.KEYWORD_ID;
		}
		if("RULE_STRING".equals(tokenName)) {
			return HighlightingStyles.STRING_ID;
		}
		if("RULE_INT".equals(tokenName)) {
			return HighlightingStyles.NUMBER_ID;
		}
		if("RULE_ML_COMMENT".equals(tokenName) || "RULE_SL_COMMENT".equals(tokenName)) {
			return HighlightingStyles.COMMENT_ID;
		}
		return HighlightingStyles.DEFAULT_ID;
	}
	
}
