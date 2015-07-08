package org.eclipse.xtext.linking.lazy.idea.highlighting;

import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug311337TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug311337TestLanguageBaseColorSettingsPage() {
		Bug311337TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug311337TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug311337TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug311337TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug311337TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug311337TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}