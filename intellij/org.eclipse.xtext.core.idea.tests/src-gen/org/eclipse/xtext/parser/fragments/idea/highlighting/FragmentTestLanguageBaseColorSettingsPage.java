package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class FragmentTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public FragmentTestLanguageBaseColorSettingsPage() {
		FragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return FragmentTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
