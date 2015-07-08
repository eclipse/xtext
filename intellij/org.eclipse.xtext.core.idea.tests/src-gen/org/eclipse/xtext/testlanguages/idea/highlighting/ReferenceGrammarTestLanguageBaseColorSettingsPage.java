package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ReferenceGrammarTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ReferenceGrammarTestLanguageBaseColorSettingsPage() {
		ReferenceGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ReferenceGrammarTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ReferenceGrammarTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ReferenceGrammarTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ReferenceGrammarTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ReferenceGrammarTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}