package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class IgnoreCaseImportsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public IgnoreCaseImportsTestLanguageBaseColorSettingsPage() {
		IgnoreCaseImportsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", IgnoreCaseImportsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", IgnoreCaseImportsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", IgnoreCaseImportsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", IgnoreCaseImportsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return IgnoreCaseImportsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}