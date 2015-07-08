package org.eclipse.xtext.parsetree.unassignedtext.idea.highlighting;

import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class UnassignedTextTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public UnassignedTextTestLanguageBaseColorSettingsPage() {
		UnassignedTextTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", UnassignedTextTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", UnassignedTextTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", UnassignedTextTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", UnassignedTextTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return UnassignedTextTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}