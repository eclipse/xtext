package org.eclipse.xtext.lexer.idea.highlighting;

import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class IgnoreCaseLexerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public IgnoreCaseLexerTestLanguageBaseColorSettingsPage() {
		IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", IgnoreCaseLexerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", IgnoreCaseLexerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", IgnoreCaseLexerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", IgnoreCaseLexerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return IgnoreCaseLexerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}