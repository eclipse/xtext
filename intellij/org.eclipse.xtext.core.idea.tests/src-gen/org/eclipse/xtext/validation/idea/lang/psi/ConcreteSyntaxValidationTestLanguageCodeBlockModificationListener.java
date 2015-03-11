package org.eclipse.xtext.validation.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

public class ConcreteSyntaxValidationTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ConcreteSyntaxValidationTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
