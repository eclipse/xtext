package org.eclipse.xtext.generator.ecore.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.generator.ecore.idea.lang.SubTestLanguageLanguage;

public class SubTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SubTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SubTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
