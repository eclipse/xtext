package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

public class Bug301935ExTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug301935ExTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug301935ExTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
