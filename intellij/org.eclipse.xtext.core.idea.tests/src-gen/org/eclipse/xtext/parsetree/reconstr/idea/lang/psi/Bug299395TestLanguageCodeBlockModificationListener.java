package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug299395TestLanguageLanguage;

public class Bug299395TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug299395TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug299395TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
