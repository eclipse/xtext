package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleBeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleBeeLangTestLanguageBaseColorSettingsPage() {
		SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleBeeLangTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SimpleBeeLangTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SimpleBeeLangTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SimpleBeeLangTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}