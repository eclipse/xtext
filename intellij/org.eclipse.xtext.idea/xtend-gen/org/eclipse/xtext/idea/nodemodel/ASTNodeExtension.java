/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.nodemodel;

import com.google.common.base.Objects;
import com.google.inject.Singleton;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.RecursiveTreeElementWalkingVisitor;
import com.intellij.psi.impl.source.tree.TreeElement;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TypeRef;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class ASTNodeExtension {
  public List<ASTNode> findNodesForFeature(final ASTNode node, final EStructuralFeature structuralFeature) {
    EClass _eContainingClass = structuralFeature.getEContainingClass();
    final ASTNode actualNode = this.findActualNodeFor(node, _eContainingClass);
    if ((actualNode instanceof TreeElement)) {
      return this.findNodesForFeature(((TreeElement)actualNode), structuralFeature);
    }
    return CollectionLiterals.<ASTNode>emptyList();
  }
  
  protected ASTNode findActualNodeFor(final ASTNode node, final EClass type) {
    if (((node == null) || (type == null))) {
      return null;
    }
    ASTNode result = node;
    while (((result != null) && 
      (!(ObjectExtensions.<Boolean>operator_elvis(result.<Boolean>getUserData(IASTNodeAwareNodeModelBuilder.HAS_SEMANTIC_ELEMENT_KEY), Boolean.valueOf(false))).booleanValue()))) {
      ASTNode _treeParent = result.getTreeParent();
      result = _treeParent;
    }
    final EClass actualType = this.getEClass(result);
    boolean _isAssignableFrom = EcoreUtil2.isAssignableFrom(type, actualType);
    if (_isAssignableFrom) {
      return result;
    }
    return null;
  }
  
  protected List<ASTNode> findNodesForFeature(final TreeElement treeElement, final EStructuralFeature structuralFeature) {
    final ArrayList<ASTNode> result = CollectionLiterals.<ASTNode>newArrayList();
    final String featureName = structuralFeature.getName();
    treeElement.acceptTree(new RecursiveTreeElementWalkingVisitor() {
      @Override
      protected void visitNode(final TreeElement element) {
        if ((element instanceof PsiErrorElement)) {
          return;
        }
        if ((element == treeElement)) {
          super.visitNode(element);
          return;
        }
        final EObject grammarElement = ASTNodeExtension.this.getGrammarElement(element);
        if ((grammarElement instanceof Action)) {
          TreeElement firstChild = element.getFirstChildNode();
          while ((ASTNodeExtension.this.getGrammarElement(firstChild) instanceof Action)) {
            TreeElement _firstChildNode = firstChild.getFirstChildNode();
            firstChild = _firstChildNode;
          }
          EObject _grammarElement = ASTNodeExtension.this.getGrammarElement(firstChild);
          final Assignment assignment = GrammarUtil.containingAssignment(_grammarElement);
          if (((assignment != null) && Objects.equal(featureName, assignment.getFeature()))) {
            result.add(element);
          }
          return;
        }
        if ((grammarElement != null)) {
          final Assignment assignment_1 = GrammarUtil.containingAssignment(grammarElement);
          if ((assignment_1 != null)) {
            String _feature = assignment_1.getFeature();
            boolean _equals = Objects.equal(featureName, _feature);
            if (_equals) {
              result.add(element);
            }
            return;
          }
        }
        super.visitNode(element);
      }
    });
    return result;
  }
  
  public EClass getEClass(final ASTNode node) {
    final EObject grammarElement = this.getGrammarElement(node);
    if ((grammarElement == null)) {
      return null;
    }
    TypeRef _switchResult = null;
    boolean _matched = false;
    if (grammarElement instanceof Action) {
      _matched=true;
      _switchResult = ((Action)grammarElement).getType();
    }
    if (!_matched) {
      if (grammarElement instanceof RuleCall) {
        _matched=true;
        AbstractRule _rule = ((RuleCall)grammarElement).getRule();
        TypeRef _type = null;
        if (_rule!=null) {
          _type=_rule.getType();
        }
        _switchResult = _type;
      }
    }
    if (!_matched) {
      AbstractRule _containingRule = GrammarUtil.containingRule(grammarElement);
      _switchResult = _containingRule.getType();
    }
    final TypeRef type = _switchResult;
    EClassifier _classifier = null;
    if (type!=null) {
      _classifier=type.getClassifier();
    }
    final EClassifier classifier = _classifier;
    if ((classifier instanceof EClass)) {
      return ((EClass)classifier);
    }
    return null;
  }
  
  public EObject getGrammarElement(final ASTNode element) {
    EObject _xblockexpression = null;
    {
      IElementType _elementType = null;
      if (element!=null) {
        _elementType=element.getElementType();
      }
      final IElementType elementType = _elementType;
      EObject _xifexpression = null;
      if ((elementType instanceof IGrammarAwareElementType)) {
        _xifexpression = ((IGrammarAwareElementType)elementType).getGrammarElement();
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
}
