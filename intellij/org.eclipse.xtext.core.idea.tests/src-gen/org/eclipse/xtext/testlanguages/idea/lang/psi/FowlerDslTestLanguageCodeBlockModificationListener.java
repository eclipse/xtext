package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

public class FowlerDslTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public FowlerDslTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(FowlerDslTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
