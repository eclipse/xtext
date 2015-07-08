package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ExBacktrackingBug325745TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ExBacktrackingBug325745TestLanguageBaseColorSettingsPage() {
		ExBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ExBacktrackingBug325745TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ExBacktrackingBug325745TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ExBacktrackingBug325745TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ExBacktrackingBug325745TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ExBacktrackingBug325745TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}