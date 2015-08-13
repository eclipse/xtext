package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug297105TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug297105TestLanguageBaseColorSettingsPage() {
		Bug297105TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug297105TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
