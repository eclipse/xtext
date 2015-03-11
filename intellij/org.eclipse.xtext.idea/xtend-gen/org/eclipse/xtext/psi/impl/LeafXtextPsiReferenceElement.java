/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl;

import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;
import org.eclipse.xtext.psi.impl.XtextPsiReferenceImpl;

@SuppressWarnings("all")
public class LeafXtextPsiReferenceElement extends LeafXtextPsiElement {
  public LeafXtextPsiReferenceElement(final IElementType type, final CharSequence text) {
    super(type, text);
  }
  
  @Override
  public PsiReference getReference() {
    return new XtextPsiReferenceImpl(this);
  }
}
