package org.eclipse.xtext.index.idea.highlighting;

import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class IndexTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public IndexTestLanguageBaseColorSettingsPage() {
		IndexTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", IndexTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", IndexTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", IndexTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", IndexTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return IndexTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}