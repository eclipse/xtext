package org.eclipse.xtext.xtext.ecoreInference.idea.highlighting;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class UnassignedRuleCallTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public UnassignedRuleCallTestLanguageBaseColorSettingsPage() {
		UnassignedRuleCallTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", UnassignedRuleCallTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", UnassignedRuleCallTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", UnassignedRuleCallTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", UnassignedRuleCallTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return UnassignedRuleCallTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}