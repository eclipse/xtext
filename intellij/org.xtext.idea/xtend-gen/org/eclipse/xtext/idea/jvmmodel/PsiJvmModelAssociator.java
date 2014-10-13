package org.eclipse.xtext.idea.jvmmodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiNamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.common.types.JvmDeclaredType;
import org.eclipse.xtext.idea.types.psi.impl.JvmPsiClassImpl;
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
    boolean _matched = false;
    if (!_matched) {
      if (jvmElement instanceof JvmDeclaredType) {
        _matched=true;
        final PsiElementProvider _function = new PsiElementProvider() {
          public PsiElement get() {
            PsiElement _psiElement = PsiJvmModelAssociator.this.psiAssociations.getPsiElement(sourceElement);
            return new JvmPsiClassImpl(((JvmDeclaredType)jvmElement), ((PsiNamedElement) _psiElement));
          }
        };
        return _function;
      }
    }
    return null;
  }
}
