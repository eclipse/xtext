package org.eclipse.xtext.purexbase.idea.highlighting;

import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class PureXbaseBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public PureXbaseBaseColorSettingsPage() {
		PureXbaseLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return PureXbaseLanguage.INSTANCE.getDisplayName();
	}
}
