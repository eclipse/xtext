package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.TerminalRulesTestLanguageLanguage;

public class TerminalRulesTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public TerminalRulesTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(TerminalRulesTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
