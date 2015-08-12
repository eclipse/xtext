package org.eclipse.xtext.generator.grammarAccess.idea.highlighting;

import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class GrammarAccessTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public GrammarAccessTestLanguageBaseColorSettingsPage() {
		GrammarAccessTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return GrammarAccessTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
