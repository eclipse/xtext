package org.eclipse.xtext.parser.fragments.idea.highlighting;

import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class FragmentTestLanguageExBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public FragmentTestLanguageExBaseColorSettingsPage() {
		FragmentTestLanguageExLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return FragmentTestLanguageExLanguage.INSTANCE.getDisplayName();
	}
}
