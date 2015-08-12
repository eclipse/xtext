package org.eclipse.xtext.parser.terminalrules.idea.highlighting;

import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;
import org.eclipse.xtext.idea.highlighting.AbstractColorSettingsPage;


public class XtextTerminalsTestLanguageBaseColorSettingsPage extends AbstractColorSettingsPage {
	
	public XtextTerminalsTestLanguageBaseColorSettingsPage() {
		XtextTerminalsTestLanguageLanguage.INSTANCE.injectMembers(this);
	}

	@Override
	public String getDisplayName() {
		return XtextTerminalsTestLanguageLanguage.INSTANCE.getDisplayName();
	}
}
