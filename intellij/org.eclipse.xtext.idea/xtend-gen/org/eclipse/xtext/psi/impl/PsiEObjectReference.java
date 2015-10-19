/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.stubs.StubElement;
import org.eclipse.xtext.psi.XtextPsiReference;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl;

@SuppressWarnings("all")
public class PsiEObjectReference<PsiE extends PsiElement, T extends StubElement<PsiE>> extends PsiEObjectImpl<PsiE, T> {
  protected PsiEObjectReference(final T stub, final IStubElementType<T, PsiE> nodeType) {
    super(stub, nodeType);
  }
  
  public PsiEObjectReference(final ASTNode node) {
    super(node);
  }
  
  @Override
  public XtextPsiReference getReference() {
    return new XtextPsiReferenceImpl(this);
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("org.eclipse.xtext.psi.impl.PsiEObjectReference");
    StringBuilder _append = builder.append("(");
    IStubElementType _elementType = this.getElementType();
    StringBuilder _append_1 = _append.append(_elementType);
    _append_1.append(")");
    return builder.toString();
  }
}
