package org.eclipse.xtext.idea.sdomain.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainLanguage;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;

@SuppressWarnings("all")
public class SDomainCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {
  public SDomainCodeBlockModificationListener(final PsiModificationTracker psiModificationTracker) {
    super(SDomainLanguage.INSTANCE, psiModificationTracker);
  }
}
