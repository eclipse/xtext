package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug317840TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug317840TestLanguageBaseColorSettingsPage() {
		Bug317840TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug317840TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug317840TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug317840TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug317840TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug317840TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}