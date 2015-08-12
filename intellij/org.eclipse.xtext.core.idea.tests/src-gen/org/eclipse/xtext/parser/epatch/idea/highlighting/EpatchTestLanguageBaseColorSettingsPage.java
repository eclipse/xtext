package org.eclipse.xtext.parser.epatch.idea.highlighting;

import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EpatchTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EpatchTestLanguageBaseColorSettingsPage() {
		EpatchTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EpatchTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
