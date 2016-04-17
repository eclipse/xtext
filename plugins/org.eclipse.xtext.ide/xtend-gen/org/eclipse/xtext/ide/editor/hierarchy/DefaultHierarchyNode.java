/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.Collection;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class DefaultHierarchyNode implements HierarchyNode {
  @Accessors
  private HierarchyNode parent;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean mayHaveChildren;
  
  @Accessors
  private IEObjectDescription element;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final ArrayList<HierarchyNodeReference> references = CollectionLiterals.<HierarchyNodeReference>newArrayList();
  
  private Wrapper<Boolean> recursive;
  
  @Override
  public Object getNavigationElement() {
    Object _elvis = null;
    HierarchyNodeReference _head = IterableExtensions.<HierarchyNodeReference>head(this.references);
    if (_head != null) {
      _elvis = _head;
    } else {
      _elvis = this.element;
    }
    return _elvis;
  }
  
  @Override
  public boolean isRecursive() {
    if ((this.recursive == null)) {
      boolean _internalIsRecursive = this.internalIsRecursive();
      Wrapper<Boolean> _wrap = Wrapper.<Boolean>wrap(Boolean.valueOf(_internalIsRecursive));
      this.recursive = _wrap;
    }
    return (this.recursive.get()).booleanValue();
  }
  
  protected boolean internalIsRecursive() {
    HierarchyNode node = this.parent;
    while ((node != null)) {
      {
        IEObjectDescription _element = node.getElement();
        URI _eObjectURI = _element.getEObjectURI();
        URI _eObjectURI_1 = this.element.getEObjectURI();
        boolean _equals = Objects.equal(_eObjectURI, _eObjectURI_1);
        if (_equals) {
          return true;
        }
        HierarchyNode _parent = node.getParent();
        node = _parent;
      }
    }
    return false;
  }
  
  @Override
  public boolean mayHaveChildren() {
    return this.mayHaveChildren;
  }
  
  @Pure
  public HierarchyNode getParent() {
    return this.parent;
  }
  
  public void setParent(final HierarchyNode parent) {
    this.parent = parent;
  }
  
  public void setMayHaveChildren(final boolean mayHaveChildren) {
    this.mayHaveChildren = mayHaveChildren;
  }
  
  @Pure
  public IEObjectDescription getElement() {
    return this.element;
  }
  
  public void setElement(final IEObjectDescription element) {
    this.element = element;
  }
  
  @Pure
  public Collection<HierarchyNodeReference> getReferences() {
    return this.references;
  }
}
