package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class OptionalEmptyTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public OptionalEmptyTestLanguageBaseColorSettingsPage() {
		OptionalEmptyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return OptionalEmptyTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
