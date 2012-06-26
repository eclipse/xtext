package org.eclipse.xpect.ui.highlighting;

import java.util.Set;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;

import com.google.common.collect.ImmutableSet;

public class XpectTokenToAttributeMapper extends
		DefaultAntlrTokenToAttributeIdMapper {

	private final Set<String> keywords = ImmutableSet.of("KEYWORD_11",
			"KEYWORD_10", "KEYWORD_7", "KEYWORD_6", "KEYWORD_8", "KEYWORD_9");

	@Override
	protected String calculateId(String tokenName, int tokenType) {
		if (keywords.contains(tokenName)) {
			return DefaultHighlightingConfiguration.KEYWORD_ID;
		}
		if (tokenName.startsWith("KEYWORD_"))
			return DefaultHighlightingConfiguration.PUNCTUATION_ID;
		return super.calculateId(tokenName, tokenType);
	}

}
