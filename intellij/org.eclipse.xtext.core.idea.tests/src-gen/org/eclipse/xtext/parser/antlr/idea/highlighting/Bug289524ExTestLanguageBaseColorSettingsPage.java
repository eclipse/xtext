package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug289524ExTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug289524ExTestLanguageBaseColorSettingsPage() {
		Bug289524ExTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug289524ExTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
