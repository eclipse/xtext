package org.eclipse.xtext.parser.encoding.idea.highlighting;

import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EncodingTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EncodingTestLanguageBaseColorSettingsPage() {
		EncodingTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EncodingTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
