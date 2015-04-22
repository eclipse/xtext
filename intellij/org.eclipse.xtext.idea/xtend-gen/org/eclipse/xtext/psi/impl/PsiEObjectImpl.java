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
import com.intellij.extapi.psi.StubBasedPsiElementBase;
import com.intellij.icons.AllIcons;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.stubs.IStubElementType;
import com.intellij.psi.tree.IElementType;
import com.intellij.util.IncorrectOperationException;
import java.util.List;
import javax.swing.Icon;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.idea.lang.IXtextLanguage;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.psi.PsiEObjectFactory;
import org.eclipse.xtext.psi.PsiEObjectIdentifier;
import org.eclipse.xtext.psi.PsiNamedEObject;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.impl.PsiEObjectIdentifierImpl;
import org.eclipse.xtext.psi.stubs.PsiNamedEObjectStub;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.service.OperationCanceledError;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.SimpleAttributeResolver;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class PsiEObjectImpl<T extends PsiNamedEObjectStub<?>> extends StubBasedPsiElementBase<T> implements PsiNamedEObject {
  @Inject
  @Extension
  private PsiEObjectFactory psiEObjectFactory;
  
  @Inject
  @Extension
  protected ILocationInFileProvider locationInFileProvider;
  
  private final IElementType elementType;
  
  protected PsiEObjectImpl(final T stub, final IStubElementType<?, ?> nodeType) {
    super(stub, nodeType);
    this.elementType = nodeType;
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
  }
  
  public PsiEObjectImpl(final ASTNode node) {
    super(node);
    IElementType _elementType = node.getElementType();
    this.elementType = _elementType;
    IXtextLanguage _xtextLanguage = this.getXtextLanguage();
    _xtextLanguage.injectMembers(this);
  }
  
  @Override
  public EClass getEClass() {
    INode node = this.getINode();
    boolean _hasDirectSemanticElement = node.hasDirectSemanticElement();
    if (_hasDirectSemanticElement) {
      EObject _semanticElement = node.getSemanticElement();
      return _semanticElement.eClass();
    }
    EReference eReference = this.getEReference();
    if ((eReference != null)) {
      return eReference.getEReferenceType();
    }
    return null;
  }
  
  @Override
  public EReference getEReference() {
    if ((this.elementType instanceof IGrammarAwareElementType)) {
      EObject grammarElement = ((IGrammarAwareElementType) this.elementType).getGrammarElement();
      if ((grammarElement instanceof CrossReference)) {
        return GrammarUtil.getReference(((CrossReference) grammarElement));
      }
    }
    INode node = this.getINode();
    if ((node == null)) {
      return null;
    }
    EObject grammarElement_1 = node.getGrammarElement();
    if ((grammarElement_1 instanceof CrossReference)) {
      return GrammarUtil.getReference(((CrossReference) grammarElement_1));
    }
    boolean _hasDirectSemanticElement = node.hasDirectSemanticElement();
    if (_hasDirectSemanticElement) {
      EObject semanticElement = node.getSemanticElement();
      return semanticElement.eContainmentFeature();
    }
    return null;
  }
  
  @Override
  public INode getINode() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    ASTNode _node = this.getNode();
    return _xtextFile.getINode(_node);
  }
  
  @Override
  public boolean isRoot() {
    PsiElement _parent = this.getParent();
    return (_parent instanceof BaseXtextFile);
  }
  
  @Override
  public EObject getEObject() {
    INode _iNode = this.getINode();
    return _iNode.getSemanticElement();
  }
  
  @Override
  public Resource getResource() {
    BaseXtextFile _xtextFile = this.getXtextFile();
    return _xtextFile.getResource();
  }
  
  @Override
  public IXtextLanguage getXtextLanguage() {
    Language _language = this.getLanguage();
    return ((IXtextLanguage) _language);
  }
  
  @Override
  public BaseXtextFile getXtextFile() {
    PsiFile _containingFile = this.getContainingFile();
    return ((BaseXtextFile) _containingFile);
  }
  
  @Override
  protected Icon getElementIcon(final int flags) {
    return AllIcons.General.SecondaryGroup;
  }
  
  @Override
  public String toString() {
    Class<? extends PsiEObjectImpl> _class = this.getClass();
    String _name = _class.getName();
    StringBuilder builder = new StringBuilder(_name);
    StringBuilder _append = builder.append("(");
    StringBuilder _append_1 = _append.append(this.elementType);
    _append_1.append(")");
    return builder.toString();
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
    String _xblockexpression = null;
    {
      final T stub = this.getStub();
      boolean _notEquals = (!Objects.equal(stub, null));
      if (_notEquals) {
        return stub.getName();
      }
      final PsiEObjectIdentifier nameIdentifier = this.getNameIdentifier();
      boolean _equals = Objects.equal(nameIdentifier, null);
      if (_equals) {
        return null;
      }
      _xblockexpression = nameIdentifier.getText();
    }
    return _xblockexpression;
  }
  
  @Override
  public PsiNamedEObject setName(final String name) throws IncorrectOperationException {
    PsiEObjectImpl<T> _xblockexpression = null;
    {
      final ASTNode nameNode = this.findNameNode();
      boolean _equals = Objects.equal(nameNode, null);
      if (_equals) {
        return this;
      }
      IGrammarAwareElementType _nameType = this.getNameType();
      EObject _grammarElement = _nameType.getGrammarElement();
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
  
  protected IGrammarAwareElementType getNameType() {
    ASTNode _findNameNode = this.findNameNode();
    IElementType _elementType = null;
    if (_findNameNode!=null) {
      _elementType=_findNameNode.getElementType();
    }
    return ((IGrammarAwareElementType) _elementType);
  }
  
  protected ASTNode findNameNode() {
    ASTNode _xblockexpression = null;
    {
      final INode treeNode = this.getINode();
      boolean _hasDirectSemanticElement = treeNode.hasDirectSemanticElement();
      boolean _not = (!_hasDirectSemanticElement);
      if (_not) {
        return null;
      }
      EObject _semanticElement = treeNode.getSemanticElement();
      final EAttribute nameAttribute = SimpleAttributeResolver.NAME_RESOLVER.getAttribute(_semanticElement);
      boolean _equals = Objects.equal(nameAttribute, null);
      if (_equals) {
        return null;
      }
      EObject _eObject = this.getEObject();
      List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(_eObject, nameAttribute);
      final INode nameAttributeNode = IterableExtensions.<INode>head(_findNodesForFeature);
      BaseXtextFile _xtextFile = this.getXtextFile();
      List<ASTNode> _aSTNodes = _xtextFile.getASTNodes(nameAttributeNode);
      final ASTNode nameNode = IterableExtensions.<ASTNode>head(_aSTNodes);
      ASTNode _xifexpression = null;
      ASTNode _treeParent = null;
      if (nameNode!=null) {
        _treeParent=nameNode.getTreeParent();
      }
      ASTNode _node = this.getNode();
      boolean _equals_1 = Objects.equal(_treeParent, _node);
      if (_equals_1) {
        _xifexpression = nameNode;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public int getTextOffset() {
    ITextRegion _significantTextRegion = this.getSignificantTextRegion();
    return _significantTextRegion.getOffset();
  }
  
  /**
   * @return
   */
  protected ITextRegion getSignificantTextRegion() {
    ITextRegion _xtrycatchfinallyexpression = null;
    try {
      EObject _eObject = this.getEObject();
      _xtrycatchfinallyexpression = this.locationInFileProvider.getSignificantTextRegion(_eObject);
    } catch (final Throwable _t) {
      if (_t instanceof OperationCanceledError) {
        final OperationCanceledError e = (OperationCanceledError)_t;
        throw e.getWrapped();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
}
