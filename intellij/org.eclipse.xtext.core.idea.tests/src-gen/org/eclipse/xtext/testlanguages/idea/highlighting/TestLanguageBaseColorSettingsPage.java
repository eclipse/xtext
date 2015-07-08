package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public TestLanguageBaseColorSettingsPage() {
		TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}