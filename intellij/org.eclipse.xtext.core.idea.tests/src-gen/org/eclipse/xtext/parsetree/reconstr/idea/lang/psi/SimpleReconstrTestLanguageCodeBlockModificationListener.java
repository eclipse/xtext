package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SimpleReconstrTestLanguageLanguage;

public class SimpleReconstrTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SimpleReconstrTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SimpleReconstrTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
