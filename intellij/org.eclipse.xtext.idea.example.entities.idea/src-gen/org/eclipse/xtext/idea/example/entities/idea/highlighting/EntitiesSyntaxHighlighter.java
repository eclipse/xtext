package org.eclipse.xtext.idea.example.entities.idea.highlighting;

import com.google.common.base.Objects;
import com.intellij.ide.highlighter.JavaHighlightingColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.idea.highlighting.AbstractSyntaxHighlighter;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;

public class EntitiesSyntaxHighlighter extends AbstractSyntaxHighlighter {
	public final static TextAttributesKey NUMBER = TextAttributesKey.createTextAttributesKey(
			(EntitiesLanguage.INSTANCE.getID() + HighlightingStyles.NUMBER_ID), JavaHighlightingColors.NUMBER);

	public final static TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey(
			(EntitiesLanguage.INSTANCE.getID() + HighlightingStyles.KEYWORD_ID),
			JavaHighlightingColors.KEYWORD);

	public final static TextAttributesKey COMMENT = TextAttributesKey.createTextAttributesKey(
			(EntitiesLanguage.INSTANCE.getID() + HighlightingStyles.COMMENT_ID),
			JavaHighlightingColors.LINE_COMMENT);

	public final static TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey(
			(EntitiesLanguage.INSTANCE.getID() + HighlightingStyles.STRING_ID), JavaHighlightingColors.STRING);

	@Override
	public TextAttributesKey createOrGetTextAttributesKey(final String attribute) {
		TextAttributesKey _switchResult = null;
		boolean _matched = false;
		if (!_matched) {
			if (Objects.equal(attribute, HighlightingStyles.NUMBER_ID)) {
				_matched = true;
				_switchResult = NUMBER;
			}
		}
		if (!_matched) {
			if (Objects.equal(attribute, HighlightingStyles.KEYWORD_ID)) {
				_matched = true;
				_switchResult = KEYWORD;
			}
		}
		if (!_matched) {
			if (Objects.equal(attribute, HighlightingStyles.STRING_ID)) {
				_matched = true;
				_switchResult = STRING;
			}
		}
		if (!_matched) {
			if (Objects.equal(attribute, HighlightingStyles.COMMENT_ID)) {
				_matched = true;
				_switchResult = COMMENT;
			}
		}
		if (!_matched) {
			_switchResult = HighlighterColors.TEXT;
		}
		return _switchResult;
	}
}