package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug296889ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug296889ExTestLanguageBaseColorSettingsPage() {
		Bug296889ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug296889ExTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug296889ExTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug296889ExTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug296889ExTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug296889ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}