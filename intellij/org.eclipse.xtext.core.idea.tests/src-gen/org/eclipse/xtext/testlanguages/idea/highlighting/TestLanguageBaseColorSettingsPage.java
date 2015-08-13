package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public TestLanguageBaseColorSettingsPage() {
		TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
