package org.eclipse.xtend.core.idea.highlighting;

import org.eclipse.xtend.core.idea.lang.XtendLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class XtendBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public XtendBaseColorSettingsPage() {
		XtendLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return XtendLanguage.INSTANCE.getDisplayName();
	}
}
