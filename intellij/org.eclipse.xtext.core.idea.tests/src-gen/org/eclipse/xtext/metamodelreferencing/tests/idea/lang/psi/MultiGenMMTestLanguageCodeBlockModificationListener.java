package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

public class MultiGenMMTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public MultiGenMMTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(MultiGenMMTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
