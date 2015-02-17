package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

public class Bug289524ExTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug289524ExTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug289524ExTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
