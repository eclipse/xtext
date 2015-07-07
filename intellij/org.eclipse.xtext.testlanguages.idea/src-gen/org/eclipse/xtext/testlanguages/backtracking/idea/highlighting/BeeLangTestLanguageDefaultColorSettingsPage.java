package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class BeeLangTestLanguageDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public BeeLangTestLanguageDefaultColorSettingsPage() {
		BeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", BeeLangTestLanguageSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", BeeLangTestLanguageSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", BeeLangTestLanguageSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", BeeLangTestLanguageSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return BeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}