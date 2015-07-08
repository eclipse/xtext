package org.eclipse.xtext.dummy.idea.highlighting;

import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class DummyTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public DummyTestLanguageBaseColorSettingsPage() {
		DummyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", DummyTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", DummyTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", DummyTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", DummyTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return DummyTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}