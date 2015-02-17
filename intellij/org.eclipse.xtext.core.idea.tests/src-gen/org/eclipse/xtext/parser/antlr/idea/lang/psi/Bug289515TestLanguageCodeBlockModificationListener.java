package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

public class Bug289515TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug289515TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug289515TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
