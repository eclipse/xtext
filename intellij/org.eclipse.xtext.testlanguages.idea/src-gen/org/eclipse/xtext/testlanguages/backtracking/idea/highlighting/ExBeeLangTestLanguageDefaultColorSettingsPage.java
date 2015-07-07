package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ExBeeLangTestLanguageDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ExBeeLangTestLanguageDefaultColorSettingsPage() {
		ExBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ExBeeLangTestLanguageSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", ExBeeLangTestLanguageSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", ExBeeLangTestLanguageSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", ExBeeLangTestLanguageSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ExBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}