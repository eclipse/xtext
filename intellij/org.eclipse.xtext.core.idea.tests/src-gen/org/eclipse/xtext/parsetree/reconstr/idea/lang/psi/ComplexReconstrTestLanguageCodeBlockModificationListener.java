package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.ComplexReconstrTestLanguageLanguage;

public class ComplexReconstrTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ComplexReconstrTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ComplexReconstrTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
