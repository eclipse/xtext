package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug301935TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug301935TestLanguageBaseColorSettingsPage() {
		Bug301935TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug301935TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
