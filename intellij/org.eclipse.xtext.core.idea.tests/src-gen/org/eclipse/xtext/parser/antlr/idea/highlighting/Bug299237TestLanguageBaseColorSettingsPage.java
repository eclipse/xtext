package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug299237TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug299237TestLanguageBaseColorSettingsPage() {
		Bug299237TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug299237TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug299237TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug299237TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug299237TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug299237TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}