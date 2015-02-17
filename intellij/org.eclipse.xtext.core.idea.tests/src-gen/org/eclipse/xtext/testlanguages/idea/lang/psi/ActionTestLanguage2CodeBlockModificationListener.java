package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.ActionTestLanguage2Language;

public class ActionTestLanguage2CodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ActionTestLanguage2CodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ActionTestLanguage2Language.INSTANCE, psiModificationTracker);
	}

}
