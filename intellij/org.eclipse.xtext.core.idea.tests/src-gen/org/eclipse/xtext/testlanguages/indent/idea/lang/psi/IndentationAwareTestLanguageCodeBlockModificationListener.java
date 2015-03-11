package org.eclipse.xtext.testlanguages.indent.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.indent.idea.lang.IndentationAwareTestLanguageLanguage;

public class IndentationAwareTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public IndentationAwareTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(IndentationAwareTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
