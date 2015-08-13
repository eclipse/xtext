package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug289515TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug289515TestLanguageBaseColorSettingsPage() {
		Bug289515TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug289515TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
