package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class PartialParserTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public PartialParserTestLanguageBaseColorSettingsPage() {
		PartialParserTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", PartialParserTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", PartialParserTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", PartialParserTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", PartialParserTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return PartialParserTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}