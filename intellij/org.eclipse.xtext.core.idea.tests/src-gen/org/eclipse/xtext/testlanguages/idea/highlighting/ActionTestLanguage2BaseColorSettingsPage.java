package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ActionTestLanguage2BaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ActionTestLanguage2BaseColorSettingsPage() {
		ActionTestLanguage2Language.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ActionTestLanguage2Language.INSTANCE.getDisplayName();
	}
}
