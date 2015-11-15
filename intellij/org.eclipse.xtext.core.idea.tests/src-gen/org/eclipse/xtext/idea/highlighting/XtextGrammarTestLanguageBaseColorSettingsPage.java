package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class XtextGrammarTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public XtextGrammarTestLanguageBaseColorSettingsPage() {
		XtextGrammarTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return XtextGrammarTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
