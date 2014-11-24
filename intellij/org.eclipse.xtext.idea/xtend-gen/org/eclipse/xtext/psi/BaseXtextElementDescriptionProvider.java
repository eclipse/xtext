package org.eclipse.xtext.psi;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class BaseXtextElementDescriptionProvider /* implements ElementDescriptionProvider  */{
  @Accessors
  private final IXtextLanguage language;
  
  public BaseXtextElementDescriptionProvider(final IXtextLanguage language) {
    this.language = language;
    language.injectMembers(this);
  }
  
  public final Object getElementDescription(final /* PsiElement */Object element, final /* ElementDescriptionLocation */Object location) {
    throw new Error("Unresolved compilation problems:"
      + "\nlanguage cannot be resolved"
      + "\n== cannot be resolved");
  }
  
  public Object doGetElementDescription(final /* PsiElement */Object element, final /* ElementDescriptionLocation */Object location) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field UsageViewTypeLocation is undefined for the type BaseXtextElementDescriptionProvider"
      + "\n== cannot be resolved"
      + "\nINSTANCE cannot be resolved"
      + "\nEObject cannot be resolved"
      + "\n!= cannot be resolved"
      + "\neClass cannot be resolved"
      + "\nname cannot be resolved");
  }
  
  @Pure
  public IXtextLanguage getLanguage() {
    return this.language;
  }
}
