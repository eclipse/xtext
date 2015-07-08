package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class TreeTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public TreeTestLanguageBaseColorSettingsPage() {
		TreeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", TreeTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", TreeTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", TreeTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", TreeTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return TreeTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}