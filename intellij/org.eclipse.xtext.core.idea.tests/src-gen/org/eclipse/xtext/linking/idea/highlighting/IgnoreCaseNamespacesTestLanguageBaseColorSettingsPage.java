package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class IgnoreCaseNamespacesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public IgnoreCaseNamespacesTestLanguageBaseColorSettingsPage() {
		IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", IgnoreCaseNamespacesTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", IgnoreCaseNamespacesTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", IgnoreCaseNamespacesTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", IgnoreCaseNamespacesTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}