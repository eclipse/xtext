package org.eclipse.xtext.valueconverter.idea.highlighting;

import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug250313BaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug250313BaseColorSettingsPage() {
		Bug250313Language.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug250313Language.INSTANCE.getDisplayName();
	}
}
