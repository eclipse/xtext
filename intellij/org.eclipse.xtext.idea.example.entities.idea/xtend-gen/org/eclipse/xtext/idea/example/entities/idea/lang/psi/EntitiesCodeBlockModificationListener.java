package org.eclipse.xtext.idea.example.entities.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

@SuppressWarnings("all")
public class EntitiesCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {
  public EntitiesCodeBlockModificationListener(final PsiModificationTracker psiModificationTracker) {
    super(EntitiesLanguage.INSTANCE, psiModificationTracker);
  }
  
  protected boolean hasJavaStructuralChanges(final PsiTreeChangeEventImpl event) {
    return true;
  }
}
