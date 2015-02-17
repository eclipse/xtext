package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

public class LookaheadTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LookaheadTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LookaheadTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
