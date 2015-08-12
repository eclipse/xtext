package org.eclipse.xtext.parser.bug419429.idea.highlighting;

import org.eclipse.xtext.parser.bug419429.idea.lang.Bug419429Language;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class Bug419429BaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public Bug419429BaseColorSettingsPage() {
		Bug419429Language.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return Bug419429Language.INSTANCE.getDisplayName();
	}
}
