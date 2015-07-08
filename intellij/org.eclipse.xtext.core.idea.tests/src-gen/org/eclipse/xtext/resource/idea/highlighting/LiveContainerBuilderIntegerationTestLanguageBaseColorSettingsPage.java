package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LiveContainerBuilderIntegerationTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LiveContainerBuilderIntegerationTestLanguageBaseColorSettingsPage() {
		LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LiveContainerBuilderIntegerationTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LiveContainerBuilderIntegerationTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LiveContainerBuilderIntegerationTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LiveContainerBuilderIntegerationTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}