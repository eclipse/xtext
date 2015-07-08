package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug296889TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug296889TestLanguageBaseColorSettingsPage() {
		Bug296889TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug296889TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug296889TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug296889TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug296889TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug296889TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}