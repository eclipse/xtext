package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug299395TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug299395TestLanguageBaseColorSettingsPage() {
		Bug299395TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug299395TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
