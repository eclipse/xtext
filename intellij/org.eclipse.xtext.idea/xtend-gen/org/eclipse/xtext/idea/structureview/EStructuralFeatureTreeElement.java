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
import com.intellij.ide.util.treeView.NodeDescriptorProvidingKey;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.AbstractStructureViewTreeElement;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class EStructuralFeatureTreeElement extends AbstractStructureViewTreeElement implements NodeDescriptorProvidingKey {
  @Accessors
  private EObject owner;
  
  @Accessors
  private EStructuralFeature feature;
  
  protected PsiElement getInternalElement() {
    List<INode> _findNodesForFeature = NodeModelUtils.findNodesForFeature(this.owner, this.feature);
    final Function1<INode, Iterable<ILeafNode>> _function = new Function1<INode, Iterable<ILeafNode>>() {
      public Iterable<ILeafNode> apply(final INode it) {
        return it.getLeafNodes();
      }
    };
    List<Iterable<ILeafNode>> _map = ListExtensions.<INode, Iterable<ILeafNode>>map(_findNodesForFeature, _function);
    Iterable<ILeafNode> _flatten = Iterables.<ILeafNode>concat(_map);
    final Function1<ILeafNode, Boolean> _function_1 = new Function1<ILeafNode, Boolean>() {
      public Boolean apply(final ILeafNode it) {
        boolean _isHidden = it.isHidden();
        return Boolean.valueOf((!_isHidden));
      }
    };
    Iterable<ILeafNode> _filter = IterableExtensions.<ILeafNode>filter(_flatten, _function_1);
    ILeafNode _head = IterableExtensions.<ILeafNode>head(_filter);
    List<ASTNode> _aSTNodes = this.xtextFile.getASTNodes(_head);
    final Function1<ASTNode, PsiElement> _function_2 = new Function1<ASTNode, PsiElement>() {
      public PsiElement apply(final ASTNode it) {
        return it.getPsi();
      }
    };
    List<PsiElement> _map_1 = ListExtensions.<ASTNode, PsiElement>map(_aSTNodes, _function_2);
    return IterableExtensions.<PsiElement>head(_map_1);
  }
  
  protected Object getObjectToPresent() {
    return this.owner;
  }
  
  public Object getKey() {
    return this.feature;
  }
  
  public boolean equals(final Object obj) {
    boolean _xifexpression = false;
    if ((this == obj)) {
      _xifexpression = true;
    } else {
      boolean _xifexpression_1 = false;
      if ((obj instanceof EStructuralFeatureTreeElement)) {
        _xifexpression_1 = Objects.equal(this.feature, ((EStructuralFeatureTreeElement)obj).feature);
      } else {
        _xifexpression_1 = false;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
  
  public int hashCode() {
    return this.feature.hashCode();
  }
  
  @Pure
  public EObject getOwner() {
    return this.owner;
  }
  
  public void setOwner(final EObject owner) {
    this.owner = owner;
  }
  
  @Pure
  public EStructuralFeature getFeature() {
    return this.feature;
  }
  
  public void setFeature(final EStructuralFeature feature) {
    this.feature = feature;
  }
}
