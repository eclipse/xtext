package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug302128TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug302128TestLanguageBaseColorSettingsPage() {
		Bug302128TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug302128TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug302128TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug302128TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug302128TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug302128TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}