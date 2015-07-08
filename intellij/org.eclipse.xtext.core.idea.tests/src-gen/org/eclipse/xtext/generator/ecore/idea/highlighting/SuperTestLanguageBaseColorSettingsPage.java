package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SuperTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SuperTestLanguageBaseColorSettingsPage() {
		SuperTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SuperTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SuperTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SuperTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SuperTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SuperTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}