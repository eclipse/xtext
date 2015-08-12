package org.eclipse.xtext.resource.idea.highlighting;

import org.eclipse.xtext.resource.idea.lang.Bug385636Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug385636BaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug385636BaseColorSettingsPage() {
		Bug385636Language.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug385636Language.INSTANCE.getDisplayName();
	}
}
