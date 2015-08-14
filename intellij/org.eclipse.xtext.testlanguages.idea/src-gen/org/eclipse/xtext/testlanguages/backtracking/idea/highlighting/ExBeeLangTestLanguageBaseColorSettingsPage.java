package org.eclipse.xtext.testlanguages.backtracking.idea.highlighting;

import org.eclipse.xtext.testlanguages.backtracking.idea.lang.ExBeeLangTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ExBeeLangTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ExBeeLangTestLanguageBaseColorSettingsPage() {
		ExBeeLangTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ExBeeLangTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
