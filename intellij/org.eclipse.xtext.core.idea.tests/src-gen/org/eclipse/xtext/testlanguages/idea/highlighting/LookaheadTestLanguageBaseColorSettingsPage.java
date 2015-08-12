package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class LookaheadTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public LookaheadTestLanguageBaseColorSettingsPage() {
		LookaheadTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return LookaheadTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
