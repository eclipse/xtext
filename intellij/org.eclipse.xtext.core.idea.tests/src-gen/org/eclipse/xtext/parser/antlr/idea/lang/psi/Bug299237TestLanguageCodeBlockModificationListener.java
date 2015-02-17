package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

public class Bug299237TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug299237TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug299237TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
