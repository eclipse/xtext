package org.eclipse.xtext.linking.idea.highlighting;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

public class Bug362902HighlightingConfiguration implements IHighlightingConfiguration {
	public final static TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
			(Bug362902Language.INSTANCE.getID() + HighlightingStyles.NUMBER_ID), DefaultLanguageHighlighterColors.NUMBER);

	public final static TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(
			(Bug362902Language.INSTANCE.getID() + HighlightingStyles.KEYWORD_ID),
			DefaultLanguageHighlighterColors.KEYWORD);

	public final static TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
			(Bug362902Language.INSTANCE.getID() + HighlightingStyles.COMMENT_ID),
			DefaultLanguageHighlighterColors.LINE_COMMENT);

	public final static TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
			(Bug362902Language.INSTANCE.getID() + HighlightingStyles.STRING_ID), DefaultLanguageHighlighterColors.STRING);

	@Override
	public TextAttributesKey getTextAttributesKey(final String attribute) {
		if (HighlightingStyles.KEYWORD_ID.equals(attribute)) {
			return KEYWORD;
		} else if (HighlightingStyles.STRING_ID.equals(attribute)) {
			return STRING;
		} else if (HighlightingStyles.COMMENT_ID.equals(attribute)) {
			return COMMENT;
		} else if (HighlightingStyles.NUMBER_ID.equals(attribute)) {
			return NUMBER;
		}
		return HighlighterColors.TEXT;
	}
}