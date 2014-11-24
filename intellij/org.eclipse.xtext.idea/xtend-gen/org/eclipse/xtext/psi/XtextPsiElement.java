package org.eclipse.xtext.psi;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public interface XtextPsiElement /* extends PsiElement  */{
  public abstract IXtextLanguage getXtextLanguage();
  
  public abstract BaseXtextFile getContainingFile();
  
  public abstract Resource getResource();
  
  public abstract INode getINode();
}
