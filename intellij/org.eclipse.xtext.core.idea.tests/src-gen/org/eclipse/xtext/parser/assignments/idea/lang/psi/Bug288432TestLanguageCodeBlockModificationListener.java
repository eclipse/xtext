package org.eclipse.xtext.parser.assignments.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

public class Bug288432TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug288432TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug288432TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
