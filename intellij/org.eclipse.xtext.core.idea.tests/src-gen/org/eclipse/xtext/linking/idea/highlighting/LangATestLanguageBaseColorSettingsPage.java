package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LangATestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LangATestLanguageBaseColorSettingsPage() {
		LangATestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LangATestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LangATestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LangATestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LangATestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LangATestLanguageLanguage.INSTANCE.getDisplayName();
	}
}