package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug287184TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug287184TestLanguageBaseColorSettingsPage() {
		Bug287184TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug287184TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug287184TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug287184TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug287184TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug287184TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}