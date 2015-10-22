/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.structureview;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewTreeElement;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EStructuralFeatureTreeElement extends AbstractStructureViewTreeElement {
  private URI uri;
  
  @Accessors
  private EObject owner;
  
  @Accessors
  private EStructuralFeature feature;
  
  @Override
  public Object getValue() {
    return Pair.<URI, EStructuralFeature>of(this.uri, this.feature);
  }
  
  public void setOwner(final EObject owner) {
    this.owner = owner;
    URI _uRI = EcoreUtil.getURI(owner);
    this.uri = _uRI;
  }
  
  @Override
  protected PsiElement getInternalNavigationElement() {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(this.owner, this.feature);
    final Function1<INode, Iterable<ILeafNode>> _function = new Function1<INode, Iterable<ILeafNode>>() {
      @Override
      public Iterable<ILeafNode> apply(final INode it) {
        return it.getLeafNodes();
      }
    };
    List<Iterable<ILeafNode>> _map = ListExtensions.<INode, Iterable<ILeafNode>>map(_findNodesForFeature, _function);
    Iterable<ILeafNode> _flatten = Iterables.<ILeafNode>concat(_map);
    final Function1<ILeafNode, Boolean> _function_1 = new Function1<ILeafNode, Boolean>() {
      @Override
      public Boolean apply(final ILeafNode it) {
        boolean _isHidden = it.isHidden();
        return Boolean.valueOf((!_isHidden));
      }
    };
    Iterable<ILeafNode> _filter = IterableExtensions.<ILeafNode>filter(_flatten, _function_1);
    ILeafNode _head = IterableExtensions.<ILeafNode>head(_filter);
    ASTNode _aSTNode = this.xtextFile.getASTNode(_head);
    return _aSTNode.getPsi();
  }
  
  @Override
  protected Object getObjectToPresent() {
    return this.owner;
  }
  
  @Override
  public boolean equals(final Object obj) {
    boolean _xifexpression = false;
    if ((this == obj)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((obj instanceof EStructuralFeatureTreeElement)) {
        boolean _and = false;
        boolean _equals = Objects.equal(this.uri, ((EStructuralFeatureTreeElement)obj).uri);
        if (!_equals) {
          _and = false;
        } else {
          boolean _equals_1 = Objects.equal(this.feature, ((EStructuralFeatureTreeElement)obj).feature);
          _and = _equals_1;
        }
        _xifexpression_1 = _and;
      } else {
        _xifexpression_1 = false;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  @Override
  public int hashCode() {
    int _hashCode = this.uri.hashCode();
    int _hashCode_1 = this.feature.hashCode();
    return (_hashCode * _hashCode_1);
  }
  
  @Pure
  public EObject getOwner() {
    return this.owner;
  }
  
  @Pure
  public EStructuralFeature getFeature() {
    return this.feature;
  }
  
  public void setFeature(final EStructuralFeature feature) {
    this.feature = feature;
  }
}
