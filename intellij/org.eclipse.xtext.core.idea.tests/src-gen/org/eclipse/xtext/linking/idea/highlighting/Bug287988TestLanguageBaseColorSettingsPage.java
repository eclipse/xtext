package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug287988TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug287988TestLanguageBaseColorSettingsPage() {
		Bug287988TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug287988TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug287988TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug287988TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug287988TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug287988TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}