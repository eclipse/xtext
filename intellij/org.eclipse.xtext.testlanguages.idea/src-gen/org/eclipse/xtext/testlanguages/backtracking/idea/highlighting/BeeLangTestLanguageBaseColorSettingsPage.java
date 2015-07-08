package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class BeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public BeeLangTestLanguageBaseColorSettingsPage() {
		BeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", BeeLangTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", BeeLangTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", BeeLangTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", BeeLangTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return BeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}