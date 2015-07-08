package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SubTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SubTestLanguageBaseColorSettingsPage() {
		SubTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SubTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SubTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SubTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SubTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SubTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}