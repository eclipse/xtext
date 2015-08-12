package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class HiddenTokensMergerTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public HiddenTokensMergerTestLanguageBaseColorSettingsPage() {
		HiddenTokensMergerTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return HiddenTokensMergerTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
