package org.eclipse.xtext.idea.common.types.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

@SuppressWarnings("all")
public class RefactoringTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {
  public RefactoringTestLanguageCodeBlockModificationListener(final PsiModificationTracker psiModificationTracker) {
    super(RefactoringTestLanguageLanguage.INSTANCE, psiModificationTracker);
  }
  
  protected boolean hasJavaStructuralChanges(final PsiTreeChangeEventImpl event) {
    return true;
  }
}
