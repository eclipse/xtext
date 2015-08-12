package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug301935ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug301935ExTestLanguageBaseColorSettingsPage() {
		Bug301935ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug301935ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
