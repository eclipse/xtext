package org.eclipse.xtext.parser.encoding.idea.highlighting;

import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EncodingTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EncodingTestLanguageBaseColorSettingsPage() {
		EncodingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EncodingTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EncodingTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EncodingTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EncodingTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EncodingTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}