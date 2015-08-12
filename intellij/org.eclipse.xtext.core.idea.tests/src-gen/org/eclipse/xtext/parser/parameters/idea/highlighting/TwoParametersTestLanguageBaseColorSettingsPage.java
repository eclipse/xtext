package org.eclipse.xtext.parser.parameters.idea.highlighting;

import org.eclipse.xtext.parser.parameters.idea.lang.TwoParametersTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class TwoParametersTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public TwoParametersTestLanguageBaseColorSettingsPage() {
		TwoParametersTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return TwoParametersTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
