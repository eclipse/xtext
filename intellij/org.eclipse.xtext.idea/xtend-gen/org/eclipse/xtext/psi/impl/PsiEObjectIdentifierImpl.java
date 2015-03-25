/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.impl.light.LightElement;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;

@SuppressWarnings("all")
public class PsiEObjectIdentifierImpl extends LightElement implements PsiEObjectIdentifier {
  private final PsiElement psiElement;
  
  public PsiEObjectIdentifierImpl(final PsiElement psiElement) {
    this(psiElement.getManager(), psiElement.getLanguage(), psiElement);
  }
  
  public PsiEObjectIdentifierImpl(final PsiManager manager, final Language language, final PsiElement psiElement) {
    super(manager, language);
    this.psiElement = psiElement;
  }
  
  @Override
  public boolean isValid() {
    return this.psiElement.isValid();
  }
  
  @Override
  public PsiFile getContainingFile() {
    return this.psiElement.getContainingFile();
  }
  
  @Override
  public PsiElement getNavigationElement() {
    return this.getParent();
  }
  
  @Override
  public PsiElement getParent() {
    return this.psiElement.getParent();
  }
  
  @Override
  public PsiElement getPrevSibling() {
    return this.psiElement.getPrevSibling();
  }
  
  @Override
  public PsiElement getNextSibling() {
    return this.psiElement.getNextSibling();
  }
  
  @Override
  public int getStartOffsetInParent() {
    TextRange _textRange = this.getTextRange();
    int _startOffset = _textRange.getStartOffset();
    PsiElement _parent = this.getParent();
    TextRange _textRange_1 = _parent.getTextRange();
    int _startOffset_1 = _textRange_1.getStartOffset();
    return (_startOffset - _startOffset_1);
  }
  
  @Override
  public TextRange getTextRange() {
    PsiElement _parent = this.getParent();
    int _textOffset = _parent.getTextOffset();
    ASTNode _node = this.getNode();
    TextRange _textRange = _node.getTextRange();
    int _endOffset = _textRange.getEndOffset();
    return new TextRange(_textOffset, _endOffset);
  }
  
  @Override
  public PsiElement copy() {
    return new PsiEObjectIdentifierImpl(this.psiElement);
  }
  
  @Override
  public String getText() {
    String _xblockexpression = null;
    {
      final TextRange textRange = this.getTextRange();
      PsiFile _containingFile = this.getContainingFile();
      String _text = _containingFile.getText();
      int _startOffset = textRange.getStartOffset();
      int _endOffset = textRange.getEndOffset();
      _xblockexpression = _text.substring(_startOffset, _endOffset);
    }
    return _xblockexpression;
  }
  
  @Override
  public int getTextOffset() {
    TextRange _textRange = this.getTextRange();
    return _textRange.getStartOffset();
  }
  
  @Override
  public ASTNode getNode() {
    return this.psiElement.getNode();
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    Class<? extends PsiEObjectIdentifierImpl> _class = this.getClass();
    String _simpleName = _class.getSimpleName();
    _builder.append(_simpleName, "");
    _builder.append(": ");
    String _text = this.getText();
    _builder.append(_text, "");
    return _builder.toString();
  }
}
