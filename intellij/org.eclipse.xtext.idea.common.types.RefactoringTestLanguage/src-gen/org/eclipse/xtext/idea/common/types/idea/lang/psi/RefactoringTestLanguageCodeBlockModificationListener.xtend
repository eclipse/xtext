package org.eclipse.xtext.idea.common.types.idea.lang.psi

import com.intellij.psi.impl.PsiTreeChangeEventImpl
import com.intellij.psi.util.PsiModificationTracker
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage

class RefactoringTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	new(PsiModificationTracker psiModificationTracker) {
		super(RefactoringTestLanguageLanguage.INSTANCE, psiModificationTracker)
	}

	override protected hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		true
	}

}
