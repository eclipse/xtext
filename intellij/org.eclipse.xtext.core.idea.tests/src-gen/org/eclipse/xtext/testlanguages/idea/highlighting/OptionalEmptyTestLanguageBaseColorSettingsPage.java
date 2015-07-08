package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class OptionalEmptyTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public OptionalEmptyTestLanguageBaseColorSettingsPage() {
		OptionalEmptyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", OptionalEmptyTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", OptionalEmptyTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", OptionalEmptyTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", OptionalEmptyTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return OptionalEmptyTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}