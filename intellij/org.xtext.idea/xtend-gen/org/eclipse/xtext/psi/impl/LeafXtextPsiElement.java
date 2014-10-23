package org.eclipse.xtext.psi.impl;

import com.intellij.lang.Language;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import com.intellij.psi.tree.IElementType;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.XtextPsiElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public class LeafXtextPsiElement extends LeafPsiElement implements XtextPsiElement {
  public LeafXtextPsiElement(final IElementType type, final CharSequence text) {
    super(type, text);
  }
  
  public IXtextLanguage getXtextLanguage() {
    IElementType _elementType = this.getElementType();
    Language _language = _elementType.getLanguage();
    return ((IXtextLanguage) _language);
  }
  
  public BaseXtextFile getContainingFile() {
    PsiFile _containingFile = super.getContainingFile();
    return ((BaseXtextFile) _containingFile);
  }
  
  public Resource getResource() {
    BaseXtextFile _containingFile = this.getContainingFile();
    return _containingFile.getResource();
  }
  
  public INode getINode() {
    BaseXtextFile _containingFile = this.getContainingFile();
    return _containingFile.getINode(this);
  }
}
