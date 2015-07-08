package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class BaseInheritanceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public BaseInheritanceTestLanguageBaseColorSettingsPage() {
		BaseInheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", BaseInheritanceTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", BaseInheritanceTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", BaseInheritanceTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", BaseInheritanceTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return BaseInheritanceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}