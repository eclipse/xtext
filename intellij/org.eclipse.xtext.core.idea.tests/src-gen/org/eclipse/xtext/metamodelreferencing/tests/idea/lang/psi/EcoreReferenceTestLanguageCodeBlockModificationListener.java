package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

public class EcoreReferenceTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EcoreReferenceTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EcoreReferenceTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
