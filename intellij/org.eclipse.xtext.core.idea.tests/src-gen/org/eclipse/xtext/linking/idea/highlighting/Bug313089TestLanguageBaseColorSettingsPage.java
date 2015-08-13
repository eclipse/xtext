package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug313089TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug313089TestLanguageBaseColorSettingsPage() {
		Bug313089TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug313089TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
