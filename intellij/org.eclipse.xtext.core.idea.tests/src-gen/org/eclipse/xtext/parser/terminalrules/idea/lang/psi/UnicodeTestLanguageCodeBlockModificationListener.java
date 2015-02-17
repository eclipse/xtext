package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.UnicodeTestLanguageLanguage;

public class UnicodeTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public UnicodeTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(UnicodeTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
