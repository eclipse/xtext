package org.eclipse.xtext.formatting2.internal.idea.highlighting;

import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class FormatterTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public FormatterTestLanguageBaseColorSettingsPage() {
		FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", FormatterTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", FormatterTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", FormatterTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", FormatterTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return FormatterTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}