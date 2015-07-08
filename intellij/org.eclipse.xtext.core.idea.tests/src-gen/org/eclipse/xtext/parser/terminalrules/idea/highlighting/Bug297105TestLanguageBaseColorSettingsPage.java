package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug297105TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug297105TestLanguageBaseColorSettingsPage() {
		Bug297105TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug297105TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug297105TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug297105TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug297105TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug297105TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}