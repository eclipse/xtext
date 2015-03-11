package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

public class TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
