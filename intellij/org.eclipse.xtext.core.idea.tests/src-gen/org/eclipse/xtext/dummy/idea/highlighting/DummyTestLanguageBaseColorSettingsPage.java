package org.eclipse.xtext.dummy.idea.highlighting;

import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class DummyTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public DummyTestLanguageBaseColorSettingsPage() {
		DummyTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return DummyTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
