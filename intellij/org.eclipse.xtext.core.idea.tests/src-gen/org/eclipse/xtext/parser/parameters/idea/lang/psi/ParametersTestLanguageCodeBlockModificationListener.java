package org.eclipse.xtext.parser.parameters.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageLanguage;

public class ParametersTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ParametersTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ParametersTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
