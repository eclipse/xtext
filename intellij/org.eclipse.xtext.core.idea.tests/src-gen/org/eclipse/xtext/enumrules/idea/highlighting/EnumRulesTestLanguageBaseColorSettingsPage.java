package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EnumRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EnumRulesTestLanguageBaseColorSettingsPage() {
		EnumRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EnumRulesTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EnumRulesTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EnumRulesTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EnumRulesTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EnumRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}