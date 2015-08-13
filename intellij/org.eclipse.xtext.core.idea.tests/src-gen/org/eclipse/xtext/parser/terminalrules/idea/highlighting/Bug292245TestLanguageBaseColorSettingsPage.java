package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug292245TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug292245TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug292245TestLanguageBaseColorSettingsPage() {
		Bug292245TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug292245TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
