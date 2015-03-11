package org.eclipse.xtext.linking.lazy.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

public class Bug311337TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug311337TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug311337TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
