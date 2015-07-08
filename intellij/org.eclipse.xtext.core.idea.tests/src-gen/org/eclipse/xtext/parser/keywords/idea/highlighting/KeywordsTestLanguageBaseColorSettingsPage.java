package org.eclipse.xtext.parser.keywords.idea.highlighting;

import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class KeywordsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public KeywordsTestLanguageBaseColorSettingsPage() {
		KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", KeywordsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", KeywordsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", KeywordsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", KeywordsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return KeywordsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}