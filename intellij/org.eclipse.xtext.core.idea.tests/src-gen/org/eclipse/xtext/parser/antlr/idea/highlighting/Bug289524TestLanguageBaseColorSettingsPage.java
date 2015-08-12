package org.eclipse.xtext.parser.antlr.idea.highlighting;

import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug289524TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug289524TestLanguageBaseColorSettingsPage() {
		Bug289524TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug289524TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
