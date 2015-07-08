package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug289059TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug289059TestLanguageBaseColorSettingsPage() {
		Bug289059TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug289059TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug289059TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug289059TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug289059TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug289059TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}