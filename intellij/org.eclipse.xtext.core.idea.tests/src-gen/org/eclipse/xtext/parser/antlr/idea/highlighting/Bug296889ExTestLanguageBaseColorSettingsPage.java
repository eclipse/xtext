package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug296889ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug296889ExTestLanguageBaseColorSettingsPage() {
		Bug296889ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug296889ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
