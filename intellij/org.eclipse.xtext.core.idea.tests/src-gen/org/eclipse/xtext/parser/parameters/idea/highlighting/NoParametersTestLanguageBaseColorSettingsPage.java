package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.parser.parameters.idea.lang.NoParametersTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class NoParametersTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public NoParametersTestLanguageBaseColorSettingsPage() {
		NoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return NoParametersTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
