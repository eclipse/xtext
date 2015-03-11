package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

public class Bug301935TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug301935TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug301935TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
