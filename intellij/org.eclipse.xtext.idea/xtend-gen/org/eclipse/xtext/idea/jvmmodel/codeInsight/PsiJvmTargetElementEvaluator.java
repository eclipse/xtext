package org.eclipse.xtext.idea.jvmmodel.codeInsight;

@SuppressWarnings("all")
public class PsiJvmTargetElementEvaluator /* implements TargetElementEvaluator  */{
  public Object getElementByReference(final /* PsiReference */Object ref, final int flags) {
    throw new Error("Unresolved compilation problems:"
      + "\nLightElement cannot be resolved to a type."
      + "\nresolve cannot be resolved"
      + "\nnavigationElement cannot be resolved");
  }
  
  public boolean includeSelfInGotoImplementation(final /* PsiElement */Object element) {
    return true;
  }
}
