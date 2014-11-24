package org.eclipse.xtext.idea.types.psi.impl;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightAnnotation /* implements LightElement, PsiAnnotation  */{
  private String qualifiedName;
  
  @Accessors
  private /* PsiAnnotationOwner */Object owner;
  
  public LightAnnotation(final /* PsiManager */Object manager, final /* Language */Object language, final String qualifiedName) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type LightAnnotation");
  }
  
  public String getQualifiedName() {
    return this.qualifiedName;
  }
  
  public String toString() {
    return this.qualifiedName;
  }
  
  public void findAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void findDeclaredAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void getNameReferenceElement() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void getParameterList() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public <T/*  extends PsiAnnotationMemberValue */> void setDeclaredAttributeValue(final String attributeName, final T value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  public void getMetaData() {
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
