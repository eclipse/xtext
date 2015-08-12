package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class LiveContainerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public LiveContainerTestLanguageBaseColorSettingsPage() {
		LiveContainerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return LiveContainerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
