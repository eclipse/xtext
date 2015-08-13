package org.eclipse.xtext.metamodelreferencing.tests.idea.highlighting;

import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class EcoreReferenceTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public EcoreReferenceTestLanguageBaseColorSettingsPage() {
		EcoreReferenceTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return EcoreReferenceTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
