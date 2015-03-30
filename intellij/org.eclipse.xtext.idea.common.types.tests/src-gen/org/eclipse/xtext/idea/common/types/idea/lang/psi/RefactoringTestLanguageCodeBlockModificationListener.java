package org.eclipse.xtext.idea.common.types.idea.lang.psi;

import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;

public class RefactoringTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public RefactoringTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(RefactoringTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
