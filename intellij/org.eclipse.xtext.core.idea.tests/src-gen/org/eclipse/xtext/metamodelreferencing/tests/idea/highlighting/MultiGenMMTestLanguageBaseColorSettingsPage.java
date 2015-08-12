package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class MultiGenMMTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public MultiGenMMTestLanguageBaseColorSettingsPage() {
		MultiGenMMTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return MultiGenMMTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
