package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class TerminalRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public TerminalRulesTestLanguageBaseColorSettingsPage() {
		TerminalRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return TerminalRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
