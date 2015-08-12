package org.eclipse.xtext.testlanguages.indent.idea.highlighting;

import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class IndentationAwareTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public IndentationAwareTestLanguageBaseColorSettingsPage() {
		IndentationAwareTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return IndentationAwareTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
