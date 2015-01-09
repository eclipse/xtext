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
import com.intellij.ide.structureView.StructureViewTreeElement;
import com.intellij.ide.util.treeView.smartTree.TreeElement;
import com.intellij.navigation.ItemPresentation;
import com.intellij.pom.Navigatable;
import com.intellij.psi.PsiElement;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.ModifiableStructureViewTreeElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public abstract class AbstractStructureViewTreeElement implements ModifiableStructureViewTreeElement {
  @Accessors
  private IStructureViewTreeElementProvider structureViewTreeElementProvider;
  
  @Accessors
  private boolean leaf;
  
  private List<StructureViewTreeElement> children;
  
  @Accessors
  private ItemPresentation itemPresentation;
  
  @Accessors
  @Extension
  protected BaseXtextFile xtextFile;
  
  public Object getValue() {
    return this.getElement();
  }
  
  protected PsiElement getElement() {
    PsiElement _xblockexpression = null;
    {
      final PsiElement element = this.getInternalElement();
      PsiElement _xifexpression = null;
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(element, null));
      if (!_notEquals) {
        _and = false;
      } else {
        boolean _isValid = element.isValid();
        _and = _isValid;
      }
      if (_and) {
        _xifexpression = element;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  protected abstract PsiElement getInternalElement();
  
  public TreeElement[] getChildren() {
    List<StructureViewTreeElement> _xblockexpression = null;
    {
      if (this.leaf) {
        return ((TreeElement[])Conversions.unwrapArray(CollectionLiterals.<TreeElement>emptyList(), TreeElement.class));
      }
      boolean _equals = Objects.equal(this.children, null);
      if (_equals) {
        ArrayList<StructureViewTreeElement> _newArrayList = CollectionLiterals.<StructureViewTreeElement>newArrayList();
        this.children = _newArrayList;
        this.structureViewTreeElementProvider.buildChildren(this);
      }
      boolean _equals_1 = Objects.equal(this.children, null);
      if (_equals_1) {
        return ((TreeElement[])Conversions.unwrapArray(CollectionLiterals.<TreeElement>emptyList(), TreeElement.class));
      }
      _xblockexpression = this.children;
    }
    return ((TreeElement[])Conversions.unwrapArray(_xblockexpression, TreeElement.class));
  }
  
  public boolean addChild(final StructureViewTreeElement child) {
    boolean _xifexpression = false;
    boolean _notEquals = (!Objects.equal(child, null));
    if (_notEquals) {
      boolean _xblockexpression = false;
      {
        boolean _equals = Objects.equal(this.children, null);
        if (_equals) {
          ArrayList<StructureViewTreeElement> _newArrayList = CollectionLiterals.<StructureViewTreeElement>newArrayList();
          this.children = _newArrayList;
        }
        this.leaf = false;
        _xblockexpression = this.children.add(child);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  public boolean addChildren(final Iterable<StructureViewTreeElement> children) {
    boolean _xblockexpression = false;
    {
      final Iterable<StructureViewTreeElement> notNullChildren = IterableExtensions.<StructureViewTreeElement>filterNull(children);
      boolean _xifexpression = false;
      boolean _isEmpty = IterableExtensions.isEmpty(notNullChildren);
      boolean _not = (!_isEmpty);
      if (_not) {
        boolean _xblockexpression_1 = false;
        {
          boolean _equals = Objects.equal(this.children, null);
          if (_equals) {
            ArrayList<StructureViewTreeElement> _newArrayList = CollectionLiterals.<StructureViewTreeElement>newArrayList();
            this.children = _newArrayList;
          }
          this.leaf = false;
          _xblockexpression_1 = Iterables.<StructureViewTreeElement>addAll(this.children, notNullChildren);
        }
        _xifexpression = _xblockexpression_1;
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ItemPresentation getPresentation() {
    return this.itemPresentation;
  }
  
  protected abstract Object getObjectToPresent();
  
  public boolean canNavigate() {
    boolean _xblockexpression = false;
    {
      final PsiElement element = this.getElement();
      boolean _xifexpression = false;
      if ((element instanceof Navigatable)) {
        _xifexpression = ((Navigatable)element).canNavigate();
      } else {
        _xifexpression = false;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public boolean canNavigateToSource() {
    return this.canNavigate();
  }
  
  public void navigate(final boolean requestFocus) {
    final PsiElement element = this.getElement();
    if ((element instanceof Navigatable)) {
      ((Navigatable)element).navigate(requestFocus);
    }
  }
  
  @Pure
  public IStructureViewTreeElementProvider getStructureViewTreeElementProvider() {
    return this.structureViewTreeElementProvider;
  }
  
  public void setStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider) {
    this.structureViewTreeElementProvider = structureViewTreeElementProvider;
  }
  
  @Pure
  public boolean isLeaf() {
    return this.leaf;
  }
  
  public void setLeaf(final boolean leaf) {
    this.leaf = leaf;
  }
  
  @Pure
  public ItemPresentation getItemPresentation() {
    return this.itemPresentation;
  }
  
  public void setItemPresentation(final ItemPresentation itemPresentation) {
    this.itemPresentation = itemPresentation;
  }
  
  @Pure
  public BaseXtextFile getXtextFile() {
    return this.xtextFile;
  }
  
  public void setXtextFile(final BaseXtextFile xtextFile) {
    this.xtextFile = xtextFile;
  }
}
