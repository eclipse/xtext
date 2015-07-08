package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class LocationProviderTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public LocationProviderTestLanguageBaseColorSettingsPage() {
		LocationProviderTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", LocationProviderTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", LocationProviderTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", LocationProviderTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", LocationProviderTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return LocationProviderTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}