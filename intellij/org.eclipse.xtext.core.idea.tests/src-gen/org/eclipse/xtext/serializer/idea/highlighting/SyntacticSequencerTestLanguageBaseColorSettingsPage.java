package org.eclipse.xtext.serializer.idea.highlighting;

import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SyntacticSequencerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SyntacticSequencerTestLanguageBaseColorSettingsPage() {
		SyntacticSequencerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SyntacticSequencerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SyntacticSequencerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SyntacticSequencerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SyntacticSequencerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SyntacticSequencerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}