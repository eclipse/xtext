package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.AbstractIgnoreCaseLinkingTestLanguageLanguage;

public class AbstractIgnoreCaseLinkingTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public AbstractIgnoreCaseLinkingTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(AbstractIgnoreCaseLinkingTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
