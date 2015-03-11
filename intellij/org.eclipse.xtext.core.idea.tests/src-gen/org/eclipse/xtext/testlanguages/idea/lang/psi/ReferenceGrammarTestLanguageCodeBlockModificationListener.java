package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.ReferenceGrammarTestLanguageLanguage;

public class ReferenceGrammarTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ReferenceGrammarTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ReferenceGrammarTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
