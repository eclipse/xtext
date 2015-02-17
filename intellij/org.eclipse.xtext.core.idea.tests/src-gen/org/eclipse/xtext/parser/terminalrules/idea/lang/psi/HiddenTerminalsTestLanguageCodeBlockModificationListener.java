package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.HiddenTerminalsTestLanguageLanguage;

public class HiddenTerminalsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public HiddenTerminalsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(HiddenTerminalsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
