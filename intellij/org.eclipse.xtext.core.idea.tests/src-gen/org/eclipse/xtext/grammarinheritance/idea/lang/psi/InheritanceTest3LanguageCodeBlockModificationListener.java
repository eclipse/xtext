package org.eclipse.xtext.grammarinheritance.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTest3LanguageLanguage;

public class InheritanceTest3LanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public InheritanceTest3LanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(InheritanceTest3LanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
