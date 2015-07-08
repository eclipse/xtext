package org.eclipse.xtext.parser.epatch.idea.highlighting;

import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EpatchTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EpatchTestLanguageBaseColorSettingsPage() {
		EpatchTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EpatchTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EpatchTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EpatchTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EpatchTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EpatchTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}