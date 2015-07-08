package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class ComplexReconstrTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public ComplexReconstrTestLanguageBaseColorSettingsPage() {
		ComplexReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", ComplexReconstrTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", ComplexReconstrTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", ComplexReconstrTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", ComplexReconstrTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return ComplexReconstrTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}