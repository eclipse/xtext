package org.eclipse.xtext.lexer.idea.highlighting;

import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class BacktrackingLexerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public BacktrackingLexerTestLanguageBaseColorSettingsPage() {
		BacktrackingLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", BacktrackingLexerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", BacktrackingLexerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", BacktrackingLexerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", BacktrackingLexerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return BacktrackingLexerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}