package org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.UnassignedRuleCallTestLanguageLanguage;

public class UnassignedRuleCallTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public UnassignedRuleCallTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(UnassignedRuleCallTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
