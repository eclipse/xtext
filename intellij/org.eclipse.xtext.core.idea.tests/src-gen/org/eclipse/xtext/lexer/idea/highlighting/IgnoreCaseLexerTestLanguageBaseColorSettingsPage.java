package org.eclipse.xtext.lexer.idea.highlighting;

import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class IgnoreCaseLexerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public IgnoreCaseLexerTestLanguageBaseColorSettingsPage() {
		IgnoreCaseLexerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return IgnoreCaseLexerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
