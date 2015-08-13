package org.eclipse.xtext.parser.unorderedGroups.idea.highlighting;

import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SimpleBacktrackingBug325745TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SimpleBacktrackingBug325745TestLanguageBaseColorSettingsPage() {
		SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
