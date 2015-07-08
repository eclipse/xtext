package org.eclipse.xtext.generator.grammarAccess.idea.highlighting;

import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class GrammarAccessTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public GrammarAccessTestLanguageBaseColorSettingsPage() {
		GrammarAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", GrammarAccessTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", GrammarAccessTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", GrammarAccessTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", GrammarAccessTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return GrammarAccessTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}