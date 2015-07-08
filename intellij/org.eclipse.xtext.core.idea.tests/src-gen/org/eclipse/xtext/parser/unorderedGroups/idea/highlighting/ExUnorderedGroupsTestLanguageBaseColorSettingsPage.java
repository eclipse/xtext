package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExUnorderedGroupsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ExUnorderedGroupsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ExUnorderedGroupsTestLanguageBaseColorSettingsPage() {
		ExUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ExUnorderedGroupsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ExUnorderedGroupsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ExUnorderedGroupsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ExUnorderedGroupsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ExUnorderedGroupsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}