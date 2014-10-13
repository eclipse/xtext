package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.PsiElementProvider;

@SuppressWarnings("all")
public interface IPsiModelAssociator {
  public abstract boolean associate(final EObject eObject, final PsiElementProvider psiElementProvider);
  
  public abstract boolean associatePrimary(final EObject eObject, final PsiElementProvider psiElementProvider);
}
