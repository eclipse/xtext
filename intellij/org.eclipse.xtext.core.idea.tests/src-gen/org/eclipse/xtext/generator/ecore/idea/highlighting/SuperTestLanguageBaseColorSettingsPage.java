package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SuperTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SuperTestLanguageBaseColorSettingsPage() {
		SuperTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SuperTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
