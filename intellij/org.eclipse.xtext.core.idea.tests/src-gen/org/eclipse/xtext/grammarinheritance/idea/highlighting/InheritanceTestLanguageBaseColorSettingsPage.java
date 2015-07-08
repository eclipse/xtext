package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class InheritanceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public InheritanceTestLanguageBaseColorSettingsPage() {
		InheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", InheritanceTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", InheritanceTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", InheritanceTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", InheritanceTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return InheritanceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}