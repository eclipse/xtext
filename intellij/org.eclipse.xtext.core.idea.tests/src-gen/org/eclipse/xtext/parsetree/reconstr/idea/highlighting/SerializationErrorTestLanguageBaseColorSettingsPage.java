package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationErrorTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SerializationErrorTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SerializationErrorTestLanguageBaseColorSettingsPage() {
		SerializationErrorTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SerializationErrorTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
