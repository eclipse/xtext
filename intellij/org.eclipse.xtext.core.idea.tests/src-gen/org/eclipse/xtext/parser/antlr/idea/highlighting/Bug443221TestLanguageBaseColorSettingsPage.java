package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug443221TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug443221TestLanguageBaseColorSettingsPage() {
		Bug443221TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug443221TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
