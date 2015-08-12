package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ReferenceGrammarTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ReferenceGrammarTestLanguageBaseColorSettingsPage() {
		ReferenceGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ReferenceGrammarTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
