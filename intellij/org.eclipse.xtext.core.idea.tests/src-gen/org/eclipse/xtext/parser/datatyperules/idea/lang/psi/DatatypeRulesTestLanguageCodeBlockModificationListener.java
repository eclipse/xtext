package org.eclipse.xtext.parser.datatyperules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.datatyperules.idea.lang.DatatypeRulesTestLanguageLanguage;

public class DatatypeRulesTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public DatatypeRulesTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(DatatypeRulesTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
