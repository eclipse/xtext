package org.eclipse.xtext.idea.types.psi.impl;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightFieldBuilder /* implements LightVariableBuilder<LightFieldBuilder>, PsiField  */{
  @Accessors
  private /* PsiClass */Object containingClass;
  
  @Accessors
  private /* PsiExpression */Object initializer;
  
  @Accessors
  private /* PsiDocComment */Object docComment;
  
  @Accessors
  private boolean deprecated;
  
  public LightFieldBuilder(final /* PsiManager */Object manager, final /* Language */Object language, final String name, final /* PsiType */Object type) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type LightFieldBuilder");
  }
  
  @Pure
  public PsiClass getContainingClass() {
    return this.containingClass;
  }
  
  public void setContainingClass(final PsiClass containingClass) {
    this.containingClass = containingClass;
  }
  
  @Pure
  public PsiExpression getInitializer() {
    return this.initializer;
  }
  
  public void setInitializer(final PsiExpression initializer) {
    this.initializer = initializer;
  }
  
  @Pure
  public PsiDocComment getDocComment() {
    return this.docComment;
  }
  
  public void setDocComment(final PsiDocComment docComment) {
    this.docComment = docComment;
  }
  
  @Pure
  public boolean isDeprecated() {
    return this.deprecated;
  }
  
  public void setDeprecated(final boolean deprecated) {
    this.deprecated = deprecated;
  }
}
