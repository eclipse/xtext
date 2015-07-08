package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;

import com.intellij.openapi.options.colors.AttributesDescriptor;

public class TerminalRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	private AttributesDescriptor[] descriptors;

	public TerminalRulesTestLanguageBaseColorSettingsPage() {
		TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public AttributesDescriptor[] getAttributeDescriptors() {
		if (descriptors == null) {
			this.descriptors = new AttributesDescriptor[] {
					createDescriptor("Keywords", TerminalRulesTestLanguageHighlightingConfiguration.KEYWORD),
					createDescriptor("Numbers", TerminalRulesTestLanguageHighlightingConfiguration.NUMBER),
					createDescriptor("Comments", TerminalRulesTestLanguageHighlightingConfiguration.COMMENT),
					createDescriptor("Strings", TerminalRulesTestLanguageHighlightingConfiguration.STRING) };
		}
		return this.descriptors;
	}

	@Override
	public String getDisplayName() {
		return TerminalRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}