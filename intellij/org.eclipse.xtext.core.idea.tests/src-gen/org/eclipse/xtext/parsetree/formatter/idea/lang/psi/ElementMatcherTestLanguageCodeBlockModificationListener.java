package org.eclipse.xtext.parsetree.formatter.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.formatter.idea.lang.ElementMatcherTestLanguageLanguage;

public class ElementMatcherTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ElementMatcherTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ElementMatcherTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
