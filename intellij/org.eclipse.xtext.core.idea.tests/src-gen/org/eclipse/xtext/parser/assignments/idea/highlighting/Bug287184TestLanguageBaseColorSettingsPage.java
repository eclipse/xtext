package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug287184TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug287184TestLanguageBaseColorSettingsPage() {
		Bug287184TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug287184TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
