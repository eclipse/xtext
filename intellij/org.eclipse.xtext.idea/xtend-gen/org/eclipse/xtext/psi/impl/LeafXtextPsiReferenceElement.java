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
