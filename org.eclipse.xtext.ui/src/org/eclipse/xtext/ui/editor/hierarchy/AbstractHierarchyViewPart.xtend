/*******************************************************************************
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.hierarchy

import org.eclipse.core.runtime.IProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.jface.viewers.ISelection
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.ui.part.ViewPart
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.ide.editor.hierarchy.DefaultHierarchyRoot
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyBuilder
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyNode
import org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.10
 */
@Accessors(PUBLIC_SETTER, PROTECTED_GETTER)
abstract class AbstractHierarchyViewPart extends ViewPart {

	IHierarchyBuilder builder
	URI rootURI

	def void refresh(IProgressMonitor monitor) {
		root = createRoot(monitor)
	}

	protected def IHierarchyRoot createRoot(IProgressMonitor monitor) {
		if (builder === null || rootURI === null)
			return IHierarchyRoot.EMPTY

		val roots = builder.buildRoots(rootURI, monitor)
		if (roots.empty)
			return org.eclipse.xtext.ide.editor.hierarchy.IHierarchyRoot.EMPTY

		val root = new DefaultHierarchyRoot
		root.roots += roots
		return root
	}

	protected def void setRoot(IHierarchyRoot root)

	protected def IHierarchyNode getSelectedNode(ISelection selection) {
		switch selection {
			IStructuredSelection case selection.size == 1: {
				val selectedElement = selection.firstElement
				if (selectedElement instanceof IHierarchyNode)
					return selectedElement
			}
		}
		return null
	}
	
	protected def <T extends IHierarchyBuilder> T getBuilder(Class<T> clazz) {
		if (clazz.isInstance(builder))
			return builder as T
			
		if (builder instanceof DeferredHierarchyBuilder) {
			val wrappedBuilder = builder.hierarchyBuilder
			if (clazz.isInstance(wrappedBuilder))
				return wrappedBuilder as T
		}
	}

}
