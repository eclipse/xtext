package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class AbstractIgnoreCaseLinkingTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public AbstractIgnoreCaseLinkingTestLanguageBaseColorSettingsPage() {
		AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", AbstractIgnoreCaseLinkingTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", AbstractIgnoreCaseLinkingTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", AbstractIgnoreCaseLinkingTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", AbstractIgnoreCaseLinkingTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}