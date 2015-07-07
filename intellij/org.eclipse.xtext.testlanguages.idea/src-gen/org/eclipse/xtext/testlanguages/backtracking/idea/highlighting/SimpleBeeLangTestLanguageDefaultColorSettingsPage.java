package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleBeeLangTestLanguageDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleBeeLangTestLanguageDefaultColorSettingsPage() {
		SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleBeeLangTestLanguageSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", SimpleBeeLangTestLanguageSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", SimpleBeeLangTestLanguageSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", SimpleBeeLangTestLanguageSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}