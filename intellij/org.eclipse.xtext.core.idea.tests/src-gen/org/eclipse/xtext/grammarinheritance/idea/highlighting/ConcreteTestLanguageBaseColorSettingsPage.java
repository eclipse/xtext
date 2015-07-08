package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ConcreteTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ConcreteTestLanguageBaseColorSettingsPage() {
		ConcreteTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ConcreteTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ConcreteTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ConcreteTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ConcreteTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ConcreteTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}