package org.eclipse.xtext.parsetree.reconstr.idea.highlighting;

import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class ComplexReconstrTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public ComplexReconstrTestLanguageBaseColorSettingsPage() {
		ComplexReconstrTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return ComplexReconstrTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
