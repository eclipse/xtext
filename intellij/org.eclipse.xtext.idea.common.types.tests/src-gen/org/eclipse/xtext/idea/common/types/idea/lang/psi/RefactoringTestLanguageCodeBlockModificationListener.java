package org.eclipse.xtext.idea.common.types.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

public class RefactoringTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public RefactoringTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(RefactoringTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
