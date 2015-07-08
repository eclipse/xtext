package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class MultiRuleEnumTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public MultiRuleEnumTestLanguageBaseColorSettingsPage() {
		MultiRuleEnumTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", MultiRuleEnumTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", MultiRuleEnumTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", MultiRuleEnumTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", MultiRuleEnumTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return MultiRuleEnumTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}