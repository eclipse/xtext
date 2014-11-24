package org.eclipse.xtext.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.psi.IPsiModelAssociations;
import org.eclipse.xtext.psi.IPsiModelAssociator;
import org.eclipse.xtext.psi.PsiElementProvider;
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator;
import org.eclipse.xtext.xbase.lib.Extension;

@SuppressWarnings("all")
public class PsiJvmModelAssociator extends JvmModelAssociator {
  @Inject
  @Extension
  private IPsiModelAssociator _iPsiModelAssociator;
  
  @Inject
  @Extension
  private IPsiModelAssociations psiAssociations;
  
  public void associate(final EObject sourceElement, final EObject jvmElement) {
    super.associate(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associate(jvmElement, psiElementProvider);
    }
  }
  
  public void associatePrimary(final EObject sourceElement, final EObject jvmElement) {
    super.associatePrimary(sourceElement, jvmElement);
    final PsiElementProvider psiElementProvider = this.createPsiElementProvider(sourceElement, jvmElement);
    boolean _notEquals = (!Objects.equal(psiElementProvider, null));
    if (_notEquals) {
      this._iPsiModelAssociator.associatePrimary(jvmElement, psiElementProvider);
    }
  }
  
  public PsiElementProvider createPsiElementProvider(final EObject sourceElement, final EObject jvmElement) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiNamedElement cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiClass cannot be resolved to a type."
      + "\nPsiMethod cannot be resolved to a type."
      + "\nThe method psiElement is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getPsiElement is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getUserData is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getPsiElement is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getUserData is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getPsiElement is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getUserData is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getPsiElement is undefined for the type PsiJvmModelAssociator"
      + "\nThe method getUserData is undefined for the type PsiJvmModelAssociator"
      + "\n== cannot be resolved"
      + "\ninnerClasses cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved"
      + "\n== cannot be resolved"
      + "\nmethods cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved"
      + "\n== cannot be resolved"
      + "\nfields cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved"
      + "\n== cannot be resolved"
      + "\nparameterList cannot be resolved"
      + "\nparameters cannot be resolved"
      + "\nfindFirst cannot be resolved"
      + "\n== cannot be resolved");
  }
}
