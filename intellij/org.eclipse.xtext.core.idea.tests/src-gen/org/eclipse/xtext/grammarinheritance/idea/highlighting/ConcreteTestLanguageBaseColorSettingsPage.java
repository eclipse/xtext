package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.ConcreteTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ConcreteTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ConcreteTestLanguageBaseColorSettingsPage() {
		ConcreteTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ConcreteTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
