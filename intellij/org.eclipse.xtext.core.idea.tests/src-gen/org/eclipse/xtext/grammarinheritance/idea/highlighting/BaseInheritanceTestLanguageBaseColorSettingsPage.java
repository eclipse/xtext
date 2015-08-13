package org.eclipse.xtext.grammarinheritance.idea.highlighting;

import org.eclipse.xtext.grammarinheritance.idea.lang.BaseInheritanceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class BaseInheritanceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public BaseInheritanceTestLanguageBaseColorSettingsPage() {
		BaseInheritanceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return BaseInheritanceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
