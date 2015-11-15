package org.eclipse.xtext.generator.ecore.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.generator.ecore.idea.lang.SuperTestLanguageLanguage;

public class SuperTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SuperTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SuperTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
