package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class HiddenTerminalsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public HiddenTerminalsTestLanguageBaseColorSettingsPage() {
		HiddenTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", HiddenTerminalsTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", HiddenTerminalsTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", HiddenTerminalsTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", HiddenTerminalsTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return HiddenTerminalsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}