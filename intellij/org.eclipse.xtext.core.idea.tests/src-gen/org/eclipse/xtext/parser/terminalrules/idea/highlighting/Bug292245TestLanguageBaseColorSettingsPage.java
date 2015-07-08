package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug292245TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug292245TestLanguageBaseColorSettingsPage() {
		Bug292245TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug292245TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug292245TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug292245TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug292245TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug292245TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}