package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class BeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public BeeLangTestLanguageBaseColorSettingsPage() {
		BeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return BeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
