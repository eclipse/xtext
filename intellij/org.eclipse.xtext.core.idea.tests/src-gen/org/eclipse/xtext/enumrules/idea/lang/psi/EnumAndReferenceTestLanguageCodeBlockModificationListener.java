package org.eclipse.xtext.enumrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.enumrules.idea.lang.EnumAndReferenceTestLanguageLanguage;

public class EnumAndReferenceTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EnumAndReferenceTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EnumAndReferenceTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
