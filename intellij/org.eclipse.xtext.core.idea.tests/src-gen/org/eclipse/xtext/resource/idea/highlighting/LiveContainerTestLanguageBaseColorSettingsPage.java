package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LiveContainerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LiveContainerTestLanguageBaseColorSettingsPage() {
		LiveContainerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LiveContainerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LiveContainerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LiveContainerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LiveContainerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LiveContainerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}