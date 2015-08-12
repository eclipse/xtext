package org.eclipse.xtext.parsetree.transientvalues.idea.highlighting;

import org.eclipse.xtext.parsetree.transientvalues.idea.lang.TransientValuesTestLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class TransientValuesTestBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public TransientValuesTestBaseColorSettingsPage() {
		TransientValuesTestLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return TransientValuesTestLanguage.INSTANCE.getDisplayName();
	}
}
