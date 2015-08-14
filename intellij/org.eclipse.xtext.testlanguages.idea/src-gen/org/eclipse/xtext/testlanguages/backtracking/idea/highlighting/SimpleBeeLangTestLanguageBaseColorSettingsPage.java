package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SimpleBeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SimpleBeeLangTestLanguageBaseColorSettingsPage() {
		SimpleBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SimpleBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
