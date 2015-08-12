package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug302128TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug302128TestLanguageBaseColorSettingsPage() {
		Bug302128TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug302128TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
