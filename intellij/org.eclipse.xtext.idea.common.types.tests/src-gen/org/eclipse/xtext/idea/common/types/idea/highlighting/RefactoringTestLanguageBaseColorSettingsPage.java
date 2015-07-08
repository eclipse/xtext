package org.eclipse.xtext.idea.common.types.idea.highlighting;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class RefactoringTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public RefactoringTestLanguageBaseColorSettingsPage() {
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", RefactoringTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", RefactoringTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", RefactoringTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", RefactoringTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return RefactoringTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}