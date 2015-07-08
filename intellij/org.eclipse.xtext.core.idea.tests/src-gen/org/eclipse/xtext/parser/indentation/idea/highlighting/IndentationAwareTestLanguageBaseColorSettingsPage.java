package org.eclipse.xtext.parser.indentation.idea.highlighting;

import org.eclipse.xtext.parser.indentation.idea.lang.IndentationAwareTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class IndentationAwareTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public IndentationAwareTestLanguageBaseColorSettingsPage() {
		IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", IndentationAwareTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", IndentationAwareTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", IndentationAwareTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", IndentationAwareTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return IndentationAwareTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}