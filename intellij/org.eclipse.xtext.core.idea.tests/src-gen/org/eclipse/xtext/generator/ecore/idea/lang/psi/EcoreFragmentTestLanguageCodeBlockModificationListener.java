package org.eclipse.xtext.generator.ecore.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.generator.ecore.idea.lang.EcoreFragmentTestLanguageLanguage;

public class EcoreFragmentTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EcoreFragmentTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EcoreFragmentTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
