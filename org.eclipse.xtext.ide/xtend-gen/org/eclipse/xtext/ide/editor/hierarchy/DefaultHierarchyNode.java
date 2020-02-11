/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.hierarchy;

import com.google.common.base.Objects;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
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
public class DefaultHierarchyNode implements IHierarchyNode {
  @Accessors
  private IHierarchyNode parent;
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private boolean mayHaveChildren;
  
  @Accessors
  private IEObjectDescription element;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final List<IHierarchyNodeReference> references = CollectionLiterals.<IHierarchyNodeReference>newArrayList();
  
  private Wrapper<Boolean> recursive;
  
  @Override
  public Object getNavigationElement() {
    Object _elvis = null;
    IHierarchyNodeReference _head = IterableExtensions.<IHierarchyNodeReference>head(this.references);
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
      this.recursive = Wrapper.<Boolean>wrap(Boolean.valueOf(this.internalIsRecursive()));
    }
    return (this.recursive.get()).booleanValue();
  }
  
  protected boolean internalIsRecursive() {
    IHierarchyNode node = this.parent;
    while ((node != null)) {
      {
        URI _eObjectURI = node.getElement().getEObjectURI();
        URI _eObjectURI_1 = this.element.getEObjectURI();
        boolean _equals = Objects.equal(_eObjectURI, _eObjectURI_1);
        if (_equals) {
          return true;
        }
        node = node.getParent();
      }
    }
    return false;
  }
  
  @Override
  public boolean mayHaveChildren() {
    return this.mayHaveChildren;
  }
  
  @Pure
  public IHierarchyNode getParent() {
    return this.parent;
  }
  
  public void setParent(final IHierarchyNode parent) {
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
  public List<IHierarchyNodeReference> getReferences() {
    return this.references;
  }
}
