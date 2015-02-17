package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;

public class SimpleExpressionsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SimpleExpressionsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SimpleExpressionsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
