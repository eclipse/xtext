package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class HiddenTokensMergerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public HiddenTokensMergerTestLanguageBaseColorSettingsPage() {
		HiddenTokensMergerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", HiddenTokensMergerTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", HiddenTokensMergerTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", HiddenTokensMergerTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", HiddenTokensMergerTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return HiddenTokensMergerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}