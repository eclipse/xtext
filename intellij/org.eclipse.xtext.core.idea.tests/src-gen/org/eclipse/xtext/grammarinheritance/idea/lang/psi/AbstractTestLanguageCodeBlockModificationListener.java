package org.eclipse.xtext.grammarinheritance.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.grammarinheritance.idea.lang.AbstractTestLanguageLanguage;

public class AbstractTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public AbstractTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(AbstractTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
