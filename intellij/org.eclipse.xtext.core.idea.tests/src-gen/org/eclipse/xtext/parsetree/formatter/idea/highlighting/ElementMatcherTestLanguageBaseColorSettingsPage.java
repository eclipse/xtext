package org.eclipse.xtext.parsetree.formatter.idea.highlighting;

import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ElementMatcherTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ElementMatcherTestLanguageBaseColorSettingsPage() {
		ElementMatcherTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ElementMatcherTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ElementMatcherTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ElementMatcherTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ElementMatcherTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ElementMatcherTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}