package org.eclipse.xtext.psi;

import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiTarget;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.psi.impl.BaseXtextFile;

@SuppressWarnings("all")
public interface XtextPsiElement extends PsiElement, PsiTarget {
  public abstract IXtextLanguage getXtextLanguage();
  
  public abstract BaseXtextFile getXtextFile();
  
  public abstract Resource getResource();
  
  public abstract INode getINode();
}
