package org.eclipse.xtext.parser.antlr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524TestLanguageLanguage;

public class Bug289524TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug289524TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug289524TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
