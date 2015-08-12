package org.eclipse.xtext.formatting2.internal.idea.highlighting;

import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class FormatterTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public FormatterTestLanguageBaseColorSettingsPage() {
		FormatterTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return FormatterTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
