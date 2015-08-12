package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class InheritanceTest3LanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public InheritanceTest3LanguageBaseColorSettingsPage() {
		InheritanceTest3LanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return InheritanceTest3LanguageLanguage.INSTANCE.getDisplayName();
	}
}
