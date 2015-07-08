package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug301935TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug301935TestLanguageBaseColorSettingsPage() {
		Bug301935TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug301935TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug301935TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug301935TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug301935TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug301935TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}