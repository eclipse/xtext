package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug296889TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug296889TestLanguageBaseColorSettingsPage() {
		Bug296889TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug296889TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
