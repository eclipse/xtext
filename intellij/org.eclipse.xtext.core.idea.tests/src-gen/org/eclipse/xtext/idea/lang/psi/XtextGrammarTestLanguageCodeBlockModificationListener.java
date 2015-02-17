package org.eclipse.xtext.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.idea.lang.XtextGrammarTestLanguageLanguage;

public class XtextGrammarTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtextGrammarTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtextGrammarTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
