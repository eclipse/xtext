/**
 * Copyright (c) 2016, 2020 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.editor.hierarchy;

import java.util.Arrays;
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
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableLayout;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder;
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder.CallHierarchyType;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNodeReference;
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot;
import org.eclipse.xtext.ui.editor.navigation.NavigationService;
import org.eclipse.xtext.xbase.lib.Pair;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
public abstract class AbstractCallHierarchyViewPart extends AbstractHierarchyViewPart implements ISelectionChangedListener {

	@Inject
	private NavigationService navigationService;

	private TableViewer locationViewer;

	private TreeViewer callHierarchyViewer;

	private final RefreshHierarchyAction refreshAction = new RefreshHierarchyAction(this);

	private final SetHierarchyTypeAction[] setHierarchyTypeActions = new SetHierarchyTypeAction[] {
			new SetHierarchyTypeAction(CallHierarchyType.CALLER, this), //
			new SetHierarchyTypeAction(CallHierarchyType.CALLEE, this) };

	protected ICallHierarchyBuilder getCallHierarchyBuilder() {
		return getBuilder(ICallHierarchyBuilder.class);
	}

	public void setCallHierarchyType(CallHierarchyType hierarchyType) {
		ICallHierarchyBuilder callHierarchyBuilder = getCallHierarchyBuilder();
		if (callHierarchyBuilder != null) {
			callHierarchyBuilder.setHierarchyType(hierarchyType);
		}
		refresh(new NullProgressMonitor());
	}

	@Override
	public void refresh(IProgressMonitor monitor) {
		CallHierarchyType hierarchyType = getCallHierarchyBuilder() != null ? getCallHierarchyBuilder().getHierarchyType() : null;
		for (SetHierarchyTypeAction setHierarchyTypeAction : setHierarchyTypeActions) {
			setHierarchyTypeAction.setChecked(hierarchyType == setHierarchyTypeAction.getHierarchyType());
		}
		super.refresh(monitor);
	}

	@Override
	public void setRoot(IHierarchyRoot root) {
		callHierarchyViewer.setInput(root);
		setFocus();
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite layout = createLayout(parent);
		callHierarchyViewer = createCallHierarchyViewer(layout);
		locationViewer = createLocationViewer(layout);
		navigationService.installNavigationSupport(locationViewer);
		navigationService.installNavigationSupport(callHierarchyViewer);
		callHierarchyViewer.addSelectionChangedListener(this);
		addActions(getViewSite().getActionBars().getToolBarManager());
	}

	protected void addActions(IToolBarManager toolBarManager) {
		toolBarManager.add(refreshAction);
		for (SetHierarchyTypeAction setHierarchyTypeAction : setHierarchyTypeActions) {
			toolBarManager.add(setHierarchyTypeAction);
		}
	}

	protected Composite createLayout(Composite parent) {
		return new SashForm(parent, SWT.NONE);
	}

	protected TreeViewer createCallHierarchyViewer(Composite parent) {
		TreeViewer treeViewer = new TreeViewer(parent);
		treeViewer.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		treeViewer.setUseHashlookup(true);
		treeViewer.setAutoExpandLevel(2);
		treeViewer.setLabelProvider(createHierarchyLabelProvider());
		treeViewer.setContentProvider(createHierarchyContentProvider());
		return treeViewer;
	}

	protected IContentProvider createHierarchyContentProvider() {
		return new HierarchyTreeContentProvider(this);
	}

	protected abstract IBaseLabelProvider createHierarchyLabelProvider();

	protected TableViewer createLocationViewer(Composite parent) {
		TableViewer locationViewer = new TableViewer(parent);
		locationViewer.setContentProvider(new ArrayContentProvider());
		locationViewer.setLabelProvider(createLocationLabelProvider());

		TableLayout layout = new TableLayout();
		locationViewer.getTable().setLayout(layout);
		locationViewer.getTable().setHeaderVisible(true);

		List<Pair<String, ColumnLayoutData>> locationColumnDescriptions = getLocationColumnDescriptionList();
		int index = 0;
		for(Pair<String, ColumnLayoutData> e : locationColumnDescriptions) {
			layout.addColumnData(e.getValue());
			createColumn(locationViewer.getTable(), e, index);
			index++;
		}

		return locationViewer;
	}
	
	protected List<Pair<String, ColumnLayoutData>> getLocationColumnDescriptionList() {
		return Arrays.asList(getLocationColumnDescriptions());
	}

	@Deprecated(since = "2.30", forRemoval = true) @SuppressWarnings("unchecked")
	protected Pair<String, ColumnLayoutData>[] getLocationColumnDescriptions() {
		@SuppressWarnings("rawtypes")
		Pair[] result = new Pair[] { Pair.of("Line", new ColumnWeightData(60)), Pair.of("Call", new ColumnWeightData(300)) };
		return result;
	}

	protected void createColumn(Table table, Pair<String, ColumnLayoutData> columnDescription, int index) {
		TableColumn column = new TableColumn(table, SWT.NONE, index);
		column.setResizable(columnDescription.getValue().resizable);
		column.setText(columnDescription.getKey());
	}

	protected abstract IBaseLabelProvider createLocationLabelProvider();

	@Override
	public void setFocus() {
		callHierarchyViewer.getControl().setFocus();
	}

	@Override
	public void selectionChanged(SelectionChangedEvent event) {
		if (event.getSelectionProvider() == callHierarchyViewer) {
			IHierarchyNode callHierarchyNode = getSelectedNode(event.getSelection());
			onCallHierarchyNodeChanged(callHierarchyNode);
		}
	}

	protected void onCallHierarchyNodeChanged(IHierarchyNode node) {
		Collection<IHierarchyNodeReference> input = Collections.emptyList();
		if (node != null && node.getReferences() != null) {
			input = node.getReferences();
		}
		locationViewer.setInput(input);
		navigationService.open(node);
		setFocus();
	}
}
