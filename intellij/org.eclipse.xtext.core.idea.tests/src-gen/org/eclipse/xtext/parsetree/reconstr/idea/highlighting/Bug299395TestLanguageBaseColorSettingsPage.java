package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class Bug299395TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public Bug299395TestLanguageBaseColorSettingsPage() {
		Bug299395TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", Bug299395TestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", Bug299395TestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", Bug299395TestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", Bug299395TestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return Bug299395TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}