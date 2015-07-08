package org.eclipse.xtext.validation.idea.highlighting;

import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ConcreteSyntaxValidationTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ConcreteSyntaxValidationTestLanguageBaseColorSettingsPage() {
		ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ConcreteSyntaxValidationTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ConcreteSyntaxValidationTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ConcreteSyntaxValidationTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ConcreteSyntaxValidationTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}