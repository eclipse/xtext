package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

public class HiddenTerminalsTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public HiddenTerminalsTestLanguageElementDescriptionProvider() {
		super(HiddenTerminalsTestLanguageLanguage.INSTANCE);
	}

}
