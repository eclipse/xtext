package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug443221TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug443221TestLanguageBaseColorSettingsPage() {
		Bug443221TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug443221TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug443221TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug443221TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug443221TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug443221TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}