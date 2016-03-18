/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.List;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNodeLocation;
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyRoot;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractHierarchyViewPart;
import org.eclipse.xtext.ui.editor.hierarchy.HierarchyTreeContentProvider;
import org.eclipse.xtext.ui.editor.hierarchy.LocationTableViewer;
import org.eclipse.xtext.ui.editor.navigation.NavigationService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@SuppressWarnings("all")
public abstract class AbstractCallHierarchyViewPart extends AbstractHierarchyViewPart implements ISelectionChangedListener {
  @Inject
  private NavigationService navigationService;
  
  private TableViewer locationViewer;
  
  private TreeViewer callHierarchyViewer;
  
  @Override
  public void setRoot(final HierarchyRoot root) {
    this.callHierarchyViewer.setInput(root);
    this.setFocus();
  }
  
  @Override
  public void createPartControl(final Composite parent) {
    final Composite layout = this.createLayout(parent);
    TreeViewer _createCallHierarchyViewer = this.createCallHierarchyViewer(layout);
    this.callHierarchyViewer = _createCallHierarchyViewer;
    TableViewer _createLocationViewer = this.createLocationViewer(layout);
    this.locationViewer = _createLocationViewer;
    this.navigationService.installNavigationSupport(this.locationViewer);
    this.navigationService.installNavigationSupport(this.callHierarchyViewer);
    this.callHierarchyViewer.addSelectionChangedListener(this);
  }
  
  protected Composite createLayout(final Composite parent) {
    return new SashForm(parent, SWT.NONE);
  }
  
  protected TreeViewer createCallHierarchyViewer(final Composite parent) {
    final TreeViewer treeViewer = new TreeViewer(parent);
    Control _control = treeViewer.getControl();
    GridData _gridData = new GridData(GridData.FILL_BOTH);
    _control.setLayoutData(_gridData);
    treeViewer.setUseHashlookup(true);
    treeViewer.setAutoExpandLevel(2);
    IBaseLabelProvider _createHierarchyLabelProvider = this.createHierarchyLabelProvider();
    treeViewer.setLabelProvider(_createHierarchyLabelProvider);
    IContentProvider _createHierarchyContentProvider = this.createHierarchyContentProvider();
    treeViewer.setContentProvider(_createHierarchyContentProvider);
    return treeViewer;
  }
  
  protected IContentProvider createHierarchyContentProvider() {
    return new HierarchyTreeContentProvider(this);
  }
  
  protected abstract IBaseLabelProvider createHierarchyLabelProvider();
  
  protected TableViewer createLocationViewer(final Composite parent) {
    final LocationTableViewer locationViewer = new LocationTableViewer(parent);
    IBaseLabelProvider _createLocationLabelProvider = this.createLocationLabelProvider();
    locationViewer.setLabelProvider(_createLocationLabelProvider);
    return locationViewer;
  }
  
  protected abstract IBaseLabelProvider createLocationLabelProvider();
  
  @Override
  public void setFocus() {
    Control _control = this.callHierarchyViewer.getControl();
    _control.setFocus();
  }
  
  @Override
  public void selectionChanged(final SelectionChangedEvent event) {
    ISelectionProvider _selectionProvider = event.getSelectionProvider();
    boolean _tripleEquals = (_selectionProvider == this.callHierarchyViewer);
    if (_tripleEquals) {
      ISelection _selection = event.getSelection();
      final HierarchyNode callHierarchyNode = this.getSelectedNode(_selection);
      this.onCallHierarchyNodeChanged(callHierarchyNode);
    }
  }
  
  protected void onCallHierarchyNodeChanged(final HierarchyNode node) {
    Collection<HierarchyNodeLocation> _elvis = null;
    Collection<HierarchyNodeLocation> _locations = null;
    if (node!=null) {
      _locations=node.getLocations();
    }
    if (_locations != null) {
      _elvis = _locations;
    } else {
      List<HierarchyNodeLocation> _emptyList = CollectionLiterals.<HierarchyNodeLocation>emptyList();
      _elvis = _emptyList;
    }
    this.locationViewer.setInput(_elvis);
    this.navigationService.open(node);
    this.setFocus();
  }
}
