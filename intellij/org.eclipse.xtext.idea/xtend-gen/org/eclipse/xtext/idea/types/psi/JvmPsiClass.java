package org.eclipse.xtext.idea.types.psi;

import org.eclipse.emf.ecore.EClass;

@SuppressWarnings("all")
public interface JvmPsiClass /* extends PsiClass  */{
  public abstract EClass getType();
}
