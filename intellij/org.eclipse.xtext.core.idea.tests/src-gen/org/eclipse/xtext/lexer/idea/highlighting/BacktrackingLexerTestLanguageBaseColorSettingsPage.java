package org.eclipse.xtext.lexer.idea.highlighting;

import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class BacktrackingLexerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public BacktrackingLexerTestLanguageBaseColorSettingsPage() {
		BacktrackingLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return BacktrackingLexerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
