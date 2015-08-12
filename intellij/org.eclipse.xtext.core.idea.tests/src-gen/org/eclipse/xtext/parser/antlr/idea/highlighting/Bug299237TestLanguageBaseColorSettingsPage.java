package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug299237TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug299237TestLanguageBaseColorSettingsPage() {
		Bug299237TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug299237TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
