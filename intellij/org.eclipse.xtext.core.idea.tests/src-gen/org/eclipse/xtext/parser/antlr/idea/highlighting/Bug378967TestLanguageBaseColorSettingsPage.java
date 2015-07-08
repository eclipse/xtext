package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug378967TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug378967TestLanguageBaseColorSettingsPage() {
		Bug378967TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug378967TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug378967TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug378967TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug378967TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug378967TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}