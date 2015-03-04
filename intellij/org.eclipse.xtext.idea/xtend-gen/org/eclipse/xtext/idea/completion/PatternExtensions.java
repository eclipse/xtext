package org.eclipse.xtext.idea.completion;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import com.intellij.patterns.PatternCondition;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.psi.PsiEObject;

@Singleton
@SuppressWarnings("all")
public class PatternExtensions {
  public PsiElementPattern.Capture<PsiElement> withEReference(final PsiElementPattern.Capture<PsiElement> it, final EReference reference) {
    return it.with(new PatternCondition<PsiElement>("withEReference") {
      @Override
      public boolean accepts(final PsiElement element, final ProcessingContext context) {
        return PatternExtensions.this.withEReference(element, reference);
      }
    });
  }
  
  protected boolean withEReference(final PsiElement element, final EReference reference) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(element, null);
      if (_equals) {
        return false;
      }
      if ((element instanceof PsiEObject)) {
        EReference _eReference = ((PsiEObject)element).getEReference();
        boolean _equals_1 = Objects.equal(_eReference, reference);
        if (_equals_1) {
          return true;
        }
      }
      PsiElement _parent = element.getParent();
      _xblockexpression = this.withEReference(_parent, reference);
    }
    return _xblockexpression;
  }
}
