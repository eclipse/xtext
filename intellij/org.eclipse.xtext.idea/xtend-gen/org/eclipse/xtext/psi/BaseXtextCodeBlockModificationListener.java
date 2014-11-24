package org.eclipse.xtext.psi;

import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class BaseXtextCodeBlockModificationListener /* implements PsiTreeChangePreprocessor  */{
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final IXtextLanguage language;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private final /* PsiModificationTrackerImpl */Object psiModificationTracker;
  
  public BaseXtextCodeBlockModificationListener(final IXtextLanguage language, final /* PsiModificationTracker */Object psiModificationTracker) {
    throw new Error("Unresolved compilation problems:"
      + "\nPsiModificationTrackerImpl cannot be resolved to a type.");
  }
  
  public Object treeChanged(final /* PsiTreeChangeEventImpl */Object event) {
    throw new Error("Unresolved compilation problems:"
      + "\nfile cannot be resolved"
      + "\nlanguage cannot be resolved"
      + "\n== cannot be resolved"
      + "\n&& cannot be resolved"
      + "\nhasStructuralChanges cannot be resolved"
      + "\nhasJavaStructuralChanges cannot be resolved"
      + "\nincCounter cannot be resolved"
      + "\nincOutOfCodeBlockModificationCounter cannot be resolved");
  }
  
  protected boolean hasStructuralChanges(final /* PsiTreeChangeEventImpl */Object it) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field code is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field CHILD_ADDED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field CHILD_REMOVED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field CHILD_REPLACED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field CHILD_MOVED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field CHILDREN_CHANGED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field PROPERTY_CHANGED is undefined for the type BaseXtextCodeBlockModificationListener"
      + "\nThe method or field genericChange is undefined for the type BaseXtextCodeBlockModificationListener");
  }
  
  protected boolean hasJavaStructuralChanges(final /* PsiTreeChangeEventImpl */Object event) {
    return false;
  }
  
  @Pure
  protected IXtextLanguage getLanguage() {
    return this.language;
  }
  
  @Pure
  protected PsiModificationTrackerImpl getPsiModificationTracker() {
    return this.psiModificationTracker;
  }
}
