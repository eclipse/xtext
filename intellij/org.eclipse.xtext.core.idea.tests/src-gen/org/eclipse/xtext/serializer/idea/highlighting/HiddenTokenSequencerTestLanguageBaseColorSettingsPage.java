package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class HiddenTokenSequencerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public HiddenTokenSequencerTestLanguageBaseColorSettingsPage() {
		HiddenTokenSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", HiddenTokenSequencerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", HiddenTokenSequencerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", HiddenTokenSequencerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", HiddenTokenSequencerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return HiddenTokenSequencerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}