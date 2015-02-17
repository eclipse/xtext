package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.Bug297105TestLanguageLanguage;

public class Bug297105TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug297105TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug297105TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
