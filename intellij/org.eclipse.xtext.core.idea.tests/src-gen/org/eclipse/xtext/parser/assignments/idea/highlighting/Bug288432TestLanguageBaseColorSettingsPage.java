package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug288432TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug288432TestLanguageBaseColorSettingsPage() {
		Bug288432TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug288432TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug288432TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug288432TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug288432TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug288432TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}