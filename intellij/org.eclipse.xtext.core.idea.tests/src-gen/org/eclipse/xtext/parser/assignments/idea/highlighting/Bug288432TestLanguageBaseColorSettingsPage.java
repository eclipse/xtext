package org.eclipse.xtext.parser.assignments.idea.highlighting;

import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug288432TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug288432TestLanguageBaseColorSettingsPage() {
		Bug288432TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug288432TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
