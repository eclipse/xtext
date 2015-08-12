package org.eclipse.xtext.parser.keywords.idea.highlighting;

import org.eclipse.xtext.parser.keywords.idea.lang.KeywordsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class KeywordsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public KeywordsTestLanguageBaseColorSettingsPage() {
		KeywordsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return KeywordsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
