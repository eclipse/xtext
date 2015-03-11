package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

public class Bug296889TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug296889TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug296889TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
