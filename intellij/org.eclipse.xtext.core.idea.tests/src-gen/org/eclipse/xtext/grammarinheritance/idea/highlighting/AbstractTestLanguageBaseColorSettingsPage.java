package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class AbstractTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public AbstractTestLanguageBaseColorSettingsPage() {
		AbstractTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", AbstractTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", AbstractTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", AbstractTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", AbstractTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return AbstractTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}