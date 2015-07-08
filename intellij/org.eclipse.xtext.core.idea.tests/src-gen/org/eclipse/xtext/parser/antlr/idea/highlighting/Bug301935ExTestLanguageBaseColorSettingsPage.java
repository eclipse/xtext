package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug301935ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug301935ExTestLanguageBaseColorSettingsPage() {
		Bug301935ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug301935ExTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug301935ExTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug301935ExTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug301935ExTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug301935ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}