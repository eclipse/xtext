/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.psi.PsiEObjectFactory;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.impl.PsiEObjectIdentifierImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PsiNamedEObjectImpl<PsiE extends PsiNamedEObject, T extends PsiNamedEObjectStub<PsiE>> extends PsiEObjectImpl<PsiE, T> implements PsiNamedEObject {
  @Inject
  @Extension
  private PsiEObjectFactory psiEObjectFactory;
  
  private final IGrammarAwareElementType nameType;
  
  public PsiNamedEObjectImpl(final T stub, final IStubElementType<T, PsiE> nodeType, final IGrammarAwareElementType nameType) {
    super(stub, nodeType);
    Preconditions.<IGrammarAwareElementType>checkNotNull(nameType);
    this.nameType = nameType;
  }
  
  public PsiNamedEObjectImpl(final ASTNode node, final IGrammarAwareElementType... nameTypes) {
    super(node);
    boolean _isEmpty = ((List<IGrammarAwareElementType>)Conversions.doWrapArray(nameTypes)).isEmpty();
    boolean _not = (!_isEmpty);
    Preconditions.checkArgument(_not);
    final Function1<IGrammarAwareElementType, Boolean> _function = new Function1<IGrammarAwareElementType, Boolean>() {
      @Override
      public Boolean apply(final IGrammarAwareElementType nameType) {
        ASTNode _findChildByType = node.findChildByType(nameType);
        return Boolean.valueOf((!Objects.equal(_findChildByType, null)));
      }
    };
    IGrammarAwareElementType _findFirst = IterableExtensions.<IGrammarAwareElementType>findFirst(((Iterable<IGrammarAwareElementType>)Conversions.doWrapArray(nameTypes)), _function);
    this.nameType = _findFirst;
  }
  
  @Override
  public PsiEObjectIdentifier getNameIdentifier() {
    PsiEObjectIdentifierImpl _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      boolean _equals = Objects.equal(nameNode, null);
      if (_equals) {
        return null;
      }
      PsiElement _psi = nameNode.getPsi();
      _xblockexpression = new PsiEObjectIdentifierImpl(_psi);
    }
    return _xblockexpression;
  }
  
  @Override
  public String getName() {
    final T stub = this.getStub();
    boolean _notEquals = (!Objects.equal(stub, null));
    if (_notEquals) {
      return stub.getName();
    }
    final ITextRegion significantTextRegion = this.getSignificantTextRegion();
    final int startIndex = significantTextRegion.getOffset();
    int _length = significantTextRegion.getLength();
    final int endIndex = (startIndex + _length);
    PsiFile _containingFile = this.getContainingFile();
    String _text = _containingFile.getText();
    final String result = _text.substring(startIndex, endIndex);
    return result;
  }
  
  @Override
  public PsiNamedEObject setName(final String name) throws IncorrectOperationException {
    PsiNamedEObjectImpl<PsiE, T> _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      boolean _equals = Objects.equal(nameNode, null);
      if (_equals) {
        return this;
      }
      EObject _grammarElement = this.nameType.getGrammarElement();
      boolean _isTerminalRuleCall = GrammarUtil.isTerminalRuleCall(_grammarElement);
      if (_isTerminalRuleCall) {
        final ASTNode newNameNode = this.psiEObjectFactory.createLeafIdentifier(name, nameNode);
        ASTNode _treeParent = nameNode.getTreeParent();
        _treeParent.replaceChild(nameNode, newNameNode);
      } else {
        String _name = this.getName();
        ASTNode _createCompositeIdentifier = this.psiEObjectFactory.createCompositeIdentifier(name, _name, nameNode);
        final ASTNode newNameNode_1 = _createCompositeIdentifier.getFirstChildNode();
        nameNode.replaceAllChildrenToChildrenOf(newNameNode_1);
      }
      _xblockexpression = this;
    }
    return _xblockexpression;
  }
  
  protected ASTNode findNameNode() {
    ASTNode _node = this.getNode();
    return _node.findChildByType(this.nameType);
  }
  
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl");
    StringBuilder _append = builder.append("(");
    IStubElementType _elementType = this.getElementType();
    StringBuilder _append_1 = _append.append(_elementType);
    _append_1.append(")");
    return builder.toString();
  }
}
