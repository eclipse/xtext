package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug289524ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug289524ExTestLanguageBaseColorSettingsPage() {
		Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug289524ExTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug289524ExTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug289524ExTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug289524ExTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug289524ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}