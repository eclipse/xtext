package org.eclipse.xtext.parsetree.unassignedtext.idea.highlighting;

import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class UnassignedTextTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public UnassignedTextTestLanguageBaseColorSettingsPage() {
		UnassignedTextTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return UnassignedTextTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
