package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SequencerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SequencerTestLanguageBaseColorSettingsPage() {
		SequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SequencerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SequencerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SequencerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SequencerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SequencerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}