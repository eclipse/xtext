package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleBacktrackingBug325745TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleBacktrackingBug325745TestLanguageBaseColorSettingsPage() {
		SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleBacktrackingBug325745TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SimpleBacktrackingBug325745TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SimpleBacktrackingBug325745TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SimpleBacktrackingBug325745TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}