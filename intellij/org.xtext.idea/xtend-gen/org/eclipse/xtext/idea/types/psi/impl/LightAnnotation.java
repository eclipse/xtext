package org.eclipse.xtext.idea.types.psi.impl;

import com.intellij.lang.Language;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiAnnotationMemberValue;
import com.intellij.psi.PsiAnnotationOwner;
import com.intellij.psi.PsiAnnotationParameterList;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.meta.PsiMetaData;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightAnnotation extends LightElement implements PsiAnnotation {
  private String qualifiedName;
  
  @Accessors
  private PsiAnnotationOwner owner;
  
  public LightAnnotation(final PsiManager manager, final Language language, final String qualifiedName) {
    super(manager, language);
    this.qualifiedName = qualifiedName;
  }
  
  public String getQualifiedName() {
    return this.qualifiedName;
  }
  
  public String toString() {
    return this.qualifiedName;
  }
  
  public PsiAnnotationMemberValue findAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiAnnotationMemberValue findDeclaredAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiJavaCodeReferenceElement getNameReferenceElement() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiAnnotationParameterList getParameterList() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public <T extends PsiAnnotationMemberValue> T setDeclaredAttributeValue(final String attributeName, final T value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public PsiMetaData getMetaData() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Pure
  public PsiAnnotationOwner getOwner() {
    return this.owner;
  }
  
  public void setOwner(final PsiAnnotationOwner owner) {
    this.owner = owner;
  }
}
