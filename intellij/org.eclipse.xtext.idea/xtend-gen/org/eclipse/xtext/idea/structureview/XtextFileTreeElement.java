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
import com.intellij.ide.structureView.impl.common.PsiTreeElementBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.structureview.IStructureViewTreeElementProvider;
import org.eclipse.xtext.idea.structureview.ModifiableStructureViewTreeElement;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class XtextFileTreeElement extends PsiTreeElementBase<BaseXtextFile> implements ModifiableStructureViewTreeElement {
  private List<StructureViewTreeElement> children;
  
  @Accessors
  private IStructureViewTreeElementProvider structureViewTreeElementProvider;
  
  public XtextFileTreeElement(final BaseXtextFile psiElement) {
    super(psiElement);
  }
  
  @Override
  public Collection<StructureViewTreeElement> getChildrenBase() {
    List<StructureViewTreeElement> _xblockexpression = null;
    {
      this.children = null;
      this.structureViewTreeElementProvider.buildChildren(this);
      boolean _equals = Objects.equal(this.children, null);
      if (_equals) {
        return CollectionLiterals.<StructureViewTreeElement>emptyList();
      }
      _xblockexpression = this.children;
    }
    return _xblockexpression;
  }
  
  @Override
  public String getPresentableText() {
    BaseXtextFile _element = this.getElement();
    return _element.getName();
  }
  
  @Override
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
        _xblockexpression = this.children.add(child);
      }
      _xifexpression = _xblockexpression;
    } else {
      _xifexpression = false;
    }
    return _xifexpression;
  }
  
  @Override
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
  
  @Pure
  public IStructureViewTreeElementProvider getStructureViewTreeElementProvider() {
    return this.structureViewTreeElementProvider;
  }
  
  public void setStructureViewTreeElementProvider(final IStructureViewTreeElementProvider structureViewTreeElementProvider) {
    this.structureViewTreeElementProvider = structureViewTreeElementProvider;
  }
}
