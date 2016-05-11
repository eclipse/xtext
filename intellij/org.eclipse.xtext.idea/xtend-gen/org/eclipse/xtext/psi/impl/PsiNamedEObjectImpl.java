/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.psi.impl;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.List;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.idea.nodemodel.ASTNodeExtension;
import org.eclipse.xtext.psi.PsiEObjectFactory;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.impl.PsiEObjectIdentifierImpl;
import org.eclipse.xtext.psi.impl.PsiEObjectImpl;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PsiNamedEObjectImpl<PsiE extends PsiNamedEObject, T extends PsiNamedEObjectStub<PsiE>> extends PsiEObjectImpl<PsiE, T> implements PsiNamedEObject {
  @Inject
  @Extension
  private ASTNodeExtension _aSTNodeExtension;
  
  @Inject
  @Extension
  private PsiEObjectFactory psiEObjectFactory;
  
  public PsiNamedEObjectImpl(final T stub, final IStubElementType<T, PsiE> nodeType) {
    super(stub, nodeType);
  }
  
  public PsiNamedEObjectImpl(final ASTNode node) {
    super(node);
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
      if ((nameNode == null)) {
        return this;
      }
      final EObject grammarElement = this._aSTNodeExtension.getGrammarElement(nameNode);
      if ((grammarElement == null)) {
        return this;
      }
      boolean _isTerminalRuleCall = GrammarUtil.isTerminalRuleCall(grammarElement);
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
    ASTNode _xblockexpression = null;
    {
      final EStructuralFeature nameFeature = this.getNameFeature();
      if ((nameFeature == null)) {
        return null;
      }
      ASTNode _node = this.getNode();
      List<ASTNode> _findNodesForFeature = this._aSTNodeExtension.findNodesForFeature(_node, nameFeature);
      _xblockexpression = IterableExtensions.<ASTNode>head(_findNodesForFeature);
    }
    return _xblockexpression;
  }
  
  protected EStructuralFeature getNameFeature() {
    ASTNode _node = this.getNode();
    EClass _eClass = this._aSTNodeExtension.getEClass(_node);
    EStructuralFeature _eStructuralFeature = null;
    if (_eClass!=null) {
      _eStructuralFeature=_eClass.getEStructuralFeature("name");
    }
    final EStructuralFeature feature = _eStructuralFeature;
    if ((((feature instanceof EAttribute) && (!feature.isMany())) && String.class.isAssignableFrom(feature.getEType().getInstanceClass()))) {
      return feature;
    }
    return null;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("org.eclipse.xtext.psi.impl.PsiNamedEObjectImpl(");
    IStubElementType _elementType = this.getElementType();
    _builder.append(_elementType, "");
    _builder.append(":");
    Object _elvis = null;
    ASTNode _findNameNode = this.findNameNode();
    IElementType _elementType_1 = null;
    if (_findNameNode!=null) {
      _elementType_1=_findNameNode.getElementType();
    }
    if (_elementType_1 != null) {
      _elvis = _elementType_1;
    } else {
      _elvis = "null";
    }
    _builder.append(_elvis, "");
    _builder.append(")");
    {
      Class<? extends PsiNamedEObjectImpl> _class = this.getClass();
      boolean _tripleNotEquals = (_class != PsiNamedEObjectImpl.class);
      if (_tripleNotEquals) {
        _builder.append("(\'anonymous\')");
      }
    }
    return _builder.toString();
  }
}
