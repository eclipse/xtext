package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class LangATestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public LangATestLanguageBaseColorSettingsPage() {
		LangATestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return LangATestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
