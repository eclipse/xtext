/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.syntaxcoloring;

import com.google.inject.Singleton;
import java.util.regex.Pattern;

/**
 * @author Anton Kosyakov
 * @since 2.9
 */
@Singleton
public class DefaultAntlrTokenToAttributeIdMapper extends AbstractAntlrTokenToAttributeIdMapper {
	private static final Pattern QUOTED = Pattern.compile("(?:^\'([^\']*)\'$)|(?:^\"([^\"]*)\")$", Pattern.MULTILINE);

	private static final Pattern PUNCTUATION = Pattern.compile("\\p{Punct}*");

	@Override
	protected String calculateId(final String tokenName, final int tokenType) {
		if (tokenName == null) {
			return HighlightingStyles.DEFAULT_ID;
		}
		if (DefaultAntlrTokenToAttributeIdMapper.PUNCTUATION.matcher(tokenName).matches()) {
			return HighlightingStyles.PUNCTUATION_ID;
		}
		if (DefaultAntlrTokenToAttributeIdMapper.QUOTED.matcher(tokenName).matches()) {
			return HighlightingStyles.KEYWORD_ID;
		}
		switch (tokenName) {
			case "RULE_STRING":
				return HighlightingStyles.STRING_ID;
			case "RULE_INT":
				return HighlightingStyles.NUMBER_ID;
			case "RULE_ML_COMMENT":
			case "RULE_SL_COMMENT":
				return HighlightingStyles.COMMENT_ID;
			default:
				return HighlightingStyles.DEFAULT_ID;
		}
	}
}
