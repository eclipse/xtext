package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class FowlerDslTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public FowlerDslTestLanguageBaseColorSettingsPage() {
		FowlerDslTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", FowlerDslTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", FowlerDslTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", FowlerDslTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", FowlerDslTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return FowlerDslTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}