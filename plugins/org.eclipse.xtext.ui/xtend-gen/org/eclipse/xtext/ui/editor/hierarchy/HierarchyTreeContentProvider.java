/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Collection;
import org.eclipse.jface.viewers.AbstractTreeViewer;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.DeferredTreeContentManager;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class HierarchyTreeContentProvider implements ITreeContentProvider {
  private final static Object[] EMPTY_ARRAY = {};
  
  private final ViewPart viewPart;
  
  private DeferredTreeContentManager deferredTreeContentManager;
  
  @Override
  public Object[] getChildren(final Object parentElement) {
    final Object[] children = this.deferredTreeContentManager.getChildren(parentElement);
    Object[] _elvis = null;
    if (children != null) {
      _elvis = children;
    } else {
      _elvis = HierarchyTreeContentProvider.EMPTY_ARRAY;
    }
    return _elvis;
  }
  
  @Override
  public Object[] getElements(final Object inputElement) {
    if ((inputElement instanceof IHierarchyRoot)) {
      Collection<IHierarchyNode> _roots = ((IHierarchyRoot)inputElement).getRoots();
      return ((Object[])Conversions.unwrapArray(IterableExtensions.<IHierarchyNode>filterNull(_roots), Object.class));
    }
    return HierarchyTreeContentProvider.EMPTY_ARRAY;
  }
  
  @Override
  public Object getParent(final Object element) {
    IHierarchyNode _xifexpression = null;
    if ((element instanceof IHierarchyNode)) {
      _xifexpression = ((IHierarchyNode)element).getParent();
    }
    return _xifexpression;
  }
  
  @Override
  public boolean hasChildren(final Object element) {
    return this.deferredTreeContentManager.mayHaveChildren(element);
  }
  
  @Override
  public void dispose() {
  }
  
  @Override
  public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
    if ((viewer instanceof AbstractTreeViewer)) {
      IWorkbenchPartSite _site = this.viewPart.getSite();
      DeferredTreeContentManager _deferredTreeContentManager = new DeferredTreeContentManager(((AbstractTreeViewer)viewer), _site);
      this.deferredTreeContentManager = _deferredTreeContentManager;
    }
  }
  
  public HierarchyTreeContentProvider(final ViewPart viewPart) {
    super();
    this.viewPart = viewPart;
  }
}
