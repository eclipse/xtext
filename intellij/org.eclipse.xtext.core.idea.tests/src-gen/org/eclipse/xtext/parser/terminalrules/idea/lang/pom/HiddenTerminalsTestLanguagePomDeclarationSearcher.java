package org.eclipse.xtext.parser.terminalrules.idea.lang.pom;

import org.eclipse.xtext.idea.pom.AbstractXtextPomDeclarationSearcher;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

public class HiddenTerminalsTestLanguagePomDeclarationSearcher extends AbstractXtextPomDeclarationSearcher {

	public HiddenTerminalsTestLanguagePomDeclarationSearcher() {
		super(HiddenTerminalsTestLanguageLanguage.INSTANCE);
	}

}
