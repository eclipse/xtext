package org.eclipse.xtext.parsetree.formatter.idea.highlighting;

import org.eclipse.xtext.parsetree.formatter.idea.lang.FormatterTestLanguageLanguage;
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
