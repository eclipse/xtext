package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ImportUriTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ImportUriTestLanguageBaseColorSettingsPage() {
		ImportUriTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ImportUriTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ImportUriTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ImportUriTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ImportUriTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ImportUriTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}