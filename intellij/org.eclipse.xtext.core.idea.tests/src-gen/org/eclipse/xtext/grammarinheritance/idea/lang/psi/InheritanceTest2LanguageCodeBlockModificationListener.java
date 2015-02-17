package org.eclipse.xtext.grammarinheritance.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest2LanguageLanguage;

public class InheritanceTest2LanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public InheritanceTest2LanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(InheritanceTest2LanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
