package org.eclipse.xtext.testlanguages.idea.highlighting;

import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class PartialParserTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public PartialParserTestLanguageBaseColorSettingsPage() {
		PartialParserTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return PartialParserTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
