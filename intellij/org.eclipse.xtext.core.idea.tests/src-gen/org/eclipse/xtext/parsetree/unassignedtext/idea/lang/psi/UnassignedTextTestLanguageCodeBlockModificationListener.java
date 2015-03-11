package org.eclipse.xtext.parsetree.unassignedtext.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.unassignedtext.idea.lang.UnassignedTextTestLanguageLanguage;

public class UnassignedTextTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public UnassignedTextTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(UnassignedTextTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
