package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.Bug287988TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug287988TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug287988TestLanguageBaseColorSettingsPage() {
		Bug287988TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug287988TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
