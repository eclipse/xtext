package org.eclipse.xtext.idea.refactoring;

import org.eclipse.xtext.psi.PsiNamedEObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.intellij.lang.refactoring.RefactoringSupportProvider;
import com.intellij.psi.PsiElement;

public class BaseXtextRefactoringSupportProvider extends RefactoringSupportProvider {

	@Override
	public boolean isMemberInplaceRenameAvailable(@NotNull PsiElement element, @Nullable PsiElement context) {
		return element instanceof PsiNamedEObject;
	}

}
