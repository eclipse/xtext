package org.eclipse.xtext.xtext.ecoreInference.idea.highlighting;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class MultiValueFeatureTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public MultiValueFeatureTestLanguageBaseColorSettingsPage() {
		MultiValueFeatureTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", MultiValueFeatureTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", MultiValueFeatureTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", MultiValueFeatureTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", MultiValueFeatureTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return MultiValueFeatureTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}