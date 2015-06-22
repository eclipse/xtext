package org.eclipse.xtext.parser.terminalrules.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class HiddenTerminalsTestLanguageLanguage extends AbstractXtextLanguage {

	public static final HiddenTerminalsTestLanguageLanguage INSTANCE = new HiddenTerminalsTestLanguageLanguage();

	private HiddenTerminalsTestLanguageLanguage() {
		super("org.eclipse.xtext.parser.terminalrules.HiddenTerminalsTestLanguage");
	}

}
