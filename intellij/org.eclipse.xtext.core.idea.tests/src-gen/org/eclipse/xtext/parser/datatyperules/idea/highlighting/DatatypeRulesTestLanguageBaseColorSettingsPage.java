package org.eclipse.xtext.parser.datatyperules.idea.highlighting;

import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class DatatypeRulesTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public DatatypeRulesTestLanguageBaseColorSettingsPage() {
		DatatypeRulesTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return DatatypeRulesTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
