package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SimpleReconstrTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SimpleReconstrTestLanguageBaseColorSettingsPage() {
		SimpleReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SimpleReconstrTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
