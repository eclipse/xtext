package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug313089TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug313089TestLanguageBaseColorSettingsPage() {
		Bug313089TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug313089TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug313089TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug313089TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug313089TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug313089TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}