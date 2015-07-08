package org.eclipse.xtext.parser.datatyperules.idea.highlighting;

import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class DatatypeRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public DatatypeRulesTestLanguageBaseColorSettingsPage() {
		DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", DatatypeRulesTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", DatatypeRulesTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", DatatypeRulesTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", DatatypeRulesTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return DatatypeRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}