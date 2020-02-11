/** 
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring

import com.google.inject.Singleton
import java.util.regex.Pattern

/** 
 * @author Anton Kosyakov
 * @since 2.9
 */
@Singleton
class DefaultAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {

	static val QUOTED = Pattern.compile("(?:^'([^']*)'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE)

	static val PUNCTUATION = Pattern.compile("\\p{Punct}*")

	override protected calculateId(String tokenName, int tokenType) {
		switch tokenName {
			case PUNCTUATION.matcher(tokenName).matches:
				HighlightingStyles.PUNCTUATION_ID
			case QUOTED.matcher(tokenName).matches:
				HighlightingStyles.KEYWORD_ID
			case "RULE_STRING":
				HighlightingStyles.STRING_ID
			case "RULE_INT":
				HighlightingStyles.NUMBER_ID
			case "RULE_ML_COMMENT",
			case "RULE_SL_COMMENT":
				HighlightingStyles.COMMENT_ID
			default:
				HighlightingStyles.DEFAULT_ID
		} 
	}

}
