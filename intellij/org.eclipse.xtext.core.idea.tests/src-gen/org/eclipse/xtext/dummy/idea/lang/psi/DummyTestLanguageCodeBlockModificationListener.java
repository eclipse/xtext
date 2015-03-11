package org.eclipse.xtext.dummy.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.dummy.idea.lang.DummyTestLanguageLanguage;

public class DummyTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public DummyTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(DummyTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
