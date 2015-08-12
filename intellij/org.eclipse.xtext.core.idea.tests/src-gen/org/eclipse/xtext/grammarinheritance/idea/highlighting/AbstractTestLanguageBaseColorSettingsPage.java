package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class AbstractTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public AbstractTestLanguageBaseColorSettingsPage() {
		AbstractTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return AbstractTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
