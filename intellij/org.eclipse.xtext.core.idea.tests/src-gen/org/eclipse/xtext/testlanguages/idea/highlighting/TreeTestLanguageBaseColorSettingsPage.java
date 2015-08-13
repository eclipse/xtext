package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class TreeTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public TreeTestLanguageBaseColorSettingsPage() {
		TreeTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return TreeTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
