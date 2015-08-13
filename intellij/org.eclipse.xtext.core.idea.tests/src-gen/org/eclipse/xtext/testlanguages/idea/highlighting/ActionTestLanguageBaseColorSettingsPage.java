package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ActionTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ActionTestLanguageBaseColorSettingsPage() {
		ActionTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ActionTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
