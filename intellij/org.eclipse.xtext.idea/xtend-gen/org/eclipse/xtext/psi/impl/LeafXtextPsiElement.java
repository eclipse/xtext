package org.eclipse.xtext.psi.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.XtextPsiElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public class LeafXtextPsiElement implements /* LeafPsiElement */XtextPsiElement {
  public LeafXtextPsiElement(final /* IElementType */Object type, final CharSequence text) {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method super is undefined for the type LeafXtextPsiElement");
  }
  
  public IXtextLanguage getXtextLanguage() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field elementType is undefined for the type LeafXtextPsiElement"
      + "\nlanguage cannot be resolved");
  }
  
  public BaseXtextFile getContainingFile() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method or field super is undefined for the type LeafXtextPsiElement"
      + "\ngetContainingFile cannot be resolved");
  }
  
  public Resource getResource() {
    BaseXtextFile _containingFile = this.getContainingFile();
    return _containingFile.getResource();
  }
  
  public INode getINode() {
    throw new Error("Unresolved compilation problems:"
      + "\nThe method getINode is undefined for the type LeafXtextPsiElement");
  }
}
