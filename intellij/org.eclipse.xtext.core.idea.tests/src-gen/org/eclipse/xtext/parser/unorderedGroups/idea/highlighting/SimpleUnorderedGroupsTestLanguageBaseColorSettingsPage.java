package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleUnorderedGroupsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleUnorderedGroupsTestLanguageBaseColorSettingsPage() {
		SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleUnorderedGroupsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SimpleUnorderedGroupsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SimpleUnorderedGroupsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SimpleUnorderedGroupsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}