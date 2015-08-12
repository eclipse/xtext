package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.EnumRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EnumRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EnumRulesTestLanguageBaseColorSettingsPage() {
		EnumRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EnumRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
