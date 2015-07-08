package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ContextFinderTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ContextFinderTestLanguageBaseColorSettingsPage() {
		ContextFinderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ContextFinderTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ContextFinderTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ContextFinderTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ContextFinderTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ContextFinderTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}