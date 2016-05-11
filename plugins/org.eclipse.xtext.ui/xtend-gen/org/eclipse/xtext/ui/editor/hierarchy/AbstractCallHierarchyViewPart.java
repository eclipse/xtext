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
import java.util.Collections;
import java.util.List;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLayoutData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;
import org.eclipse.xtext.ui.editor.hierarchy.AbstractHierarchyViewPart;
import org.eclipse.xtext.ui.editor.hierarchy.HierarchyTreeContentProvider;
import org.eclipse.xtext.ui.editor.hierarchy.RefreshHierarchyAction;
import org.eclipse.xtext.ui.editor.hierarchy.SetHierarchyTypeAction;
import org.eclipse.xtext.ui.editor.navigation.NavigationService;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

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
  
  private final RefreshHierarchyAction refreshAction = new RefreshHierarchyAction(this);
  
  private final List<SetHierarchyTypeAction> setHierarchyTypeActions = Collections.<SetHierarchyTypeAction>unmodifiableList(CollectionLiterals.<SetHierarchyTypeAction>newArrayList(new SetHierarchyTypeAction(ICallHierarchyBuilder.CallHierarchyType.CALLER, this), new SetHierarchyTypeAction(ICallHierarchyBuilder.CallHierarchyType.CALLEE, this)));
  
  protected ICallHierarchyBuilder getCallHierarchyBuilder() {
    return this.<ICallHierarchyBuilder>getBuilder(ICallHierarchyBuilder.class);
  }
  
  public void setCallHierarchyType(final ICallHierarchyBuilder.CallHierarchyType hierarchyType) {
    ICallHierarchyBuilder _callHierarchyBuilder = this.getCallHierarchyBuilder();
    if (_callHierarchyBuilder!=null) {
      _callHierarchyBuilder.setHierarchyType(hierarchyType);
    }
    NullProgressMonitor _nullProgressMonitor = new NullProgressMonitor();
    this.refresh(_nullProgressMonitor);
  }
  
  @Override
  public void refresh(final IProgressMonitor monitor) {
    ICallHierarchyBuilder _callHierarchyBuilder = this.getCallHierarchyBuilder();
    ICallHierarchyBuilder.CallHierarchyType _hierarchyType = null;
    if (_callHierarchyBuilder!=null) {
      _hierarchyType=_callHierarchyBuilder.getHierarchyType();
    }
    final ICallHierarchyBuilder.CallHierarchyType hierarchyType = _hierarchyType;
    for (final SetHierarchyTypeAction setHierarchyTypeAction : this.setHierarchyTypeActions) {
      ICallHierarchyBuilder.CallHierarchyType _hierarchyType_1 = setHierarchyTypeAction.getHierarchyType();
      boolean _tripleEquals = (hierarchyType == _hierarchyType_1);
      setHierarchyTypeAction.setChecked(_tripleEquals);
    }
    super.refresh(monitor);
  }
  
  @Override
  public void setRoot(final IHierarchyRoot root) {
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
    IViewSite _viewSite = this.getViewSite();
    IActionBars _actionBars = _viewSite.getActionBars();
    IToolBarManager _toolBarManager = _actionBars.getToolBarManager();
    this.addActions(_toolBarManager);
  }
  
  protected void addActions(final IToolBarManager toolBarManager) {
    toolBarManager.add(this.refreshAction);
    for (final SetHierarchyTypeAction setHierarchyTypeAction : this.setHierarchyTypeActions) {
      toolBarManager.add(setHierarchyTypeAction);
    }
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
    final TableViewer locationViewer = new TableViewer(parent);
    ArrayContentProvider _arrayContentProvider = new ArrayContentProvider();
    locationViewer.setContentProvider(_arrayContentProvider);
    IBaseLabelProvider _createLocationLabelProvider = this.createLocationLabelProvider();
    locationViewer.setLabelProvider(_createLocationLabelProvider);
    final TableLayout layout = new TableLayout();
    Table _table = locationViewer.getTable();
    _table.setLayout(layout);
    Table _table_1 = locationViewer.getTable();
    _table_1.setHeaderVisible(true);
    Pair<String, ColumnLayoutData>[] _locationColumnDescriptions = this.getLocationColumnDescriptions();
    Iterable<Pair<Integer, Pair<String, ColumnLayoutData>>> _indexed = IterableExtensions.<Pair<String, ColumnLayoutData>>indexed(((Iterable<? extends Pair<String, ColumnLayoutData>>)Conversions.doWrapArray(_locationColumnDescriptions)));
    final Procedure1<Pair<Integer, Pair<String, ColumnLayoutData>>> _function = new Procedure1<Pair<Integer, Pair<String, ColumnLayoutData>>>() {
      @Override
      public void apply(final Pair<Integer, Pair<String, ColumnLayoutData>> it) {
        Pair<String, ColumnLayoutData> _value = it.getValue();
        ColumnLayoutData _value_1 = _value.getValue();
        layout.addColumnData(_value_1);
        Table _table = locationViewer.getTable();
        Pair<String, ColumnLayoutData> _value_2 = it.getValue();
        Integer _key = it.getKey();
        AbstractCallHierarchyViewPart.this.createColumn(_table, _value_2, (_key).intValue());
      }
    };
    IterableExtensions.<Pair<Integer, Pair<String, ColumnLayoutData>>>forEach(_indexed, _function);
    return locationViewer;
  }
  
  protected Pair<String, ColumnLayoutData>[] getLocationColumnDescriptions() {
    ColumnWeightData _columnWeightData = new ColumnWeightData(60);
    Pair<String, ColumnLayoutData> _mappedTo = Pair.<String, ColumnLayoutData>of("Line", _columnWeightData);
    ColumnWeightData _columnWeightData_1 = new ColumnWeightData(300);
    Pair<String, ColumnLayoutData> _mappedTo_1 = Pair.<String, ColumnLayoutData>of("Call", _columnWeightData_1);
    return new Pair[] { _mappedTo, _mappedTo_1 };
  }
  
  protected void createColumn(final Table table, final Pair<String, ColumnLayoutData> columnDescription, final int index) {
    final TableColumn column = new TableColumn(table, SWT.NONE, index);
    ColumnLayoutData _value = columnDescription.getValue();
    column.setResizable(_value.resizable);
    String _key = columnDescription.getKey();
    column.setText(_key);
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
      final IHierarchyNode callHierarchyNode = this.getSelectedNode(_selection);
      this.onCallHierarchyNodeChanged(callHierarchyNode);
    }
  }
  
  protected void onCallHierarchyNodeChanged(final IHierarchyNode node) {
    Collection<IHierarchyNodeReference> _elvis = null;
    Collection<IHierarchyNodeReference> _references = null;
    if (node!=null) {
      _references=node.getReferences();
    }
    if (_references != null) {
      _elvis = _references;
    } else {
      List<IHierarchyNodeReference> _emptyList = CollectionLiterals.<IHierarchyNodeReference>emptyList();
      _elvis = _emptyList;
    }
    this.locationViewer.setInput(_elvis);
    this.navigationService.open(node);
    this.setFocus();
  }
}
