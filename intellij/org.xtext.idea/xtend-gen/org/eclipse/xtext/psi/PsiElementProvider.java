package org.eclipse.xtext.psi;

import com.intellij.psi.PsiElement;

@SuppressWarnings("all")
public interface PsiElementProvider {
  public abstract PsiElement get();
}
