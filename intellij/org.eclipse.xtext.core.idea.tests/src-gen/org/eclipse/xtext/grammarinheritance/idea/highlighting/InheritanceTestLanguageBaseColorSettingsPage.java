package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class InheritanceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public InheritanceTestLanguageBaseColorSettingsPage() {
		InheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return InheritanceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
