package org.eclipse.xtext.enumrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.enumrules.idea.lang.MultiRuleEnumTestLanguageLanguage;

public class MultiRuleEnumTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public MultiRuleEnumTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(MultiRuleEnumTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
