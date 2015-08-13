package org.eclipse.xtext.generator.ecore.idea.highlighting;

import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EcoreFragmentTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EcoreFragmentTestLanguageBaseColorSettingsPage() {
		EcoreFragmentTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EcoreFragmentTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
