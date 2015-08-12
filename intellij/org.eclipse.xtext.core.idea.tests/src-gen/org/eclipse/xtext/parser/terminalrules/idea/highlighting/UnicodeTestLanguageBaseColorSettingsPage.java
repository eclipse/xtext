package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class UnicodeTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public UnicodeTestLanguageBaseColorSettingsPage() {
		UnicodeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return UnicodeTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
