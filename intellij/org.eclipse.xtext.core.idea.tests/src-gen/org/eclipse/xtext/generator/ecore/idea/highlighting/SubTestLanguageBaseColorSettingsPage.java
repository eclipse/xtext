package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SubTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SubTestLanguageBaseColorSettingsPage() {
		SubTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SubTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
