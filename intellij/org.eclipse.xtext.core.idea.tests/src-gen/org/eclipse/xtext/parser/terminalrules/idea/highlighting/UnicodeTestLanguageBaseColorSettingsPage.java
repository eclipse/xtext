package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class UnicodeTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public UnicodeTestLanguageBaseColorSettingsPage() {
		UnicodeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", UnicodeTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", UnicodeTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", UnicodeTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", UnicodeTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return UnicodeTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}