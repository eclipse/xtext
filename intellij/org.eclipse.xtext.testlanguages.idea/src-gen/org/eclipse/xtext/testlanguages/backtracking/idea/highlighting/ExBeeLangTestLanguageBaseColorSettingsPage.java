package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ExBeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ExBeeLangTestLanguageBaseColorSettingsPage() {
		ExBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ExBeeLangTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ExBeeLangTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ExBeeLangTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ExBeeLangTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ExBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}