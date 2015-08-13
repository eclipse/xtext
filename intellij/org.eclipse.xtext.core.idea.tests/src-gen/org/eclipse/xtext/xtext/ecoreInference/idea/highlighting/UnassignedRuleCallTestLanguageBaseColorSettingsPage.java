package org.eclipse.xtext.xtext.ecoreInference.idea.highlighting;

import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class UnassignedRuleCallTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public UnassignedRuleCallTestLanguageBaseColorSettingsPage() {
		UnassignedRuleCallTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return UnassignedRuleCallTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
