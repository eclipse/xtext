package org.eclipse.xtext.parser.assignments.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

public class Bug287184TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug287184TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug287184TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
