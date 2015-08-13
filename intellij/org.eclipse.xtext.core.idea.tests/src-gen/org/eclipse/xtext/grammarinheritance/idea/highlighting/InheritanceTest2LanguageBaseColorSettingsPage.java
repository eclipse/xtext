package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class InheritanceTest2LanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public InheritanceTest2LanguageBaseColorSettingsPage() {
		InheritanceTest2LanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return InheritanceTest2LanguageLanguage.INSTANCE.getDisplayName();
	}
}
