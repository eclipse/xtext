package org.eclipse.xtext.generator.grammarAccess.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.generator.grammarAccess.idea.lang.GrammarAccessTestLanguageLanguage;

public class GrammarAccessTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public GrammarAccessTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(GrammarAccessTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
