package org.eclipse.xtext.idea.sdomain.idea.highlighting;

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class SDomainBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public SDomainBaseColorSettingsPage() {
		SDomainLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return SDomainLanguage.INSTANCE.getDisplayName();
	}
}
