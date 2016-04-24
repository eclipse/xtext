/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.jface.viewers.AbstractTreeViewer
import org.eclipse.jface.viewers.ITreeContentProvider
import org.eclipse.jface.viewers.Viewer
import org.eclipse.ui.part.ViewPart
import org.eclipse.ui.progress.DeferredTreeContentManager
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@FinalFieldsConstructor
class HierarchyTreeContentProvider implements ITreeContentProvider {

	static val Object[] EMPTY_ARRAY = #[]

	val ViewPart viewPart

	DeferredTreeContentManager deferredTreeContentManager

	override getChildren(Object parentElement) {
		val children = deferredTreeContentManager.getChildren(parentElement)
		return children ?: EMPTY_ARRAY
	}

	override getElements(Object inputElement) {
		if (inputElement instanceof IHierarchyRoot) {
			return inputElement.roots.filterNull
		}
		return EMPTY_ARRAY
	}

	override getParent(Object element) {
		if (element instanceof IHierarchyNode)
			element.parent
	}

	override hasChildren(Object element) {
		return deferredTreeContentManager.mayHaveChildren(element)
	}

	override dispose() {
	}

	override inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		if (viewer instanceof AbstractTreeViewer) {
			deferredTreeContentManager = new DeferredTreeContentManager(viewer, viewPart.site)
		}
	}

}
