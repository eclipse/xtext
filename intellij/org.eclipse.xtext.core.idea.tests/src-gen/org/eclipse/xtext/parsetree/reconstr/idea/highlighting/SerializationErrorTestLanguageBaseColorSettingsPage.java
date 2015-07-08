package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SerializationErrorTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SerializationErrorTestLanguageBaseColorSettingsPage() {
		SerializationErrorTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SerializationErrorTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SerializationErrorTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SerializationErrorTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SerializationErrorTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SerializationErrorTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}