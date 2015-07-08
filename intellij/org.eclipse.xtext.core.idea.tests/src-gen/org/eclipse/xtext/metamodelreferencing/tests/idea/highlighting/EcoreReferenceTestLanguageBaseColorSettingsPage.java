package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class EcoreReferenceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public EcoreReferenceTestLanguageBaseColorSettingsPage() {
		EcoreReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", EcoreReferenceTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", EcoreReferenceTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", EcoreReferenceTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", EcoreReferenceTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return EcoreReferenceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}