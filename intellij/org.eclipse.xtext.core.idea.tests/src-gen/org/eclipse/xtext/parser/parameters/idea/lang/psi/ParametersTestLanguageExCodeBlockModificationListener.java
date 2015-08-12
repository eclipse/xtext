package org.eclipse.xtext.parser.parameters.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.parameters.idea.lang.ParametersTestLanguageExLanguage;

public class ParametersTestLanguageExCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ParametersTestLanguageExCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ParametersTestLanguageExLanguage.INSTANCE, psiModificationTracker);
	}

}
