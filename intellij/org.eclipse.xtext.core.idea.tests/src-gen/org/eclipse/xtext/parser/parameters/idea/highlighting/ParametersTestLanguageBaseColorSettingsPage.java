package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ParametersTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ParametersTestLanguageBaseColorSettingsPage() {
		ParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ParametersTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
