package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class InheritanceTest2LanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public InheritanceTest2LanguageBaseColorSettingsPage() {
		InheritanceTest2LanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", InheritanceTest2LanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", InheritanceTest2LanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", InheritanceTest2LanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", InheritanceTest2LanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return InheritanceTest2LanguageLanguage.INSTANCE.getDisplayName();
	}
}