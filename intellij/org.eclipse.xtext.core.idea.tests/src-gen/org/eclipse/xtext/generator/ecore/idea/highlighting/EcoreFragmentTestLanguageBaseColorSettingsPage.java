package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EcoreFragmentTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EcoreFragmentTestLanguageBaseColorSettingsPage() {
		EcoreFragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EcoreFragmentTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EcoreFragmentTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EcoreFragmentTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EcoreFragmentTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EcoreFragmentTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}