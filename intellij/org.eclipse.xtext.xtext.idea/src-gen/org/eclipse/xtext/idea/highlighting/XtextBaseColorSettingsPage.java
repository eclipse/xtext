package org.eclipse.xtext.idea.highlighting;

import org.eclipse.xtext.idea.lang.XtextLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class XtextBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public XtextBaseColorSettingsPage() {
		XtextLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return XtextLanguage.INSTANCE.getDisplayName();
	}
}
