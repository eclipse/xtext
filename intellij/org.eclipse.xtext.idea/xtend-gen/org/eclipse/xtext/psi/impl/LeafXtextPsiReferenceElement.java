package org.eclipse.xtext.psi.impl;

import com.intellij.psi.PsiReference;
import com.intellij.psi.tree.IElementType;
import org.eclipse.xtext.psi.XtextPsiReference;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;

@SuppressWarnings("all")
public class LeafXtextPsiReferenceElement extends LeafXtextPsiElement {
  public LeafXtextPsiReferenceElement(final IElementType type, final CharSequence text) {
    super(type, text);
  }
  
  public PsiReference getReference() {
    return new XtextPsiReference(this);
  }
}
