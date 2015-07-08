package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SerializationBug269362TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SerializationBug269362TestLanguageBaseColorSettingsPage() {
		SerializationBug269362TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SerializationBug269362TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SerializationBug269362TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SerializationBug269362TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SerializationBug269362TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SerializationBug269362TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}