package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleExpressionsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleExpressionsTestLanguageBaseColorSettingsPage() {
		SimpleExpressionsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleExpressionsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SimpleExpressionsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SimpleExpressionsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SimpleExpressionsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleExpressionsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}