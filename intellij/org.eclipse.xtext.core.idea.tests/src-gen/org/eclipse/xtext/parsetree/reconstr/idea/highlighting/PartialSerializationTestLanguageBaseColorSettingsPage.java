package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class PartialSerializationTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public PartialSerializationTestLanguageBaseColorSettingsPage() {
		PartialSerializationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", PartialSerializationTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", PartialSerializationTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", PartialSerializationTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", PartialSerializationTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return PartialSerializationTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}