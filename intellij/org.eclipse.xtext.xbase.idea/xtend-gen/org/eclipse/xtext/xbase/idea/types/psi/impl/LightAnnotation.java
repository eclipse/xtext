/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.types.psi.impl;

import com.intellij.core.JavaCoreBundle;
import com.intellij.lang.Language;
import com.intellij.psi.PsiAnnotation;
import com.intellij.psi.PsiAnnotationMemberValue;
import com.intellij.psi.PsiAnnotationOwner;
import com.intellij.psi.PsiAnnotationParameterList;
import com.intellij.psi.PsiJavaCodeReferenceElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.light.LightElement;
import com.intellij.psi.meta.PsiMetaData;
import com.intellij.util.IncorrectOperationException;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class LightAnnotation extends LightElement implements PsiAnnotation {
  protected final static String CAN_NOT_MODIFY_MESSAGE = JavaCoreBundle.message("psi.error.attempt.to.edit.class.file");
  
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
    return null;
  }
  
  @Override
  public PsiAnnotationMemberValue findDeclaredAttributeValue(final String attributeName) {
    return null;
  }
  
  @Override
  public PsiJavaCodeReferenceElement getNameReferenceElement() {
    return null;
  }
  
  @Override
  public PsiAnnotationParameterList getParameterList() {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public <T extends PsiAnnotationMemberValue> T setDeclaredAttributeValue(final String attributeName, final T value) {
    throw new IncorrectOperationException(LightAnnotation.CAN_NOT_MODIFY_MESSAGE);
  }
  
  @Override
  public PsiMetaData getMetaData() {
    return null;
  }
  
  @Pure
  public PsiAnnotationOwner getOwner() {
    return this.owner;
  }
  
  public void setOwner(final PsiAnnotationOwner owner) {
    this.owner = owner;
  }
}
