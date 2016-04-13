/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import com.google.inject.Inject
import org.eclipse.jface.viewers.IBaseLabelProvider
import org.eclipse.jface.viewers.IContentProvider
import org.eclipse.jface.viewers.ISelectionChangedListener
import org.eclipse.jface.viewers.SelectionChangedEvent
import org.eclipse.jface.viewers.TableViewer
import org.eclipse.jface.viewers.TreeViewer
import org.eclipse.swt.SWT
import org.eclipse.swt.custom.SashForm
import org.eclipse.swt.layout.GridData
import org.eclipse.swt.widgets.Composite
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyNode
import org.eclipse.xtext.ide.editor.hierarchy.HierarchyRoot
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

	override void setRoot(HierarchyRoot root) {
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
		val locationViewer = new LocationTableViewer(parent)
		locationViewer.labelProvider = createLocationLabelProvider
		return locationViewer
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

	protected def onCallHierarchyNodeChanged(HierarchyNode node) {
		locationViewer.input = node?.locations ?: emptyList
		navigationService.open(node)
		setFocus
	}

}
