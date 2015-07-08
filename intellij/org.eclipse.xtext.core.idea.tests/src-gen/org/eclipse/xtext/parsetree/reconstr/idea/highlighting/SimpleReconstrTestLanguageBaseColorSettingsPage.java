package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class SimpleReconstrTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public SimpleReconstrTestLanguageBaseColorSettingsPage() {
		SimpleReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", SimpleReconstrTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", SimpleReconstrTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", SimpleReconstrTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", SimpleReconstrTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return SimpleReconstrTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}