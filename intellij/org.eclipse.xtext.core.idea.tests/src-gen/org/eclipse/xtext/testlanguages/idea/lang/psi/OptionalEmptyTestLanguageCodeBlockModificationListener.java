package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.OptionalEmptyTestLanguageLanguage;

public class OptionalEmptyTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public OptionalEmptyTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(OptionalEmptyTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
