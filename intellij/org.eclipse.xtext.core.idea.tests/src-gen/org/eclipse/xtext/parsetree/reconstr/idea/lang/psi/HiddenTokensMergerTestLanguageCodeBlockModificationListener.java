package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.HiddenTokensMergerTestLanguageLanguage;

public class HiddenTokensMergerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public HiddenTokensMergerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(HiddenTokensMergerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
