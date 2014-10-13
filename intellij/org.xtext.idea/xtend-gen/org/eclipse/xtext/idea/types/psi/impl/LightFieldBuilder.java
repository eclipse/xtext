package org.eclipse.xtext.idea.types.psi.impl;

import com.intellij.lang.Language;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiExpression;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiType;
import com.intellij.psi.impl.light.LightVariableBuilder;
import com.intellij.psi.javadoc.PsiDocComment;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightFieldBuilder extends LightVariableBuilder<LightFieldBuilder> implements PsiField {
  @Accessors
  private PsiClass containingClass;
  
  @Accessors
  private PsiExpression initializer;
  
  @Accessors
  private PsiDocComment docComment;
  
  @Accessors
  private boolean deprecated;
  
  public LightFieldBuilder(final PsiManager manager, final Language language, final String name, final PsiType type) {
    super(manager, name, type, language);
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
