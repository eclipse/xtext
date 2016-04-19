/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.common.collect.Iterables;
import java.util.Collection;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyRoot;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyRoot;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors({ AccessorType.PUBLIC_SETTER, AccessorType.PROTECTED_GETTER })
@SuppressWarnings("all")
public abstract class AbstractHierarchyViewPart extends ViewPart {
  private HierarchyBuilder builder;
  
  private URI rootURI;
  
  public void refresh(final IProgressMonitor monitor) {
    HierarchyRoot _createRoot = this.createRoot(monitor);
    this.setRoot(_createRoot);
  }
  
  protected HierarchyRoot createRoot(final IProgressMonitor monitor) {
    if (((this.builder == null) || (this.rootURI == null))) {
      return HierarchyRoot.EMPTY;
    }
    final Collection<HierarchyNode> roots = this.builder.buildRoots(this.rootURI, monitor);
    boolean _isEmpty = roots.isEmpty();
    if (_isEmpty) {
      return HierarchyRoot.EMPTY;
    }
    final DefaultHierarchyRoot root = new DefaultHierarchyRoot();
    Collection<HierarchyNode> _roots = root.getRoots();
    Iterables.<HierarchyNode>addAll(_roots, roots);
    return root;
  }
  
  protected abstract void setRoot(final HierarchyRoot root);
  
  protected HierarchyNode getSelectedNode(final ISelection selection) {
    boolean _matched = false;
    if (selection instanceof IStructuredSelection) {
      int _size = ((IStructuredSelection)selection).size();
      boolean _equals = (_size == 1);
      if (_equals) {
        _matched=true;
        final Object selectedElement = ((IStructuredSelection)selection).getFirstElement();
        if ((selectedElement instanceof HierarchyNode)) {
          return ((HierarchyNode)selectedElement);
        }
      }
    }
    return null;
  }
  
  @Pure
  protected HierarchyBuilder getBuilder() {
    return this.builder;
  }
  
  public void setBuilder(final HierarchyBuilder builder) {
    this.builder = builder;
  }
  
  @Pure
  protected URI getRootURI() {
    return this.rootURI;
  }
  
  public void setRootURI(final URI rootURI) {
    this.rootURI = rootURI;
  }
}
