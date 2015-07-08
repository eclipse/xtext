package org.eclipse.xtend.core.idea.highlighting;

import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.IHighlightingConfiguration;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendHighlightingConfiguration implements IHighlightingConfiguration {
	public final static TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
			(XtendLanguage.INSTANCE.getID() + HighlightingStyles.NUMBER_ID), JavaHighlightingColors.NUMBER);

	public final static TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(
			(XtendLanguage.INSTANCE.getID() + HighlightingStyles.KEYWORD_ID),
			JavaHighlightingColors.KEYWORD);

	public final static TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
			(XtendLanguage.INSTANCE.getID() + HighlightingStyles.COMMENT_ID),
			JavaHighlightingColors.LINE_COMMENT);

	public final static TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
			(XtendLanguage.INSTANCE.getID() + HighlightingStyles.STRING_ID), JavaHighlightingColors.STRING);

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