package org.eclipse.xtext.linking.lazy.idea.highlighting;

import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LazyLinkingTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LazyLinkingTestLanguageBaseColorSettingsPage() {
		LazyLinkingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LazyLinkingTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LazyLinkingTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LazyLinkingTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LazyLinkingTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LazyLinkingTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}