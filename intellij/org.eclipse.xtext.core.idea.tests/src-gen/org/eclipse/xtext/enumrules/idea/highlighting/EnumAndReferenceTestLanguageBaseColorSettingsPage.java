package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EnumAndReferenceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EnumAndReferenceTestLanguageBaseColorSettingsPage() {
		EnumAndReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EnumAndReferenceTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EnumAndReferenceTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EnumAndReferenceTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EnumAndReferenceTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EnumAndReferenceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}