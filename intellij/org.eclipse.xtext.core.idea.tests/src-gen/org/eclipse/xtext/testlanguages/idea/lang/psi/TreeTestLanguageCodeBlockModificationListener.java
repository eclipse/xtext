package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

public class TreeTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public TreeTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(TreeTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
