/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
  
  @Override
  public String getQualifiedName() {
    return this.qualifiedName;
  }
  
  @Override
  public String toString() {
    return this.qualifiedName;
  }
  
  @Override
  public PsiAnnotationMemberValue findAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public PsiAnnotationMemberValue findDeclaredAttributeValue(final String attributeName) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public PsiJavaCodeReferenceElement getNameReferenceElement() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public PsiAnnotationParameterList getParameterList() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public <T extends PsiAnnotationMemberValue> T setDeclaredAttributeValue(final String attributeName, final T value) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
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
