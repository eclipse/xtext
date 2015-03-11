package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;

public class Bug302128TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug302128TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug302128TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
