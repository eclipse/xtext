package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EObjectAtOffsetTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EObjectAtOffsetTestLanguageBaseColorSettingsPage() {
		EObjectAtOffsetTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EObjectAtOffsetTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EObjectAtOffsetTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EObjectAtOffsetTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EObjectAtOffsetTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EObjectAtOffsetTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}