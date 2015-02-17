package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

public class LangATestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LangATestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LangATestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
