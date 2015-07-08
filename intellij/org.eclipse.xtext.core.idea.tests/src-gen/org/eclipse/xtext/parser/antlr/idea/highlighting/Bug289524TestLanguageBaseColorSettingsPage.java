package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug289524TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug289524TestLanguageBaseColorSettingsPage() {
		Bug289524TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug289524TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug289524TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug289524TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug289524TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug289524TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}