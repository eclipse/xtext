package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LookaheadTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LookaheadTestLanguageBaseColorSettingsPage() {
		LookaheadTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LookaheadTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LookaheadTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LookaheadTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LookaheadTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LookaheadTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}