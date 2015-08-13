package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SerializationBug269362TestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SerializationBug269362TestLanguageBaseColorSettingsPage() {
		SerializationBug269362TestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SerializationBug269362TestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
