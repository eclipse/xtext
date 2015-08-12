package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.EcoreTerminalsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EcoreTerminalsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EcoreTerminalsTestLanguageBaseColorSettingsPage() {
		EcoreTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EcoreTerminalsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
