/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.jface.action.IToolBarManager
import org.eclipse.jface.viewers.ArrayContentProvider
import org.eclipse.jface.viewers.ColumnLayoutData
import org.eclipse.jface.viewers.ColumnWeightData
import org.eclipse.jface.viewers.IBaseLabelProvider
import org.eclipse.jface.viewers.IContentProvider
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.SelectionChangedEvent
import org.eclipse.jface.viewers.TableLayout
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.swt.widgets.Table
import org.eclipse.swt.widgets.TableColumn
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.ICallHierarchyBuilder.CallHierarchyType
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot
import org.eclipse.xtext.ui.editor.navigation.NavigationService

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
abstract class AbstractCallHierarchyViewPart extends AbstractHierarchyViewPart implements ISelectionChangedListener {

	@Inject
	NavigationService navigationService

	TableViewer locationViewer
	TreeViewer callHierarchyViewer

	val refreshAction = new RefreshHierarchyAction(this)
	val setHierarchyTypeActions = #[
		new SetHierarchyTypeAction(CallHierarchyType.CALLER, this),
		new SetHierarchyTypeAction(CallHierarchyType.CALLEE, this)
	]

	protected def getCallHierarchyBuilder() {
		getBuilder(ICallHierarchyBuilder)
	}

	def void setCallHierarchyType(CallHierarchyType hierarchyType) {
		callHierarchyBuilder?.setHierarchyType(hierarchyType)
		refresh(new NullProgressMonitor)
	}

	override refresh(IProgressMonitor monitor) {
		val hierarchyType = callHierarchyBuilder?.hierarchyType
		for (setHierarchyTypeAction : setHierarchyTypeActions) {
			setHierarchyTypeAction.checked = hierarchyType === setHierarchyTypeAction.hierarchyType
		}
		super.refresh(monitor)
	}

	override void setRoot(IHierarchyRoot root) {
		callHierarchyViewer.input = root
		setFocus
	}

	override createPartControl(Composite parent) {
		val layout = createLayout(parent)
		callHierarchyViewer = createCallHierarchyViewer(layout)
		locationViewer = createLocationViewer(layout)

		navigationService.installNavigationSupport(locationViewer)
		navigationService.installNavigationSupport(callHierarchyViewer)
		callHierarchyViewer.addSelectionChangedListener(this)

		viewSite.actionBars.toolBarManager.addActions
	}

	protected def void addActions(IToolBarManager toolBarManager) {
		toolBarManager.add(refreshAction)
		for (setHierarchyTypeAction : setHierarchyTypeActions)
			toolBarManager.add(setHierarchyTypeAction)
	}

	protected def Composite createLayout(Composite parent) {
		return new SashForm(parent, SWT.NONE)
	}

	protected def TreeViewer createCallHierarchyViewer(Composite parent) {
		val treeViewer = new TreeViewer(parent)
		treeViewer.control.layoutData = new GridData(GridData.FILL_BOTH)
		treeViewer.useHashlookup = true
		treeViewer.autoExpandLevel = 2
		treeViewer.labelProvider = createHierarchyLabelProvider
		treeViewer.contentProvider = createHierarchyContentProvider
		return treeViewer
	}

	protected def IContentProvider createHierarchyContentProvider() {
		new HierarchyTreeContentProvider(this)
	}

	protected def IBaseLabelProvider createHierarchyLabelProvider()

	protected def TableViewer createLocationViewer(Composite parent) {
		val locationViewer = new TableViewer(parent)
		locationViewer.contentProvider = new ArrayContentProvider
		locationViewer.labelProvider = createLocationLabelProvider

		val layout = new TableLayout
		locationViewer.table.layout = layout
		locationViewer.table.headerVisible = true
		locationColumnDescriptions.indexed.forEach [
			layout.addColumnData(value.value)
			locationViewer.table.createColumn(value, key)
		]
		return locationViewer
	}

	protected def Pair<String, ColumnLayoutData>[] getLocationColumnDescriptions() {
		#[
			'Line' -> new ColumnWeightData(60),
			'Call' -> new ColumnWeightData(300)
		]
	}

	protected def void createColumn(
		Table table,
		Pair<String, ColumnLayoutData> columnDescription,
		int index
	) {
		val column = new TableColumn(table, SWT.NONE, index)
		column.resizable = columnDescription.value.resizable
		column.text = columnDescription.key
	}

	protected def IBaseLabelProvider createLocationLabelProvider()

	override setFocus() {
		callHierarchyViewer.control.setFocus
	}

	override selectionChanged(SelectionChangedEvent event) {
		if (event.selectionProvider === callHierarchyViewer) {
			val callHierarchyNode = event.selection.selectedNode
			onCallHierarchyNodeChanged(callHierarchyNode)
		}
	}

	protected def onCallHierarchyNodeChanged(IHierarchyNode node) {
		locationViewer.input = node?.references ?: emptyList
		navigationService.open(node)
		setFocus
	}

}
