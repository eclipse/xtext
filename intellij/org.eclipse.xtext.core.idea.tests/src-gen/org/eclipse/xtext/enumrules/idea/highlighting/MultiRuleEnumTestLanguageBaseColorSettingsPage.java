package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class MultiRuleEnumTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public MultiRuleEnumTestLanguageBaseColorSettingsPage() {
		MultiRuleEnumTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return MultiRuleEnumTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
