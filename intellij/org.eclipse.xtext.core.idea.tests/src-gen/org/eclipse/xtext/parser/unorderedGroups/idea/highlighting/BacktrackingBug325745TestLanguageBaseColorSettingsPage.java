package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class BacktrackingBug325745TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public BacktrackingBug325745TestLanguageBaseColorSettingsPage() {
		BacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", BacktrackingBug325745TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", BacktrackingBug325745TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", BacktrackingBug325745TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", BacktrackingBug325745TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return BacktrackingBug325745TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}