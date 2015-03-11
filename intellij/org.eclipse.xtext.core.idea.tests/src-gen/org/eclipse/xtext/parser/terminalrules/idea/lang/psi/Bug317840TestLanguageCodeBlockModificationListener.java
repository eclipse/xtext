package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug317840TestLanguageLanguage;

public class Bug317840TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug317840TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug317840TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
