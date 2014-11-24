package org.eclipse.xtext.psi.impl;

import org.eclipse.xtext.psi.XtextPsiReference;
import org.eclipse.xtext.psi.impl.LeafXtextPsiElement;

@SuppressWarnings("all")
public class LeafXtextPsiReferenceElement extends LeafXtextPsiElement {
  public LeafXtextPsiReferenceElement(final /* IElementType */Object type, final CharSequence text) {
    super(type, text);
  }
  
  public XtextPsiReference getReference() {
    return new XtextPsiReference(this);
  }
}
