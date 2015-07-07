package org.eclipse.xtext.idea.common.types.idea.highlighting;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class RefactoringTestLanguageDefaultColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public RefactoringTestLanguageDefaultColorSettingsPage() {
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", RefactoringTestLanguageSyntaxHighlighter.KEYWORD),
					createDescriptor("Numbers", RefactoringTestLanguageSyntaxHighlighter.NUMBER),
					createDescriptor("Comments", RefactoringTestLanguageSyntaxHighlighter.COMMENT),
					createDescriptor("Strings", RefactoringTestLanguageSyntaxHighlighter.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return RefactoringTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}