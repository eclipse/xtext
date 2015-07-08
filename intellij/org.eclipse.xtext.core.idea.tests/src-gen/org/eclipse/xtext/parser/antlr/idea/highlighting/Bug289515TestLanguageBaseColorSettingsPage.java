package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug289515TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug289515TestLanguageBaseColorSettingsPage() {
		Bug289515TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug289515TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug289515TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug289515TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug289515TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug289515TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}