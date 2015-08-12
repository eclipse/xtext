package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class PartialSerializationTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public PartialSerializationTestLanguageBaseColorSettingsPage() {
		PartialSerializationTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return PartialSerializationTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
