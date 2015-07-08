package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class UnorderedGroupsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public UnorderedGroupsTestLanguageBaseColorSettingsPage() {
		UnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", UnorderedGroupsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", UnorderedGroupsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", UnorderedGroupsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", UnorderedGroupsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return UnorderedGroupsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}