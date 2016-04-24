/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Collection;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.progress.IDeferredWorkbenchAdapter;
import org.eclipse.ui.progress.IElementCollector;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public class DeferredHierarchyBuilder implements IHierarchyBuilder {
  @FinalFieldsConstructor
  public static class DeferredHierarchyNode implements IAdaptable, IDeferredWorkbenchAdapter, IHierarchyNode {
    @Delegate
    @Accessors
    private final IHierarchyNode delegate;
    
    @Extension
    private final IHierarchyBuilder hierarchyBuilder;
    
    @Override
    public Object getAdapter(final Class adapterType) {
      boolean _isInstance = adapterType.isInstance(this);
      if (_isInstance) {
        return this;
      }
      return null;
    }
    
    @Override
    public void fetchDeferredChildren(final Object object, final IElementCollector collector, final IProgressMonitor monitor) {
      final IHierarchyNode[] children = ((IHierarchyNode[])Conversions.unwrapArray(this.hierarchyBuilder.buildChildren(this.delegate, monitor), IHierarchyNode.class));
      collector.add(children, monitor);
      collector.done();
    }
    
    @Override
    public ISchedulingRule getRule(final Object object) {
      return null;
    }
    
    @Override
    public boolean isContainer() {
      return this.delegate.mayHaveChildren();
    }
    
    @Override
    public Object[] getChildren(final Object o) {
      return new Object[] {};
    }
    
    @Override
    public ImageDescriptor getImageDescriptor(final Object object) {
      return null;
    }
    
    @Override
    public String getLabel(final Object o) {
      return null;
    }
    
    @Override
    public Object getParent(final Object o) {
      return null;
    }
    
    @Pure
    public IHierarchyNode getDelegate() {
      return this.delegate;
    }
    
    public DeferredHierarchyNode(final IHierarchyNode delegate, final IHierarchyBuilder hierarchyBuilder) {
      super();
      this.delegate = delegate;
      this.hierarchyBuilder = hierarchyBuilder;
    }
    
    public IEObjectDescription getElement() {
      return this.delegate.getElement();
    }
    
    public IHierarchyNode getParent() {
      return this.delegate.getParent();
    }
    
    public Collection<IHierarchyNodeReference> getReferences() {
      return this.delegate.getReferences();
    }
    
    public boolean isRecursive() {
      return this.delegate.isRecursive();
    }
    
    public boolean mayHaveChildren() {
      return this.delegate.mayHaveChildren();
    }
    
    public Object getNavigationElement() {
      return this.delegate.getNavigationElement();
    }
  }
  
  @Accessors
  private IHierarchyBuilder hierarchyBuilder;
  
  @Override
  public Collection<IHierarchyNode> buildRoots(final URI rootURI, final IProgressMonitor monitor) {
    Collection<IHierarchyNode> _buildRoots = this.hierarchyBuilder.buildRoots(rootURI, monitor);
    final Function1<IHierarchyNode, IHierarchyNode> _function = new Function1<IHierarchyNode, IHierarchyNode>() {
      @Override
      public IHierarchyNode apply(final IHierarchyNode it) {
        return DeferredHierarchyBuilder.this.defer(it);
      }
    };
    Iterable<IHierarchyNode> _map = IterableExtensions.<IHierarchyNode, IHierarchyNode>map(_buildRoots, _function);
    Iterable<IHierarchyNode> _filterNull = IterableExtensions.<IHierarchyNode>filterNull(_map);
    return IterableExtensions.<IHierarchyNode>toList(_filterNull);
  }
  
  @Override
  public Collection<IHierarchyNode> buildChildren(final IHierarchyNode node, final IProgressMonitor monitor) {
    Collection<IHierarchyNode> _buildChildren = this.hierarchyBuilder.buildChildren(node, monitor);
    final Function1<IHierarchyNode, IHierarchyNode> _function = new Function1<IHierarchyNode, IHierarchyNode>() {
      @Override
      public IHierarchyNode apply(final IHierarchyNode it) {
        return DeferredHierarchyBuilder.this.defer(it);
      }
    };
    Iterable<IHierarchyNode> _map = IterableExtensions.<IHierarchyNode, IHierarchyNode>map(_buildChildren, _function);
    Iterable<IHierarchyNode> _filterNull = IterableExtensions.<IHierarchyNode>filterNull(_map);
    return IterableExtensions.<IHierarchyNode>toList(_filterNull);
  }
  
  protected IHierarchyNode defer(final IHierarchyNode node) {
    DeferredHierarchyBuilder.DeferredHierarchyNode _xifexpression = null;
    if ((node != null)) {
      _xifexpression = new DeferredHierarchyBuilder.DeferredHierarchyNode(node, this);
    }
    return _xifexpression;
  }
  
  @Pure
  public IHierarchyBuilder getHierarchyBuilder() {
    return this.hierarchyBuilder;
  }
  
  public void setHierarchyBuilder(final IHierarchyBuilder hierarchyBuilder) {
    this.hierarchyBuilder = hierarchyBuilder;
  }
}
