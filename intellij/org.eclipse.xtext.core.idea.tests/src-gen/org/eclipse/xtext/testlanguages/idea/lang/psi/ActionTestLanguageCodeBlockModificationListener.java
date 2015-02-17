package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguageLanguage;

public class ActionTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ActionTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ActionTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
