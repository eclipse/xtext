package org.eclipse.xtext.linking.idea.highlighting;

import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class IgnoreCaseImportsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public IgnoreCaseImportsTestLanguageBaseColorSettingsPage() {
		IgnoreCaseImportsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return IgnoreCaseImportsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
