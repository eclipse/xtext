package org.eclipse.xtext.idea.common.types.idea.highlighting;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class RefactoringTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public RefactoringTestLanguageBaseColorSettingsPage() {
		RefactoringTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return RefactoringTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
