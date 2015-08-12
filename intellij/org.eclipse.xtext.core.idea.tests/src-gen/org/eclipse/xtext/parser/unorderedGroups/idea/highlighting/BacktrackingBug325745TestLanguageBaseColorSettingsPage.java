package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class BacktrackingBug325745TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public BacktrackingBug325745TestLanguageBaseColorSettingsPage() {
		BacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return BacktrackingBug325745TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
