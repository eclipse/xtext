package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseImportsTestLanguageLanguage;

public class IgnoreCaseImportsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public IgnoreCaseImportsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(IgnoreCaseImportsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
