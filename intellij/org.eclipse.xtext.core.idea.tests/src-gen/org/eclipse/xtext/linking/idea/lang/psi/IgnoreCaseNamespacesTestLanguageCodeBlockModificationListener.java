package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.IgnoreCaseNamespacesTestLanguageLanguage;

public class IgnoreCaseNamespacesTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public IgnoreCaseNamespacesTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
