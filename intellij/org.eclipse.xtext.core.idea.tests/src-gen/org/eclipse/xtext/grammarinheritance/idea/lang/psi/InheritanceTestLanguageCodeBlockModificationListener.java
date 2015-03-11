package org.eclipse.xtext.grammarinheritance.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.grammarinheritance.idea.lang.InheritanceTestLanguageLanguage;

public class InheritanceTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public InheritanceTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(InheritanceTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
