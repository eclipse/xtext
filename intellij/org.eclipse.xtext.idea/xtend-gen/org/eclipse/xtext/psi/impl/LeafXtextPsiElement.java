/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
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
  
  @Override
  public IXtextLanguage getXtextLanguage() {
    IElementType _elementType = this.getElementType();
    Language _language = _elementType.getLanguage();
    return ((IXtextLanguage) _language);
  }
  
  @Override
  public BaseXtextFile getXtextFile() {
    PsiFile _containingFile = this.getContainingFile();
    return ((BaseXtextFile) _containingFile);
  }
  
  @Override
  public Resource getResource() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getResource();
  }
  
  @Override
  public INode getINode() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getINode(this);
  }
}
