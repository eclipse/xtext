package org.eclipse.xtext.enumrules.idea.highlighting;

import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EnumAndReferenceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EnumAndReferenceTestLanguageBaseColorSettingsPage() {
		EnumAndReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EnumAndReferenceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
